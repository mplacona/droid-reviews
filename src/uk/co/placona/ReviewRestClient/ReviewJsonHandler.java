package uk.co.placona.ReviewRestClient;

import org.json.JSONObject;

import uk.co.placona.review_sample.MainActivity;

import com.loopj.android.http.JsonHttpResponseHandler;

public class ReviewJsonHandler extends JsonHttpResponseHandler{
	MainActivity activity;
	
	public ReviewJsonHandler(MainActivity activity){
		this.activity = activity;	
	}
	
	public void onSuccess(JSONObject myObj){
		activity.onDownloadSuccess(myObj);
	}
	
	public void onFailure(Throwable arg0, JSONObject arg1) {
		super.onFailure(arg0, arg1);
        activity.onDownloadFailure();
	}
}
