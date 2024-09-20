
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; // para inicializar graficos del nivel del agua y muñeco
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * 
 * @author Mishel Loeiza 9959-23-3457(COORDINADORA)
 * @author Cristofer pivaral
 * @author Ruddyard 959-23-1409
 * @author Rocio
 * @author Gabriela
 * @author Daniel 
 * private AhorcadoPanel ahorcadoPanel;
 */
public class NewJFrame extends javax.swing.JFrame {

    //contador 
    int contador = 0;
    UIManager UI;
    Icon Modificar;
    private AhorcadoPanel ahorcadoPanel; // Referencia global al panel

    // Variables relacionadas con el dibujo
    private int nivelAgua = 0;
    private int estadoMuñeco = 0;

    // Variables globales del juego
    private String palabraSecreta;
    private StringBuilder palabraAdivinada;
    private int intentosFallidos = 0;//restricciòn de intentos fallidos igualado a 0
    private final int maxIntentos = 3;

    public NewJFrame() {
        initComponents();
        ahorcadoPanel = new AhorcadoPanel(); // Inicializa el panel
        ahorcadoPanel.setPreferredSize(new Dimension(500, 500)); // Ajustar el tamaño preferido (ancho 600, altura 400)
 Ahorcado.setLayout(new java.awt.BorderLayout());
         Ahorcado.add(ahorcadoPanel); // Añade el panel al contenedor
        Modificar = new ImageIcon("C:\\Users\\ADMI\\OneDrive\\PROTOTIPO 2 AHOGADO OFICIAL\\ProyectoAhorcado\\clase06092024\\src\\icono.png");
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
// implementacioN de coordenadas 

        private void dibujarAgua(Graphics g) {
            // Ajusta el nivel del agua para que sea más proporcional al tamaño del muñeco
  
    
            g.setColor(Color.BLUE);
            g.fillRect(0, getHeight() - nivelAgua, getWidth(), nivelAgua);
        }

        // Agrega la soga en el método dibujarMuneco
private void dibujarMuneco(Graphics g) {
    g.setColor(Color.BLACK);

    // Ajustamos el tamaño del muñeco
    int tamañoCabeza = 40; // Cabeza más grande
    int alturaCuerpo = 100; // Cuerpo más largo
    int anchoBrazos = 80; // Brazos más largos
    int alturaPiernas = 60; // Piernas más largas
    int radioOjo = 5; // Radio de los ojos
    int distanciaOjos = 10; // Distancia entre los ojos
    int margenSonrisa = 5; // Margen para la sonrisa (ajustar para el caso 2)

    // Ajustamos las coordenadas centrales del muñeco
    int x = getWidth() / 2;
    int y = getHeight() - nivelAgua - alturaCuerpo - tamañoCabeza; // Más espacio para el muñeco

    // Dibujar la cuerda (soga)
    g.setColor(Color.GRAY);
    g.drawLine(x, y - tamañoCabeza, x, y - alturaCuerpo - tamañoCabeza); // Cuerda desde arriba hasta la cabeza

    // Cambiamos a color negro para el muñeco
    g.setColor(Color.BLACK);

    // Dibujar el muñeco dependiendo del estado
    switch (estadoMuñeco) {
        case 1 -> {
            // Cabeza
            g.setColor(Color.BLACK);
            g.drawOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza);

            // Cara feliz
            g.setColor(Color.YELLOW);
            g.fillOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza); // Rellenar la cabeza con amarillo

            g.setColor(Color.BLACK);
            // Ojos
            int ojoX1 = x - tamañoCabeza / 4 - radioOjo;
            int ojoY1 = y - tamañoCabeza / 2 + tamañoCabeza / 4 - radioOjo;
            int ojoX2 = x + tamañoCabeza / 4 - radioOjo;
            int ojoY2 = ojoY1;
            g.fillOval(ojoX1, ojoY1, radioOjo * 2, radioOjo * 2); // Ojo izquierdo
            g.fillOval(ojoX2, ojoY2, radioOjo * 2, radioOjo * 2); // Ojo derecho

            // Boca
            g.drawArc(x - tamañoCabeza / 4, y - tamañoCabeza / 2 + tamañoCabeza / 4 + margenSonrisa, tamañoCabeza / 2, tamañoCabeza / 4, 0, -180); // Sonrisa
        }

        case 2 -> {
            // Cabeza
            g.setColor(Color.BLACK);
            g.drawOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza);

            // Cara feliz
            g.setColor(Color.YELLOW);
            g.fillOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza); // Rellenar la cabeza con amarillo

