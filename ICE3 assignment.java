import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Name: Nadir Mahmood
 * Program: VaccinationRecordManager
 * Date: 2023.11.25
 * Description: A Java program for tracking vaccination records against COVID-19 and showing data that has been recorded.
 */

class VaccinationRecord {
    private int recordId;
    private String vaccineName;
    private double unitPrice;
    private int availableDoses;
    private Date expiryDate;

    /**
     * Function default that has useful default values.
     */
    public VaccinationRecord() {
        this.recordId = 0;
        this.vaccineName = "Unknown";
        this.unitPrice = 0.0;
        this.availableDoses = 0;
        this.expiryDate = new Date();
    }

    /**
     * Parameterized constructor.
     */
    public VaccinationRecord(int recordId, String vaccineName, double unitPrice, int availableDoses, Date expiryDate) {
        this.recordId = recordId;
        this.vaccineName = vaccineName;
        this.unitPrice = unitPrice;
        this.availableDoses = availableDoses;
        this.expiryDate = expiryDate;
    }

    // Getter and setter methods for each data member...

    /**
     * Display function with a boolean parameter to control the format.
     */
    public void showDetails(boolean tableFormat) {
        if (tableFormat) {
            // Display in table format
            System.out.printf("%-4d | %-15s | $%-8.2f | %-4d | %s%n",
                    recordId, vaccineName, unitPrice, availableDoses, new SimpleDateFormat("MM/dd/yyyy").format(expiryDate));
        } else {
            //  non-linear format
            System.out.println("Record ID: " + recordId);
            System.out.println("Vaccine Name: " + vaccineName);
            System.out.println("Unit Price: $" + unitPrice);
            System.out.println("Available Doses: " + availableDoses);
            System.out.println("Expiry Date: " + new SimpleDateFormat("MM/dd/yyyy").format(expiryDate));
        }
    }
}

public class VaccinationAppManager {
    public static void main(String[] args) {
        // an empty VaccinationRecord using the default constructor
        VaccinationRecord emptyRecord = new VaccinationRecord();

        // values of the empty VaccinationRecord in a non-linear format
        System.out.println("Empty Vaccination Record Details:");
        emptyRecord.showDetails(false);

        //values using setters for the empty VaccinationRecord
        emptyRecord.setRecordId(1);
        emptyRecord.setVaccineName("COVID Vaccine");
        emptyRecord.setUnitPrice(29.99);
        emptyRecord.setAvailableDoses(1000);

        // Displaying the values of the VaccinationRecord in a non-linear format
        System.out.println("\nUpdated Vaccination Record Details:");
        emptyRecord.showDetails(false);

        // Creating two more vaccination records using the parameterized constructor
        VaccinationRecord record1 = new VaccinationRecord(2, "Flu Vaccine", 19.99, 500, new Date());
        VaccinationRecord record2 = new VaccinationRecord(3, "Pneumonia Vaccine", 39.99, 200, new Date());

        // Creating an array to save all the vaccination records
        VaccinationRecord[] vaccinationRecords = {emptyRecord, record1, record2};

        // Displaying the contents of the vaccination records in a table format
        System.out.println("\nVaccination Record Inventory:");
        System.out.println("ID  | Vaccine Name    | Unit Price | Doses | Expiry Date");
        System.out.println("----|-----------------|------------|-------|--------------");

        for (VaccinationRecord record : vaccinationRecords) {
            record.showDetails(true);
        }
    }
}

}
