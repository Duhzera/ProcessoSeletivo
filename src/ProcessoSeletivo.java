import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Random;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        case3();
		for(String candidato: selecionados()){
			case4(candidato);
		}
    }

    static String[] candidatosTotal() {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};
        return candidatos;
    }

    static void case2() {
        String[] candSelecionados = selecionados();
        double salarioBase = 2000.0;
        int totalSelecionados = 0;
        int proximoCandidato = 0;

        while (totalSelecionados < 5 && proximoCandidato < candSelecionados.length) {
            String candidato = candSelecionados[proximoCandidato++];
            double valorPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);

            if (valorPretendido > salarioBase) {
                System.out.println("QUE PENA!! O candidato " + candidato + " NÃO foi selecionado ");
            } else {
                System.out.println("LEGAL!! O candidato " + candidato + " foi selecionado ");
                totalSelecionados++;
            }
        }

        System.out.println("Total de selecionados: " + totalSelecionados);
        System.out.println("Total de consultados: " + proximoCandidato);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static String[] selecionados() {
        String[] candidatos = candidatosTotal();
        ArrayList<String> candSelecionados = new ArrayList<>();
        double salarioBase = 2000.0;
        int totalSelecionados = 0;
        int proximoCandidato = 0;

        while (totalSelecionados < 5 && proximoCandidato < candidatos.length) {
            String candidato = candidatos[proximoCandidato++];
            double valorPretendido = valorPretendido();
            if (valorPretendido > salarioBase) {
            } else {
                candSelecionados.add(candidato);
                totalSelecionados++;
            }
        }

        return candSelecionados.toArray(new String[0]);
    }

	static void case3(){
		String[] candidatos = selecionados();
		for(int x=0; x<candidatos.length; x++) {
			System.out.println((x+1)+ "° Candidato é " + candidatos[x] );
		}
		
		for(String candidato: candidatos) {
			System.out.println(candidato);
		}
	}
	static void case4(String candidato) {
		
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
		
		
	}
	
	//método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}
}
