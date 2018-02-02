package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.k.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class d {
    public static Context ssG = null;
    private static final String ssH;
    private static final Uri ssI = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        ssH = stringBuilder.toString();
    }

    public static boolean bIm() {
        return true;
    }

    public static int bIn() {
        return VERSION.SDK_INT;
    }

    private static boolean bIo() {
        boolean z = false;
        FileInputStream fileInputStream;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("ro.miui.ui.version.name", null);
                if (property != null && property.equals("V6")) {
                    z = true;
                }
            } catch (IOException e) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                x.d("VoipUtil", "isMIUIv6 " + z);
                return z;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            x.d("VoipUtil", "isMIUIv6 " + z);
            return z;
        }
        x.d("VoipUtil", "isMIUIv6 " + z);
        return z;
    }

    public static boolean dD(Context context) {
        boolean z = false;
        if (bIo()) {
            z = dG(context);
        }
        x.d("VoipUtil", "isLbePermissionEnable ret:" + z);
        return z;
    }

    public static boolean dE(Context context) {
        boolean z = false;
        if (bIo()) {
            z = dF(context);
        }
        x.d("VoipUtil", "setLbePermissionEnable ret:" + z);
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean dF(Context context) {
        ContentResolver contentResolver;
        int i;
        int i2;
        Throwable th;
        Throwable th2;
        Cursor query;
        ContentResolver contentResolver2;
        try {
            int i3;
            int i4;
            contentResolver = context.getContentResolver();
            query = contentResolver.query(ssI, new String[]{"userAccept"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        i3 = query.getInt(0);
                        if (query == null) {
                            query.close();
                            i4 = i3;
                            contentResolver2 = contentResolver;
                            i = i4;
                        } else {
                            i4 = i3;
                            contentResolver2 = contentResolver;
                            i = i4;
                        }
                        x.d("VoipUtil", "setLbePermissionEnable query ua: ", new Object[]{Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                        i2 = -1;
                        if (i != -1 || contentResolver2 == null) {
                            i = -1;
                        } else {
                            int i5 = i | WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                            try {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("userAccept", Integer.valueOf(i5));
                                i = contentResolver2.update(ssI, contentValues, "pkgName='com.tencent.mm'", null);
                                try {
                                    x.d("VoipUtil", "serLbePermissionEnable update ua: ", new Object[]{Integer.valueOf(i5), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), " ret: ", Integer.valueOf(i)});
                                } catch (Throwable th22) {
                                    i2 = i;
                                    th = th22;
                                    x.w("VoipUtil", "isLbePermissionEnable update ", new Object[]{th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                                    if (i2 > 0) {
                                        return false;
                                    }
                                    return true;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                x.w("VoipUtil", "isLbePermissionEnable update ", new Object[]{th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                                if (i2 > 0) {
                                    return false;
                                }
                                return true;
                            }
                        }
                        i2 = i;
                        if (i2 > 0) {
                            return true;
                        }
                        return false;
                    }
                } catch (Throwable th4) {
                    th22 = th4;
                    try {
                        x.w("VoipUtil", "isLbePermissionEnable query ", new Object[]{th22, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                        if (query != null) {
                            query.close();
                            contentResolver2 = contentResolver;
                            i = -1;
                        } else {
                            contentResolver2 = contentResolver;
                            i = -1;
                        }
                        x.d("VoipUtil", "setLbePermissionEnable query ua: ", new Object[]{Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                        i2 = -1;
                        if (i != -1) {
                        }
                        i = -1;
                        i2 = i;
                        if (i2 > 0) {
                            return true;
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            i3 = -1;
            if (query == null) {
                i4 = i3;
                contentResolver2 = contentResolver;
                i = i4;
            } else {
                query.close();
                i4 = i3;
                contentResolver2 = contentResolver;
                i = i4;
            }
        } catch (Throwable th6) {
            th = th6;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        x.d("VoipUtil", "setLbePermissionEnable query ua: ", new Object[]{Integer.valueOf(i), " flag: ", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
        i2 = -1;
        if (i != -1) {
        }
        i = -1;
        i2 = i;
        if (i2 > 0) {
            return false;
        }
        return true;
    }

    private static boolean dG(Context context) {
        Cursor query;
        Throwable th;
        try {
            query = context.getContentResolver().query(ssI, new String[]{"suggestAccept", "userAccept", "userPrompt", "userReject"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        boolean z = ((query.getInt(0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT && (query.getInt(2) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0 && (query.getInt(3) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) || (query.getInt(1) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.w("gray", "isLbePermissionEnable", new Object[]{th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return false;
    }

    public static void M(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    public static int ok(String str) {
        int i = 0;
        try {
            i = bh.getInt(g.zY().getValue(str), 0);
        } catch (Exception e) {
            x.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static boolean bIp() {
        b axVar = new ax();
        a.xef.m(axVar);
        return axVar.fpc.fdc;
    }

    public static boolean bIq() {
        b spVar = new sp();
        spVar.fKq.fuL = 2;
        a.xef.m(spVar);
        return spVar.fKr.fKs;
    }

    public static boolean bIr() {
        b bfVar = new bf();
        a.xef.m(bfVar);
        return bfVar.fpv.fdc;
    }

    public static boolean bIs() {
        b auVar = new au();
        a.xef.m(auVar);
        return auVar.foW.foX;
    }

    public static Notification a(Builder builder) {
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            return builder.getNotification();
        }
        return builder.build();
    }
}
