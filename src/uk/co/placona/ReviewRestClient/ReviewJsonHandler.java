package uk.co.placona.ReviewRestClient;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.co.placona.review_sample.MainActivity;

import com.loopj.android.http.JsonHttpResponseHandler;

public class ReviewJsonHandler extends JsonHttpResponseHandler{
	private final MainActivity activity;
	
	public ReviewJsonHandler(MainActivity activity){
		this.activity = activity;	
	}
	
	public void onSuccess(JSONArray reviews){
		activity.onDownloadSuccess(reviews);
	}
	
	public void onFailure(Throwable arg0, JSONObject arg1) {
		super.onFailure(arg0, arg1);
        activity.onDownloadFailure();
	}
}
