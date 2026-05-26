package in.edu.kristujayanti.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import java.util.*;

import static in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder.OID;

public class ExcelDownloadUtil {

    private final MongoDatabase mongoDatabase;

    public ExcelDownloadUtil(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public Workbook createExcelWorkbook(List<String> fields, String collectionName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(collectionName != null ? collectionName : "Sheet1");

        // Add "_id" to fields if collection name is specified
        if (collectionName != null && !collectionName.isEmpty() && !fields.contains(OID.getPropertyName())) {
            fields.add(0, OID.getPropertyName());
        }

        // Create header row with provided fields
        addHeaderRow(sheet, fields);

        // Fill in rows with values if collection name is provided
        if (collectionName != null && !collectionName.isEmpty()) {
            fillRowsWithValues(sheet, collectionName, fields);
        }

        return workbook;
    }

    public static Workbook createExcelWorkbook(List<String> fields) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        // Create header row with provided fields
        addHeaderRow(sheet, fields);

        return workbook;
    }


//    public Workbook createExcelWorkbookWithIndependentHeadersFirst(
//            List<Document> headerStructure,
//            List<Document> data,
//            List<String> independentHeaders) {
//
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Sheet1");
//
//        Map<String, Integer> columnMap = new HashMap<>();
//        int columnIndex = 0;
//
//        // Create main and sub-header rows
//        Row mainHeaderRow = sheet.createRow(0);
//        Row subHeaderRow = sheet.createRow(1);
//
//        // Add independent headers first
//        for (String independentHeader : independentHeaders) {
//            mainHeaderRow.createCell(columnIndex).setCellValue("");
//            String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(independentHeader);
//            subHeaderRow.createCell(columnIndex).setCellValue(displayName != null ? displayName : independentHeader);
//            columnMap.put(independentHeader, columnIndex);
//            columnIndex++;
//        }
//
//        // Add hierarchical headers with nested support
//        for (Document section : headerStructure) {
//            for (Map.Entry<String, Object> entry : section.entrySet()) {
//                String mainHeader = entry.getKey();
//                if (entry.getValue() instanceof List) {
//                    List<String> subHeaders = (List<String>) entry.getValue();
//
//                    // Merge cells for the main header if there are multiple sub-headers
//                    if (subHeaders.size() > 1) {
//                        sheet.addMergedRegion(new CellRangeAddress(0, 0, columnIndex, columnIndex + subHeaders.size() - 1));
//                    }
//                    mainHeaderRow.createCell(columnIndex).setCellValue(mainHeader);
//
//                    // Add sub-headers
//                    for (String subHeader : subHeaders) {
//                        String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(subHeader);
//                        subHeaderRow.createCell(columnIndex).setCellValue(displayName != null ? displayName : subHeader);
//                        columnMap.put(mainHeader + "." + subHeader, columnIndex);
//                        columnIndex++;
//                    }
//                }
//            }
//        }
//        // Fill in data rows with nested support
//        if (data != null && !data.isEmpty()) {
//            int rowNum = 2;
//            for (Document record : data) {
//                Row dataRow = sheet.createRow(rowNum++);
//                for (String key : columnMap.keySet()) {
//                    if (independentHeaders.contains(key)) {  // Add this check
//                        Cell cell = dataRow.createCell(columnMap.get(key));
//                        Object value = record.get(key);
//                        setCellValue(cell, value, key);
//                    }else{
//                        Cell cell = dataRow.createCell(columnMap.get(key));
//                        Object value = extractNestedValue(record, key);
//                        setCellValue(cell, value, key);
//                    }
//
//                }
//            }
//        }
//
//        // Auto-size columns
//        for (int i = 0; i < columnIndex; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        return workbook;
//    }

    public Workbook createExcelWorkbookWithIndependentHeadersFirst(
            List<Document> headerStructure,
            List<Document> data,
            List<String> independentHeaders) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Map<String, Integer> columnMap = new HashMap<>();
        int columnIndex = 0;

        // Create main and sub-header rows
        Row mainHeaderRow = sheet.createRow(0);
        Row subHeaderRow = sheet.createRow(1);

        // Add independent headers first (leave them blank in the main header row)
        for (String independentHeader : independentHeaders) {
            mainHeaderRow.createCell(columnIndex).setCellValue("");  // Leave blank in main header row
            String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(independentHeader);
            subHeaderRow.createCell(columnIndex).setCellValue(displayName != null ? displayName : independentHeader);
            columnMap.put(independentHeader, columnIndex);
            columnIndex++;
        }

