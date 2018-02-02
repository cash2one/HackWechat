package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.bq.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f {
    private static boolean DEBUG = false;
    private static boolean Vx = false;

    static /* synthetic */ void F(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.WelabUpdater", "No Exp");
            return;
        }
        List arrayList = new ArrayList();
        for (b a : list) {
            a Qy = g.Qy(n.a(a));
            if (Qy != null && Qy.isValid()) {
                arrayList.add(Qy);
                com.tencent.mm.plugin.welab.d.b.bVJ().f(Qy);
                e.o(Qy.field_LabsAppId, 8, com.tencent.mm.plugin.welab.d.b.bVJ().e(Qy));
            }
        }
        x.i("MicroMsg.WelabUpdater", "save exp " + arrayList);
        b.bVu().tPx.ct(arrayList);
    }

    static /* synthetic */ void cs(List list) {
        if (bh.cA(list)) {
            x.w("MicroMsg.WelabUpdater", "No expired Exp");
            return;
        }
        x.i("MicroMsg.WelabUpdater", "expired exp " + list);
        List arrayList = new ArrayList();
        for (Integer num : list) {
            c aVar = new a();
            aVar.field_expId = num.toString();
            b.bVu().tPx.b(aVar, new String[]{"expId"});
            if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                aVar.field_Switch = 3;
                arrayList.add(aVar);
            }
        }
        b.bVu().tPx.ct(arrayList);
    }

    static void M(boolean z, boolean z2) {
        x.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (g.Dh().Cy()) {
            if (!(DEBUG || z || z2)) {
                Object obj;
                Long l = (Long) g.Dj().CU().get(w.a.xvk, null);
                long longValue = l == null ? 0 : l.longValue();
                int intValue;
                if (longValue == 0) {
                    hb(new Random().nextInt(86400));
                    IB();
                    IC();
                    x.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[]{Integer.valueOf(intValue)});
                    obj = 1;
                } else {
                    Integer num = (Integer) g.Dj().CU().get(w.a.xvl, null);
                    intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                    long j = (long) intValue;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = "MicroMsg.WelabUpdater";
                    String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Long.valueOf(j);
                    objArr[3] = Long.valueOf(currentTimeMillis);
                    x.i(str, str2, objArr);
                    obj = currentTimeMillis > longValue + j ? 1 : null;
                }
                if (obj == null) {
                    x.v("MicroMsg.WelabUpdater", "No need to update");
                    return;
                }
            }
            if (Vx) {
                x.i("MicroMsg.WelabUpdater", "Updating");
                return;
            }
            Vx = true;
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new xi();
            aVar.hmk = new xj();
            aVar.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            aVar.hmi = 1816;
            com.tencent.mm.ae.b JZ = aVar.JZ();
            xi xiVar = (xi) JZ.hmg.hmo;
            Integer num2 = (Integer) g.Dj().CU().get(w.a.xvm, null);
            xiVar.whX = num2 == null ? 0 : num2.intValue();
            xiVar.whY = bVw();
            xiVar.whZ = (int) bh.Wo();
            if (z) {
                xiVar.fDt |= 1;
            }
            if (z2) {
                xiVar.fDt |= 2;
            }
            x.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[]{as(xiVar.whY)});
            u.a(JZ, new u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        xj xjVar = (xj) bVar.hmh.hmo;
                        f.IB();
                        g.Dj().CU().a(w.a.xvm, Integer.valueOf(xjVar.waZ));
                        f.hb(xjVar.wib);
                        f.cs(xjVar.wic);
                        f.F(xjVar.wia);
                        f.IC();
                        x.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[]{Integer.valueOf(xjVar.wib)});
                        f.Vx = false;
                    } else {
                        x.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400)});
                        f.IB();
                        f.hb(86400);
                        f.IC();
                    }
                    return 0;
                }
            });
            return;
        }
        x.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
    }

    private static String as(LinkedList<tf> linkedList) {
        Iterator it = linkedList.iterator();
        String str = "";
        while (it.hasNext()) {
            tf tfVar = (tf) it.next();
            str = str + tfVar.vYU + ":" + tfVar.priority + "|";
        }
        return str;
    }

    private static LinkedList<tf> bVw() {
        LinkedList<tf> linkedList = new LinkedList();
        try {
            for (a aVar : b.bVu().tPx.bVE()) {
                tf tfVar = new tf();
                tfVar.vYU = bh.getInt(aVar.field_expId, 0);
                tfVar.priority = aVar.field_prioritylevel;
                linkedList.add(tfVar);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WelabUpdater", e, "", new Object[0]);
        }
        return linkedList;
    }

    private static void IB() {
        g.Dj().CU().a(w.a.xvk, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void hb(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Dj().CU().a(w.a.xvl, Integer.valueOf(i2));
    }

    private static void IC() {
        g.Dj().CU().lH(true);
    }
}
