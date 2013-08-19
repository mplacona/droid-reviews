package uk.co.placona.ReviewRestClient;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IDownloadListener {
	public void onDownloadSuccess(JSONArray reviews);
    public void onDownloadSuccess(JSONObject reviews);
    public void onDownloadFailure();
}