        // Add hierarchical headers with nested support
        for (Document section : headerStructure) {
            for (Map.Entry<String, Object> entry : section.entrySet()) {
                String mainHeader = entry.getKey();
                if (entry.getValue() instanceof List) {
                    List<String> subHeaders = (List<String>) entry.getValue();

                    // Repeat the main header for each sub-header
                    for (String subHeader : subHeaders) {
                        mainHeaderRow.createCell(columnIndex).setCellValue(mainHeader);  // Set the main header
                        String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(subHeader);
                        subHeaderRow.createCell(columnIndex).setCellValue(displayName != null ? displayName : subHeader);
                        columnMap.put(mainHeader + "." + subHeader, columnIndex);
                        columnIndex++;
                    }
                }
            }
        }

        // Fill in data rows with nested support
        if (data != null && !data.isEmpty()) {
            int rowNum = 2;
            for (Document record : data) {
                Row dataRow = sheet.createRow(rowNum++);
                for (String key : columnMap.keySet()) {
                    Cell cell = dataRow.createCell(columnMap.get(key));
                    Object value = independentHeaders.contains(key) ? record.get(key) : extractNestedValue(record, key);
                    setCellValue(cell, value, key);
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < columnIndex; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }


    private Object extractNestedValue(Document document, String key) {
        if (key.contains(".")) {
            String[] parts = key.split("\\.");
            Document nestedDoc = (Document) document.get(parts[0]);
            return nestedDoc != null ? nestedDoc.get(parts[1]) : null;
        }
        return document.get(key);
    }

    private static void addHeaderRow(Sheet sheet, List<String> fields) {
        Row headerRow = sheet.createRow(0);
        int columnIndex = 0;
        Iterator var5 = fields.iterator();

        while(var5.hasNext()) {
            String propertyName = (String)var5.next();
            String label = PropertyBinderUtils.getDisplayNameByPropertyName(propertyName);
            headerRow.createCell(columnIndex++).setCellValue(label != null ? label : propertyName);
        }

    }

    private void fillRowsWithValues(Sheet sheet, String collectionName, List<String> fields) {
        MongoCollection<Document> collection = this.mongoDatabase.getCollection(collectionName);
        int rowNum = 1;

        Document projection = new Document();
        for (String field : fields) {
            projection.append(field, 1);
        }
        MongoCursor var6 = collection.find().projection(projection).iterator();

        while(var6.hasNext()) {
            Document document = (Document)var6.next();
            Row row = sheet.createRow(rowNum++);
            int columnIndex = 0;
            Iterator var10 = fields.iterator();

            while(var10.hasNext()) {
                String key = (String)var10.next();
                Object value;
                if (key.equals(OID.getPropertyName())) {
                    value = document.getObjectId("_id").toHexString();
                } else {
                    value = document.get(key);
                }

                Cell cell = row.createCell(columnIndex++);
                this.setCellValue(cell, value, key);
            }
        }

    }

    private void setCellValue(Cell cell, Object value, String key) {
        if (value instanceof Integer) {
            cell.setCellValue((double)(Integer)value);
        } else if (value instanceof Long) {
            if (key.endsWith("_Date")) {
                cell.setCellValue(DateUtils.convertMillisToDateString((Long)value));
            } else {
                cell.setCellValue((double)(Long)value);
            }
        } else if (value instanceof Double) {
            cell.setCellValue((Double)value);
        } else if (value instanceof String) {
            cell.setCellValue((String)value);
        } else {
            cell.setCellValue(value != null ? value.toString() : "");
        }

    }
    private static void setCellValues(Cell cell, Object value, String key) {
        if (value instanceof Integer) {
            cell.setCellValue((double)(Integer)value);
        } else if (value instanceof Long) {
            if (key.endsWith("_Date")) {
                cell.setCellValue(DateUtils.convertMillisToDateString((Long)value));
            } else {
                cell.setCellValue((double)(Long)value);
            }
        } else if (value instanceof Double) {
            cell.setCellValue((Double)value);
        } else if (value instanceof String) {
            cell.setCellValue((String)value);
        } else {
            cell.setCellValue(value != null ? value.toString() : "");
        }

    }

    public static Workbook createExcelWorkbook(List<String> fields, List<Document> documents) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create header row with provided fields
        addHeaderRow(sheet, fields);

        // Fill in rows with values from the provided list of documents
        fillRowsWithValues(sheet, documents, fields);

        return workbook;
    }

    public Workbook createExcelWorkbookWithoutObjectId(List<String> fields, String collectionName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(collectionName != null ? collectionName : "Sheet1");

        addHeaderRow(sheet, fields);
        if (collectionName != null && !collectionName.isEmpty()) {
            this.fillRowsWithValues(sheet, collectionName, fields);
        }

        return workbook;
    }

    private static void fillRowsWithValues(Sheet sheet, List<Document> documents, List<String> fields) {
        int rowNum = 1;

        for (Document document : documents) {
            Row row = sheet.createRow(rowNum++);
            int columnIndex = 0;

            for (String key : fields) {
                Object value = key.equals(OID.getPropertyName()) ? document.getObjectId("_id").toHexString() : document.get(key);
                Cell cell = row.createCell(columnIndex++);
                setCellValues(cell, value, key);
            }
        }
    }

    /**
     * Creates an Excel Workbook with the specified fields as columns, using the provided documents as data rows.
     * Columns whose field names are in shadedList will be shaded gray.
     *
     * @param fields      List of property names for columns.
     * @param documents   List of Documents representing row data.
     * @param shadedList  List of field names whose columns should be shaded gray.
     * @return            A Workbook containing the data and formatting.
     */
    public static Workbook createExcelWorkbook(List<String> fields, List<Document> documents, List<String> shadedList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Prepare shaded style
        CellStyle shadedStyle = workbook.createCellStyle();
        shadedStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        shadedStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Filter fields with non-empty display names
        List<String> fieldsWithDisplayNames = new ArrayList<>();
        List<String> displayNames = new ArrayList<>();
        for (String propertyName : fields) {
            String displayName = PropertyBinderUtils.getDisplayNameByPropertyName(propertyName);
            if (displayName != null && !displayName.trim().isEmpty()) {
                fieldsWithDisplayNames.add(propertyName);
                displayNames.add(displayName);
            }
        }

        // Header row
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < fieldsWithDisplayNames.size(); col++) {
            String propertyName = fieldsWithDisplayNames.get(col);
            String displayName = displayNames.get(col);
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(displayName);

            if (shadedList != null && shadedList.contains(propertyName)) {
                cell.setCellStyle(shadedStyle);
            }
        }

        // Data rows
        for (int rowNum = 0; rowNum < documents.size(); rowNum++) {
            Document doc = documents.get(rowNum);
            Row row = sheet.createRow(rowNum + 1);
            for (int col = 0; col < fieldsWithDisplayNames.size(); col++) {
                String propertyName = fieldsWithDisplayNames.get(col);
                Object value = doc.get(propertyName);
                Cell cell = row.createCell(col);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
                if (shadedList != null && shadedList.contains(propertyName)) {
                    cell.setCellStyle(shadedStyle);
                }
            }
        }

        return workbook;
    }


