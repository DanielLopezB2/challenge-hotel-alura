package Clases;

import DAO.ReservaDAO;
import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;


public class Reservas extends javax.swing.JFrame {

    ReservaDAO miReserva = new ReservaDAO();
    
    public Reservas() {
        initComponents();
        
        txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener(){
        @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    
                    Date fechaEntradaDate = txtFechaEntrada.getDate();
                    Date fechaSalidaDate = txtFechaSalida.getDate();

                    SimpleDateFormat dateFormatEntrada = new SimpleDateFormat("yyyy/MM/dd");
                    SimpleDateFormat dateFormatSalida = new SimpleDateFormat("yyyy/MM/dd");

                    String fechaEntradaString = dateFormatEntrada.format(fechaEntradaDate);
                    String fechaSalidaString = dateFormatSalida.format(fechaSalidaDate);

                    long diferenciaMilisegundos = fechaSalidaDate.getTime() - fechaEntradaDate.getTime();
                    long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);

                    float VALOR_NOCHE = 20000;
                    float valorReservaTotal = VALOR_NOCHE * diferenciaDias;
                    String valorReservaTotalString = "" + valorReservaTotal;

                    txtValorReserva.setText(valorReservaTotalString);
                    
                }
            }
        });
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxFormaPago = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        txtFechaEntrada = new com.toedter.calendar.JDateChooser();
        txtFechaSalida = new com.toedter.calendar.JDateChooser();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JLabel();
        txtSignoPesos = new javax.swing.JLabel();
        txtValorReserva = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(12, 138, 199));
        jLabel2.setText("SISTEMA DE RESERVAS");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("FECHA DE CHECK-OUT");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("FECHA DE CHECK-IN");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("VALOR DE LA RESERVA");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("FORMA DE PAGO");

        cbxFormaPago.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbxFormaPago.setForeground(new java.awt.Color(153, 153, 153));
        cbxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tarjeta de credito", "Tarjeta de debito", "PSE", "Efectivo" }));

        jSeparator1.setBackground(new java.awt.Color(12, 138, 199));
        jSeparator1.setForeground(new java.awt.Color(12, 138, 199));

        txtFechaEntrada.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaEntrada.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaEntrada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtFechaSalida.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaSalida.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaSalida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSiguiente.setBackground(new java.awt.Color(12, 138, 199));
        btnSiguiente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.setBorder(null);
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseEntered(evt);
            }
        });
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-izquierda.png"))); // NOI18N
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
        });

        txtSignoPesos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtSignoPesos.setForeground(new java.awt.Color(153, 153, 153));
        txtSignoPesos.setText("$");

        txtValorReserva.setEditable(false);
        txtValorReserva.setBackground(new java.awt.Color(255, 255, 255));
        txtValorReserva.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtValorReserva.setForeground(new java.awt.Color(153, 153, 153));
        txtValorReserva.setText("0");
        txtValorReserva.setBorder(null);
        txtValorReserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorReservaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(btnAtras))
                    .addComponent(cbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSignoPesos)
                            .addGap(4, 4, 4)
                            .addComponent(txtValorReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnAtras)))
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSignoPesos, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtValorReserva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(12, 138, 199));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ha-100px.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reservas-img-3.png"))); // NOI18N

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-24px.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCerrar)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        // TODO add your handling code here:
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnSiguienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseEntered
        // TODO add your handling code here:
        btnSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_btnSiguienteMouseEntered

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        // TODO add your handling code here:
        btnAtras.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        MenuUsuario menuUsuario = new MenuUsuario();
        menuUsuario.setVisible(true);
        menuUsuario.setLocationRelativeTo(null);
                
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        
        if (txtFechaEntrada.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una fecha");
            txtFechaEntrada.requestFocusInWindow();
            return;
        }
        
        if (txtFechaSalida.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una fecha");
            txtFechaSalida.requestFocusInWindow();
            return;
        }
        
        if (txtValorReserva.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un valor");
            txtValorReserva.requestFocusInWindow();
            return;
        }
        
        if (cbxFormaPago.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un metodo de pago");
            cbxFormaPago.requestFocusInWindow();
            return;
        }
        
        int selectedIndex = cbxFormaPago.getSelectedIndex();
        
        String selectedValue = (String) cbxFormaPago.getItemAt(selectedIndex);
        
        Date fechaEntradaDate = txtFechaEntrada.getDate();
        Date fechaSalidaDate = txtFechaSalida.getDate();
        
        SimpleDateFormat dateFormatEntrada = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateFormatSalida = new SimpleDateFormat("yyyy/MM/dd");
        
        String fechaEntradaString = dateFormatEntrada.format(fechaEntradaDate);
        String fechaSalidaString = dateFormatSalida.format(fechaSalidaDate);
                
        long diferenciaMilisegundos = fechaSalidaDate.getTime() - fechaEntradaDate.getTime();
        long diferenciaDias = diferenciaMilisegundos / (24 * 60 * 60 * 1000);
        
        float VALOR_NOCHE = 20000;
        float valorReservaTotal = VALOR_NOCHE * diferenciaDias;
        String valorReservaTotalString = "" + valorReservaTotal;
       
        
        UUID uniqueId = UUID.randomUUID();
        int randomIntId = Math.abs(uniqueId.hashCode());
        
        Reserva objReserva = new Reserva(
                randomIntId,
                fechaEntradaString,
                fechaSalidaString,
                valorReservaTotal,
                selectedValue        
        );
        
        if (miReserva.nuevaReserva(objReserva)) {

                JOptionPane.showMessageDialog(rootPane, "La reserva se ha creado exitosamente");
                JOptionPane.showMessageDialog(rootPane, "# de la reserva: " + randomIntId);
                this.setVisible(false);
                RegistroHuesped registroHuesped = new RegistroHuesped(randomIntId);
                registroHuesped.setVisible(true);
                registroHuesped.setLocationRelativeTo(null);

            } else {

                JOptionPane.showMessageDialog(rootPane, "La reserva no se ha guardado");
                txtFechaEntrada.requestFocusInWindow();

            }
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtValorReservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorReservaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!(numeros)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorReservaKeyTyped

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
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxFormaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser txtFechaEntrada;
    private com.toedter.calendar.JDateChooser txtFechaSalida;
    private javax.swing.JLabel txtSignoPesos;
    private javax.swing.JTextField txtValorReserva;
    // End of variables declaration//GEN-END:variables
}
