package ifto.poo.aula04.modificadoresdeacesso.programa;

import ifto.poo.aula04.modificadoresdeacesso.entidade.Teste;
import ifto.poo.aula04.modificadoresdeacesso.entidade.Teste2;

public class Iniciar {
    public static void main(String[] args) {

        Teste objT = new Teste();

        //System.out.println(objT.a + objT.b + objT.c + objT.d + objT.e);

        System.out.println("Soma Objeto Teste: " + objT.somar());
        System.out.println("Soma Objeto Teste2: " + Teste2.somar());
        System.out.println("Soma Obj1 + Obj2: " + (objT.somar() + Teste2.somar()));
    }
}
