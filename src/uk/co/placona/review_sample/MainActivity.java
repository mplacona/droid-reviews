package uk.co.placona.review_sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uk.co.placona.ReviewRestClient.OnDownloadListener;
import uk.co.placona.ReviewRestClient.ReviewJsonHandler;
import uk.co.placona.ReviewRestClient.ReviewRestClient;

public class MainActivity extends Activity implements OnDownloadListener {
	ReviewRestClient reviewRestClient;
	ReviewJsonHandler reviewJsonHandler;
	ReviewAdapter adpt;
	EditText txt;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt = (EditText) this.findViewById(R.id.editText1);
        adpt  = new ReviewAdapter(new ArrayList<Review>(), this);
        ListView lView = (ListView) findViewById(R.id.listView1);
        
        lView.setAdapter(adpt);
        
        reviewJsonHandler = new ReviewJsonHandler(this);
        reviewRestClient = new ReviewRestClient();
        
        try{
        	reviewRestClient.getReviews("reviews", reviewJsonHandler);
        }catch(JSONException e){
        	e.printStackTrace();
        }
        
    }
    
    /*
    private JSONArray fakeJsonObject(){
    	JSONArray object = null;
		String s = "[{\"id\":1,\"name\":\"Marcos\",\"text\":\"This is some text\",\"created_at\":\"2013-08-14T08:37:05+01:00\",\"updated_at\":\"2013-08-14T08:37:05+01:00\"},{\"id\":2,\"name\":\"Marcos\",\"text\":\"This is some text\",\"created_at\":\"2013-08-14T08:37:36+01:00\",\"updated_at\":\"2013-08-14T08:37:36+01:00\"},{\"id\":3,\"name\":\"Marcos\",\"text\":\"another review updated\",\"created_at\":\"2013-08-14T08:48:50+01:00\",\"updated_at\":\"2013-08-14T08:48:50+01:00\"}]";
		try {
			object = new JSONArray(s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
    }*/
    
    private Review convertReview(JSONObject obj) throws JSONException{   	
		return new Review(obj.getString("name"), obj.getString("text"));    	
    }
    
	public void onDownloadSuccess(JSONArray reviews) {
		List<Review> result = new ArrayList<Review>();

        for (int i=0; i < reviews.length(); i++) {
			try {
				result.add(convertReview(reviews.getJSONObject(i)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}
		adpt.setItemList(result);
		txt.setText(reviews.toString());
	}

	public void onDownloadFailure() {
		// TODO Auto-generated method stub
		
	}
}
