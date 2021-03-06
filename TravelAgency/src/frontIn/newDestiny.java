/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontIn;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import travelagency.Structure.bTree;
import travelagency.exceptions.errorException;

/**
 *
 * @author angel
 */
public class newDestiny extends javax.swing.JFrame {

    bTree tree;

    /**
     * Creates new form newDestiny
     */
    public newDestiny(bTree bTreeIn) {
        this.tree = bTreeIn;
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

        codeFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setTitle("New Destiny");

        codeFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        codeFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFormattedTextFieldFocusLost(evt);
            }
        });

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Codigo:");

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(codeFormattedTextField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codeFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(cancelarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            if (!codeFormattedTextField.getText().replaceAll(" ", "").replaceAll("\t", "").isEmpty() && !nameTextField.getText().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                if (!tree.existNode(Integer.valueOf(codeFormattedTextField.getText()))) {
                    tree.addNode(Integer.valueOf(codeFormattedTextField.getText()), nameTextField.getText());
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Destino agregado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    clear();
                    JOptionPane.showMessageDialog(this, "ya existe el nodo, intente con un nuevo codigo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Casillas vacias, debe colocar los datos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (errorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        clear();
        this.setVisible(false);
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void codeFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeFormattedTextFieldFocusLost
        try {
            if (tree.existNode(Integer.valueOf(codeFormattedTextField.getText()))) {
                clear();
                JOptionPane.showMessageDialog(this, "ya existe el nodo, intente con un nuevo codigo", "Error", JOptionPane.ERROR_MESSAGE);
                guardarButton.setEnabled(false);
            } else {
                guardarButton.setEnabled(true);
            }
        } catch (errorException ex) {
            Logger.getLogger(newDestiny.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codeFormattedTextFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JFormattedTextField codeFormattedTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables

    private void clear() {
        codeFormattedTextField.setText("");
        nameTextField.setText("");
    }
}
