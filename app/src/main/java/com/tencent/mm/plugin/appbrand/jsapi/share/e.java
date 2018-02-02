package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean jqT = false;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jqT) {
            jqT = false;
            if (jSONObject != null) {
                AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
                Context a = a(jVar);
                if (a == null) {
                    jVar.E(i, e("fail", null));
                    return;
                }
                String str;
                try {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        x.i("MicroMsg.JsApiShareTimeline", "%s, %s", new Object[]{str, jSONObject.get(str)});
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiShareTimeline", e, "", new Object[0]);
                }
                String optString = jSONObject.optString("path");
                String str2 = jVar.mAppId;
                str = jSONObject.optString("desc");
                String optString2 = jSONObject.optString("title");
                String str3 = appBrandSysConfig.fnl;
                String optString3 = jSONObject.optString("imgUrl");
                String pr = l.pr(jVar.mAppId);
                String str4 = appBrandSysConfig.iOg;
                x.i("MicroMsg.JsApiShareTimeline", "doSendMessage, title = %s, description = %s ,username = %s , path = %s ,thumbIconUrl = %s", new Object[]{optString2, str, str3, optString, optString3});
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s]", new Object[]{pr});
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, init intent");
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", pr);
                intent.putExtra("Ksnsupload_title", optString2);
                intent.putExtra("Ksnsupload_contentattribute", 0);
                if (s.eE(optString3, "http://") || s.eE(optString3, "https://")) {
                    intent.putExtra("Ksnsupload_imgurl", optString3);
                } else {
                    Bitmap j = o.j(jVar.irP, optString3);
                    byte[] bArr = new byte[0];
                    if (j == null || j.isRecycled()) {
                        x.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
                    } else {
                        x.i("MicroMsg.JsApiShareTimeline", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        j.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    intent.putExtra("Ksnsupload_imgbuf", bArr);
                }
                intent.putExtra("ksnsis_appbrand", true);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("KsnsUpload_BrandUsername", str3);
                intent.putExtra("KsnsUpload_BrandPath", optString);
                x.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", new Object[]{str2, optString});
                str = u.hz("wxapp_" + str2 + optString);
                u.GK().t(str, true).o("prePublishId", "wxapp_" + str2 + optString);
                intent.putExtra("reportSessionId", str);
                x.i("MicroMsg.JsApiShareTimeline", "doTimeline, start activity");
                if (a instanceof MMActivity) {
                    intent.putExtra("need_result", true);
                    a.jwN = new 1(this, a, str2, optString, jVar, i);
                    d.a(a, "sns", ".ui.SnsUploadUI", intent, 0, false);
                    return;
                }
                return;
            }
            x.i("MicroMsg.JsApiShareTimeline", "data is null");
            jVar.E(i, e("fail", null));
            return;
        }
        jVar.E(i, e("fail", null));
    }

    public static void agL() {
        jqT = true;
    }
}
