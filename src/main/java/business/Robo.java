package business;

public class Robo
{
	private int[][] terreno;
	private Direcao direcao;
	private int posicaoAtualX;
	private int posicaoAtualY;
	
	public Robo(){}
	
	

	public Robo(int[][] terreno, Direcao direcao, int posicaoAtualX,
			int posicaoAtualY) {
		super();
		this.terreno = terreno;
		this.direcao = direcao;
		this.posicaoAtualX = posicaoAtualX;
		this.posicaoAtualY = posicaoAtualY;
	}



	public int[][] getTerreno() {
		return terreno;
	}

	public void setTerreno(int[][] terreno) {
		this.terreno = terreno;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public int getPosicaoAtualX() {
		return posicaoAtualX;
	}



	public void setPosicaoAtualX(int posicaoAtualX) {
		this.posicaoAtualX = posicaoAtualX;
	}



	public int getPosicaoAtualY() {
		return posicaoAtualY;
	}



	public void setPosicaoAtualY(int posicaoAtualY) {
		this.posicaoAtualY = posicaoAtualY;
	}
	

}