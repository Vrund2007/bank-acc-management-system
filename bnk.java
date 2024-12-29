import java.util.*;
class Acc{
    int ano; String aname; int abal; static String bankname;
    Scanner sc = new Scanner(System.in);

    void set(){
        System.out.print("Enter Account Number : ");
        int no = sc.nextInt();
        sc.nextLine(); //Flush
        System.out.print("Enter Account Owner's name : ");
        String name = sc.nextLine();
        System.out.print("Enter Account Balance : ");
        int bal = sc.nextInt();

        ano = no;
        abal = bal;
        aname = name;
        System.out.println();
    }

    void get(){
        System.out.println("Account Number : "+ano);
        System.out.println("Account Owner's Name : "+aname);
        System.out.println("Account Balance : "+abal);
        System.out.println("Bank Name : " + bankname);
        System.out.println();
    }

    void case1(Acc [] a){
        System.out.print("Enter account number : ");
        int sno = sc.nextInt();
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(a[i].ano == sno){
                a[i].get();
                check = true;
            }
        }
        if(check == false){
            System.out.println("Account Number is invalid :( ");
        }
        System.out.println();
    }

    void case2(Acc [] a){
        System.out.print("Enter Balance : ");
        int sbal = sc.nextInt();
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(a[i].abal >= sbal){ // Corrected the condition over here, It was finding the account
                // With the exact balance of the entered amount in the sbal;
                a[i].get();
                check = true;
            }
        }
        if(check == false){
            System.out.println("Account not Found ");
        }
        System.out.println();
    }

    void case3(Acc [] a){
        System.out.print("Enter Account owner's name : ");
        String sname = sc.nextLine();
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(a[i].aname.equalsIgnoreCase(sname)){
                a[i].get();
                check = true;
            }
        }
        if(check == false){
            System.out.println("Account Owner's name is invalid :( ");
        }
        System.out.println();
    }

    void case4(Acc [] a){
        System.out.print("Enter First char of Account owner/s : ");
        char schar = sc.next().toUpperCase().charAt(0);
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(schar == a[i].aname.toUpperCase().charAt(0)){
                a[i].get();
                check = true;
            }
        }
        if(check == false){
            System.out.println("Account Owner's name not found :( ");
        }
        System.out.println();
    }

    void case5(Acc [] a){
        System.out.print("Enter Account Number : ");
        int sno = sc.nextInt();
        System.out.print("Enter Amount to be deposit : ");
        int dep = sc.nextInt();
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(a[i].ano == sno){
                a[i].abal = a[i].abal + dep;
                check = true;
                System.out.println("Balance Updated. New Balance = " + a[i].abal);
                break;
            }
        }
        if(check == false){
            System.out.println("Account Number is invalid :( ");
        }
        System.out.println();
    }

    void case6(Acc [] a){
        System.out.print("Enter Account Number : ");
        int sno = sc.nextInt();
        System.out.print("Enter Amount to withdraw : ");
        int wit= sc.nextInt();
        boolean check = false;

        for(int i = 0; i < a.length; i++){
            if(a[i].ano == sno){
                if(a[i].abal >= wit){
                    a[i].abal = a[i].abal - wit;
                    check = true;
                    System.out.println("Balance Updated. New Balance = " + a[i].abal);
                }
                else{
                    System.out.println("Insufficient Balance :( ");
                }
            }
        }
        if(check == false){
            System.out.println("Account Number is invalid :( ");
        }
        System.out.println();
    }

    void case7(Acc[] a) {
        int[] balance = new int[a.length]; // Created balance array for storing the array
        for (int i = 0; i < a.length; i++) {
            balance[i]=a[i].abal;
        }
        Arrays.sort(balance); // Balance stored in the array
        for (int i = a.length-1; i > a.length-4; i--) {
            if(a[i].abal==balance[i]) {
                a[i].get();
                System.out.println();
            }
        }
    }

    void case8(Acc [] a){
        System.out.print("Enter new Bank Name : ");
        sc.nextLine(); // Flush
        String newBankName = sc.nextLine();
        bankname = newBankName;
        System.out.println("Bank Name updated successfully to : " + bankname);
        System.out.println();
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Bank Name : ");
        Acc.bankname = sc.nextLine();

        System.out.print("Enter no of Account in Bank : ");
        int n = sc.nextInt();
        System.out.println();

        //Making array for all Account
        Acc [] a = new Acc [n];
        Acc m = new Acc();

        //Gathering Information of all acc
        for(int i = 0; i<n ; i++ ){
            a[i] = new Acc();
            a[i].set();
            System.out.println();
        }

        boolean b = false;
        while (b==false) {
            System.out.println("Enter 1 to retrieve details of an account using its account number.");
            System.out.println("Enter 2 to display details of all accounts with a balance exceeding the amount you input.");
            System.out.println("Enter 3 to find account details by entering the owner's name.");
            System.out.println("Enter 4 to display details of accounts where the owner's name starts with a specified character.");
            System.out.println("Enter 5 to deposit money into a specific account.");
            System.out.println("Enter 6 to withdraw money from a specific account.");
            System.out.println("Enter 7 to view details of the top three accounts with the highest balances.");
            System.out.println("Enter 8 to update the bank's name for all accounts.");
            System.out.println("Enter 9 to exit the application.");
            System.out.println();

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();
            System.out.println();

            switch (ch)
            {
                case 1 : m.case1(a);
                    break;
                case 2 : m.case2(a);
                    break;
                case 3 : m.case3(a);
                    break;
                case 4 : m.case4(a);
                    break;
                case 5 : m.case5(a);
                    break;
                case 6 : m.case6(a);
                    break;
                case 7 : m.case7(a);
                    break;
                case 8 : m.case8(a);
                    break;
                case 9 : System.out.println("Bye Bye! Have a great time.");
                    b=true;
                    break;
                default: System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
