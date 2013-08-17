package uk.co.placona.review_sample;

public class Review {
	private String name;
	private String text;
	
	public Review(String name, String text){
		this.setName(name);
		this.setText(text);
	}

	public String getName() {
		return this.name;
	}

	public String getText() {
		return this.text;
	}

    private void setName(String name) {
        this.name = name;
    }

    private void setText(String text) {
        this.text = text;
    }
}
