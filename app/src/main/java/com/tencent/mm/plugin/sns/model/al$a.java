package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class al$a implements e, h {
    public static int qXd = -1;
    private Map<a, String> hmZ = new HashMap();
    private Map<String, Long> qXe = new HashMap();
    private Map<String, Integer> qXf = new HashMap();
    private int qXg = 0;
    public long qXh = 0;
    private LinkedList<String> qXi = new LinkedList();
    public Map<String, ArrayList<b>> qXj = new HashMap();
    public Map<String, Integer> qXk = new HashMap();

    static /* synthetic */ void a(al$a com_tencent_mm_plugin_sns_model_al_a) {
        if (!ae.bve() && com_tencent_mm_plugin_sns_model_al_a.hmZ.isEmpty()) {
            ae.bvs().buJ();
            x.d("MicroMsg.SnsService", "clean sns cache");
        }
    }

    public final void h(String str, ArrayList<b> arrayList) {
        this.qXj.put(str, arrayList);
    }

    public final Intent e(Intent intent, String str) {
        intent.putExtra("sns_userName", str);
        if (this.qXi != null && this.qXi.contains(str)) {
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.addFlags(67108864);
        }
        return intent;
    }

    public final void a(int i, String str, a aVar) {
        x.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
        ae.bvu().gze = q.FS();
        ae.bvu().buW();
        ae.bvr().buj();
        if (this.hmZ.isEmpty()) {
            g.Dk();
            g.Di().gPJ.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
            g.Dk();
            g.Di().gPJ.a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, this);
        }
        if (!this.hmZ.containsKey(aVar)) {
            if (i == 1) {
                this.hmZ.put(aVar, "@__weixintimtline");
            } else if (i == 2 || i == 3) {
                this.hmZ.put(aVar, str);
            } else if (i == 4) {
                this.hmZ.put(aVar, "@__classify_timeline");
            } else if (i == 5) {
                this.hmZ.put(aVar, "");
            } else {
                this.hmZ.put(aVar, "");
            }
        }
        switch (i) {
            case 1:
                this.qXh = 0;
                this.qXg = bvU();
                x.Kd("@__weixintimtline");
                return;
            case 2:
                synchronized (this.qXe) {
                    this.qXe.put(str, Long.valueOf(0));
                }
                synchronized (this.qXf) {
                    if (!this.qXf.containsKey(str)) {
                        this.qXf.put(str, Integer.valueOf(bvU()));
                    }
                }
                z.Kg(str);
                this.qXi.add(str);
                return;
            default:
                return;
        }
    }

    public final boolean a(a aVar, int i) {
        x.d("MicroMsg.SnsService", "closeServer");
        this.hmZ.remove(aVar);
        if (i == 2 && this.qXi.size() > 0) {
            this.qXi.removeLast();
        }
        if (this.hmZ.isEmpty()) {
            g.Dk();
            g.Di().gPJ.b(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
            g.Dk();
            g.Di().gPJ.b(com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, this);
            am.release();
            m.release();
            new af(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ al$a qXl;

                {
                    this.qXl = r1;
                }

                public final void run() {
                    al$a.a(this.qXl);
                }
            }, 5000);
            ai.bvO();
            x.i("MicroMsg.SnsService", "close finish");
        }
        return true;
    }

    public final void b(int i, String str, boolean z, int i2) {
        if (!r.ida) {
            synchronized (this.qXe) {
                x.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[]{str, Integer.valueOf(i), Long.valueOf(this.qXh), this.qXe});
            }
            if (i == 2) {
                if (z.Kf(str)) {
                    long j = 0;
                    synchronized (this.qXe) {
                        if (this.qXe.containsKey(str)) {
                            j = ((Long) this.qXe.get(str)).longValue();
                        }
                    }
                    if (j == 0) {
                        x.Kd(str);
                        return;
                    }
                    g.Dk();
                    g.Di().gPJ.a(new z(str, j, z, i2), 0);
                }
            } else if (i == 1) {
                if (!x.Kc("@__weixintimtline")) {
                    return;
                }
                if (this.qXh == 0) {
                    x.Kd("@__weixintimtline");
                    return;
                }
                g.Dk();
                g.Di().gPJ.a(new x(this.qXh), 0);
            } else if (i == 3 || i != 4 || !m.Kc("@__classify_timeline")) {
            } else {
                if (this.qXh == 0) {
                    m.Kd("@__classify_timeline");
                    return;
                }
                g.Dk();
                g.Di().gPJ.a(new m(""), 0);
            }
        }
    }

    public final void a(int i, String str, boolean z, int i2) {
        if (!r.ida) {
            x.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[]{Integer.valueOf(i), str});
            if (i == 2) {
                if (z.Kf(str)) {
                    g.Dk();
                    g.Di().gPJ.a(new z(str, 0, z, i2), 0);
                }
            } else if (i == 1) {
                if (x.Kc("@__weixintimtline")) {
                    g.Dk();
                    g.Dj().CU().set(68377, "");
                    g.Dk();
                    g.Di().gPJ.a(new x(0), 0);
                }
            } else if (i != 3 && i == 4 && m.Kc("@__classify_timeline")) {
                g.Dk();
                g.Di().gPJ.a(new m(""), 0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int Kp(String str) {
        synchronized (this.qXf) {
            if (this.qXf.containsKey(str)) {
                int intValue = ((Integer) this.qXf.get(str)).intValue();
                if (intValue <= 0) {
                    intValue = i.bul();
                }
            } else {
                return i.bul();
            }
        }
    }

    public final int bvU() {
        return this.qXg > 0 ? this.qXg : i.bul();
    }

    public final void x(long j, int i) {
        x.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[]{Long.valueOf(j)});
        if (i > 0) {
            this.qXg = i;
            i.ww(i);
        }
        if (j != 0) {
            this.qXh = j;
        }
    }

    public static int bvV() {
        if (qXd != -1) {
            return qXd;
        }
        int buk = i.buk();
        qXd = buk;
        return buk;
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        x xVar;
        int i3;
        z zVar;
        String str2;
        long j;
        d dVar;
        Iterator it;
        a aVar;
        String str3;
        String er;
        boolean buC;
        boolean buE;
        boolean z;
        boolean buD;
        x.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (!((i == 4 && i2 == 207) || (i == 4 && i2 == 203))) {
            if (i == 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN)) {
                obj = 1;
                if (obj != null) {
                    switch (kVar.getType()) {
                        case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                            xVar = (x) kVar;
                            x(xVar.qTM, xVar.qTO);
                            i3 = xVar.qTP;
                            if (qXd != i3) {
                                i.wv(i3);
                            }
                            qXd = i3;
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                            zVar = (z) kVar;
                            str2 = zVar.userName;
                            j = zVar.qTM;
                            i3 = zVar.qTO;
                            if (i3 > 0) {
                                synchronized (this.qXf) {
                                    this.qXf.put(str2, Integer.valueOf(i3));
                                }
                            }
                            if (j != 0) {
                                synchronized (this.qXe) {
                                    this.qXe.put(str2, Long.valueOf(j));
                                }
                                break;
                            }
                            break;
                    }
                    if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                    }
                    dVar = (d) kVar;
                    it = new ArrayList(this.hmZ.keySet()).iterator();
                    while (it.hasNext()) {
                        aVar = (a) it.next();
                        if (!this.hmZ.containsKey(aVar)) {
                            str3 = (String) this.hmZ.get(aVar);
                            if (!dVar.getUserName().equals(str3)) {
                                x.d("MicroMsg.SnsService", "notify ui " + str3);
                                if (dVar.buF() != 0) {
                                }
                                if (dVar.buB()) {
                                    buC = dVar.buC();
                                    buE = dVar.buE();
                                    if (i != 4) {
                                    }
                                    aVar.a(buC, er, buE, z, i2, dVar.buH());
                                } else {
                                    buD = dVar.buD();
                                    buC = dVar.buC();
                                    buE = dVar.buG();
                                    if (i != 4) {
                                    }
                                    aVar.a(buD, buC, er, buE, z, i2, dVar.buH());
                                }
                            }
                        }
                    }
                }
            } else if (i == 4 && (i2 == 2001 || i2 == 2003)) {
                obj = 1;
                if (obj != null) {
                    switch (kVar.getType()) {
                        case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                            xVar = (x) kVar;
                            x(xVar.qTM, xVar.qTO);
                            i3 = xVar.qTP;
                            if (qXd != i3) {
                                i.wv(i3);
                            }
                            qXd = i3;
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                            zVar = (z) kVar;
                            str2 = zVar.userName;
                            j = zVar.qTM;
                            i3 = zVar.qTO;
                            if (i3 > 0) {
                                synchronized (this.qXf) {
                                    this.qXf.put(str2, Integer.valueOf(i3));
                                }
                            }
                            if (j != 0) {
                                synchronized (this.qXe) {
                                    this.qXe.put(str2, Long.valueOf(j));
                                }
                                break;
                            }
                            break;
                    }
                    if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                    }
                    dVar = (d) kVar;
                    it = new ArrayList(this.hmZ.keySet()).iterator();
                    while (it.hasNext()) {
                        aVar = (a) it.next();
                        if (!this.hmZ.containsKey(aVar)) {
                            str3 = (String) this.hmZ.get(aVar);
                            if (!dVar.getUserName().equals(str3)) {
                                x.d("MicroMsg.SnsService", "notify ui " + str3);
                                if (dVar.buF() != 0) {
                                }
                                if (dVar.buB()) {
                                    buC = dVar.buC();
                                    buE = dVar.buE();
                                    if (i != 4) {
                                    }
                                    aVar.a(buC, er, buE, z, i2, dVar.buH());
                                } else {
                                    buD = dVar.buD();
                                    buC = dVar.buC();
                                    buE = dVar.buG();
                                    if (i != 4) {
                                    }
                                    aVar.a(buD, buC, er, buE, z, i2, dVar.buH());
                                }
                            }
                        }
                    }
                }
            } else if (!(i == 0 && i2 == 0)) {
                obj = null;
                if (obj != null) {
                    switch (kVar.getType()) {
                        case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                            xVar = (x) kVar;
                            x(xVar.qTM, xVar.qTO);
                            i3 = xVar.qTP;
                            if (qXd != i3) {
                                i.wv(i3);
                            }
                            qXd = i3;
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                            zVar = (z) kVar;
                            str2 = zVar.userName;
                            j = zVar.qTM;
                            i3 = zVar.qTO;
                            if (i3 > 0) {
                                synchronized (this.qXf) {
                                    this.qXf.put(str2, Integer.valueOf(i3));
                                }
                            }
                            if (j != 0) {
                                synchronized (this.qXe) {
                                    this.qXe.put(str2, Long.valueOf(j));
                                }
                                break;
                            }
                            break;
                    }
                    if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX) {
                        dVar = (d) kVar;
                        it = new ArrayList(this.hmZ.keySet()).iterator();
                        while (it.hasNext()) {
                            aVar = (a) it.next();
                            if (!this.hmZ.containsKey(aVar)) {
                                str3 = (String) this.hmZ.get(aVar);
                                if (!dVar.getUserName().equals(str3)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str3);
                                    er = dVar.buF() != 0 ? "" : i.er(dVar.buF());
                                    if (dVar.buB()) {
                                        buD = dVar.buD();
                                        buC = dVar.buC();
                                        buE = dVar.buG();
                                        z = i != 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || i2 == 2003);
                                        aVar.a(buD, buC, er, buE, z, i2, dVar.buH());
                                    } else {
                                        buC = dVar.buC();
                                        buE = dVar.buE();
                                        z = i != 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || i2 == 2003);
                                        aVar.a(buC, er, buE, z, i2, dVar.buH());
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            switch (kVar.getType()) {
                case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                    xVar = (x) kVar;
                    x(xVar.qTM, xVar.qTO);
                    i3 = xVar.qTP;
                    if (qXd != i3) {
                        i.wv(i3);
                    }
                    qXd = i3;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                    zVar = (z) kVar;
                    str2 = zVar.userName;
                    j = zVar.qTM;
                    i3 = zVar.qTO;
                    if (i3 > 0) {
                        synchronized (this.qXf) {
                            this.qXf.put(str2, Integer.valueOf(i3));
                        }
                    }
                    if (j != 0) {
                        synchronized (this.qXe) {
                            this.qXe.put(str2, Long.valueOf(j));
                        }
                        break;
                    }
                    break;
            }
            if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            }
            dVar = (d) kVar;
            it = new ArrayList(this.hmZ.keySet()).iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!this.hmZ.containsKey(aVar)) {
                    str3 = (String) this.hmZ.get(aVar);
                    if (!dVar.getUserName().equals(str3)) {
                        x.d("MicroMsg.SnsService", "notify ui " + str3);
                        if (dVar.buF() != 0) {
                        }
                        if (dVar.buB()) {
                            buC = dVar.buC();
                            buE = dVar.buE();
                            if (i != 4) {
                            }
                            aVar.a(buC, er, buE, z, i2, dVar.buH());
                        } else {
                            buD = dVar.buD();
                            buC = dVar.buC();
                            buE = dVar.buG();
                            if (i != 4) {
                            }
                            aVar.a(buD, buC, er, buE, z, i2, dVar.buH());
                        }
                    }
                }
            }
        }
    }

    public static void Kq(String str) {
        com.tencent.mm.plugin.sns.storage.a bxT;
        Object obj;
        ac bvu = ae.bvu();
        if (bh.ov(bvu.gze)) {
            bvu.gze = q.FS();
        }
        String str2 = bvu.gze;
        m Ll = com.tencent.mm.plugin.sns.storage.h.Ll(str);
        try {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(Ll.field_attrBuf);
            Iterator it = com_tencent_mm_protocal_c_bjv.wNa.iterator();
            while (it.hasNext()) {
                bjk com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                if (com_tencent_mm_protocal_c_bjk.vIy.equals(str2)) {
                    com_tencent_mm_protocal_c_bjv.wNa.remove(com_tencent_mm_protocal_c_bjk);
                    com_tencent_mm_protocal_c_bjv.wMY--;
                    Ll.field_attrBuf = com_tencent_mm_protocal_c_bjv.toByteArray();
                    if (Ll.xl(32)) {
                        ae.bvy().a(Ll.byB());
                    } else {
                        ae.bvv().z(Ll);
                    }
                    if (!ae.bvu().eF(u.LF(str))) {
                        if (Ll.xl(32)) {
                            g.Dk();
                            g.Di().gPJ.a(new q(u.LF(str), 5), 0);
                            return;
                        }
                        bxT = Ll.bxT();
                        if (bxT != null) {
                            obj = "";
                        } else {
                            String str3 = bxT.iTh;
                        }
                        ((c) g.h(c.class)).a(11855, Ll.byC(), Integer.valueOf(0), obj, Integer.valueOf(Ll.byC()));
                        g.Dk();
                        g.Di().gPJ.a(new q(u.LF(str), 7), 0);
                    }
                    return;
                }
            }
        } catch (Exception e) {
        }
        if (!ae.bvu().eF(u.LF(str))) {
            return;
        }
        if (Ll.xl(32)) {
            g.Dk();
            g.Di().gPJ.a(new q(u.LF(str), 5), 0);
            return;
        }
        bxT = Ll.bxT();
        if (bxT != null) {
            String str32 = bxT.iTh;
        } else {
            obj = "";
        }
        ((c) g.h(c.class)).a(11855, Ll.byC(), Integer.valueOf(0), obj, Integer.valueOf(Ll.byC()));
        g.Dk();
        g.Di().gPJ.a(new q(u.LF(str), 7), 0);
    }

    public static bjk a(m mVar, int i, String str) {
        return a(mVar, i, str, null, false, 0, 0);
    }

    public static bjk a(m mVar, int i, String str, bjk com_tencent_mm_protocal_c_bjk, int i2) {
        return a(mVar, i, str, com_tencent_mm_protocal_c_bjk, false, i2);
    }

    public static bjk a(m mVar, int i, String str, bjk com_tencent_mm_protocal_c_bjk, boolean z, int i2) {
        return a(mVar, i, str, com_tencent_mm_protocal_c_bjk, z, 0, i2);
    }

    private static bjk a(m mVar, int i, String str, bjk com_tencent_mm_protocal_c_bjk, boolean z, int i2, int i3) {
        bje com_tencent_mm_protocal_c_bje = new bje();
        com_tencent_mm_protocal_c_bje.nje = str;
        com_tencent_mm_protocal_c_bje.pbl = (int) (bh.Wp() / 1000);
        com_tencent_mm_protocal_c_bje.wMt = q.FU();
        com_tencent_mm_protocal_c_bje.wFM = q.FS();
        com_tencent_mm_protocal_c_bje.vHW = 0;
        com_tencent_mm_protocal_c_bje.wMu = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(mVar.field_userName);
        com_tencent_mm_protocal_c_bje.wbg = mVar.field_userName;
        com_tencent_mm_protocal_c_bje.ktN = i;
        com_tencent_mm_protocal_c_bje.wMB = i3;
        if (mVar.xl(32)) {
            com_tencent_mm_protocal_c_bje.wMy = com_tencent_mm_protocal_c_bjk == null ? 0 : com_tencent_mm_protocal_c_bjk.wMz;
        } else {
            com_tencent_mm_protocal_c_bje.wMv = com_tencent_mm_protocal_c_bjk == null ? 0 : com_tencent_mm_protocal_c_bjk.wMw;
        }
        bje com_tencent_mm_protocal_c_bje2 = new bje();
        com_tencent_mm_protocal_c_bje2.wFM = com_tencent_mm_protocal_c_bjk == null ? "" : com_tencent_mm_protocal_c_bjk.vIy;
        bjf com_tencent_mm_protocal_c_bjf = new bjf();
        com_tencent_mm_protocal_c_bjf.vPO = mVar.field_snsId;
        com_tencent_mm_protocal_c_bjf.wMD = com_tencent_mm_protocal_c_bje;
        com_tencent_mm_protocal_c_bjf.wME = com_tencent_mm_protocal_c_bje2;
        String str2 = "";
        if (mVar.xl(32)) {
            Object obj;
            com.tencent.mm.plugin.sns.storage.a bxT = mVar.bxT();
            if (bxT == null) {
                obj = "";
            } else {
                String str3 = bxT.iTh;
            }
            str2 = bxT == null ? "" : bxT.qZM;
            if (com_tencent_mm_protocal_c_bje.ktN == 7) {
                ((c) g.h(c.class)).a(11855, mVar.byC(), Integer.valueOf(1), obj, Integer.valueOf(mVar.byC()));
            } else if (com_tencent_mm_protocal_c_bje.ktN == 8) {
                ((c) g.h(c.class)).a(11855, mVar.byC(), Integer.valueOf(2), obj, Integer.valueOf(mVar.byC()));
            }
            com.tencent.mm.plugin.sns.storage.e byB = mVar.byB();
            if (byB != null && byB.field_firstControlTime == 0) {
                byB.field_firstControlTime = com_tencent_mm_protocal_c_bje.pbl;
                ae.bvy().b(byB.field_snsId, byB);
            }
        }
        String s = com.tencent.mm.a.g.s((bh.Wq()).getBytes());
        if (mVar.xl(32)) {
            s = "_AD_TAG_" + s;
        }
        if (!ae.bvu().a(s, com_tencent_mm_protocal_c_bjf)) {
            x.e("MicroMsg.SnsService", "can not add Comment");
        } else if (ac.Kh(s)) {
            g.Dk();
            g.Di().gPJ.a(new j(com_tencent_mm_protocal_c_bjf, s, str2), 0);
        } else {
            g.Dk();
            g.Di().gPJ.a(new n(com_tencent_mm_protocal_c_bjf, s), 0);
        }
        if (!z) {
            return null;
        }
        bjk com_tencent_mm_protocal_c_bjk2 = new bjk();
        com_tencent_mm_protocal_c_bjk2.pbl = com_tencent_mm_protocal_c_bje.pbl;
        com_tencent_mm_protocal_c_bjk2.ktN = com_tencent_mm_protocal_c_bje.ktN;
        com_tencent_mm_protocal_c_bjk2.vHW = com_tencent_mm_protocal_c_bje.vHW;
        com_tencent_mm_protocal_c_bjk2.vIy = com_tencent_mm_protocal_c_bje.wFM;
        com_tencent_mm_protocal_c_bjk2.wvW = com_tencent_mm_protocal_c_bje.wMt;
        com_tencent_mm_protocal_c_bjk2.nje = com_tencent_mm_protocal_c_bje.nje;
        com_tencent_mm_protocal_c_bjk2.wMB = com_tencent_mm_protocal_c_bje.wMB;
        if (mVar.xl(32)) {
            com_tencent_mm_protocal_c_bjk2.wMy = com_tencent_mm_protocal_c_bjk == null ? 0 : com_tencent_mm_protocal_c_bjk.wMz;
        } else {
            com_tencent_mm_protocal_c_bjk2.wMv = com_tencent_mm_protocal_c_bjk == null ? 0 : com_tencent_mm_protocal_c_bjk.wMw;
        }
        com_tencent_mm_protocal_c_bjk2.wMQ = com_tencent_mm_protocal_c_bjk == null ? "" : com_tencent_mm_protocal_c_bjk.vIy;
        return com_tencent_mm_protocal_c_bjk2;
    }

    public static bjk a(m mVar, int i, String str, String str2, int i2) {
        bje com_tencent_mm_protocal_c_bje = new bje();
        com_tencent_mm_protocal_c_bje.nje = str;
        com_tencent_mm_protocal_c_bje.pbl = (int) (bh.Wp() / 1000);
        com_tencent_mm_protocal_c_bje.wMt = q.FU();
        com_tencent_mm_protocal_c_bje.wFM = q.FS();
        com_tencent_mm_protocal_c_bje.vHW = i2;
        com_tencent_mm_protocal_c_bje.wMu = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(mVar.field_userName);
        com_tencent_mm_protocal_c_bje.wbg = mVar.field_userName;
        com_tencent_mm_protocal_c_bje.ktN = i;
        if (mVar.xl(32)) {
            com_tencent_mm_protocal_c_bje.wMy = 0;
        } else {
            com_tencent_mm_protocal_c_bje.wMv = 0;
        }
        bje com_tencent_mm_protocal_c_bje2 = new bje();
        com_tencent_mm_protocal_c_bje2.wFM = str2;
        bjf com_tencent_mm_protocal_c_bjf = new bjf();
        com_tencent_mm_protocal_c_bjf.vPO = mVar.field_snsId;
        com_tencent_mm_protocal_c_bjf.wMD = com_tencent_mm_protocal_c_bje;
        com_tencent_mm_protocal_c_bjf.wME = com_tencent_mm_protocal_c_bje2;
        String str3 = "";
        if (mVar.xl(32)) {
            Object obj;
            com.tencent.mm.plugin.sns.storage.a bxT = mVar.bxT();
            if (bxT == null) {
                obj = "";
            } else {
                String str4 = bxT.iTh;
            }
            str3 = bxT == null ? "" : bxT.qZM;
            if (com_tencent_mm_protocal_c_bje.ktN == 7) {
                ((c) g.h(c.class)).a(11855, mVar.byC(), Integer.valueOf(1), obj, Integer.valueOf(mVar.byC()));
            } else if (com_tencent_mm_protocal_c_bje.ktN == 8) {
                ((c) g.h(c.class)).a(11855, mVar.byC(), Integer.valueOf(2), obj, Integer.valueOf(mVar.byC()));
            }
        }
        String s = com.tencent.mm.a.g.s((bh.Wq()).getBytes());
        if (mVar.xl(32)) {
            s = "_AD_TAG_" + s;
        }
        if (!ae.bvu().a(s, com_tencent_mm_protocal_c_bjf, str3)) {
            x.e("MicroMsg.SnsService", "can not add Comment");
        } else if (ac.Kh(s)) {
            g.Dk();
            g.Di().gPJ.a(new j(com_tencent_mm_protocal_c_bjf, s, str3), 0);
        } else {
            g.Dk();
            g.Di().gPJ.a(new n(com_tencent_mm_protocal_c_bjf, s), 0);
        }
        return null;
    }

    public static void a(String str, int i, String str2, m mVar, int i2) {
        if (i == 3 || i == 5) {
            bje com_tencent_mm_protocal_c_bje = new bje();
            com_tencent_mm_protocal_c_bje.nje = str2;
            com_tencent_mm_protocal_c_bje.pbl = (int) (System.currentTimeMillis() / 1000);
            com_tencent_mm_protocal_c_bje.wMt = q.FU();
            com_tencent_mm_protocal_c_bje.wFM = q.FS();
            com_tencent_mm_protocal_c_bje.vHW = i2;
            com_tencent_mm_protocal_c_bje.wMu = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(str);
            com_tencent_mm_protocal_c_bje.wbg = str;
            com_tencent_mm_protocal_c_bje.ktN = i;
            bjf com_tencent_mm_protocal_c_bjf = new bjf();
            com_tencent_mm_protocal_c_bjf.vPO = mVar.field_snsId;
            com_tencent_mm_protocal_c_bjf.wMD = com_tencent_mm_protocal_c_bje;
            com_tencent_mm_protocal_c_bjf.wME = new bje();
            String s = com.tencent.mm.a.g.s((bh.Wq()).getBytes());
            long j = mVar.field_snsId;
            try {
                x.v("MicroMsg.SnsService", "comment stg inserted");
                com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
                iVar.field_talker = str;
                iVar.field_snsID = j;
                iVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                iVar.field_curActionBuf = com_tencent_mm_protocal_c_bje.toByteArray();
                iVar.field_type = i;
                iVar.field_isSend = true;
                iVar.field_isRead = (short) 1;
                ae.bvA().b(iVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
            }
            ae.bvu().a(s, com_tencent_mm_protocal_c_bjf);
        }
    }

    public final void JC(String str) {
        String accSnsPath = ae.getAccSnsPath();
        String str2 = str + "bg_";
        String str3 = str + "tbg_";
        if (FileOp.bO(str2)) {
            FileOp.deleteFile(am.r(accSnsPath, str) + str3);
            FileOp.g(am.r(accSnsPath, str), str2, str3);
        }
    }
}
