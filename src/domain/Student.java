/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Vuk
 */
public class Student implements GenericEntity{
    
    private Integer id;
    private String brojIndeksa;
    private String ime;
    private String prezime;
    private Pol pol;
    private LocalDate datumRodjenja;
    private List<Polaganje> polaganja;

    public Student() {
    }

    public Student(Integer id,String brojIndeksa, String ime, String prezime,Pol pol, LocalDate datumRodjenja) {
        this.id = id;
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public List<Polaganje> getPolaganja() {
        return polaganja;
    }

    public void setPolaganja(List<Polaganje> polaganja) {
        this.polaganja = polaganja;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getIme()+" "+getPrezime();
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,brojIndeksa,ime,prezime,pol,datumRodjenja";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(brojIndeksa).append("',")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append("'").append(pol.toString()).append("',")
                .append("'").append(datumRodjenja.toString()).append("'");
        return sb.toString();
    }

    @Override
    public String getWhereCondition(Object object) {
        return "id="+((Student)object).getId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("id"),rs.getString("brojIndeksa"),rs.getString("ime"),rs.getString("prezime"),Pol.valueOf(rs.getString("pol")),rs.getDate("datumRodjenja").toLocalDate());
    }

    @Override
    public String getSelectValues() {
        return "SELECT * FROM student";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Student student = (Student)object;
        return "brojIndeksa="+ "'"+student.getBrojIndeksa()+"'"+", ime="+"'"+student.getIme()+"'"+", prezime="+"'"+student.getPrezime()+"'"+", pol="+"'"+student.getPol().toString()+"'"+", datumRodjenja="+"'"+student.getDatumRodjenja()+"'";
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return getWhereCondition(object);
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(datumRodjenja.toString()).append("'");
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "id,datumRodjenja";
    }
}
