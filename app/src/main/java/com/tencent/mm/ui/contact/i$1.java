package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ag.e.a.b;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class i$1 implements Runnable {
    final /* synthetic */ i ySu;
    final /* synthetic */ b yyT;

    i$1(i iVar, b bVar) {
        this.ySu = iVar;
        this.yyT = bVar;
    }

    public final void run() {
        ar.Hg();
        af WO = c.EY().WO(this.yyT.hog);
        if (i.a(this.ySu) == null || i.a(this.ySu).size() <= 0 || !i.a(this.ySu).contains(this.yyT.hog)) {
            if (WO != null && ((int) WO.gJd) > 0 && a.fZ(WO.field_type)) {
                if (i.a(this.ySu) != null) {
                    i.a(this.ySu).clear();
                }
                if (i.b(this.ySu) != null) {
                    i.b(this.ySu).clear();
                }
                if (i.c(this.ySu) != null) {
                    i.c(this.ySu).removeAllViews();
                }
                i.e(this.ySu);
                if (i.d(this.ySu) != null) {
                    i.d(this.ySu).Gl(i.a(this.ySu).size());
                }
            }
        } else if (WO == null || ((int) WO.gJd) <= 0 || !a.fZ(WO.field_type)) {
            x.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", new Object[]{this.yyT.hog});
            i.a(this.ySu).remove(this.yyT.hog);
            if (i.a(this.ySu).size() > 0) {
                View view = (View) i.b(this.ySu).get(this.yyT.hog);
                if (view != null && i.c(this.ySu) != null) {
                    i.c(this.ySu).removeView(view);
                    i.b(this.ySu).remove(view);
                }
            } else if (i.d(this.ySu) != null) {
                if (i.b(this.ySu) != null) {
                    i.b(this.ySu).clear();
                }
                if (i.c(this.ySu) != null) {
                    i.c(this.ySu).removeAllViews();
                }
                i.d(this.ySu).Gl(i.a(this.ySu).size());
            }
        }
    }
}
