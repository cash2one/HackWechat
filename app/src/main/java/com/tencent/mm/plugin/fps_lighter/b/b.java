package com.tencent.mm.plugin.fps_lighter.b;

import android.os.Looper;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.plugin.fps_lighter.d.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class b implements a {
    boolean isInit = false;
    Timer jwk = new Timer();
    HashMap<String, LinkedList<d>> mAC = new HashMap();

    public final void K(LinkedList<d> linkedList) {
        synchronized (this.mAC) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                x.i("MicroMsg.FPSAnalyser.result", dVar.toString());
                String aKR = dVar.aKR();
                if (!this.mAC.containsKey(aKR)) {
                    this.mAC.put(aKR, new LinkedList());
                }
                ((LinkedList) this.mAC.get(aKR)).add(dVar);
            }
        }
        linkedList.clear();
        new af(Looper.getMainLooper()).post(new 2(this));
    }
}
