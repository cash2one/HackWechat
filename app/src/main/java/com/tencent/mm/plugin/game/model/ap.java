package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.game.model.ao.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap {
    private static String ned = null;
    private static String nee = "";

    public static void a(Context context, int i, int i2, int i3, String str, int i4, String str2) {
        x.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + i + " , " + i2 + " , " + i3 + " , 1" + " , 0 , " + bh.ou(str) + " , " + i4 + " , 0 , " + bh.ou(null) + " , " + bh.ou(null) + " , " + bh.ou(str2));
        g.pQN.h(13384, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(0), str, Integer.valueOf(i4), Integer.valueOf(0), null, Integer.valueOf(bh.getInt(null, 0)), Integer.valueOf(getNetworkType(context)), str2);
    }

    public static void a(Context context, String str, long j, int i) {
        g.pQN.h(14416, str, Long.valueOf(j), Integer.valueOf(getNetworkType(context)), Integer.valueOf(i));
    }

    public static void o(Context context, String str, String str2) {
        x.d("MicroMsg.GameReportUtil", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (bh.ov(str)) {
            x.e("MicroMsg.GameReportUtil", "reportRegToWx fail, appId is null");
            return;
        }
        g.pQN.h(10534, str, Integer.valueOf(aa(context, str2)), aQV(), Long.valueOf(System.currentTimeMillis() / 1000));
    }

    public static void a(String str, String str2, int i, int i2, String str3, long j) {
        x.d("MicroMsg.GameReportUtil", "reportReadMsg, appId = " + str);
        if (bh.ov(str)) {
            x.e("MicroMsg.GameReportUtil", "reportReadMsg fail, appId is null");
            return;
        }
        x.d("MicroMsg.GameReportUtil", "reportReadMsg, unsignedlonglong = " + new BigInteger("00FFFFFFFFFFFFFFFF", 16).and(BigInteger.valueOf(j)).toString());
        g.pQN.h(10532, str, r0, str2, Integer.valueOf(i), str3, Integer.valueOf(i2));
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
        x.d("MicroMsg.GameReportUtil", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", str, str2, Long.valueOf(j), str5);
        if (bh.ov(str)) {
            x.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appId is null");
            return;
        }
        if (context == null) {
            context = ac.getContext();
        }
        if (com.tencent.mm.pluginsdk.model.app.g.aZ(str, false) == null) {
            x.e("MicroMsg.GameReportUtil", "reportMsgClick fail, appinfo is null");
            return;
        }
        SubCoreGameCenter.aRf().a(a.g(10531, str, Integer.valueOf(aa(context, str2)), aQV(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(getNetworkType(context)), bh.ou(r0.field_packageName), bh.ou(r0.field_signature), Long.toString(j), "", str5));
    }

    public static void h(String str, int i, int i2, int i3) {
        x.d("MicroMsg.GameReportUtil", "reportGameDetail, appId = " + str + ", scene = " + i2);
        if (bh.ov(str)) {
            x.e("MicroMsg.GameReportUtil", "reportGameDetail fail, appId is null");
            return;
        }
        g.pQN.h(10700, str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static void a(String str, String str2, int i, int i2, String str3, int i3) {
        x.d("MicroMsg.GameReportUtil", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (bh.ov(str2)) {
            x.e("MicroMsg.GameReportUtil", "rejectGameMsg fail, appId is null");
            return;
        }
        g.pQN.h(10546, str, str2, Integer.valueOf(i), aQV(), Integer.valueOf(i2), str3, Integer.valueOf(i3));
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        x.d("MicroMsg.GameReportUtil", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (bh.ov(str)) {
            x.e("MicroMsg.GameReportUtil", "reportDelGameMsg fail, appId is null");
            return;
        }
        if (context == null) {
            context = ac.getContext();
        }
        SubCoreGameCenter.aRf().a(a.g(10583, str, Integer.valueOf(aa(context, str2)), aQV(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(getNetworkType(context))));
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        SubCoreGameCenter.aRf().a(a.g(12909, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(bh.getInt(str3, 0)), Integer.valueOf(getNetworkType(context)), str4));
    }

    public static void a(Context context, int i, int i2, int i3, String str) {
        a g = a.g(12909, Integer.valueOf(18), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(0), null, Integer.valueOf(i3), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(getNetworkType(context)), str);
        GameCrossProcessReportReceiver.H(g.hQu, g.nec);
    }

    public static void a(int i, int i2, int i3, long j, String str, String str2, String str3, long j2, long j3, String str4) {
        SubCoreGameCenter.aRf().a(a.g(14683, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, null, str3, Long.valueOf(j2), Long.valueOf(j3), null));
    }

    public static void am(int i, String str) {
        a aVar = new a();
        aVar.hQu = i;
        aVar.nec = str;
        SubCoreGameCenter.aRf().a(aVar);
    }

    public static String BY(String str) {
        if (bh.ov(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            String str2 = "";
            x.e("MicroMsg.GameReportUtil", exception.getMessage());
            return str2;
        }
    }

    public static String A(Map<String, String> map) {
        if (map.size() == 0) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                x.e("MicroMsg.GameReportUtil", e.getMessage());
                return "";
            }
        }
        try {
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e2) {
            x.e("MicroMsg.GameReportUtil", e2.getMessage());
            return "";
        }
    }

    public static String cL(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameReportUtil", e, "", new Object[0]);
        }
        return BY(jSONObject.toString());
    }

    public static String L(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            x.e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = cM(str, jSONObject.toString());
        }
        return BY(str);
    }

    private static String cM(String str, String str2) {
        if (bh.ov(str)) {
            return str2;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str3 = (String) keys.next();
                        jSONObject2.put(str3, jSONObject.opt(str3));
                    } catch (Exception e2) {
                        return "";
                    }
                }
            }
            return jSONObject2.toString();
        } catch (JSONException e3) {
            return "";
        }
    }

    public static void a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        long currentTimeMillis = System.currentTimeMillis();
        SubCoreGameCenter.aRf().a(a.g(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), str2, "", str3, Integer.valueOf(getNetworkType(ac.getContext())), Integer.valueOf(0), Integer.valueOf(1), str4, str5));
    }

    public static void a(String str, int i, int i2, long j, long j2, String str2, int i3, int i4, String str3, long j3, int i5, long j4) {
        x.i("MicroMsg.GameReportUtil", "reportGameDownloadState, appId = %s, scene = %d, opId = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j3), Integer.valueOf(i5));
        SubCoreGameCenter.aRf().a(a.g(14567, str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), BY(str2), Integer.valueOf(getNetworkType(ac.getContext())), Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j3), Integer.valueOf(i5), Long.valueOf(j4), BY(null)));
    }

    public static void M(String str, String str2, String str3) {
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.GameReportUtil", "null open or null username");
            return;
        }
        g.pQN.h(10738, str, str2, str, str3);
    }

    private static int aa(Context context, String str) {
        PackageInfo packageInfo = p.getPackageInfo(context, str);
        return packageInfo == null ? 0 : packageInfo.versionCode;
    }

    private static String aQV() {
        if (ned == null) {
            String yF = q.yF();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < yF.length() - 1; i++) {
                stringBuilder.append(Integer.toHexString(yF.charAt(i)));
            }
            stringBuilder.append("00");
            ned = stringBuilder.toString();
        }
        return ned;
    }

    public static int getNetworkType(Context context) {
        if (an.is3G(context)) {
            return 4;
        }
        if (an.is4G(context)) {
            return 5;
        }
        switch (an.getNetType(context)) {
            case -1:
                return 255;
            case 0:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 6;
        }
    }

    public static void BZ(String str) {
        nee = str;
    }
}
