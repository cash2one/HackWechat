package com.tencent.mm.aq;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.l.b;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class i implements e, f {
    private static Set<Integer> hAY = new HashSet();
    private Queue<e> flN = new LinkedList();
    private boolean flR = false;
    private boolean flS = false;
    int flT = 0;
    private long flU = 0;
    com.tencent.mm.compatible.util.g.a flX = new com.tencent.mm.compatible.util.g.a();
    private ak flY;
    private LinkedList<l> hAZ = new LinkedList();
    public a hBa = null;
    private boolean hBb = false;
    private com.tencent.mm.aq.l.a hBc = new 1(this);

    public interface a {
        void b(long j, int i, int i2);

        void f(long j, boolean z);
    }

    static /* synthetic */ void e(i iVar) {
        e eVar;
        iVar.flU = System.currentTimeMillis();
        if (!iVar.flR && iVar.flN.size() == 0) {
            g Pw = o.Pw();
            Cursor a = Pw.hhp.a(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null, 0);
            int count = a.getCount();
            x.d("MicroMsg.ImgInfoStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                a.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    a.moveToPosition(i);
                    e eVar2 = new e();
                    eVar2.b(a);
                    e hR = Pw.hR((int) eVar2.hzP);
                    if (hR != null) {
                        if (hR.fFo != 0 || hR.hzX != 0) {
                            list.add(eVar2);
                        }
                    } else if (eVar2.fFo != 0 || eVar2.hzX != 0) {
                        list.add(eVar2);
                    }
                }
                a.close();
            }
            if (r0 == null || r0.size() == 0) {
                x.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (e eVar3 : r0) {
                    if (bh.ov(eVar3.hzQ)) {
                        x.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        e hR2 = o.Pw().hR((int) eVar3.hzP);
                        if (hAY.contains(Integer.valueOf(hR2 == null ? (int) eVar3.hzP : (int) hR2.hzP))) {
                            x.d("MicroMsg.ImgService", "File is Already running:" + eVar3.hzP);
                        } else {
                            if (hR2 != null) {
                                if (hR2.hzX > 0) {
                                    if (hR2.fFo <= 0) {
                                        if (eVar3.offset <= eVar3.hlp) {
                                            if (eVar3.status != -1) {
                                                if (hR2.status == -1) {
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (eVar3.hzX > 0 && eVar3.fFo <= 0 && eVar3.offset <= eVar3.hlp && eVar3.status != -1) {
                            }
                            if (((long) (eVar3.hzW + 600)) < bh.Wo()) {
                                hU((int) eVar3.hzP);
                            } else {
                                iVar.flN.add(eVar3);
                            }
                        }
                    }
                }
                iVar.flN.size();
            }
        }
        if (iVar.flR || iVar.flN.size() > 0) {
            eVar3 = null;
            if (!iVar.flR && iVar.flN.size() > 0) {
                e hR3;
                while (iVar.flN.size() > 0) {
                    eVar3 = (e) iVar.flN.poll();
                    hR3 = o.Pw().hR((int) eVar3.hzP);
                    if (hAY.contains(Integer.valueOf(hR3 == null ? (int) eVar3.hzP : (int) hR3.hzP))) {
                        eVar3 = null;
                    }
                }
                iVar.flR = true;
                if (eVar3 != null && eVar3.hzP > 0) {
                    k lVar;
                    hR3 = o.Pw().hR((int) eVar3.hzP);
                    if (hR3 != null) {
                        x.d("MicroMsg.ImgService", "try upload hdinfo ");
                        lVar = new l((int) hR3.hzP, 1);
                    } else {
                        x.d("MicroMsg.ImgService", "try upload normalinfo ");
                        lVar = new l((int) eVar3.hzP, 0);
                    }
                    g.Di().gPJ.a(lVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.vB();
        x.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
    }

    public static boolean hS(int i) {
        return hAY.add(Integer.valueOf(i));
    }

    public static boolean hT(int i) {
        return hAY.remove(Integer.valueOf(i));
    }

    public i() {
        g.Dk();
        this.flY = new ak(g.Dm().oAt.getLooper(), new 5(this), false);
        if (g.Di().gPJ != null) {
            g.Di().gPJ.a(110, this);
        }
        this.hAZ.clear();
        this.hBb = false;
    }

    public final void a(String str, String str2, ArrayList<String> arrayList, int i, boolean z, int i2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            x.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(q.a(str3, str2, z) ? 1 : 0)});
            a(new l(3, str, str2, str3, r6, this, i, this.hBc, i2));
        }
    }

    public final void a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z, int i2) {
        Iterator it = arrayList2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            int i4 = i3 + 1;
            int i5 = q.a(str3, str2, z) ? 1 : 0;
            String str4 = "";
            e hQ = o.Pw().hQ(intValue);
            if (hQ != null) {
                str4 = hQ.hAa;
            }
            l lVar = new l((long) intValue, 3, str, str2, str3, i5, (f) this, i, str4, "", i2);
            lVar.hBI = new b(lVar, this.hBc);
            a(lVar);
            i3 = i4;
        }
    }

    private void a(l lVar) {
        g.Dk();
        g.Dm().F(new 2(this, lVar));
    }

    public static void hU(int i) {
        x.w("MicroMsg.ImgService", "setImgError, %d", new Object[]{Integer.valueOf(i)});
        e hQ = o.Pw().hQ(i);
        if (hQ != null && hQ.hzP > 0) {
            cf dH;
            e hR = o.Pw().hR((int) hQ.hzP);
            if (hR != null) {
                hR.eQ(-1);
                hR.fDt = 264;
                o.Pw().a((int) hR.hzP, hR);
                dH = ((h) g.h(h.class)).aZi().dH(hR.hzX);
            } else {
                hQ.eQ(-1);
                hQ.fDt = 264;
                o.Pw().a(i, hQ);
                dH = ((h) g.h(h.class)).aZi().dH(hQ.hzX);
            }
            if (dH.field_msgId == hQ.hzX) {
                dH.eQ(5);
                d.pPH.a(111, 31, 1, true);
                ((h) g.h(h.class)).aZi().a((long) ((int) dH.field_msgId), dH);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof l) {
            l lVar = (l) kVar;
            if (!(this.hBa == null || lVar == null || lVar.fnB == null)) {
                this.hBa.f(lVar.fnB.field_msgId, lVar.fnB.field_status != 5);
            }
        }
        g.Dk();
        g.Dm().F(new 3(this, kVar));
    }

    private void vB() {
        this.flN.clear();
        this.flS = false;
        x.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.flX.zi());
    }

    public final void run() {
        g.Dk();
        g.Dm().F(new 4(this));
    }

    public final void a(int i, int i2, k kVar) {
        l lVar = (l) kVar;
        if (this.hBa != null && lVar != null && lVar.fnB != null) {
            this.hBa.b(lVar.fnB.field_msgId, i, i2);
        }
    }
}
