/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.utils;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author breno
 */
public class CaixaDeProgresso {

    private JDialog dialog;
    private JProgressBar progressBar;
    
    public CaixaDeProgresso(JFrame view) {
        this.dialog = new JDialog(view, true);
        
        this.progressBar = new JProgressBar();
        this.progressBar.setStringPainted(true);
        this.progressBar.setString("Aguarde...");
        this.dialog.add(BorderLayout.CENTER, this.progressBar);
        this.dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.dialog.setTitle("Processando");
        this.dialog.setSize(300, 75);
        
        if(view != null) {
            this.dialog.setLocationRelativeTo(view);
        } else {
            this.dialog.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.dialog.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.dialog.getHeight()/ 2)
            );
        }
    }
    
    public CaixaDeProgresso(JFrame view, int size) {
        this.dialog = new JDialog(view, true);
        
        this.progressBar = new JProgressBar(0, size);
        this.dialog.add(BorderLayout.CENTER, this.progressBar);
        this.dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.dialog.setTitle("Processando");
        this.dialog.setSize(300, 75);
        
        if(view != null) {
            this.dialog.setLocationRelativeTo(view);
        } else {
            this.dialog.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.dialog.getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.dialog.getHeight()/ 2)
            );
        }
    }
    
    public void updateProgress() {
        this.progressBar.setValue(this.progressBar.getValue() + 1);
    }
    
    public void show() {
        this.dialog.setVisible(true);
    }
    
    public void dismiss() {
        this.dialog.setVisible(false);
    }
}
