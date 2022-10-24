import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CSVParser{
    List<String> ParseLine(String line){
        String token = new String();
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < line.length(); i++){
            char currChar = line.charAt(i);
            if (currChar == ',') {
                tokens.add(token.strip());
                token = "";
                continue;
            }
            token += currChar;
            if (i == line.length() - 1){
                tokens.add(token);
            }
        }
        return tokens;
    }
}
public class StudentInfoReader {
    void ReadFile(String fileName, ArrayList<PerStudentInfo> studentInfo){
        try {
            boolean headerLine = true;
            List<String> header = new ArrayList<>();
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (headerLine) {
                    headerLine = false;
                    header = m_Parser.ParseLine(line);
                    continue;
                }
                PerStudentInfo info = new PerStudentInfo();
                List<String> tokens = m_Parser.ParseLine(line);
                int i = 0;
                info.studentRegNo = Integer.valueOf(tokens.get(i++));
                info.course = tokens.get(i++);
                for (; i < tokens.size(); i++){
                    if (tokens.get(i) != "")
                        info.AddModuleMarks(new PerStudentInfo.ModuleMarks(header.get(i), tokens.get(i)));
                }
                studentInfo.add(info);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private CSVParser m_Parser = new CSVParser();
    private static final int headerRegIndex = 0;
    private static final int headerCourseIndex = 1;
}
