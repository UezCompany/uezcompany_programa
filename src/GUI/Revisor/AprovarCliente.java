/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Revisor;

import Factory.ConnectionFactory;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.Loader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author renat
 */
public class AprovarCliente extends javax.swing.JFrame {

    /**
     * Creates new form AceitarUzer
     *
     *
     */
    private class PDFViewerPanel extends JPanel {

        private BufferedImage image;

        public PDFViewerPanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private Connection connection;

    public AprovarCliente() {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        connection = ConnectionFactory.getConnection();
        initComponents();
        atualizarListagemClientes();
    }

    private void atualizarListagemClientes() {
        try {
            // Consultar dados do banco de dados
            String sql = "SELECT * FROM cliente";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Obter o modelo de tabela
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Limpar todas as linhas existentes na tabela
            model.setRowCount(0);

            // Adicionar as linhas à tabela
            while (resultSet.next()) {
                boolean reprovado = resultSet.getBoolean("reprovacaoCliente");
                boolean aprovado = resultSet.getBoolean("aprovacaoCliente");

                if ((reprovado || (!reprovado && !aprovado))) {
                    Object[] rowData = {
                        resultSet.getString("idCliente"),
                        resultSet.getString("datacadCliente"),
                        "Oculto",
                        resultSet.getString("cpfCliente"),
                        reprovado,
                        resultSet.getString("nomeCliente")
                    };
                    model.addRow(rowData);
                }
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

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Aprovação");
        setMinimumSize(new java.awt.Dimension(640, 360));

        ImageIcon icon = new ImageIcon(getClass().getResource("../Imagem/fundoprograma2.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }};
            jPanel1.setLayout(null);

            jTable1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String [] {
                    "ID", "Data de Cadastro", "Antecedentes", "CPF", "Reprovado", "Nome"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
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
            jScrollPane1.setViewportView(jTable1);

            jPanel1.add(jScrollPane1);
            jScrollPane1.setBounds(47, 99, 508, 318);

            jButton1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton1.setText("Aprovar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton1);
            jButton1.setBounds(581, 106, 100, 22);

            jButton2.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton2.setText("Reprovar");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton2);
            jButton2.setBounds(581, 140, 100, 22);

            jButton3.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton3.setText("Atualizar");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton3);
            jButton3.setBounds(581, 174, 100, 22);

            jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Aprovação de Clientes");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(227, 36, 220, 23);

            jButton5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton5.setText("Exibir pdf");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });
            jPanel1.add(jButton5);
            jButton5.setBounds(581, 208, 100, 22);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idCliente = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do cliente selecionado

        try {
            String sql = "Select * from cliente where idCliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                boolean aprovado = resultSet.getBoolean("aprovacaoCliente");
                if (aprovado) {
                    return;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean aprovacao = (boolean) jTable1.getValueAt(selectedRow, 4); // Obtém a aprovação do cliente selecionado

        // Atualiza a aprovação do cliente selecionado
        try {
            // Atualiza a aprovação do cliente no banco de dados
            String sql = "UPDATE cliente SET aprovacaoCliente = ?, reprovacaoCliente = ? WHERE idCliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setBoolean(2, false);
            statement.setString(3, idCliente);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Atualiza a tabela com a nova aprovação do cliente
                jTable1.setValueAt(false, selectedRow, 4);
                JOptionPane.showMessageDialog(this, "O cliente foi aprovado");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a aprovação do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a aprovação do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        atualizarListagemClientes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        atualizarListagemClientes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean aprovacao = (boolean) jTable1.getValueAt(selectedRow, 4); // Obtém a aprovação do cliente selecionado

        // Atualiza a aprovação do cliente selecionado
        try {
            String idCliente = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do cliente selecionado

            // Atualiza a aprovação do cliente no banco de dados
            String sql = "UPDATE cliente SET reprovacaoCliente = ?, aprovacaoCliente = ? WHERE idCliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setBoolean(2, false);
            statement.setString(3, idCliente);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Atualiza a tabela com a nova aprovação do cliente
                jTable1.setValueAt(true, selectedRow, 4);
                JOptionPane.showMessageDialog(this, "O cliente foi reprovado");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a aprovação do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a aprovação do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        atualizarListagemClientes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String idCliente = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do cliente selecionado

            // Consultar o PDF do banco de dados
            String sql = "SELECT historicocriminalCliente FROM cliente WHERE idCliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idCliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Obter o PDF do banco de dados
                byte[] pdfBytes = resultSet.getBytes("historicocriminalCliente");

                // Carregar o PDF como um documento
                try ( PDDocument document = Loader.loadPDF(pdfBytes)) {
                    PDFRenderer renderer = new PDFRenderer(document);
                    BufferedImage image = renderer.renderImage(0); // Renderiza a primeira página do PDF como uma imagem

                    JFrame frame = new JFrame("Visualizador de PDF");
                    frame.setSize(630, 891);//210 × 297
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    PDFViewerPanel viewerPanel = new PDFViewerPanel(image);
                    frame.add(viewerPanel);

                    frame.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum PDF encontrado para o cliente selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao obter o PDF do banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(AprovarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AprovarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AprovarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AprovarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AprovarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
