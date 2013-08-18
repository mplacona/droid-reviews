package uk.co.placona.review_sample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import uk.co.placona.ReviewRestClient.IDownloadListener;
import uk.co.placona.ReviewRestClient.ReviewJsonHandler;
import uk.co.placona.ReviewRestClient.ReviewRestClient;

/**
 * Created by mplacona on 18/08/2013.
 */
public class CreateReviewActionActivity extends BaseActivity implements IDownloadListener {

    private ReviewRestClient reviewRestClient;
    private ReviewJsonHandler reviewJsonHandler;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.created_review);

        reviewJsonHandler = new ReviewJsonHandler(this);
        reviewRestClient = new ReviewRestClient();

        // Get values
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String text = intent.getStringExtra("text");

        RequestParams params = new RequestParams();
        params.put("name", name);
        params.put("text", text);

        try {
            reviewRestClient.createReview("review", params, reviewJsonHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDownloadSuccess(JSONArray reviews) {
        Log.d("aaa", reviews.toString());
    }

    @Override
    public void onDownloadFailure() {

    }
}
