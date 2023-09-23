/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Vuk
 */
public class RezultatPolaganja implements GenericEntity{
    private Integer id;
    private Student student;
    private Polaganje polaganje;
    private Integer brojPoena;
    private Integer ocena;

    public RezultatPolaganja() {
    }

    public RezultatPolaganja(Student student, Polaganje polaganje, Integer brojPoena, Integer ocena) {
        this.student = student;
        this.polaganje = polaganje;
        this.brojPoena = brojPoena;
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Polaganje getPolaganje() {
        return polaganje;
    }

    public void setPolaganje(Polaganje polaganje) {
        this.polaganje = polaganje;
    }
    
    public Integer getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(Integer brojPoena) {
        this.brojPoena = brojPoena;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "RezultatPolaganja{" + "studentId=" + student.getId() + ", polaganjeId=" + polaganje.getPolaganjeId() + ", brojPoena=" + brojPoena + ", ocena=" + ocena + '}';
    }

    @Override
    public String getTableName() {
        return "rezultatpolaganja";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "studentId,polaganjeId,brojPoena,ocena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getId()).append(",")
                .append(polaganje.getPolaganjeId()).append(",")
                .append(brojPoena).append(",")
                .append(ocena);
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
        return "rp.studentId="+((RezultatPolaganja)object).getStudent().getId() + " AND rp.polaganjeId="+((RezultatPolaganja)object).getPolaganje().getPolaganjeId();
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setId(rs.getInt("studentId"));
        s.setBrojIndeksa(rs.getString("brojIndeksa"));
        s.setIme(rs.getString("ime"));
        s.setPrezime(rs.getString("prezime"));
        s.setDatumRodjenja(rs.getDate("datumRodjenja").toLocalDate());
        s.setPol(Pol.valueOf(rs.getString("pol")));
        
        Test test = new Test();
        test.setTestId(rs.getInt("testId"));
        test.setNaziv(rs.getString("nazivTesta"));
        test.setAutor(rs.getString("autor"));
        test.setMaxBrojPoena(rs.getInt("maxBrojPoena"));
        
        Polaganje p = new Polaganje();
        p.setPolaganjeId(rs.getInt("polaganjeId"));
        p.setNaziv(rs.getString("nazivPolaganja"));
        p.setNazivSale(rs.getString("nazivSale"));
        p.setDatum(rs.getDate("datum").toLocalDate());
        p.setTest(test);
        
        return new RezultatPolaganja(s,p,rs.getInt("brojPoena"),rs.getInt("ocena"));
    }

    @Override
    public String getSelectValues() {
        return "SELECT rp.studentId,rp.polaganjeId,rp.brojPoena,rp.ocena,s.id,s.brojIndeksa,s.ime,s.prezime,s.pol,s.datumRodjenja,p.polaganjeId,p.naziv AS nazivPolaganja,p.datum,p.nazivSale,p.testId,t.testId,t.naziv AS nazivTesta,t.autor,t.maxBrojPoena FROM rezultatpolaganja AS rp INNER JOIN student AS s ON rp.studentId=s.id INNER JOIN polaganje AS p ON rp.polaganjeId=p.polaganjeId INNER JOIN test t ON p.testId = t.testId";
    }

    @Override
    public String getUpdateSetValues(Object object) {
        RezultatPolaganja rp = (RezultatPolaganja)object;
        return "brojPoena="+rp.getBrojPoena()+", ocena="+rp.getOcena();
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "studentId="+((RezultatPolaganja)object).getStudent().getId() + " AND polaganjeId="+((RezultatPolaganja)object).getPolaganje().getPolaganjeId();
    }

    @Override
    public String getCreateInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(student.getId()).append(",")
                .append(polaganje.getPolaganjeId());
        return sb.toString();
    }

    @Override
    public String getColumnNamesForCreate() {
        return "studentId,polaganjeId";
    }

    
}
