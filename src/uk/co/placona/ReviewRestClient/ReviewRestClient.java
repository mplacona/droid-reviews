package uk.co.placona.ReviewRestClient;

import org.json.JSONException;

public class ReviewRestClient {
	public void getReviews(String fileName,ReviewJsonHandler jsonHandler) throws JSONException{		
		ReviewRestClientHttp.get(fileName, null, jsonHandler);
	}
}
