package applicationInterfaces;

import business.Direcao;

public interface IDirecaoApplication {
	
	public Direcao[] converterEmDirecao(String[] direcoes);
	
	public Direcao converterEmDirecao(String direcao);
	
	public String reverterDirecaoParaString(Direcao direcao);
	
}
