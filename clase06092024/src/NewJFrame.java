import java.awt.Color;
import java.awt.Graphics; // para inicializar graficos del nivel del agua y muñeco
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Ruddyard 959-23-1409
 * @author Mishel Loeiza 9959-23-3457
 * @author Rocio
 * @author Gabriela
 * @author Daniel 
 * private AhorcadoPanel ahorcadoPanel;
 */
public class NewJFrame extends javax.swing.JFrame {

    private AhorcadoPanel ahorcadoPanel; // Referencia global al panel
    
    // Variables relacionadas con el dibujo
    private int nivelAgua = 0;
    private int estadoMuñeco = 0;

    // Variables globales del juego
    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentosFallidos = 4;
    private final int maxIntentos = 4;


    public NewJFrame() {
        initComponents();
        ahorcadoPanel = new AhorcadoPanel(); // Inicializa el panel
        Ahorcado.setLayout(new java.awt.BorderLayout());
        Ahorcado.add(ahorcadoPanel); // Añade el panel al contenedor
    }

    private void actualizarDibujo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public class AhorcadoPanel extends JPanel {
        private int nivelAgua = 0;
        private int estadoMuñeco = 0;

        public void setNivelAgua(int nivelAgua) {
            this.nivelAgua = nivelAgua;
            repaint();
        }

        public void setEstadoMuñeco(int estadoMuñeco) {
            this.estadoMuñeco = estadoMuñeco;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            dibujarAgua(g);
            dibujarMuneco(g);
        }

        private void dibujarAgua(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(0, getHeight() - nivelAgua, getWidth(), nivelAgua);
        }

        private void dibujarMuneco(Graphics g) {
            g.setColor(Color.BLACK);
            int x = getWidth() / 2;
            int y = getHeight() - nivelAgua - 50;

            switch (estadoMuñeco) {
                case 1 -> g.drawOval(x - 10, y - 20, 20, 20); // Cabeza
                case 2 -> {
                    g.drawOval(x - 10, y - 20, 20, 20); // Cabeza
                    g.drawLine(x, y, x, y + 30); // Cuerpo
                }
                case 3 -> {
                    g.drawOval(x - 10, y - 20, 20, 20); // Cabeza
                    g.drawLine(x, y, x, y + 30); // Cuerpo
                    g.drawLine(x - 15, y + 10, x + 15, y + 10); // Brazo
                }
                case 4 -> {
                    g.drawOval(x - 10, y - 20, 20, 20); // Cabeza
                    g.drawLine(x, y, x, y + 30); // Cuerpo
                    g.drawLine(x - 15, y + 10, x + 15, y + 10); // Brazo
                    g.drawLine(x, y + 30, x - 10, y + 50); // Pierna izquierda
                    g.drawLine(x, y + 30, x + 10, y + 50); // Pierna derecha
                }
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        color = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIngresarPalabra = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtIngresarLetra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalIngresos = new javax.swing.JTextField();
        btnA = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        txtLestrasEncontradas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Ahorcado = new javax.swing.JPanel();
        btnverificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        color.setBackground(new java.awt.Color(153, 255, 204));
        color.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("INGRESAR PALABRA SECRETA");

        jLabel2.setText("INGRESAR LETRA");

        txtIngresarLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresarLetraActionPerformed(evt);
            }
        });

        jLabel3.setText("Letras encontradas");

        jLabel4.setText("cantidad de letras ingresadas");

        btnA.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnA.setText("A");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnD.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnD.setText("B");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel6.setText("JUEGO DE AHORCADO");

        jButton1.setText("INICIAR JUEGO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad de intentos Fallidos");

        jLabel8.setText("Cantidad de intentos restantes");

        jButton2.setText("REINICIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SALIR");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("¡NO TE AHORQUES NI TE AHOGUES");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("TRATANDO DE ADIVINAR QUE SOLO ES UN JUEGO !");

