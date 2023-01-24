/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liewm
 */

package client;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Patient;
import entity.Record;
import adt.QueueInterface;
import adt.ArrayQueue;

class BadInputException extends Exception {

    String s;

    BadInputException(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }

}

public class PatientManager {

    private QueueInterface<Record> recordList = new ArrayQueue<>();
    private QueueInterface<Patient> patientList = new ArrayQueue<>();
    private int PIDcount = 1003;
    private int rIDcount = 113;
    private Scanner scan = new Scanner(System.in);

    public PatientManager() {
        patientList.enqueue(new Patient(1001, "Ah Leong", "010406-06-4332", "018-3466691", "Male"));
        patientList.enqueue(new Patient(1002, "Cheng Lok", "050721-04-2734", "014-3146596", "Male"));
        patientList.enqueue(new Patient(1003, "Xiu Ting", "980327-06-3062", "011-2373934", "Female"));
        recordList.enqueue(new Record(111, "Fever", 70, "27-6-2022"));
        recordList.enqueue(new Record(112, "Stomach Aches", 65, "21-7-2022"));
        recordList.enqueue(new Record(113, "Sore Throat", 70, "27-6-2022"));

    }

    public void addNewPatient() {
        PIDcount++;
        String phone = null;
        String name = null;
        String ic = null;
        String g = null;
        System.out.println("\n\n Add New Patient");

        System.out.println("ID :" + PIDcount);
       
        

        //patient name
        while (true) {
            try {
                System.out.println("Patient Name : ");
                name = scan.nextLine();

                for (int i = 0; i < name.length(); i++) {
                    if (!Character.isAlphabetic(name.toCharArray()[i])) {
                        throw new BadInputException("Name must be all alphabet");
                    }
                }
            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }

        // patient ic
        while (true) {
            try {
                System.out.println("Patient IC (XXXXXX-XX-XXXX): ");
                ic = scan.nextLine();

                if (ic.length() != 14) {
                    throw new BadInputException("IC must be 14 characters long !");
                }
                if (ic.charAt(6) != '-' && ic.charAt(9) != '-') {
                    throw new BadInputException("Please use this XXXXXX-XX-XXXX format !");
                }

                for (int i = 0; i < 6; i++) {
                    if (!Character.isDigit(ic.toCharArray()[i])) {
                        throw new BadInputException("Phone number must be all digit !!");
                    }
                }

                for (int i = 7; i < 9; i++) {
                    if (!Character.isDigit(ic.toCharArray()[i])) {
                        throw new BadInputException("Phone number must be all digit !!");
                    }
                }

                for (int i = 10; i < 14; i++) {
                    if (!Character.isDigit(ic.toCharArray()[i])) {
                        throw new BadInputException("Phone number must be all digit !!");
                    }
                }
            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }

        //phone number
        while (true) {

            try {
                System.out.println("Phone Number (XXX-XXXXXXX): ");
                phone = scan.nextLine();

                if (phone.length() != 11) {
                    throw new BadInputException("Phone number must be 11 characters long !");
                }
                if (phone.charAt(3) != '-') {
                    throw new BadInputException("Please use this XXX-XXXXXXX format");
                }
                for (int i = 0; i < 3; i++) {
                    if (!Character.isDigit(phone.toCharArray()[i])) {
                        throw new BadInputException("Phone number must be all digit !!");
                    }
                }
                for (int i = 4; i < 11; i++) {
                    if (!Character.isDigit(phone.toCharArray()[i])) {
                        throw new BadInputException("Phone number must be all digit !!");
                    }
                }

            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }

        // gender
        while (true) {
            try {
                System.out.println("Gender : ");
                g = scan.nextLine();
                for (int i = 0; i < g.length(); i++) {
                    if (!Character.isAlphabetic(g.toCharArray()[i])) {
                        throw new BadInputException("Name must be all alphabet");
                    }
                }

            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }
        
       
        
        patientList.enqueue(new Patient(PIDcount, name, ic, phone, g));
        
        
        
        
        
    }

    public void searchPatient() {
        System.out.println("\n\n Search Patient");
        System.out.println("Please Enter Patient ID :");
        int id = scan.nextInt();
        scan.nextLine();
        
        
        Patient patient = patientList.getEntry(new Patient(id));
        boolean check = patientList.contains(patient);

        if (check) {
            System.out.println("Patient Info : \n" + patient);
        } else {
            System.out.println("Patient Not Found !!");
        }

    }

    public void addRecordToPatient() {
        System.out.println("Enter record ID : ");
        int recordid = scan.nextInt();
        scan.nextLine();

        Record record = recordList.getEntry(new Record(recordid));
        System.out.println(record);
        if (record == null) {
            System.out.println("Record Not Exist !!");
        } else {
            System.out.println("Enter Patient ID : ");
            int patientid = scan.nextInt();
            scan.nextLine();

            Patient patient = patientList.getEntry(new Patient(patientid));
            System.out.println(patient);

            patient.addRecordToPatient(record);
        }
    }

    public void displayPatient() {

        for (int i = 0; i < patientList.getbackIndex(); i++) {
            System.out.println("--------");
            System.out.println("Patient ");
            System.out.println("--------");
            System.out.println(patientList.getEntry(i+1));
            System.out.println("--------");
            System.out.println("Reocrd");
            System.out.println("--------");
            System.out.println(patientList.getEntry(i+1).getAllRecord());
        }

    }

    public void deleteData() {
//        System.out.println("\n\n Search Patient");
//        System.out.println("Please Enter Patient ID :");
//        int id = scan.nextInt();
//        scan.nextLine();
//
//        for (int i = 1; i < patientList.getbackIndex(); i++) {
//            int patient = patientList.getEntry(i).getID();
//            if (patient == id) {
//                int position = i;
//
//                patientList.dequeue();
//                System.out.println("Customer has been successfully remove");
//                break;
//            } else {
//                System.out.println("Customer not found in the list!");
//            }
//        }

        patientList.dequeue();
        System.out.println("Customer has been successfully remove");

    }

    public void replacepdata() {
        System.out.println("\n\n Search Patient");
        System.out.println("Please Enter Patient ID :");
        int id = scan.nextInt();
        scan.nextLine();
        Patient patient = patientList.getEntry(new Patient(id));

        System.out.println(" 1. Name ");
        System.out.println(" 2. IC ");
        System.out.println(" 3. Phone No ");
        System.out.println(" 4. Gender ");
        System.out.println("Your Selection : ");

        int choose = scan.nextInt();
        scan.nextLine();

        if (patient != null) {
            if (choose == 1) {
                System.out.println("Name : ");
                String name = scan.nextLine();
                scan.nextLine();
                patient.setPatientName(name);
            } else if (choose == 2) {
                System.out.println("IC : ");
                String ic = scan.nextLine();
                scan.nextLine();
                patient.setPatientIC(ic);
            } else if (choose == 3) {
                System.out.println("Phone No : ");
                String ph = scan.nextLine();
                scan.nextLine();
                patient.setPhoneNo(ph);
            } else if (choose == 4) {
                System.out.println("Gender");
                String gen = scan.nextLine();
                scan.nextLine();
                patient.setGender(gen);
            } else {
                System.out.println("invalid input !!");
            }
        } else {
            System.out.println("Patient Not Found !!");
        }

    }

    public void addNewRecord() {
        rIDcount++;

        String mc = null;
        int tp;
        String pd = null;

        System.out.println("\n\n Add New Record");

        System.out.println("ID :" + rIDcount);

        //case
        while (true) {
            try {
                System.out.println("Case : ");
                mc = scan.nextLine();
                for (int i = 0; i < mc.length(); i++) {
                    if (!Character.isAlphabetic(mc.toCharArray()[i])) {
                        throw new BadInputException("Name must be all alphabet");
                    }
                }

            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }

        System.out.println("Price : ");
        tp = scan.nextInt();
        scan.nextLine();

        //date
        while (true) {
            try {
                System.out.println("Payment Date (XX-XX-XXXX): ");
                pd = scan.nextLine();
                for (int i = 0; i < 2; i++) {
                    if (!Character.isDigit(pd.toCharArray()[i])) {
                        throw new BadInputException("Date must be all digit !!");
                    }
                }

                for (int i = 3; i < 5; i++) {
                    if (!Character.isDigit(pd.toCharArray()[i])) {
                        throw new BadInputException("Date number must be all digit !!");
                    }
                }

                for (int i = 6; i < 10; i++) {
                    if (!Character.isDigit(pd.toCharArray()[i])) {
                        throw new BadInputException("Date number must be all digit !!");
                    }
                }

                if (pd.charAt(2) != '-' && pd.charAt(5) != '-') {
                    throw new BadInputException("Please use this XX-XX-XXXX format !");
                }

            } catch (BadInputException x) {
                System.out.println(x.toString());
                continue;
            }
            break;
        }

        recordList.enqueue(new Record(rIDcount, mc, tp, pd));

    }

    public void writeToFile() {
        String patientFile = "patientFile.txt";
        String recordFile = "recordFile";
        try {
            PrintWriter pwriter = new PrintWriter(new FileWriter(patientFile, false));
            PrintWriter rwriter = new PrintWriter(new FileWriter(recordFile,false));
            
            
            pwriter.println(patientList);//store in ram first
            rwriter.println(recordList);
            

            //writer.println(patientData);//store in ram first
            pwriter.close();//flushes the data to the file 
            rwriter.close();
            System.out.println("Done");
        } catch (IOException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
