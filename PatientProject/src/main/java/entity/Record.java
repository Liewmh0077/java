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
public class Record {
    private int recordID;
    private String medicalCase;
    private int totalpayment;
    private String paydate;
    
    public Record() {
        recordID = 0;
        medicalCase = null;
        totalpayment = 0;
        paydate = null;
    }
    
    public Record(int id){
        recordID = id;
        medicalCase = null;
        totalpayment = 0;
        paydate = null;
        
    }
    
    
    public Record(int recordID,String mc,int tp,String pd){
        this.recordID = recordID;
        this.medicalCase = mc;
        this.totalpayment = tp;
        this.paydate = pd;
    }
    
    
    ///set data
    public void serRecordID(int id){
        this.recordID = id;
    }
    
    public void setMedicalCase(String mc){
       medicalCase = mc;
    }
    
    public void setTotalPayment(int tp){
        totalpayment = tp;
    }
    
    public void setPayDate(String pd){
        paydate = pd;
    }
    
    //// get data
    public int getRecordID(){
        return recordID;
    }
    
    public String getMedicalCase(){
        return medicalCase;
    }
    
    
    public int getTotalPayment(){
        return totalpayment;
    }
    
    public String getPayDate(){
        return paydate;
    }
    
    
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Record other = (Record) obj;
        
        
        
        return  true;
        
    
    }
    
    public String toString(){
        return "Record ID :"+recordID+"\nMedical Case : "+medicalCase+"\nTotal Payment : "+totalpayment+"\nDate : "+paydate+"\n";
    }
}


