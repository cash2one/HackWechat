package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class h {
    public static String xP(String str) {
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        x.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return "";
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
            return "";
        } catch (Exception e2) {
            exception = e2;
            x.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return "";
        }
    }

    public static a b(g gVar) {
        a aVar = new a();
        aVar.field_downloadUrl = gVar.iFI;
        aVar.field_secondaryUrl = gVar.lsv;
        aVar.field_fileSize = gVar.lsw;
        aVar.field_downloadUrlHashCode = gVar.iFI.hashCode();
        aVar.field_fileName = gVar.mFileName;
        aVar.field_fileType = gVar.lsy;
        aVar.field_md5 = gVar.lsx;
        aVar.field_appId = gVar.mAppId;
        aVar.field_autoInstall = gVar.lsz;
        aVar.field_showNotification = gVar.lsA;
        aVar.field_packageName = gVar.mPackageName;
        aVar.field_autoDownload = gVar.lsC;
        aVar.field_scene = gVar.irz;
        return aVar;
    }
}
