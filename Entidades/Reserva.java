package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date chekin;
	private Date chekout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		super();
	}
	
	public Reserva(Integer numeroQuarto, Date chekin, Date chekout) throws ExceptionProprio {
		
		if(!chekout.after(chekin)){
			throw new ExceptionProprio("Erro na reserva");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.chekin = chekin;
		this.chekout = chekout;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getChekin() {
		return chekin;
	}
	
	public Date getChekout() {
		return chekout;
	}
	
	public long durasao() {
		long diff = chekout.getTime() - chekin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateDatas(Date chekin, Date chekout) throws ExceptionProprio {
		
		Date now = new Date();
		if(chekin.before(now) || chekout.before(now)) {
			throw new ExceptionProprio("Data anterior a atual, pf adicione uma data futura");
		}
		if(!chekout.after(chekin)){
			throw new ExceptionProprio("Erro na reserva");
		}
		
		this.chekin = chekin;
		this.chekout = chekout;
	
	}
	
	@Override
	public String toString() {
		return "Quarto: " + numeroQuarto
				+ ", Chekin: " + sdf.format(chekin)
				+ ", Chekout: " + sdf.format(chekout)
				+ ", Durasao: " + durasao() + " noites";
	}
	
}
