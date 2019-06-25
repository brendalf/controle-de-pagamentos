/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaopagamentos.persistence.txt;

import java.io.FileNotFoundException;

/**
 *
 * @author breno
 */
public interface TratadorTXT {
    boolean salvar();
    boolean carregar();
}
