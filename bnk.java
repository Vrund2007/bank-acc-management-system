import java.util.*;
class Acc{
    int ano; String aname; int abal; static String bankname;
    Scanner sc = new Scanner(System.in);

    void set(){
        System.out.println("Enter Account Number");
        int no = sc.nextInt();
        sc.nextLine(); //Flush
        System.out.println("Enter Account Owner's name");
        String name = sc.nextLine();
        System.out.println("Enter Account Balance");
        int bal = sc.nextInt();

        ano = no;
        abal = bal;
        aname = name;
    }

    void get(){
        System.out.println("Account Number : "+ano);
        System.out.println("Account Owner's Name : "+aname);
        System.out.println("Account Balance : "+abal);
    }
}