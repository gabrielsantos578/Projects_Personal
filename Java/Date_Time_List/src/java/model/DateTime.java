/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alunos
 */
public class DateTime {
    
    private int idTest;
    private String dateTest;
    private String timeTest;

    public DateTime() {
    }

    public DateTime(int idTest, String dateTest, String timeTest) {
        this.idTest = idTest;
        this.dateTest = dateTest;
        this.timeTest = timeTest;
    }

    /**
     * @return the idTest
     */
    public int getIdTest() {
        return idTest;
    }

    /**
     * @param idTest the idTest to set
     */
    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    /**
     * @return the dateTest
     */
    public String getDateTest() {
        return dateTest;
    }

    /**
     * @param dateTest the dateTest to set
     */
    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    /**
     * @return the timeTest
     */
    public String getTimeTest() {
        return timeTest;
    }

    /**
     * @param timeTest the timeTest to set
     */
    public void setTimeTest(String timeTest) {
        this.timeTest = timeTest;
    }
    
    
    
}
