package indices;

import java.util.ArrayList;
import java.util.List;

public abstract class IndiceAbstracto implements Indice {
    protected List<String> frases;
    public IndiceAbstracto(){
        this.frases=new ArrayList<>();
    }

    @Override
    public void agregarFrase(String frase) {
        if(frase.isEmpty()){
            throw new IllegalArgumentException("El string a añadir al texto no puede estar vacio");
        }else{
            frases.add(frase);
        }
    }
}
