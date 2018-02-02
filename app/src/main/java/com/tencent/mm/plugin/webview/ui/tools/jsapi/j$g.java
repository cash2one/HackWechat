package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.f;
import com.tencent.mm.pluginsdk.model.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLEncoder;

final class j$g extends f {
    private j$g() {
        super((byte) 0);
    }

    protected final void a(Context context, e eVar, e eVar2, String str) {
        if (context == null) {
            super.a(context, eVar, eVar2, str);
            return;
        }
        String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
        if (eVar != null) {
            format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            if (!bh.ov(eVar.tJV)) {
                format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.tJV)});
            }
        } else {
            format = format + String.format("&from=%s", new Object[]{"我的位置"});
        }
        if (bh.ov(str)) {
            if (bh.ov(eVar2.tJV)) {
                str = "目的地";
            } else {
                str = eVar2.tJV;
            }
        }
        String str2 = "android.intent.action.VIEW";
        Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
        intent.setPackage(a.vdc.getPackage());
        context.startActivity(intent);
    }

    protected final String getPackageName() {
        return a.vdc.getPackage();
    }
}
