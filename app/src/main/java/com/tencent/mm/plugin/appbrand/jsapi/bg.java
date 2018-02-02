package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.Closeable;
import java.io.InputStream;
import org.json.JSONObject;

public final class bg extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarItem";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("index");
            String optString = jSONObject.optString("text", "");
            String optString2 = jSONObject.optString("iconPath", "");
            String optString3 = jSONObject.optString("selectedIconPath", "");
            l aiT = jVar.irP.iqC.aiT();
            if (aiT instanceof e) {
                Closeable d = ah.d(jVar.irP, optString2);
                Bitmap decodeStream = BitmapFactory.decodeStream(d);
                if (d != null) {
                    bh.d(d);
                }
                InputStream d2 = ah.d(jVar.irP, optString3);
                Bitmap decodeStream2 = BitmapFactory.decodeStream(d2);
                if (d2 != null) {
                    bh.d(d);
                }
                c cVar = ((e) aiT).jCV;
                if (i2 < cVar.jUz.size()) {
                    c$a com_tencent_mm_plugin_appbrand_widget_c_a = (c$a) cVar.jUz.get(i2);
                    com_tencent_mm_plugin_appbrand_widget_c_a.jUJ = optString;
                    if (decodeStream == null) {
                        decodeStream = com_tencent_mm_plugin_appbrand_widget_c_a.uX;
                    }
                    com_tencent_mm_plugin_appbrand_widget_c_a.uX = decodeStream;
                    if (decodeStream2 == null) {
                        decodeStream = com_tencent_mm_plugin_appbrand_widget_c_a.jUI;
                    } else {
                        decodeStream = decodeStream2;
                    }
                    com_tencent_mm_plugin_appbrand_widget_c_a.jUI = decodeStream;
                    cVar.amg();
                }
                jVar.E(i, e("ok", null));
                return;
            }
            jVar.E(i, e("fail:not TabBar page", null));
        } catch (Exception e) {
            jVar.E(i, e("fail", null));
        }
    }
}
