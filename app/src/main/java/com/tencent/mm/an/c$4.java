package com.tencent.mm.an;

import android.os.Looper;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bso;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import java.util.ArrayList;
import java.util.LinkedList;

class c$4 implements a {
    final /* synthetic */ c hyF;

    c$4(c cVar) {
        this.hyF = cVar;
    }

    public final boolean uF() {
        if (this.hyF.hyz.isEmpty()) {
            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
            return false;
        }
        boolean z;
        int i;
        int intValue;
        long Wp = bh.Wp();
        int i2 = this.hyF.hkG ? 5 : 15;
        ArrayList arrayList = new ArrayList(i2 * 2);
        int i3 = 0;
        while (i3 < i2) {
            b OY;
            c$a com_tencent_mm_an_c_a = (c$a) this.hyF.hyz.peek();
            if (com_tencent_mm_an_c_a == null) {
                x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                z = false;
            } else {
                LinkedList linkedList = com_tencent_mm_an_c_a.hyL.wkl;
                LinkedList linkedList2 = com_tencent_mm_an_c_a.hyL.wkm;
                i = com_tencent_mm_an_c_a.hyM;
                if (linkedList.size() <= i) {
                    this.hyF.hyz.poll();
                    if (this.hyF.hyz.isEmpty()) {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[]{Integer.valueOf(i), Integer.valueOf(r8)});
                        this.hyF.hyA = 0;
                        this.hyF.hyD.J(0, 0);
                        z = false;
                    } else {
                        x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[]{Integer.valueOf(i), Integer.valueOf(r8)});
                    }
                } else {
                    arp com_tencent_mm_protocal_c_arp = (arp) linkedList.get(i);
                    intValue = ((Integer) linkedList2.get(i)).intValue();
                    String az = bh.az(n.a(com_tencent_mm_protocal_c_arp.vYI), "");
                    String az2 = bh.az(com_tencent_mm_protocal_c_arp.hvy, "");
                    arrayList.add(az);
                    arrayList.add(az2);
                    switch (intValue) {
                        case -477:
                            z = d.OY().ld(az);
                            boolean ld = d.OY().ld(az2);
                            boolean gf = m.gf(az);
                            x.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[]{Integer.valueOf(intValue), az, az2, Boolean.valueOf(z), Boolean.valueOf(ld), Boolean.valueOf(gf)});
                            d.pPH.a(832, 1, 1, false);
                            z = false;
                            break;
                        case 0:
                            String az3;
                            if (com_tencent_mm_an_c_a.hyL.wkn != null && com_tencent_mm_an_c_a.hyL.wkn.size() > i) {
                                if (az.equals(((bso) com_tencent_mm_an_c_a.hyL.wkn.get(i)).username)) {
                                    az3 = bh.az(((bso) com_tencent_mm_an_c_a.hyL.wkn.get(i)).wTR, "");
                                    x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[]{az, az2, az3});
                                    b.ift.a(com_tencent_mm_protocal_c_arp, az3);
                                    d.pPH.a(832, 0, 1, false);
                                    z = true;
                                    break;
                                }
                            }
                            String str = "MicroMsg.GetContactService";
                            String str2 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                            Object[] objArr = new Object[3];
                            if (com_tencent_mm_an_c_a.hyL.wkn == null) {
                                az3 = "null";
                            } else {
                                az3 = Integer.valueOf(com_tencent_mm_an_c_a.hyL.wkn.size());
                            }
                            objArr[0] = az3;
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = az;
                            x.w(str, str2, objArr);
                            az3 = "";
                            x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[]{az, az2, az3});
                            b.ift.a(com_tencent_mm_protocal_c_arp, az3);
                            d.pPH.a(832, 0, 1, false);
                            z = true;
                        default:
                            z = m.gf(az);
                            x.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[]{Integer.valueOf(intValue), az, az2, Boolean.valueOf(z)});
                            d.pPH.a(832, 2, 1, false);
                            z = false;
                            break;
                    }
                    new af(Looper.getMainLooper()).post(new 1(this, az, az2, z));
                    com_tencent_mm_an_c_a.hyM++;
                }
                i3++;
            }
            i = arrayList.size();
            if (i > 0) {
                ar.Hg();
                long dz = c.EV().dz(Thread.currentThread().getId());
                OY = d.OY();
                for (intValue = 0; intValue < i; intValue++) {
                    OY.ld((String) arrayList.get(intValue));
                }
                ar.Hg();
                c.EV().fS(dz);
            }
            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.hyF.hkG + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (bh.Wp() - Wp) + "ms");
            return z;
        }
        z = true;
        i = arrayList.size();
        if (i > 0) {
            ar.Hg();
            long dz2 = c.EV().dz(Thread.currentThread().getId());
            OY = d.OY();
            for (intValue = 0; intValue < i; intValue++) {
                OY.ld((String) arrayList.get(intValue));
            }
            ar.Hg();
            c.EV().fS(dz2);
        }
        x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.hyF.hkG + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (bh.Wp() - Wp) + "ms");
        return z;
    }
}
