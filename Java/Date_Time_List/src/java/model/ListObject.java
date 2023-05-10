/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sindicato
 */
public class ListObject {
    
    private int idTest;
    private String objectTest;

    public ListObject() {
    }

    public ListObject(int idTest, String objectTest) {
        this.idTest = idTest;
        this.objectTest = objectTest;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getObjectTest() {
        return objectTest;
    }

    public void setObjectTest(String objectTest) {
        this.objectTest = objectTest;
    }
    
}
