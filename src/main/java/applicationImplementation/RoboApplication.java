package applicationImplementation;

import exception.RoboException;
import applicationFactory.ApplicationFactory;
import applicationInterfaces.IDirecaoApplication;
import applicationInterfaces.IRoboApplication;
import business.Direcao;
import business.Robo;
import sun.security.util.Length;

public class RoboApplication implements IRoboApplication
{
	private IDirecaoApplication direcaoApplication;
	private Robo robo;
	
	public RoboApplication()
	{
		robo = new Robo();
		direcaoApplication = ApplicationFactory.GetInstance().getDirecaoApplication();
	}
	/**
	 * 
	 * @param espaco - Este parametro possui as dimensões do array que o robô pode percorrer.
	 * @return - Retorna o array contendo o espaco que o robô pode percorrer.
	 */
	public int[][] gerarEspacoDoRobo(String gradeEmString)
	{

		String[] grades = gradeEmString.split(" ");

		int x = Integer.parseInt(grades[0]) + 1;
		int y = Integer.parseInt(grades[1]) + 1;
		
		robo.setTerreno(new int[x][y]);
		return robo.getTerreno();
	}


	/**
	 * 
	 * @param x - Inicializa a posição do robô em x.
	 * @param y - Inicializa a posição do robô em y.
	 * @param direcao - Inicializa a direção que o robô irá começar.
	 * @return - Retorna o robô com suas posições e direção.
	 */
	public Robo colocarRoboNaPosicaoInicial(int x, int y, Direcao direcao)
	{
		robo.setPosicaoAtualX(x);
		robo.setPosicaoAtualY(y);
		robo.setDirecao(direcao);
		return robo;
	}


	/**
	 * 
	 * @param direcoes - Aponta as direções que o robô deve apontar/seguir.
	 * @return - Retorna em string o valor de x, y e sua coordenada (Ex: 1 2 N).
	 * @throws RoboException
	 */
	public String movimentarRobo(Direcao[] direcoes) throws RoboException
	{
		if(robo.getTerreno() == null)
		{
			throw new RoboException("Favor configurar o terreno do robô, chamando o método RoboApplication.gerarEspacoDoRobo(String).");
		}
		String finalLocation = "";
		int[][] grid = null;
		for(Direcao direcao : direcoes)
		{
			grid = movimentarRoboUmPasso(robo.getDirecao(), direcao);
			
		}
		
		for(int i = 0 ; i < robo.getTerreno().length ; i++)
		{
			for(int j = 0 ; j < robo.getTerreno()[0].length ; j++ )
			{
				if(grid[i][j] == 1)
					finalLocation = i + " " + j + " " + direcaoApplication.reverterDirecaoParaString(robo.getDirecao());
			}
		}
		
		return finalLocation;
	}

	/**
	 * 
	 * @param direcaoAtual - Aponta a coordenada que o robô está apontando.
	 * @param direcao - Aponta direção que o robô deve apontar/seguir.
	 * @return - Retorna o array contendo o espaco em que o robô se encontra.
	 */
	public int[][] movimentarRoboUmPasso(Direcao direcaoAtual,Direcao direcao) throws RoboException
	{
		if(robo.getTerreno() == null)
			throw new RoboException("Favor configurar o terreno do robô, chamando o método RoboApplication.gerarEspacoDoRobo(String).");
		int[][] grid = robo.getTerreno();
		int x = robo.getPosicaoAtualX();
		int y = robo.getPosicaoAtualY();
		
		int xAMover = 0;
		int yAMover = 0;
		
		if(direcao == Direcao.Mover)
		{
			switch(direcaoAtual)
			{
				case Norte:
					yAMover = 1;
					xAMover = 0;
					break;
					
				case Sul:
					yAMover = -1;
					xAMover = 0;
					break;
					
				case Leste:
					yAMover = 0;
					xAMover = 1;
					break;
					
				case Oeste:
					yAMover = 0;
					xAMover = -1;
					break;
				default:
					break;
				
			}
			grid[x][y] = 0; //Como o robo saiu desta posição então limpe este local com um 0
			x = x + xAMover;
			y = y + yAMover;
			
			robo.setPosicaoAtualX(x);
			robo.setPosicaoAtualY(y);
			
			grid[x][y] = 1;//Coloca nova posição do robô em marte
			
		}
		else if(direcao == Direcao.Leste)
		{
			direcaoAtual = direcaoAtual == Direcao.Norte ? Direcao.Leste : 
				direcaoAtual == Direcao.Leste ? Direcao.Sul : 
				direcaoAtual == Direcao.Sul ? Direcao.Oeste :
				direcaoAtual == Direcao.Oeste ? Direcao.Norte : direcaoAtual;
		}
		else if(direcao == Direcao.Oeste)
		{
			direcaoAtual = direcaoAtual == Direcao.Norte ? Direcao.Oeste: 
				direcaoAtual == Direcao.Oeste ? Direcao.Sul : 
				direcaoAtual == Direcao.Sul ? Direcao.Leste :
				direcaoAtual == Direcao.Leste ? Direcao.Norte : direcaoAtual;
		}
		robo.setDirecao(direcaoAtual);
		return grid;
	}
}
