package uk.co.placona.ReviewRestClient;

import com.loopj.android.http.RequestParams;

import org.json.JSONException;

public class ReviewRestClient {
	public void getReviews(String url,ReviewJsonHandler jsonHandler) throws JSONException{
		ReviewRestClientHttp.get(url, null, jsonHandler);
	}

    public void getReview(String url, ReviewJsonHandler jsonHandler) throws JSONException{
        ReviewRestClientHttp.get(url, null, jsonHandler);
    }

    public void createReview(String url, RequestParams params, ReviewJsonHandler jsonHandler) throws JSONException{
        ReviewRestClientHttp.post(url, params, jsonHandler);
    }
}
