package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelDeTrabalho;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Dados do Trabalhador = ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nome, NivelDeTrabalho.valueOf(level), salarioBase, new Departamento(departamentoNome));
		
		System.out.print("Quantos contratos esse trabalhador vai ter? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do contrato #" + i);
			System.out.print("Data (DD/MM/AAAA): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora =  sc.nextDouble();
			System.out.print("Quantas horas? ");
			int hora = sc.nextInt();
			ContratoHora contratos = new ContratoHora(data, valorPorHora, hora);
			trabalhador.addContrato(contratos);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e ano para o calculo do salário (MM/AAAA): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3,7));
		
		System.out.println("Trabalhador: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda do mês " + mesEAno + " : " + String.format("%.2f", trabalhador.renda(mes, ano)));
		
				
		
		
		sc.close();
	}

}
