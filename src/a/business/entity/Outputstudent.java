package a.business.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Outputstudent {
    public static List<Student>arrStudent=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void inputData(){
        System.out.println("moi ban nhap so luong");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Student student=new Student();
            student.inputData(sc);
            arrStudent.add(student);
        }
    }
    public static void outputData(){
        arrStudent.forEach((e)->{
            e.outputData();
        });
    }
    public static void  update(){
        System.out.println("moi ban cap nhat nhap ma id");
        int id=sc.nextInt();
        int update=findId(id);
        if(update>=0){
            boolean exit=true;
            do {
                System.out.println("moi ban nhap chuc nang menu:");
                int choice=sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("cap nhat ten sinh vien");
                        arrStudent.get(update).setStudentName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("cap nhat ngày sinh sinh vien");
                        try {
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                            Date date=sdf.parse(sc.nextLine());
                            arrStudent.get(update).setBirthdate(sdf.format(date));
                        }catch (Exception e){
                            System.err.println("dinh dang phai dd/mm/yyyy");
                        }
                        break;
                    case 3:
                        System.out.println("cap nhat dia chỉ sinh vien");
                        arrStudent.get(update).setAddress(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("cap nhat gioi sinh vien");
                        arrStudent.get(update).setGender(Boolean.parseBoolean(sc.nextLine()));
                        break;
                    case 5:
                        System.out.println("cap nhat so dien thoai sinh vien");
                        arrStudent.get(update).setPhone(sc.nextLine());
                        break;
                    default:
                        exit=false;
                }
            }while (exit);

        }
        else{
            System.err.println("ma id k ton tai");
        }
    }
    public static int findId(int id){
        for(int i=0;i<arrStudent.size();i++){
            if(arrStudent.get(i).getStudentId()==id){
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
                    Outputstudent.inputData();
                    break;
                case 2:
                    Outputstudent.outputData();
                    break;
                case 3:
                    Outputstudent.update();
                    break;
            }
        }while (true);
    }
}
