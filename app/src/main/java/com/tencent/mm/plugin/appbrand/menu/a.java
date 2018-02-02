package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;

public final class a extends com.tencent.mm.plugin.appbrand.menu.a.a {
    public a() {
        super(m.jAQ - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        CharSequence charSequence;
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        int i = m.jAQ - 1;
        String str2 = appBrandSysConfig.frn;
        int i2 = appBrandSysConfig.iOI.iGK;
        boolean z = pVar.jDZ;
        CharSequence string = context.getString(j.dDP, new Object[]{str2});
        str2 = com.tencent.mm.plugin.appbrand.appcache.a.ju(i2);
        if (bh.ov(str2)) {
            charSequence = string;
        } else {
            int c;
            int parseColor = Color.parseColor("#42000000");
            i2 = com.tencent.mm.bv.a.c(context, d.isB);
            if (z) {
                parseColor = Color.parseColor("#80FFFFFF");
                c = com.tencent.mm.bv.a.c(context, d.buj);
            } else {
                c = i2;
            }
            b bVar = new b(str2, com.tencent.mm.bv.a.fromDPToPix(context, 11), com.tencent.mm.bv.a.fromDPToPix(context, 11), com.tencent.mm.bv.a.fromDPToPix(context, 9), parseColor, com.tencent.mm.bv.a.fromDPToPix(context, 2));
            int a = bVar.a(null);
            int[] akV = com.tencent.mm.plugin.appbrand.ui.j.akV();
            int aa = com.tencent.mm.bv.a.aa(context, e.isW);
            TextPaint textPaint = new TextPaint(new Paint(c));
            textPaint.setTextSize((float) aa);
            CharSequence ellipsize = TextUtils.ellipsize(string, textPaint, (float) ((akV[0] - com.tencent.mm.bv.a.aa(context, e.isV)) - a), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize + str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(aa, false), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(bVar, ellipsize.length(), spannableStringBuilder.length(), 18);
            Object obj = spannableStringBuilder;
        }
        nVar.f(i, charSequence);
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig != null) {
            String str2 = "";
            if (com.tencent.mm.plugin.appbrand.a.oT(str) != null) {
                str2 = bh.ou(h.e(pVar.irP).irG);
            }
            com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.agE();
            WxaExposedParams$a wxaExposedParams$a = new WxaExposedParams$a();
            wxaExposedParams$a.appId = appBrandSysConfig.appId;
            wxaExposedParams$a.fqe = 3;
            wxaExposedParams$a.fCp = pVar.jDS == null ? "" : pVar.jDS.iZW;
            wxaExposedParams$a.iGK = appBrandSysConfig.iOI.iGK;
            wxaExposedParams$a.iGL = appBrandSysConfig.iOI.iGL;
            AppBrandProfileUI.a(context, appBrandSysConfig.fnl, str2, wxaExposedParams$a.ace());
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 6, "", bh.Wo(), 1, 0);
        }
    }
}
