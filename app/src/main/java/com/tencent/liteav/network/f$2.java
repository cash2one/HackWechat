package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f.a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class f$2 extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ a f;
    final /* synthetic */ f g;

    f$2(f fVar, String str, String str2, String str3, String str4, String str5, int i, a aVar) {
        this.g = fVar;
        this.a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str5;
        this.e = i;
        this.f = aVar;
        super(str);
    }

    public void run() {
        int i = -1;
        String str = "";
        for (int i2 = 5; i2 > 0; i2--) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bizid", Integer.valueOf(this.a).intValue());
                jSONObject.put("stream_id", this.b);
                jSONObject.put("txSecret", this.c);
                jSONObject.put("txTime", this.d);
                jSONObject.put(DownloadSettingTable$Columns.TYPE, 1);
                String jSONObject2 = jSONObject.toString();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://livepull.myqcloud.com/getpulladdr").openConnection();
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setRequestProperty("Charsert", "UTF-8");
                httpsURLConnection.setRequestProperty("Content-Type", "text/plain;");
                httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(jSONObject2.length()));
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + jSONObject2 + "] retryIndex = " + i2);
                new DataOutputStream(httpsURLConnection.getOutputStream()).write(jSONObject2.getBytes());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                str2 = "";
                while (true) {
                    jSONObject2 = bufferedReader.readLine();
                    if (jSONObject2 == null) {
                        break;
                    }
                    str2 = str2 + jSONObject2;
                }
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = " + str2);
                jSONObject = (JSONObject) new JSONTokener(str2).nextValue();
                if (jSONObject.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                    i = jSONObject.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                }
                if (i != 0) {
                    if (jSONObject.has("message")) {
                        str = jSONObject.getString("message");
                    }
                    TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i + " errorMessage = " + str);
                }
                Vector vector = new Vector();
                Vector vector2 = new Vector();
                JSONArray jSONArray = jSONObject.getJSONArray("pull_addr");
                if (jSONArray == null || jSONArray.length() == 0) {
                    TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                } else {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        jSONObject = (JSONObject) jSONArray.get(i3);
                        if (jSONObject != null) {
                            boolean z;
                            String string = jSONObject.getString("rtmp_url");
                            if (jSONObject.getInt("proto") == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + string + " Q channel = " + z);
                            String d = f.d(this.g, string);
                            if (d != null && d.equalsIgnoreCase(this.b)) {
                                if (z) {
                                    vector.add(new d(string, true));
                                } else {
                                    vector2.add(new d(string, false));
                                }
                            }
                        }
                    }
                }
                if (this.e == 1) {
                    if (vector2.size() > 0) {
                        f.a(this.g).post(new 1(this, vector2));
                        return;
                    }
                } else if (this.e != 2) {
                    Iterator it = vector2.iterator();
                    while (it.hasNext()) {
                        vector.add((d) it.next());
                    }
                    if (vector.size() > 0) {
                        f.a(this.g).post(new 3(this, vector));
                        return;
                    }
                } else if (vector.size() > 0) {
                    f.a(this.g).post(new 2(this, vector));
                    return;
                }
            } catch (Exception e) {
                str2 = str;
                int i4 = i;
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception");
                i = i4;
                str = str2;
            }
            try {
                sleep(1000, 0);
            } catch (Exception e2) {
                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
            }
        }
        f.a(this.g).post(new 4(this, i, str));
    }
}
