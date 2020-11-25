
package views;

import entities.Evento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import services.EventoService;
import types.TipoEventoType;

public class TelaEvento extends javax.swing.JDialog {

    private Evento entitySearch;
    private Evento entity;
    private final EventoService eventoService;
    
    public TelaEvento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        eventoService = new EventoService();
        
        entitySearch = new Evento();
        
        comboSearchTipoEvento.removeAllItems();
        
        comboSearchTipoEvento.addItem("");
        
        for ( TipoEventoType tipoEvento : TipoEventoType.values() ) {
            comboSearchTipoEvento.addItem(tipoEvento.getValue());
        }
    }
    
    private void load() {
        if (!fieldSearchId.getText().equals("")) {
            entitySearch.setId(Integer.valueOf(fieldSearchId.getText()));
        }
        
        if (!fieldSearchNome.getText().equals("")) {
            entitySearch.setNomeEvento(fieldSearchNome.getText());
        }
        
        if (comboSearchTipoEvento.getSelectedIndex() != 0) {
            entitySearch.setTipoEvento(Arrays.asList(TipoEventoType.values()).get(comboSearchTipoEvento.getSelectedIndex()-1));
        }
        
        populateTable(eventoService.find(entitySearch));
        
        entitySearch = new Evento();
    }
    
    private void populateTable(List<Evento> list) {
        DefaultTableModel model = (DefaultTableModel) tableEvento.getModel();
        Object rowData[] = new Object[4];
        model.setRowCount(0);
        
        for ( Evento evento : list ) {
            rowData[0] = evento.getId();
            rowData[1] = evento.getNomeEvento();
            rowData[2] = evento.getTipoEvento().getValue();
            rowData[3] = evento.getDataEvento();

            model.addRow(rowData);
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

        dialogInsert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        fieldInsertNome = new javax.swing.JTextField();
        buttonInsertSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboInsertTipoEvento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        formatedFieldInsertDataEvento = new javax.swing.JFormattedTextField();
        dialogUpdate = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldUpdateNome = new javax.swing.JTextField();
        fieldUpdateId = new javax.swing.JTextField();
        buttonUpdateSalvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboUpdateTipoEvento = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        formatedFieldUpdateDataEvento = new javax.swing.JFormattedTextField();
        buttonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEvento = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fieldSearchId = new javax.swing.JTextField();
        fieldSearchNome = new javax.swing.JTextField();
        buttonPesquisar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        comboSearchTipoEvento = new javax.swing.JComboBox<>();

        dialogInsert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInsert.setTitle("Cadastrar Produto");
        dialogInsert.setModal(true);
        dialogInsert.setResizable(false);
        dialogInsert.setSize(new java.awt.Dimension(360, 200));

        jLabel6.setText("Nome:");

        buttonInsertSalvar.setText("Salvar");
        buttonInsertSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertSalvarActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Evento:");

        jLabel8.setText("Data:");

        javax.swing.GroupLayout dialogInsertLayout = new javax.swing.GroupLayout(dialogInsert.getContentPane());
        dialogInsert.getContentPane().setLayout(dialogInsertLayout);
        dialogInsertLayout.setHorizontalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInsertSalvar)
                            .addGroup(dialogInsertLayout.createSequentialGroup()
                                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboInsertTipoEvento, 0, 200, Short.MAX_VALUE)
                                    .addComponent(fieldInsertNome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(formatedFieldInsertDataEvento))))
                        .addGap(0, 88, Short.MAX_VALUE))))
        );
        dialogInsertLayout.setVerticalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboInsertTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(formatedFieldInsertDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(buttonInsertSalvar)
                .addContainerGap())
        );

        dialogUpdate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogUpdate.setTitle("Atualizar Produto");
        dialogUpdate.setModal(true);
        dialogUpdate.setResizable(false);
        dialogUpdate.setSize(new java.awt.Dimension(300, 300));

        jLabel4.setText("Nome:");

        jLabel5.setText("ID:");

        fieldUpdateId.setEditable(false);

        buttonUpdateSalvar.setText("Salvar");
        buttonUpdateSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateSalvarActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo Evento:");

        jLabel9.setText("Data:");

        javax.swing.GroupLayout dialogUpdateLayout = new javax.swing.GroupLayout(dialogUpdate.getContentPane());
        dialogUpdate.getContentPane().setLayout(dialogUpdateLayout);
        dialogUpdateLayout.setHorizontalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(235, Short.MAX_VALUE))
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonUpdateSalvar)
                            .addComponent(jLabel4)
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboUpdateTipoEvento, 0, 150, Short.MAX_VALUE)
                                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(formatedFieldUpdateDataEvento))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        dialogUpdateLayout.setVerticalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboUpdateTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(formatedFieldUpdateDataEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(buttonUpdateSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        tableEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEvento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEvento);
        if (tableEvento.getColumnModel().getColumnCount() > 0) {
            tableEvento.getColumnModel().getColumn(0).setMinWidth(50);
            tableEvento.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableEvento.getColumnModel().getColumn(0).setMaxWidth(50);
            tableEvento.getColumnModel().getColumn(1).setResizable(false);
            tableEvento.getColumnModel().getColumn(2).setResizable(false);
            tableEvento.getColumnModel().getColumn(3).setMinWidth(100);
            tableEvento.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableEvento.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel3.setText("Tipo Evento:");

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboSearchTipoEvento, 0, 131, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldSearchNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldSearchId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSearchTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Evento();
                entity.setId((Integer) tableEvento.getValueAt(tableEvento.getSelectedRow(), 0));

                entity = eventoService.find(entity).get(0);

                fieldUpdateId.setText(String.valueOf(entity.getId()));
                fieldUpdateNome.setText(entity.getNomeEvento());
                formatedFieldUpdateDataEvento.setText(new SimpleDateFormat("dd/MM/yyyy").format(entity.getDataEvento()));
                
                comboUpdateTipoEvento.removeAllItems();
                
                for ( TipoEventoType ativo : TipoEventoType.values() ) {
                    comboUpdateTipoEvento.addItem(ativo.getValue());
                }
                
                comboUpdateTipoEvento.setSelectedIndex(Arrays.asList(TipoEventoType.values()).indexOf(entity.getTipoEvento()));

                dialogUpdate.setLocationRelativeTo(null);
                dialogUpdate.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        load();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Evento();

                fieldInsertNome.setText("");
                formatedFieldInsertDataEvento.setText("");

                dialogInsert.setLocationRelativeTo(null);
                dialogInsert.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNomeEvento(fieldInsertNome.getText());
                entity.setTipoEvento(Arrays.asList(TipoEventoType.values()).get(comboInsertTipoEvento.getSelectedIndex()));
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(sdf.parse(formatedFieldInsertDataEvento.getText()));
                    
                    entity.setDataEvento(sdf.parse(formatedFieldInsertDataEvento.getText()));
                } catch (ParseException ex) {
                    Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                eventoService.insert(entity);
                
                fieldInsertNome.setText("");
                formatedFieldInsertDataEvento.setText("");
                
                dialogInsert.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonUpdateSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNomeEvento(fieldUpdateNome.getText());
                entity.setTipoEvento(Arrays.asList(TipoEventoType.values()).get(comboUpdateTipoEvento.getSelectedIndex()));
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(sdf.parse(formatedFieldUpdateDataEvento.getText()));
                    
                    entity.setDataEvento(sdf.parse(formatedFieldUpdateDataEvento.getText()));
                } catch (ParseException ex) {
                    Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                eventoService.update(entity);
                
                fieldUpdateNome.setText("");
                formatedFieldUpdateDataEvento.setText("");
                
                dialogUpdate.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonUpdateSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaEvento dialog = new TelaEvento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonUpdateSalvar;
    private javax.swing.JComboBox<String> comboInsertTipoEvento;
    private javax.swing.JComboBox<String> comboSearchTipoEvento;
    private javax.swing.JComboBox<String> comboUpdateTipoEvento;
    private javax.swing.JDialog dialogInsert;
    private javax.swing.JDialog dialogUpdate;
    private javax.swing.JTextField fieldInsertNome;
    private javax.swing.JTextField fieldSearchId;
    private javax.swing.JTextField fieldSearchNome;
    private javax.swing.JTextField fieldUpdateId;
    private javax.swing.JTextField fieldUpdateNome;
    private javax.swing.JFormattedTextField formatedFieldInsertDataEvento;
    private javax.swing.JFormattedTextField formatedFieldUpdateDataEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEvento;
    // End of variables declaration//GEN-END:variables
}
