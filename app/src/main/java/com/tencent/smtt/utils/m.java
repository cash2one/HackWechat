package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.smtt.sdk.a.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class m {
    private static m AaR = null;
    private Handler mHandler;

    private m() {
        this.mHandler = null;
        this.mHandler = new Handler(this, Looper.getMainLooper()) {
            final /* synthetic */ m AaS;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(Message message) {
                try {
                    Object[] objArr;
                    switch (message.what) {
                        case 0:
                            objArr = (Object[]) message.obj;
                            m.bR((Context) objArr[0], (String) objArr[1]);
                            break;
                        case 1:
                            m.a(this.AaS, (Context) ((Object[]) message.obj)[0]);
                            break;
                        case 2:
                            objArr = (Object[]) message.obj;
                            m.bS((Context) objArr[0], (String) objArr[1]);
                            break;
                    }
                } catch (Exception e) {
                }
                super.handleMessage(message);
            }
        };
    }

    static /* synthetic */ void a(m mVar, Context context) {
        try {
            Object cFC = mVar.cFC();
            if (!TextUtils.isEmpty(cFC)) {
                File file = new File(cFC);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    n.hV(context);
                    String str = context.getApplicationInfo().processName;
                    if (!TextUtils.isEmpty(str)) {
                        n.abp(str);
                        n.abq(str);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private static Map<String, String> abo(String str) {
        if (str.length() <= 0) {
            return null;
        }
        try {
            Map<String, String> hashMap = new HashMap();
            try {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.trim().split("=", 2);
                        if (split != null && split.length >= 2) {
                            String str3 = split[0];
                            Object obj = split[1];
                            if (str3 != null && str3.length() > 0) {
                                hashMap.put(str3, obj);
                            }
                        }
                    }
                }
                return hashMap;
            } catch (Throwable th) {
                return hashMap;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static void bR(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            c.a(context, str, null, null);
        }
    }

    static /* synthetic */ void bS(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public static m cFA() {
        if (AaR == null) {
            AaR = new m();
        }
        return AaR;
    }

    private static Map<String, String> cFB() {
        Throwable th;
        FileInputStream fileInputStream = null;
        String str = "";
        try {
            FileInputStream fileInputStream2;
            String str2 = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
            String str3 = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
            File file = new File("/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini");
            if (!file.exists()) {
                file = new File(str2);
            }
            File file2 = !file.exists() ? new File(str3) : file;
            if (file2.exists()) {
                fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] t = f.t(fileInputStream2);
                    if (t != null) {
                        str = new String(t, ProtocolPackage.ServerEncoding);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    throw th;
                }
            }
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return abo(str);
    }

    private String cFC() {
        Map cFB = cFB();
        if (cFB != null && cFB.size() > 0) {
            String str = (String) cFB.get("FileDownloadPath");
            String str2 = (String) cFB.get("FileDownloadVerifyInfo");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            if (TextUtils.equals(i.bV(file.lastModified()), str2)) {
                return str;
            }
        }
        return "";
    }

    private static PackageInfo m(String str, Context context) {
        PackageInfo packageInfo = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            } catch (Throwable th) {
            }
        }
        return packageInfo;
    }

    public final boolean bQ(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("tbsqbdownload://")) {
                    String substring;
                    String str2;
                    String[] split = str.substring(16).split(",");
                    if (split.length > 1) {
                        String[] split2 = split[0].split("=");
                        substring = (split2.length <= 1 || !SlookSmartClipMetaTag.TAG_TYPE_URL.equalsIgnoreCase(split2[0])) ? null : split[0].substring(4);
                        String[] split3 = split[1].split("=");
                        if (split3.length <= 1 || !"downloadurl".equalsIgnoreCase(split3[0])) {
                            str2 = substring;
                            substring = null;
                        } else {
                            str2 = substring;
                            substring = split[1].substring(12);
                        }
                    } else {
                        substring = null;
                        str2 = null;
                    }
                    if (str2 == null || substring == null) {
                        return false;
                    }
                    boolean z = m("com.tencent.mtt", context) != null ? true : !TextUtils.isEmpty(cFC());
                    Object obj;
                    Message message;
                    if (z) {
                        obj = new Object[]{context, str2};
                        message = new Message();
                        message.what = 0;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else if (z) {
                        obj = new Object[]{context};
                        message = new Message();
                        message.what = 1;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else {
                        obj = new Object[]{context, substring};
                        message = new Message();
                        message.what = 2;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }
}
