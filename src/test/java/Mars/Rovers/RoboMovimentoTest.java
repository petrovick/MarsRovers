package Mars.Rovers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import business.Direcao;
import business.Robo;
import applicationFactory.ApplicationFactory;
import applicationInterfaces.IDirecaoApplication;
import applicationInterfaces.IRoboApplication;
import controller.ReceberComandosController;
import exception.RoboException;

public class RoboMovimentoTest
{
	

	@Test
	public void testeExamploUm()
	{
		String linha1 = "5 5";
		String linha2 = "1 2 N";
		String linha3 = "LMLMLMLMM";
		

		ReceberComandosController c = new ReceberComandosController();
		String resultado = c.updateRobotLocation(linha1, linha2, linha3);
		
		assertEquals("1 3 N", resultado);
	}
	
	@Test
	public void testeExamploDois()
	{
		String linha1 = "5 5";
		String linha2 = "3 3 E";
		String linha3 = "MMRMMRMRRM";
		

		ReceberComandosController c = new ReceberComandosController();
		String resultado = c.updateRobotLocation(linha1, linha2, linha3);
		assertEquals("5 1 E", resultado);
	}
	
	@Test
	public void testarGeracaoEspaco()
	{
		IRoboApplication roboApplication = ApplicationFactory.GetInstance().getRoboApplication();
		int grid[][] = roboApplication.gerarEspacoDoRobo("2 2");
		assertEquals(grid.length, 3);
		assertEquals(grid[0].length, 3);
	}
	
	@Test
	public void testarPosicaoCorretaRobo()
	{
		IRoboApplication roboApplication = ApplicationFactory.GetInstance().getRoboApplication();
		Robo robo = roboApplication.colocarRoboNaPosicaoInicial(1, 1, Direcao.Norte);

		assertEquals(robo.getPosicaoAtualX(), 1);
		assertEquals(robo.getPosicaoAtualY(), 1);
		assertEquals(robo.getDirecao(), Direcao.Norte);
	}
	
	@Test
	public void testarUmMovimentoDoRobo()
	{
		try
		{
			IRoboApplication roboApplication = ApplicationFactory.GetInstance().getRoboApplication();
			IDirecaoApplication direcaoApplication = ApplicationFactory.GetInstance().getDirecaoApplication();
			
			roboApplication.gerarEspacoDoRobo("3 3");
	
			String[] stringPositions = "1 1 N".split(" ");
			
			Direcao direcaoInicial = direcaoApplication.converterEmDirecao(stringPositions[2]);
			
			Robo robo = roboApplication.colocarRoboNaPosicaoInicial(Integer.parseInt(stringPositions[0]), Integer.parseInt(stringPositions[1]), direcaoInicial);
		
			int[][] gridResultado = roboApplication.movimentarRoboUmPasso(robo.getDirecao(), Direcao.Mover);
		
			int[][] grid = new int[4][4];
			grid[1][2] = 1;
			
			for(int x = 0 ; x < 4 ; x++)
			{
				for(int y = 0 ; y < 4 ; y++)
				{
					assertEquals(grid[x][y], gridResultado[x][y]);
				}
			}
		}
		catch(RoboException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
}
