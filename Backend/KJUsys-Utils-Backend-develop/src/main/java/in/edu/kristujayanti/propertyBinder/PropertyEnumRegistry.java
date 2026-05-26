package in.edu.kristujayanti.propertyBinder;


import in.edu.kristujayanti.propertyBinder.FeeModule.TallyConfigurationKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.PeriodicalsKeyPBinder;
import in.edu.kristujayanti.propertyBinder.SlotDesk.SlotDeskKeysPBinder;
import in.edu.kristujayanti.propertyBinder.academics.StudentGroupKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EduServ.DocumentCollectionKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EduServ.EduServKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EduServ.IdCardKeysPBinders;
import in.edu.kristujayanti.propertyBinder.Eform.Applicant.AdmissionDashboardPBinder;
import in.edu.kristujayanti.propertyBinder.Eform.Applicant.ApplicantFormsKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Eform.EformCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.AddNewBudgetKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.EventBudgetActualKeyBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.IncomeKeysPBinder;

import in.edu.kristujayanti.propertyBinder.Examination.ExaminationKeysPBinder;
import in.edu.kristujayanti.propertyBinder.FeeModule.FeeModuleKeysPBinder;
import in.edu.kristujayanti.propertyBinder.GlobalRelations.GlobalRelationsKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Gym.GymKeysPBinder;
import in.edu.kristujayanti.propertyBinder.HR.*;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexeBookingKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexePaymentKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexeRoomKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryBookKeysPBInder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCheckInAndOutKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCommonKeysPBinder;

import in.edu.kristujayanti.propertyBinder.QueueManager.QueueManagerKeysPBinder;

