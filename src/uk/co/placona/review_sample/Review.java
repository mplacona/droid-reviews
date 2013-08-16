package uk.co.placona.review_sample;

public class Review {
	public String name;
	public String text;
	
	public Review(){}
	
	public Review(String name, String text){
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return this.name;
	}

	public String getText() {
		return this.text;
	}
}
