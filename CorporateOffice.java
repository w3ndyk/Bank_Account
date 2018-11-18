import java.util.*;

public class CorporateOffice{
    private ArrayList<BranchBanking> branchList = new ArrayList<BranchBanking>();
    
    public CorporateOffice(ArrayList<String> clientInformation){
        ArrayList<Client> clientList = new ArrayList<Client>();
        
        String fname;
        String lname;
        String user;
        String pass;
        float per_bal;
        float bus_bal;
        
        for (int i = 0; i < 4; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 4; i < 8; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 8; i < 12; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 12; i < 16; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
    }
    
    public void ClientSystem(Client user) { 
        int response = 0;
        boolean exit = false, correctInput;
        Scanner sc = new Scanner(System.in);
        String input;
        float amount = 0;
        
        while (!exit) {
            System.out.print("\n\n* * Bank Account * *\n" + 
                       "1." + "\tMake a deposit into Personal bank account.\n"  +
                       "2." + "\tMake a withdrawal from your Personal bank account.\n" +
                       "3." + "\tView your Personal bank account balance.\n" + 
                       "4." + "\tMake a deposit into Business bank account.\n" +
                       "5." + "\tMake a withdrawal from your Business bank account.\n" +
                       "6." + "\tView your Business bank account balance.\n" + 
                       "7." + "\tExit the system.\n" +
                       "\nChoose an option: ");
            
            input = sc.nextLine();
            correctInput = numCheck7(input);
            while (!correctInput) {
                System.out.print("Choose an option again: ");
                input = sc.nextLine();
                correctInput = numCheck7(input);
            }
            response = Integer.parseInt(input);
            
            if (response == 7) {
                exit = true;
            }
            else {
                switch (response) {
                    case 1:
                        System.out.print("\nEnter the amount of money you wish to deposit: ");
                        input = sc.nextLine();
                        correctInput = isNumString(input);
                        while (!correctInput) {
                            System.out.print("Re-enter the amount of money you wish to deposit: ");
                            input = sc.nextLine();
                            correctInput = isNumString(input);
                        }
                        amount = Float.parseFloat(input);
                        user.setPerBal(amount);
                        System.out.println("\nDepositing...");
                        System.out.print("New Personal Balance: $");
                        System.out.printf("%.2f", user.getPerBal());
                        break;
                    case 2:
                        System.out.print("\nCurrent Personal Balance: $");
                        System.out.printf("%.2f", user.getPerBal());
                        System.out.print("\nEnter the amount of money you wish to withdraw: ");
                        input = sc.nextLine();
                        correctInput = isNumString(input);
                        while (!correctInput) {
                            System.out.print("Re-enter the amount of money you wish to withdraw: ");
                            input = sc.nextLine();
                            correctInput = isNumString(input);
                        }
                        amount = Float.parseFloat(input);
                        correctInput = amount <= user.getPerBal();
                        while (!correctInput) {
                            System.out.println("\tError! Withdrawal amount is greater than current balance.");
                            System.out.print("Current Personal Balance: $");
                            System.out.printf("%.2f", user.getPerBal());
                            System.out.print("\nRe-enter the amount of money you wish to withdraw: ");
                            input = sc.nextLine();
                            amount = Float.parseFloat(input);
                            correctInput = amount <= user.getPerBal();
                        }
                        user.setPerBal(-amount);
                        System.out.println("\nWithdrawing...");
                        System.out.print("New Personal Balance: $");
                        System.out.printf("%.2f", user.getPerBal());
                        break;
                    case 3:
                        System.out.print("\nCurrent Personal Balance: $");
                        System.out.printf("%.2f", user.getPerBal());
                        break;
                    case 4:
                        System.out.print("\nEnter the amount of money you wish to deposit: ");
                        input = sc.nextLine();
                        correctInput = isNumString(input);
                        while (!correctInput) {
                            System.out.print("Re-enter the amount of money you wish to deposit: ");
                            input = sc.nextLine();
                            correctInput = isNumString(input);
                        }
                        amount = Float.parseFloat(input);
                        user.setBusBal(amount);
                        System.out.println("\nDepositing...");
                        System.out.print("New Business Balance: $");
                        System.out.printf("%.2f", user.getBusBal());
                        break;
                    case 5:
                        System.out.print("\nCurrent Business Balance: $");
                        System.out.printf("%.2f", user.getBusBal());
                        System.out.print("\nEnter the amount of money you wish to withdraw: ");
                        input = sc.nextLine();
                        correctInput = isNumString(input);
                        while (!correctInput) {
                            System.out.print("Re-enter the amount of money you wish to withdraw: ");
                            input = sc.nextLine();
                            correctInput = isNumString(input);
                        }
                        amount = Float.parseFloat(input);
                        correctInput = amount <= user.getBusBal();
                        while (!correctInput) {
                            System.out.println("\tError! Withdrawal amount is greater than current balance.");
                            System.out.print("Current Business Balance: $");
                            System.out.printf("%.2f", user.getBusBal());
                            System.out.print("\nRe-enter the amount of money you wish to withdraw: ");
                            input = sc.nextLine();
                            amount = Float.parseFloat(input);
                            correctInput = amount <= user.getBusBal();
                        }
                        user.setBusBal(-amount);
                        System.out.println("\nWithdrawing...");
                        System.out.print("New Business Balance: $");
                        System.out.printf("%.2f", user.getBusBal());
                        break;
                    case 6:
                        System.out.print("\nCurrent Business Balance: $");
                        System.out.printf("%.2f", user.getBusBal());
                        break;
                }
            }
        }
    }
    
    public void CorpSystem() {
        int response = 0;
        boolean exit = false, correctInput;
        Scanner sc = new Scanner(System.in);
        String input;
        float amount = 0;
        
        while (!exit) {
            System.out.print("\n* * Regional Manager Account * *\n" + 
                           "1." + "\tPrint out all client information.\n"  +
                           "2." + "\tPrint out all business account information.\n" +
                           "3." + "\tPrint out all personal account information.\n" + 
                           "4." + "\tPrint out whether a monthly profit was earned.\n" +
                           "5." + "\tPrint out whether a monthly profit was earned through Personal Banking.\n" +
                           "6." + "\tPrint out whether a monthly profit was earned through Business Banking.\n" + 
                           "7." + "\tExit the system.\n" +
                           "\nChoose an option: ");
            
            input = sc.nextLine();
            correctInput = numCheck7(input);
            while (!correctInput) {
                System.out.print("Choose an option again: ");
                input = sc.nextLine();
                correctInput = numCheck7(input);
            }
            response = Integer.parseInt(input);
            
            if (response == 7) {
                exit = true;
            }
            else {
                switch (response) {
                    case 1:
                        System.out.print(toString());
                        break;
                    case 2:
                        System.out.print(getBus());
                        break;
                    case 3:
                        System.out.print(getPer());
                        break;
                    case 4:
                        System.out.print("\nTotal money earned: $");
                        System.out.printf("%.2f", getTotalProfit());
                        if (checkProfit()) {
                            System.out.print("\nA monthly profit was earned.");
                        }
                        else {
                            System.out.println("\nNo monthly profit was earned.");
                        }
                        break;  
                    case 5:
                        System.out.print("\nTotal money earned through \"Personal Banking\": $ ");
                        System.out.printf("%.2f", getProfitPer());
                        if (profitPer()) {
                            System.out.println("\nA monthly profit was earned through \"Personal Banking\".");
                        }
                        else {
                            System.out.println("\nNo monthly profit was earned through \"Personal Banking\".");
                        }
                        break;
                    case 6:
                        System.out.print("\nTotal money earned through \"Business Banking\": $");
                        System.out.printf("%.2f", getProfitBus());
                        if (profitBus()) {
                            System.out.println("\nA monthly profit was earned through \"Business Banking\".");
                        }
                        else {
                            System.out.println("\nNo monthly profit was earned through \"Business Banking\".");
                        }
                        break;
                }
            }
        }
    }
    
    public boolean checkProfit() {
        if (getTotalProfit() >= 7000) {
            return true;
        }
        else {
            return false;
        }
    }
    public float getTotalProfit() { // get profit from all accounts
        return (((getTotalPer() + getTotalBus()) * 0.05f) / branchList.size()) / 12f;
    }

    public boolean profitPer() { // true if profit from Per > 40% expenses (7000)
        if (getProfitPer() >= (7000 * 0.4)) {
            return true;
        }
        else {
            return false;
        }
    }
    public float getProfitPer() { // get profit from personal accounts
        return ((getTotalPer() * 0.05f) / branchList.size()) / 12f;
    }
    public float getTotalPer() { // get total amount from personal accounts
        float p_bal = 0;
        for (int i = 0; i < branchList.size(); i++) {
            for (int j = 0; j < branchList.get(i).getClientSize(); j++) {
                p_bal += branchList.get(i).getClient(j).getPerBal(); 
            }
        } 
        return p_bal;
    }
    
    public boolean profitBus() { // true if profit from Bus > 60% expenses (7000)
        if (getProfitBus() >= (7000 * 0.6)) {
            return true;
        }
        else {
            return false;
        }
    }
    public float getProfitBus() { // get profit from business accounts
        return ((getTotalBus() * 0.05f) / branchList.size()) / 12f;
    }
    public float getTotalBus() { // get total amount from business accounts
        float b_bal = 0;
        for (int i = 0; i < branchList.size(); i++) {
            for (int j = 0; j < branchList.get(i).getClientSize(); j++) {
                b_bal += branchList.get(i).getClient(j).getBusBal(); 
            }
        }
        return b_bal;
    }
    
    public boolean credentialCheck(String u, String p) { // true if user exists within system
        if (getUser(u, p) != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isNumString(String str) { // check if string can be parsed to float
        boolean condition = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                count++;
                if (i != str.length() - 3) { // only 2 decimal place
                    count++;
                }
            }
            if (Character.isDigit(str.charAt(i)) && count <= 1) {
                condition = true;
            }
            else {
                condition = false;
            }
        }
        
        if (!condition) {
            System.out.println("\tError! Input should contain numbers only.");
        }
        
        return condition;
    }    
    public boolean numCheck7(String str) { // check if string is a number from 1 to 7
        boolean condition = false;
        String num[] = {"1", "2", "3", "4", "5", "6", "7"};
        for (int i = 0; i < num.length; i++) {
            if (str.equals(num[i])) {
                condition = true;
            }
        }
        
        if (!condition) {
            System.out.println("\tError! Enter a number from 1-7.");
        }
        
        return condition;
    }
    
    public Client getUser(String u, String p) {
        String username, password;
        Client user = null;
        for (int i = 0; i < branchList.size(); i++) {
            for (int j = 0; j < branchList.get(i).getClientSize(); j++) {
                username = branchList.get(i).getClient(j).getUser();
                password = branchList.get(i).getClient(j).getPassword();
                
                if (username.equals(u) && password.equals(p)) {
                    user = branchList.get(i).getClient(j);
                }
            }
        }
        return user;
    }
    
    public String getBus() {
        String output = "";
        for (int i = 0; i < branchList.size(); i++) {
            output += branchList.get(i).getBus() + "\n";
        }
        return output;
    }
    public String getPer() {
        String output = "";
        for (int i = 0; i < branchList.size(); i++) {
            output += branchList.get(i).getPer() + "\n";
        }
        return output;
    }
    
    public String toString(){
        String output = "";
        for (int i = 0; i < branchList.size(); i++) {
            output += branchList.get(i) + "\n";
        }
        return output;
    }
}