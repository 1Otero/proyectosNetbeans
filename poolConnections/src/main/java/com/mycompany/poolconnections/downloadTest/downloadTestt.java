/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poolconnections.downloadTest;

import com.github.axet.vget.VGet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

/**
 *
 * @author truji
 */
public class downloadTestt extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form downloadTestt
     */
    public downloadTestt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlCancion = new javax.swing.JTextField();
        DownloadMus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        urlCancion.setText("Colocar url cancion");

        DownloadMus.setText("Download");
        DownloadMus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadMusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(urlCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(DownloadMus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DownloadMus))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DownloadMusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadMusActionPerformed
        String textTest = urlCancion.getText();
        String urlDownload = "https://www.youtube.com/watch?v=b2wQtu9YnWk";
        String urlLeave = "C:\\Users\\truji\\Downloads\\testDownload";
        if (textTest.length() > 0) {
            System.out.println("Dato es: " + textTest);
        } else {
            System.out.println(urlDownload);
            makeDownloadYoutube(urlDownload, urlLeave);
        }

    }//GEN-LAST:event_DownloadMusActionPerformed
    public void makeDownloadYoutube(String d, String l) {
        try{
          //VGet vget= new VGet(new URL(d), new File(l));    
          //vget.download();
          
          //YoutubeDLRequest
            System.out.println("Downloaded.... sucessfully ");
        }catch(Exception e){
            System.out.println("error VGet " + e);
        }
    }

    public void makeDownload(String d, String l) {
        try {
            HttpClient httpClient = this.createHttpClient();
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .uri(URI.create(d))
                    .build();
            HttpResponse<InputStream> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
            System.out.println(d);
            InputStream input = response.body();
            Path outputFile = Path.of(l);
            Files.copy(input, outputFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Downloas finally... ");
        } catch (Exception e) {
            System.out.println("Error download... ");
            System.out.println("error : " + e);
        }
    }

    public static HttpClient createHttpClient() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");

            sslContext.init(null, new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                }}, new SecureRandom());
            SSLParameters sslParameters = new SSLParameters();
            sslParameters.setEndpointIdentificationAlgorithm("");

            return HttpClient
                    .newBuilder()
                    .sslContext(sslContext)
                    .sslParameters(sslParameters)
                    .build();
        } catch (Exception e) {
            System.out.println("erros create http client " + e);
            return HttpClient.newHttpClient();
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
            java.util.logging.Logger.getLogger(downloadTestt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(downloadTestt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(downloadTestt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(downloadTestt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new downloadTestt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DownloadMus;
    private javax.swing.JTextField urlCancion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.DownloadMus == e.getSource()){
            System.out.println("Ejecuto action 2");
        }
    }
}
