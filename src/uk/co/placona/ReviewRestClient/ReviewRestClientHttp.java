package uk.co.placona.ReviewRestClient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ReviewRestClientHttp {
    private static final int TIMEOUT = 3000;
	//private static final String BASE_URL = "http://10.0.2.2:9393/";
    private static final String BASE_URL = "http://10.0.3.2:9393/";
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.setTimeout(TIMEOUT);
        client.get(getAbsoluteUrl(url), params, responseHandler);
	}

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.setTimeout(TIMEOUT);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

	private static String getAbsoluteUrl(String relativeUrl){
		return BASE_URL + relativeUrl;
	}
}
