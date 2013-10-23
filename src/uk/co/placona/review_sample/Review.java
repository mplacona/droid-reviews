package uk.co.placona.review_sample;

public class Review {
    private String id;
	private String name;
	private String text;

    public Review(String id, String name, String text){
        this.id = id;
		this.name = name;
		this.text = text;
	}

    public String getId() {
        return this.id;
    }

    public String getName() {
		return this.name;
	}

	public String getText() {
		return this.text;
    }
}
