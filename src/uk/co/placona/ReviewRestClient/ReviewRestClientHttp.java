package uk.co.placona.ReviewRestClient;

import android.util.Log;

import com.loopj.android.http.*;

public class ReviewRestClientHttp {
	//private static final String BASE_URL = "http://10.0.0.2:9393/";
	private static final String BASE_URL = "http://top40.placona.co.uk/chart/";
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        Log.d("aaa", getAbsoluteUrl(url));
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}
	
	private static String getAbsoluteUrl(String relativeUrl){
		return BASE_URL + relativeUrl;
	}
}
