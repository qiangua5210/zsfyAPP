package com.fyzs.Http;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import android.content.Context;

import com.fyzs.activity.StreamTools;

public class SetUser {
	public static void AddUser(String xh,String name,String sfz,String banji,String xibu,String email, String phone) {

		try {
			// httpclient get 请求提交数据
			Random r=new Random();
			int x=r.nextInt(9);
			String path = "http://202.119.168.66:8080/test"+x+"/UserServlet";
			//String path = "http://202.119.168.53:8080/test/LoginServlet";
			// 1.打开浏览器
			System.out.println("1");
			HttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 8000);// 连接时间
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					8000);// 数据传输时间
			// 2.输入地址
			System.out.println("2");
			HttpPost httpPost = new HttpPost(path);
			// 设置一个url表单的数据
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			 parameters.add(new BasicNameValuePair("xh", xh));
			 parameters.add(new BasicNameValuePair("name", name));
			 parameters.add(new BasicNameValuePair("sfz", sfz));
			 parameters.add(new BasicNameValuePair("banji", banji));
			 parameters.add(new BasicNameValuePair("xibu", xibu));
			 parameters.add(new BasicNameValuePair("email", email));
			 parameters.add(new BasicNameValuePair("phone", phone));
			httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
			// 3.敲回车
			System.out.println("3");
			httpPost.setHeader("Host", "121.42.31.127:8080");
			httpPost.setHeader("Referer",
					"http://121.42.31.127:8080/test/InsertLoginWHO.jsp");
			HttpResponse response = client.execute(httpPost);
			// httpclient get 请求提交数据

			System.out.println("4");
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				InputStream is = response.getEntity().getContent();
				String result = StreamTools.readFromStream(is);
				System.out.println("保存成功");
				//Toast.makeText(context, "反馈成功", 0).show();

			} else {
				// showToastInAnyThread("请求失败,返回码"+code);
				System.out.println("请求失败,返回码" + code);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("请求失败");
			// showToastInAnyThread("请求失败");
		}

	}
}
