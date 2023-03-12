import edu.duke.*;
import java.util.*;

public class Crypto {
    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder (input);
        key=key%26;
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = Alphabet.toLowerCase();
        String s="";
        String ShiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        for (int i = 0; i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)) {
                int idx = alphabet.indexOf(currChar);
                if (idx !=-1){
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }

            }

            else {
                int idx = Alphabet.indexOf(currChar);
                if (idx !=-1){
                    char newChar = ShiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }

            }
        }
        s=encrypted.toString();
        return s;
    }

    public static String encrypt2keys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder (input);
        key1%=26;
        key2%=26;
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        for (int i = 0; i <encrypted.length();i+=2){
            char currChar = encrypted.charAt(i);
            if ((i %2 == 0) && (Character.isLowerCase(currChar))) {
                int idx = alphabet.indexOf(currChar);
                if (idx!= 0)
                {
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
            {
                int idx = Alphabet.indexOf(currChar);
                if (idx != 0)
                {
                    char newChar = ShiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }
        for (int i = 1; i <encrypted.length();i+=2){
            char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                int idx = alphabet.indexOf(currChar);
                if (idx != 0)
                {
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else if ((i %2 != 0) && (Character.isUpperCase(currChar))) {
                int idx = Alphabet.indexOf(currChar);
                if (idx != 0)
                {
                    char newChar = ShiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        } 
        String s=encrypted.toString();
        return s;
    }

    public static String Vigencrypt(String text, String key) {
        String res = "";
        key=key.toUpperCase();
        String temp=text;
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                res+=c;
            else{
                if(Character.isLowerCase(temp.charAt(i)))
                {
                    res += Character.toLowerCase((char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                }
                else
                    res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                j = ++j % key.length();}
        }
        return res;
    }

    public static String Vigdecrypt(String text, String key) {
        String res = "";
        String temp=text;
        key=key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') res+=c;
            else{
                if(Character.isLowerCase(temp.charAt(i)))
                    res += Character.toLowerCase((char)((c - key.charAt(j) + 26) % 26 + 'A'));
                else
                    res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
                j = ++j % key.length();
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice1=0;
        while(choice1!=3){
            System.out.println("Enter 1 to perform Encryption");
            System.out.println("Enter 2 to perform Decryption");
            System.out.println("Enter 3 to Exit the Program");
            System.out.print("\nEnter your choice: ");
            choice1=sc.nextInt();
            System.out.println();
            switch(choice1){
                case 1:{int choice2=0;
                    while(choice2!=3){
                        System.out.println("Enter 1 to perform Caesar Cipher Encryption");
                        System.out.println("Enter 2 to perform Vignere Cipher Encryption");
                        System.out.println("Enter 3 to go back");
                        System.out.println("Enter 4 to Exit the program");
                        System.out.print("\nEnter your choice: ");
                        choice2=sc.nextInt();
                        System.out.println();
                        switch(choice2){
                            case 1:{int choice3=0;
                                while(choice3!=3){
                                    System.out.println("Enter 1 to perform Single Key Caesar Cipher Encryption");
                                    System.out.println("Enter 2 to perform Double Key Caesar Cipher Encryption");
                                    System.out.println("Enter 3 to go back");
                                    System.out.println("Enter 4 to Exit the Program");
                                    System.out.print("\nEnter your choice: ");
                                    choice3=sc.nextInt();
                                    System.out.println();
                                    switch(choice3){
                                        case 1:{int choice4=0;
                                            while(choice4!=3){
                                                System.out.println("Enter 1 to type the message to be encrypted");
                                                System.out.println("Enter 2 to choose a text file whose message is to be encrypted");
                                                System.out.println("Enter 3 to go back");
                                                System.out.println("Enter 4 to Exit the Program");
                                                System.out.print("\nEnter your choice: ");
                                                choice4=sc.nextInt();
                                                switch(choice4){
                                                    case 1:{
                                                        String message;
                                                        sc.nextLine();
                                                        System.out.print("\nEnter the message to be encrypted: ");
                                                        message=sc.nextLine();
                                                        System.out.print("Enter the key with which the message is to be encrypted: ");
                                                        int key=sc.nextInt();
                                                        sc.nextLine();
                                                        String s=encrypt(message,key);
                                                        System.out.print("Encrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 2:{
                                                        FileResource fr = new FileResource();
                                                        String message = fr.asString();
                                                        System.out.print("Enter the key with which the message is to be encrypted: ");
                                                        int key=sc.nextInt();
                                                        String s=encrypt(message,key);
                                                        System.out.print("Encrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 3:break;
                                                    case 4:System.exit(0);
                                                    default:System.out.println("\nPlease Enter a Valid Choice\n");
                                                }
                                            }
                                        }
                                        break;
                                        case 2:{int choice4=0;
                                            while(choice4!=3){
                                                System.out.println("Enter 1 to type the message to be encrypted");
                                                System.out.println("Enter 2 to choose a text file whose message is to be encrypted");
                                                System.out.println("Enter 3 to go back");
                                                System.out.println("Enter 4 to Exit the Program");
                                                System.out.print("\nEnter your choice: ");
                                                choice4=sc.nextInt();
                                                switch(choice4){
                                                    case 1:{
                                                        String message;
                                                        sc.nextLine();
                                                        System.out.print("\nEnter the message to be encrypted: ");
                                                        message=sc.nextLine();
                                                        System.out.print("Enter the key 1 with which the message is to be encrypted: ");
                                                        int key1=sc.nextInt();
                                                        System.out.print("Enter the key 2 with which the message is to be encrypted: ");
                                                        int key2=sc.nextInt();
                                                        sc.nextLine();
                                                        String s=encrypt2keys(message,key1,key2);
                                                        System.out.print("Encrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 2:{
                                                        FileResource fr = new FileResource();
                                                        String message = fr.asString();
                                                        System.out.print("Enter the key 1 with which the message is to be encrypted: ");
                                                        int key1=sc.nextInt();
                                                        System.out.print("Enter the key 2 with which the message is to be encrypted: ");
                                                        int key2=sc.nextInt();
                                                        sc.nextLine();
                                                        String s=encrypt2keys(message,key1,key2);
                                                        System.out.print("Encrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 3:break;
                                                    case 4:System.exit(0);
                                                    default:System.out.println("\nPlease Enter a Valid Choice\n");
                                                }
                                            }
                                        }
                                        break;
                                        case 3:break;
                                        case 4:System.exit(0);
                                        default:System.out.println("\nPlease Enter a Valid Choice\n");
                                    }
                                }
                            }
                            break;
                            case 2:{
                                int choice4=0;
                                while(choice4!=3){
                                    System.out.println("Enter 1 to type the message to be encrypted");
                                    System.out.println("Enter 2 to choose a text file whose message is to be encrypted");
                                    System.out.println("Enter 3 to go back");
                                    System.out.println("Enter 4 to Exit the Program");
                                    System.out.print("\nEnter your choice: ");
                                    choice4=sc.nextInt();
                                    switch(choice4){
                                        case 1:{
                                            String message;
                                            sc.nextLine();
                                            System.out.print("\nEnter the message to be encrypted: ");
                                            message=sc.nextLine();
                                            System.out.print("Enter the key with which the message is to be encrypted: ");
                                            String key=sc.next();
                                            String s=Vigencrypt(message,key);
                                            System.out.print("Encrypted message is: "+s);
                                            System.out.println("\n");
                                        }
                                        break;
                                        case 2:{
                                            FileResource fr = new FileResource();
                                            String message = fr.asString();
                                            //sc.next();
                                            System.out.print("Enter the key with which the message is to be encrypted: ");
                                            String key=sc.next();
                                            String s=Vigencrypt(message,key);
                                            System.out.print("Encrypted message is: "+s);
                                            System.out.println("\n");
                                        }
                                        break;
                                        case 3:break;
                                        case 4:System.exit(0);
                                        default:System.out.println("\nPlease Enter a Valid Choice\n");
                                    }
                                }
                            }
                            break;
                            case 3:break;
                            case 4:System.exit(0);
                            default:System.out.println("\nPlease Enter a Valid Choice\n");
                        }
                    }
                }
                break;
                case 2:{int choice2=0;
                    while(choice2!=3){
                        System.out.println("Enter 1 to perform Caesar Cipher Decryption");
                        System.out.println("Enter 2 to perform Vignere Cipher Decryption");
                        System.out.println("Enter 3 to go back");
                        System.out.println("Enter 4 to Exit the program");
                        System.out.print("\nEnter your choice: ");
                        choice2=sc.nextInt();
                        System.out.println();
                        switch(choice2){
                            case 1:{
                                int choice3=0;
                                while(choice3!=3){
                                    System.out.println("Enter 1 to perform Single Key Caesar Cipher Decryption");
                                    System.out.println("Enter 2 to perform Double Key Caesar Cipher Decryption");
                                    System.out.println("Enter 3 to go back");
                                    System.out.println("Enter 4 to Exit the Program");
                                    System.out.print("\nEnter your choice: ");
                                    choice3=sc.nextInt();
                                    System.out.println();
                                    switch(choice3){
                                        case 1:{int choice4=0;
                                            while(choice4!=3){

                                                System.out.println("Enter 1 to type the message to be decrypted");
                                                System.out.println("Enter 2 to choose a text file whose message is to be decrypted");
                                                System.out.println("Enter 3 to go back");
                                                System.out.println("Enter 4 to Exit the Program");
                                                System.out.print("\nEnter your choice: ");
                                                choice4=sc.nextInt();
                                                switch(choice4){
                                                    case 1:{
                                                        String message;
                                                        sc.nextLine();
                                                        System.out.print("\nEnter the message to be decrypted: ");
                                                        message=sc.nextLine();
                                                        System.out.print("Enter the key with which the message is to be decrypted: ");
                                                        int key=sc.nextInt();
                                                        key%=26;
                                                        key=26-key;
                                                        sc.nextLine();
                                                        String s=encrypt(message,key);
                                                        System.out.print("Decrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 2:{
                                                        FileResource fr = new FileResource();
                                                        String message = fr.asString();
                                                        System.out.print("Enter the key with which the message is to be decrypted: ");
                                                        int key=sc.nextInt();
                                                        key%=26;
                                                        key=26-key;
                                                        String s=encrypt(message,key);
                                                        System.out.print("Decrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 3:break;
                                                    case 4:System.exit(0);
                                                    default:System.out.println("\nPlease Enter a Valid Choice\n");
                                                }
                                            }
                                        }
                                        break;
                                        case 2:{int choice4=0;
                                            while(choice4!=3){
                                                System.out.println("Enter 1 to type the message to be decrypted");
                                                System.out.println("Enter 2 to choose a text file whose message is to be decrypted");
                                                System.out.println("Enter 3 to go back");
                                                System.out.println("Enter 4 to Exit the Program");
                                                System.out.print("\nEnter your choice: ");
                                                choice4=sc.nextInt();
                                                switch(choice4){
                                                    case 1:{
                                                        String message;
                                                        sc.nextLine();
                                                        System.out.print("\nEnter the message to be decrypted: ");
                                                        message=sc.nextLine();
                                                        System.out.print("Enter the key 1 with which the message is to be decrypted: ");
                                                        int key1=sc.nextInt();
                                                        System.out.print("Enter the key 2 with which the message is to be decrypted: ");
                                                        int key2=sc.nextInt();
                                                        sc.nextLine();
                                                        key1%=26;
                                                        key1=26-key1;
                                                        key2%=26;
                                                        key2=26-key2;
                                                        String s=encrypt2keys(message,key1,key2);
                                                        System.out.print("Decrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 2:{
                                                        FileResource fr = new FileResource();
                                                        String message = fr.asString();
                                                        System.out.print("Enter the key 1 with which the message is to be decrypted: ");
                                                        int key1=sc.nextInt();
                                                        System.out.print("Enter the key 2 with which the message is to be decrypted: ");
                                                        int key2=sc.nextInt();
                                                        key1%=26;
                                                        key1=26-key1;
                                                        key2%=26;
                                                        key2=26-key2;
                                                        sc.nextLine();
                                                        String s=encrypt2keys(message,key1,key2);
                                                        System.out.print("Decrypted message is: "+s);
                                                        System.out.println("\n");
                                                    }
                                                    break;
                                                    case 3:break;
                                                    case 4:System.exit(0);
                                                    default:System.out.println("\nPlease Enter a Valid Choice\n");
                                                }
                                            }
                                        }
                                        break;
                                        case 3:break;
                                        case 4:System.exit(0);
                                        default:System.out.println("\nPlease Enter a Valid Choice\n");
                                    }
                                }
                            }
                            break;
                            case 2:{int choice4=0;
                                while(choice4!=3){
                                    System.out.println("Enter 1 to type the message to be decrypted");
                                    System.out.println("Enter 2 to choose a text file whose message is to be decrypted");
                                    System.out.println("Enter 3 to go back");
                                    System.out.println("Enter 4 to Exit the Program");
                                    System.out.print("\nEnter your choice: ");
                                    choice4=sc.nextInt();
                                    switch(choice4){
                                        case 1:{
                                            String message;
                                            sc.nextLine();
                                            System.out.print("\nEnter the message to be decrypted: ");
                                            message=sc.nextLine();
                                            System.out.print("Enter the key with which the message is to be decrypted: ");
                                            String key=sc.next();
                                            String s=Vigdecrypt(message,key);
                                            System.out.print("Decrypted message is: "+s);
                                            System.out.println("\n");
                                        }
                                        break;
                                        case 2:{
                                            sc.nextLine();
                                            FileResource fr = new FileResource();
                                            String message = fr.asString();
                                            System.out.print("Enter the key with which the message is to be decrypted: ");
                                            String key=sc.next();
                                            String s=Vigdecrypt(message,key);
                                            System.out.print("Decrypted message is: "+s);
                                            System.out.println("\n");
                                        }
                                        break;
                                        case 3:break;
                                        case 4:System.exit(0);
                                        default:System.out.println("\nPlease Enter a Valid Choice\n");
                                    }
                                }
                            }
                            break;
                            case 3:break;
                            case 4:System.exit(0);
                            default:System.out.println("\nPlease Enter a Valid Choice\n");
                        }
                    }
                }
                break;
                case 3:System.exit(0);
                default:System.out.println("\nPlease Enter a Valid Choice\n");
            }
        }
    }
}