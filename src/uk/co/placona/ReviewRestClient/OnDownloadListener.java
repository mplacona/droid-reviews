package uk.co.placona.ReviewRestClient;

import org.json.JSONArray;

public interface OnDownloadListener {
	public void onDownloadSuccess(JSONArray reviews);
    public void onDownloadFailure();
}
