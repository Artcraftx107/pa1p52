package indices;

import java.io.PrintWriter;

public interface Indice {
    public void agregarFrase(String frase);
    public void resolver(String delimitadores);
    public void presentarIndice(PrintWriter pw);
    default void presentarIndiceConsola(){
        PrintWriter pw = new PrintWriter(System.out, true);
        presentarIndice(pw);
    }
}
