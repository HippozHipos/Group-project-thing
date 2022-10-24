import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        reader.ReadFile("src/Datafile.csv", perStudentInfoList);

        for (PerStudentInfo psi : perStudentInfoList){
            System.out.print("Reg no: ");  System.out.print(psi.studentRegNo); System.out.println();
            System.out.print("Course: ");  System.out.print(psi.course); System.out.println();
            System.out.println("Module with marks: ");
            for (int i = 0; i < psi.NoModules(); i++) {
                PerStudentInfo.ModuleMarks mm = psi.GetModuleMarks(i);
                System.out.print("Module: ");  System.out.print(mm.module);  System.out.print(", ");
                System.out.print("Marks: ");  System.out.print(mm.marks);  System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

    static StudentInfoReader reader = new StudentInfoReader();
    static ArrayList<PerStudentInfo> perStudentInfoList = new ArrayList<PerStudentInfo>();

}