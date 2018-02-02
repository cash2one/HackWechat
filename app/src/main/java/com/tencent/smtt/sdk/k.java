package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.sdk.CookieManager.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public final class k {
    public static final String LOGTAG = CookieManager.LOGTAG;
    static File zWC;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Context context, int i, String str, boolean z) {
        Cursor cursor = null;
        if (context != null) {
            if (i != a.zVc || !TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 0) {
                    SQLiteDatabase gA = gA(context);
                    if (gA != null) {
                        HashMap hashMap = new HashMap();
                        try {
                            cursor = gA.rawQuery("select * from cookies", null);
                            int gB;
                            if (cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (gA != null && gA.isOpen()) {
                                    gA.close();
                                }
                                if (!hashMap.isEmpty()) {
                                    if (context != null) {
                                        f.e(gz(context), false);
                                    }
                                    for (Entry entry : hashMap.entrySet()) {
                                        CookieManager.getInstance().setCookie((String) entry.getKey(), (String) entry.getValue(), true);
                                    }
                                    if (VERSION.SDK_INT < 21) {
                                        CookieManager.getInstance().flush();
                                    } else {
                                        CookieSyncManager.getInstance().sync();
                                    }
                                    if (z) {
                                        b(gA(context));
                                        gB = gB(context);
                                        if (gB != -1) {
                                            CookieManager.getInstance();
                                            CookieManager.setROMCookieDBVersion(context, gB);
                                        }
                                    }
                                }
                            }
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("host_key"));
                                if (i == a.zVc) {
                                    boolean z2;
                                    for (Object equals : split) {
                                        if (string.equals(equals)) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                    z2 = false;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(cursor.getString(cursor.getColumnIndex(DownloadSettingTable$Columns.VALUE)));
                                stringBuilder.append(";").append(cursor.getString(cursor.getColumnIndex("name")));
                                stringBuilder.append(";").append(cursor.getInt(cursor.getColumnIndex("expires_utc")));
                                stringBuilder.append(";").append(cursor.getInt(cursor.getColumnIndex(DownloadInfo.PRIORITY)));
                                hashMap.put(string, stringBuilder.toString());
                            } while (cursor.moveToNext());
                            if (cursor != null) {
                                cursor.close();
                            }
                            gA.close();
                            if (!hashMap.isEmpty()) {
                                if (context != null) {
                                    f.e(gz(context), false);
                                }
                                for (Entry entry2 : hashMap.entrySet()) {
                                    CookieManager.getInstance().setCookie((String) entry2.getKey(), (String) entry2.getValue(), true);
                                }
                                if (VERSION.SDK_INT < 21) {
                                    CookieSyncManager.getInstance().sync();
                                } else {
                                    CookieManager.getInstance().flush();
                                }
                                if (z) {
                                    b(gA(context));
                                    gB = gB(context);
                                    if (gB != -1) {
                                        CookieManager.getInstance();
                                        CookieManager.setROMCookieDBVersion(context, gB);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (gA != null && gA.isOpen()) {
                                gA.close();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return cursor;
        }
        ArrayList<String> arrayList = new ArrayList();
        try {
            cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(1);
                    cursor.getString(4);
                    arrayList.add(string);
                    c(sQLiteDatabase, string);
                } while (cursor.moveToNext());
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            Cursor cursor2 = cursor;
            Throwable th3 = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            sQLiteDatabase.close();
            throw th3;
        }
        return arrayList;
    }

    private static String c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            return stringBuilder.toString();
        }
        do {
            stringBuilder.append("\n");
            for (count = 0; count < columnCount; count++) {
                try {
                    stringBuilder.append(rawQuery.getString(count)).append(",");
                } catch (Exception e) {
                }
            }
            stringBuilder.append("\n");
        } while (rawQuery.moveToNext());
        return stringBuilder.toString();
    }

    private static SQLiteDatabase gA(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        if (context != null) {
            File gz = gz(context);
            if (gz != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openDatabase(gz.getAbsolutePath(), null, 0);
                } catch (Exception e) {
                }
                if (sQLiteDatabase == null) {
                    TbsLog.i(LOGTAG, "dbPath is not exist!");
                }
            }
        }
        return sQLiteDatabase;
    }

    public static int gB(Context context) {
        Throwable th;
        int i = 0;
        Cursor cursor = null;
        System.currentTimeMillis();
        SQLiteDatabase gA;
        try {
            gA = gA(context);
            if (gA == null) {
                if (gA != null && gA.isOpen()) {
                    gA.close();
                }
                return -1;
            }
            try {
                cursor = gA.rawQuery("select * from meta", null);
                int count = cursor.getCount();
                cursor.getColumnCount();
                if (count > 0 && cursor.moveToFirst()) {
                    while (!cursor.getString(0).equals("version")) {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    }
                    i = Integer.parseInt(cursor.getString(1));
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (gA == null || !gA.isOpen()) {
                    return i;
                }
                gA.close();
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            gA = null;
            if (cursor != null) {
                cursor.close();
            }
            if (gA != null && gA.isOpen()) {
                gA.close();
            }
            throw th;
        }
    }

    private static File gz(Context context) {
        if (zWC == null && context != null) {
            zWC = new File(context.getDir("webview", 0), "Cookies");
        }
        if (zWC == null) {
            zWC = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        return zWC;
    }
}
