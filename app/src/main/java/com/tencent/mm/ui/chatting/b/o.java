package com.tencent.mm.ui.chatting.b;

import android.graphics.Bitmap;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.gallery.f;
import com.tencent.mm.z.ar;

public final class o implements a, j.a {
    public p fhr;
    public c yAr = new 1(this);
    ak yAs = new ak(new 2(this), false);
    public f yAt = a.yEE;

    public o(p pVar) {
        this.fhr = pVar;
    }

    public final void ctR() {
        this.yAs.TG();
        this.yAs.J(1000, 1000);
    }

    public final void TG() {
        if (ar.Hj()) {
            com.tencent.mm.aq.o.Px().a(this);
        }
        this.yAs.TG();
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        com.tencent.mm.modelcontrol.c.MR();
        if (!com.tencent.mm.modelcontrol.c.MS()) {
            com.tencent.mm.aq.o.Px().a(this);
        }
        boolean z = i3 == 0 && i4 == 0;
        com.tencent.mm.aq.o.Py();
        b.a(j, j2, z);
        ar.Hg();
        this.fhr.csy().a(j2, com.tencent.mm.z.c.Fa().dH(j2), z);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void l(String str, Bitmap bitmap) {
        if (!bh.ov(str) && this.fhr.csx() != null && bitmap != null) {
            this.fhr.css().post(new 3(this));
        }
    }
}
