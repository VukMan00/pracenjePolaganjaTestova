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
public class Pitanje implements GenericEntity{
    private Integer pitanjeId;
    private String sadrzaj;
    private List<Odgovor> odgovori;
    private List<Test> testovi;

    public Pitanje() {
    }

    public Pitanje(Integer pitanjeId, String sadrzaj) {
        this.pitanjeId = pitanjeId;
        this.sadrzaj = sadrzaj;
    }

    public Integer getPitanjeId() {
        return pitanjeId;
    }

    public void setPitanjeId(Integer pitanjeId) {
        this.pitanjeId = pitanjeId;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public List<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }

    public List<Test> getTestovi() {
        return testovi;
    }

    public void setTestovi(List<Test> testovi) {
        this.testovi = testovi;
    }
    
    
    
    @Override
    public String toString() {
        return getSadrzaj();
    }

    @Override
    public String getTableName() {
        return "pitanje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "pitanjeId,sadrzaj";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(pitanjeId).append(",")
            .append("'").append(sadrzaj).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        setPitanjeId(id);
    }

    @Override
    public String getWhereCondition(Object object) {
        return "pitanjeId="+((Pitanje)object).getPitanjeId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Pitanje(rs.getInt("pitanjeId"),rs.getString("sadrzaj"));
    }

    @Override
    public String getSelectValues() {
        return "SELECT * FROM pitanje";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Pitanje pitanje = (Pitanje)object;
        return "sadrzaj="+"'"+pitanje.getSadrzaj()+"'";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return getWhereCondition(object);
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(pitanjeId);
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "pitanjeId";
    }

    
    
}
