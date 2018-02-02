package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import junit.framework.Assert;

class g$1 implements a {
    final /* synthetic */ g hFp;

    g$1(g gVar) {
        this.hFp = gVar;
    }

    public final boolean uF() {
        float f = 1.0f;
        if (!g.Dh().Cy() || com.tencent.mm.kernel.a.Cs()) {
            x.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
            return false;
        } else if (this.hFp.hEW) {
            x.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[]{Integer.valueOf(this.hFp.hashCode())});
            return false;
        } else if (this.hFp.hyz.isEmpty()) {
            x.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
            return false;
        } else {
            boolean z;
            x.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[]{Integer.valueOf(this.hFp.hashCode()), Long.valueOf(this.hFp.hEZ.zi()), Integer.valueOf(this.hFp.hyz.size()), Integer.valueOf(this.hFp.hFl), Boolean.valueOf(this.hFp.hFm), Integer.valueOf(this.hFp.hFo), Integer.valueOf(this.hFp.hFn)});
            g.Dk();
            long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
            c cVar = new c();
            cVar.bv("NetSceneInit");
            int i = this.hFp.hFm ? 40 : 10;
            int i2 = 0;
            while (i2 < i) {
                g$a com_tencent_mm_modelmulti_g_a = (g$a) this.hFp.hyz.peek();
                if (com_tencent_mm_modelmulti_g_a.hFt != Integer.MAX_VALUE) {
                    LinkedList linkedList = com_tencent_mm_modelmulti_g_a.hFs.wAT;
                    if (linkedList != null && linkedList.size() > com_tencent_mm_modelmulti_g_a.hyM) {
                        linkedList.size();
                        if (cVar.a((ol) linkedList.get(com_tencent_mm_modelmulti_g_a.hyM), true)) {
                            com_tencent_mm_modelmulti_g_a.hyM++;
                            g gVar = this.hFp;
                            gVar.hFo++;
                            i2++;
                        }
                    }
                    this.hFp.hyz.poll();
                    g.Dk();
                    g.Dj().CU().set(8197, bh.by(n.a(com_tencent_mm_modelmulti_g_a.hFs.wAP)));
                    g.Dk();
                    g.Dj().CU().set(8198, bh.by(n.a(com_tencent_mm_modelmulti_g_a.hFs.wAQ)));
                    g.Dk();
                    g.Dj().CU().set(16, Integer.valueOf(0));
                    g.Dk();
                    g.Dj().CU().set(8196, Long.valueOf((long) com_tencent_mm_modelmulti_g_a.hFs.wAR));
                    g.Dk();
                    g.Dj().CU().lH(true);
                    z = true;
                    break;
                }
                boolean z2;
                String str = "in Queue tail , resp should be null";
                if (com_tencent_mm_modelmulti_g_a.hFs == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assert.assertTrue(str, z2);
                g.Dk();
                String str2 = (String) g.Dj().CU().get(8198, null);
                g.Dk();
                g.Dj().CU().set(8195, str2);
                ac.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", str2).commit();
                g.Dk();
                g.Dj().CU().set(8197, "");
                g.Dk();
                g.Dj().CU().set(8198, "");
                g.Dk();
                g.Dj().CU().set(15, Integer.valueOf(1));
                g.Dk();
                g.Dj().CU().lH(true);
                x.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[]{Integer.valueOf(this.hFp.hashCode()), Long.valueOf(this.hFp.hEZ.zi()), Integer.valueOf(this.hFp.hFl), Integer.valueOf(this.hFp.hFn), Integer.valueOf(com_tencent_mm_modelmulti_g_a.errType), Integer.valueOf(com_tencent_mm_modelmulti_g_a.errCode)});
                g.Dm().F(new 1(this, com_tencent_mm_modelmulti_g_a));
                z = false;
            }
            z = true;
            cVar.bw("NetSceneInit");
            g.Dk();
            g.Dj().gQj.fS(dz);
            k kVar = this.hFp;
            if (kVar.hBj == null) {
                x.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
            } else {
                int i3 = kVar.hFl > 50 ? 50 : kVar.hFl;
                if (kVar.hFm) {
                    float f2 = ((float) kVar.hFo) / ((float) kVar.hFn);
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    float f3 = f2;
                    i = (int) ((((float) (100 - i3)) * f2) + ((float) i3));
                    f = f3;
                } else {
                    i = i3;
                }
                x.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[]{Integer.valueOf(kVar.hFo), Integer.valueOf(kVar.hFn), Float.valueOf(f), Integer.valueOf(i3)});
                kVar.hBj.a(i, 100, kVar);
            }
            return z;
        }
    }
}
