package views;

import utilidades.Utilidades;
import models.Articulo;
import services.ArticuloServices;

public class VtnActualizarArticulo extends javax.swing.JFrame {
    private final ArticuloServices articleServices;
    
    public VtnActualizarArticulo(ArticuloServices articleServices) {
        initComponents();
        this.articleServices = articleServices;
    }
    
    public void cargarDatos(int idArticulo)
    {
        Articulo objArticulo = this.articleServices.findById(idArticulo);
        this.jTextFieldId.setText(objArticulo.getId()+"");
        this.jTextFieldTitulo1.setText(objArticulo.getTitle());
        this.jTextFieldRevista.setText(objArticulo.getJournal());
        this.jTextAreaPalabras.setText(objArticulo.getKeywords());
        this.jTextFieldCantAut.setText(objArticulo.getnumAuthors()+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();
        jPanelCentral = new javax.swing.JPanel();
        jButtonActualizar = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTitulo1 = new javax.swing.JTextField();
        jLabelRevista = new javax.swing.JLabel();
        jTextFieldRevista = new javax.swing.JTextField();
        jLabelPalabrasClave = new javax.swing.JLabel();
        jLabelCantAut = new javax.swing.JLabel();
        jTextFieldCantAut = new javax.swing.JTextField();
        jTextAreaPalabras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(102, 51, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Actualizar articulo");
        jLabelTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/print.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jTextFieldId.setEditable(false);

        jLabel5.setText("Id:");

        jLabel6.setText("Titulo:");

        jLabelRevista.setText("Revista:");

        jLabelPalabrasClave.setText("Palabras clave:");

        jLabelCantAut.setText("Cantidad de autores:");

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonActualizar)
                .addGap(41, 41, 41))
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabelRevista)
                    .addComponent(jLabelPalabrasClave)
                    .addComponent(jLabelCantAut))
                .addGap(64, 64, 64)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCantAut, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextAreaPalabras, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldRevista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRevista)
                    .addComponent(jTextFieldRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPalabrasClave)
                    .addComponent(jTextAreaPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldCantAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelCantAut)))
                .addGap(18, 18, 18)
                .addComponent(jButtonActualizar)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        String titulo, revista, palabrasClave, numAut, id;
        Integer cantAuth = 0;
        int idEnteroArticulo;
        
        id = this.jTextFieldId.getText();          
        idEnteroArticulo = Integer.parseInt(id);
        titulo = this.jTextFieldTitulo1.getText();
        revista = this.jLabelRevista.getText();
        palabrasClave = this.jTextAreaPalabras.getText();
        numAut = this.jTextFieldCantAut.getText();
        
        try {
            cantAuth = Integer.valueOf(numAut);
            if(cantAuth <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
                Utilidades.mensajeAdvertencia("La cantidad de autores debe ser un numero positivo", "Cantidad de autores no válida");
        }
        
        Articulo objArticulo = new Articulo();
        objArticulo.setId(idEnteroArticulo);
        objArticulo.setTitle(titulo);
        objArticulo.setJournal(revista);
        objArticulo.setKeywords(palabrasClave);
        objArticulo.setCantAuthors(cantAuth);
        
       this.articleServices.update(objArticulo.getId(), objArticulo);
       if(!objArticulo.equals(null))
       {
           Utilidades.mensajeExito("Artículo actualizado exitosamente", "Artículo actualizado");
           setVisible(false);
       }
       else
       {
           Utilidades.mensajeError("Error al actualizar el artículo", "Error al actualizar");
       }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCantAut;
    private javax.swing.JLabel jLabelPalabrasClave;
    private javax.swing.JLabel jLabelRevista;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JTextField jTextAreaPalabras;
    private javax.swing.JTextField jTextFieldCantAut;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldRevista;
    private javax.swing.JTextField jTextFieldTitulo1;
    // End of variables declaration//GEN-END:variables
}