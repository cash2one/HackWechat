package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

final class j extends a {
    j() {
        super(m.jAK - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (b.ceK()) {
            nVar.f(this.jAX, context.getString(com.tencent.mm.plugin.appbrand.q.j.iBq));
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void a(Context context, p pVar, String str, l lVar) {
        String str2;
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        Object stringBuilder = new StringBuilder("!PKG_INFO!\n");
        WxaPkgWrappingInfo ZP = v.ZP();
        stringBuilder.append("\n[lib.src] ");
        if (ZP.iGN) {
            stringBuilder.append(y.ZV() ? "local(force)" : "local");
        } else {
            stringBuilder.append("cgi");
        }
        stringBuilder.append("\n[lib.ver] ").append(ZP.iGL);
        if (ZP.iGK != 0) {
            StringBuilder append = stringBuilder.append("  ");
            if (ZP.iGK == 0) {
                str2 = "";
            } else {
                str2 = bh.fJ(ZP.iGM);
            }
            append.append(str2);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = appBrandSysConfig.iOI;
        stringBuilder.append('\n');
        stringBuilder.append("\n[app.version] ").append(wxaPkgWrappingInfo.iGL);
        if (appBrandSysConfig.iOI.iGK != 0) {
            stringBuilder.append("  ").append(bh.fJ(wxaPkgWrappingInfo.iGM));
        }
        boolean z = !bh.cA(wxaPkgWrappingInfo.iGO);
        stringBuilder.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            str2 = pVar.irP.iqP.pt(pVar.getURL());
            stringBuilder.append(String.format(Locale.US, "  (%s)", new Object[]{str2}));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.bvv);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(context, null, textView, null);
    }
}
