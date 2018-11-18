import java.util.ArrayList;

public class BranchBanking{
    private ArrayList<Client> clientList = new ArrayList<Client>();
    
    public BranchBanking(ArrayList<Client> clients){
        for (Client item : clients) {
            clientList.add(item);
        }
    }
    
    public int getClientSize() {
        return clientList.size();
    }
    
    public Client getClient(int i) {
        return clientList.get(i);
    }
    
    public String getBus() {
        String output = "";
        for (int i = 0; i < clientList.size(); i++) {
            output += clientList.get(i).getBus() + "\n";
        }
        return output;
    }
    
    public String getPer() {
        String output = "";
        for (int i = 0; i < clientList.size(); i++) {
            output += clientList.get(i).getPer() + "\n";
        }
        return output;
    }
    
    public String toString(){
        String output = "";
        for (int i = 0; i < clientList.size(); i++) {
            output += clientList.get(i) + "\n";
        }
        return output;
    }
}