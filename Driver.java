import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String args[]){
        String username = null, password = null;
        boolean inUse = true, invalid, userIsClient, userIsCorp;
        Client user = null;
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> newClients = new ArrayList<String>();
        
        newClients.add("Dan Lee a1 a1 42000.01 78000.12");
        newClients.add("Ted Lee a2 a2 40200.01 70800.12");
        newClients.add("Red Lee a3 a3 40020.01 70080.12");
        newClients.add("Phil Lee a4 a4 40002.01 70008.12");
        
        newClients.add("Ben Lee b1 b1 43000.01 73000.12");
        newClients.add("Yul Lee b2 b2 40300.01 70300.12");
        newClients.add("Luk Lee b3 b3 40030.01 70030.12");
        newClients.add("Fred Lee b4 b4 40003.01 70003.12");
        
        newClients.add("Ned Lee c1 c1 47000.01 76000.12");
        newClients.add("Wen Lee c2 c2 40700.01 70600.12");
        newClients.add("Mo Lee c3 c3 40070.01 70060.12");
        newClients.add("Nell Lee c4 c4 40007.01 70006.12");
        
        newClients.add("Gad Lee d1 d1 49000.01 74000.12");
        newClients.add("Ill Lee d2 d2 40900.01 70400.12");
        newClients.add("Pill Lee d3 d3 40090.01 70040.12");
        newClients.add("Dill Lee d4 d4 40009.01 70004.12");
        
        CorporateOffice corp = new CorporateOffice(newClients);
        
        while (inUse) {
            invalid = true; 
            userIsClient = userIsCorp = false;
            
            System.out.print('\u000C'); // clear console
            System.out.println("* * Welcome to the Bank! * *\n");
        
            while (invalid) {
                System.out.print("Enter username: ");
                username = sc.nextLine();
                System.out.print("Enter password: ");
                password = sc.nextLine();
                if (corp.credentialCheck(username, password)) {
                    userIsClient = true;
                    invalid = false;
                    user = corp.getUser(username, password);
                }
                else if (username.equals("-1") && password.equals("-1")) {
                    userIsCorp = true;
                    invalid = false;
                }
                else {
                    System.out.println("\tError! Invalid credentials.");
                }
            }
            
            if (userIsClient && !userIsCorp) {
                corp.ClientSystem(user);
            }
            if (userIsCorp && !userIsClient) {
                corp.CorpSystem(); 
            }
            System.out.println("* * Thank You! * *");
            
            try { 
                Thread.sleep(1500); // delay
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}