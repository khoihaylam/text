package a.business.entity;
import ra.business.design.SubjectImpl;

import java.util.Scanner;

public class Subject implements SubjectImpl {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.subjectId = inputsubjectId(scanner);
        this.subjectName = inputsubjectName(scanner);

    }


    public String inputsubjectId(Scanner scanner) {
        scanner.nextLine();
        System.out.println("moi ban nhap ma mon học");
        do {
            String subjectId = scanner.nextLine();
            if (subjectId.length() == 5) {
                if (subjectId.charAt(0) == 'M' && subjectId.charAt(1) == 'H') {
                    boolean check = false;
                    for (int i = 0; i < Outputsubject.arrSubject.size(); i++) {
                        if (Outputsubject.arrSubject.get(i).equals(subjectId)) {
                            check = true;
                        }
                    }
                    if (check) {
                        System.err.println("ma mon hoc da ton tai");
                    } else {
                        return subjectId;
                    }
                } else {
                    System.err.println("ma mon hoc bắt đầu m-h");
                }
            } else {
                System.err.println("ma mon hoc bat dau 5 ky tu");
            }
        } while (true);
    }
    public String inputsubjectName(Scanner scanner){
        scanner.nextLine();
        System.out.println("moi ban nhap tên mon học");
        do {
            String subjectName = scanner.nextLine();
            if(subjectName.length()!=0){
                boolean check=false;
                for(int i=0;i<Outputsubject.arrSubject.size();i++){
                    if(Outputsubject.arrSubject.get(i).equals(subjectName)){
                        check=true;
                    }
                }
                if(check){
                    System.err.println("ten mon hoc da ton tai");
                }
                else{
                    return subjectName;
                }
            }
            else{
                System.err.println("ten mon hoc khong duoc bỏ trống");
            }
        }while (true);
    }
    @Override
    public void outputData() {
        System.out.printf("%5s  %5s\n",this.subjectId,this.subjectName);

    }
}

