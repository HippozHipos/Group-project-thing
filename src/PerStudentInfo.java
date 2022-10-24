import java.util.ArrayList;

public class PerStudentInfo {
    public static class ModuleMarks{
        ModuleMarks(String module, String marks){
            this.module = module;
            this.marks = marks;
        }
        public String module;
        public String marks;
    }

    public int studentRegNo = 0;
    public String course = "";

    void AddModuleMarks(ModuleMarks name){
        m_Modules.add(name);
    }

    int NoModules(){
        return m_Modules.size();
    }

    ModuleMarks GetModuleMarks(int i){
        return m_Modules.get(i);
    }

    private ArrayList<ModuleMarks> m_Modules = new ArrayList<ModuleMarks>();
}
