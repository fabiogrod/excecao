package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.aula_143_Reserva;

public class aula_143
{
	public static void main(String[] args) throws ParseException
	{		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numeroQuarto = sc.nextInt();
		
		System.out.print("\nData da entrada (dd/mm/aaaa): ");
		Date entrada = sdf.parse(sc.next());
		
		System.out.print("Data da saida (dd/mm/aaaa): ");
		Date saida = sdf.parse(sc.next());
		
		if (!saida.after(entrada) )
		{
			System.out.println("\nErro na reserva: Data de saida deve ser posterior a data de entrada!");			
		}
		else
		{
			aula_143_Reserva reserva = new aula_143_Reserva(numeroQuarto, entrada, saida);
			System.out.println("\nReserva #1 - " + reserva);
			
			System.out.println("\nDigite os dados para atualizar a reserva");		
			
			System.out.print("\nData da entrada (dd/mm/aaaa): ");
			entrada = sdf.parse(sc.next());
			
			System.out.print("Data da saida (dd/mm/aaaa): ");
			saida = sdf.parse(sc.next());		
		
			String erro = reserva.atualizaDatas(entrada, saida);
			
			if (erro != null)
			{
				System.out.println(erro);
			}
			else
			{
				System.out.println("\nReserva #1 - " + reserva);
			}			
		}		
		sc.close();
	}
}









