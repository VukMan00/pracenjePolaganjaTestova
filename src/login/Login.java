/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import controller.Communication;
import domain.Student;
import domain.User;
import form.AdminForm;
import form.StudentMainForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private String korisnickoImeAdmina = "admin";
    private String sifraAdmina = "admin";
    private LocalStorage localStorage = LocalStorage.getInstance();
    
    public Login() {
        initComponents();
        prepareForm();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblErrorKorisnickoIme = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblErrorSifra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnLogIn = new javax.swing.JButton();
        jpSifra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dobrodosli!");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("LogIn forma:");

        jLabel3.setText("Korisnicko ime: ");

        lblErrorKorisnickoIme.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrorKorisnickoIme.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorKorisnickoIme.setText("jLabel4");

        jLabel4.setText("Sifra:");

        lblErrorSifra.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblErrorSifra.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorSifra.setText("jLabel5");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("*Napomena: \nKorisnicko ime svih studenata je u obliku:\nvm20190048 (inicijali imena i prezimena + brojIndeksa)\n\nSifra svih studenata je u obliku:\nbrojIndeksa-godina (primer: 2019-0048)\n");
        jScrollPane1.setViewportView(jTextArea1);

        btnLogIn.setText("Ulogujte se");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErrorKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jpSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblErrorSifra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorKorisnickoIme)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorSifra)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:        
        String korisnickoIme = txtKorisnickoIme.getText();
        System.out.println(korisnickoIme);
        String sifra = jpSifra.getText();
        System.out.println(sifra);
        prepareForm();
        try {
            Object object = Communication.getInstance().logIn(korisnickoIme, sifra);
            System.out.println(object);
            if(object instanceof User){
                User user = (User)object;
                if(user.getUsername()!=null && user.getPassword()!=null){
                    JOptionPane.showMessageDialog(this, "Uspesno ste se ulogovali");
                    AdminForm adminForm = new AdminForm();
                    adminForm.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Neispravno uneti podaci");
                }
            }
            else if(object instanceof Student){
                Student student = (Student)object;
                if(student.getId()!=null){
                    JOptionPane.showMessageDialog(this, "Uspesno ste se ulogovali");
                    localStorage.addItemsInHashMap("Login", (Student)object);
                    StudentMainForm smf = new StudentMainForm();
                    smf.setLocationRelativeTo(null);
                    smf.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Neispravno uneti podaci");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Neuspesno logovanje");
                System.out.println(object);
                setTextErrors((String)object);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLogInActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField jpSifra;
    private javax.swing.JLabel lblErrorKorisnickoIme;
    private javax.swing.JLabel lblErrorSifra;
    private javax.swing.JTextField txtKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        lblErrorKorisnickoIme.setVisible(false);
        lblErrorKorisnickoIme.setText("");
        lblErrorSifra.setVisible(false);
        lblErrorSifra.setText("");
        
    }

    private void setTextErrors(String string) {
        String[] arrayExceptions = string.split(",");
        if(!arrayExceptions[0].equals(" ")){
            lblErrorSifra.setVisible(true);
            lblErrorSifra.setText(arrayExceptions[0]);
        }
        if(!arrayExceptions[1].equals(" ")){
            lblErrorKorisnickoIme.setVisible(true);
            lblErrorKorisnickoIme.setText(arrayExceptions[1]);
        }
    }

}
