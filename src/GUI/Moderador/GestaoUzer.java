/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Moderador;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruna
 */
public class GestaoUzer extends javax.swing.JFrame {

    private Connection connection;

    /**
     * Creates new form GestaoUezer
     */
    public GestaoUzer() {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        connection = ConnectionFactory.getConnection();
        initComponents();
        atualizarListagemUezers();

    }

    private void atualizarListagemUezers() {
        try {
            // Consultar dados do banco de dados
            String sql = "SELECT * FROM uezer";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Obter o modelo de tabela
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Limpar todas as linhas existentes na tabela
            model.setRowCount(0);

            // Adicionar as linhas à tabela
            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getString("idUezer"),
                    resultSet.getString("nomeUezer"),
                    resultSet.getString("situacaoUezer"),
                    resultSet.getBoolean("aprovacaoUezer"),
                    resultSet.getString("datacadUezer")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao consultar dados do banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        btnAprovarUzer = new javax.swing.JButton();
        btnAtualizarlistagem = new javax.swing.JButton();
        btnBanirDesbanir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Listagem de Uzers");

        btnAprovarUzer.setText("Aprovar");
        btnAprovarUzer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprovarUzerActionPerformed(evt);
            }
        });

        btnAtualizarlistagem.setText("Atualizar listagem");
        btnAtualizarlistagem.setMaximumSize(new java.awt.Dimension(72, 23));
        btnAtualizarlistagem.setMinimumSize(new java.awt.Dimension(72, 23));
        btnAtualizarlistagem.setPreferredSize(new java.awt.Dimension(126, 23));
        btnAtualizarlistagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarlistagemActionPerformed(evt);
            }
        });

        btnBanirDesbanir.setText("Banir/Desbanir");
        btnBanirDesbanir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanirDesbanirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id Uzer", "Nome Uzer", "Situação", "Aprovação", "Data de Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAprovarUzer, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBanirDesbanir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarlistagem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBanirDesbanir)
                        .addGap(18, 18, 18)
                        .addComponent(btnAprovarUzer)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarlistagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarlistagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarlistagemActionPerformed
        atualizarListagemUezers();
    }//GEN-LAST:event_btnAtualizarlistagemActionPerformed

    private void btnBanirDesbanirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanirDesbanirActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String situacao = jTable1.getValueAt(selectedRow, 2).toString(); // Obtém a situação do usuário selecionado

        // Atualiza o estado do usuário selecionado
        if (situacao.equals("Ativo")) {
            updateSituacaoUsuario(selectedRow, "Banido");
            JOptionPane.showMessageDialog(null, "O Uezer foi Banido da plataforma.");
        } else if (situacao.equals("Banido")) {
            updateSituacaoUsuario(selectedRow, "Ativo");
            JOptionPane.showMessageDialog(null, "O Uezer foi Ativado na plataforma.");
        }
    }

    private void updateSituacaoUsuario(int rowIndex, String novaSituacao) {
        String idUezer = jTable1.getValueAt(rowIndex, 0).toString(); // Obtém o id do usuário selecionado

        try {
            // Atualiza o estado do usuário no banco de dados
            String sql = "UPDATE uezer SET situacaoUezer = ? WHERE idUezer = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novaSituacao);
            statement.setString(2, idUezer);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Atualiza a tabela com a nova situação do usuário
                jTable1.setValueAt(novaSituacao, rowIndex, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a situação do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a situação do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBanirDesbanirActionPerformed

    private void btnAprovarUzerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprovarUzerActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum Uzer selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean aprovacao = (boolean) jTable1.getValueAt(selectedRow, 3); // Obtém a aprovação do Uzer selecionado

        // Atualiza a aprovação do Uzer selecionado
        try {
            String idUzer = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do Uzer selecionado

            // Atualiza a aprovação do Uzer no banco de dados
            String sql = "UPDATE uzer SET aprovacaoUzer = ? WHERE idUzer = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, !aprovacao);
            statement.setString(2, idUzer);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Atualiza a tabela com a nova aprovação do Uzer
                jTable1.setValueAt(!aprovacao, selectedRow, 3);
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a aprovação do Uzer.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a aprovação do Uzer.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAprovarUzerActionPerformed

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
            java.util.logging.Logger.getLogger(GestaoUzer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestaoUzer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestaoUzer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestaoUzer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestaoUzer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAprovarUzer;
    private javax.swing.JButton btnAtualizarlistagem;
    private javax.swing.JButton btnBanirDesbanir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}