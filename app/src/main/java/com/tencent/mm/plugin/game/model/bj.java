package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;

public class bj {
    private static bj neA;
    private static TMQQDownloaderOpenSDK neB;

    private bj() {
    }

    public static bj aQY() {
        if (neA == null) {
            synchronized (bj.class) {
                if (neA == null) {
                    neA = new bj();
                }
            }
        }
        return neA;
    }

    private static TMQQDownloaderOpenSDK aQZ() {
        if (neB == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            neB = instance;
            instance.initQQDownloaderOpenSDK(ac.getContext());
        }
        return neB;
    }

    public static void aRa() {
        boolean z = false;
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(neB == null);
        if (neA == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (neB != null) {
            neB.destroyQQDownloaderOpenSDK();
        }
        neB = null;
        neA = null;
    }

    public static void ab(Context context, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
        } else if (context == null) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
        } else {
            x.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[]{str});
            TMQQDownloaderOpenSDKParam Cb = new a((byte) 0).Cb(str);
            try {
                aQY();
                aQZ().startToDownloadTaskList(context, Cb, true, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
            }
        }
    }

    public static int Ca(String str) {
        if (!bh.ov(str)) {
            return a(new a((byte) 0).Cb(str));
        }
        x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
        return -1;
    }

    private static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        try {
            aQY();
            TMAssistantDownloadTaskInfo downloadTaskState = aQZ().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                return downloadTaskState.mState;
            }
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[]{e.getMessage()});
        }
        return -1;
    }

    public static int g(Context context, String str, int i) {
        int i2 = -1;
        if (bh.ov(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
        } else {
            try {
                PackageInfo packageInfo = p.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i2 = 1;
                } else {
                    x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[]{Integer.valueOf(packageInfo.versionCode)});
                    i2 = packageInfo.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[]{e.getMessage()});
            }
            x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[]{Integer.valueOf(i2)});
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            return;
        }
        TMQQDownloaderOpenSDKParam Cb = new a((byte) 0).Cb(str);
        try {
            aQY();
            aQZ().startToAuthorized(context, Cb, "1");
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public static boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aQY();
        return aQZ().registerListener(iTMQQDownloaderOpenSDKListener);
    }

    public static boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aQY();
        return aQZ().unregisterListener(iTMQQDownloaderOpenSDKListener);
    }
}
