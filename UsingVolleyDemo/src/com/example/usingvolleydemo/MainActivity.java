package com.example.usingvolleydemo;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.RequestConnControl;
import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// volley_Get();
		volley_Post();
	}

	private void volley_Post() {
		String url = "http://fanyi.youdao.com/openapi.do?";
		StringRequest request = new StringRequest(Method.POST, url,
				new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						Toast.makeText(MainActivity.this, arg0,
								Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Toast.makeText(MainActivity.this, "Õ¯¬Á«Î«Û ß∞‹",
								Toast.LENGTH_LONG).show();
					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap.put("keyfrom", "UsingVelloyDeo");
				hashMap.put("key", "1774363313");
				hashMap.put("doctype", "json");
				hashMap.put("type", "data");
				hashMap.put("version", "1.1");
				hashMap.put("q", "hello");
				return hashMap;
			}
		};
		request.setTag("aPost");
		MyApplication.getRequestQueue().add(request);
	}

	private void volley_Get() {
		String url = "http://fanyi.youdao.com/openapi.do?keyfrom=UsingVelloyDeo&key=1774363313&type=data&doctype=json&version=1.1&q=hello";
		StringRequest request = new StringRequest(Method.GET, url,
				new Listener<String>() {

					// «Î«Ûªÿµ˜
					@Override
					public void onResponse(String arg0) {
						Toast.makeText(MainActivity.this, arg0,
								Toast.LENGTH_LONG).show();
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Toast.makeText(MainActivity.this, "Õ¯¬Á«Î«Û ß∞‹",
								Toast.LENGTH_LONG).show();
					}
				});
		request.setTag("aGet");
		MyApplication.getRequestQueue().add(request);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		MyApplication.getRequestQueue().cancelAll("aPost");
	}

}
