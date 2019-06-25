/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.persistence;

import gestaopagamentos.persistence.txt.TratadorFuncionariosTXT;
import gestaopagamentos.persistence.txt.TratadorPagamentosTXT;
import gestaopagamentos.persistence.txt.TratadorTXT;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class DAO {
    
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
            
            ArrayList<TratadorTXT> tratadores = new ArrayList<>();
            tratadores.add(new TratadorPagamentosTXT(diretorio));
            tratadores.add(new TratadorFuncionariosTXT(diretorio));
            
            tratadores.forEach((tratador) -> {
                tratador.carregar();
            });
            
            JOptionPane.showMessageDialog(null, "Dados importados com sucesso");
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
            
            ArrayList<TratadorTXT> tratadores = new ArrayList<>();
            tratadores.add(new TratadorPagamentosTXT(diretorio));
            tratadores.add(new TratadorFuncionariosTXT(diretorio));
            
            tratadores.forEach((tratador) -> {
                tratador.salvar();
            });
            
            JOptionPane.showMessageDialog(null, "Dados exportados com sucesso");
        }
    }
}