    /**
      Create Excel workbook from list of documents (data from lookup/aggregation)
     * This method works with ANY document structure and ANY fields
     *
     * @param fields List of field names to include in Excel (property names)
     * @param documents List of documents containing the data (from lookup/aggregation)
     * @return Workbook with specified fields as columns
     */
    public Workbook createExcelWorkbookDocument(List<String> fields, List<Document> documents) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create styles
        CellStyle headerStyle = createHeaderStyleForPacket(workbook);
        CellStyle dataStyle = createDataStyleForPacket(workbook);

        int rowNum = 0;

        // === HEADER ROW ===
        Row headerRow = sheet.createRow(rowNum++);
        int columnIndex = 0;

//        for (String propertyName : fields) {
//            String label = PropertyBinderUtils.getDisplayNameByPropertyName(propertyName);
//            Cell headerCell = headerRow.createCell(columnIndex++);
//            headerCell.setCellValue(label != null ? label : propertyName);
//            headerCell.setCellStyle(headerStyle);
//        }
        for(String propertyName : fields) {
            Cell headerCell = headerRow.createCell(columnIndex++);
            headerCell.setCellValue(propertyName);
            headerCell.setCellStyle(headerStyle);
        }
        // === DATA ROWS ===
        if (documents != null && ! documents.isEmpty()) {
            for (Document document : documents) {
                Row dataRow = sheet.createRow(rowNum++);
                columnIndex = 0;

                for (String fieldName : fields) {
                    Cell cell = dataRow.createCell(columnIndex++);

                    // Get value directly from document using the field name
                    Object value = document.get(fieldName);

                    // Set cell value using existing setCellValue method
                    setCellValue(cell, value, fieldName);
                    cell.setCellStyle(dataStyle);
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < fields.size(); i++) {
            sheet.autoSizeColumn(i);
            // Set minimum width
            if (sheet.getColumnWidth(i) < 3500) {
                sheet.setColumnWidth(i, 3500);
            }
        }

        return workbook;
    }

    /**
     * Helper method:  Create header style for generic Excel
     */
    private CellStyle createHeaderStyleForPacket(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        org.apache.poi.ss.usermodel. Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType. SOLID_FOREGROUND);
        style.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle. THIN);
        style.setBorderLeft(org.apache.poi. ss.usermodel.BorderStyle. THIN);
        style.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        style.setVerticalAlignment(org.apache.poi. ss.usermodel.VerticalAlignment.CENTER);
        return style;
    }

    /**
     * Helper method: Create data style for generic Excel
     */
    private CellStyle createDataStyleForPacket(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderTop(org.apache. poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderLeft(org.apache.poi.ss.usermodel. BorderStyle.THIN);
        style.setBorderRight(org. apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        return style;
    }
}