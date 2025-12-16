package aula04.entidade;

public class Teste2 {

    private int a = 10;
    protected int b = 20;
    int c = 30;
    public int d = 40;
    protected static  int e = 50;

    public static int somar() {
        Teste2 t2v = new Teste2();
        return t2v.a + t2v.b + t2v.c + t2v.d + e;
    }
}
