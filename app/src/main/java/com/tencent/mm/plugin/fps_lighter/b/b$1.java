package com.tencent.mm.plugin.fps_lighter.b;

import android.util.Pair;
import com.tencent.mm.plugin.fps_lighter.c.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.g.AnonymousClass7;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimerTask;

class b$1 extends TimerTask {
    final /* synthetic */ b mAD;

    b$1(b bVar) {
        this.mAD = bVar;
    }

    public final void run() {
        x.i("MicroMsg.FPSAnalyser", "begin report analyse result!");
        synchronized (this.mAD.mAC) {
            b bVar = this.mAD;
            x.i("MicroMsg.FPSAnalyser", "[report] size:%s", Integer.valueOf(bVar.mAC.size()));
            List arrayList = new ArrayList(100);
            for (Entry value : bVar.mAC.entrySet()) {
                LinkedList linkedList = (LinkedList) value.getValue();
                x.d("MicroMsg.FPSAnalyser", "[report] results size:%s key:%s", Integer.valueOf(linkedList.size()), ((Entry) r5.next()).getKey());
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.mBC.mBo) {
                        x.w("MicroMsg.FPSAnalyser.report", dVar.toString());
                    } else {
                        Map hashMap = new HashMap();
                        hashMap.put("scene", Integer.valueOf(dVar.mBC.scene));
                        hashMap.put("maskTimeStamp", Long.valueOf(dVar.mBC.mBn));
                        hashMap.put("dropCount", Integer.valueOf(dVar.mBC.mBp));
                        hashMap.put("dropTime", Long.valueOf(dVar.mBC.aKP()));
                        hashMap.put("cpu", dVar.mBC.mBq + "%");
                        hashMap.put("methodId", Long.valueOf(dVar.mBv));
                        hashMap.put("costTime", Long.valueOf(dVar.mBB));
                        hashMap.put("percent", Math.round(((((double) dVar.mBB) * 1.0d) / ((double) dVar.mBC.aKP())) * 100.0d) + "%");
                        hashMap.put("exec num", Integer.valueOf(dVar.hTi));
                        hashMap.put("rawCostTime", Long.valueOf(dVar.mBs));
                        hashMap.put("isDrawing", Boolean.valueOf(dVar.mBt));
                        hashMap.put("revision", e.REV);
                        x.i("MicroMsg.FPSAnalyser.report", dVar.toString());
                        arrayList.add(new Pair(dVar.aKR(), hashMap));
                    }
                }
            }
            g gVar = g.pQN;
            gVar.a("fps", new AnonymousClass7(gVar, arrayList));
            bVar.mAC.clear();
        }
    }
}
