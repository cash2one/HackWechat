package com.tencent.mm.ui.bindgooglecontact;

import android.os.AsyncTask;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

class GoogleFriendUI$c extends AsyncTask<Void, Void, Void> {
    private String ykF;
    private boolean ykH;
    private String ykJ;
    final /* synthetic */ GoogleFriendUI ykV;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSm();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
        GoogleFriendUI.a(this.ykV, this.ykH, this.ykF);
    }

    public GoogleFriendUI$c(GoogleFriendUI googleFriendUI, String str) {
        this.ykV = googleFriendUI;
        this.ykJ = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
        this.ykH = false;
    }

    private Void aSm() {
        x.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
        try {
            String str = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("refresh_token", this.ykJ));
            arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
            arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
            arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
            String N = n.N(arrayList);
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s" + N);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(N);
            bufferedWriter.flush();
            bufferedWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            x.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:" + responseCode);
            if (200 == responseCode) {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str = stringBuffer.toString();
                x.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s" + str);
            }
            httpURLConnection.disconnect();
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", new Object[]{str});
            this.ykF = new JSONObject(str).optString("access_token");
            this.ykH = true;
        } catch (ProtocolException e) {
            x.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", new Object[]{e.getMessage()});
        } catch (MalformedURLException e2) {
            x.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", new Object[]{e2.getMessage()});
        } catch (IOException e3) {
            x.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", new Object[]{e3.getMessage()});
        } catch (JSONException e4) {
            x.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", new Object[]{e4.getMessage()});
        }
        return null;
    }
}
