/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Vuk
 */
public class Polaganje implements GenericEntity{
    private Integer polaganjeId;
    private String naziv;
    private LocalDate datum;
    private String nazivSale;
    private Test test;
    private List<Student> studenti;

    public Polaganje() {
    }

    public Polaganje(Integer polaganjeId, String naziv, LocalDate datum, String nazivSale) {
        this.polaganjeId = polaganjeId;
        this.naziv = naziv;
        this.datum = datum;
        this.nazivSale = nazivSale;
    }

    public Integer getPolaganjeId() {
        return polaganjeId;
    }

    public void setPolaganjeId(Integer polaganjeId) {
        this.polaganjeId = polaganjeId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }
    
    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String getTableName() {
        return "polaganje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "polaganjeId,naziv,datum,nazivSale,testId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(polaganjeId).append(",")
                .append("'").append(naziv).append("',")
                .append("'").append(datum.toString()).append("',")
                .append("'").append(nazivSale).append("', ")
                .append(test.getTestId());
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        setPolaganjeId(id);
    }

    @Override
    public String getWhereCondition(Object object) {
        return "p.polaganjeId="+((Polaganje)object).getPolaganjeId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Polaganje polaganje = new Polaganje(rs.getInt("polaganjeId"),rs.getString("nazivPolaganja"),rs.getDate("datum").toLocalDate(),rs.getString("nazivSale"));
        Test test = new Test();
        test.setTestId(rs.getInt("testId"));
        test.setNaziv(rs.getString("naziv"));
        test.setAutor(rs.getString("autor"));
        test.setMaxBrojPoena(rs.getInt("maxBrojPoena"));
        
        polaganje.setTest(test);
        return polaganje;
    }

    @Override
    public String getSelectValues() {
        return "SELECT p.polaganjeId,p.naziv AS nazivPolaganja,p.datum,p.nazivSale,p.testId,t.testId,t.naziv,t.autor,t.maxBrojPoena FROM polaganje AS P INNER JOIN test AS t ON p.testId = t.testId";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Polaganje polaganje = (Polaganje)object;
        return "naziv="+"'"+polaganje.getNaziv()+"'"+", datum="+"'"+polaganje.getDatum().toString()+"'"+", nazivSale="+"'"+polaganje.getNazivSale()+"'"+", testId="+polaganje.getTest().getTestId();
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "polaganjeId="+((Polaganje)object).getPolaganjeId();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(polaganjeId).append(",")
                .append("'").append(datum.toString()).append("',")
                .append(test.getTestId());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "polaganjeId,datum,testId";
    }
       
}
