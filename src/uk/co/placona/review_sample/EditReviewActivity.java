package uk.co.placona.review_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import uk.co.placona.ReviewRestClient.IDownloadListener;
import uk.co.placona.ReviewRestClient.ReviewJsonHandler;
import uk.co.placona.ReviewRestClient.ReviewRestClient;

/**
 * Created by mplacona on 19/08/2013.
 */
public class EditReviewActivity extends BaseActivity implements IDownloadListener {
    private ReviewRestClient reviewRestClient;
    private ReviewJsonHandler reviewJsonHandler;
    private TextView name;
    private TextView text;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_review);

        reviewJsonHandler = new ReviewJsonHandler(this);
        reviewRestClient = new ReviewRestClient();

        // view
        name = (TextView) findViewById(R.id.name);
        text = (TextView) findViewById(R.id.text);

        // Get values
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        RequestParams params = new RequestParams();
        params.put("id", id);

        try {
            // this looks bad, but will do for an example
            reviewRestClient.getReview("review/" + id, reviewJsonHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Review convertReview(JSONObject obj) throws JSONException{
        return new Review(obj.getString("name"), obj.getString("text"));
    }


    @Override
    public void onDownloadSuccess(JSONObject reviews) {
        Review review;
        Log.d("aaa", reviews.toString());
        try {
            review = convertReview(reviews);
            name.setText(review.getName());
            text.setText(review.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDownloadFailure() {

    }
}