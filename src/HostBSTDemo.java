import java.util.Scanner;

public class HostBSTDemo {
    public static void main(String[] args) {
        HostBST bst = new HostBST();
        Scanner input = new Scanner(System.in);

        // Pre-populating with your known hosts
        bst.addHost("google.com", "142.250.190.78");
        bst.addHost("example.com", "93.184.216.34");
        bst.addHost("github.com", "140.82.112.3");
        bst.addHost("stackoverflow.com", "151.101.65.69");
        bst.addHost("certifiedethicalhacker.com", "104.22.9.154");
        bst.addHost("quad9.com", "35.244.205.16");

        System.out.println("--- ELK Stack Host Lookup Tool ---");

        while (true) {
            System.out.print("\nEnter hostname to search (or type 'exit' to quit): ");
            String lookUp = input.nextLine().trim();

            if (lookUp.equalsIgnoreCase("exit")) {
                System.out.println("Closing lookup tool...");
                break;
            }

            // Logic to find the IP
            if (bst.containsHostname(lookUp)) {
                String ip = bst.getIPAddress(lookUp);
                System.out.println("Result -> IP for " + lookUp + " is: " + ip);
            } else {
                System.out.println("Result -> Hostname '" + lookUp + "' not found in the system.");
            }
        }

        input.close(); // Good practice to close the scanner
    }
}