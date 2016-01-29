package applicationInterfaces;

import exception.RoboException;
import business.Direcao;
import business.Robo;

public interface IRoboApplication
{
	public int[][] gerarEspacoDoRobo(String espaco);

	public Robo colocarRoboNaPosicaoInicial(int x, int y, Direcao direcao);
	
	public String movimentarRobo(Direcao[] direcoes) throws RoboException;
	
	public int[][] movimentarRoboUmPasso(Direcao direcaoAtual,Direcao direcao) throws RoboException;
	
	
}
