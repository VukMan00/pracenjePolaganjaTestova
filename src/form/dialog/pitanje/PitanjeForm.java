/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.pitanje;

import domain.Pitanje;
import domain.Test;
import form.dialog.odgovor.OdgovorForm;
import session.LocalStorage;
import components.MyOdgovorTableModel;
import domain.Odgovor;
import domain.PitanjeTest;
import form.util.FormView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controller.Communication;
import java.io.IOException;

/**
 *
 * @author Vuk
 */
public class PitanjeForm extends javax.swing.JDialog {

    /**
     * Creates new form PitanjeForm
     */
    private LocalStorage localStorage = LocalStorage.getInstance();
    private Test test;
    private static List<Odgovor> odgovori;
    private Pitanje pitanje;
    private int mode;
    
    public PitanjeForm(java.awt.Frame parent,boolean modal,int mode) {
        super(parent, modal);
        initComponents();
        odgovori = new ArrayList<>();
        test = (Test) localStorage.getItemFromHashMap("Test");
        this.mode = mode;
        populateForm();
        populateTable();
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
        lblNazivTest = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSadrzaj = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDodajOdgovore = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdgovori = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        lblSadrzajError = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBrojPoena = new javax.swing.JTextField();
        lblBrojPoenaError = new javax.swing.JLabel();
        btnIzbaciOdgovor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kreiranje pitanja za test");

        lblNazivTest.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblNazivTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNazivTest.setText("jLabel2");

        jLabel3.setText("Sadrzaj:");

        jLabel2.setText("Dodaj odgovor:");

        btnDodajOdgovore.setText("Dodaj odgovore");
        btnDodajOdgovore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajOdgovoreActionPerformed(evt);
            }
        });

        jLabel4.setText("Odgovori:");

        tblOdgovori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblOdgovori);

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblSadrzajError.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblSadrzajError.setForeground(new java.awt.Color(255, 0, 0));
        lblSadrzajError.setText("jLabel5");

        jLabel5.setText("Id:");

        jLabel6.setText("Broj poena:");

        lblBrojPoenaError.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblBrojPoenaError.setForeground(new java.awt.Color(255, 0, 0));
        lblBrojPoenaError.setText("jLabel7");

        btnIzbaciOdgovor.setText("Izbaci odgovor");
        btnIzbaciOdgovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciOdgovorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNazivTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSadrzajError, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSadrzaj, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(44, 44, 44)
                                    .addComponent(btnDodajOdgovore, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBrojPoena, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblBrojPoenaError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzbaciOdgovor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNazivTest)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSadrzaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSadrzajError)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDodajOdgovore))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzbaciOdgovor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBrojPoena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBrojPoenaError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajOdgovoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajOdgovoreActionPerformed
        // TODO add your handling code here:
        localStorage.addItemsInHashMap("Pitanje",pitanje);
        OdgovorForm odgovorForm = new OdgovorForm(null,true,FormView.FORM_MODEL_ADD_ANSWER);
        odgovorForm.setVisible(true);
        if(pitanje.getOdgovori()!=null){
            odgovori = pitanje.getOdgovori();
        }        
        Odgovor odgovor = (Odgovor)localStorage.getItemFromHashMap("Odgovor");
        if(odgovor!=null){
            odgovori.add(odgovor);
            tblOdgovori.setModel(new MyOdgovorTableModel(odgovori));
        }
        localStorage.removeItemFromHashMap("Odgovor");
    }//GEN-LAST:event_btnDodajOdgovoreActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
        setErrors();
        try {
            String sadrzaj = txtSadrzaj.getText();
            pitanje.setSadrzaj(sadrzaj);
            pitanje.setOdgovori(odgovori);

            Object object = Communication.getInstance().updatePitanje(pitanje);
            if (!(object instanceof String)) {
                if ((boolean) object) {
                    Integer brojPoena = Integer.parseInt(txtBrojPoena.getText().trim());
                    System.out.println(brojPoena);
                    PitanjeTest pt = new PitanjeTest();
                    pt.setPitanje(pitanje);
                    pt.setTest(test);
                    pt.setBrojPoena(brojPoena);
                    boolean flag = false;
                    if (mode == FormView.FORM_ADD_MODE) {
                        object = Communication.getInstance().addPitanjeTest(pt);
                        if (!(object instanceof String)) {
                            flag = (boolean) object;
                        } else {
                            flag = false;
                            lblBrojPoenaError.setVisible(true);
                            lblBrojPoenaError.setText((String) object);
                        }
                    } else if (mode == FormView.FORM_EDIT_MODE) {
                        object = Communication.getInstance().updatePitanjeTest(pt);
                        if (!(object instanceof String)) {
                            flag = (boolean) object;
                        } else {
                            flag = false;
                            lblBrojPoenaError.setVisible(true);
                            lblBrojPoenaError.setText((String) object);
                        }
                    }

                    if (flag) {
                        localStorage.addItemsInHashMap("Pitanje", pitanje);
                        if (mode == FormView.FORM_ADD_MODE) {
                            JOptionPane.showMessageDialog(this, "Uspesno ste dodali pitanje");
                        } else if (mode == FormView.FORM_EDIT_MODE) {
                            JOptionPane.showMessageDialog(this, "Uspesno ste izmenili pitanje");
                        }
                        this.dispose();
                    } else if(mode == FormView.FORM_ADD_MODE){
                        JOptionPane.showMessageDialog(this, "Neuspesno dodavanje pitanja");
                    } else if(mode==FormView.FORM_EDIT_MODE){
                        JOptionPane.showMessageDialog(this, "Neuspesna izmena pitanja");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Neuspesno dodavanje pitanja");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Neuspesno dodavanje pitanja");
                lblSadrzajError.setVisible(true);
                lblSadrzajError.setText((String) object);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "U polje broj poena morate uneti broj!");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnIzbaciOdgovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciOdgovorActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = tblOdgovori.getSelectedRows();
        if(selectedRows.length==0){
            JOptionPane.showMessageDialog(this, "Niste izabrali odgovor");
        }
        else{
            MyOdgovorTableModel myOdgovorTableModel = (MyOdgovorTableModel)tblOdgovori.getModel();
            for(int i=0;i<selectedRows.length;i++){
                try {
                    Odgovor odgovor = myOdgovorTableModel.getOdgovori().get(selectedRows[i]);
                    Object object = Communication.getInstance().deleteOdgovor(odgovor);
                    if (!(object instanceof String)) {
                        if ((boolean) object) {
                           JOptionPane.showMessageDialog(this, "Uspesno ste izbrisali odgovor");
                            myOdgovorTableModel.remove(odgovor);
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Neuspesno brisanje odgovora");
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PitanjeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnIzbaciOdgovorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajOdgovore;
    private javax.swing.JButton btnIzbaciOdgovor;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojPoenaError;
    private javax.swing.JLabel lblNazivTest;
    private javax.swing.JLabel lblSadrzajError;
    private javax.swing.JTable tblOdgovori;
    private javax.swing.JTextField txtBrojPoena;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSadrzaj;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        test = (Test)localStorage.getItemFromHashMap("Test");
        lblNazivTest.setText(test.getNaziv());
        lblSadrzajError.setVisible(false);
        lblSadrzajError.setText("");
        lblBrojPoenaError.setVisible(false);
        lblSadrzajError.setText("");
        txtId.setEnabled(false);
        
        if(mode==FormView.FORM_ADD_MODE){    
            pitanje = kreirajPitanje();
            if(pitanje!=null){
                txtId.setText(Integer.toString(pitanje.getPitanjeId()));
            }
            localStorage.addItemsInHashMap("Pitanje", pitanje);
        }
        else if(mode==FormView.FORM_EDIT_MODE){
            try {
                pitanje = (Pitanje)localStorage.getItemFromHashMap("Pitanje");
                txtSadrzaj.setText(pitanje.getSadrzaj());
                txtId.setText(Integer.toString(pitanje.getPitanjeId()));
                
                PitanjeTest pt = (PitanjeTest)Communication.getInstance().getOnePitanjeTest(new PitanjeTest(pitanje,test,0));
                txtBrojPoena.setText(Integer.toString((int) pt.getBrojPoena()));
                odgovori = pitanje.getOdgovori();
                
            } catch (Exception ex) {
                Logger.getLogger(PitanjeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    private Pitanje kreirajPitanje() {
        try {
            pitanje = new Pitanje();
            pitanje.setSadrzaj("");
            return Communication.getInstance().createPitanje(pitanje);
        } catch (Exception ex) {
            Logger.getLogger(PitanjeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void populateTable() {
        tblOdgovori.setModel(new MyOdgovorTableModel(odgovori));
    }

    private void setErrors() {
        lblSadrzajError.setVisible(false);
        lblSadrzajError.setText("");
        lblBrojPoenaError.setVisible(false);
        lblBrojPoenaError.setText("");
    }
}
