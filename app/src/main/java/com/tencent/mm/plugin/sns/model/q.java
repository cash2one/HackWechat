package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.bjz;
import com.tencent.mm.protocal.c.bka;
import com.tencent.mm.protocal.c.bkb;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    private af handler;
    public int qQY;
    private long qTW;
    private bjk qTX;
    private Object qTY;
    private int qTZ;
    public int type;

    public q(long j, int i) {
        this(j, i, null, null);
    }

    public q(long j, int i, Object obj) {
        this(j, i, null, obj);
    }

    public q(long j, int i, bjk com_tencent_mm_protocal_c_bjk) {
        this(j, i, com_tencent_mm_protocal_c_bjk, null);
    }

    private q(long j, int i, bjk com_tencent_mm_protocal_c_bjk, Object obj) {
        this.type = -1;
        this.qTW = 0;
        this.qQY = -1;
        this.qTZ = 0;
        this.handler = new af(Looper.getMainLooper());
        this.qTX = com_tencent_mm_protocal_c_bjk;
        this.type = i;
        this.qTW = j;
        this.qTY = obj;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (com_tencent_mm_protocal_c_bjk != null) {
            x.i("MicroMsg.NetSceneSnsObjectOp", com_tencent_mm_protocal_c_bjk.wMw + " " + com_tencent_mm_protocal_c_bjk.wMz);
        }
        a aVar = new a();
        aVar.hmj = new bkb();
        aVar.hmk = new bkc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hmi = 218;
        aVar.hml = 104;
        aVar.hmm = 1000000104;
        this.gJQ = aVar.JZ();
        bkb com_tencent_mm_protocal_c_bkb = (bkb) this.gJQ.hmg.hmo;
        m eR = ae.bvv().eR(j);
        if (eR != null) {
            this.qQY = eR.roJ;
        }
        bjy a = a(j, i, this.qTX, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        com_tencent_mm_protocal_c_bkb.wNw = linkedList;
        com_tencent_mm_protocal_c_bkb.wNv = linkedList.size();
    }

    public q(long j, int i, int i2, String str) {
        this.type = -1;
        this.qTW = 0;
        this.qQY = -1;
        this.qTZ = 0;
        this.handler = new af(Looper.getMainLooper());
        this.qTX = null;
        this.type = 9;
        this.qTW = j;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.hmj = new bkb();
        aVar.hmk = new bkc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hmi = 218;
        aVar.hml = 104;
        aVar.hmm = 1000000104;
        this.gJQ = aVar.JZ();
        bkb com_tencent_mm_protocal_c_bkb = (bkb) this.gJQ.hmg.hmo;
        m eR = ae.bvv().eR(j);
        if (eR != null) {
            this.qQY = eR.roJ;
        }
        bjy w = w(j, this.type);
        bka com_tencent_mm_protocal_c_bka = new bka();
        com_tencent_mm_protocal_c_bka.rYW = i;
        com_tencent_mm_protocal_c_bka.wNt = i2;
        com_tencent_mm_protocal_c_bka.wNu = n.os(str);
        try {
            w.wCY = new bdn().bj(com_tencent_mm_protocal_c_bka.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(w);
        com_tencent_mm_protocal_c_bkb.wNw = linkedList;
        com_tencent_mm_protocal_c_bkb.wNv = linkedList.size();
    }

    private static bjy a(long j, int i, bjk com_tencent_mm_protocal_c_bjk, Object obj) {
        m mVar;
        bjy w = w(j, i);
        x.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        String str = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            m bxX;
            com.tencent.mm.plugin.sns.storage.e eK = ae.bvy().eK(j);
            if (eK != null) {
                bxX = eK.bxX();
            } else {
                bxX = null;
            }
            if (bxX == null || !bxX.xl(32)) {
                mVar = bxX;
            } else {
                com.tencent.mm.plugin.sns.storage.a bxT = bxX.bxT();
                String str2 = bxT == null ? "" : bxT.qZM;
                x.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + str2);
                str = str2;
                mVar = bxX;
            }
        } else {
            mVar = null;
        }
        if (i == 6) {
            if (com_tencent_mm_protocal_c_bjk == null || (com_tencent_mm_protocal_c_bjk.wMw == 0 && com_tencent_mm_protocal_c_bjk.wMz == 0)) {
                return w;
            }
            bjd com_tencent_mm_protocal_c_bjd = new bjd();
            com_tencent_mm_protocal_c_bjd.wMs = com_tencent_mm_protocal_c_bjk.wMz;
            com_tencent_mm_protocal_c_bjd.wMi = n.os(bh.az(str, ""));
            try {
                w.wCY = new bdn().bj(com_tencent_mm_protocal_c_bjd.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            biv com_tencent_mm_protocal_c_biv = new biv();
            com_tencent_mm_protocal_c_biv.wMi = n.os(bh.az(str, ""));
            try {
                w.wCY = new bdn().bj(com_tencent_mm_protocal_c_biv.toByteArray());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            int i2 = (obj == null || !(obj instanceof com.tencent.mm.plugin.sns.storage.a.b.a)) ? 0 : 1;
            if (i2 != 0) {
                com.tencent.mm.plugin.sns.storage.a.b.a aVar = (com.tencent.mm.plugin.sns.storage.a.b.a) obj;
                str2 = bh.az(str, "") + ("&" + aVar.qQK + "|" + aVar.reu);
            } else {
                str2 = str;
            }
            biy com_tencent_mm_protocal_c_biy = new biy();
            com_tencent_mm_protocal_c_biy.wMi = n.os(bh.az(str2, ""));
            if (mVar != null) {
                com_tencent_mm_protocal_c_biy.vHW = mVar.byC();
                mVar = ae.bvv().Ll(mVar.bxW());
                if (mVar != null) {
                    str2 = f.a(mVar.bxV());
                } else {
                    x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{str2});
                    str2 = "";
                }
                com_tencent_mm_protocal_c_biy.wMk = n.os(bh.az(str2, ""));
            }
            if (i2 == 0 || ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).res != com.tencent.mm.plugin.sns.storage.a.b.a.reo) {
                ae.bvy().delete(j);
                ae.bvA().eM(j);
                if (i2 != 0) {
                    com_tencent_mm_protocal_c_biy.wMl = ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).res;
                }
            } else {
                com_tencent_mm_protocal_c_biy.wMl = com.tencent.mm.plugin.sns.storage.a.b.a.reo;
            }
            try {
                w.wCY = new bdn().bj(com_tencent_mm_protocal_c_biy.toByteArray());
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (com_tencent_mm_protocal_c_bjk == null || (com_tencent_mm_protocal_c_bjk.wMw == 0 && com_tencent_mm_protocal_c_bjk.wMz == 0)) {
                return w;
            }
            bjz com_tencent_mm_protocal_c_bjz = new bjz();
            com_tencent_mm_protocal_c_bjz.wMw = com_tencent_mm_protocal_c_bjk.wMw;
            try {
                w.wCY = new bdn().bj(com_tencent_mm_protocal_c_bjz.toByteArray());
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            bki com_tencent_mm_protocal_c_bki = new bki();
            if (obj instanceof com.tencent.mm.bq.b) {
                com.tencent.mm.bq.b bVar = (com.tencent.mm.bq.b) obj;
                com_tencent_mm_protocal_c_bki.wNO = n.N(bVar.oz);
                x.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.oz.length);
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_bki.toByteArray();
                w.wCY = new bdn().bj(toByteArray);
                x.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Throwable e2222) {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof bju) {
                bju com_tencent_mm_protocal_c_bju = (bju) obj;
                try {
                    w.wCY = n.N(com_tencent_mm_protocal_c_bju.toByteArray());
                    x.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + com_tencent_mm_protocal_c_bju.wMV);
                } catch (Exception e3) {
                    x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e3.getMessage());
                }
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        return w;
    }

    private static bjy w(long j, int i) {
        bjy com_tencent_mm_protocal_c_bjy = new bjy();
        com_tencent_mm_protocal_c_bjy.wCY = new bdn();
        com_tencent_mm_protocal_c_bjy.vPO = j;
        com_tencent_mm_protocal_c_bjy.nhx = i;
        return com_tencent_mm_protocal_c_bjy;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 218;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            m eR;
            bjv com_tencent_mm_protocal_c_bjv;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    ae.bvu().eE(this.qTW);
                    ae.bvv().delete(this.qTW);
                    break;
                case 2:
                    eR = ae.bvv().eR(this.qTW);
                    if (eR != null) {
                        eR.field_pravited = 1;
                        eR.byk();
                        ae.bvv().b(this.qTW, eR);
                        break;
                    }
                    break;
                case 3:
                    eR = ae.bvv().eR(this.qTW);
                    if (eR != null) {
                        eR.field_pravited = 0;
                        eR.field_localPrivate = 0;
                        eR.byn();
                        ae.bvv().b(this.qTW, eR);
                        break;
                    }
                    break;
                case 4:
                    m eR2 = ae.bvv().eR(this.qTW);
                    if (eR2 != null) {
                        try {
                            com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eR2.field_attrBuf);
                            it = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                            while (it.hasNext()) {
                                obj = (bjk) it.next();
                                if (this.qTX != null && obj.wMw == this.qTX.wMw) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_bjv.wNd.remove(obj);
                                    }
                                    eR2.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                                    ae.bvv().z(eR2);
                                    ae.bvA().d(eR2.field_snsId, (long) this.qTX.wMw, this.qTX.ktN);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_bjv.wNd.remove(obj);
                            }
                            eR2.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                            ae.bvv().z(eR2);
                            ae.bvA().d(eR2.field_snsId, (long) this.qTX.wMw, this.qTX.ktN);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    ae.bvu().eG(this.qTW);
                    break;
                case 6:
                    c eK = ae.bvy().eK(this.qTW);
                    if (eK != null) {
                        try {
                            com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eK.field_attrBuf);
                            it = com_tencent_mm_protocal_c_bjv.wNd.iterator();
                            while (it.hasNext()) {
                                obj = (bjk) it.next();
                                if (this.qTX != null && obj.wMz == this.qTX.wMz) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_bjv.wNd.remove(obj);
                                    }
                                    eK.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                                    ae.bvy().a(eK);
                                    ae.bvA().d(eK.field_snsId, this.qTX.wMz, this.qTX.ktN);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_bjv.wNd.remove(obj);
                            }
                            eK.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
                            ae.bvy().a(eK);
                            ae.bvA().d(eK.field_snsId, this.qTX.wMz, this.qTX.ktN);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    ae.bvu().eG(this.qTW);
                    break;
                case 8:
                    if (!(this.qTY != null && (this.qTY instanceof com.tencent.mm.plugin.sns.storage.a.b.a) && ((com.tencent.mm.plugin.sns.storage.a.b.a) this.qTY).res == com.tencent.mm.plugin.sns.storage.a.b.a.reo)) {
                        ae.bvy().delete(this.qTW);
                        ae.bvA().eM(this.qTW);
                        break;
                    }
                case 9:
                    eR = ae.bvv().eR(this.qTW);
                    if (eR != null) {
                        eR.xm(2);
                        ae.bvv().b(this.qTW, eR);
                        break;
                    }
                    break;
                case 11:
                    x.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.qTZ);
                    if (this.qTZ == 0) {
                        g.Dk();
                        g.Dj().CU().a(w.a.xqI, Boolean.valueOf(true));
                    } else if (this.qTZ == 1) {
                        g.Dk();
                        g.Dj().CU().a(w.a.xqI, Boolean.valueOf(false));
                    }
                    g.Dk();
                    int intValue = ((Integer) g.Dj().CU().get(w.a.xqK, Integer.valueOf(0))).intValue();
                    g.Dk();
                    g.Dj().CU().a(w.a.xqK, Integer.valueOf(intValue + 1));
                    g.Dk();
                    intValue = ((Integer) g.Dj().CU().get(w.a.xqL, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.qTZ == 0) {
                        intValue++;
                        i4 = (intValue * 2) + bc.CTRL_INDEX;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX;
                        }
                        if (i4 >= 200) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.qTZ == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + bc.CTRL_INDEX) + 1;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
                        }
                        if (i4 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    g.Dk();
                    g.Dj().CU().a(w.a.xqL, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.qTY != null && (this.qTY instanceof bju)) {
                        ae.bvA().q(this.qTW, ((bju) this.qTY).wMV == 1);
                        x.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[]{Long.valueOf(this.qTW), Boolean.valueOf(r0)});
                        break;
                    }
            }
            ae.bvu().buW();
            this.gJT.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    ae.bvu().eE(this.qTW);
                    break;
                case 5:
                case 7:
                    ae.bvu().eG(this.qTW);
                    break;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
