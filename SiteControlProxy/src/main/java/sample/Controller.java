package sample;

import hostupdater.HostReader;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller extends SplitPane{

	@FXML
	private TextField siteName;
	@FXML
	private ListView hostsList;

	private HostReader hostReader = new HostReader();
	public Controller()
	{
		URL location = getClass().getResource("/sample.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText()
	{
		return getTextProperty().get();
	}

	public void setText(String text)
	{
		getTextProperty().set(text);
	}

	public void actionButton()
	{
		System.out.println(getText());
		//List<String> text = new ArrayList<String>(1);
		hostsList.setItems(FXCollections.observableList(hostReader.getHostDomainsList()));

	}

	private StringProperty getTextProperty()
	{
		return  siteName.textProperty();
	}



}
