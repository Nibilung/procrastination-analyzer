import hostupdater.HostReader;
import model.Domain;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args)
    {
		HostReader hostReader = new HostReader();
		for (String domain : hostReader.getHostDomainsList())
		{
			System.out.println(domain);
		}
    }
}

