package hostupdater;

import model.Domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nikita Tkachuk
 */
public class HostReader {

    private static final String HOST_PATH = "C:\\Windows\\System32\\drivers\\etc\\hosts";
	//private static final Log4jListener LOGGER = new Log4jListener();
    public List<String> getHostDomainsList(){
		List<String> hostDomainsList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HOST_PATH));){
            while (bufferedReader.ready()){
               String hostLine =  bufferedReader.readLine();
                if (!hostLine.startsWith("#")) {
					int start = hostLine.indexOf(" ");
					if (start != -1) {
						//domain.setHost(hostLine.substring(start));
						hostDomainsList.add(hostLine.substring(start));
					}

                }
            }
        }
		catch (IOException e) {
			 e.printStackTrace();
		}
		return hostDomainsList;
	}


}
