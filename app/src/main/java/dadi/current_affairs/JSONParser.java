package dadi.current_affairs;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
public class JSONParser {
	public final static int GET = 1;
	public final static int POST = 2;
	public final static int DELETE = 3;
	private static JSONObject jObject;
	public static JSONObject makeServiceCall(String url, int method,
			List<NameValuePair> params) {
		try {
			// http client
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;
			// Checking http request method type
			System.out.println("method: " + method);
			if (method == POST) {
				System.gc();
				HttpPost httpPost = new HttpPost(url.trim());
				// adding post param
				System.out.println("params: " + params);
				System.out.println("url: " + url.trim());
				if (params != null) {
					httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
				}
				System.out.println("noty: " + httpPost);
				httpResponse = httpClient.execute(httpPost);
				System.out.println("STEP: 1 :" + httpResponse);
			} else if (method == GET) {
				// appending params to url
				if (params != null) {
					String paramString = URLEncodedUtils
							.format(params, "utf-8");
					url += "?" + paramString;
					System.out.println("STEP: 2 :" + url);
				}
				HttpGet httpGet = new HttpGet(url);
				//added line
				httpGet.addHeader("Cache-Control", "no-cache");
				httpResponse = httpClient.execute(httpGet);
			}
			else if (method == DELETE) {
				// appending params to url
				if (params != null) {
					String paramString = URLEncodedUtils
							.format(params, "utf-8");
					url += "?" + paramString;
					System.out.println("STEP: 2 :" + url);


				}
				HttpGet httpGet = new HttpGet(url);
				HttpDelete httpDelete = new HttpDelete(url);
				//added line
				httpGet.addHeader("Cache-Control", "no-cache");
				httpResponse = httpClient.execute(httpDelete);
			}

            httpEntity = httpResponse.getEntity();
			System.out.println("STEP: 2 :" + httpEntity);
			// response = EntityUtils.toString(httpEntity);
			InputStream in = httpEntity.getContent(); // Get the data in the
			System.out.println("STEP: 3 :" + in); // entity
			String a = convertStreamToString(in);

			String xx = httpResponse.getEntity().getContentType().getValue();
			Log.d("type", xx.toString());
			if (xx.equals("application/json; charset=utf-8")){
				Log.d("hello","hleoo");
				jObject = new JSONObject(a.toString());
				System.out.println("jobject: " + jObject);
			}else {

				try {
					jObject = XML.toJSONObject(a.toString());
				} catch (JSONException e) {
					Log.e("JSON exception", e.getMessage());
					e.printStackTrace();
				}
			}


		} catch (JSONException je) {
			je.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jObject;
	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line.trim() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
