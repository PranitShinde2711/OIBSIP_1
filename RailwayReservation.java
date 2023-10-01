import java.util.*;
import java.util.HashMap;
class LoginSystem
{
    public Map<String,String> userDatabase;
    public LoginSystem()
    {
        userDatabase=new HashMap<>();
        userDatabase.put("user1","12345");
        userDatabase.put("user2","54321");
        userDatabase.put("user3","23415");
        userDatabase.put("user4","54123");
    }

    public boolean AuthenticateUser(String loginId,String Password)
    {
        if(userDatabase.containsKey(loginId))
        {
            String StoredPasswordHash =userDatabase.get(loginId);
            String EnteredPasswordHash =hashPassword(Password);
            return StoredPasswordHash.equals(EnteredPasswordHash);

        }
        return false;
    }

    private String hashPassword(String Password)
    {
        return Password;
    }
}


class TrainTicketBookingSystem {
    private Map<Integer, Boolean> bookedTickets;

    public TrainTicketBookingSystem(int totalSeats) {
        bookedTickets = new HashMap<>();
        // Initialize all seats as availabler(true)
        for (int i = 1; i <= totalSeats; i++) {
            bookedTickets.put(i, true);
        }
    }

    public void bookTicket(int seatNumber,String trainname) {
        if (bookedTickets.containsKey(seatNumber) && bookedTickets.get(seatNumber))
        {
            bookedTickets.put(seatNumber, false);
            System.out.println("Ticket for seat " + seatNumber + " booked successfully in  "+trainname);
        } 
        else {
            System.out.println("Seat " + seatNumber + " is already booked or invalid.");
        }
    }

    public void cancelTicket(int seatNumber,String PNR) {
        if (bookedTickets.containsKey(seatNumber) && !bookedTickets.get(seatNumber)) {
            bookedTickets.put(seatNumber, true);
            System.out.println("Ticket for seat " + seatNumber +" "+"having PNR no."+" "+PNR+" "+ "canceled successfully.");
        } else {
            System.out.println("Seat " + seatNumber + " is not booked or invalid.");
        }
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (Map.Entry<Integer, Boolean> entry : bookedTickets.entrySet()) {
            if (entry.getValue()) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}






public class RailwayReservation 
{
  public static void main(String[]args)
  {

    System.out.println("***********Railway Reservation system*************");
    String loginid,password,name,phoneno,destination,Trainno,PNR;
    int Numseats,seatno;
   
    //Passenger Login
    LoginSystem login=new LoginSystem();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter your login id: ");
    loginid=sc.nextLine();
    System.out.println("Enter your password:");
    password=sc.nextLine();
    if(login.AuthenticateUser(loginid,password))
        System.out.println("login Successful!!!");
    else
        System.out.println("Login failed");
    System.out.println("------------------------------------------");
    String choice;
    
    //Train Reservation
    TrainTicketBookingSystem ticketSystem = new TrainTicketBookingSystem(10);
    System.out.println("Enter your name:");
    name=sc.next();
    System.out.println("Enter your phoneno:");
    phoneno=sc.next();
    System.out.println("Enter your PNR number:");
    PNR=sc.next();
    System.out.println("Enter your destination:");
    destination=sc.next();
    System.out.println("Enter the seat number:");
    seatno=sc.nextInt();

    ticketSystem.bookTicket(seatno,"Local express");
    System.out.println("Enter the seat number:");
    seatno=sc.nextInt();

    ticketSystem.bookTicket(seatno,"Local express");
    ticketSystem.displayAvailableSeats();
    System.out.println("-------------------------------------------------");
    
    //Ticket Cancellation
    System.out.println("Do you want to cancel a ticket(YES/NO):");
    choice=sc.next();
    if(choice.equals("YES"))
    {
        System.out.println("Enter your PNR number:");
        PNR=sc.next();
        System.out.println("Enter the seat no. you want to cancel:");
        seatno=sc.nextInt();
        ticketSystem.cancelTicket(seatno, PNR);
    }   
    ticketSystem.displayAvailableSeats();
    
    
                

    }
  
}
