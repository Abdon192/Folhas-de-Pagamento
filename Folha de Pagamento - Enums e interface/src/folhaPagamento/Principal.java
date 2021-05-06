package folhaPagamento;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		FolhaEnum tipoFolha;

		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1-Folha Salario");
			System.out.println("2-Folha Férias");
			System.out.println("3-Folha Décimo Terceiro");
			System.out.println("4-Folha Verde Amarelo");
			System.out.println("5-Folha trabalhador intermitente.");
			System.out.println("6-Sair");

			try {
				
				opcao = Integer.valueOf(ler.nextLine());

				//tipoFolha = FolhaEnum.valuesOf("SALARIO");
				tipoFolha = FolhaEnum.values()[opcao - 1];

				switch (tipoFolha) {
				case SALARIO:
					calcular(new FolhaSalario());
					break;

				case FERIAS:
					calcular(new FolhaFerias());
					break;

				case DT:
					calcular(new FolhaDecimoTerceiro());
					break;

				case VERDEAMARELO:
					calcular(new FolhaVerdeAmarelo());
					break;

				case INTERMITENTE:
					calcular(new FolhaIntermitente());
					break;

				}

			} catch (ArrayIndexOutOfBoundsException e) {

				if (opcao != 6) {

					System.out.println("Opção inválida !");
				} else {
					System.out.println("Processo encerrado !");
				}
			} catch (NumberFormatException e) {

				System.out.println("Informe apenas números !");

			} catch (Exception e) {

				System.out.println("Exception !");
			}

			System.out.println("\n");
		} while (opcao != 6);
		ler.close();
	}

	private static void calcular(Folha folha) {
		folha.calcular();
	};
}
