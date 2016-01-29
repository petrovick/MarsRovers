package business;

public enum Direcao
{
	Norte, Sul, Leste, Oeste, Mover;
	
	public Direcao posicaoAtual(String stringPosition)
	{
		if(stringPosition.toUpperCase().equals("N"))
			return Norte;
		if(stringPosition.toUpperCase().equals("S"))
			return Sul;
		if(stringPosition.toUpperCase().equals("E"))
			return Leste;
		if(stringPosition.toUpperCase().equals("W"))
			return Oeste;
		else if(stringPosition.toUpperCase().equals("M"))
			return Mover;
		else
			return null;
		
	}
	
}
