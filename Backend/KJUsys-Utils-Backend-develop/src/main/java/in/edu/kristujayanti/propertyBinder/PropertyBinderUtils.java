package in.edu.kristujayanti.propertyBinder;

import in.edu.kristujayanti.propertyBinder.EduServ.DocumentCollectionKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EduServ.EduServKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EduServ.IdCardKeysPBinders;
import in.edu.kristujayanti.propertyBinder.Eform.Applicant.ApplicantFormsKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Eform.Applicant.AdmissionDashboardPBinder;
import in.edu.kristujayanti.propertyBinder.Eform.EformCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.AddNewBudgetKeysPBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.EventBudgetActualKeyBinder;
import in.edu.kristujayanti.propertyBinder.EventBudget.IncomeKeysPBinder;

import in.edu.kristujayanti.propertyBinder.Examination.ExaminationKeysPBinder;

import in.edu.kristujayanti.propertyBinder.FeeModule.FeeModuleKeysPBinder;
import in.edu.kristujayanti.propertyBinder.FeeModule.TallyConfigurationKeysPBinder;
import in.edu.kristujayanti.propertyBinder.GlobalRelations.GlobalRelationsKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Gym.GymKeysPBinder;
import in.edu.kristujayanti.propertyBinder.HR.*;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexeBookingKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexePaymentKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJAnnexe.AnnexeRoomKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryBookKeysPBInder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCheckInAndOutKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.PeriodicalsKeyPBinder;
import in.edu.kristujayanti.propertyBinder.QueueManager.QueueManagerKeysPBinder;
import in.edu.kristujayanti.propertyBinder.RazorpayPayment.RazorpayKeysPBinder;
import in.edu.kristujayanti.propertyBinder.ReportOrchestrator.ReportOrchestratorKeysPBinder;
import in.edu.kristujayanti.propertyBinder.ResearchScholar.ResearchKeysPBinder;
import in.edu.kristujayanti.propertyBinder.SIM.InterviewKeysPBinder;
import in.edu.kristujayanti.propertyBinder.SlotDesk.SlotDeskKeysPBinder;
import in.edu.kristujayanti.propertyBinder.WorkDiary.WorkDiaryKeysPBinder;
import in.edu.kristujayanti.propertyBinder.WorkflowManagement.WorkflowKeysPBInder;
import in.edu.kristujayanti.propertyBinder.academics.*;
import in.edu.kristujayanti.propertyBinder.arena.*;
import in.edu.kristujayanti.propertyBinder.core.*;
import in.edu.kristujayanti.propertyBinder.payment.PaymentCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.payment.ReceiptCommonKeysPBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to fetch display names by property names across various property binder enums.
 */
public class PropertyBinderUtils {

    /**
     * Retrieves the display name associated with the given property name across all property binder enums.
     *
     * @param propertyName The property name for which the display name is requested.
     * @return The display name corresponding to the property name, or null if not found.
     */
    public static String getDisplayNameByPropertyName(String propertyName) {
        List<Class<? extends KJUSYSPropertyBinder>> binderClasses = getAllPropertyBinderClasses();

        // Iterate through each property binder enum class
        for (Class<? extends KJUSYSPropertyBinder> binderClass : binderClasses) {
            KJUSYSPropertyBinder[] binders = binderClass.getEnumConstants();
            if (binders != null) {
                // Iterate through each enum constant within the binder
                for (KJUSYSPropertyBinder binder : binders) {
                    // Compare property names to find a match
                    if (binder.getPropertyName().equals(propertyName)) {
                        return binder.getDisplayName(); // Return display name if match found
                    }
                }
            }
        }

        return null; // Return null if no matching property name found
    }

    /**
     * Retrieves the property name associated with the given display name across all property binder enums.
     *
     * @param displayName The display name for which the property name is requested.
     * @return The property name corresponding to the display name, or null if not found.
     */
    public static String getPropertyNameByDisplayName(String displayName) {
        // Get a list of all property binder enum classes
        List<Class<? extends KJUSYSPropertyBinder>> binderClasses = getAllPropertyBinderClasses();

        // Iterate through each property binder enum class
        for (Class<? extends KJUSYSPropertyBinder> binderClass : binderClasses) {
            // Get all enum constants for the current binder class
            KJUSYSPropertyBinder[] binders = binderClass.getEnumConstants();
            if (binders != null) {
                // Iterate through each enum constant within the binder
                for (KJUSYSPropertyBinder binder : binders) {
                    // Compare display names to find a match
                    if (binder.getDisplayName().equals(displayName)) {
                        // Return property name if match found
                        return binder.getPropertyName();
                    }
                }
            }
        }

        // Return null if no matching display name found
        return null;
    }


