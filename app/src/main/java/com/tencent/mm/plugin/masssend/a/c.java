package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> omU;

    public final void aYz() {
        a aVar = null;
        boolean aYB = aYB();
        ar.Hg();
        boolean booleanValue = ((Boolean) com.tencent.mm.z.c.CU().get(102408, Boolean.valueOf(false))).booleanValue();
        boolean z = (q.Gd() & 65536) == 0;
        x.d("MicroMsg.MassSendService", "hadSetTop is %B", new Object[]{Boolean.valueOf(booleanValue)});
        if (z && !booleanValue && aYB) {
            x.d("MicroMsg.MassSendService", "set top conversation");
            ar.Hg();
            if (com.tencent.mm.z.c.Fd().WY("masssendapp") == null) {
                ar.Hg();
                if (com.tencent.mm.z.c.Fd().WY("masssendapp") == null) {
                    ae aeVar = new ae();
                    aeVar.setUsername("masssendapp");
                    aeVar.setContent(ac.getContext().getResources().getString(R.l.dVA));
                    aeVar.aj(bh.Wp() + 2000);
                    aeVar.eR(0);
                    aeVar.eO(0);
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().d(aeVar);
                }
            } else {
                String string;
                Cursor a = h.aYD().hhp.a("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
                if (a != null) {
                    a aVar2;
                    if (a.moveToFirst()) {
                        aVar2 = new a();
                        aVar2.b(a);
                    } else {
                        aVar2 = null;
                    }
                    a.close();
                    aVar = aVar2;
                }
                if (aVar == null) {
                    string = ac.getContext().getResources().getString(R.l.dVA);
                } else {
                    h.aYD();
                    string = b.a(aVar);
                }
                ae aeVar2 = new ae();
                aeVar2.setUsername("masssendapp");
                aeVar2.setContent(string);
                aeVar2.aj(bh.Wp() + 2000);
                aeVar2.eR(0);
                aeVar2.eO(0);
                ar.Hg();
                com.tencent.mm.z.c.Fd().a(aeVar2, "masssendapp");
            }
            g.pQN.k(10425, "");
            ar.Hg();
            com.tencent.mm.z.c.CU().set(102409, Long.valueOf(bh.Wp()));
            ar.Hg();
            com.tencent.mm.z.c.CU().set(102408, Boolean.valueOf(true));
        } else if (!aYB) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(102408, Boolean.valueOf(false));
        }
    }

    public static void dG(long j) {
        ar.Hg();
        com.tencent.mm.z.c.CU().set(102409, Long.valueOf(j));
    }

    private static String aYA() {
        if (!ar.Hj()) {
            return "";
        }
        r1 = new Object[2];
        ar.Hg();
        r1[0] = com.tencent.mm.z.c.FB();
        r1[1] = w.cfi();
        x.d("MicroMsg.MassSendService", "config file path is %s", new Object[]{String.format("%s/masssend_%s.ini", r1)});
        return String.format("%s/masssend_%s.ini", r1);
    }

    private boolean aYB() {
        if (this.omU == null) {
            String aYA = aYA();
            byte[] e = e.e(aYA, 0, -1);
            if (e == null) {
                return false;
            }
            try {
                this.omU = ((e) new e().aF(e)).omV;
            } catch (Exception e2) {
                b.deleteFile(aYA);
                return false;
            }
        }
        if (this.omU == null) {
            x.w("MicroMsg.MassSendService", "info list is empty");
            return false;
        }
        x.i("MicroMsg.MassSendService", "info list[%s]", new Object[]{this.omU.toString()});
        long Wo = bh.Wo();
        Iterator it = this.omU.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (((long) dVar.fcM) <= Wo && Wo <= ((long) dVar.end)) {
                return true;
            }
        }
        return false;
    }

    public final void Ef(String str) {
        if (!bh.ov(str)) {
            Map y = bi.y(str, "Festivals");
            if (y != null) {
                e eVar = new e();
                int i = 0;
                while (true) {
                    String str2 = ".Festivals.Festival" + (i == 0 ? "" : String.valueOf(i));
                    if (!y.containsKey(str2)) {
                        break;
                    }
                    d dVar = new d();
                    dVar.fcM = bh.Vz((String) y.get(str2 + ".StartTime"));
                    dVar.end = bh.Vz((String) y.get(str2 + ".EndTime")) + Downloads.MAX_RETYR_AFTER;
                    eVar.omV.add(dVar);
                    i++;
                }
                eVar.count = eVar.omV.size();
                this.omU = eVar.omV;
                try {
                    byte[] toByteArray = eVar.toByteArray();
                    String aYA = aYA();
                    if (bh.ov(aYA)) {
                        x.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                        return;
                    }
                    File file = new File(aYA);
                    if (file.exists()) {
                        int i2;
                        if (com.tencent.mm.a.g.i(file).equals(com.tencent.mm.a.g.s(toByteArray))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            ar.Hg();
                            com.tencent.mm.z.c.CU().set(102408, Boolean.valueOf(false));
                        }
                    } else {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(102408, Boolean.valueOf(false));
                    }
                    x.d("MicroMsg.MassSendService", "save to config file : %s", new Object[]{eVar.toString()});
                    e.b(aYA, toByteArray, toByteArray.length);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MassSendService", e, "", new Object[0]);
                }
            }
        }
    }
}
