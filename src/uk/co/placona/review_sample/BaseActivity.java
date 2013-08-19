package uk.co.placona.review_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONArray;
<<<<<<< HEAD
=======
import org.json.JSONObject;
>>>>>>> patch_functionality

import uk.co.placona.ReviewRestClient.IDownloadListener;

/**
 * Created by mplacona on 18/08/2013.
 */
public class BaseActivity extends Activity implements IDownloadListener {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.review_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reviews:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.menu_create:
                startActivity(new Intent(this, CreateReviewActivity.class));
                break;

            default:
                break;
        }

        return true;
    }

    @Override
    public void onDownloadSuccess(JSONArray reviews) {

    }

    @Override
<<<<<<< HEAD
=======
    public void onDownloadSuccess(JSONObject reviews) {

    }

    @Override
>>>>>>> patch_functionality
    public void onDownloadFailure() {

    }
}