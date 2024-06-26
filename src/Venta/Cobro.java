package Venta;


import DBObjetos.Producto;
import DBObjetos.Usuario;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import login.SesionManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author frix4
 */
public class Cobro extends javax.swing.JFrame {

    /**
     * Creates new form Cobro
     */
    private double pre; // Total a pagar
    private double cambio;
    NumeroEnPalabras converter = new NumeroEnPalabras();
    String precioEnLetras;
    List<Producto> productos;  // Lista de productos para generar el ticket
    private VentaListener ventaListener;
    
    public interface VentaListener {
        void onVentaCompleta();
    }
    
    public Cobro() {
        initComponents();
        
        
        double importe = Double.parseDouble(recibi.getText());  
        
        precio.setText("$" + pre);
        precioEnLetras = converter.convertir(pre);
        letras.setText(precioEnLetras);
        
        if(importe >= pre){
            
        }
        
        agregarListeners();

                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Asegura que solo se cierre esta ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Venta.getInstance().setVisible(true); // Vuelve a hacer visible la ventana de venta
            }
        });
    }


  
    
    public Cobro(double total, List<Producto> productos) {
        initComponents();
        this.productos = productos;
        this.pre = total;
        precio.setText("$" + String.format("%.2f", total));
        precioEnLetras = converter.convertir(total);
        letras.setText(precioEnLetras);

        agregarListeners();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Asegura que solo se cierre esta ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Venta.getInstance().setVisible(true); // Vuelve a hacer visible la ventana de venta
            }
        });
    }

    
    public void setVentaListener(VentaListener listener) {
        this.ventaListener = listener;
    }
    
    private void agregarListeners() {
        recibi.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calcularCambio();
            }
            public void removeUpdate(DocumentEvent e) {
                calcularCambio();
            }
            public void insertUpdate(DocumentEvent e) {
                calcularCambio();
            }
        });
    }
    
    private void calcularCambio() {
        try {
            double montoRecibido = Double.parseDouble(recibi.getText());
            if (montoRecibido >= pre) {
                cambio = montoRecibido - pre;
                camb.setText(String.format("$%.2f", cambio));
            } else {
                camb.setText("Insuficiente");
            }
        } catch (NumberFormatException e) {
            camb.setText("");  // Limpiar el texto si el campo está vacío o no es numérico
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        letras = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        recibi = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        efectivo = new javax.swing.JRadioButton();
        tarjeta = new javax.swing.JRadioButton();
        camb = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setText("Total a pagar:");

        precio.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precio.setText("$0.00");

        letras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        letras.setText("cero");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 91, Short.MAX_VALUE)
                .addComponent(letras, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(letras, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setText("Recibo");

        jLabel10.setText("Cambio");

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(0, 255, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        buttonGroup1.add(efectivo);
        efectivo.setText("Efectivo");
        efectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        efectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                efectivoMouseClicked(evt);
            }
        });

        buttonGroup1.add(tarjeta);
        tarjeta.setText("Tarjeta (Credito / Debito)");

        camb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder("Correo Electronico"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCorreo)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(efectivo)
                    .addComponent(tarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recibi, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(camb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(efectivo)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tarjeta)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recibi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(camb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnAceptar))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void efectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_efectivoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_efectivoMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    // Primero, verifica si algún método de pago ha sido seleccionado.
    if (!efectivo.isSelected() && !tarjeta.isSelected()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un método de pago.");
        return;
    }

    // Intenta procesar el pago y generar/enviar el ticket.
    try {
        double pago = Double.parseDouble(recibi.getText());  // Intenta obtener el pago ingresado.
        if (pago < pre) {
            JOptionPane.showMessageDialog(this, "El monto pagado no es suficiente para cubrir el total de la compra.");
            return;
        }
        cambio = pago - pre;
        camb.setText("$" + String.format("%.2f", cambio));

        // Genera el ticket y obtiene la ruta del PDF generado.
        String pdfPath = generarPDF(productos, pre, pago, cambio);
        if (pdfPath != null) {
            // Si el archivo PDF se generó correctamente, procede a enviarlo por correo.
            String emailDestino = txtCorreo.getText();
            if (!emailDestino.isEmpty()) {
                EnvioTicket.enviarConArchivo(emailDestino, pdfPath);  // Enviar el PDF por correo
                JOptionPane.showMessageDialog(this, "El ticket ha sido enviado correctamente a: " + emailDestino);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo electrónico válido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar el ticket PDF.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, introduzca un monto válido en el campo 'Recibí'.");
    }


    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    
    private String generarPDF(List<Producto> productosSeleccionados, double total, double pago, double cambio) {
        Document document = new Document();
        String fileName = "Ticket_" + System.currentTimeMillis() + ".pdf";  // Nombre del archivo con marca de tiempo
        String filePath = "./tickets/" + fileName;  // Guardar en un directorio específico
        LocalDateTime fechaActual= LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = fechaActual.format(formato);

        // Asegúrate de que el directorio tickets existe o créalo
        new File("./tickets").mkdirs();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            
            Usuario usuario = SesionManager.getInstance().getUsuarioLogueado();

            Font bold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normal = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font gigante = FontFactory.getFont(FontFactory.HELVETICA,16);
            
            Paragraph Titulo = new Paragraph("ABARROTES DON LUIS", gigante);
            Titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(Titulo);   
            
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            
            document.add(new Paragraph("Ticket de compra",normal));
            document.add(new Paragraph("Cajero: " + usuario.getNombreCompleto()));
            
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            
            Paragraph fechaParrafo = new Paragraph("Fecha y Hora: " + fechaHoraFormateada, normal);
            fechaParrafo.setAlignment(Element.ALIGN_RIGHT);
            document.add(fechaParrafo);            
            document.add(new Paragraph(" "));
            document.add(new Paragraph("")); 
            
            document.add(new Paragraph("RFC: VECJ880326", normal));
            document.add(new Paragraph("Régimen fiscal: 601-Ley General de Personas Morales", normal));
            document.add(new Paragraph("Emitido en: Heroica Escuela Naval Militar 917, Reforma Centro, 68050 Oaxaca de Juárez, Oax", normal));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            

            PdfPTable table = new PdfPTable(new float[]{1, 2, 1, 1, 1});
            table.setWidthPercentage(100);
            String[] headers = {"Código", "Producto", "Unidades", "Precio Uni.", "Importe"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header, bold));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
            }

            for (Producto producto : productosSeleccionados) {
                PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(producto.getProductoID()), normal));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(producto.getNombre(), normal));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(String.valueOf(producto.getCantidad()), normal));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(String.format("$%.2f", producto.getPrecio()), normal));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(String.format("$%.2f", producto.getPrecio() * producto.getCantidad()), normal));
                cell.setBorder(PdfPCell.NO_BORDER);
                table.addCell(cell);
            }

            document.add(table);
            
            
            document.add(new Paragraph(" "));            
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            
            Paragraph totalParrafo = new Paragraph(String.format("Total: $%.2f", total), bold);
            totalParrafo.setAlignment(Element.ALIGN_RIGHT);
            document.add(totalParrafo);

            Paragraph pagoParrafo = new Paragraph(String.format("Pago en efectivo: $%.2f", pago), normal);
            pagoParrafo.setAlignment(Element.ALIGN_RIGHT);
            document.add(pagoParrafo);

            Paragraph cambioParrafo = new Paragraph(String.format("Cambio: $%.2f", cambio), normal);
            cambioParrafo.setAlignment(Element.ALIGN_RIGHT);
            document.add(cambioParrafo);
                        
            document.add(new Paragraph(" "));            
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph graciasParrafo = new Paragraph("¡GRACIAS POR SU COMPRA!", bold);
            graciasParrafo.setAlignment(Element.ALIGN_CENTER);
            document.add(graciasParrafo);
            
            
            document.close();

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(filePath));  // Opcional: abrir el archivo automáticamente
            }

            return filePath;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el ticket: " + e.getMessage());
            return null;
        }
    }



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
            java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cobro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel camb;
    private javax.swing.JRadioButton efectivo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel letras;
    private javax.swing.JLabel precio;
    private javax.swing.JTextField recibi;
    private javax.swing.JRadioButton tarjeta;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
