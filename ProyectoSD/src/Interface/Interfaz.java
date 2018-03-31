/*
    @title = Proyecto Sistemas Distribuidos
    @author's = 
        Urtiaga Torres Jenny Nazareth
        Ramirez Martinez Carlos Alberto
    Entrega 4 abril 2018
    @Descripci'on 
       * Se debera ingresar en el cuadro de texto la palabra a buscar.
       * Se tiene a eleccion 4 m'etodos de conexi'on sockets, RPC y RMI.
       * Es posible agregar una funci'on l'ogica a la busqu'eda si se ingresa de la siguiente manera:
            - <consulta_1 AND consulta_2>
            - <consulta_1 NOR consulta_2>
        tambien es posible solamente ingresar una palabra, en caso de no ingresar nada o ingresar m'as de lo debido
        se mostrara un mensaje, explicando como hacerlo.
       * Tambien es posible seleccionar a lo m'as el n'umero de busquedas mediante el ComboBox.
*/
package Interface;
//Utilidades
import java.util.List;
import java.util.StringTokenizer;
// Practicas
import RPCXML.*;
import Sockets.*;
import JavaRMI.*;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Launcher = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Ingresa tu busqueda...");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField1MouseEntered(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Launcher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 153, 51))); // NOI18N

        Launcher.add(jRadioButton1);
        jRadioButton1.setText("Sockets");

        Launcher.add(jRadioButton2);
        jRadioButton2.setText("RPC");

        Launcher.add(jRadioButton3);
        jRadioButton3.setText("RMI");

        Launcher.add(jRadioButton4);
        jRadioButton4.setText("CORBA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setDisabledIcon(null);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel3.setOpaque(true);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(jLabel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Monotxt_IV50", 0, 24)); // NOI18N
        jLabel1.setText("CHISTONARIO");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "20", "30", "40", "50" }));

        jLabel2.setText("N° Resultados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(92, 92, 92)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("static-access")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int num_consultas = Integer.parseInt((String) jComboBox2.getSelectedItem());
    StringTokenizer st = new StringTokenizer(jTextField1.getText());
    if (jTextField1.getText().equals("") || (st.countTokens() != 1 && st.countTokens() != 3 ) ) {
       jLabel3.setText("<html>Introduzca una consulta valida... <br>"
               + "Siga el siguiente formato: <br>"
               + "-> consulta<br>"
               + "-> consulta_1 AND consulta_2<br>"
               + "-> consulta_1 NOR consulta_2<br>"
               + "</html>");
    } else {
      if ( jRadioButton1.isSelected() == true ) {
            ClienteHilos client = new ClienteHilos();
            List<String> consultas = client.main(jTextField1.getText(),num_consultas);
                if ( consultas.size() > 0 ) {
                    String allQuery = "<html><body>";
                    for (int i = 0; i < consultas.size() ; i++) {
                       String tmp = consultas.get(i);
                       allQuery += tmp + "<br><br>";
                    }
                    allQuery += "</body></html>";
                    if (allQuery.equals("<html><body><br><br></body></html>"))
                        jLabel3.setText("No se han encontrado coincidencias...");
                    else 
                        jLabel3.setText(allQuery);
                } else {
                    if (jTextField1.getText().equals("Ingresa tu busqueda...")) {
                        jLabel3.setText("Vamos modifica la caja de texto no es tan dificil...");
                    } else {
                             jLabel3.setText("No se han encontrado coincidencias...");
                         }
                    }
             } else if ( jRadioButton2.isSelected() == true  ) {
                JavaClientRPC client = new JavaClientRPC();
                String consultas = client.main(jTextField1.getText(),num_consultas);
                if ( st.countTokens() > 0 ) {
                    String allQuery = "<html><body>"+consultas+"</body></html>";
                    if (allQuery.equals("<html><body></body></html>"))
                        jLabel3.setText("No se han encontrado coincidencias...");
                    else 
                        jLabel3.setText(allQuery);
                } else {
                    if (jTextField1.getText().equals("Ingresa tu busqueda...")) {
                        jLabel3.setText("Vamos modifica la caja de texto no es tan dificil...");
                    } else {
                        jLabel3.setText("No se han encontrado coincidencias...");
                    }
                }
             } else if ( jRadioButton3.isSelected() == true  ) {
                    ClienteJavaRMI client = new ClienteJavaRMI();
                    List<String> consultas = client.main(jTextField1.getText(),num_consultas);
                    if ( consultas.size() > 0 ) {
                        String allQuery = "<html><body>";
                        for (int i = 0; i < consultas.size() ; i++) {
                           String tmp = consultas.get(i);
                           allQuery += tmp + "<br><br>";
                        }
                        allQuery += "</body></html>";
                        if (allQuery.equals("<html><body><br><br></body></html>"))
                            jLabel3.setText("No se han encontrado coincidencias...");
                        else 
                            jLabel3.setText(allQuery);
                    } else {
                    if (jTextField1.getText().equals("Ingresa tu busqueda...")) {
                        jLabel3.setText("Vamos modifica la caja de texto no es tan dificil...");
                    } else {
                             jLabel3.setText("No se han encontrado coincidencias...");
                         }
                    }
             } else if ( jRadioButton4.isSelected() == true  ) {
                 jLabel3.setText("Corba esta de vacaciones en la playa...");
                 /*
                    Client stub = new Client();
                    stub.main(null);
                 */
             } else {
                 jLabel3.setText("Selecciona una opcion del menu.");
             }       
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseEntered
        if (jTextField1.getText().equalsIgnoreCase("Ingresa tu busqueda...")) {
            jTextField1.setText(null);
        } 
    }//GEN-LAST:event_jTextField1MouseEntered

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (jTextField1.getText().equalsIgnoreCase("Ingresa tu busqueda...")) {
            jTextField1.setText(null);
        } 
    }//GEN-LAST:event_jTextField1KeyPressed
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });  
        
        // Servidores
        Runnable r1 = new ServerSocketThread();
        Runnable r2 = new ServerXMLRPC();
        Runnable r3 = new ServerJavaRMI();
        //Manejo con hilos de manera concurrente todos los servidores se inician prioridad por defecto
        Thread s1 = new Thread(r1);
        s1.start();
        Thread s2 = new Thread(r2);
        s2.start();
        Thread s3 = new Thread(r3);
        s3.start(); 
        /* CORBA
            Runnable r0 = new ServerPOA();
            Thread   s0 = new Thread(r0);
            s0.start();
        */
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Launcher;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
