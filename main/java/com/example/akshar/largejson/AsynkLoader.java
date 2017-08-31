package com.example.akshar.largejson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Akshar on 8/31/2017.
 */

public class AsynkLoader extends AsyncTask<Void,Void,String> {

    OnAsynkLoader onAsynkLoader;
    ListView listView;
    String urldata;
    ProgressDialog progressDialog;
    Context context;

    public AsynkLoader(MainActivity context, String urldata, OnAsynkLoader onAsynkLoader) {
        this.onAsynkLoader = onAsynkLoader;
        this.urldata = urldata;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("wait");
        progressDialog.setMessage("plz wait");
        progressDialog.show();
    }

    @Override

    protected String doInBackground(Void... params) {
        String result="";

        try {
            URL url =new URL(urldata);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            if(httpURLConnection.getResponseCode()==200){
                InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result+=line;
                }
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onAsynkLoader.OnResult(s);
        progressDialog.dismiss();
    }
}