            g.setColor(Color.BLACK);
            // Ojos
            int ojoX1 = x - tamañoCabeza / 4 - radioOjo;
            int ojoY1 = y - tamañoCabeza / 2 + tamañoCabeza / 4 - radioOjo;
            int ojoX2 = x + tamañoCabeza / 4 - radioOjo;
            int ojoY2 = ojoY1;
            g.fillOval(ojoX1, ojoY1, radioOjo * 2, radioOjo * 2); // Ojo izquierdo
            g.fillOval(ojoX2, ojoY2, radioOjo * 2, radioOjo * 2); // Ojo derecho

            // Boca
            g.drawArc(x - tamañoCabeza / 4, y - tamañoCabeza / 2 + tamañoCabeza / 4 - 10, tamañoCabeza / 2, tamañoCabeza / 4, 0, -180); // Sonrisa ajustada
            // Cuerpo
            g.drawLine(x, y, x, y + alturaCuerpo);
        }

        case 3 -> {
            // Cabeza
            g.setColor(Color.BLACK);
            g.drawOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza);
            // Cara feliz
            g.setColor(Color.YELLOW);
            g.fillOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza); // Rellenar la cabeza con amarillo

            g.setColor(Color.BLACK);
            // Ojos
            int ojoX1 = x - tamañoCabeza / 4 - radioOjo;
            int ojoY1 = y - tamañoCabeza / 2 + tamañoCabeza / 4 - radioOjo;
            int ojoX2 = x + tamañoCabeza / 4 - radioOjo;
            int ojoY2 = ojoY1;
            g.fillOval(ojoX1, ojoY1, radioOjo * 2, radioOjo * 2); // Ojo izquierdo
            g.fillOval(ojoX2, ojoY2, radioOjo * 2, radioOjo * 2); // Ojo derecho

            // Boca
            g.drawArc(x - tamañoCabeza / 4, y - tamañoCabeza / 2 + tamañoCabeza / 4 - 10, tamañoCabeza / 2, tamañoCabeza / 4, 0, -180); // Sonrisa ajustada
            // Cuerpo
            g.drawLine(x, y, x, y + alturaCuerpo);
            // Brazos
            g.drawLine(x - anchoBrazos / 2, y + tamañoCabeza / 2, x + anchoBrazos / 2, y + tamañoCabeza / 2);
        }

        case 4 -> {
            // Cabeza
            g.setColor(Color.BLACK);
            g.drawOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza);
            // Cara feliz
            g.setColor(Color.YELLOW);
            g.fillOval(x - tamañoCabeza / 2, y - tamañoCabeza, tamañoCabeza, tamañoCabeza); // Rellenar la cabeza con amarillo

            g.setColor(Color.BLACK);
            // Ojos
            int ojoX1 = x - tamañoCabeza / 4 - radioOjo;
            int ojoY1 = y - tamañoCabeza / 2 + tamañoCabeza / 4 - radioOjo;
            int ojoX2 = x + tamañoCabeza / 4 - radioOjo;
            int ojoY2 = ojoY1;
            g.fillOval(ojoX1, ojoY1, radioOjo * 2, radioOjo * 2); // Ojo izquierdo
            g.fillOval(ojoX2, ojoY2, radioOjo * 2, radioOjo * 2); // Ojo derecho

            // Boca
            g.drawArc(x - tamañoCabeza / 4, y - tamañoCabeza / 2 + tamañoCabeza / 4 - 10, tamañoCabeza / 2, tamañoCabeza / 4, 0, -180); // Sonrisa ajustada
            // Cuerpo
            g.drawLine(x, y, x, y + alturaCuerpo);
            // Brazos
            g.drawLine(x - anchoBrazos / 2, y + tamañoCabeza / 2, x + anchoBrazos / 2, y + tamañoCabeza / 2);
            // Piernas
            g.drawLine(x, y + alturaCuerpo, x - 20, y + alturaCuerpo + alturaPiernas); // Pierna izquierda
            g.drawLine(x, y + alturaCuerpo, x + 20, y + alturaCuerpo + alturaPiernas); // Pierna derecha
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
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
        btnIniciarjuego = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtfallidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIntentosFaltantes = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Ahorcado = new javax.swing.JPanel();
        btnverificar = new javax.swing.JButton();
        btNC = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btnK = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnÑ = new javax.swing.JButton();

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

        txtTotalIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalIngresosActionPerformed(evt);
            }
        });

        btnA.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnA.setText("A");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnD.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnD.setText("D");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel6.setText("JUEGO DE AHORCADO");

        btnIniciarjuego.setText("INICIAR JUEGO");
        btnIniciarjuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarjuegoActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad de intentos Fallidos");

        jLabel8.setText("Cantidad de intentos restantes");

        txtIntentosFaltantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntentosFaltantesActionPerformed(evt);
            }
        });

        btnReiniciar.setText("REINICIAR");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("¡NO TE AHORQUES NI TE AHOGUES");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("TRATANDO DE ADIVINAR QUE SOLO ES UN JUEGO !");

        javax.swing.GroupLayout AhorcadoLayout = new javax.swing.GroupLayout(Ahorcado);
        Ahorcado.setLayout(AhorcadoLayout);
        AhorcadoLayout.setHorizontalGroup(
            AhorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        AhorcadoLayout.setVerticalGroup(
            AhorcadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnverificar.setText("VERIFICAR LETRA");
        btnverificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverificarActionPerformed(evt);
            }
        });

        btNC.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btNC.setText("C");
        btNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNCActionPerformed(evt);
            }
        });

        btnB.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnB.setText("B");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnE.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnE.setText("E");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnF.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnF.setText("F");
        btnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFActionPerformed(evt);
            }
        });

        btnG.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnG.setText("G");
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        btnH.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnH.setText("H");
        btnH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHActionPerformed(evt);
            }
        });

        btnI.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnI.setText("I");
        btnI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIActionPerformed(evt);
            }
        });

        btnJ.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnJ.setText("J");
        btnJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJActionPerformed(evt);
            }
        });

        btnK.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnK.setText("K");
        btnK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKActionPerformed(evt);
            }
        });

        btnL.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnL.setText("L");
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });

        btnM.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnM.setText("M");
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        btnN.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnN.setText("N");
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        btnÑ.setFont(new java.awt.Font("Viner Hand ITC", 3, 12)); // NOI18N
        btnÑ.setText("Ñ");
        btnÑ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÑActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorLayout = new javax.swing.GroupLayout(color);
        color.setLayout(colorLayout);
        colorLayout.setHorizontalGroup(
            colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorLayout.createSequentialGroup()
                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(colorLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(salir))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnReiniciar))
                            .addComponent(jLabel2)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIntentosFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfallidos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(btnIniciarjuego, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLestrasEncontradas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorLayout.createSequentialGroup()
                                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorLayout.createSequentialGroup()
                                        .addComponent(txtIngresarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnA)
                                        .addGap(12, 12, 12))
                                    .addGroup(colorLayout.createSequentialGroup()
                                        .addComponent(btnverificar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(colorLayout.createSequentialGroup()
                                        .addComponent(btnB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btNC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnF))
                                    .addGroup(colorLayout.createSequentialGroup()
                                        .addComponent(btnI)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnJ)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnK)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnM))
                                    .addComponent(btnÑ))
                                .addGap(3, 3, 3)))
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnG)
                            .addComponent(btnN))))
                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnH)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel10))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Ahorcado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(86, Short.MAX_VALUE))))
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
                        .addGap(36, 36, 36)
                        .addComponent(Ahorcado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(colorLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(txtIngresarPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIniciarjuego)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(colorLayout.createSequentialGroup()
                                .addComponent(txtIngresarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnverificar)
                                .addGap(78, 78, 78)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(colorLayout.createSequentialGroup()
                                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btNC)
                                    .addComponent(btnB)
                                    .addComponent(btnE)
                                    .addComponent(btnD)
                                    .addComponent(btnA)
                                    .addComponent(btnF)
                                    .addComponent(btnG)
                                    .addComponent(btnH))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnI)
                                    .addComponent(btnJ)
                                    .addComponent(btnK)
                                    .addComponent(btnL)
                                    .addComponent(btnM)
                                    .addComponent(btnN))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnÑ)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
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
                            .addComponent(txtfallidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtIntentosFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReiniciar)
                            .addComponent(salir))))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
