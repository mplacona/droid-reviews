package uk.co.placona.ReviewRestClient;

import org.json.JSONArray;

public interface IDownloadListener {
	public void onDownloadSuccess(JSONArray reviews);
    public void onDownloadFailure();
}
