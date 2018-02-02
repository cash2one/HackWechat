package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

class FreeWifiManufacturerLoadingUI$5 implements Runnable {
    final /* synthetic */ String mDz;
    final /* synthetic */ FreeWifiManufacturerLoadingUI mHX;
    private int mHZ = 0;
    private final int mIa = 5;

    FreeWifiManufacturerLoadingUI$5(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        this.mHX = freeWifiManufacturerLoadingUI;
        this.mDz = str;
    }

    public final void run() {
        Context context = ac.getContext();
        if (context == null) {
            FreeWifiManufacturerLoadingUI.a(this.mHX, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
            return;
        }
        if (!(m.aLl() && m.AD("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(this.mDz))) {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + this.mDz);
            FreeWifiManufacturerLoadingUI.a(this.mHX, this.mHX.getString(R.l.ejX));
            int aKT = new b(this.mDz, context).aKT();
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=" + aKT);
            if (aKT != 0) {
                FreeWifiManufacturerLoadingUI.a(this.mHX, aKT, "An attempt to switch to special portal ap failed. connectRet=" + aKT);
                return;
            }
        }
        aMK();
    }

    private void aMJ() {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
        this.mHZ++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            x.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
        }
        aMK();
    }

    private void aMK() {
        Exception exception;
        Writer stringWriter;
        Throwable th;
        String aLb = h.b.aLc().aLb();
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : " + aLb);
        FreeWifiManufacturerLoadingUI.a(this.mHX, this.mHX.getString(R.l.ejT));
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(aLb).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = " + responseCode);
                    String m;
                    if (200 == responseCode) {
                        if (m.AD("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(this.mDz)) {
                            m = FreeWifiManufacturerLoadingUI.m(httpURLConnection2.getInputStream());
                            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=" + m);
                            if (m.indexOf("wxwifiecho") == -1) {
                                FreeWifiManufacturerLoadingUI.b(this.mHX, aLb);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                            FreeWifiManufacturerLoadingUI.a(this.mHX, 0, "");
                            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                            FreeWifiManufacturerLoadingUI.a(this.mHX, 0, "");
                            FreeWifiManufacturerLoadingUI.a(this.mHX, this.mHX.getString(R.l.ejS));
                            FreeWifiManufacturerLoadingUI.e(this.mHX);
                            FreeWifiManufacturerLoadingUI.f(this.mHX);
                        } else {
                            FreeWifiManufacturerLoadingUI.a(this.mHX, 1150, "Target ssid is not connected.");
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    } else if (HardCoderJNI.SCENE_QUIT_CHATTING == responseCode) {
                        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                        m = httpURLConnection2.getHeaderField("Location");
                        if (m.AA(m)) {
                            FreeWifiManufacturerLoadingUI.a(this.mHX, 1146, "AP cannot response portal url properly.");
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        }
                        FreeWifiManufacturerLoadingUI.b(this.mHX, m);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    } else {
                        FreeWifiManufacturerLoadingUI.a(this.mHX, 1149, "Ap response code is neither 200 nor 302.");
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        stringWriter = new StringWriter();
                        exception.printStackTrace(new PrintWriter(stringWriter));
                        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                        if (exception instanceof UnknownHostException) {
                            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.mHZ), Integer.valueOf(5)});
                            if (this.mHZ < 5) {
                                aMJ();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        FreeWifiManufacturerLoadingUI.a(this.mHX, 1153, "An attempt to connect to ap failed.");
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
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.mHZ), Integer.valueOf(5)});
            if (this.mHZ < 5) {
                aMJ();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    return;
                }
                return;
            }
            FreeWifiManufacturerLoadingUI.a(this.mHX, 1148, "An attempt to connect to ap failed.");
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Exception e2) {
            exception = e2;
            stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
            if (exception instanceof UnknownHostException) {
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.mHZ), Integer.valueOf(5)});
                if (this.mHZ < 5) {
                    aMJ();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
            }
            FreeWifiManufacturerLoadingUI.a(this.mHX, 1153, "An attempt to connect to ap failed.");
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
