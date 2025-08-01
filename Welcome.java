import java.util.Scanner;
public class Welcome{
   public static void main(String[] args){
     
    
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your First Name:");
    String fristName = input.nextLine(); 
   
    System.out.println("Enter your Last Name:");
    String lastName = input.nextLine(); 

    System.out.println("Welcome to the Second Year " + fristName +" " + lastName );
}
}