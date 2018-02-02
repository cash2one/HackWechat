package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.freewifi.ui.a.2.1.1;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

class a$2$1$1$1 implements Runnable {
    final /* synthetic */ String mDA;
    final /* synthetic */ String mDn;
    final /* synthetic */ String mDz;
    final /* synthetic */ String mGJ;
    final /* synthetic */ String mGK;
    final /* synthetic */ 1 mGL;

    a$2$1$1$1(1 1, String str, String str2, String str3, String str4, String str5) {
        this.mGL = 1;
        this.mGJ = str;
        this.mDz = str2;
        this.mDA = str3;
        this.mGK = str4;
        this.mDn = str5;
    }

    public final void run() {
        Exception exception;
        Writer stringWriter;
        String stringWriter2;
        g gVar;
        Object[] objArr;
        Throwable th;
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", new Object[]{this.mGJ});
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(this.mGJ);
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                    int responseCode = httpURLConnection2.getResponseCode();
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    g.pQN.h(12907, new Object[]{this.mDz, this.mDA, this.mGK, this.mDn, "", Long.valueOf(currentTimeMillis), Integer.valueOf(responseCode), "", "", ""});
                    x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", new Object[]{Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis)});
                    if (200 == responseCode) {
                        ag.y(new Runnable(this) {
                            final /* synthetic */ a$2$1$1$1 mGM;

                            {
                                this.mGM = r1;
                            }

                            public final void run() {
                                this.mGM.mGL.mGI.mGF.setVisibility(0);
                            }
                        });
                    } else if (HardCoderJNI.SCENE_QUIT_CHATTING == responseCode) {
                        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        stringWriter = new StringWriter();
                        exception.printStackTrace(new PrintWriter(stringWriter));
                        stringWriter2 = stringWriter.toString();
                        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                        if (stringWriter2 == null) {
                            stringWriter2 = "";
                        }
                        gVar = g.pQN;
                        objArr = new Object[10];
                        objArr[0] = this.mDz;
                        objArr[1] = this.mDA;
                        objArr[2] = this.mGK;
                        objArr[3] = this.mDn;
                        objArr[4] = "";
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = "";
                        objArr[8] = "";
                        if (stringWriter2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            stringWriter2 = stringWriter2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        }
                        objArr[9] = stringWriter2;
                        gVar.h(12907, objArr);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Exception e2) {
            exception = e2;
            stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            stringWriter2 = stringWriter.toString();
            x.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
            if (stringWriter2 == null) {
                stringWriter2 = "";
            }
            gVar = g.pQN;
            objArr = new Object[10];
            objArr[0] = this.mDz;
            objArr[1] = this.mDA;
            objArr[2] = this.mGK;
            objArr[3] = this.mDn;
            objArr[4] = "";
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            objArr[7] = "";
            objArr[8] = "";
            if (stringWriter2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stringWriter2 = stringWriter2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            objArr[9] = stringWriter2;
            gVar.h(12907, objArr);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
