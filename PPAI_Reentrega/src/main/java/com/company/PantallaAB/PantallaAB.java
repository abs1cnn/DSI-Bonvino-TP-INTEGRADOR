package com.company.PantallaAB;

// --------------------------------------------
// Importar clases necesarias 
// --------------------------------------------
import Controladores.ControladorImportarActualizacionVinosBodega;
import com.company.views.tablaBodegasAct;
import com.company.views.tablaResumen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


// ---------------------------------------------
// Definicion de clase boudary PantallaAB
//---------------------------------------------
public class PantallaAB extends javax.swing.JFrame {

    private ControladorImportarActualizacionVinosBodega controlador;
    private static tablaBodegasAct tabla;
    private static tablaResumen tablaResumenVinos;

    public PantallaAB() {
        initComponents();
        setLocationRelativeTo(null);
        centrarPanelBotones();
        // Inicialización del controlador
        controlador = new ControladorImportarActualizacionVinosBodega();
        // Inicialización de la tabla
        tabla = new tablaBodegasAct();
        //tablaResumenVinos = new tablaResumen();
        // Ajustar el tamaño de la tabla
        tabla.setSize(1000, 500);

        tablaResumenVinos = new tablaResumen();
        tablaResumenVinos.setSize(1000, 500);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        backGround = new javax.swing.JPanel();
        barMenu = new javax.swing.JPanel();
        Inicio = new javax.swing.JButton();

        contenedor = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        botonImpActBod = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backGround.setBackground(new java.awt.Color(238, 240, 235));
        backGround.setForeground(new java.awt.Color(255, 255, 255));

        barMenu.setBackground(new java.awt.Color(123, 38, 66));

        Inicio.setBackground(new java.awt.Color(219, 179, 177));
        Inicio.setText("Inicio");



        javax.swing.GroupLayout barMenuLayout = new javax.swing.GroupLayout(barMenu);
        barMenu.setLayout(barMenuLayout);
        barMenuLayout.setHorizontalGroup(
            barMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barMenuLayout.setVerticalGroup(
            barMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        contenedor.setBackground(new java.awt.Color(238, 240, 235));

        panelBotones.setBackground(new java.awt.Color(238, 240, 235));
        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        botonImpActBod.setBackground(new java.awt.Color(180, 184, 171));
        botonImpActBod.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        botonImpActBod.setText("Importar actualización \nde vinos de bodega ");
        botonImpActBod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImpActBodActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(180, 184, 171));
        jButton3.setText("jButton3");

        jButton4.setBackground(new java.awt.Color(180, 184, 171));
        jButton4.setText("jButton4");

        jButton2.setBackground(new java.awt.Color(180, 184, 171));
        jButton2.setText("jButton2");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonImpActBod, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonImpActBod, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addComponent(barMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }

    // Pantalla habilita pantalla
    private void botonImpActBodActionPerformed(java.awt.event.ActionEvent evt) {
        habilitarPantalla();
        // llama al metodo del controlador
        controlador.opcionImportarActualizacionVinosBodega();
        //controlador.notificar(); // crea la InterfazNotificacion
        //controlador.suscribir();
    }
    
    // Cosas esteticas, menu de arriba 
    public void barMenu(){
           barMenu.setBackground(new java.awt.Color(123, 38, 66));
            Inicio.setBackground(new java.awt.Color(219, 179, 177));
    };

    public void centrarPanelBotones() {
        contenedor.removeAll();
        contenedor.setLayout(new GridBagLayout()); // Establecer GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Crear restricciones
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el componente
        contenedor.add(panelBotones, gbc); // Agregar el panelBotones con las restricciones
        contenedor.revalidate();
        contenedor.repaint();
    }

    // --------------------------------------------------
    //
    // --------------------------------------------------
    public void habilitarPantalla() {
        // Ocultar botones y mostrar el panel de la tabla
        //contenedor.setVisible(false);
        //jPanel1.setVisible(false);

        // Elimina todos los componentes actuales del contenedor (contenedor)
        contenedor.removeAll();
        // Administrador de diseño que permite posicionar componentes dentro de una cuadrícula.
        contenedor.setLayout(new GridBagLayout());
        // Especificar restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH; // Hacer que el componente llene su celda en ambas direcciones
        gbc.weightx = 1.0; // Dar todo el espacio extra horizontal al componente
        gbc.weighty = 1.0; // Dar todo el espacio extra vertical al componente
        // añade el compoente tabla al contenedor
        contenedor.add(tabla, gbc);
        contenedor.revalidate();


    }

    //Fijarse los statics
    public static void mostrarBodegasParaActualizar(List<String> listaBodegasConActualizacion) {
        // Ajustar el tamaño de la tabla
        tabla.llenarTablaBodegas(listaBodegasConActualizacion);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAB().setVisible(true);

            }
        });
    }

    public void seleccionarBodega(List<String> bodegaSeleccionadas) {
        controlador.tomarSeleccionBodega(bodegaSeleccionadas);
    }

    public static void mostrarResumenVinosImportados(ArrayList<ArrayList<String>> resumenVinosImportados) {
        //CERRAR LA VISTA DE LAS BODEGAS SELECCIONADAS
        tablaResumenVinos.llenarTablaResumen(resumenVinosImportados);


    }

    public static void tablaBodegasSinConexion(ArrayList<String> bodegasSinConexion){
        tablaResumenVinos.llenarTablaBodegasSinConex(bodegasSinConexion);
    }

    public void habilitarTablaResumen(Container container){
        container.removeAll();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        container.add(tablaResumenVinos, gbc);

        container.revalidate();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inicio;
    private javax.swing.JPanel backGround;
    private javax.swing.JPanel barMenu;
    private javax.swing.JButton botonImpActBod;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel panelBotones;


    // End of variables declaration//GEN-END:variables
}


