package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.xweb.r;
import org.xwalk.core.Log;

public final class f {
    static b Asn;

    static {
        r.initInterface();
    }

    public static void a(b bVar) {
        Asn = bVar;
    }

    public static boolean iR(Context context) {
        if (Asn != null) {
            return Asn.s(context, false);
        }
        Log.e("TbsDownloader", "needSendRequest: sImp is null");
        return false;
    }

    public static boolean A(Context context, boolean z) {
        return a(context, z, false, null);
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        if (Asn != null) {
            return Asn.a(context, z, z2, aVar);
        }
        Log.e("TbsDownloader", "needDownload: sImp is null");
        return false;
    }

    public static void gI(Context context) {
        t(context, false);
    }

    public static synchronized void t(Context context, boolean z) {
        synchronized (f.class) {
            if (Asn != null) {
                Asn.t(context, z);
            } else {
                Log.e("TbsDownloader", "startDownload: sImp is null");
            }
        }
    }

    public static void stopDownload() {
        if (Asn != null) {
            Asn.stopDownload();
        } else {
            Log.e("TbsDownloader", "stopDownload: sImp is null");
        }
    }

    public static synchronized boolean isDownloading() {
        boolean isDownloading;
        synchronized (f.class) {
            if (Asn != null) {
                isDownloading = Asn.isDownloading();
            } else {
                Log.e("TbsDownloader", "isDownloading: sImp is null");
                isDownloading = false;
            }
        }
        return isDownloading;
    }

    public static boolean cEs() {
        if (Asn != null) {
            return Asn.cEs();
        }
        Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
        return false;
    }
}
