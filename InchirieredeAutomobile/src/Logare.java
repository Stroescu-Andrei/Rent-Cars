
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stroescu Andrei
 */
public class Logare extends javax.swing.JFrame { 
    /**
     * Creates new form Logare
     */
    public Logare() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nume = new javax.swing.JTextField();
        uitare_parola = new javax.swing.JLabel();
        parola = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Logare = new javax.swing.JButton();
        Iesire = new javax.swing.JButton();
        Resetare = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 222, 145));

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logare");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Parola");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nume");

        nume.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        uitare_parola.setBackground(new java.awt.Color(0, 0, 255));
        uitare_parola.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uitare_parola.setForeground(new java.awt.Color(255, 0, 0));
        uitare_parola.setText("Click! Dacă ați uitat parola!");
        uitare_parola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uitare_parolaMouseClicked(evt);
            }
        });

        parola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parolaActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Password_24px.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Key_24px.png"))); // NOI18N

        Logare.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Logare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Enter_20px.png"))); // NOI18N
        Logare.setText("Logare");
        Logare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogareActionPerformed(evt);
            }
        });

        Iesire.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Iesire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Close Window_20px.png"))); // NOI18N
        Iesire.setText("Iesire");
        Iesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IesireActionPerformed(evt);
            }
        });

        Resetare.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Resetare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Reset_20px.png"))); // NOI18N
        Resetare.setText("Resetare");
        Resetare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Logare)
                                .addGap(18, 18, 18)
                                .addComponent(Resetare)
                                .addGap(18, 18, 18)
                                .addComponent(Iesire))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nume, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(parola, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uitare_parola)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(parola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Logare)
                    .addComponent(Iesire)
                    .addComponent(Resetare))
                .addGap(64, 64, 64)
                .addComponent(uitare_parola)
                .addGap(56, 56, 56))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Inchiriere De Autovehicule");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/pkw.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(51, 102, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 153));
        jLabel7.setText("AUTONOM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel4))
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uitare_parolaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uitare_parolaMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane,"Nume='Stroescu' si Parola='Andrei' !");
    }//GEN-LAST:event_uitare_parolaMouseClicked

    private void parolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parolaActionPerformed

    private void LogareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogareActionPerformed
        // TODO add your handling code here:
        String nume1=nume.getText();
        String parola1=parola.getText();
        
        if(nume1.equals("Stroescu")&&parola1.equals("Andrei")){
            Meniu obj=new Meniu();
            obj.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Invalid Nume si Parola! Introduceti din nou!" );
            nume.setText("");
            parola.setText("");
        }
    }//GEN-LAST:event_LogareActionPerformed

    private void IesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IesireActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_IesireActionPerformed

    private void ResetareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetareActionPerformed
        // TODO add your handling code here:
        nume.setText("");
        parola.setText("");
    }//GEN-LAST:event_ResetareActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iesire;
    private javax.swing.JButton Logare;
    private javax.swing.JButton Resetare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField nume;
    private javax.swing.JPasswordField parola;
    private javax.swing.JLabel uitare_parola;
    // End of variables declaration//GEN-END:variables
}
