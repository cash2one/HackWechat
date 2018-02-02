package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ap.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;

class BindGoogleContactUI$a extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ BindGoogleContactUI ykD;
    private String ykF;
    private String ykG;
    private boolean ykH;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSm();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
        Context context = this.ykD;
        boolean z = this.ykH;
        String str = this.ykG;
        if (!z || TextUtils.isEmpty(str)) {
            context.alp();
            context.cqv();
        } else if (TextUtils.isEmpty(context.ykr) || TextUtils.isEmpty(str) || context.ykr.equalsIgnoreCase(str)) {
            context.ykr = str;
            context.dj(context.ykr, a.hyR);
        } else {
            context.alp();
            h.a(context, context.getString(R.l.ent), "", new BindGoogleContactUI$4(context, str), new BindGoogleContactUI$5(context));
        }
    }

    public BindGoogleContactUI$a(BindGoogleContactUI bindGoogleContactUI, String str) {
        this.ykD = bindGoogleContactUI;
        this.ykF = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
        this.ykH = false;
    }

    private Void aSm() {
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
        try {
            String str = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + this.ykF).openConnection();
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
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
                str = stringBuffer.toString();
                x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", new Object[]{str});
            }
            httpURLConnection.disconnect();
            this.ykG = new JSONObject(str).optString("email");
            if (!TextUtils.isEmpty(this.ykG)) {
                this.ykH = true;
            }
        } catch (MalformedURLException e) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", new Object[]{e.getMessage()});
        } catch (ProtocolException e2) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", new Object[]{e2.getMessage()});
        } catch (UnsupportedEncodingException e3) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", new Object[]{e3.getMessage()});
        } catch (IOException e4) {
            x.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", new Object[]{e4.getMessage()});
        } catch (Throwable e5) {
            x.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e5, "", new Object[0]);
        }
        return null;
    }
}
