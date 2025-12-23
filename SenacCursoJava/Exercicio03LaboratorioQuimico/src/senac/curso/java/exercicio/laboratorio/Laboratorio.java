package senac.curso.java.exercicio.laboratorio;

public class Laboratorio {
    private boolean portaFechada = true;
    private String temperatura = "normal";
    private String gasesToxicos = "ausentes";
    private boolean alarmeAtivo = false;

    public Laboratorio() {
    }

    public Laboratorio(boolean portaFechada, String temperatura, String gasesToxicos, boolean alarmeAtivo) {
        this.portaFechada = portaFechada;
        this.temperatura = temperatura;
        this.gasesToxicos = gasesToxicos;
        this.alarmeAtivo = alarmeAtivo;
    }

    public void portaAbrirFechar() {
        if (this.temperatura.equals("alta") || this.gasesToxicos.equals("presentes")) {
            System.out.println("Porta não pode ser aberta: ambiente inseguro!");
        } else if (!this.portaFechada) {
            this.portaFechada = true;
            System.out.println("Porta fechada!" );
        } else  {
            this.portaFechada = false;
            System.out.println("Porta aberta!" );
        }
    }

    public void alterarTemperatura() {
        if (!this.portaFechada) {
            System.out.println("Não é permitido elevar a temperatura com a porta aberta.");
        } else if (this.portaFechada && this.temperatura.equals("normal")) {
            this.temperatura = "alta";
            System.out.println("Temperatura alterada! (Alta)");
        } else   {
            this.temperatura = "normal";
            System.out.println("Temperatura alterada! (Normal)");
        }
    }

    public void alterarGasesToxicos() {
        if (!this.portaFechada) {
            System.out.println("Impossível liberar gases tóxicos com a porta aberta.");
        } else if (this.portaFechada && this.gasesToxicos.equals("ausentes")) {
            this.gasesToxicos = "presentes";
            System.out.println("Gases tóxicos liberados!");
        } else {
            this.gasesToxicos = "ausentes";
            System.out.println("Gases tóxicos ausentes!" );
        }
    }

    public void alarmeAtivarDesaivar() {
        if (this.temperatura.equals("alta") && this.gasesToxicos.equals("presentes")) {
            this.alarmeAtivo = true;
            System.out.println("ALARME - Risco Crítico detectado!");
        } else if (!this.alarmeAtivo) {
            this.alarmeAtivo = true;
            System.out.println("Alarme ativado! (Manualmente)");
        } else   {
            this.alarmeAtivo = false;
            System.out.println("Alarme desativado! (Manualmente)");
        }
    }

    public void relaorio() {
        System.out.println("----- RELATORIO -----");
        System.out.println("Porta: " + (this.portaFechada ? "Fechada" : "Aberta"));
        System.out.println("Temperatura: " + (this.temperatura));
        System.out.println("Gases toxicos: " + (this.gasesToxicos));
        System.out.println("Alarme: " + (this.alarmeAtivo ? "ATIVADO" : "DESATIVADO"));
        if (this.temperatura.equals("alta") && this.gasesToxicos.equals("presentes")) {
            System.out.println("Status geral: CRÍTICO");
        } else if (!this.portaFechada && this.temperatura.equals("alta")) {
            System.out.println("Status geral: INSEGURO");
        } else if (!this.portaFechada && this.gasesToxicos.equals("presentes")) {
            System.out.println("Status geral: INSEGURO");
        } else if (this.temperatura.equals("alta") || this.gasesToxicos.equals("presentes")) {
            System.out.println("Status geral: INSEGURO");
        } else {
            System.out.println("Status geral: SEGURO");
        }
    }

    public void resetar() {
        this.portaFechada = false;
        this.temperatura = "normal";
        this.gasesToxicos = "ausentes";
        this.alarmeAtivo = false;
        System.out.println("Resetando sistema... Resetado!");
    }





}
