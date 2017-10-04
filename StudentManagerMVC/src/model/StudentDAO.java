package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    public StudentDAO() {
    }
    
    public ArrayList<StudentDTO> loadFromDatabase(String filename) {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<StudentDTO> list = new ArrayList<>();
        try {
            File f = new File(filename);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            list = new ArrayList<>();
            String detail;
            while ((detail = br.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(detail, "-");
                StudentDTO sdto = new StudentDTO(stk.nextToken(), stk.nextToken(), stk.nextToken());
                list.add(sdto);
            }
        } catch (IOException e) {
            System.out.println("Error happened!");
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public boolean saveToDatabase(String filename, ArrayList<StudentDTO> list) {
        File f = new File(filename);
        try (PrintWriter pw = new PrintWriter(f)) {
            list.forEach((dto) -> {
                pw.println(dto.getId() + "-" + dto.getName() + "-" + dto.getRoom());
            });
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
    
    public StudentDTO searchByID(String filename, String id) {
        FileReader fr = null;
        BufferedReader br = null;
        StudentDTO dto = null;
        try {
            File f = new File(filename);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {                
                StringTokenizer stk = new StringTokenizer(detail, "-");
                String code = stk.nextToken();
                if (code.equals(id)) return new StudentDTO(code, stk.nextToken(), stk.nextToken());
            }
        } catch (IOException e) {
            System.out.println("Error happened!");
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public boolean removeRecord(ArrayList<StudentDTO> list, String code) {
        for (int i = 0; i < list.size(); i++) 
            if (list.get(i).getId().equals(code)) {
                list.remove(i);
                return true;
            }
        return false;
    }
    
    public void addRecord(ArrayList<StudentDTO> list, StudentDTO dto) {
        list.add(dto);
    }
    
    public boolean updateRecord(ArrayList<StudentDTO> list, String code, StudentDTO newDto) {
        for (StudentDTO e : list)
        if (e.getId().equals(code)) {
            e.setName(newDto.getName());
            e.setRoom(newDto.getRoom());
            return true;
        }
        return false;
    }
}
