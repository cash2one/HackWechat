package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q$f;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;

@a(7)
public final class AppBrandGuideUI extends MMActivity implements f {
    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        setTheme(k.iCb);
        super.onCreate(bundle);
        ae.a(getWindow());
        a Zf = com.tencent.mm.plugin.appbrand.app.f.Zf();
        if (Zf == null) {
            super.finish();
            return;
        }
        b.d(this);
        i.a aVar = new i.a(this);
        aVar.Ez(j.dDT);
        View imageView = new ImageView(this);
        imageView.setImageResource(q$f.itd);
        View textView = new TextView(this);
        textView.setText(j.izx);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.bv.a.fromDPToPix(this, 16);
        aVar.dk(linearLayout);
        aVar.a(new 1(this));
        aVar.ED(j.bWk);
        aVar.b(new 2(this));
        aVar.EC(j.izw);
        aVar.a(false, new 3(this));
        aVar.mi(false);
        aVar.mj(true);
        Dialog akx = aVar.akx();
        akx.setOnKeyListener(new 4(this));
        akx.show();
        m.a(m.a.jIO, Zf.jKI);
        Zf.jKH = false;
        Zf.jKI = null;
    }

    protected final void onDestroy() {
        super.onDestroy();
        b.c(this);
    }

    public final void ak(String str, int i) {
        finish();
    }
}
