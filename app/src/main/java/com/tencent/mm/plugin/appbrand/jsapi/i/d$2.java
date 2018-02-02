package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

class d$2 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ String icx;
    final /* synthetic */ p jfB;
    final /* synthetic */ d jqg;
    final /* synthetic */ boolean jqh;
    final /* synthetic */ int jqi;
    final /* synthetic */ boolean jqj;
    final /* synthetic */ String jqk;
    final /* synthetic */ String jql;

    d$2(d dVar, p pVar, boolean z, j jVar, int i, int i2, boolean z2, String str, String str2, String str3) {
        this.jqg = dVar;
        this.jfB = pVar;
        this.jqh = z;
        this.iZy = jVar;
        this.jqi = i;
        this.gOK = i2;
        this.jqj = z2;
        this.jqk = str;
        this.jql = str2;
        this.icx = str3;
    }

    public final void run() {
        l bS;
        if (this.jqg.jqe != null) {
            d.bH(this.jqg.jqe);
            this.jqg.jqe = null;
            bS = l.bS(this.jfB.aeM());
            if (bS != null) {
                bS.a(this.jqg.jqf);
            }
            if (this.jqg.iZb != null) {
                this.jqg.iZb.TG();
            }
        }
        if (this.jqh) {
            this.jqg.jqe = LayoutInflater.from(this.jfB.mContext).inflate(h.ixn, null);
        } else {
            this.jqg.jqe = LayoutInflater.from(this.jfB.mContext).inflate(h.ixo, null);
        }
        bS = l.bS(this.jfB.aeM());
        if (bS == null) {
            x.e("MicroMsg.JsApiShowToast", "the page may be destroy");
            return;
        }
        View view = bS.jXB;
        if (view != null && view.isShown()) {
            ((LinearLayout) this.jqg.jqe).setGravity(80);
        }
        u.GK().t(this.iZy.hashCode() + "toast_name", true).o("toast_view", this.jqg.jqe);
        if (this.jqj) {
            this.jqg.jqe.setLayoutParams(new LayoutParams(-1, -1));
            ((LinearLayout) this.jqg.jqe.findViewById(g.iwt)).setBackgroundColor(0);
            this.jqg.jqe.setOnTouchListener(new 2(this));
        }
        TextView textView = (TextView) this.jqg.jqe.findViewById(g.title);
        int fromDPToPix = a.fromDPToPix(textView.getContext(), 18);
        if (bh.ov(this.icx)) {
            textView.setVisibility(4);
        } else {
            textView.setLineSpacing(0.0f, 1.0f);
            textView.setSpannableFactory(new 3(this, fromDPToPix));
            textView.setText(this.icx, BufferType.SPANNABLE);
            textView.setVisibility(0);
            if (!this.jqh) {
                this.jqg.jqe.findViewById(g.iwu).setPadding(0, a.fromDPToPix(textView.getContext(), 27), 0, 0);
            }
        }
        if (!this.jqh) {
            ImageView imageView = (ImageView) this.jqg.jqe.findViewById(g.ivQ);
            ProgressBar progressBar = (ProgressBar) this.jqg.jqe.findViewById(g.progress);
            if (this.jqk.equals("loading")) {
                imageView.setVisibility(8);
                progressBar.setVisibility(0);
            } else {
                Drawable c;
                imageView.setVisibility(0);
                progressBar.setVisibility(8);
                if (bh.ov(this.jql)) {
                    c = com.tencent.mm.svg.a.a.c(imageView.getResources(), i.ixY);
                } else {
                    Bitmap j = o.j(this.iZy.irP, this.jql);
                    c = (j == null || j.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), j);
                }
                if (c != null) {
                    imageView.setImageDrawable(c);
                    imageView.setScaleType(ScaleType.FIT_CENTER);
                }
            }
        }
        this.jfB.aeM().addView(this.jqg.jqe);
        this.jqg.iZb = new ak(new 1(this), false);
        long j2 = (long) this.jqi;
        this.jqg.iZb.J(j2, j2);
        this.iZy.E(this.gOK, this.jqg.e("ok", null));
    }
}
