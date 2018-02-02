package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.k.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    private static float gyA = -1000.0f;
    private static boolean gyB = false;
    private static Map<String, akt> gyC = new ConcurrentHashMap();
    private static List<akt> gyD = new CopyOnWriteArrayList();
    private static Boolean gyE = Boolean.valueOf(false);
    private static a gyF = new 1();
    private static ak gyG = new ak(Looper.getMainLooper(), new 2(), true);
    private static c gyH = new c<dk>() {
        {
            this.xen = dk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            dk dkVar = (dk) bVar;
            if (dkVar != null && (dkVar instanceof dk)) {
                String str = dkVar.frY.frW;
                int i = dkVar.frY.frZ;
                int i2 = dkVar.frY.fsa;
                if (!k.gyC.containsKey(str + "," + i + "," + i2)) {
                    akt com_tencent_mm_protocal_c_akt = new akt();
                    com_tencent_mm_protocal_c_akt.ned = str;
                    com_tencent_mm_protocal_c_akt.major = i;
                    com_tencent_mm_protocal_c_akt.minor = 65535 & i2;
                    com_tencent_mm_protocal_c_akt.hLU = dkVar.frY.fsb;
                    k.gyC.put(str + "," + i + "," + i2, com_tencent_mm_protocal_c_akt);
                    if (dkVar.frY.fsb >= 0.0d && k.gyD.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.gyD.size()) {
                            akt com_tencent_mm_protocal_c_akt2 = (akt) k.gyD.get(i3);
                            if (dkVar.frY.fsb >= com_tencent_mm_protocal_c_akt2.hLU) {
                                if (i3 == k.gyD.size() - 1 && dkVar.frY.fsb > com_tencent_mm_protocal_c_akt2.hLU) {
                                    k.gyD.add(com_tencent_mm_protocal_c_akt);
                                    break;
                                }
                                i3++;
                            } else {
                                k.gyD.add(i3, com_tencent_mm_protocal_c_akt);
                                break;
                            }
                        }
                    }
                    k.gyD.add(com_tencent_mm_protocal_c_akt);
                }
                x.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", new Object[]{str + "," + i + "," + i2, Integer.valueOf(k.gyC.size())});
            }
            return false;
        }
    };
    private static com.tencent.mm.modelgeo.c gyy;
    private static float gyz = -85.0f;

    public static void run() {
        if (ar.Hj() && !ar.Cs()) {
            ar.Hg();
            Boolean valueOf = Boolean.valueOf(bh.a((Boolean) com.tencent.mm.z.c.CU().get(w.a.xqe, null), false));
            x.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + valueOf);
            if (valueOf.booleanValue()) {
                long Wo = bh.Wo();
                ar.Hg();
                long a = bh.a((Long) com.tencent.mm.z.c.CU().get(w.a.xqf, null), 0);
                ar.Hg();
                if (Wo - a > bh.a((Long) com.tencent.mm.z.c.CU().get(w.a.xpZ, null), 0)) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.xqe, Boolean.valueOf(false));
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.xqd, "");
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.xqc, "");
                    ar.Hg();
                    com.tencent.mm.z.c.Cu();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.xqc, "");
                    return;
                }
                List<String> zN = g.zZ().zN();
                if (zN != null) {
                    for (String str : zN) {
                        x.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", new Object[]{str});
                        b djVar = new dj();
                        djVar.frU.frW = str;
                        djVar.frU.frT = true;
                        com.tencent.mm.sdk.b.a.xef.m(djVar);
                    }
                    gyy = com.tencent.mm.modelgeo.c.OP();
                    if (gyG.cfK()) {
                        gyG.J(3000, 3000);
                    }
                    if (!(gyB || gyy == null)) {
                        gyy.b(gyF);
                    }
                    com.tencent.mm.sdk.b.a.xef.b(gyH);
                }
            }
        }
    }
}
