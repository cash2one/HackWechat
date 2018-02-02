package com.tencent.mm.ui.bindgooglecontact;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI.a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
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

class BindGoogleContactUI$b extends AsyncTask<Void, Void, Void> {
    private boolean fsH;
    final /* synthetic */ BindGoogleContactUI ykD;
    private String ykF;
    private String ykI;
    private String ykJ;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSm();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
        BindGoogleContactUI bindGoogleContactUI = this.ykD;
        boolean z = this.fsH;
        Object obj2 = this.ykF;
        String str = this.ykJ;
        if (!z || TextUtils.isEmpty(obj2)) {
            bindGoogleContactUI.alp();
            bindGoogleContactUI.cqv();
            return;
        }
        bindGoogleContactUI.ykA = obj2;
        bindGoogleContactUI.ykB = str;
        new a(bindGoogleContactUI, bindGoogleContactUI.ykA).execute(new Void[0]);
    }

    public BindGoogleContactUI$b(BindGoogleContactUI bindGoogleContactUI, String str) {
        this.ykD = bindGoogleContactUI;
        this.ykI = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
        this.ykF = "";
        this.ykJ = "";
        this.fsH = false;
    }

    private Void aSm() {
        try {
            String str = this.ykI;
            String str2 = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str));
            arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
            arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
            arrayList.add(new BasicNameValuePair("redirect_uri", "urn:ietf:wg:oauth:2.0:oob"));
            arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
            str = n.N(arrayList);
            x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", new Object[]{str});
            httpURLConnection.setRequestProperty("Content-length", String.valueOf(str.getBytes().length));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:" + responseCode);
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
                str2 = stringBuffer.toString();
                x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", new Object[]{str2});
            }
            httpURLConnection.disconnect();
            this.ykF = new JSONObject(str2).optString("access_token");
            this.ykJ = new JSONObject(str2).optString("refresh_token");
            x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", new Object[]{str2});
            x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", new Object[]{this.ykF});
            x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", new Object[]{this.ykJ});
            this.fsH = true;
        } catch (MalformedURLException e) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e.getMessage());
        } catch (ProtocolException e2) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e2.getMessage());
        } catch (IOException e3) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e3.getMessage());
        } catch (JSONException e4) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e4.getMessage());
        }
        return null;
    }
}
