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
public class Odgovor implements GenericEntity{
    private Integer odgovorId;
    private String sadrzaj;
    private Boolean resenje;
    private Pitanje pitanje;

    public Odgovor() {
    }

    public Odgovor(Integer odgovorId, String sadrzaj, Boolean resenje, Pitanje pitanje) {
        this.odgovorId = odgovorId;
        this.sadrzaj = sadrzaj;
        this.resenje = resenje;
        this.pitanje = pitanje;
    }

    public Integer getOdgovorId() {
        return odgovorId;
    }

    public void setOdgovorId(Integer odgovorId) {
        this.odgovorId = odgovorId;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Boolean getResenje() {
        return resenje;
    }

    public void setResenje(Boolean resenje) {
        this.resenje = resenje;
    }

    @Override
    public String toString() {
        return getSadrzaj();
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    @Override
    public String getTableName() {
        return "odgovor";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "odgovorId,sadrzaj,resenje,pitanjeId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(odgovorId).append(",")
                .append("'").append(sadrzaj).append("',")
                .append(resenje).append(",")
                .append(pitanje.getPitanjeId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public void setId(Integer id) {
        setOdgovorId(id);
    }

    @Override
    public String getWhereCondition(Object object) {
        return "o.odgovorId="+((Odgovor)object).getOdgovorId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Odgovor(rs.getInt("odgovorId"),rs.getString("sadrzajOdgovor"),rs.getBoolean("resenje"),new Pitanje(rs.getInt("pitanjeId"),rs.getString("sadrzaj")));
    }

    @Override
    public String getSelectValues() {
        return "SELECT o.odgovorId,o.sadrzaj AS sadrzajOdgovor,o.resenje,o.pitanjeId, p.pitanjeId,p.sadrzaj FROM odgovor AS o INNER JOIN pitanje AS p ON o.pitanjeId = p.pitanjeId";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Odgovor odgovor = (Odgovor)object;
        return "sadrzaj="+"'"+odgovor.getSadrzaj()+"'"+", resenje="+odgovor.getResenje()+", pitanjeId="+odgovor.getPitanje().getPitanjeId();
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "odgovorId="+((Odgovor)object).getOdgovorId();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(odgovorId).append(",")
                .append(pitanje.getPitanjeId());
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "odgovorId,pitanjeId";
    }


    
    
}
