package a.business.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Outputsubject {
    public static List<Subject>arrSubject=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void inputData(){
        System.out.println("moi ban nhap so luong");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Subject subject=new Subject();
            subject.inputData(sc);
            arrSubject.add(subject);
        }
    }
    public static void outputData(){
        arrSubject.forEach((e)->{
            e.outputData();
        });
    }
    public static void update(){
        sc.nextLine();
        System.out.println("moi ban cap nhat ma mon học");
        String subjectId=sc.nextLine();
        int update=findIdA(subjectId);
        if(update>=0){
            boolean exit=true;
            do {
                System.out.println("moi ban chon chuc nang menu:");
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("moi ban cap nhat ten mon hoc");
                        arrSubject.get(update).setSubjectName(sc.nextLine());
                        break;
                    default:
                        exit=false;
                }
            }while (exit);
        }
        else{
            System.err.println("ma môn học k ton tai");
        }
    }
    public static int findIdA(String subjectId){
        for(int i=0;i<arrSubject.size();i++){
            if(arrSubject.get(i).getSubjectId().equals(subjectId)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        do {
            System.out.println("moi ban nhap chuc nang menu:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    Outputsubject.inputData();
                    break;
                case 2:
                    Outputsubject.outputData();
                    break;
                case 3:
                    Outputsubject.update();
                    break;
            }
        }while (true);
    }
}
