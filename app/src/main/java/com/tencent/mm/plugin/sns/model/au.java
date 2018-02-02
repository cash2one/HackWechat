package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class au implements f {
    private static HashMap<String, b> qXM = new HashMap();
    private static HashMap<String, WeakReference<b>> qXN = new HashMap();

    public static void Kv(String str) {
        if (r.idT) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) qXN.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.nxv = true;
            }
        }
    }

    public static void Kw(String str) {
        if (r.idT) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) qXN.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null && bVar != null && bVar.qXO == -1) {
                HashMap hashMap = bVar.qXS;
                if (hashMap != null && hashMap.containsKey(str)) {
                    a aVar = (a) hashMap.get(str);
                    if (aVar != null && aVar.qXO == -1) {
                        aVar.qXO = 1;
                        bVar.qXR++;
                    }
                }
            }
        }
    }

    public static void Kx(String str) {
        x.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[]{str});
        if (qXM.containsKey(str)) {
            x.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[]{str});
            b bVar = (b) qXM.get(str);
            if (bVar != null && bVar.qXO == -1 && bVar.startTime != -1) {
                bVar.qXO = 1;
                bVar.qXR = bVar.het;
                bVar.endTime = System.currentTimeMillis();
                bVar.qXQ = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.qXS.values()) {
                    aVar.qXO = 1;
                }
            }
        }
    }

    public final void a(String str, bnp com_tencent_mm_protocal_c_bnp) {
        if (!qXM.containsKey(str)) {
            if (r.idT) {
                x.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[]{str});
            }
            if (com_tencent_mm_protocal_c_bnp != null && com_tencent_mm_protocal_c_bnp.wQo != null && com_tencent_mm_protocal_c_bnp.wQo.vYc == 1 && com_tencent_mm_protocal_c_bnp.wQo.vYd != null && com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                b bVar = new b(this);
                bVar.het = com_tencent_mm_protocal_c_bnp.wQo.vYd.size();
                bVar.qXR = 0;
                bVar.qXS = new HashMap();
                Iterator it = com_tencent_mm_protocal_c_bnp.wQo.vYd.iterator();
                while (it.hasNext()) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) it.next();
                    a aVar = new a(this);
                    aVar.mediaId = com_tencent_mm_protocal_c_aqr.nGJ;
                    bVar.qXS.put(com_tencent_mm_protocal_c_aqr.nGJ, aVar);
                    qXN.put(com_tencent_mm_protocal_c_aqr.nGJ, new WeakReference(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                qXM.put(str, bVar);
            } else if (r.idT) {
                x.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
    }

    public final void JY(String str) {
        if (qXM.containsKey(str)) {
            if (r.idT) {
                x.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[]{str});
            }
            b bVar = (b) qXM.get(str);
            if (bVar != null && bVar.startTime != -1 && bVar.qXO == -1) {
                bVar.endTime = System.currentTimeMillis();
                bVar.qXQ = bVar.endTime - bVar.startTime;
                if (bVar.qXR == bVar.het) {
                    bVar.qXO = 1;
                } else {
                    bVar.qXO = 2;
                }
            }
        }
    }

    public final void buI() {
        x.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[]{Integer.valueOf(qXM.size())});
        int bum = i.bum();
        for (String str : qXM.keySet()) {
            b bVar = (b) qXM.get(str);
            if (bVar != null && bVar.nxv) {
                if (bVar.qXQ == -1 || bVar.qXO == -1 || bVar.startTime == -1) {
                    if (bVar.startTime != -1) {
                        bVar.endTime = System.currentTimeMillis();
                        bVar.qXQ = bVar.endTime - bVar.startTime;
                        if (bVar.het == bVar.qXR) {
                            bVar.qXO = 1;
                        } else {
                            bVar.qXO = 2;
                        }
                    }
                }
                x.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[]{Integer.valueOf(bVar.het), Long.valueOf(bVar.qXO), Long.valueOf(bVar.qXQ), Integer.valueOf(bVar.qXR), Integer.valueOf(bum)});
                g.pQN.h(11600, new Object[]{Integer.valueOf(bVar.het), Long.valueOf(bVar.qXO), Long.valueOf(bVar.qXQ), Integer.valueOf(bVar.qXR), Integer.valueOf(bum)});
            }
        }
        qXM.clear();
        qXN.clear();
    }
}
