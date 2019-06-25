/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.persistence.txt;

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
public class TratadorPagamentosTXT implements TratadorTXT {
    
    private File destination;

    public TratadorPagamentosTXT(File destination) {
        this.destination = new File(destination.getAbsolutePath() + "//pagamentos.txt");
    }

    @Override
    public boolean salvar() {
        try {
            if(this.destination.exists())
                this.destination.delete();
            this.destination.createNewFile();
            
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(this.destination));
            obj.writeObject(PagamentosCollection.getInstance().getPagamentos());
            obj.close();
            
            return true;
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo pagamentos.txt nao encontrado");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo pagamentos.txt");
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
            JOptionPane.showMessageDialog(null, "Arquivo pagamentos.txt nao encontrado");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo pagamentos.txt");
            return false;
        }
    }    
}
