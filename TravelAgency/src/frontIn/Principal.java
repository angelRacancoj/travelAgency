/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontIn;

/**
 *
 * @author angel
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        destinosMenu.setText("Destinos");

        nuevoDestinoMenuItem.setText("Nuevo");
        destinosMenu.add(nuevoDestinoMenuItem);

        verDestinosMenuItem.setText("Ver");
        destinosMenu.add(verDestinosMenuItem);

        jMenuBar1.add(destinosMenu);

        rutasMenu.setText("Rutas");

        nuevaRutaMenuItem.setText("Nuevo");
        rutasMenu.add(nuevaRutaMenuItem);

        editarRutaMenuItem.setText("Editar");
        rutasMenu.add(editarRutaMenuItem);

        verRutasMenuItem.setText("Ver");
        rutasMenu.add(verRutasMenuItem);

        jMenuBar1.add(rutasMenu);

        reservacionMenu.setText("Reservaciones");
        jMenuBar1.add(reservacionMenu);

        aboutMenu.setText("Acerca de");

        informacionMenuItem.setText("Informacion");
        aboutMenu.add(informacionMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenu destinosMenu;
    private javax.swing.JMenuItem editarRutaMenuItem;
    private javax.swing.JMenuItem informacionMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem nuevaRutaMenuItem;
    private javax.swing.JMenuItem nuevoDestinoMenuItem;
    private javax.swing.JMenu reservacionMenu;
    private javax.swing.JMenu rutasMenu;
    private javax.swing.JMenuItem verDestinosMenuItem;
    private javax.swing.JMenuItem verRutasMenuItem;
    // End of variables declaration//GEN-END:variables
}