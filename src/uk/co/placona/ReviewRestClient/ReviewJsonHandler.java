package uk.co.placona.ReviewRestClient;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import uk.co.placona.review_sample.BaseActivity;

public class ReviewJsonHandler extends JsonHttpResponseHandler{
    BaseActivity activity;
	
	public ReviewJsonHandler(BaseActivity activity){
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
