package com.tencent.mapsdk.rastercore.d;

import com.tencent.mapsdk.rastercore.a;
import java.net.HttpURLConnection;
import java.net.URL;

class e$2 extends Thread {
    e$2(e eVar) {
    }

    public final void run() {
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2;
        try {
            String str = Integer.toString(e.c) + "," + Integer.toString(e.d);
            String str2 = Integer.toString(e.a) + "," + Integer.toString(e.b);
            String str3 = Integer.toString(e.e) + "," + Integer.toString(0);
            httpURLConnection2 = (HttpURLConnection) new URL("https://pr.map.qq.com/pingd?" + a.a.toString() + "&appid=sdk&logid=ditu&miss=" + str + "&hit=" + str2 + "&keep=" + str3 + "&change=" + (Integer.toString(e.f) + "," + Integer.toString(0))).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.connect();
                if (httpURLConnection2.getResponseCode() == 200) {
                    httpURLConnection2.getInputStream();
                    e.c = 0;
                    e.d = 0;
                    e.a = 0;
                    e.b = 0;
                    e.e = 0;
                    e.f = 0;
                    e.g = 0;
                    e.b = 0;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e) {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            httpURLConnection2 = null;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
