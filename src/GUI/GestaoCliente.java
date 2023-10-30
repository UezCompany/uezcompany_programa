/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author bruna
 */
public class GestaoCliente extends javax.swing.JFrame {

    /**
     * Creates new form GestaoCliente
     */
    public GestaoCliente() {
        try {
            // Define o look and feel Nimbus
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        String imagePath = "../Imagem/fundoprograma2.png";
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL == null) {
            System.out.println("Arquivo de imagem não encontrado: " + imagePath);
        } else {
            ImageIcon icon = new ImageIcon(imageURL);
            Image image = icon.getImage();
        }

        initComponents();
        atualizarListagemClientes();

    }

    private void atualizarListagemClientes() {
        try {
            // Defina a URL da sua API para obter os clientes
            String apiUrl = "https://api.uezcompany.com/funcionariosSearch/clientes";
            System.out.println(System.getenv("OS"));

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
                    
                    boolean aprovado = jsonObject.getBoolean("aprovacao");

                    // Trata a situação do cliente que é retornada como string "null"
                    if (aprovado) {
                        Object[] rowData = {
                            jsonObject.getString("_id"),
                            jsonObject.getString("nome"),
                            jsonObject.optString("situacao"),
                            jsonObject.getBoolean("aprovacao"),
                            jsonObject.getString("dataCadastro"),
                            jsonObject.getDouble("avaliacao"),
                            jsonObject.getInt("quantidadePedidos")
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBanirDesbanir = new javax.swing.JButton();
        btnAtualizarlistagem1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de gestão de clientes");
        setMinimumSize(new java.awt.Dimension(960, 540));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listagem de Clientes");

        btnBanirDesbanir.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnBanirDesbanir.setText("Bloquear/Desbloquear");
        btnBanirDesbanir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanirDesbanirActionPerformed(evt);
            }
        });

        btnAtualizarlistagem1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnAtualizarlistagem1.setText("Atualizar listagem");
        btnAtualizarlistagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarlistagem1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Cliente", "Nome Cliente", "Situação", "Aprovação", "Data de Cadastro", "Avaliação", "Quantidade de Pedidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setLayout(new java.awt.CardLayout());

        ImageIcon icon = new ImageIcon(getClass().getResource("/GUI/Imagem/fundoprograma2.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }};

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBanirDesbanir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtualizarlistagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(38, 38, 38)
                            .addComponent(btnBanirDesbanir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(btnAtualizarlistagem1)
                            .addGap(348, 348, 348))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)))
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnBanirDesbanirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanirDesbanirActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum Cliente selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String situacao = jTable1.getValueAt(selectedRow, 2).toString(); // Obtém a situação do usuário selecionado

        // Atualiza o estado do usuário selecionado
        if (situacao.equals("Ativo") || situacao.equals("Pendente...")) {
            String idCliente = jTable1.getValueAt(selectedRow, 0).toString(); // Obtém o id do usuário selecionado
            BanirCliente banirClienteFrame = new BanirCliente(idCliente); // Cria a tela BanirCliente com o ID como parâmetro
            banirClienteFrame.setVisible(true); // Exibe a tela BanirCliente
        } else if (situacao.equals("Bloqueado")) {
            updateSituacaoUsuario(selectedRow, "Ativo");
            JOptionPane.showMessageDialog(null, "O Cliente foi Ativado na plataforma.");
        }
    }

    private void updateSituacaoUsuario(int rowIndex, String novaSituacao) {
        String idCliente = jTable1.getValueAt(rowIndex, 0).toString(); // Obtém o id do cliente selecionado

        try {
            // Defina a URL da sua API para atualizar a situação do cliente
            String apiUrl = "https://api.uezcompany.com/clientes/" + idCliente;

            // Crie os parâmetros do JSON para atualizar a situação
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("situacaoCliente", novaSituacao);

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
                // Atualiza a tabela com a nova situação do cliente
                jTable1.setValueAt(novaSituacao, rowIndex, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar a situação do Cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a situação do Cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBanirDesbanirActionPerformed

    private void btnAtualizarlistagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarlistagem1ActionPerformed
        atualizarListagemClientes();
    }//GEN-LAST:event_btnAtualizarlistagem1ActionPerformed

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
            java.util.logging.Logger.getLogger(GestaoCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestaoCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestaoCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestaoCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestaoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarlistagem1;
    private javax.swing.JButton btnBanirDesbanir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
