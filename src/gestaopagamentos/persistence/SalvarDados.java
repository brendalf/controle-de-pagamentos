/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.persistence;

import gestaopagamentos.utils.CaixaDeProgresso;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author breno
 */
public class SalvarDados {
    
    public static void importar() {        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Selecione a pasta com os arquivos");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)  {
            File diretorio = fileChooser.getSelectedFile();
            if(!diretorio.isDirectory() || !diretorio.canRead()) {
                JOptionPane.showMessageDialog(fileChooser, "Nao selecionou uma pasta valida");
            }
            
            CaixaDeProgresso cp = new CaixaDeProgresso(null);
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    ArrayList<ISalvarDadosTratador> tratadores = new ArrayList<>();
                    tratadores.add(new SalvarDadosTratadorPagamentos(diretorio));
                    tratadores.add(new SalvarDadosTratadorFuncionarios(diretorio));

                    for(ISalvarDadosTratador tratador : tratadores) {
                        boolean retorno = tratador.carregar();
                        if(retorno) {
                            JOptionPane.showMessageDialog(null, tratador.getNome() + ": Dados importados com sucesso");
                        }
                    };
                    return null;
                }

                @Override
                protected void done() {
                    cp.dismiss();
                }
            };
            worker.execute();
            cp.show();            
        }
    }

    public static void exportar() {        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Selecione a pasta para salvar os arquivos");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)  {
            File diretorio = fileChooser.getSelectedFile();
            if(!diretorio.isDirectory() || !diretorio.canRead()) {
                JOptionPane.showMessageDialog(fileChooser, "Nao selecionou uma pasta valida");
            }
            
            CaixaDeProgresso cp = new CaixaDeProgresso(null);
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    ArrayList<ISalvarDadosTratador> tratadores = new ArrayList<>();
                    tratadores.add(new SalvarDadosTratadorPagamentos(diretorio));
                    tratadores.add(new SalvarDadosTratadorFuncionarios(diretorio));

                    for(ISalvarDadosTratador tratador : tratadores) {
                        boolean retorno = tratador.salvar();
                        if(retorno) {
                            JOptionPane.showMessageDialog(null, tratador.getNome() + ": Dados exportados com sucesso");
                        }
                    };
                    return null;
                }

                @Override
                protected void done() {
                    cp.dismiss();
                }
            };
            worker.execute();
            cp.show();
        }
    }
}