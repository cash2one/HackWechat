package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import com.tencent.mm.plugin.fps_lighter.b.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class a$1 implements Runnable {
    final /* synthetic */ boolean mAA;
    final /* synthetic */ a mAB;
    final /* synthetic */ Activity oZ;

    a$1(a aVar, boolean z, Activity activity) {
        this.mAB = aVar;
        this.mAA = z;
        this.oZ = activity;
    }

    public final void run() {
        if (this.mAA) {
            x.i("MicroMsg.BaseFrameBeatCore", "went foreground");
            Iterator it = a.a(this.mAB).iterator();
            while (it.hasNext()) {
                try {
                    ((a) it.next()).q(this.oZ);
                } catch (Exception e) {
                    x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                }
            }
            return;
        }
        x.i("MicroMsg.BaseFrameBeatCore", "still foreground");
    }
}
