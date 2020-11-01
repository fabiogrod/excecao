package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class aula_143_Reserva
{	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public aula_143_Reserva() {}

	public aula_143_Reserva(Integer numeroQuarto, Date entrada, Date saida)
	{	
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}	

	public Date getSaida() {
		return saida;
	}

	public long duracao()
	{
		long dif = saida.getTime()-entrada.getTime();
		
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaDatas(Date entrada, Date saida)
	{
		Date dataAtual = new Date();
		
		if (entrada.before(dataAtual) || saida.before(dataAtual))
		{
			return "\nErro na reserva: Datas para atualizar a reserva devem ser posteriores a data atual!";	
		}
		
		if (!saida.after(entrada) )
		{
			return "\nErro na reserva: Data de saida deve ser posterior a data de entrada!";			
		}		
		
		this.entrada = entrada;
		this.saida = saida;
		
		return null;
	}

	@Override
	public String toString()
	{
		return "Numero do Quarto: " + numeroQuarto + " - Entrada: " + sdf.format(entrada) + " - Saida: " + sdf.format(saida)+" - Duração: " + duracao() + " noites";
	}
}
