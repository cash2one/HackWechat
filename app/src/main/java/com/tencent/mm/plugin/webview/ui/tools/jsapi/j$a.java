package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.f;
import com.tencent.mm.pluginsdk.model.a$a;
import com.tencent.mm.sdk.platformtools.x;

final class j$a extends f {
    private j$a() {
        super((byte) 0);
    }

    protected final void a(Context context, e eVar, e eVar2, String str) {
        if (context == null) {
            super.a(context, eVar, eVar2, str);
            return;
        }
        String format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
        if (eVar != null) {
            format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
        }
        x.d("MicroMsg.OpenMapNavigator", "url " + format);
        try {
            context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
        }
    }

    protected final String getPackageName() {
        return a$a.BaiduMap.getPackage();
    }
}
