/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import controller.ModeloCarroController;
import helper.Conexao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloCarro;

/**
 *
 * @author Joao-P
 */
public class TelaModeloCarroPesquisa extends javax.swing.JFrame {

    ModeloCarro modeloCarro;
    
    public void mostrarTabela() {

        EntityManager em = Conexao.getInstancia().getMysqlPU();

        List<ModeloCarro> listaModeloCarro = em.createQuery("select c from ModeloCarro c ", ModeloCarro.class).getResultList();

        DefaultTableModel model = (DefaultTableModel) TabelaModeloCarro.getModel();
        model.setNumRows(0);

        for (ModeloCarro modeloCarro : listaModeloCarro) {

            Object[] linhasLista = {
                modeloCarro.getCodigo(),
                modeloCarro.getDescricao()};
            model.addRow(linhasLista);
            TabelaModeloCarro.setModel(model);

        }

    }
    
    public TelaModeloCarroPesquisa() {
        initComponents();
        mostrarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaModeloCarro = new javax.swing.JTable();
        LabelRemover = new javax.swing.JLabel();
        LabelEditar = new javax.swing.JLabel();
        BotaoRemover = new javax.swing.JButton();
        CaixaCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaModeloCarro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Modelo", "Fabricante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaModeloCarro);

        LabelRemover.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        LabelRemover.setText("Digite o Codigo para Remover");

        LabelEditar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        LabelEditar.setText("Editar Modelo");

        BotaoRemover.setText("Remover");
        BotaoRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoRemoverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CaixaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoRemover)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelEditar)
                        .addGap(119, 119, 119))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRemover)
                    .addComponent(LabelEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoRemover)
                    .addComponent(CaixaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRemoverMouseClicked
        ModeloCarro modeloCarro = new ModeloCarro(Long.parseLong(CaixaCodigo.getText()));
        ModeloCarroController modeloCarroControler = new ModeloCarroController(modeloCarro);
        System.out.println(modeloCarro.getCodigo());
        if(modeloCarroControler.removerModeloCarro()){JOptionPane.showMessageDialog(null, "Modelo do Carro Removido com Sucesso!");}
        else{JOptionPane.showMessageDialog(null, "Codigo Nào Digitado!");}
    }//GEN-LAST:event_BotaoRemoverMouseClicked

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
            java.util.logging.Logger.getLogger(TelaModeloCarroPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModeloCarroPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModeloCarroPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModeloCarroPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModeloCarroPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoRemover;
    private javax.swing.JTextField CaixaCodigo;
    private javax.swing.JLabel LabelEditar;
    private javax.swing.JLabel LabelRemover;
    private javax.swing.JTable TabelaModeloCarro;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}