
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class ImageSplitTest extends javax.swing.JFrame {

    /**
     * Creates new form ImageSplitTest
     */
    public ImageSplitTest() {
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

        jButton1 = new javax.swing.JButton();
        path = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("show split of images");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258)
                .addComponent(path)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(path)
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */

  
this.setVisible(false);
  try
  {
      
        File file = new File(path.getText()); // I have bear.jpg in my working directory  
        FileInputStream fis;  
      
          
        fis = new FileInputStream(file);
        
        BufferedImage image = ImageIO.read(fis); //reading the image file 
       
  
        int rows = 1; //You should decide the values for rows and cols variables  
        int cols = 2;  
        int chunks = rows * cols;  
  
        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height  
        int chunkHeight = image.getHeight() / rows;  
        int count = 0;  
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
        for (int x = 0; x < rows; x++) {  
            for (int y = 0; y < cols; y++) {  
                //Initialize the image array with image chunks  
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  
  
                // draws the image chunk  
                Graphics2D gr = imgs[count++].createGraphics();  
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
                gr.dispose();  
            }  
        }  
        System.out.println("Splitting done");  
  
        //writing mini images into image files  
        for (int i = 0; i < imgs.length; i++) {  
            ImageIO.write(imgs[i], "jpg", new File("img" + i + ".jpg"));  
        }  
        System.out.println("Mini images created");  
    split_image sl=new split_image();
    sl.setVisible(true);
           ImageIcon ic1=new ImageIcon(imgs[0]);
           ImageIcon ic2=new ImageIcon(imgs[1]);

   sl.lab1.setIcon(ic1);
      sl.lab2.setIcon(ic2);

   
    }
    
    catch(Exception e)
    {
        System.out.println("File Not Found");
    }   

    


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     * 
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
            java.util.logging.Logger.getLogger(ImageSplitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageSplitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageSplitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageSplitTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageSplitTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel path;
    // End of variables declaration//GEN-END:variables
}
