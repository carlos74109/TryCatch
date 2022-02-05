package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Numero de quarto: ");
		int numero = sc.nextInt();
		
		System.out.println("Chekin data (dd/MM/yyyy) ");
		Date chekin = sdf.parse(sc.next());
		
		System.out.println("checkout data (dd/MM/yyyy) ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(chekin)) {
			System.out.println("Erro, chekout tem que ser depois da data de chekin");
		}
		else {
			Reserva reserva = new Reserva(numero, chekin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			
			System.out.println("Entre com as novas datas: ");
			
			System.out.println("Chekin data (dd/MM/yyyy) ");
			chekin = sdf.parse(sc.next());
			
			System.out.println("checkout data (dd/MM/yyyy) ");
			checkout = sdf.parse(sc.next());
			
			
			Date now = new Date();
			if(chekin.before(now) || checkout.before(now)) {
				System.out.println("Data anterior a atual");
			}
			else if(!checkout.after(chekin)){
				System.out.println("Erro na reserva");
			}
			else {
				reserva.updateDatas(chekin, chekin);
				System.out.println(reserva);
				
			}
			
		}
		
		sc.close();
	}	

}
