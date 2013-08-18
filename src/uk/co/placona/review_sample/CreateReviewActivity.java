package uk.co.placona.review_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mplacona on 18/08/2013.
 */
public class CreateReviewActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_review);

        Button btn = (Button) findViewById(R.id.submit_review);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText text = (EditText) findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateReviewActivity.this, CreateReviewActionActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("text", text.getText().toString());
                startActivity(intent);
            }
        });
    }
}