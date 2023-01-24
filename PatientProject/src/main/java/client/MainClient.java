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
import java.util.Scanner;



public class MainClient {
    private PatientManager pm = new PatientManager();
    private Scanner scan = new Scanner(System.in);
    
    
    public void runApp(){
        int choose;
        
        do{
            
            System.out.println(" 1 . Add New Patient ");
            System.out.println(" 2 . Search Patient ");
            System.out.println(" 3 . Display Patient ");
            System.out.println(" 4 . Modify Patient ");
            System.out.println(" 5 . Add Record To Patient ");
            System.out.println(" 6 . Add New Record ");
            System.out.println(" 7 . Save to Text File");
            System.out.println(" 0 . Exit ");
            
            System.out.println("Your Selection : ");
            
            choose = scan.nextInt();
            scan.nextLine();
            
            switch(choose){
                case 1 : pm.addNewPatient();
                break;
                case 2 : pm.searchPatient();
                break;
                case 3 : pm.displayPatient();
                break;
                case 4 : modify();
                break;
                case 5 : pm.addRecordToPatient();
                break;
                case 6 : pm.addNewRecord();
                break;
                case 7 : pm.writeToFile();
                break;
                default: System.out.println(" Bye Bye !!!");
            }
        
        }while (choose!=0);
    }
    
    public void modify(){
        int choose;
        
        do{
            System.out.println("Enter your Selection : ");
            System.out.println(" 1. Delete ");
            System.out.println(" 2. Change Details ");
            System.out.println(" 0. Return ");
        
            choose = scan.nextInt();
            scan.nextLine();
            
            switch(choose){
                case 1 : pm.deleteData();
                break;
                case 2 : pm.replacepdata();
                break;
                
            }
        }while(choose != 0);
        
        
    }
    
    
    public static void main (String[] args){
        new MainClient().runApp();
    }
}
