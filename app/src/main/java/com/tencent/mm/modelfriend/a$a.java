package com.tencent.mm.modelfriend;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class a$a implements Runnable {
    private static byte[] gSF = new byte[0];
    public static boolean huT = false;
    private static final af hvh = new 1(Looper.getMainLooper());
    private List<String[]> hvc;
    private List<String[]> hvd;
    private List<b> hve;
    private List<b> hvf;
    private bf hvg;

    private a$a() {
    }

    private static List<b> a(List<b> list, int i, int i2) {
        List<b> linkedList = new LinkedList();
        while (i < i2) {
            linkedList.add(list.get(i));
            i++;
        }
        return linkedList;
    }

    public final void run() {
        synchronized (gSF) {
            this.hvg = new bf("MicroMsg.AddrBookSyncHelper", "sync addrBook");
            this.hvg.addSplit("sync begin");
            x.d("MicroMsg.AddrBookSyncHelper", "reading email info");
            this.hvc = a.dX(ac.getContext());
            if (this.hvc != null) {
                x.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.hvc.size());
            }
            this.hvf = a(1, this.hvc);
            x.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
            this.hvd = a.dW(ac.getContext());
            if (this.hvd != null) {
                x.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.hvd.size());
            }
            this.hve = a(0, this.hvd);
            x.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
            if (this.hvc != null && this.hvf.size() > 0) {
                for (int i = 0; i < this.hvf.size(); i += 100) {
                    List a;
                    x.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i);
                    if (i + 100 < this.hvf.size()) {
                        a = a(this.hvf, i, i + 100);
                    } else {
                        a = a(this.hvf, i, this.hvf.size());
                    }
                    x.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + a.size());
                    m.L(a);
                }
            }
            if (this.hve == null || this.hve.size() == 0) {
                x.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
                Message obtainMessage = hvh.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(false);
                hvh.sendMessage(obtainMessage);
                return;
            }
            int i2 = 0;
            while (i2 < this.hve.size()) {
                x.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i2);
                if (ar.Hj()) {
                    List a2;
                    if (i2 + 100 < this.hve.size()) {
                        a2 = a(this.hve, i2, i2 + 100);
                    } else {
                        a2 = a(this.hve, i2, this.hve.size());
                    }
                    x.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + a2.size());
                    m.L(a2);
                    i2 += 100;
                } else {
                    x.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
                    obtainMessage = hvh.obtainMessage();
                    obtainMessage.obj = Boolean.valueOf(false);
                    hvh.sendMessage(obtainMessage);
                    return;
                }
            }
            x.i("MicroMsg.AddrBookSyncHelper", "sync ok");
            if (ar.Hj()) {
                Np();
                System.currentTimeMillis();
                this.hvg.addSplit("sync ok");
                this.hvg.dumpToLog();
                obtainMessage = hvh.obtainMessage();
                obtainMessage.obj = Boolean.valueOf(true);
                hvh.sendMessage(obtainMessage);
                return;
            }
            x.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
            obtainMessage = hvh.obtainMessage();
            obtainMessage.obj = Boolean.valueOf(false);
            hvh.sendMessage(obtainMessage);
        }
    }

    private static void Np() {
        bf bfVar = new bf("MicroMsg.AddrBookSyncHelper", "delete");
        List arrayList = new ArrayList();
        List dY = a.dY(ac.getContext());
        for (String[] strArr : af.OD().ND()) {
            String ou = bh.ou(strArr[0]);
            String ou2 = bh.ou(strArr[1]);
            if (!(ou.equals("") || dY.contains(ou))) {
                arrayList.add(ou2);
            }
        }
        if (arrayList.size() > 0) {
            af.OD().I(arrayList);
            m.K(arrayList);
        }
        bfVar.addSplit("end");
        bfVar.dumpToLog();
    }

    private static List<b> a(int i, List<String[]> list) {
        if (list == null) {
            x.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
            return new LinkedList();
        }
        List<b> arrayList = new ArrayList();
        for (String[] strArr : list) {
            if (strArr != null) {
                String str = strArr[0];
                String str2 = strArr[1];
                String str3 = strArr[2];
                String str4 = strArr[3];
                long VJ = bh.VJ(strArr[4]);
                if (!(str3 == null || str3.equals(""))) {
                    String str5 = "";
                    if (i == 1) {
                        str5 = g.s(str3.getBytes());
                    }
                    if (i == 0) {
                        str5 = a.Id(str3);
                        if (bh.ov(str5)) {
                            x.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
                        } else {
                            str5 = g.s(str5.getBytes());
                        }
                    }
                    b bVar = new b();
                    bVar.gJo = str2;
                    bVar.hvk = c.om(str2);
                    bVar.hvl = c.ol(str2);
                    bVar.hvi = str;
                    bVar.hls = str4;
                    bVar.kQ(str5);
                    bVar.hvL = VJ;
                    bVar.hvr = bVar.Ad();
                    if (i == 1) {
                        bVar.fWi = str3;
                    }
                    if (i == 0) {
                        bVar.hvo = str3;
                    }
                    bVar.type = i;
                    bVar.fDt = 1095798;
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }
}
