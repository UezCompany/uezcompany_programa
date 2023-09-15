/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Revisor;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author renat
 */
public class AprovarUzer extends javax.swing.JFrame {

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

    public AprovarUzer() {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initComponents();
        atualizarListagemUzers();
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
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("../Imagem/fundoprograma2.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }};

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

            jButton1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton1.setText("Aprovar");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton2.setText("Reprovar");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jButton3.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton3.setText("Atualizar");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Aprovação de Uzers");

            jButton5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
            jButton5.setText("Exibir pdf");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(34, 34, 34))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(233, 233, 233))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton5)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void atualizarListagemUzers() {
        try {
            // Defina a URL da sua API para obter a lista de Uzers
            String apiUrl = "http://localhost:3333/api/funcionariosSearch/uzers";

            // Abra uma conexão HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar a conexão para um método GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer Renatchingaymuitolegal898989");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Ler a resposta JSON
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse do JSON de resposta
                JSONArray jsonArray = new JSONArray(response.toString());

                // Obter o modelo de tabela
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                // Limpar todas as linhas existentes na tabela
                model.setRowCount(0);

                // Adicionar as linhas à tabela
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    // Aqui, você precisa adaptar os nomes dos campos de acordo com a estrutura da sua API
                    String idUzer = jsonObject.getString("_id");
                    String dataCadastro = jsonObject.getString("dataCadastro");
                    String cpfUzer = jsonObject.getString("CPF");
                    boolean aprovado = jsonObject.getBoolean("aprovacao");
                    boolean reprovado = jsonObject.getBoolean("reprovacao");
                    String nomeUzer = jsonObject.getString("nome");

                    if (!aprovado) {
                        Object[] rowData = {
                            idUzer,
                            dataCadastro,
                            "Oculto",
                            cpfUzer,
                            reprovado,
                            nomeUzer
                        };
                        model.addRow(rowData);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao obter dados da API.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao obter dados da API.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSituacaoUsuario(String idUzer, boolean aprovado, String motivo) {
        try {
            // Defina a URL da sua API para atualizar a situação do uzer
            String apiUrl = "http://localhost:3333/api/funcionariosSearch/uzers/" + idUzer;

            // Crie os parâmetros do JSON para atualizar a situação, a aprovação e o motivo
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("aprovacao", aprovado);
            jsonParams.put("reprovacao", !aprovado); // Defina o campo de reprovação como o oposto da aprovação
            jsonParams.put("motivoBloqueio", motivo);

            // Abra uma conexão HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar a conexão para um método PUT
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Authorization", "Bearer Renatchingaymuitolegal898989");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Escrever os parâmetros JSON na requisição
            try ( OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonParams.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(null, "Situação do Uzer atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a situação do Uzer.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a situação do Uzer.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum uzer selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idUzer = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do uzer selecionado
        String motivo = "Motivo da aprovação"; // Substitua pelo motivo apropriado

        // Atualiza a situação do uzer para aprovado via API
        updateSituacaoUsuario(idUzer, true, motivo);

        atualizarListagemUzers(); // Atualize a listagem após a aprovação via API
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        atualizarListagemUzers();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum uzer selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idUzer = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do uzer selecionado
        String motivo = "Motivo da reprovação"; // Substitua pelo motivo apropriado

        // Atualiza a situação do uzer para reprovado via API
        updateSituacaoUsuario(idUzer, false, motivo);

        atualizarListagemUzers(); // Atualize a listagem após a reprovação via API
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum uzer selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String idUzer = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do uzer selecionado

            // Defina a URL da sua API para obter o PDF do uzer
            String apiUrl = "http://localhost:3333/api/uzers/" + idUzer + "/pdf";

            // Abra uma conexão HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar a conexão para um método GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer Renatchingaymuitolegal898989");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Ler o PDF como um fluxo de bytes
                InputStream pdfInputStream = connection.getInputStream();

                // Crie um arquivo temporário para salvar o PDF
                File tempFile = File.createTempFile("uzer_pdf", ".pdf");

                // Escreva o conteúdo do PDF no arquivo temporário
                try ( OutputStream os = new FileOutputStream(tempFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = pdfInputStream.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }

                // Feche o fluxo de entrada do PDF
                pdfInputStream.close();

                // Abra o PDF no visualizador padrão
                Desktop.getDesktop().open(tempFile);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao obter o PDF da API.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao obter o PDF da API.", "Erro", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(AprovarUzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AprovarUzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AprovarUzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AprovarUzer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AprovarUzer().setVisible(true);
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
