package in.edu.kristujayanti.util.export;

import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Utility class for creating and managing Excel (XLSX) output.
 * Supports static one-shot exports, including from BSON Document lists.
 */
public class ExcelExporter {

    /**
     * Write header row to a sheet.
     */
    public static void writeHeader(Row row, List<String> headers, CellStyle headerStyle) {
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers.get(i));
            if (headerStyle != null) cell.setCellStyle(headerStyle);
        }
    }

    /**
     * Write a data row to a sheet.
     */
    public static void writeRow(Row row, List<String> values, CellStyle dataStyle) {
        for (int i = 0; i < values.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(values.get(i));
            if (dataStyle != null) cell.setCellStyle(dataStyle);
        }
    }

    /**
     * Create Excel (.xlsx) file from {@code List<Document>}, filter out "_File" and "_id",
     * map headers with PropertyBinderUtils, and return as bytes.
     *
     * @param documents List of BSON Documents
     * @return Excel file as bytes
     */
    public static byte[] createExcelBytesFromDocuments(List<Document> documents) throws IOException {
        if (documents == null || documents.isEmpty()) return new byte[0];

        // 1. Collect union of all keys (preserve first-seen order)
        Set<String> rawHeaders = new LinkedHashSet<>();
        for (Document doc : documents) {
            rawHeaders.addAll(doc.keySet());
        }
        // 2. Exclude unwanted fields
        List<String> filteredHeaders = rawHeaders.stream()
                .filter(header -> !header.contains("_File") && !"_id".equals(header))
                .toList();

        // 3. Map to display names (fallback to property name)
        List<String> displayHeaders = filteredHeaders.stream()
                .map(header -> {
                    try {
                        String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(header);
                        return displayName != null ? displayName : header;
                    } catch (Exception e) {
                        return header;
                    }
                }).toList();

        // 4. Prepare rows (use the full header set, default to "" for missing keys)
        List<List<String>> rows = documents.stream()
                .map(doc -> filteredHeaders.stream()
                        .map(key -> {
                            Object value = doc.get(key);
                            return (value == null || value.toString().equals("null")) ? "" : value.toString();
                        })
                        .toList())
                .toList();

        // 5. Generate Excel in-memory
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header style (bold)
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Write header row
            Row headerRow = sheet.createRow(0);
            writeHeader(headerRow, displayHeaders, headerStyle);

            // Write data rows
            for (int r = 0; r < rows.size(); r++) {
                Row row = sheet.createRow(r + 1);
                writeRow(row, rows.get(r), null);
            }

            // Auto-size columns for neatness
            for (int i = 0; i < displayHeaders.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }

    /**
     * Static utility variant for direct one-shot Excel creation from headers+rows.
     */
    public static byte[] createExcelBytes(List<String> headers, List<List<String>> rows) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Header style
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Header row
            Row headerRow = sheet.createRow(0);
            writeHeader(headerRow, headers, headerStyle);

            // Data rows
            for (int r = 0; r < rows.size(); r++) {
                Row row = sheet.createRow(r + 1);
                writeRow(row, rows.get(r), null);
            }

            // Auto-size
            for (int i = 0; i < headers.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }

    /**
     * Creates an Excel XLSX export (as bytes) from a list of documents,
     * using all unique keys as columns, and shading (headers and values) for columns in columnsToShade.
     *
     * @param documents      List of Documents representing row data.
     * @param columnsToShade List of property names whose columns should be shaded gray.
     * @return byte[] of XLSX file contents with shading applied to specified columns.
     * @throws IOException If writing fails.
     */
    public static byte[] createExcelBytesWithShadedHeaders(List<Document> documents, List<String> columnsToShade) throws IOException {
        if (documents == null || documents.isEmpty()) return new byte[0];

        // 1. Collect union of all keys (preserve first-seen order)
        Set<String> allFields = new LinkedHashSet<>();
        for (Document doc : documents) {
            allFields.addAll(doc.keySet());
        }
        // Exclude unwanted fields
        List<String> usedFields = allFields.stream()
                .filter(header -> !header.contains("_File") && !"_id".equals(header))
                .toList();

        // 2. Map to display names (fallback to property name)
        List<String> displayNames = usedFields.stream()
                .map(header -> {
                    try {
                        String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(header);
                        return displayName != null && !displayName.isEmpty() ? displayName : header;
                    } catch (Exception e) {
                        return header;
                    }
                })
                .toList();

        // 3. Prepare data rows
        List<List<String>> rows = documents.stream()
                .map(doc -> usedFields.stream()
                        .map(fld -> Optional.ofNullable(doc.get(fld)).map(Object::toString).orElse(""))
                        .toList())
                .toList();

        // 4. Create workbook and sheet, with styles
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Style: Bold for header
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);

            CellStyle boldHeader = workbook.createCellStyle();
            boldHeader.setFont(boldFont);

            // Style: Shaded header
            CellStyle shadedHeader = workbook.createCellStyle();
            shadedHeader.setFont(boldFont);
            shadedHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            shadedHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Style: Shaded cell (not bold)
            CellStyle shadedCell = workbook.createCellStyle();
            shadedCell.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            shadedCell.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // 5. Write headers
            Row headerRow = sheet.createRow(0);
            for (int c = 0; c < usedFields.size(); c++) {
                Cell cell = headerRow.createCell(c);
                cell.setCellValue(displayNames.get(c));
                if (columnsToShade != null && columnsToShade.contains(usedFields.get(c))) {
                    cell.setCellStyle(shadedHeader);
                } else {
                    cell.setCellStyle(boldHeader);
                }
            }

            // 6. Write data
            for (int r = 0; r < rows.size(); r++) {
                Row row = sheet.createRow(r + 1);
                List<String> rowData = rows.get(r);
                for (int c = 0; c < rowData.size(); c++) {
                    Cell cell = row.createCell(c);
                    cell.setCellValue(rowData.get(c));
                    if (columnsToShade != null && columnsToShade.contains(usedFields.get(c))) {
                        cell.setCellStyle(shadedCell);
                    }
                }
            }

            // 7. Auto-size columns
            for (int c = 0; c < usedFields.size(); c++) {
                sheet.autoSizeColumn(c);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }
}