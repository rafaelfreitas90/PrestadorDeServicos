/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgressBar.java
 *
 * Created on 02/11/2009, 20:04:39
 */

package br.com.prestadoradeservicos.views;

import br.com.prestadoradeservicos.controlers.TelaPrincipalControler;
import br.com.prestadoradeservicos.controlers.RelatorioServicosExecutadosControler;
import java.util.Date;

/**
 *
 * @author Anderson Luis Ribeiro
 */
public class ProgressBar extends javax.swing.JFrame {

    private TelaPrincipalControler telaPrincipalController;
    private RelatorioServicosExecutadosControler relatorioServicosExecutadosController;
    /** Creates new form ProgressBar */
    public ProgressBar(TelaPrincipalControler controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.telaPrincipalController = controller;
    }

    public ProgressBar(RelatorioServicosExecutadosControler controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.relatorioServicosExecutadosController = controller;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraDeProgresso = new javax.swing.JProgressBar();
        lbMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Status do Processo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barraDeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barraDeProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProgressBar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeProgresso;
    private javax.swing.JLabel lbMensagem;
    // End of variables declaration//GEN-END:variables

    public void carregarInterfaceGraficaTelaPrincipal(){
        lbMensagem.setText("Carregando...");
        barraDeProgresso.setIndeterminate(true);
        Thread thread = new Thread(new Runnable() {
            public void run() {
               telaPrincipalController.iniciarSessionFactory();
               telaPrincipalController.exibirInterfaceGrafica();
               lbMensagem.setText("Carregado !");
               barraDeProgresso.setIndeterminate(false);               
               dispose();
            }
        });
        thread.start();

    }

    public void carregarRelatorioServicosExecutados(final Date dataInicial, final Date dataFinal){
        lbMensagem.setText("Carregando...");
        barraDeProgresso.setIndeterminate(true);
        Thread thread = new Thread(new Runnable() {
            public void run() {
               relatorioServicosExecutadosController.gerarRelatorio(dataInicial, dataFinal);
               lbMensagem.setText("Carregado !");
               barraDeProgresso.setIndeterminate(false);
               dispose();
            }
        });
        thread.start();

    }
}