        javax.swing.GroupLayout AhorcadoLayout = new javax.swing.GroupLayout(Ahorcado);
        Ahorcado.setLayout(AhorcadoLayout);
        AhorcadoLayout.setHorizontalGroup(
            AhorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        AhorcadoLayout.setVerticalGroup(
            AhorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        btnverificar.setText("VERIFICAR LETRA");
        btnverificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorLayout = new javax.swing.GroupLayout(color);
        color.setLayout(colorLayout);
        colorLayout.setHorizontalGroup(
            colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorLayout.createSequentialGroup()
                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIngresarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jButton3))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton2))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(txtIngresarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnD))
                            .addComponent(jLabel2)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLestrasEncontradas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnverificar)))
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)))
                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ahorcado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        colorLayout.setVerticalGroup(
            colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorLayout.createSequentialGroup()
                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, colorLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ahorcado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, colorLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(txtIngresarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIngresarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnA)
                            .addComponent(btnD))
                        .addGap(18, 18, 18)
                        .addComponent(btnverificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLestrasEncontradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                                               
    // Limpia el estado actual del juego
    palabraSecreta = ""; // Puedes definir una palabra secreta nueva o dejarla vacía para el ingreso del usuario
    palabraAdivinada = new StringBuilder(); // Limpia la palabra adivinada
    intentosFallidos = 0;
    nivelAgua = 0;
    estadoMuñeco = 0;

    // Actualiza el panel con el estado limpio
    actualizarDibujo();

    // Muestra un mensaje indicando que el juego ha sido reiniciado
    JOptionPane.showMessageDialog(this, "Juego reiniciado. Ingresa una nueva palabra.");

    // Opcional: Permite que el usuario ingrese una nueva palabra
    // Puedes mostrar un diálogo o realizar otra acción para ingresar la nueva palabra
    palabraSecreta = JOptionPane.showInputDialog(this, "Ingresa la nueva palabra secreta:");

    // Actualiza la palabra adivinada con la nueva palabra secreta
    if (palabraSecreta != null && !palabraSecreta.isEmpty()) {
        palabraAdivinada = new StringBuilder("_".repeat(palabraSecreta.length()));
    }
    
    // Vuelve a actualizar el panel con la nueva configuración
    actualizarDibujo();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
 // Obtener la palabra secreta y ocultarla con guiones
    palabraSecreta = new String(txtIngresarPalabra.getPassword()).toLowerCase();
    palabraAdivinada = new StringBuilder("_".repeat(palabraSecreta.length()));
    txtLestrasEncontradas.setText(palabraAdivinada.toString());
    intentosFallidos = 0;
    ahorcadoPanel.setNivelAgua(0);
    ahorcadoPanel.setEstadoMuñeco(0);
    JOptionPane.showMessageDialog(this, "¡Juego Iniciado!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        // TODO add your handling code here:
         // Lógica para manejar la letra "d"
        txtIngresarLetra.setText("d" + txtIngresarLetra.getText());

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(2); // Cambia el estado según sea necesario
    }//GEN-LAST:event_btnDActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        // TODO add your handling code here:
         // Lógica para manejar la letra "d"
        txtIngresarLetra.setText("a" + txtIngresarLetra.getText());

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
    }//GEN-LAST:event_btnAActionPerformed

    private void txtIngresarLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresarLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresarLetraActionPerformed

    private void btnverificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverificarActionPerformed
            // Obtener la letra ingresada por el usuario
    String letraIngresada = txtIngresarLetra.getText().toLowerCase();
    
    // Validar que solo se ingrese una letra y que no esté vacía
    if (letraIngresada.length() != 1) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese una letra válida.");
        return;
    }
    
    // Verificar si la letra está en la palabra secreta
    boolean letraEncontrada = false;
    for (int i = 0; i < palabraSecreta.length(); i++) {
        if (palabraSecreta.charAt(i) == letraIngresada.charAt(0)) {
            palabraAdivinada.setCharAt(i, letraIngresada.charAt(0));
            letraEncontrada = true;
        }
    }

    // Actualizar el campo de letras encontradas
    txtLestrasEncontradas.setText(palabraAdivinada.toString());

    if (!letraEncontrada) {
        intentosFallidos++;
        ahorcadoPanel.setEstadoMuñeco(intentosFallidos);
        
        // Aumentar el nivel del agua con cada fallo
        int nivelAgua = (getHeight() / maxIntentos) * intentosFallidos;
        ahorcadoPanel.setNivelAgua(nivelAgua);
        
        if (intentosFallidos >= maxIntentos) {
            JOptionPane.showMessageDialog(this, "¡Has perdido! La palabra era: " + palabraSecreta);
            // Aquí puedes reiniciar el juego o desactivar los botones
        }
    } else if (palabraAdivinada.toString().equals(palabraSecreta)) {
        JOptionPane.showMessageDialog(this, "¡Felicidades! ¡Has ganado!");
        // Aquí puedes reiniciar el juego o desactivar los botones
    }
    
    // Limpiar el campo de texto para la siguiente letra
    txtIngresarLetra.setText("");
    }//GEN-LAST:event_btnverificarActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ahorcado;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnverificar;
    private javax.swing.JPanel color;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtIngresarLetra;
    private javax.swing.JPasswordField txtIngresarPalabra;
    private javax.swing.JTextField txtLestrasEncontradas;
    private javax.swing.JTextField txtTotalIngresos;
    // End of variables declaration//GEN-END:variables
}
