package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DownloadHelper {
    public static final int PHONE = 1;
    public static final float SAVE_FATOR = 1.5f;
    public static final long SAVE_LENGTH = 104857600;
    public static final int SDCARD = 2;
    public static final String TAG = DownloadHelper.class.getSimpleName();
    public static final int UNKNOWN = 0;

    public static WakeLock getWakeLock() {
        return null;
    }

    public static String correctURL(String str) {
        String trim = str.replace("\r", "").replace("\n", "").trim();
        String str2 = new String(trim);
        try {
            Uri parse = Uri.parse(trim);
            CharSequence lastPathSegment = parse.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                str2 = str2.replace(lastPathSegment, URLEncoder.encode(parse.getLastPathSegment()).replace("+", "%20"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
        }
        return str2;
    }

    public static String genAPKFileName(String str) {
        if (str.contains(".apk")) {
            String trim = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (trim.contains("?")) {
                trim = trim.substring(0, trim.lastIndexOf("?"));
            }
            if (!TextUtils.isEmpty(trim)) {
                TMLog.i(TAG, "file name = " + trim);
                return renameAPKFileName(trim);
            }
        }
        return null;
    }

    public static String decodeFileName(String str) {
        if (str != null) {
            return URLDecoder.decode(str);
        }
        return null;
    }

    public static String correctFileName(String str) {
        return str.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    }

    public static String renameAPKFileName(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            return str;
        }
        String str2;
        String[] strArr = new String[]{str.substring(0, lastIndexOf), str.substring(lastIndexOf, str.length())};
        int i = 0;
        do {
            if (i == 0) {
                str2 = str;
            } else {
                str2 = strArr[0] + "(" + i + ")" + strArr[1];
            }
            i++;
        } while (new File(TMAssistantFile.getSavePathRootDir() + File.separator + str2).exists());
        return str2;
    }

    public static boolean isValidURL(String str) {
        try {
            URI uri = new URI(correctURL(str));
            return true;
        } catch (Throwable th) {
            x.printErrStackTrace(TAG, th, "", new Object[0]);
            return false;
        }
    }

    public static String generateFileNameFromURL(String str, String str2) {
        String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
        if (TextUtils.isEmpty(calcMD5AsString)) {
            calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("application/vnd.android.package-archive")) {
                str3 = ".apk";
            } else if (str2.equals("application/tm.android.apkdiff")) {
                str3 = ".diff";
            } else if (str2.equals("resource/tm.android.unknown")) {
                str3 = ".other";
            }
        }
        return calcMD5AsString + str3;
    }

    public static synchronized String getNetStatus() {
        String str;
        synchronized (DownloadHelper.class) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context == null) {
                str = "";
            } else {
                try {
                    if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                        str = "";
                    } else {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            str = "";
                        } else if (activeNetworkInfo.getType() == 1) {
                            str = "wifi";
                        } else {
                            str = activeNetworkInfo.getExtraInfo();
                            if (str == null) {
                                str = "";
                            } else {
                                str = str.toLowerCase();
                                TMLog.v(TAG, "netInfo  =  " + str);
                            }
                        }
                    }
                } catch (Exception e) {
                    str = "";
                }
            }
        }
        return str;
    }

    public static boolean isNetworkConncted() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            TMLog.w(TAG, "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        boolean isAvailable;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            isAvailable = activeNetworkInfo.isAvailable();
        } else {
            isAvailable = false;
        }
        return isAvailable;
    }

    public static boolean isDownloadFileExisted(String str, String str2) {
        try {
            if (new File(TMAssistantFile.getSaveFilePath(generateFileNameFromURL(str, str2))).exists()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return false;
        }
    }

    public static boolean isDownloadFileExisted(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (new File(TMAssistantFile.getSaveFilePath(str)).exists()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSpaceEnough(String str, long j) {
        long j2 = 0;
        long j3 = -1;
        int storePosition = getStorePosition(str);
        if (storePosition == 1) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j3 = (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
        } else {
            if (storePosition == 2) {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs2 = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
                    j3 = (((long) statFs2.getAvailableBlocks()) - 4) * ((long) statFs2.getBlockSize());
                }
            }
            j2 = j3;
        }
        j3 = (long) (((float) j) * SAVE_FATOR);
        return j3 > SAVE_LENGTH ? j2 >= j3 : j2 >= SAVE_LENGTH;
    }

    public static int getStorePosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str != null && str.startsWith("/data")) {
            return 1;
        }
        if (TMAssistantFile.isSDCardExistAndCanWrite()) {
            return 2;
        }
        return 0;
    }
}
