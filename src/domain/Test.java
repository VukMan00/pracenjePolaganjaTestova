/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vuk
 */
public class Test implements GenericEntity{
    private Integer testId;
    private String naziv;
    private String autor;
    private Integer maxBrojPoena;
    private List<Pitanje> pitanja;

    public Test() {
    }

    public Test(Integer testId, String naziv, String autor, Integer maxBrojPoena, List<Pitanje> pitanja) {
        this.testId = testId;
        this.naziv = naziv;
        this.autor = autor;
        this.maxBrojPoena = maxBrojPoena;
        this.pitanja = pitanja;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getMaxBrojPoena() {
        return maxBrojPoena;
    }

    public void setMaxBrojPoena(Integer maxBrojPoena) {
        this.maxBrojPoena = maxBrojPoena;
    }

    public List<Pitanje> getPitanja() {
        return pitanja;
    }

    public void setPitanja(List<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }
    
    

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String getTableName() {
        return "test";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "testId,naziv,autor,maxBrojPoena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(testId).append(",")
                .append("'").append(naziv).append("',")
                .append("'").append(autor).append("',")
                .append("'").append(maxBrojPoena).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        setTestId(id);
    }

    @Override
    public String getWhereCondition(Object object) {
        return "testId="+((Test)object).getTestId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Test t = new Test();
        t.setTestId(rs.getInt("testId"));
        t.setNaziv(rs.getString("naziv"));
        t.setAutor(rs.getString("autor"));
        t.setMaxBrojPoena(rs.getInt("maxBrojPoena"));
        
        return t;
    }

    @Override
    public String getSelectValues() {
        return "SELECT * FROM test";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Test test = (Test)object;
        return "naziv="+"'"+test.getNaziv()+"'"+", autor="+"'"+test.getAutor()+"'"+", maxBrojPoena="+"'"+test.getMaxBrojPoena()+"'";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return getWhereCondition(object);
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(testId);        
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "testId";
    }
}
