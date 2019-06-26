package gestaopagamentos.persistence;

import gestaopagamentos.business.Funcionario;
import gestaopagamentos.collection.FuncionariosCollection;
import gestaopagamentos.utils.CaixaDeProgresso;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author breno
 */
public class ImportarFuncionariosCSV {
    
    private static final File csv = new File("src\\gestaopagamentos\\data\\funcionarios.csv");

    public static void importar() {
        CaixaDeProgresso cp = new CaixaDeProgresso(null);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                BufferedReader br;
                String linha;
                String divisor = ",";

                try {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
                    br.readLine();

                    ArrayList<Funcionario> funcionarios = new ArrayList<>();

                    while ((linha = br.readLine()) != null) {
                        try {
                            String[] l = linha.split(divisor);
                            l[0]=l[0].substring(1, l[0].length()-1);
                            l[1]=l[1].substring(1, l[1].length()-1);

                            funcionarios.add(new Funcionario(l[0], l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3])));
                        } catch (Exception e) {

                        }
                    }

                    br.close();
                    FuncionariosCollection.getInstance().setFuncionarios(funcionarios);
                    JOptionPane.showMessageDialog(null, "Funcionarios importados com sucesso");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao importar funcionarios");
                }
                
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
