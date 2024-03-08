package a.business.entity;

import java.util.*;

public class Outputmark {
    public static List<Mark> arrmark=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void inputData(){
        System.out.println("moi ban nhap so luong");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Mark mark=new Mark();
            mark.inputData(sc);
            arrmark.add(mark);
        }
    }
    public static void outputData(){
        Collections.sort(arrmark, new Comparator<Mark>() {
            @Override
            public int compare(Mark o1, Mark o2) {
                return (int)(o1.getPoint()-o2.getPoint());
            }
        });
        arrmark.forEach((e)->{
            e.outputData();
        });
    }
    public static void update(){
        System.out.println("moi ban nhap ma diem muon cap nhat");
        int markId=sc.nextInt();
        int update=findId(markId);
        if(update>=0){
            boolean exit=true;
            do {
                System.out.println("chon chuc nang menu cap nhat");
                int choice=sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("cap nhat ten sinh vien");
                        arrmark.get(update).setStudent(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("cap nhat ten mon hoc ");
                        arrmark.get(update).setSubject(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("cap nhat diem thi");
                        arrmark.get(update).setPoint(sc.nextDouble());
                        break;
                    default:
                        exit=false;
                }
            }while (exit);
        }
    }
    public static int findId(int markId){
        for(int i=0;i<arrmark.size();i++){
            if(arrmark.get(i).getMarkId()==markId){
                return i;
            }
        }
        return -1;
    }
    public static void delete(){
        System.out.println("moi ban nhap ma diem muon xóa");
        int markId=sc.nextInt();
        int delete=findId(markId);
        if(delete>=0){
            arrmark.remove(delete);
        }
        else{
            System.err.println("ma diem k ton tai");
        }
    }
    public static int findIdA(String subjectId){
        for(int i=0;i<Outputsubject.arrSubject.size();i++){
            if(Outputsubject.arrSubject.get(i).getSubjectId().equals(subjectId)){
                return i;
            }
        }
        return -1;
    }
    public static void outputMark(){
        sc.nextLine();
        System.out.println("moi ban  nhap ma mon học");
        String subjectId=sc.nextLine();
        int find=findIdA(subjectId);
        if(find>=0){
            arrmark.get(find).outputData();
        }
        else{
            System.err.println("ma môn học k ton tai");
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("moi ban chon chuc nang menu:");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    Outputmark.inputData();
                    break;
                case 2:
                    Outputmark.outputData();
                    break;
                case 3:
                    Outputmark.update();
                    break;
                case 4:
                    Outputmark.delete();
                    break;
                case 5:
                    Outputmark.outputMark();
                    break;
            }
        }while (true);

    }
}
