package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.performance.b;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;

public final class h extends LinearLayout implements a {
    private final a[] jNa = new a[4];
    private final SparseArray<b> jNb = new SparseArray();
    private final SparseArray<b> jNc = new SparseArray();
    private int jNd;
    public final String mAppId;

    static /* synthetic */ void a(h hVar, int i, String str) {
        Integer num = (Integer) b.jGa.get(i);
        if (num == null) {
            x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData no such performance type: %d", new Object[]{Integer.valueOf(i)});
            return;
        }
        String string = hVar.getContext().getString(num.intValue());
        b bVar = (b) hVar.jNc.get(i);
        if (bVar == null) {
            bVar = new b(hVar, hVar.getContext());
            b.b(bVar, string);
            int i2 = (i / 100) - 1;
            if (i2 >= 4) {
                x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceLabelView group index is invalid.");
                bVar = null;
            } else {
                if (i2 == 3) {
                    hVar.addView(bVar);
                } else {
                    hVar.addView(bVar, hVar.indexOfChild(hVar.jNa[i2 + 1]));
                }
                hVar.jNc.put(i, bVar);
            }
        }
        if (bVar == null) {
            x.e("MicroMsg.AppBrandUIPerformancePanel", "insertPerformanceData label view is null.");
        } else {
            b.a(bVar, str);
        }
    }

    static /* synthetic */ void a(h hVar, String str, String str2) {
        b bVar = (b) hVar.jNb.get(str.hashCode());
        if (bVar == null) {
            bVar = new b(hVar, hVar.getContext());
            b.b(bVar, str);
            hVar.addView(bVar);
            hVar.jNb.put(str.hashCode(), bVar);
        }
        b.a(bVar, str2);
    }

    public h(Context context, String str) {
        super(context);
        this.mAppId = str;
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.bv.a.fromDPToPix(getContext(), 4);
        LayoutParams layoutParams = new FrameLayout.LayoutParams((i * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        akT();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 2);
        View textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(j.iAI));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.bv.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        akU();
        c.ac((Activity) getContext()).a(this);
    }

    private void akT() {
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.a.ci(getContext()) + this.jNd;
            requestLayout();
        }
    }

    private void akU() {
        for (int i = 0; i < 4; i++) {
            View aVar = new a(this, getContext());
            aVar.setText(getContext().getString(b.jFZ[i]));
            this.jNa[i] = aVar;
            addView(aVar);
        }
    }

    public final void N(int i, String str) {
        com.tencent.mm.plugin.appbrand.q.c.runOnUiThread(new 1(this, i, str));
    }

    public final void bC(String str, String str2) {
        com.tencent.mm.plugin.appbrand.q.c.runOnUiThread(new 2(this, str, str2));
    }

    public final void lA(int i) {
        this.jNd = i;
        akT();
    }
}
