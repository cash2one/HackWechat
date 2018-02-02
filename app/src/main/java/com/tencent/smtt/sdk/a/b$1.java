package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.smtt.sdk.o;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

class b$1 extends Thread {
    final /* synthetic */ ThirdAppInfoNew Aag;
    final /* synthetic */ Context rkw;

    b$1(String str, Context context, ThirdAppInfoNew thirdAppInfoNew) {
        this.rkw = context;
        this.Aag = thirdAppInfoNew;
        super(str);
    }

    public final void run() {
        if (VERSION.SDK_INT >= 8) {
            if (b.Aaf == null) {
                try {
                    b.Aaf = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e) {
                    b.Aaf = null;
                    TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                }
            }
            if (b.Aaf == null) {
                TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                return;
            }
            String string = o.gG(this.rkw).zXm.getString("tbs_deskey_token", "");
            String str = "";
            String str2 = "";
            if (TextUtils.isEmpty(string)) {
                String str3 = str2;
                str2 = str;
                str = str3;
            } else {
                str2 = string.substring(0, string.indexOf("&"));
                str = string.substring(string.indexOf("&") + 1, string.length());
            }
            boolean z = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
            try {
                JSONObject b;
                q cFD = q.cFD();
                if (z) {
                    StringBuilder append = new StringBuilder().append(cFD.Abf);
                    j.cFu();
                    str2 = append.append(j.cFv()).toString();
                } else {
                    str2 = cFD.Abg + str2;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                try {
                    b = b.b(this.Aag, this.rkw);
                } catch (Exception e2) {
                    b = null;
                }
                if (b == null) {
                    TbsLog.e("sdkreport", "post -- jsonData is null!");
                    return;
                }
                try {
                    byte[] bytes = b.toString().getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bL = z ? j.cFu().bL(bytes) : j.i(bytes, str);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bL.length));
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bL);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() != 200) {
                            TbsLog.e("sdkreport", "Post failed -- not 200");
                        }
                    } catch (Throwable th) {
                        TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                    }
                } catch (Throwable th2) {
                }
            } catch (IOException e3) {
                TbsLog.e("sdkreport", "Post failed -- IOException:" + e3);
            } catch (AssertionError e4) {
                TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e4);
            } catch (NoClassDefFoundError e5) {
                TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
            }
        }
    }
}
