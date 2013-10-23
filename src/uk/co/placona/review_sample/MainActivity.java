package uk.co.placona.review_sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uk.co.placona.ReviewRestClient.IDownloadListener;
import uk.co.placona.ReviewRestClient.ReviewJsonHandler;
import uk.co.placona.ReviewRestClient.ReviewRestClient;

public class MainActivity extends BaseActivity implements IDownloadListener {
	private ReviewRestClient reviewRestClient;
	private ReviewJsonHandler reviewJsonHandler;
	private ReviewAdapter adpt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adpt  = new ReviewAdapter(new ArrayList<Review>(), this);
        ListView lView = (ListView) findViewById(R.id.listView1);
        
        lView.setAdapter(adpt);
        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentEdit = new Intent(MainActivity.this, EditReviewActivity.class);
                String id = (String)view.getTag();
                intentEdit.putExtra("id", id);
                startActivity(intentEdit);
            }
        });
        
        reviewJsonHandler = new ReviewJsonHandler(this);
        reviewRestClient = new ReviewRestClient();
        
        try{
        	reviewRestClient.getReviews("reviews", reviewJsonHandler);
        }catch(JSONException e){
        	e.printStackTrace();
        }
        
    }

    private Review convertReview(JSONObject obj) throws JSONException{   	
		return new Review(obj.getString("id"),obj.getString("name"), obj.getString("text"));
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
        adpt.notifyDataSetChanged();
	}

	public void onDownloadFailure() {
		// TODO Auto-generated method stub
		
	}
}
