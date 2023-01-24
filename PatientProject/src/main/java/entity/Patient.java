/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liewm
 */
package entity;

import adt.QueueInterface;
import adt.ArrayQueue;

public class Patient implements java.io.Serializable{
    
    //class attributes
    private int patientID;
    private String patientName;
    private String patientIC;
    private String phoneNo;
    private String gender;
    //1 patient has MANY records. So records must be put in list ADT
    private QueueInterface<Record> patientRecord;
    
    public Patient(int id,String pn,String pIC,String hp,String g){
        this.patientID = id;
        this.patientName = pn;
        this.patientIC = pIC;
        this.phoneNo = hp;
        this.gender = g;
        this.patientRecord = new ArrayQueue<>();
    }
    
    public Patient(int id) {
        this.patientID = id;
        this.patientRecord = new ArrayQueue<>();
    }
    
    public Patient(int id,String pn,String pIC,String hp,String g,QueueInterface<Record> record){
        this.patientID = id;
        this.patientName = pn;
        this.patientIC = pIC;
        this.phoneNo = hp;
        this.gender = g;
        this.patientRecord = record;
    }
    
    public void setID(int id ){
        this.patientID = id;
    }
    
    public void setPatientName(String pn){
        this.patientName = pn;
    }
    
    public void setPatientIC(String pIC){
        this.patientIC = pIC;
    }
    
    public void setPhoneNo(String hp){
        this.phoneNo = hp;
    }
    
    public void setGender (String g){
        this.gender = g;
    }
    
    public int getID(){
        return patientID;
    }
    
    public String getPatientName(){
        return patientName;
    }
    
    public String getPatientIC(){
        return patientIC;
    }
    
    public String getPhoneNo(){
        return phoneNo;
    }
    
    public String getGender(){
        return gender;
    }
    
    public QueueInterface<Record> getAllRecord(){
        return patientRecord;
    }
    
    public void addRecordToPatient(Record r){
        patientRecord.enqueue(r);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Patient other = (Patient) obj;

        if (this.patientID != other.patientID) {
            return false;
        }

        return true;
    }
    
    public String toString(){
        String line1 = "ID : "+patientID+"\nName : "+patientName+"\nIC :"+patientIC+"\nPhone No :"+phoneNo+"\nGender :"+gender+"\n";
       
//        for(int i=0;i<ownerCar.getNumberOfEntries();i++){
//            line2 += ownerCar.getEntry(i+1)+"\n";
//        }
        return line1;
    }

    
    
    
    

    

    
}
