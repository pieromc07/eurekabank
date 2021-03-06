/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;

import command.Invoker;
import command.OpTransferir;
import data.MovimientoDAL;
import logic.MovimientoBL;
import model.Cuenta;
import security.Login;

/**
 *
 * @author Piero
 */
public class transferir extends javax.swing.JFrame {

    /**
     * Creates new form transferir
     */
    private Login authenticado = null;

    public transferir(Login authenticado) {
        initComponents();
        this.authenticado = authenticado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnTransferir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MONTO:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("TRANSFERIR");

        jLabel3.setText("CUENTA DESTINO :");

        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });

        btnTransferir.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/iconos/money_currency_change_dollar_coins_business_icon_150706.png"))); // NOI18N
        btnTransferir.setText("TRANSFERIR");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3).addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup().addGap(129, 129, 129)
                                        .addComponent(btnTransferir))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap().addComponent(jLabel2).addGap(24, 24, 24)))
                        .addContainerGap(113, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addComponent(jLabel2).addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3).addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29).addComponent(btnTransferir).addContainerGap(28, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCuentaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtCuentaActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTransferirActionPerformed
        // TODO add your handling code here:
        int monto = 0;
        float saldo = authenticado.getCuenta().getSaldo();
        Cuenta cuenta = (Cuenta) authenticado.getCuenta();
        float costemovimiento = authenticado.getCostoMovimiento().getImporte();
        monto = Integer.parseInt(txtMonto.getText().trim());
        Cuenta cuentaReferencia = (Cuenta) MovimientoDAL.getCuenta(txtCuenta.getText().trim()).getCuenta();
        if (cuentaReferencia != null) {
            String mensaje = MovimientoBL.vRetirar(monto, saldo);
            if (mensaje.equals("OK")) {
                OpTransferir opTransferir = new OpTransferir(cuenta, monto, costemovimiento, cuentaReferencia);
                Invoker invoker = new Invoker();
                invoker.recibirOperacion(opTransferir);
                invoker.realizarOperaciones();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, mensaje, "ALERTA", 1);
            }
        }else{
            JOptionPane.showMessageDialog(null, "CUENTA NO EXISTE", "ALERTA", 1);
        }

    }// GEN-LAST:event_btnTransferirActionPerformed

    /**
     * @param args the command line arguments //
     */
    // public static void main(String args[]) {
    // /* Set the Nimbus look and feel */
    // //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    // /* If Nimbus (introduced in Java SE 6) is not available, stay with the
    // default look and feel.
    // * For details see
    // http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    // */
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(transferir.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(transferir.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(transferir.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(transferir.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // //</editor-fold>
    //
    // /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new transferir().setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTransferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
