package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.ExceptionProprio;
import Entidades.Reserva;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero de quarto: ");
			int numero = sc.nextInt();
			
			System.out.println("Chekin data (dd/MM/yyyy) ");
			Date chekin = sdf.parse(sc.next());
			
			System.out.println("checkout data (dd/MM/yyyy) ");
			Date checkout = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numero, chekin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			
			System.out.println("Entre com as novas datas: ");
			
			System.out.println("Chekin data (dd/MM/yyyy) ");
			chekin = sdf.parse(sc.next());
			
			System.out.println("checkout data (dd/MM/yyyy) ");
			checkout = sdf.parse(sc.next());		
			
			reserva.updateDatas(chekin, chekin);
			
			System.out.println("Reserva : " + reserva);
		
		}catch (ParseException e) {
			System.out.println("Data invalida");
		}
		catch (ExceptionProprio e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}	

}
