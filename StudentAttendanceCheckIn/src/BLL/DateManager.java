/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Dato;
import BE.Student;
import BLL.Exceptions.BllException;
import DAL.DateDAO;
import DAL.DateInterface;
import DAL.Exceptions.DalException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author KristianUrup
 */
public class DateManager {

    DateInterface ddao;

    public DateManager() {
        ddao = new DateDAO();
    }

    /**
     * Gets all the dates from the SchoolDates table
     * 
     * @return List of Dates
     * @throws BllException 
     */
    public List<Dato> getAllDates() throws BllException {
        try {
            return ddao.getAllDates();
        } catch (DalException ex) {
            throw new BllException(ex.getMessage());
        }
    }

    /**
     * Updates the absence of a specific student
     * 
     * @param studentID
     * @param date
     * @param isAbsence
     * @throws BllException 
     */
    public void updateAbsence(int studentID, Date date, boolean isAbsence) throws BllException {
        try {
            ddao.updateAbsence(studentID, date, isAbsence);
        } catch (DalException ex) {
            throw new BllException(ex.getMessage());
        }
    }
    
    /**
     * Gets a students absence of the day today
     * true if absent
     * 
     * @param studentID
     * @return student absence of the day
     * @throws BllException 
     */
    public boolean isStudentAbsence(int studentID) throws BllException {
        try {
            return ddao.isStudentAbsence(studentID);
        } catch (DalException ex) {
            throw new BllException(ex.getMessage());
        }
    }

    /**
     * Get all the dates of that the student is absent
     * 
     * @param studentID
     * @return List of dates
     * @throws BllException 
     */
    public List<Dato> getStudentAbsenceDates(int studentID) throws BllException {
        try {
            return ddao.getStudentAbsenceDates(studentID);
        } catch (DalException ex) {
            throw new BllException(ex.getMessage());
        }
    }

    /**
     * Calculates the absence for a single student
     * 
     * @param studentID
     * @return The calculated absence
     * @throws BllException 
     */
    public double absenseCalculator(int studentID) throws BllException {
        double absencePercentage = 0;
        try {
            List<Dato> tmp = new ArrayList();
            List<Dato> list = ddao.getStudentAbsenceDates(studentID);
            for (Dato dato : list) {
                if (dato.getIsAbsent() == true) {
                    tmp.add(dato);
                }
            }

            double totalDays = list.size();
            double absentDays = tmp.size();

            absencePercentage = (absentDays / totalDays) * 100;

            return formatCalculatedAbsence(absencePercentage);
        } catch (DalException ex) {
            throw new BllException("Could not calculate absence");
        }
    }

    /**
     * formats the absence so it onlt has two decimals
     * 
     * @param absence
     * @return 
     */
    private double formatCalculatedAbsence(double absence) {
        NumberFormat nf = new DecimalFormat("#0.00");
        String formatPercentage = nf.format(absence);
        return Double.parseDouble(formatPercentage.replace(",", "."));
    }

    /**
     * Updates the day which is most absent after a day where a student is absent
     * 
     * @param student
     * @return 
     * @throws BllException 
     */
    public String updateMostDayAbsent(Student student) throws BllException {
        try {
            int amountOfDaysAbsence = -1;
            String dayMostAbsent = "no day";
            HashMap<String, Integer> days = new HashMap<>();
            List<Dato> datoList = ddao.getStudentAbsenceDates(student.getId());
            for (Dato dato : datoList) {
                if (dato.getIsAbsent()) {
                    if (days.containsKey(dato.getDay())) {
                        days.replace(dato.getDay(), days.get(dato.getDay()) + 1);
                    } else {
                        days.put(dato.getDay(), 1);
                    }
                }
            }

            if (!days.isEmpty()) {
                for (String day : days.keySet()) {
                    if (days.get(day) > amountOfDaysAbsence) {
                        amountOfDaysAbsence = days.get(day);
                        dayMostAbsent = day;
                    }
                }
            }
            
            student.setDayMostAbsent(dayMostAbsent);
            ddao.updateMostDayAbsent(student);
            
            return dayMostAbsent;
        } catch (DalException ex) {
            throw new BllException(ex.getMessage());
        }
    }
}
