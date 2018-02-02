package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.f;
import com.tencent.mm.pluginsdk.model.a$a;
import com.tencent.mm.sdk.platformtools.bh;
import java.net.URLEncoder;

final class j$h extends f {
    private j$h() {
        super((byte) 0);
    }

    protected final void a(Context context, e eVar, e eVar2, String str) {
        if (context == null) {
            super.a(context, eVar, eVar2, str);
            return;
        }
        String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude)});
        if (eVar != null) {
            format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude)});
            if (!bh.ov(eVar.tJV)) {
                format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.tJV)});
            }
        }
        if (bh.ov(str)) {
            if (bh.ov(eVar2.tJV)) {
                str = "地图选点";
            } else {
                str = eVar2.tJV;
            }
        }
        format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
        intent.setPackage(a$a.TencentMap.getPackage());
        context.startActivity(intent);
    }

    protected final String getPackageName() {
        return a$a.TencentMap.getPackage();
    }
}
