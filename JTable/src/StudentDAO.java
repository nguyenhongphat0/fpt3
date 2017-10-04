
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phat
 */
public class StudentDAO {
    public List<StudentDTO> list = null;
    
    public StudentDAO() {
    }
    
    public void loadData(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File f = new File(fileName);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            list = new ArrayList<>();
            String detail;
            while ((detail = br.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(detail, "-");
                StudentDTO sdto = new StudentDTO(stk.nextToken(), stk.nextToken(), stk.nextToken());
                list.add(sdto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addDTO(StudentDTO dto) {
        list.add(dto);        
    }
    
    public boolean saveToDatabase(String filename) {
        File f = new File(filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
            for (StudentDTO dto : list) {
                pw.println(dto.getId() + "-" + dto.getName() + "-" + dto.getRoom());
            }
        } catch (FileNotFoundException ex) {
            return false;
        } finally {
            if (pw != null) pw.close();
        }
        
        return true;
    }
}
