package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(DownloadSettingTable$Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (bh.ov(optString) || bh.ov(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            jVar.E(i, e("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            jVar.E(i, e("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(jVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                jVar.E(i, e("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", jVar.mAppId);
            int i2 = 0;
            if (an.isConnected(jVar.getContext())) {
                if (an.isWifi(jVar.getContext())) {
                    i2 = 1;
                } else if (an.is4G(jVar.getContext())) {
                    i2 = 4;
                } else if (an.is3G(jVar.getContext())) {
                    i2 = 3;
                } else if (an.is2G(jVar.getContext())) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            long Wo = bh.Wo();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(Wo), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2);
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bh.ou(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str7 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                    g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
                    jVar.E(i, e("ok", null));
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str6;
                e = th;
                x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
                jVar.E(i, e("ok", null));
            }
            g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
            jVar.E(i, e("ok", null));
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(DownloadSettingTable$Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (bh.ov(optString) || bh.ov(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            pVar.E(i, e("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            pVar.E(i, e("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(pVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                pVar.E(i, e("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", pVar.mAppId);
            int i2 = 0;
            if (an.isConnected(pVar.mContext)) {
                if (an.isWifi(pVar.mContext)) {
                    i2 = 1;
                } else if (an.is4G(pVar.mContext)) {
                    i2 = 4;
                } else if (an.is3G(pVar.mContext)) {
                    i2 = 3;
                } else if (an.is2G(pVar.mContext)) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i2));
            }
            long Wo = bh.Wo();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(Wo), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2);
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bh.ou(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                optString = URLEncoder.encode(optString, "UTF-8");
                try {
                    str7 = URLEncoder.encode(optString2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                    g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
                    pVar.E(i, e("ok", null));
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                optString = str6;
                e = th;
                x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
                pVar.E(i, e("ok", null));
            }
            g.pQN.h(13579, r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Wo), Long.valueOf(Wo));
            pVar.E(i, e("ok", null));
        }
    }
}
