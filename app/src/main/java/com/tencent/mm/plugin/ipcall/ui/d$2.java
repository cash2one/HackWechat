package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.as.a;

class d$2 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ String gIn;
    final /* synthetic */ ImageView jlT;
    final /* synthetic */ d nIg;

    d$2(d dVar, String str, ImageView imageView, String str2) {
        this.nIg = dVar;
        this.gIT = str;
        this.jlT = imageView;
        this.gIn = str2;
    }

    public final boolean JB() {
        Bitmap a = b.a(this.gIT, false, -1);
        if (a == null) {
            n.Jz();
            a = d.jd(this.gIT);
        }
        d.a(this.nIg, this.jlT, this.gIn, a);
        return true;
    }

    public final boolean JC() {
        return false;
    }
}
