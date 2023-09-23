/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.polaganje;

import components.MyStudentTableModel;
import domain.Polaganje;
import domain.RezultatPolaganja;
import domain.Student;
import domain.Test;
import form.dialog.student.StudentViewForm;
import form.util.FormView;
import form.util.ViewForm;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import session.LocalStorage;
import controller.Communication;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Vuk
 */
public class PolaganjeForm extends javax.swing.JDialog  implements ViewForm{

    /**
     * Creates new form PolaganjeForm
     */
    private final LocalStorage localStorage = LocalStorage.getInstance();
    private int model  = -1;
    public static boolean visibility = false;
    
    public PolaganjeForm(java.awt.Frame parent, boolean modal,int model) {
        super(parent, modal);
        initComponents();
        this.model = model;
        populateForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbDan = new javax.swing.JComboBox<>();
        cmbMesec = new javax.swing.JComboBox<>();
        cmbGodina = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNazivSale = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTest = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudenti = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        lblErrorNaziv = new javax.swing.JLabel();
        lblErrorNazivSale = new javax.swing.JLabel();
        btnUbaci = new javax.swing.JButton();
        btnIzbaci = new javax.swing.JButton();
        btnIzmena = new javax.swing.JButton();
        lblErrorTest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("jLabel1");

        jLabel1.setText("Id:");

        txtId.setEditable(false);

        jLabel2.setText("Naziv:");

        jLabel3.setText("Datum:");

        cmbDan.setEditable(true);
        cmbDan.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        cmbDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDanActionPerformed(evt);
            }
        });

        cmbMesec.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        cmbGodina.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jLabel4.setText("Naziv sale:");

        jLabel5.setText("Test: ");

        cmbTest.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        tblStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStudenti);

        jLabel6.setText("Studenti:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblErrorNaziv.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblErrorNaziv.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNaziv.setText("jLabel7");

        lblErrorNazivSale.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblErrorNazivSale.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorNazivSale.setText("jLabel7");

        btnUbaci.setText("Ubaci studenta");
        btnUbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbaciActionPerformed(evt);
            }
        });

        btnIzbaci.setText("Izbaci studenta");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        btnIzmena.setText("Omoguci izmenu");
        btnIzmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaActionPerformed(evt);
            }
        });

        lblErrorTest.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblErrorTest.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorTest.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUbaci)
                                .addGap(18, 18, 18)
                                .addComponent(btnIzbaci, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIzmena)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblErrorNaziv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblErrorNazivSale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtNazivSale, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cmbDan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cmbMesec, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13, 13, 13))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(12, 12, 12))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblErrorTest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(130, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addComponent(lblErrorNaziv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMesec, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(cmbDan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNazivSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorNazivSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblErrorTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIzmena, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUbaci)
                            .addComponent(btnIzbaci))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
        setErrors();
        try {
            Polaganje polaganje = zapamtiPolaganje((Polaganje) localStorage.getItemFromHashMap("Polaganje"));
            Object object = Communication.getInstance().updatePolaganje(polaganje);
            if (!(object instanceof String)) {
                if ((boolean) object) {
                    RezultatPolaganja rp = new RezultatPolaganja();
                    for (Student student : polaganje.getStudenti()) {
                        rp.setPolaganje(polaganje);
                        rp.setStudent(student);
                        rp.setBrojPoena(0);
                        rp.setOcena(5);
                        object = Communication.getInstance().addRezultatPolaganja(rp);
                        if (!(object instanceof String)) {
                            if((boolean)object){
                                System.out.println("Student je dodat u polaganje");
                            }
                            else{
                                System.out.println("Student je ubacen u dato polaganje");
                            }
                        } else {
                            System.out.println((String)object);
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio polaganje");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti polaganje");
                }
            } else {
                setTextErrors((String)object);
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti polaganje");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnUbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbaciActionPerformed
        // TODO add your handling code here:
        StudentViewForm studentDialog = new StudentViewForm(null,true,FormView.FORM_MODEL_GET_STUDENTS_MODE);
        studentDialog.setVisible(true);
        
        List<Student> students = (List<Student>) localStorage.getItemFromHashMap("Studenti");
        List<Student> studentsTable = ((MyStudentTableModel)tblStudenti.getModel()).getStudents();
        
        boolean flag;
        for(Student student:students){
            flag = true;
            for(Student studentTable:studentsTable){
                if(student.getId().equals(studentTable.getId())){
                    flag = false;
                }
            }
            if(flag){
                studentsTable.add(student);
            }
        }
        tblStudenti.setModel(new MyStudentTableModel(studentsTable));
  
    }//GEN-LAST:event_btnUbaciActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = tblStudenti.getSelectedRows();
        if(selectedRows.length==0){
            JOptionPane.showMessageDialog(this, "Niste izabrali studenta");
        }
        else{
            MyStudentTableModel myStudentTableModel = (MyStudentTableModel)tblStudenti.getModel();
            List<Student> students = myStudentTableModel.getStudents();
            for(int i=0;i<selectedRows.length;i++){      
                try {
                    int polaganjeId = Integer.parseInt(txtId.getText());
                    RezultatPolaganja rp = new RezultatPolaganja();
                    
                    Polaganje polaganje = new Polaganje();
                    polaganje.setPolaganjeId(polaganjeId);
                    Student student = new Student();
                    student.setId(students.get(selectedRows[i]).getId());
                    rp.setPolaganje(polaganje);
                    rp.setStudent(student);
                    rp.setBrojPoena(0);
                    rp.setOcena(5);
                    if(Communication.getInstance().deleteRezultatPolaganja(rp)){
                        myStudentTableModel.remove(students.get(selectedRows[i]));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }        
        }
    }//GEN-LAST:event_btnIzbaciActionPerformed

    private void cmbDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDanActionPerformed

    private void btnIzmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaActionPerformed
        // TODO add your handling code here:
        prepareEditForm();
        this.model = FormView.FORM_EDIT_MODE;
    }//GEN-LAST:event_btnIzmenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnIzmena;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUbaci;
    private javax.swing.JComboBox<Integer> cmbDan;
    private javax.swing.JComboBox<Integer> cmbGodina;
    private javax.swing.JComboBox<Integer> cmbMesec;
    private javax.swing.JComboBox<Test> cmbTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorNaziv;
    private javax.swing.JLabel lblErrorNazivSale;
    private javax.swing.JLabel lblErrorTest;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblStudenti;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtNazivSale;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        try {
            List<Student> studenti = (List<Student>) Communication.getInstance().getStudents();
            tblStudenti.setModel(new MyStudentTableModel(studenti));
            List<Test> testovi = (List<Test>) Communication.getInstance().getTests();
            
            cmbTest.setModel(new DefaultComboBoxModel(testovi.toArray()));          
            cmbTest.setSelectedIndex(-1);
            
            for(int i=1;i<=31;i++){
                cmbDan.addItem(i);
            }
            cmbDan.setSelectedIndex(20);
            
            for(int i=1;i<=12;i++){
                cmbMesec.addItem(i);
            }
            cmbMesec.setSelectedIndex(5);
            for(int i=1900;i<=2023;i++){
                cmbGodina.addItem(i);
            }
            cmbGodina.setSelectedIndex(40);
            
            if(model==FormView.FORM_ADD_MODE){
                if(kreirajPolaganje()){
                    prepareAddForm();
                }
                else{
                    visibility = false;
                }
            }
            else if(model==FormView.FORM_VIEW_MODE){
                prepareViewForm();
                Polaganje polaganje = (Polaganje) localStorage.getItemFromHashMap("Polaganje");
                ucitaj(polaganje);
            }
            else if(model==FormView.FORM_EDIT_MODE){
                prepareEditForm();
                Polaganje polaganje = (Polaganje) localStorage.getItemFromHashMap("Polaganje");
                ucitaj(polaganje);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private boolean kreirajPolaganje() {
        try {
            Polaganje p = new Polaganje();
            p.setDatum(LocalDate.now());
            p.setNaziv("");
            p.setNazivSale("");
            p.setTest(new Test());
            Polaganje polaganje = (Polaganje) Communication.getInstance().createPolaganje(p);
            if(polaganje==null){
                JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira polaganje");
                return false;
            }
            else{
                txtId.setText(Integer.toString(polaganje.getPolaganjeId()));
                localStorage.addItemsInHashMap("Polaganje", polaganje);
                JOptionPane.showMessageDialog(this, "Sistem je kreirao polaganje");
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }

    private Polaganje zapamtiPolaganje(Polaganje polaganje) {
        String naziv = txtNaziv.getText();
        int dan = (int) cmbDan.getSelectedItem();
        int mesec = (int) cmbMesec.getSelectedItem();
        int godina = (int) cmbGodina.getSelectedItem();
        
        LocalDate datum = LocalDate.of(godina, mesec, dan);
        
        String nazivSale = txtNazivSale.getText();
        Test test = (Test) cmbTest.getSelectedItem();
     
        int[] selectedRows = tblStudenti.getSelectedRows();
        
        List<Student> studenti = new ArrayList<>();
        if(model==FormView.FORM_ADD_MODE){
            for(int i=0;i<selectedRows.length;i++){
                studenti.add(((MyStudentTableModel)tblStudenti.getModel()).getStudents().get(selectedRows[i]));
            }
        }
        else{
            studenti = ((MyStudentTableModel)tblStudenti.getModel()).getStudents();
        }
        polaganje.setStudenti(studenti);
        
        polaganje.setNaziv(naziv);
        polaganje.setDatum(datum);
        polaganje.setNazivSale(nazivSale);
        polaganje.setTest(test);
        
        return polaganje;
    }

    private void ucitaj(Polaganje polaganje) {
        try {
            txtId.setText(Integer.toString(polaganje.getPolaganjeId()));
            txtNaziv.setText(polaganje.getNaziv());
            txtNazivSale.setText(polaganje.getNazivSale());
            
            LocalDate datum = polaganje.getDatum();
            int dan = datum.getDayOfMonth();
            int mesec = datum.getMonthValue();
            int godina = datum.getYear();
            
            cmbDan.setSelectedItem(dan);
            cmbMesec.setSelectedItem(mesec);
            cmbGodina.setSelectedItem(godina);
            
            List<Test> testovi = (List<Test>) Communication.getInstance().getTests();
            
            for(int i=0;i<testovi.size();i++){
                if(testovi.get(i).getNaziv().equals(polaganje.getTest().getNaziv())){
                    cmbTest.setSelectedIndex(i);
                }
            }
            
            tblStudenti.setModel(new MyStudentTableModel(polaganje.getStudenti()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    public void prepareAddForm(){
        visibility = true;
        lblTitle.setText("Kreiranje polaganja");
        setErrors();
        btnUbaci.setVisible(false);
        btnIzbaci.setVisible(false);
        btnIzmena.setVisible(false);
    }
    
    public void prepareEditForm(){
        lblTitle.setText("Izmena polaganja");
        setErrors();
        txtNaziv.setEnabled(true);
        txtNazivSale.setEnabled(true);
        cmbDan.setEnabled(true);
        cmbMesec.setEnabled(true);
        cmbGodina.setEnabled(true);
        cmbTest.setEnabled(true);
        btnSacuvaj.setVisible(true);
        btnUbaci.setVisible(true);
        btnIzbaci.setVisible(true);
        btnIzmena.setVisible(false);
    }
    
    public void prepareViewForm(){
        setErrors();
        txtNaziv.setEnabled(false);
        txtNazivSale.setEnabled(false);
        cmbDan.setEnabled(false);
        cmbMesec.setEnabled(false);
        cmbGodina.setEnabled(false);
        cmbTest.setEnabled(false);
        btnUbaci.setVisible(false);
        btnIzbaci.setVisible(false);
        btnSacuvaj.setVisible(false);
        btnIzmena.setVisible(true);
        lblTitle.setText("Prikaz polaganja");
    }

    private void setErrors() {
        lblErrorNaziv.setVisible(false);
        lblErrorNaziv.setText("");
        lblErrorNazivSale.setVisible(false);
        lblErrorNazivSale.setText("");
        lblErrorTest.setVisible(false);
        lblErrorTest.setText("");
    }

    private void setTextErrors(String string) {
        String[] arrayExceptions = string.split(",");
        if (!arrayExceptions[0].equals(" ")) {
            lblErrorTest.setVisible(true);
            lblErrorTest.setText(arrayExceptions[0]);
        }
        if (!arrayExceptions[1].equals(" ")) {
            lblErrorNazivSale.setVisible(true);
            lblErrorNazivSale.setText(arrayExceptions[1]);
        }
        if (!arrayExceptions[2].endsWith(" ")) {
            lblErrorNaziv.setVisible(true);
            lblErrorNaziv.setText(arrayExceptions[2]);
        }
    }
}