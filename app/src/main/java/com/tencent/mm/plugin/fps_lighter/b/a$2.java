package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import com.tencent.mm.plugin.fps_lighter.b.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class a$2 implements Runnable {
    final /* synthetic */ a mAB;
    final /* synthetic */ Activity oZ;

    a$2(a aVar, Activity activity) {
        this.mAB = aVar;
        this.oZ = activity;
    }

    public final void run() {
        if (a.b(this.mAB) && a.c(this.mAB)) {
            a.d(this.mAB);
            x.i("MicroMsg.BaseFrameBeatCore", "went background");
            Iterator it = a.a(this.mAB).iterator();
            while (it.hasNext()) {
                try {
                    ((a) it.next()).r(this.oZ);
                } catch (Exception e) {
                    x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                }
            }
            return;
        }
        x.i("MicroMsg.BaseFrameBeatCore", "still foreground");
    }
}
