/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.dialog.polaganje;

import components.MyPolaganjeTableModel;
import domain.Polaganje;
import domain.RezultatPolaganja;
import domain.Student;
import form.util.FormView;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import session.LocalStorage;
import communication.*;
import controller.Communication;

/**
 *
 * @author Vuk
 */
public class PolaganjeViewForm extends javax.swing.JDialog {

    /**
     * Creates new form PolaganjeViewForm
     */
    
    private int mode;
    private LocalStorage localStorage = LocalStorage.getInstance();
    
    public PolaganjeViewForm(java.awt.Frame parent, boolean modal,int mode) {
        super(parent, modal);
        initComponents();
        this.mode = mode;
        populateForm();
        populateTable();
        
         tblPolaganja.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int selectedRow = tblPolaganja.getSelectedRow();
                int selectedColumn = tblPolaganja.getSelectedColumn();
                
                List<Polaganje> polaganja = (List<Polaganje>) localStorage.getItemFromHashMap("Polaganja");
                if(selectedColumn==3){
                    List<Student> studenti = polaganja.get(selectedRow).getStudenti();
                    localStorage.addItemsInHashMap("Studenti", studenti);
                    localStorage.addItemsInHashMap("Polaganje", polaganja.get(selectedRow));
                    RezultatiPolaganja rezultatPolaganja = new RezultatiPolaganja(null,true);
                    rezultatPolaganja.setVisible(true);
                   
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
        txtPretraziPolaganje = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPolaganja = new javax.swing.JTable();
        btnUcitaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnUbaciPolaganje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretrazi polaganje po nazivu sale:");

        txtPretraziPolaganje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPretraziPolaganjeKeyPressed(evt);
            }
        });

        tblPolaganja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPolaganja);

        btnUcitaj.setText("Ucitaj");
        btnUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnUbaciPolaganje.setText("Ubaci polaganje");
        btnUbaciPolaganje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbaciPolaganjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUcitaj)
                                .addGap(18, 18, 18)
                                .addComponent(btnIzmeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbaciPolaganje))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPretraziPolaganje, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretraziPolaganje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUcitaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnUbaciPolaganje))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretraziPolaganjeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretraziPolaganjeKeyPressed
        // TODO add your handling code here:
        MyPolaganjeTableModel myPolaganjeTableModel = (MyPolaganjeTableModel)tblPolaganja.getModel();
        List<Polaganje> polaganja = myPolaganjeTableModel.getPolaganja();
        List<Polaganje> novaPolaganja;
        
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           novaPolaganja = nadjiPolaganja(txtPretraziPolaganje.getText(),polaganja);
           if(!novaPolaganja.isEmpty()){
               tblPolaganja.setModel(new MyPolaganjeTableModel(novaPolaganja));
               JOptionPane.showMessageDialog(this, "Sistem je nasao polaganja po zadatoj vrednosti");
           }
           else{
               JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje polaganja po zadatoj vrednosti");
           }
       }

    }//GEN-LAST:event_txtPretraziPolaganjeKeyPressed

    private void btnUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPolaganja.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita polaganje");
        }
        else{
            
            JOptionPane.showMessageDialog(this, "Sistem je ucitao polaganje");

            List<Polaganje> polaganja = ((MyPolaganjeTableModel) tblPolaganja.getModel()).getPolaganja();
            Polaganje polaganje = polaganja.get(selectedRow);
            localStorage.addItemsInHashMap("Polaganje", polaganje);
            
            PolaganjeForm studentForm = new PolaganjeForm(null,true,FormView.FORM_VIEW_MODE);
            studentForm.setVisible(true);
            
            populateTable();
            
        }
    }//GEN-LAST:event_btnUcitajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPolaganja.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da ucita polaganje");
        }
        else{
            JOptionPane.showMessageDialog(this, "Sistem je ucitao polaganje");
            
            List<Polaganje> polaganja = ((MyPolaganjeTableModel) tblPolaganja.getModel()).getPolaganja();
            Polaganje polaganje = polaganja.get(selectedRow);
            localStorage.addItemsInHashMap("Polaganje", polaganje);
            
            PolaganjeForm studentForm = new PolaganjeForm(null,true,FormView.FORM_EDIT_MODE);
            studentForm.setVisible(true);
            
            populateTable();
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnUbaciPolaganjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbaciPolaganjeActionPerformed
        // TODO add your handling code here:
        int[] array = tblPolaganja.getSelectedRows();
        if(array.length == 0){
            JOptionPane.showMessageDialog(this, "Niste izabrali nijedno polaganje");
        }
        else{
            List<Polaganje> polaganja = (List<Polaganje>) localStorage.getItemFromHashMap("PolaganjaStudenta");
            if(polaganja==null){
                polaganja = new ArrayList<>();
            }
            boolean signal = true;
            for(int i=0;i<array.length;i++){
                for(Polaganje polaganje:polaganja){
                    if(polaganje.getPolaganjeId().equals(((MyPolaganjeTableModel)tblPolaganja.getModel()).getPolaganja().get(array[i]).getPolaganjeId())){
                        signal = false;
                        break;
                    }
                }
                if(signal){
                    polaganja.add(((MyPolaganjeTableModel)tblPolaganja.getModel()).getPolaganja().get(array[i]));
                }
            }
            
            localStorage.addItemsInHashMap("PolaganjaStudenta", polaganja);
            JOptionPane.showMessageDialog(this, "Uspesno ste dodali studenta u polaganja");
            this.dispose();
        }
    }//GEN-LAST:event_btnUbaciPolaganjeActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnUbaciPolaganje;
    private javax.swing.JButton btnUcitaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPolaganja;
    private javax.swing.JTextField txtPretraziPolaganje;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        try {
            List<Polaganje> polaganja = Communication.getInstance().getPolaganja();
            List<RezultatPolaganja> rezultatiBaza = Communication.getInstance().getRezultatPolaganja();
            
            for(Polaganje polaganje:polaganja){
                List<Student> studenti = new ArrayList<>();
                for(RezultatPolaganja rp:rezultatiBaza){
                    if(Objects.equals(polaganje.getPolaganjeId(), rp.getPolaganje().getPolaganjeId())){
                        studenti.add(rp.getStudent());
                    }
                }
                polaganje.setStudenti(studenti);
            }
            tblPolaganja.setModel(new MyPolaganjeTableModel(polaganja));
            localStorage.addItemsInHashMap("Polaganja", polaganja);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void populateForm() {
        btnIzmeni.setVisible(true);
        btnUcitaj.setVisible(true);
        btnUbaciPolaganje.setVisible(false);
        if(mode==FormView.FORM_ADD_MODE || mode==FormView.FORM_EDIT_MODE){
            btnIzmeni.setVisible(false);
            btnUcitaj.setVisible(true);
            btnUbaciPolaganje.setVisible(true);
        }
    }

    private List<Polaganje> nadjiPolaganja(String text,List<Polaganje> polaganja) {
        List<Polaganje> nadjenaPolaganja = new ArrayList<>();
        for(Polaganje polaganje:polaganja){
            if(polaganje.getNazivSale().equals(text)){
                nadjenaPolaganja.add(polaganje);
            }
        }
        
        return nadjenaPolaganja;
    }
}
