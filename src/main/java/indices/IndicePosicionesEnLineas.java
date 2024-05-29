package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto{
    private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;

    public IndicePosicionesEnLineas(){
        super();
        this.indice=new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for(int lineNum = 0; lineNum<frases.size(); lineNum++){
            String aux = frases.get(lineNum);
            String[] arrayAux = aux.split(delimitadores);
            for(int pos = 0; pos< arrayAux.length; pos++){
                String word = arrayAux[pos].trim().toLowerCase();
                if(!word.isEmpty()){
                    SortedMap<Integer, SortedSet<Integer>> linesMap = indice.getOrDefault(word, new TreeMap<>());
                    SortedSet<Integer> positionsSet = linesMap.getOrDefault(lineNum +1, new TreeSet<>());
                    positionsSet.add(pos+1);
                    linesMap.put(lineNum+1, positionsSet);
                    indice.put(word, linesMap);
                }
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> entry : indice.entrySet()) {
            String word = entry.getKey();
            pw.println(word);
            SortedMap<Integer, SortedSet<Integer>> linesMap = entry.getValue();
            for (Map.Entry<Integer, SortedSet<Integer>> lineEntry : linesMap.entrySet()) {
                int lineNum = lineEntry.getKey();
                SortedSet<Integer> positionsSet = lineEntry.getValue();
                pw.print(" "+ lineNum + " <");
                Iterator<Integer> it = positionsSet.iterator();
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
}
