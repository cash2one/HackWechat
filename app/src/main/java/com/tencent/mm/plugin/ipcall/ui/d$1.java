package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.as.a;
import java.lang.ref.WeakReference;

class d$1 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ String gIn;
    final /* synthetic */ ImageView jlT;
    private boolean nIe = false;
    final /* synthetic */ String nIf;
    final /* synthetic */ d nIg;

    d$1(d dVar, String str, String str2, ImageView imageView, String str3) {
        this.nIg = dVar;
        this.nIf = str;
        this.gIn = str2;
        this.jlT = imageView;
        this.gIT = str3;
    }

    public final boolean JB() {
        Bitmap an = com.tencent.mm.plugin.ipcall.b.a.an(this.nIg.context, this.nIf);
        if (an != null) {
            this.nIg.nId.put(this.gIn, new WeakReference(an));
            this.nIe = true;
            d.a(this.nIg, this.jlT, this.gIn, an);
        }
        return true;
    }

    public final boolean JC() {
        if (!this.nIe) {
            d dVar = this.nIg;
            String str = this.nIf;
            String str2 = this.gIT;
            dVar.nIc.c(new d$2(dVar, str2, this.jlT, d.cX(str, str2)));
        }
        return true;
    }
}
