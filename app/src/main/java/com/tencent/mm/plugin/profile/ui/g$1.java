package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.ay.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

class g$1 implements a {
    final /* synthetic */ boolean kCv;
    final /* synthetic */ o kCw = null;
    final /* synthetic */ r kCx;

    g$1(boolean z, o oVar, r rVar) {
        this.kCv = z;
        this.kCx = rVar;
    }

    public final boolean uF() {
        int i;
        int Gd = q.Gd();
        if (this.kCv) {
            i = Gd & -32769;
        } else {
            i = Gd | WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        ar.Hg();
        c.CU().set(34, Integer.valueOf(i));
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.kCv) {
            g.aaS();
        }
        if (this.kCw != null) {
            this.kCw.a(null, null);
        }
        if (this.kCx != null) {
            this.kCx.dismiss();
        }
        return true;
    }
}
