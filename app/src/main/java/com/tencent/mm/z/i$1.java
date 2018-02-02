package com.tencent.mm.z;

import android.database.Cursor;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba.a;

class i$1 implements Runnable {
    final /* synthetic */ String gIx;
    final /* synthetic */ long hfa;
    final /* synthetic */ a hfb;

    i$1(String str, long j, a aVar) {
        this.gIx = str;
        this.hfa = j;
        this.hfb = aVar;
    }

    public final void run() {
        Cursor an = ((o) g.h(o.class)).Fb().an(this.gIx, this.hfa);
        if (an.moveToFirst()) {
            while (!an.isAfterLast() && (this.hfb == null || !this.hfb.HB())) {
                au auVar = new au();
                auVar.b(an);
                ba.j(auVar);
                an.moveToNext();
            }
        }
        an.close();
        ((o) g.h(o.class)).Fb().am(this.gIx, this.hfa);
        ag.y(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|deleteMsgByTalker";
    }
}