//        // TODO add your handling code here:

JOptionPane.showMessageDialog(null, "¡Vamos de nuevo !");
        txtIngresarPalabra.setEnabled(true);
        txtLestrasEncontradas.setEnabled(false);
        txtTotalIngresos.setEnabled(false);
        txtIntentosFaltantes.setEnabled(false);
        txtIngresarLetra.setEnabled(false);
        txtIntentosFaltantes.setEnabled(false);
        
        txtIngresarPalabra.setText("");
        txtLestrasEncontradas.setText("");
        txtTotalIngresos.setText("");
        txtfallidos.setText("");
        txtIntentosFaltantes.setText("");
       

        ahorcadoPanel.setNivelAgua(0);
        ahorcadoPanel.setEstadoMuñeco(0);
        contador=0;
//
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnIniciarjuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarjuegoActionPerformed
        // TODO add your handling code here:
        // Tomamos la palabra oculta y mandamos a contar cuantos caracteres tiene
        String palabraOculta = txtIngresarPalabra.getText();
        int longi = palabraOculta.length();
        //si sus cantidad de caracteres es mayor a 0 empieza el juego, de lo contrario no pasa nada.
        if (longi > 0) {
            txtIngresarPalabra.setEnabled(false);
            txtLestrasEncontradas.setEnabled(false);
            txtTotalIngresos.setEnabled(false);
            txtfallidos.setEnabled(false);
            txtIngresarLetra.setEnabled(false);
            txtLestrasEncontradas.setText("");
            txtTotalIngresos.setText("");
            txtfallidos.setText("");
            txtIntentosFaltantes.setEnabled(false);
            txtIntentosFaltantes.setText("");

            String palabraOriginal = txtIngresarPalabra.getText();
            StringBuilder SimboloSustituir = new StringBuilder();

            // Remplasar cada letra con  el  simbolo "-"
            for (int i = 0; i < palabraOriginal.length(); i++) {
                SimboloSustituir.append("-");
            }

            // Desplegar el simbolo de la parabra en otro text field 
            txtLestrasEncontradas.setText(SimboloSustituir.toString());

            // Save the symbol word to a file (you can change the file path as needed)
            try (PrintWriter out = new PrintWriter("symbolWord.txt")) {
                out.println(SimboloSustituir.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "¡Juego Iniciado!");
            contador = 0;
        }

        // Obtener la palabra secreta y ocultarla con guiones implementacion de guiones
        palabraSecreta = new String(txtIngresarPalabra.getPassword()).toLowerCase();
        palabraAdivinada = new StringBuilder("_".repeat(palabraSecreta.length()));
        txtLestrasEncontradas.setText(palabraAdivinada.toString());
        intentosFallidos = 0;
        ahorcadoPanel.setNivelAgua(0);
        ahorcadoPanel.setEstadoMuñeco(0);

// Obtener la palabra secreta y ocultarla con guiones implementacion de guiones
        palabraSecreta = new String(txtIngresarPalabra.getPassword()).toLowerCase();
        palabraAdivinada = new StringBuilder("_".repeat(palabraSecreta.length()));
        txtLestrasEncontradas.setText(palabraAdivinada.toString());
        intentosFallidos = 0;
//inicializacion de intentos fallidos contador
        txtfallidos.setText(String.valueOf(intentosFallidos));

        ahorcadoPanel.setNivelAgua(0);
        ahorcadoPanel.setEstadoMuñeco(0);
    }//GEN-LAST:event_btnIniciarjuegoActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "d"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "d");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("d");
        }

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(2); // Cambia el estado según sea necesario
    }//GEN-LAST:event_btnDActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "d"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "a");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("a");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
       // contador++;
        
    }//GEN-LAST:event_btnAActionPerformed

    private void txtIngresarLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresarLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresarLetraActionPerformed

    private void btnverificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverificarActionPerformed
       // Obtener la letra ingresada por el usuario 
       contador++;
    txtTotalIngresos.setText(String.valueOf(contador));  
                                            
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
        
        // Actualizar el campo de intentos fallidos
        txtfallidos.setText(String.valueOf(intentosFallidos));
            
          // Calcular intentos restantes
    int intentosRestantes = maxIntentos - intentosFallidos;
    txtIntentosFaltantes.setText(String.valueOf(intentosRestantes));

    if (intentosFallidos >= maxIntentos) {
            JOptionPane.showMessageDialog(this, "¡Has perdido! La palabra era: " + palabraSecreta);
            // Cerrar la ventana después de perder
              // volver
        }
    } else if (palabraAdivinada.toString().equals(palabraSecreta)) {
        JOptionPane.showMessageDialog(this, "¡Felicidades! ¡Has ganado!");
        // Cerrar la ventana después de ganar
          // volver
    }
    
    // Limpiar el campo de texto para la siguiente letra
    txtIngresarLetra.setText("");
    }//GEN-LAST:event_btnverificarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        Object UI = null;
        UIManager.put("OptionPane.background", new Color(211, 211, 211));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(211, 211, 211));
        JLabel label = new JLabel("<html><b style=\"color:red; font-size:16px;\">¿Desea salir del juego?</b></html>");
        label.setForeground(Color.WHITE);
        panel.add(label);
        Icon Modificar = null;

        int confirmar = JOptionPane.showConfirmDialog(null, panel,
                "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Modificar);
        if (JOptionPane.OK_OPTION == confirmar) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void btNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNCActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "d"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "c");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("c");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
        //txtTotalIngresos.setText(String.valueOf(contador));        // TODO add your handling code here:
    }//GEN-LAST:event_btNCActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "d"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "b");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("b");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
        /*contador++;
        txtTotalIngresos.setText(String.valueOf(contador));    }//GEN-LAST:event_btnBActionPerformed
*/
}
    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "d"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "e");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("e");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
    }//GEN-LAST:event_btnEActionPerformed

    private void txtIntentosFaltantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntentosFaltantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntentosFaltantesActionPerformed

    private void btnFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFActionPerformed
        // TODO add your handling code here:
      
        // Lógica para manejar la letra "f"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "f");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("f");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(4);
    }//GEN-LAST:event_btnFActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        // TODO add your handling code here:
         
        // Lógica para manejar la letra "g"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "g");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("g");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(4);
    }//GEN-LAST:event_btnGActionPerformed

    private void btnHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHActionPerformed
        // TODO add your handling code here: 
        // Lógica para manejar la letra "h"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "h"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "h");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("h");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(2);
    }//GEN-LAST:event_btnHActionPerformed

    private void btnIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIActionPerformed
        // TODO add your handling code here: 
        // Lógica para manejar la letra "i"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "a"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "i");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("i");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
    }//GEN-LAST:event_btnIActionPerformed

    private void btnJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJActionPerformed
        // TODO add your handling code here: 
        // Lógica para manejar la letra "j"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "j"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "j");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("j");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(1);
    }//GEN-LAST:event_btnJActionPerformed

    private void txtTotalIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalIngresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalIngresosActionPerformed

    private void btnKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKActionPerformed
        // TODO add your handling code here:
        
        // Lógica para manejar la letra "j"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "j"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "k");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("k");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(1);
    }//GEN-LAST:event_btnKActionPerformed

    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLActionPerformed
        // TODO add your handling code here:
         
        // Lógica para manejar la letra "j"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "j"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "l");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("l");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(2);
    }//GEN-LAST:event_btnLActionPerformed

    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "m"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "m"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "m");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("m");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
    }//GEN-LAST:event_btnMActionPerformed

    private void btnNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "n"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "n"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "n");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("n");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(4);
    }//GEN-LAST:event_btnNActionPerformed

    private void btnÑActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÑActionPerformed
        // TODO add your handling code here:
        // Lógica para manejar la letra "ñ"
        if (txtIngresarPalabra.isEnabled()) {
            // si esta habilitado, set text "ñ"
            // Subrallado indica que es un password file 
            // Ingresa a txtIngresarPalabra el texto que contiene como predeterminado + a 
            txtIngresarPalabra.setText(txtIngresarPalabra.getText() + "ñ");
        } else {
            // si esta desactivado agregar la letra a en txt ingresar letra
            //Para else usar el que borra ya que solo se puede introducir una letra a la vez
            txtIngresarLetra.setText("ñ");
        };

        ahorcadoPanel.setNivelAgua(ahorcadoPanel.getHeight() / 2); // Ajusta según sea necesario
        ahorcadoPanel.setEstadoMuñeco(3);
    }//GEN-LAST:event_btnÑActionPerformed

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
    private javax.swing.JButton btNC;
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnD;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnF;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnH;
    private javax.swing.JButton btnI;
    private javax.swing.JButton btnIniciarjuego;
    private javax.swing.JButton btnJ;
    private javax.swing.JButton btnK;
    private javax.swing.JButton btnL;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnN;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnverificar;
    private javax.swing.JButton btnÑ;
    private javax.swing.JPanel color;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton salir;
    private javax.swing.JTextField txtIngresarLetra;
    private javax.swing.JPasswordField txtIngresarPalabra;
    private javax.swing.JTextField txtIntentosFaltantes;
    private javax.swing.JTextField txtLestrasEncontradas;
    private javax.swing.JTextField txtTotalIngresos;
    private javax.swing.JTextField txtfallidos;
    // End of variables declaration//GEN-END:variables
}
