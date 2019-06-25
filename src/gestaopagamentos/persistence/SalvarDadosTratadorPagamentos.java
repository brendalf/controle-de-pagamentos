/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.persistence;

import gestaopagamentos.business.Pagamento;
import gestaopagamentos.collection.PagamentosCollection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author breno
 */
public class SalvarDadosTratadorPagamentos implements SalvarDadosTratador {
    
    private File destination;

    public SalvarDadosTratadorPagamentos(File destination) {
        this.destination = new File(destination.getAbsolutePath() + "//pagamentos.gp");
    }

    @Override
    public boolean salvar() {
        try {
            if(this.destination.exists())
                this.destination.delete();
            
            if(PagamentosCollection.getInstance().getPagamentos().isEmpty())
                return false;
                
            this.destination.createNewFile();
            
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(this.destination));
            obj.writeObject(PagamentosCollection.getInstance().getPagamentos());
            obj.close();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar pagamentos");
            return false;
        }
    }

    @Override
    public boolean carregar() {        
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(this.destination));
            PagamentosCollection.getInstance().setPagamentos((ArrayList<Pagamento>) obj.readObject());
            obj.close();
            
            return true;
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo com pagamentos nao encontrado");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo pagamentos.gp");
            return false;
        }
    }    

    @Override
    public String getNome() {
        return "Pagamentos";
    }
}
