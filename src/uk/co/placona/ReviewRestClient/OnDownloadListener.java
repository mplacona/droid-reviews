package uk.co.placona.ReviewRestClient;

import org.json.JSONObject;

public interface OnDownloadListener {
	public void onDownloadSuccess(JSONObject obj);
    public void onDownloadFailure();
}
