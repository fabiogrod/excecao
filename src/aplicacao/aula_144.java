package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.aula_144_Reserva;
import modelo.excecoes.aula_144_ExcecaoDominio;

public class aula_144
{
	public static void main(String[] args)
	{		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		try 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Numero do Quarto: ");
			int numeroQuarto = sc.nextInt();
			
			System.out.print("\nData da entrada (dd/mm/aaaa): ");
			Date entrada = sdf.parse(sc.next() );
			
			System.out.print("Data da saida (dd/mm/aaaa): ");
			Date saida = sdf.parse(sc.next() );
			
			aula_144_Reserva reserva = new aula_144_Reserva(numeroQuarto, entrada, saida);
			System.out.println("\nReserva #1 - " + reserva);
			
			System.out.println("\nDigite os dados para atualizar a reserva");		
			
			System.out.print("\nData da entrada (dd/mm/aaaa): ");
			entrada = sdf.parse(sc.next() );
			
			System.out.print("Data da saida (dd/mm/aaaa): ");
			saida = sdf.parse(sc.next() );		
		
			reserva.atualizaDatas(entrada, saida);
			System.out.println("\nReserva #1 - " + reserva);			
		}
		catch (ParseException e)
		{
			System.out.println("Data inválida");
		}
		catch (aula_144_ExcecaoDominio e)
		{
			System.out.println("Data inválida" + e.getMessage() );
		}
		catch (RuntimeException e)
		{
			System.out.println("Erro inesperado" );
		}
		
		sc.close();
	}
}









