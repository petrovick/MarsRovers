package controller;

import exception.RoboException;
import business.Direcao;
import applicationFactory.ApplicationFactory;
import applicationImplementation.DirecaoApplication;
import applicationImplementation.RoboApplication;
import applicationInterfaces.IDirecaoApplication;
import applicationInterfaces.IRoboApplication;

public class ReceberComandosController
{
	private IRoboApplication roboApplication;
	private IDirecaoApplication direcaoApplication;
	
	public ReceberComandosController()
	{
		roboApplication = ApplicationFactory.GetInstance().getRoboApplication();
		direcaoApplication = ApplicationFactory.GetInstance().getDirecaoApplication();
	}
	/**
	 * 
	 * @param grid - Este parametro possui as dimensões das coordenadas 
	 * @param currentPosition - Este parametro possui o estado atual do objeto, quando ele entra no sistema
	 * @param steps - Este parametro explica os passos a serem seguidos pelo robô
	 * @return - Retorno o estado final do robo, ou seja, sua posição final.
	 */
	public String updateRobotLocation(String gridSizes, String currentPosition, String steps)
	{
		String finalLocation = "";
		try
		{
			
			int[][] grid = roboApplication.gerarEspacoDoRobo(gridSizes);
			
			String[] stringPositions = currentPosition.split(" ");
			
			Direcao direcaoInicial = direcaoApplication.converterEmDirecao(stringPositions[2]);
			
			roboApplication.colocarRoboNaPosicaoInicial(Integer.parseInt(stringPositions[0]), Integer.parseInt(stringPositions[1]), direcaoInicial);
			Direcao[] direcoes = direcaoApplication.converterEmDirecao(steps.split(""));
			finalLocation = roboApplication.movimentarRobo(direcoes);
		}
		catch(RoboException ex)
		{
			finalLocation = ex.getMessage();
		}
		return finalLocation;
		
	}

}