import in.edu.kristujayanti.propertyBinder.RazorpayPayment.RazorpayKeysPBinder;
import in.edu.kristujayanti.propertyBinder.ReportOrchestrator.ReportOrchestratorKeysPBinder;
import in.edu.kristujayanti.propertyBinder.ResearchScholar.ResearchKeysPBinder;
import in.edu.kristujayanti.propertyBinder.SIM.InterviewKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Ticketing.TicketingKeysPBinder;
import in.edu.kristujayanti.propertyBinder.WorkDiary.WorkDiaryKeysPBinder;
import in.edu.kristujayanti.propertyBinder.WorkflowManagement.WorkflowKeysPBInder;
import in.edu.kristujayanti.propertyBinder.academics.*;
import in.edu.kristujayanti.propertyBinder.academics.AcademicsCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.academics.PhdAcademicsKeyPBinder;
import in.edu.kristujayanti.propertyBinder.academics.RoomMasterKeysPBinder;
import in.edu.kristujayanti.propertyBinder.arena.*;
import in.edu.kristujayanti.propertyBinder.core.*;
import in.edu.kristujayanti.propertyBinder.payment.PaymentCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.payment.ReceiptCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.portal.PortalCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.purchaseOrder.PurchaseOrderCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.timetable.LeaveTypeKeysPBinder;
import in.edu.kristujayanti.propertyBinder.timetable.StudentAttendanceKeysPBinder;
import in.edu.kristujayanti.propertyBinder.timetable.TimeTableKeysPBinder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PropertyEnumRegistry {
    private static final Map<String, Class> KJUSYS_ENUM_REGISTRY = new ConcurrentHashMap();

    public static Class getEnumClass(String key) {
        if (KJUSYS_ENUM_REGISTRY.containsKey(key)) {
            return KJUSYS_ENUM_REGISTRY.get(key);
        } else {
            throw new IllegalStateException("Registry key " + key + " is invalid");
        }
    }

    static {
        KJUSYS_ENUM_REGISTRY.put("EformCommon", EformCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("AuthCommon", AuthCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ApplicantForms", ApplicantFormsKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("KJUSYSCommon", KJUSYSCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPUserProfile", ERPUserProfileKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EmployeeOnBoarding", OnBoardingKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("RazorpayKeys", RazorpayKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EmployeePaySlip", PaySlipGenerationKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryCheckInAndOut", LibraryCheckInAndOutKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryCommon", LibraryCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryBook", LibraryBookKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPStaffUserProfile", LibraryCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPStudentUserProfile", LibraryCommonKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("QueueManager", QueueManagerKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("Menu", MenuPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("FeeModule", FeeModuleKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("Ticketing", TicketingKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("AcademicsCommon", AcademicsCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("HRCommon", HRCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EmailSenderCommon", EmailSenderCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EventBudget", AddNewBudgetKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EventIncome", IncomeKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("AttendanceData", AttendanceDataKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("BulkBooking", BulkBookingKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("VenueCreation", CreateVenueKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("FetchVenue", FetchVenueKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("Report", GetAllBookingsKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("OthersBooking", OthersBookingKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("UserBooking", UserBookingKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("WorkShift", WorkShiftKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("InterviewKeys", InterviewKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("PrincipalViewKeys", PrincipalViewKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("StaffRoleKeysPBinder", StaffRoleKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LeaveApplication", LeaveApplicationsKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("PurchaseOrder", PurchaseOrderCommonKeysPBinder.class);


        KJUSYS_ENUM_REGISTRY.put("LeaveApplications", LeaveApplicationsKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("AwardsDataKeys", AwardsDataKeyPBinders.class);
        KJUSYS_ENUM_REGISTRY.put("UpdateVenue", VenueUpdateKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("StaffTimeTable", StaffTimetableKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("KJAnnexeBooking", AnnexeBookingKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("KJAnnexeRoom", AnnexeRoomKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("KJAnnexePayment", AnnexePaymentKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EduServ", EduServKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("DocumentCollection", DocumentCollectionKeysPBinder.class);


        KJUSYS_ENUM_REGISTRY.put("ErpStudentProfile", ERPStudentProfileKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("Gym", GymKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("AdmissionDashboardKeys", AdmissionDashboardPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("WorkflowManagement", WorkflowKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("PaymentCommonKeys", PaymentCommonKeysPBinder.class);


        //id card
        KJUSYS_ENUM_REGISTRY.put("IdCard", IdCardKeysPBinders.class);


        KJUSYS_ENUM_REGISTRY.put("ConsultancyAndProject", ConsultancyDataKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ReceiptCommon", ReceiptCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ResearchKeys", ResearchKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("WorkDiary", WorkDiaryKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("Examination", ExaminationKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("Organization", OrganizationKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("Portal", PortalCommonKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("GlobalRelation", GlobalRelationsKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("PresetAndFilter", PresetAndFilterKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("ReportOrchestrator", ReportOrchestratorKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("PhdAcademics", PhdAcademicsKeyPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("EventBudgetActual", EventBudgetActualKeyBinder.class);
        KJUSYS_ENUM_REGISTRY.put("MentorBook", MentorBookKeyBinder.class);


        //Time Table - Schedule Manager
        KJUSYS_ENUM_REGISTRY.put("RoomMaster", RoomMasterKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("StudentGroup", StudentGroupKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("TimeTable", TimeTableKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("StudentAttendance", StudentAttendanceKeysPBinder.class);


        KJUSYS_ENUM_REGISTRY.put("Course", CourseKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("Matrix", MatrixKeysPBInder.class);

        KJUSYS_ENUM_REGISTRY.put("ProgrammeOutcome", ProgrammeOutcomeKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("BloomsLevel", BloomsLevelKeysPBInder.class);
        KJUSYS_ENUM_REGISTRY.put("BlowUp", BlowUpKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LeaveType", LeaveTypeKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("Periodicals", PeriodicalsKeyPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("Periodical", PeriodicalsKeyPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("SlotDesk", SlotDeskKeysPBinder.class);

        KJUSYS_ENUM_REGISTRY.put("TallyConfiguration", TallyConfigurationKeysPBinder.class);


    }
}