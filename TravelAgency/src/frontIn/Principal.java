/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontIn;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import travelManager.travelAndRoute;
import travelagency.Structure.bTree;
import travelagency.Structure.hashTable;

/**
 *
 * @author angel
 */
public class Principal extends javax.swing.JFrame {

    travelAndRoute newTR;
    bTree myTree;
    hashTable newHT;
    newDestiny newDest;

    public Principal(travelAndRoute newTravel, bTree newBtree, hashTable newHT) {
        this.newTR = newTravel;
        this.myTree = newBtree;
        this.newHT = newHT;
        this.newDest = new newDestiny(myTree);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        destinosMenu = new javax.swing.JMenu();
        nuevoDestinoMenuItem = new javax.swing.JMenuItem();
        verDestinosMenuItem = new javax.swing.JMenuItem();
        rutasMenu = new javax.swing.JMenu();
        nuevaRutaMenuItem = new javax.swing.JMenuItem();
        editarRutaMenuItem = new javax.swing.JMenuItem();
        verRutasMenuItem = new javax.swing.JMenuItem();
        reservacionMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();
        informacionMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Travel Agency");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        destinosMenu.setText("Destinos");

        nuevoDestinoMenuItem.setText("Nuevo");
        nuevoDestinoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoDestinoMenuItemActionPerformed(evt);
            }
        });
        destinosMenu.add(nuevoDestinoMenuItem);

        verDestinosMenuItem.setText("Ver");
        verDestinosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDestinosMenuItemActionPerformed(evt);
            }
        });
        destinosMenu.add(verDestinosMenuItem);

        jMenuBar1.add(destinosMenu);

        rutasMenu.setText("Rutas");

        nuevaRutaMenuItem.setText("Nuevo");
        nuevaRutaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaRutaMenuItemActionPerformed(evt);
            }
        });
        rutasMenu.add(nuevaRutaMenuItem);

        editarRutaMenuItem.setText("Editar");
        editarRutaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarRutaMenuItemActionPerformed(evt);
            }
        });
        rutasMenu.add(editarRutaMenuItem);

        verRutasMenuItem.setText("Ver");
        verRutasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verRutasMenuItemActionPerformed(evt);
            }
        });
        rutasMenu.add(verRutasMenuItem);

        jMenuBar1.add(rutasMenu);

        reservacionMenu.setText("Reservaciones");
        jMenuBar1.add(reservacionMenu);

        aboutMenu.setText("Acerca de");

        informacionMenuItem.setText("Informacion");
        informacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(informacionMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoDestinoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoDestinoMenuItemActionPerformed
        newDest.setVisible(true);
    }//GEN-LAST:event_nuevoDestinoMenuItemActionPerformed

    private void verDestinosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDestinosMenuItemActionPerformed
        try {
            myTree.treeGraphPrueba();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_verDestinosMenuItemActionPerformed

    private void nuevaRutaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaRutaMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevaRutaMenuItemActionPerformed

    private void editarRutaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarRutaMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarRutaMenuItemActionPerformed

    private void verRutasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verRutasMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verRutasMenuItemActionPerformed

    private void informacionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Create by:\nAngel Racancoj 201631547\nVersion: 0.1 Beta", "Error", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_informacionMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenu destinosMenu;
    private javax.swing.JMenuItem editarRutaMenuItem;
    private javax.swing.JMenuItem informacionMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem nuevaRutaMenuItem;
    private javax.swing.JMenuItem nuevoDestinoMenuItem;
    private javax.swing.JMenu reservacionMenu;
    private javax.swing.JMenu rutasMenu;
    private javax.swing.JMenuItem verDestinosMenuItem;
    private javax.swing.JMenuItem verRutasMenuItem;
    // End of variables declaration//GEN-END:variables
}
