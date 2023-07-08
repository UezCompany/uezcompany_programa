/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Moderador;

import Factory.ConnectionFactory;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
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
     * Creates new form GestaoUzer
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
        atualizarListagemUzers();

    }

    private void atualizarListagemUzers() {
        try {
            // Consultar dados do banco de dados
            String sql = "SELECT * FROM uzer WHERE aprovacaoUzer = true";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Obter o modelo de tabela
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Limpar todas as linhas existentes na tabela
            model.setRowCount(0);

            // Adicionar as linhas à tabela
            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getString("idUzer"),
                    resultSet.getString("nomeUzer"),
                    resultSet.getString("situacaoUzer"),
                    resultSet.getBoolean("aprovacaoUzer"),
                    resultSet.getString("datacadUzer"),
                    resultSet.getDouble("avaliacaoUzer")
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
        btnAtualizarlistagem = new javax.swing.JButton();
        btnBanirDesbanir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listagem de Uzers");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 29, 180, -1));

        btnAtualizarlistagem.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAtualizarlistagem.setText("Atualizar listagem");
        btnAtualizarlistagem.setMaximumSize(new java.awt.Dimension(72, 23));
        btnAtualizarlistagem.setMinimumSize(new java.awt.Dimension(72, 23));
        btnAtualizarlistagem.setPreferredSize(new java.awt.Dimension(126, 23));
        btnAtualizarlistagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarlistagemActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarlistagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 172, 150, -1));

        btnBanirDesbanir.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnBanirDesbanir.setText("Banir/Desbanir");
        btnBanirDesbanir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanirDesbanirActionPerformed(evt);
            }
        });
        getContentPane().add(btnBanirDesbanir, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 90, 150, -1));

        jTable1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Uzer", "Nome Uzer", "Situação", "Aprovação", "Data de Cadastro", "Avaliação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 72, 658, -1));

        ImageIcon icon = new ImageIcon(getClass().getResource("../Imagem/fundoprograma2.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }};

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 540));

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarlistagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarlistagemActionPerformed
        atualizarListagemUzers();
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
            String idUzer = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do usuário selecionado
            BanirUzer banirUzerFrame = new BanirUzer(idUzer); // Cria a tela BanirUzer com o ID como parâmetro
            banirUzerFrame.setVisible(true); // Exibe a tela BanirUzer
        } else if (situacao.equals("Banido")) {
            updateSituacaoUsuario(selectedRow, "Ativo");
            JOptionPane.showMessageDialog(null, "O Uzer foi Ativado na plataforma.");
        }
    }

    private void updateSituacaoUsuario(int rowIndex, String novaSituacao) {
        String idUzer = jTable1.getValueAt(rowIndex, 0).toString(); // Obtém o id do usuário selecionado

        try {
            // Atualiza o estado do usuário no banco de dados
            String sql = "UPDATE Uzer SET situacaoUzer = ? WHERE idUzer = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novaSituacao);
            statement.setString(2, idUzer);
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
    private javax.swing.JButton btnAtualizarlistagem;
    private javax.swing.JButton btnBanirDesbanir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
