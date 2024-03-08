package a.business.entity;
import ra.business.design.MarkImpl;

import java.util.Scanner;

public class Mark implements MarkImpl {
    private int markId;
    private String student;
    private String subject;
    private  double point;

    public Mark() {
    }

    public Mark(int markId, String student,String subject,double point) {
        this.markId = markId;
        this.student=student;
        this.subject=subject;
        this.point=point;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.markId=inputmarkId();
        this.student=inputStudent(scanner);
        this.subject=inputSubject(scanner);
        this.point=inputpoint(scanner);

    }
    public int inputmarkId(){
        int max;
        if(Outputmark.arrmark.size()==0){
            max=0;
        }
        else{
            max=Outputmark.arrmark.get(0).getMarkId();
            for(int i=0;i<Outputmark.arrmark.size();i++){
                if(Outputmark.arrmark.get(i).getMarkId()>max){
                    max=Outputmark.arrmark.get(i).getMarkId();
                }
            }
        }
        return max+1;
    }
    public String inputStudent(Scanner scanner){
        scanner.nextLine();
        System.out.println("nhap ten sinh vien");
        do {
            String student=scanner.nextLine();
            if(student.length()!=0){
                return student;
            }
            else{
                System.err.println("ten hoc sinh khong duoc bo trong");
            }
        }while (true);
    }
    public String inputSubject(Scanner scanner){
        scanner.nextLine();
        System.out.println("moi ban nhap  mon hoc");
        do {
            String subject=scanner.nextLine();
            if(subject.length()!=0){
                return subject;
            }
            else{
                System.err.println("mon hoc khong duoc bo trong");
            }
        }while (true);
    }
    public double inputpoint(Scanner scanner){
        System.out.println("moi ban nhap diem");
        do {
            double point=scanner.nextDouble();
            if(point>=0&&point<=10){
                return point;
            }
            else{
                System.err.println("diem chi tu 0-10");
            }

        }while (true);
    }
    @Override
    public void outputData() {
        System.out.printf("%5d %5s %5s %.1f\n",this.markId,this.student,this.subject,this.point);

    }
}
