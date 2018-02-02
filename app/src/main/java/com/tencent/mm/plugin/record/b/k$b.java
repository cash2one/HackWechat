package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.f;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class k$b implements e, a, Runnable {
    private boolean fdb = false;
    private int i = 0;
    private g pEX;
    HashMap<Long, Boolean> pFs = new HashMap();
    final /* synthetic */ k pFv;
    HashMap<Long, String> pFw = new HashMap();

    public k$b(k kVar, g gVar) {
        this.pFv = kVar;
        this.pEX = gVar;
        o.TU().a(this, Looper.getMainLooper());
        ar.CG().a(221, this);
    }

    public final void run() {
        this.i = 0;
        this.fdb = false;
        Iterator it = this.pEX.field_dataProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            long j = uqVar.wdP;
            if (j > 0) {
                ar.Hg();
                cf dH = c.Fa().dH(j);
                String str = uqVar.wdh;
                Object obj = (System.currentTimeMillis() - dH.field_createTime <= 259200000 || (!bh.ov(str) && com.tencent.mm.a.e.bO(str))) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[]{Integer.valueOf(dH.getType())});
                } else if (uqVar.bjS == 2) {
                    if (dH.cje()) {
                        int i;
                        com.tencent.mm.aq.e bh = com.tencent.mm.aq.o.Pw().bh(dH.field_msgSvrId);
                        if (dH.field_isSend == 1) {
                            int i2;
                            if (bh.Pe()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            i = i2;
                        } else if (bh.Pe()) {
                            if (com.tencent.mm.a.e.bO(com.tencent.mm.aq.o.Pw().m(f.a(bh).hzQ, "", ""))) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (bh.offset < bh.hlp || bh.hlp == 0) {
                            this.pFs.put(Long.valueOf(j), Boolean.valueOf(false));
                            this.i = this.pEX.field_dataProto.weU.indexOf(uqVar);
                            com.tencent.mm.aq.o.Px().a(bh.hzP, dH.field_msgId, i, uqVar, R.g.bAH, new 1(this, bh, dH, j));
                        }
                    } else if (dH.cjm()) {
                        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(dH.field_content);
                        if (fT == null) {
                            x.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[]{dH.field_content});
                        } else {
                            if (bh.ov(fT.fny) && !bh.ov(fT.hbi)) {
                                x.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[]{dH.field_content});
                                fT.fny = fT.hbi.hashCode();
                            }
                            str = fT.fny;
                            if (!l.a(dH, l.af(str, dH.field_msgId))) {
                                this.pFs.put(Long.valueOf(dH.field_msgId), Boolean.valueOf(false));
                                this.pFw.put(Long.valueOf(dH.field_msgId), str);
                                l.a(dH, null);
                            }
                        }
                    }
                } else if (uqVar.bjS == 4 || uqVar.bjS == 15) {
                    r nF = t.nF(dH.field_imgPath);
                    if (!(nF == null || nF.status == 199)) {
                        this.pFs.put(Long.valueOf(j), Boolean.valueOf(false));
                        if (nF.Ui()) {
                            x.i("MicroMsg.RecordMsgSendService", "start complete online video");
                            t.nJ(dH.field_imgPath);
                        } else {
                            x.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                            t.nB(dH.field_imgPath);
                        }
                    }
                }
            }
        }
        this.fdb = true;
        this.pFv.pFa = false;
        a(this.pFs, this.fdb, this.pEX);
    }

    public final void a(a.a aVar) {
        r nF = t.nF(aVar.fileName);
        if (nF != null) {
            ar.Hg();
            cf dH = c.Fa().dH((long) nF.hVI);
            if (nF.Uj()) {
                this.pFs.put(Long.valueOf(dH.field_msgId), Boolean.valueOf(true));
                a(this.pFs, this.fdb, this.pEX);
                return;
            }
            return;
        }
        a(null, this.fdb, this.pEX);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof ab) {
            ar.CG().b(221, this);
            if (this.pFw != null) {
                for (Entry entry : this.pFw.entrySet()) {
                    long longValue = ((Long) entry.getKey()).longValue();
                    String str2 = (String) entry.getValue();
                    if (longValue > 0 && !((Boolean) this.pFs.get(Long.valueOf(longValue))).booleanValue()) {
                        ar.Hg();
                        c.Fa().dH(longValue);
                        b af = l.af(str2, longValue);
                        if (af != null) {
                            str2 = af.field_fileFullPath;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null && str2.length() > 0) {
                            this.pFs.put(Long.valueOf(longValue), Boolean.valueOf(true));
                            Iterator it = this.pEX.field_dataProto.weU.iterator();
                            while (it.hasNext()) {
                                uq uqVar = (uq) it.next();
                                if (uqVar.wdP == longValue) {
                                    uqVar.TE(af.field_fileFullPath);
                                }
                            }
                        }
                    }
                }
            }
            a(this.pFs, this.fdb, this.pEX);
            return;
        }
        a(null, this.fdb, this.pEX);
    }

    private void a(HashMap<Long, Boolean> hashMap, boolean z, g gVar) {
        int i;
        if (hashMap != null) {
            for (Entry value : hashMap.entrySet()) {
                if (!Boolean.valueOf(((Boolean) value.getValue()).booleanValue()).booleanValue()) {
                    i = 0;
                    break;
                }
            }
        }
        i = 1;
        if (i != 0 && z) {
            o.TU().a(this);
            gVar.field_type = 2;
            n.bmS().c(gVar, new String[]{"localId"});
            n.bmT().a(gVar);
        }
    }
}
