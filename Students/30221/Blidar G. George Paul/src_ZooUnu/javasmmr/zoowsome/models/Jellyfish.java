package javasmmr.zoowsome.models;

public class Jellyfish extends Aquatic {
	
	public Jellyfish()
	{
		;
	}
	
	public Jellyfish(String name,int value, String waterType)
	{
		this.setNumberOfLegs(0);
		this.setName(name);
		this.setAvgSwimDepth(value);
		this.setWaterType(waterType);
	}
}