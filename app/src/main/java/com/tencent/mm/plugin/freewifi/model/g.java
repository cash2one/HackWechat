package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    int mEm = 5;

    static /* synthetic */ void b(String str, int i, Intent intent) {
        x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", new Object[]{str, Integer.valueOf(i)});
        if (i == 3) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c AQ = j.aLO().AQ(str);
            if (AQ != null) {
                AQ.field_expiredTime = bh.Wo() - 10;
                boolean c = j.aLO().c(AQ, new String[0]);
                x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", new Object[]{str, Long.valueOf(AQ.field_expiredTime), Boolean.valueOf(c)});
            }
        }
        d.a(str, i, intent);
    }

    static /* synthetic */ String cB(String str, String str2) {
        if (bh.ov(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
            String[] split = str.split("\\?");
            String[] split2 = str2.length() > 0 ? split[1].split("&") : split;
            if (split2 != null && split2.length > 0) {
                for (String str3 : split2) {
                    if (str3.startsWith(str2)) {
                        return str3.substring(str2.length());
                    }
                }
            }
        }
        return null;
    }

    static String AN(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
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
            return null;
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            x.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
