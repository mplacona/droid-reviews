package uk.co.placona.ReviewRestClient;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ReviewRestClientHttp {
	private static final String BASE_URL = "http://10.0.2.2:9393/";
	//private static final String BASE_URL = "http://top40.placona.co.uk/chart/";
	private static final AsyncHttpClient client = new AsyncHttpClient();
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.setTimeout(3000);
        client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl){
		return BASE_URL + relativeUrl;
	}
}