    /**
     * Retrieves all property binder enum classes that implement the KJUSYSPropertyBinder interface.
     *
     * @return A list of Class objects representing property binder enum classes.
     */
    private static List<Class<? extends KJUSYSPropertyBinder>> getAllPropertyBinderClasses() {
        // Return a list of all relevant property binder enum classes
        return List.of(
                AuthCommonKeysPBinder.class,
                KJUSYSCommonKeysPBinder.class,
                ApplicantFormsKeysPBinder.class,
                EformCommonKeysPBinder.class,
                ERPUserProfileKeysPBinder.class,
                OnBoardingKeysPBinder.class,
                PaySlipGenerationKeysPBinder.class,
                LibraryCheckInAndOutKeysPBinder.class,
                LibraryBookKeysPBInder.class,
                LibraryCommonKeysPBinder.class,
                // ExaminationKeysPBinder.class,

                QueueManagerKeysPBinder.class,

                MenuPBinder.class,
                FeeModuleKeysPBinder.class,
                AttendanceDataKeysPBinder.class,
                FeeModuleKeysPBinder.class,
                AcademicsCommonKeysPBinder.class,
                HRCommonKeysPBinder.class,

                EmailSenderCommonKeysPBinder.class,
                RazorpayKeysPBinder.class,

                WorkShiftKeysPBinder.class,

                CreateVenueKeysPBInder.class,
                FetchVenueKeysPBInder.class,
                BulkBookingKeysPBInder.class,
                UserBookingKeysPBInder.class,
                GetAllBookingsKeysPBInder.class,
                OthersBookingKeysPBInder.class,

                InterviewKeysPBinder.class,
                VenueUpdateKeysPBInder.class,
                StaffTimetableKeysPBinder.class,

                AnnexeBookingKeysPBinder.class,
                AnnexeRoomKeysPBinder.class,
                AnnexePaymentKeysPBinder.class,


                DocumentCollectionKeysPBinder.class,
                IncomeKeysPBinder.class,
                AddNewBudgetKeysPBinder.class,
                ERPStudentProfileKeysPBinder.class,
                AdmissionDashboardPBinder.class,


                GymKeysPBinder.class,
                WorkflowKeysPBInder.class,
                PaymentCommonKeysPBinder.class,
                ResearchKeysPBinder.class,

                WorkDiaryKeysPBinder.class,
                OrganizationKeysPBinder.class,

                ConsultancyDataKeysPBinder.class,

                IdCardKeysPBinders.class,
                ReceiptCommonKeysPBinder.class,
                
                ExaminationKeysPBinder.class,
                EduServKeysPBinder.class,
                PresetAndFilterKeysPBinder.class,
                ReportOrchestratorKeysPBinder.class,

                GlobalRelationsKeysPBinder.class,
                PhdAcademicsKeyPBinder.class,
                EventBudgetActualKeyBinder.class,
                CourseKeysPBInder.class,
                MatrixKeysPBInder.class,
                BloomsLevelKeysPBInder.class,
                ProgrammeOutcomeKeysPBInder.class,
                BlowUpKeysPBinder.class,
                PeriodicalsKeyPBinder.class,
                SlotDeskKeysPBinder.class,
                TallyConfigurationKeysPBinder.class,
                RoomMasterKeysPBinder.class
        );
    }

    /**
     * Retrieves a list of property names for a given property binder enum.
     *
     * @param propertyBinder The property binder enum.
     * @return A list of property names.
     */
    public static List<String> getPropertyNames(Class<? extends KJUSYSPropertyBinder> propertyBinder) {
        List<String> propertyNames = new ArrayList<>();
        KJUSYSPropertyBinder[] keys = propertyBinder.getEnumConstants();
        if (keys != null) {
            for (KJUSYSPropertyBinder key : keys) {
                propertyNames.add(key.getPropertyName());
            }
        }
        return propertyNames;
    }
}