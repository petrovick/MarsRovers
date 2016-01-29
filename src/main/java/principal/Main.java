package principal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.ReceberComandosController;
import business.Direcao;

public class Main
{
	public static void main(String... args)
	{
		
		Scanner reader = new Scanner(System.in);
		
		String tamanhoGrid = reader.nextLine();//"5 5";
		String robo1Linha2 = reader.nextLine();//"1 2 N";
		String robo1Linha3 = reader.nextLine();//"LMLMLMLMM";
		
		String robo2Linha2 = reader.nextLine();//"3 3 E";
		String robo2Linha3 = reader.nextLine();//"MMRMMRMRRM";
		
		reader.close();

		ReceberComandosController c = new ReceberComandosController();
		String resultadoRobo1 = c.updateRobotLocation(tamanhoGrid, robo1Linha2, robo1Linha3);

		String resultadoRobo2 = c.updateRobotLocation(tamanhoGrid, robo2Linha2, robo2Linha3);
		
		System.out.println(resultadoRobo1);
		System.out.println(resultadoRobo2);
		
	}
}
