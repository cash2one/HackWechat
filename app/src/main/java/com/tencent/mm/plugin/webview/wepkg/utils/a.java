package com.tencent.mm.plugin.webview.wepkg.utils;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void b(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        try {
            if (bh.ov(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DownloadInfo.NETTYPE, an.eP(ac.getContext()));
                encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, "UTF-8"));
                jSONObject2.put(DownloadInfo.NETTYPE, an.eP(ac.getContext()));
                encode = URLEncoder.encode(jSONObject2.toString(), "UTF-8");
            }
            try {
                if (!bh.ov(str2)) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            encode = str5;
        }
        g.pQN.h(13980, new Object[]{str, str2, str3, str4, Long.valueOf(j), encode, Long.valueOf(j2)});
    }

    public static String Qm(String str) {
        if (str == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
            x.e("MicroMsg.WePkgReport", e.getMessage());
            return "";
        } catch (UnsupportedEncodingException e2) {
            x.e("MicroMsg.WePkgReport", e2.getMessage());
            return "";
        }
    }

    public static String Bi(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
            return null;
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }
}
