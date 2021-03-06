package javasmmr.zoowsome.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javasmmr.zoowsome.services.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

public class Spider extends Insect {
	
	public Spider()
	{
		this("SPIDER",false,true,1.0,0.7);
	}
	
	public Spider(String name, boolean answer1, boolean answer2, Double maintCost, double dangerPerc)
	{
		super(maintCost,dangerPerc);
		this.setNumberOfLegs(8);
		this.setName(name);
		this.setIsFlying(answer1);
		this.setItIsDangerous(answer2);
	}
	
	public boolean kill()
	{
		double randomNumber = Math.random();
		double predispositionOfAnimal = this.getPredisposition();
		if(randomNumber < predispositionOfAnimal)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public double getPredisposition()
	{
		String theTime = new SimpleDateFormat("HH:mm").format(new Date());
		double thePredisposition = this.dangerPercentage;
		if(theTime.compareTo("09:30")>0 && theTime.compareTo("13:30")<0)
		{
			thePredisposition = 0.0;
		}
		return thePredisposition;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException
	{
		super.encodeToXml(eventWriter);
		createNode(eventWriter,Constants.XML_TAGS.DISCRIMINANT,Constants.Animals.Insects.Spider);
	}
	
	public void decodeFromXml(Element theElement)
	{
		
	}
}