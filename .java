import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class attendance1{
    String name;
    int regno;
    int hourstakentillnow;
    int hoursabsenttillnow;
    String subjectname1; 
    float attendedpercentage1;
    float crtattendance;
    attendance1(String name,int regno,String subjectaname1,int hourstakentillnow,int hoursabsenttillnow){
        this.name = name;
        this.regno = regno;
        this.subjectname1 = subjectaname1;
        this.hourstakentillnow = hourstakentillnow;
        this.hoursabsenttillnow = hoursabsenttillnow;
    }
    void attendancecalculator(){
        attendedpercentage1 = (((float)(hourstakentillnow) - (hoursabsenttillnow))/hourstakentillnow)*100;
    }
    void nameregnodisplay1(){
        System.out.printf("Name: %s\nRegister no: %d\n",name,regno);
    }
    void displaydetails1(){
        System.out.printf("Subject: %s,Attendance: %.2f%%\n",subjectname1,attendedpercentage1);
    }
    void filehandle1(FileWriter writer)throws IOException{
        writer.write("Subject: "+subjectname1+","+"Attendance: "+String.format("%.2f",attendedpercentage1)+"\n");
    }
}
class attendance{
    static float  minattd;
    String name;
    int regno;
    String subjectname;
    int totalhours;
    double maxhrstotakeleave;
    int mxhrstotakeleave;
    attendance(String name,int regno,String subjectname,int totalhours){
        this.name = name;
        this.regno = regno;
        this.subjectname = subjectname;
        this.totalhours = totalhours;
    }
    void maxhourstoleave(){
        maxhrstotakeleave = ((totalhours-((minattd/100)*totalhours)));
        mxhrstotakeleave = (int)Math.round(maxhrstotakeleave);
    }
    void nameregnodisplay(){
        System.out.printf("Name: %s,\nRegisterno:%d\n",name,regno);
    }

