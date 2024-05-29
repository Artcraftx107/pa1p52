package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto{
    private SortedMap<String, Integer> indice;
    public IndiceContador(){
        super();
        this.indice= new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for(String str : frases){
            String[] aux = str.split(delimitadores);
            for(String word : aux){
                word=word.trim().toLowerCase();
                indice.put(word, indice.getOrDefault(word, 0)+1);
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(Map.Entry<String, Integer> entry : indice.entrySet()){
            pw.println(entry.getKey()+" "+entry.getValue());
        }
    }

    @Override
    public void presentarIndiceConsola() {
        //Ignorar
    }
}
