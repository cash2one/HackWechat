package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.m;
import com.tencent.smtt.sdk.o;
import com.tencent.smtt.sdk.p;
import com.tencent.smtt.sdk.x;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

public final class b {
    public static byte[] Aaf;

    static {
        Aaf = null;
        try {
            Aaf = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
    }

    private static JSONObject a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (x.hq(context)) {
                jSONObject.put("HOST_COREVERSION", x.cES());
            } else {
                jSONObject.put("HOST_COREVERSION", p.gJ(context));
                jSONObject.put("DECOUPLE_COREVERSION", p.gJ(context));
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = m.zXe;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", o.gG(context).cEp());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (thirdAppInfoNew.sAppName.equals("com.tencent.mobileqq")) {
                    k.cFx();
                    jSONObject.put("TID", k.abn(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        String str4;
        ThirdAppInfoNew thirdAppInfoNew;
        int i2;
        String str5 = "";
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            str4 = str5;
        } catch (Throwable th) {
            return;
        }
        ThirdAppInfoNew thirdAppInfoNew2 = new ThirdAppInfoNew();
        thirdAppInfoNew2.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
        q.hZ(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        thirdAppInfoNew2.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        thirdAppInfoNew2.sGuid = str;
        if (z) {
            thirdAppInfoNew2.sQua2 = str2;
        } else {
            thirdAppInfoNew2.sQua2 = com.tencent.smtt.utils.p.hW(context);
        }
        thirdAppInfoNew2.sLc = str3;
        str5 = c.hO(context);
        String ab = c.ab(context);
        String hN = c.hN(context);
        Object hP = c.hP(context);
        if (!(ab == null || "".equals(ab))) {
            thirdAppInfoNew2.sImei = ab;
        }
        if (!(hN == null || "".equals(hN))) {
            thirdAppInfoNew2.sImsi = hN;
        }
        if (!TextUtils.isEmpty(hP)) {
            thirdAppInfoNew2.sAndroidID = hP;
        }
        if (!(str5 == null || "".equals(str5))) {
            thirdAppInfoNew2.sMac = str5;
        }
        thirdAppInfoNew2.iPv = (long) i;
        ThirdAppInfoNew thirdAppInfoNew3;
        if (x.hq(context)) {
            if (!z) {
                thirdAppInfoNew3 = thirdAppInfoNew2;
                thirdAppInfoNew = thirdAppInfoNew3;
                i2 = 0;
            } else if (x.cEY()) {
                i2 = 2;
                thirdAppInfoNew = thirdAppInfoNew2;
            } else {
                i2 = 1;
                thirdAppInfoNew = thirdAppInfoNew2;
            }
        } else if (z) {
            i2 = 1;
            thirdAppInfoNew = thirdAppInfoNew2;
        } else {
            thirdAppInfoNew3 = thirdAppInfoNew2;
            thirdAppInfoNew = thirdAppInfoNew3;
            i2 = 0;
        }
        thirdAppInfoNew.iCoreType = i2;
        thirdAppInfoNew2.sAppVersionName = str4;
        thirdAppInfoNew2.sAppSignature = hH(context);
        if (!z) {
            thirdAppInfoNew2.sWifiConnectedTime = j;
            thirdAppInfoNew2.localCoreVersion = QbSdk.getTbsVersion(context);
        }
        new 1("HttpUtils", context.getApplicationContext(), thirdAppInfoNew2).start();
    }

    private static String hH(Context context) {
        String str = null;
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (toByteArray != null && toByteArray.length > 0) {
                        for (int i = 0; i < toByteArray.length; i++) {
                            String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                            if (i > 0) {
                                stringBuilder.append(":");
                            }
                            if (toUpperCase.length() < 2) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toUpperCase);
                        }
                        str = stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
