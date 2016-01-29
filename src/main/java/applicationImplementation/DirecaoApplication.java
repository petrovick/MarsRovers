package applicationImplementation;

import applicationInterfaces.IDirecaoApplication;
import business.Direcao;

public class DirecaoApplication implements IDirecaoApplication
{
	public Direcao converterEmDirecao(String direcao)
	{
		return direcao.equals("N") ? Direcao.Norte : 
			direcao.equals("S") ? Direcao.Sul : 
			direcao.equals("E") ? Direcao.Leste : 
			direcao.equals("W") ? Direcao.Oeste : 
			Direcao.Mover;
	}
	
	public Direcao[] converterEmDirecao(String[] direcoes)
	{
		Direcao[] direcaos = new Direcao[direcoes.length];
		int i = 0;
		for(String direcao : direcoes)
		{
			direcaos[i] = direcao.equals("R") ? Direcao.Leste : 
				direcao.equals("L") ? Direcao.Oeste : 
				Direcao.Mover;
			i++;
		}
		return direcaos;
	}
	
	public String reverterDirecaoParaString(Direcao direcao)
	{
		return direcao.equals(Direcao.Norte) ? "N" : 
			direcao.equals(Direcao.Sul) ? "S" : 
			direcao.equals(Direcao.Leste) ? "E" : 
			direcao.equals(Direcao.Oeste) ? "W" : 
			"M";
	}
	

}