    void displaydetails(){
        System.out.printf("Subject: %s,Max hours to take leave: %d\n",
    subjectname,mxhrstotakeleave); 
    }
    void filehandle(FileWriter writer)throws IOException{
        writer.write("Subject:"+subjectname+","+"Max hours to take leave:"+mxhrstotakeleave+"\n");
    }
}
public class attendancetracker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name;
        int regno;
        System.out.println("Enter the mininum attendance percentage of your college:");
        int clgminattendance = s.nextInt();
        float fcma = (float)clgminattendance;
        attendance.minattd =fcma;
        int n;
        int hourstakentillnow;
        int hoursabsenttillnow;
        int totalhours;
        char userinchoice;
        char displaychoice;
        String subjectname;
        String subjectname1;
        while(true){
        System.out.println("Enter if you want to find the current attendance percantage(c)\\The number of max hours to take leave(d)\\Exit(other than c,d)");
        char userchoice;
        userchoice = s.next().charAt(0);
        s.nextLine(); 
        if(userchoice == 'c'){
            System.out.println("Enter your name:");
            name = s.nextLine();
            while(true){
                try{
                    System.out.println("Enter your register number:");
                    regno = s.nextInt();
                    s.nextLine();
                    break;
                }
                catch(InputMismatchException e){
                    System.out.println("Enter a valid register number:");
                    s.nextLine();
                }
            }
            System.out.println("Enter the number of subjects:");
            n = s.nextInt();
            s.nextLine();
            attendance1[] subs1 = new attendance1[n];
            for(int i=0;i<n;i++){
                System.out.println("Subject:"+(i+1));
                System.out.println("Name:");
                subjectname= s.nextLine();
                while(true){
                    try{
                        System.out.println("Enter the number of hours you have taken leave");
                        hoursabsenttillnow= s.nextInt();
                        s.nextLine();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter a valid integer");
                        s.nextLine();
                    }
                }
                while(true){
                    try{
                        System.out.println("Enter the number of hours the subject has been taken");
                        hourstakentillnow = s.nextInt();
                        s.nextLine();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter a valid integer");
                        s.nextLine();
                    }
                }
                while(true){
                    if(hoursabsenttillnow>hourstakentillnow){
                        System.out.println("Hoursabsent greater than hourstaken");
                        System.out.println("Swap them(s) or enter again(a)");
                        userinchoice = s.next().charAt(0);
                            if(userinchoice == 's'){
                                int t = hoursabsenttillnow;
                                hoursabsenttillnow = hourstakentillnow;
                                hourstakentillnow = t;
                                System.out.println("Swap successfull");
                                break;
                            }
                            else if(userinchoice=='a'){
                                System.out.println("Enter the number of hours the subject has been taken");
                                hourstakentillnow = s.nextInt();
                                s.nextLine();
                                System.out.println("Enter the number of hours you have taken leave");
                                hoursabsenttillnow = s.nextInt();
                                s.nextLine();
                                if((hoursabsenttillnow>hourstakentillnow)==false){
                                    break;
                                }
                            }
                            else{
                                while(true){
                                    System.out.println("Enter c to continue");
                                    userinchoice = s.next().charAt(0);
                                    if(userinchoice == 'c'){
                                        break;
                                    }

                                }
                            }
                        }
                        else{
                            break;
                        }
                   }
            subs1[i] = new attendance1(name,regno,subjectname, hourstakentillnow, hoursabsenttillnow);
            }
            
            while(true){
                System.out.println("Enter p to display the details\\v to save the file\\l to exit");
                displaychoice = s.next().charAt(0);
                s.nextLine();
                if(displaychoice == 'p' || displaychoice == 'v' || displaychoice == 'l'){
                    if(displaychoice == 'p'){
                        for(int i=0;i<1;i++){
                            subs1[i].nameregnodisplay1();
                        }
                        for(int i=0;i<n;i++){
                            subs1[i].attendancecalculator();
                            subs1[i].displaydetails1();
                        }
                        break;
                    }
                else if(displaychoice == 'v'){
                    try{
                        FileWriter writer = new FileWriter("attendancetrackingsystem.txt",true);
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
                        String cortime = now.format(formatter);
                        writer.write("Last checked on:"+cortime+System.lineSeparator());
                        writer.write("Name:"+name+","+"Registernumber:"+regno+"\n");
                        for(int i=0;i<n;i++){
                            subs1[i].attendancecalculator();
                            // subs1[i].displaydetails1();
                            subs1[i].filehandle1(writer);
                        }
                        writer.write("\n");
                        writer.close();
                    }
                    catch(IOException e){
                        System.out.println("Error in writing to the file");
                        e.printStackTrace();
                    }
                    System.out.println("File saved successfully");
                    break;
                }
                else if(displaychoice=='l'){
                    break;
                }
                else{
                    while(true){
                        System.out.println("You have entered an invalid option\nEnter n to continue");
                        displaychoice = s.next().charAt(0);
                        s.nextLine();
                        if(displaychoice == 'n'){
                            break;
                        }
                    }
                }

                
            }
        }
    }
        else if(userchoice == 'd'){
            System.out.println("Enter your name:");
            name = s.nextLine();
            while(true){
                try{
                    System.out.println("Enter your register number:");
                    regno = s.nextInt();
                    s.nextLine();
                    break;
                }
                catch(InputMismatchException e){
                    System.out.println("Enter a valid register number:");
                    s.nextLine();
                }
            }
            System.out.println("Enter the number of subjects:");
            n = s.nextInt();
            s.nextLine();
            attendance[] subs = new attendance[n]; 
            for(int i=0;i<n;i++){
                System.out.println("Subject:"+(i+1));
                System.out.println("Name:");
                subjectname1 = s.nextLine();
                while(true){
                    try{
                        System.out.println("Totalhours:");
                        totalhours= s.nextInt();
                        s.nextLine();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter a valid integer");
                        s.nextLine();
                    }
                }
                subs[i] = new attendance(name,regno,subjectname1,totalhours);    
            }
             while(true){
                System.out.println("Enter p to display the details\\v to save the file");
                displaychoice = s.next().charAt(0);
                s.nextLine();
                if(displaychoice == 'p' || displaychoice == 'v'){
                    if(displaychoice == 'p'){
                        for(int i=0;i<1;i++){
                            subs[i].nameregnodisplay();
                        }
                        for(int i=0;i<n;i++){
                            subs[i].maxhourstoleave();
                            subs[i].displaydetails();
                        }
                        break;
                    }
                    if(displaychoice == 'v'){
                        try{
                            FileWriter writer = new FileWriter("attendancetrackingsystem.txt",true);
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
                            String cortime = now.format(formatter);
                            writer.write("Last checked on:"+cortime+System.lineSeparator());
                            writer.write("Name:"+name+","+"Registernumber:"+regno+"\n");
                            for(int i=0;i<n;i++){
                            subs[i].maxhourstoleave();
                            // subs[i].displaydetails();
                            subs[i].filehandle(writer);
                        }
                        writer.write("\n");
                        writer.close();
                        }
                        catch(IOException e){
                            System.out.println("Error in writing to the file");
                            e.printStackTrace();
                        }
                        System.out.println("File saved successfully\n");
                        break;
                    }
                }
                else{
                    while(true){
                        System.out.println("You have entered an invalid option\nEnter n to continue");
                        displaychoice = s.next().charAt(0);
                        s.nextLine();
                        if(displaychoice == 'n'){
                            break;
                        }
                    }
                }
            }
            
        }
        else{
            System.out.println("Exited successfully");
            break;
        }
    }
    s.close();
    }
    
}
