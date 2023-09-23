/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vuk
 */
public class PitanjeTest implements GenericEntity{
    
    private Integer id;
    private Pitanje pitanje;
    private Test test;
    private Integer brojPoena;

    public PitanjeTest() {
    }
    
    public PitanjeTest(Pitanje pitanje, Test test, Integer brojPoena) {
        this.pitanje = pitanje;
        this.test = test;
        this.brojPoena = brojPoena;
    }
    
    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(Integer brojPoena) {
        this.brojPoena = brojPoena;
    }

    @Override
    public String toString() {
        return "PitanjeTest{" + "pitanjeId=" + pitanje.getPitanjeId() + ", testId=" + test.getTestId() + ", brojPoena=" + brojPoena + '}';
    }
    

    @Override
    public String getTableName() {
        return "pitanjeTest";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "pitanjeId,testId,brojPoena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(pitanje.getPitanjeId()).append(",")
                .append(test.getTestId()).append(",")
                .append(brojPoena);
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
       this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getWhereCondition(Object object) {
        return "pt.pitanjeId="+((PitanjeTest)object).getPitanje().getPitanjeId() + " AND pt.testId="+((PitanjeTest)object).getTest().getTestId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Pitanje pitanje = new Pitanje(rs.getInt("pitanjeId"),rs.getString("sadrzaj"));
        Test test = new Test();
        test.setTestId(rs.getInt("testId"));
        test.setNaziv(rs.getString("naziv"));
        test.setAutor(rs.getString("autor"));
        test.setMaxBrojPoena(rs.getInt("maxBrojPoena"));
        
        return new PitanjeTest(pitanje,test,rs.getInt("brojPoena"));
    }

    @Override
    public String getSelectValues() {
        return "SELECT pt.pitanjeId,pt.testId,pt.brojPoena,t.testId,t.naziv,t.autor,t.maxBrojPoena,p.pitanjeId,p.sadrzaj FROM pitanjetest AS pt INNER JOIN test AS t ON pt.testId=t.testId INNER JOIN pitanje AS p ON pt.pitanjeId=p.pitanjeId";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        PitanjeTest pt = (PitanjeTest)object;
        return "brojPoena="+pt.getBrojPoena();
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "pitanjeId="+((PitanjeTest)object).getPitanje().getPitanjeId() + " AND testId="+((PitanjeTest)object).getTest().getTestId();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(pitanje.getPitanjeId()).append(",")
                .append(test.getTestId()).append(",");
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "pitanjeId,testId";
    }
}
