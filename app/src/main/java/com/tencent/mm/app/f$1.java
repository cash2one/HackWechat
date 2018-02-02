package com.tencent.mm.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.blink.c;
import com.tencent.mm.cd.j;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kiss.a.a;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

class f$1 implements Runnable {
    final /* synthetic */ g ffa;
    final /* synthetic */ f ffb;

    f$1(f fVar, g gVar) {
        this.ffb = fVar;
        this.ffa = gVar;
    }

    public final void run() {
        try {
            j a = f.a(this.ffb);
            synchronized (a.gOg) {
                a.gOg[0] = (byte) -1;
                com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[]{a});
            }
            f.a(this.ffb).done();
            Context contextWrapper = new ContextWrapper(this.ffa.gSI);
            b DY = b.DY();
            Looper looper = a.DX().gSR.getLooper();
            LayoutInflater fv = v.fv(contextWrapper);
            if (!DY.gSX) {
                DY.gSX = true;
                DY.DF = fv;
                DY.gSV = looper;
                DY.mMode = 2;
                DY.gSW = new 1(DY, DY.gSV);
            }
            com.tencent.mm.blink.a.wh();
            Context baseContext = ((h) com.tencent.mm.kernel.g.Dg().CN()).gSI.getBaseContext();
            boolean a2 = b.DY().a("R.layout.actionbar_title_launcher", 1, R.i.cZX, new LinearLayout(baseContext), new int[0]);
            b.DY().a("R.layout.main_tab", 1, R.i.dmV, new int[0]);
            if (com.tencent.mm.bv.a.ey(baseContext)) {
                b.DY().a("R.layout.mm_bottom_tabitem_large", 4, R.i.dnr, new LinearLayout(baseContext), new int[0]);
            } else {
                b.DY().a("R.layout.mm_bottom_tabitem", 4, R.i.dnq, new LinearLayout(baseContext), new int[0]);
            }
            b.DY().a("R.layout.mm_activity", 4, R.i.dnk, new int[0]);
            if (!(Build.BRAND.equals("vivo") && d.fN(20))) {
                b.DY().a("R.layout.main", 1, R.i.cuK, new int[0]);
                b.DY().a("R.layout.address", 1, R.i.daa, new int[0]);
                b.DY().a("R.layout.mm_preference_fragment_list_content", 2, R.i.dnT, new int[0]);
            }
            b.DY().a("R.layout.actionview_with_dot_tips", 1, R.i.cZY, new int[0]);
            if (com.tencent.mm.bv.a.ey(baseContext)) {
                b.DY().a("R.layout.conversation_item_with_cache_large", 8, R.i.dfe, null);
            } else if (com.tencent.mm.bv.a.ez(baseContext)) {
                b.DY().a("R.layout.conversation_item_with_cache_small", 8, R.i.dff, null);
            } else {
                b.DY().a("R.layout.conversation_item_with_cache", 8, R.i.dfd, null);
            }
            if (a2) {
                b DY2 = b.DY();
                DY2.gSW.post(new c.1());
            }
            f.a(this.ffb).done();
        } catch (Throwable e) {
            try {
                x.printErrStackTrace("MicroMsg.DefaultBootStep", e, "", new Object[0]);
                com.tencent.mm.blink.a.j(10, 1);
                x.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[]{ac.getResources(), this.ffa.gSI.getResources(), this.ffa.gSI.getResources().getAssets()});
                f.a(this.ffb, this.ffa);
                f.b(this.ffb);
            } finally {
                f.a(this.ffb).done();
            }
        }
    }
}
