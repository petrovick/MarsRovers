package applicationFactory;

import applicationImplementation.DirecaoApplication;
import applicationImplementation.RoboApplication;
import applicationInterfaces.IDirecaoApplication;
import applicationInterfaces.IRoboApplication;

public class ApplicationFactory
{
	private static ApplicationFactory applicationFactory;
	
	private ApplicationFactory() { }
	
	public static ApplicationFactory GetInstance()
	{
		if(applicationFactory == null)
		{
			return new ApplicationFactory();
		}
		return applicationFactory;
	}
	
	public IDirecaoApplication getDirecaoApplication()
	{
		return new DirecaoApplication();
	}
	
	public IRoboApplication getRoboApplication()
	{
		return new RoboApplication();
	}
}
