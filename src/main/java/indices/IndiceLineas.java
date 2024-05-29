package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto{
    private SortedMap<String, SortedSet<Integer>> indice;
    public IndiceLineas(){
        super();
        this.indice=new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for(int lineNum = 0; lineNum<frases.size(); lineNum++){
            String aux = frases.get(lineNum);
            String[] arrayAux = aux.split(delimitadores);
            for(String word : arrayAux){
                word = word.trim().toLowerCase();
                if(!word.isEmpty()){
                    SortedSet<Integer> lines = indice.getOrDefault(word, new TreeSet<>());
                    lines.add(lineNum+1);
                    indice.put(word, lines);
                }
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, SortedSet<Integer>> entry : indice.entrySet()) {
            pw.print(entry.getKey() + " <");
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                pw.print(it.next());
                if (it.hasNext()) {
                    pw.print(",");
                }
            }
            pw.println(">");
        }
    }
}
