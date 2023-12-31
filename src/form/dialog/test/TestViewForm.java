/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.test;

import form.dialog.pitanje.PitanjaForm;
import components.MyTestTableModel;
import domain.Odgovor;
import domain.Pitanje;
import domain.PitanjeTest;
import domain.Test;
import form.util.FormView;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import session.LocalStorage;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import communication.*;
import controller.Communication;

/**
 *
 * @author Vuk
 */
public class TestViewForm extends javax.swing.JDialog {

    /**
     * Creates new form TestViewForm
     */
    
    private final int mode;
    private LocalStorage localStorage = LocalStorage.getInstance();
    
    public TestViewForm(java.awt.Frame parent, boolean modal,int mode) {
        super(parent, modal);
        initComponents();
        this.mode = mode;
        populateForm();
        populateTable();
        
        tblTest.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int selectedRow = tblTest.getSelectedRow();
                int selectedColumn = tblTest.getSelectedColumn();
                
                if(selectedColumn==3){
                    Test t = ((MyTestTableModel)tblTest.getModel()).getTestovi().get(selectedRow);
                    localStorage.addItemsInHashMap("Test", t);
                    PitanjaForm pitanjaForm = new PitanjaForm(null,true,FormView.FORM_VIEW_MODE);
                    pitanjaForm.setTitleForTest("Pitanja za test pod nazivom: " + t.getNaziv());
                    pitanjaForm.setVisible(true);
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTest = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnModel = new javax.swing.JButton();
        btnUcitaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretrazi testove po autoru");

        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });
        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFilterKeyPressed(evt);
            }
        });

        tblTest.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTest);

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnModel.setText("Prikazi model testa");
        btnModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelActionPerformed(evt);
            }
        });

        btnUcitaj.setText("Ucitaj");
        btnUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnUcitaj, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnModel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnIzbrisi)
                    .addComponent(btnModel)
                    .addComponent(btnUcitaj))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTest.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita test");
        }
        else{ 
            int option = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete test?");
            if(option==0){
                Test test = ((MyTestTableModel)tblTest.getModel()).getTestovi().get(selectedRow);
                izbrisiTest(test);
            }
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtFilterActionPerformed

    private void txtFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyPressed
        // TODO add your handling code here:
        MyTestTableModel myTestTableModel = (MyTestTableModel)tblTest.getModel();
        List<Test> testovi = myTestTableModel.getTestovi();
        List<Test> noviTestovi;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            noviTestovi = nadjiTestove(txtFilter.getText(),testovi);
            if(!noviTestovi.isEmpty()){
                tblTest.setModel(new MyTestTableModel(noviTestovi));
                JOptionPane.showMessageDialog(this, "Sistem je nasao testove po zadatoj vrednosti");
            }
            else{
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje testove po zadatoj vrednosti");
            }
        }

    }//GEN-LAST:event_txtFilterKeyPressed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTest.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita test");
        }
        else{
            JOptionPane.showMessageDialog(this, "Sistem je ucitao test");
            List<Test> testovi = ((MyTestTableModel) tblTest.getModel()).getTestovi();
            Test test = testovi.get(selectedRow);
            
            localStorage.addItemsInHashMap("Test", test);
            TestForm testForm = new TestForm(null,true,FormView.FORM_EDIT_MODE);
            testForm.setVisible(true);
            
            populateTable();
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTest.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita test");
        }
        else{
            JOptionPane.showMessageDialog(this,"Sistem je ucitao test");
            List<Test> testovi = ((MyTestTableModel) tblTest.getModel()).getTestovi();
            Test test = testovi.get(selectedRow);
            
            localStorage.addItemsInHashMap("Test", test);
            TestModel testModel = new TestModel(null,true);
            testModel.setVisible(true);
            
        }
    }//GEN-LAST:event_btnModelActionPerformed

    private void btnUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblTest.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita test");
        }
        else{
            JOptionPane.showMessageDialog(this,"Sistem je ucitao test");
            List<Test> testovi = ((MyTestTableModel) tblTest.getModel()).getTestovi();
            Test test = testovi.get(selectedRow);
            
            localStorage.addItemsInHashMap("Test", test);
            TestForm testForm = new TestForm(null,true,FormView.FORM_VIEW_MODE);
            testForm.setVisible(true);
            populateTable();
        }
    }//GEN-LAST:event_btnUcitajActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnModel;
    private javax.swing.JButton btnUcitaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTest;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

    

    private void populateForm() {
        btnIzmeni.setVisible(true);
        btnIzbrisi.setVisible(true);
        btnModel.setVisible(true);
        btnUcitaj.setVisible(true);
        
    }

    private void populateTable() {
        try {
            List<Test> testovi = (List<Test>)Communication.getInstance().getTests();
            List<Odgovor> odgovori = (List<Odgovor>)Communication.getInstance().getOdgovore();
            System.out.println(odgovori);
            List<PitanjeTest> pitanjaTest = (List<PitanjeTest>)Communication.getInstance().getPitanjaTest();
            
            for(Test test:testovi){
                List<Pitanje> pitanja = new ArrayList<>();
                for(PitanjeTest pt:pitanjaTest){
                    if(Objects.equals(test.getTestId(), pt.getTest().getTestId())){
                        pitanja.add(pt.getPitanje());
                    }
                }
                test.setPitanja(pitanja);
            }
            
            for(Test test:testovi){
                for(Pitanje pitanje:test.getPitanja()){
                    List<Odgovor> noviOdgovori = new ArrayList<>();
                    for(Odgovor odgovor: odgovori){
                        if(odgovor.getPitanje().getPitanjeId().equals(pitanje.getPitanjeId())){
                            noviOdgovori.add(odgovor);
                        }
                    }
                    
                    pitanje.setOdgovori(noviOdgovori);
                }
            }
            
            tblTest.setModel(new MyTestTableModel(testovi));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }   

    private List<Test> nadjiTestove(String text, List<Test> testovi) {
        List<Test> nadjeniTestovi = new ArrayList<>();
        for(Test test:testovi){
            if(text.equals(test.getAutor())){
                nadjeniTestovi.add(test);
            }
        }
        
        return nadjeniTestovi;
    }

    private void izbrisiTest(Test test) {
        try {
            MyTestTableModel myTestTableModel = (MyTestTableModel)tblTest.getModel();
            if(Communication.getInstance().deleteTest(test)){
                JOptionPane.showMessageDialog(this, "Sistem je izbrisao test");
                myTestTableModel.remove(test);
            }
            else{
                JOptionPane.showMessageDialog(this, "Sistem ne moze da izbrise test");
                populateTable();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
