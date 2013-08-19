package uk.co.placona.ReviewRestClient;

<<<<<<< HEAD
import com.loopj.android.http.RequestParams;

=======
import android.util.Log;

import com.loopj.android.http.RequestParams;

import org.apache.http.HttpEntity;
>>>>>>> patch_functionality
import org.json.JSONException;

import java.io.IOException;
import java.util.Iterator;

public class ReviewRestClient {
	public void getReviews(String url,ReviewJsonHandler jsonHandler) throws JSONException{
		ReviewRestClientHttp.get(url, null, jsonHandler);
	}

<<<<<<< HEAD
=======
    public void getReview(String url, ReviewJsonHandler jsonHandler) throws JSONException{
        ReviewRestClientHttp.get(url, null, jsonHandler);
    }

>>>>>>> patch_functionality
    public void createReview(String url, RequestParams params, ReviewJsonHandler jsonHandler) throws JSONException{
        ReviewRestClientHttp.post(url, params, jsonHandler);
    }
}
