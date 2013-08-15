package uk.co.placona.review_sample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ReviewAdapter extends ArrayAdapter<Review> {

	private List<Review> reviewList;
	private Context context;
	
	public ReviewAdapter(List<Review> reviewList, Context ctx) {
		super(ctx, android.R.layout.simple_list_item_1, reviewList);
		this.reviewList = reviewList;
		this.context = ctx;
	}
	
	public int getCount() {
		if (reviewList != null)
			return reviewList.size();
		return 0;
	}
	
	public Review getItem(int position) {
		if (reviewList != null)
			return reviewList.get(position);
		return null;
	}
	
	public long getItemId(int position) {
		if (reviewList != null)
			return reviewList.get(position).hashCode();
		return 0;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.review_layout, null);
		}
		Review r = reviewList.get(position);
		
		TextView text = (TextView) v.findViewById(R.id.name);
		text.setText(r.getName());
		
		TextView text1 = (TextView) v.findViewById(R.id.review);
		text1.setText(r.getText());

		return v;
	}
	
	public List<Review> getItemList(){
		return reviewList;
	}
	
	public void setItemList(List<Review> itemList) {
		this.reviewList = itemList;
	}
}
