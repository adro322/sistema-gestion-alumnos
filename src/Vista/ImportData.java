/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Dao.alumnosDao; 
import Servicio.AlumnosService;
import Modelo.Alumnos;
import Modelo.Sedes;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ImportData extends javax.swing.JInternalFrame {

    // --- VARIABLES GLOBALES ---
    // 1. Instanciamos el DAO concreto (la herramienta)
    alumnosDao dao = new alumnosDao();
    // 2. Instanciamos el Servicio inyectándole el DAO (el jefe que usa la herramienta)
    AlumnosService service = new AlumnosService(dao);
    // 3. Objeto auxiliar para recoger datos de la caja de texto
    Alumnos en = new Alumnos();

    public ImportData() {
        initComponents();
        txtId.setVisible(false);
        // Llenar ComboBoxes usando el SERVICIO (Ya no el DAO directo)
        cargarComboSedes();
        cargarComboEstado();
        try {
            this.setMaximum(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }

    }

    // --- MÉTODOS AUXILIARES DE LA VISTA (UI) ---
    // Método privado para llenar el Combo de Sedes
    private void cargarComboSedes() {
        cbxSede.removeAllItems();
        cbxSede.addItem("Seleccione la Sede");

        List<Sedes> lista = service.obtenerListaSedes();

        for (Sedes s : lista) {
            cbxSede.addItem(s.getNombre());
        }
    }

    // Método simple para el estado (ya que son datos fijos)
    private void cargarComboEstado() {
        cbxEstado.removeAllItems();
        cbxEstado.addItem("Seleccione Estado");
        cbxEstado.addItem("activo");
        cbxEstado.addItem("egresado");
        cbxEstado.addItem("retirado");
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtCod.setText("");
        txtDNI.setText("");
        txtTelf.setText("");
        txtNom.setText("");
        txtApe.setText("");
        txtCarrera.setText("");
        txtCiclo.setText("");
        txtEmail.setText("");
        txtPromedio.setText("");
        cbxEstado.setSelectedIndex(0);
        cbxSede.setSelectedIndex(0);
        txtCod.requestFocus();
    }

    // Método para pintar la tabla (Reutilizable)
    private void llenarTabla(List<Alumnos> listaDatos, javax.swing.JTable tablaDestino) {
        String[] titulos = {
            "ID", "Código", "DNI", "Teléfono", "Nombres", "Apellidos",
            "Carrera", "Ciclo", "Email", "Promedio", "Estado",
            "Fecha Ingreso", "Sede"};

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        for (Alumnos a : listaDatos) {
            Object[] fila = {
                a.getId(),
                a.getCodigo(),
                a.getDni(),
                a.getTelefono(),
                a.getNombres(),
                a.getApellidos(),
                a.getCarrera(),
                a.getCiclo(),
                a.getEmail(),
                a.getPromedio(),
                a.getEstado(),
                a.getFecha_ingreso(),
                a.getNombreSede() 
            };
            modelo.addRow(fila);
        }
        tablaDestino.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarDatos = new javax.swing.JButton();
        btnImportarDatos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aña = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtTelf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        cbxSede = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        txtCiclo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        aña1 = new javax.swing.JLabel();
        txtPromedio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(37, 44, 73));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Importa tus datos a la base de datos, para luego visualizarlas aqui");

        btnMostrarDatos.setBackground(new java.awt.Color(55, 83, 126));
        btnMostrarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMostrarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarDatos.setText("Mostrar Datos Importados");
        btnMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDatosActionPerformed(evt);
            }
        });

        btnImportarDatos.setBackground(new java.awt.Color(55, 83, 126));
        btnImportarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImportarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnImportarDatos.setText("Importar Datos");
        btnImportarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnMostrarDatos)
                .addContainerGap(635, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImportarDatos)
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportarDatos)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrarDatos)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        tablaAlumnos.setBackground(new java.awt.Color(37, 44, 73));
        tablaAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Importar Datos", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(37, 44, 73));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por Apellidos:");

        txtApellido.setBackground(new java.awt.Color(163, 184, 227));

        btnBuscar.setBackground(new java.awt.Color(55, 83, 126));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jTable1.setBackground(new java.awt.Color(37, 44, 73));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Buscar Alumno", jPanel2);

        jPanel3.setBackground(new java.awt.Color(37, 44, 73));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBackground(new java.awt.Color(37, 44, 73));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel6.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombres:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellidos:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        aña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aña.setForeground(new java.awt.Color(255, 255, 255));
        aña.setText("Sede:");
        jPanel6.add(aña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Carrera:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        txtCod.setBackground(new java.awt.Color(163, 184, 227));
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        jPanel6.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 104, 32));

        txtDNI.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 104, 32));

        txtNom.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 638, 32));

        txtApe.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtApe, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 638, 32));

        txtTelf.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 437, 32));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefono:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(55, 83, 126));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 106, 35));

        btnEliminar.setBackground(new java.awt.Color(55, 83, 126));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 112, 47));

        btnActualizar.setBackground(new java.awt.Color(55, 83, 126));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel6.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 112, 47));

        btnCerrar.setBackground(new java.awt.Color(55, 83, 126));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 112, 47));

        cbxSede.setBackground(new java.awt.Color(163, 184, 227));
        cbxSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cbxSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 638, 36));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ciclo:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        txtCarrera.setBackground(new java.awt.Color(163, 184, 227));
        txtCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarreraActionPerformed(evt);
            }
        });
        jPanel6.add(txtCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 638, 33));

        txtCiclo.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 247, 33));

        txtEmail.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 287, 33));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        aña1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aña1.setForeground(new java.awt.Color(255, 255, 255));
        aña1.setText("Promedio:");
        jPanel6.add(aña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        txtPromedio.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 246, 33));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, -1, -1));

        cbxEstado.setBackground(new java.awt.Color(163, 184, 227));
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 288, 33));

        txtId.setBackground(new java.awt.Color(163, 184, 227));
        jPanel6.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Swis721 BT", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CRUD - ALUMNOS");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(jPanel6, gridBagConstraints);

        jTabbedPane1.addTab("CRUD Alumnos", jPanel3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            int fila = jTable1.getSelectedRow();

            // Orden de columnas según tabla:
            txtId.setText(jTable1.getValueAt(fila, 0).toString()); // ID está en la columna 0
            txtCod.setText(jTable1.getValueAt(fila, 1).toString());       // ID
            txtDNI.setText(jTable1.getValueAt(fila, 2).toString());       // DNI
            txtTelf.setText(jTable1.getValueAt(fila, 3).toString());      // Teléfono
            txtNom.setText(jTable1.getValueAt(fila, 4).toString());       // Nombres
            txtApe.setText(jTable1.getValueAt(fila, 5).toString());       // Apellidos
            txtCarrera.setText(jTable1.getValueAt(fila, 6).toString());   // Carrera
            txtCiclo.setText(jTable1.getValueAt(fila, 7).toString());     // Ciclo
            txtEmail.setText(jTable1.getValueAt(fila, 8).toString());     // Email
            cbxSede.setSelectedItem(jTable1.getValueAt(fila, 12));         // Sede
            txtPromedio.setText(jTable1.getValueAt(fila, 9).toString()); // Promedio
            cbxEstado.setSelectedItem(jTable1.getValueAt(fila, 10));      // Estado

            jTabbedPane1.setSelectedIndex(2); // Cambiar de pestaña para editar
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnImportarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarDatosActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo Excel");

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            // Validar extensión (Responsabilidad UI)
            if (!archivo.getName().endsWith(".xlsx")) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un archivo .xlsx");
                return;
            }
            // --- LLAMADA AL SERVICIO ---
            // El UI se congela esperando, el servicio trabaja (lee excel -> conecta BD -> guarda)
            String resultado = service.importarDesdeExcel(archivo);

            JOptionPane.showMessageDialog(this, resultado);

            // Refrescamos la tabla automáticamente para ver los nuevos datos
            btnMostrarDatosActionPerformed(null);
        }
    }//GEN-LAST:event_btnImportarDatosActionPerformed

    private void btnMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDatosActionPerformed
        // Pedimos la lista al servicio
        List<Alumnos> lista = service.obtenerTodosLosAlumnos();
        // Se la pasamos a nuestro método pintor
        llenarTabla(lista, tablaAlumnos);
    }//GEN-LAST:event_btnMostrarDatosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un apellido para buscar");
            return;
        }
        // Llamamos al servicio
        List<Alumnos> resultados = service.buscarPorApellido(txtApellido.getText());

        System.out.println("Coincidencias encontradas: " + resultados.size());
        System.out.println("Filas cargadas: " + jTable1.getRowCount());
        System.out.println("Columnas: " + jTable1.getColumnCount());

        llenarTabla(resultados, jTable1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //Validación básica de UI: Verificar que hay un ID seleccionado
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un alumno de la tabla primero.");
            return;
        }

        try {
            en.setId(Integer.parseInt(txtId.getText())); 
            en.setCodigo(txtCod.getText());
            en.setDni(txtDNI.getText());
            en.setTelefono(txtTelf.getText());
            en.setNombres(txtNom.getText());
            en.setApellidos(txtApe.getText());
            en.setCarrera(txtCarrera.getText());
            en.setCiclo(txtCiclo.getText()); 
            en.setEmail(txtEmail.getText());
            en.setPromedio(Double.parseDouble(txtPromedio.getText()));
            en.setEstado(cbxEstado.getSelectedItem().toString());
            en.setId_sede(cbxSede.getSelectedIndex());

            // El servicio validará reglas de negocio y llamará al DAO
            String mensaje = service.actualizarAlumno(en);

            // Mostrar resultado
            JOptionPane.showMessageDialog(this, mensaje);

            // Si fue exitoso, limpiar y refrescar tabla
            if (mensaje.toLowerCase().contains("actualizado")) {
                limpiarCampos();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos (Promedio o ID): " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Validación: ¿Tenemos un ID para eliminar?
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona un alumno de la tabla para eliminar.");
            return;
        }

        // Confirmación (Esto es responsabilidad de la Vista)
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de eliminar al alumno con ID: " + txtId.getText() + "?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int idEliminar = Integer.parseInt(txtId.getText());

                //LLAMADA AL SERVICIO
                String mensaje = service.eliminarAlumno(idEliminar);

                // Mostrar resultado
                JOptionPane.showMessageDialog(this, mensaje);

                limpiarCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al intentar eliminar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        en.setCodigo(txtCod.getText());
        en.setDni(txtDNI.getText());
        en.setTelefono(txtTelf.getText());
        en.setNombres(txtNom.getText());
        en.setApellidos(txtApe.getText());
        en.setCarrera(txtCarrera.getText());
        en.setCiclo(txtCiclo.getText());
        en.setEmail(txtEmail.getText());
        try {
            en.setPromedio(Double.parseDouble(txtPromedio.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El promedio debe ser un número");
            return;
        }
        en.setEstado(cbxEstado.getSelectedItem().toString());
        en.setId_sede(cbxSede.getSelectedIndex()); 

        // Ya no validamos lógica aquí, se lo mandamos al Service
        String respuesta = service.registrarAlumno(en);

        // Mostramos lo que dijo el servicio
        JOptionPane.showMessageDialog(this, respuesta);

        if (respuesta.contains("éxito") || respuesta.contains("correctamente")) {
            limpiarCampos(); 
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aña;
    private javax.swing.JLabel aña1;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImportarDatos;
    private javax.swing.JButton btnMostrarDatos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPromedio;
    private javax.swing.JTextField txtTelf;
    // End of variables declaration//GEN-END:variables
}
