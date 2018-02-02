package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.statusbar.b;

public final class e extends b implements l {
    private final com.tencent.mm.plugin.appbrand.e irP;
    private final Bitmap jLG;

    static /* synthetic */ void a(e eVar) {
        ProgressBar progressBar = (ProgressBar) eVar.findViewById(g.progress);
        if (progressBar != null && (progressBar.getIndeterminateDrawable() instanceof Animatable)) {
            ((Animatable) progressBar.getIndeterminateDrawable()).stop();
        }
    }

    public e(Context context, com.tencent.mm.plugin.appbrand.e eVar, Bitmap bitmap) {
        super(context);
        this.jLG = bitmap;
        this.irP = eVar;
        boolean Yz = this.irP.Yz();
        Activity cg = j.cg(getContext());
        if (cg != null) {
            Window window = cg.getWindow();
            if (window != null) {
                j.c(window, Yz);
            }
        }
        nn(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(h.ixo, this, false);
        addView(inflate, new LayoutParams(-2, -2, 17));
        ((TextView) inflate.findViewById(g.title)).setText(j.izV);
        inflate.findViewById(g.ivQ).setVisibility(8);
    }

    public final void bA(String str, String str2) {
    }

    public final void akz() {
        post(new 1(this));
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.jLG.recycle();
    }

    public final void akA() {
    }

    public final void a(d dVar) {
    }

    public final View getView() {
        return this;
    }
}
