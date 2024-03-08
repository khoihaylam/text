package a.business.entity;
import ra.business.design.StudentImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student implements StudentImpl {
    private int studentId;
    private String studentName;
    private String birthdate;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
    }

    public Student(int studentId, String studentName, String birthdate, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.studentId = inputstudentId();
        this.studentName = inputstudentName(scanner);
        this.birthdate = inputbirthdate(scanner);
        this.address = inputAdress(scanner);
        this.gender=inputGender(scanner);
        this.phone = inputPhone(scanner);

    }

    public int inputstudentId() {
        int max;
        if (Outputstudent.arrStudent.size() == 0) {
            max = 0;
        } else {
            max = Outputstudent.arrStudent.get(0).getStudentId();
            for (int i = 0; i < Outputstudent.arrStudent.size(); i++) {
                if (Outputstudent.arrStudent.get(i).getStudentId() > max) {
                    max = Outputstudent.arrStudent.get(i).getStudentId();
                }
            }
        }
        return max + 1;
    }

    public String inputstudentName(Scanner scanner) {
        scanner.nextLine();
        do {
            System.out.println("nhap ten sinh vien");
            String studentName = scanner.nextLine();
            if (studentName.length() != 0) {
                return studentName;
            } else {
                System.err.println("ten khong duoc bo trong");
            }
        } while (true);
    }

    public String inputbirthdate(Scanner scanner) {
        System.out.println("moi ban nhap ngay sinh chua bạn");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                Date birthdate = sdf.parse(scanner.nextLine());
                return sdf.format(birthdate);

            } catch (Exception ex) {
                System.err.println("dinh dang phai dd/mm/yyyy");
            }
        } while (true);
    }

    public String inputAdress(Scanner scanner) {
        scanner.nextLine();
        do {
            String address = scanner.nextLine();
            if (address.length() != 0) {
                return address;
            } else {
                System.err.println("dia chỉ khong duoc bo trong");
            }
        } while (true);
    }

    public String inputPhone(Scanner scanner) {
        scanner.nextLine();
        System.out.println("moi ban nhap so dien thoại:");
        do {
            String phone = scanner.nextLine();
            if (phone.length() == 10 || phone.length() == 11) {
                if (phone.charAt(0) == '0') {
                    boolean check = false;
                    for (int i = 0; i < Outputstudent.arrStudent.size(); i++) {
                        if (Outputstudent.arrStudent.get(i).getPhone().equals(phone)) {
                            check = true;
                        }
                    }
                    if (check) {
                        System.err.println("da ton tai sdt");
                    } else {
                        return phone;
                    }
                } else {
                    System.err.println("sdt bat dau chu so 0");
                }

            } else {
                System.err.println("sdt bat dau chua 10-11 ký tự");
            }

        } while (true);
    }

    public boolean inputGender(Scanner scanner) {
        System.out.println("moi ban nhap giới tính");
        do {
        String gender = scanner.nextLine();
        if (gender.equals("true") || gender.equals("false")) {
            return Boolean.parseBoolean(gender);
        } else {
            System.err.println("chi nhap true hoac false");
        }
    }while(true);
    }
    @Override
    public void outputData() {
        System.out.printf("%5d %5s %5s %5s %5s %5s\n",this.studentId,this.studentName,this.birthdate,this.address,(this.gender)?"nam":"nữ",this.phone);
    }
}
