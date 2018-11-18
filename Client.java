import java.util.Scanner;

public class Client
{
    private String fname;
    private String lname;
    private String username;
    private String password;
    private float per_bal;
    private float bus_bal;
    
    public Client(String f, String l, String u, String p, float pb, float bb) {
        fname = f;
        lname = l;
        username = u;
        password = p;
        per_bal = pb;
        bus_bal = bb;
    }
    
    public float getPerBal() {
        return per_bal;
    }
    
    public void setPerBal(float p) {
        per_bal += p;
    }
    
    public float getBusBal() {
        return bus_bal;
    }
    
    public void setBusBal(float b) {
        bus_bal += b;
    }
    
    public String getUser() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getBus() {
        return fname + " " + lname + " (Business Balance): $" + bus_bal;
    }
    
    public String getPer() {
        return fname + " " + lname + " (Personal Balance): $" + per_bal;
    }
    
    public String toString() {
        return fname + " " + lname + " (Personal Balance): $" + per_bal + "\n" +
               fname + " " + lname + " (Business Balance): $" + bus_bal;
    }
}