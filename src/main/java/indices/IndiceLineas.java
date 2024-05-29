package indices;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class IndiceLineas extends IndiceAbstracto{
    private SortedMap<String, SortedSet<Indice>> indice;
    public IndiceLineas(){
        super();
        this.indice=new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        
    }
}
