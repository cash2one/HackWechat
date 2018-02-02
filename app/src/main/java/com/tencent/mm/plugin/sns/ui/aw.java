package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.ae.k;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.uo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.a.b;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aw extends b<ay, m> {
    private boolean DEBUG = false;
    ar hhy;
    Context mContext;
    volatile String maQ = "";
    String rIa;
    av rJk;
    private int rJl = ((int) (System.currentTimeMillis() / 1000));
    private a rJm;
    private boolean rJn = false;
    volatile boolean rJo = false;
    byte[] rJp = new byte[0];
    protected HashMap<String, String> rJq = new HashMap();
    public HashMap<String, Boolean> rJr = new HashMap();
    private String rJs = "";
    private String rJt = "";
    volatile String rwz = "";

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (m) obj;
        if (obj == null) {
            obj = new m();
        }
        obj.b(cursor);
        return obj;
    }

    protected final /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        aUn();
        this.BA = cursor;
    }

    public final /* synthetic */ Object xO(int i) {
        return xN(i);
    }

    public aw() {
        super(new m());
        czD();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bBr() {
        long j;
        looperCheckForVending();
        if (this.mCount == 0) {
            j = 0;
        } else {
            int i = this.mCount - 1;
            int i2 = 0;
            while (true) {
                m mVar = (m) getItem(i);
                if (mVar != null && !mVar.xl(32) && mVar.field_snsId != 0) {
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            j = 0;
        }
        this.rJo = true;
        synchronized (this.rJp) {
            this.maQ = q(j, this.maQ);
        }
    }

    String q(long j, String str) {
        x.d("MicroMsg.SnsTimeLineVendingSide", "updateLitmitSeq %s %s", new Object[]{Integer.valueOf(ae.bvl().bvU()), str});
        String er = i.er(ae.bvv().d(j, str.equals("") ? ae.bvl().bvU() / 2 : ae.bvl().bvU(), false));
        String str2 = this.rwz;
        if (!str2.equals("") && er.compareTo(str2) >= 0) {
            er = str2;
        }
        uo byh = ae.bvz().Lq("@__weixintimtline").byh();
        if (byh.wcx == 0) {
            return er;
        }
        str2 = i.er(byh.wcx);
        if (er.equals("")) {
            return str2;
        }
        if (str2.compareTo(er) > 0) {
            return str2;
        }
        return er;
    }

    private ay xN(int i) {
        if (i < 0) {
            return null;
        }
        x.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", new Object[]{Integer.valueOf(i)});
        long currentTimeMillis = System.currentTimeMillis();
        ay ayVar = new ay();
        m mVar = (m) super.getItem(i);
        if (mVar == null) {
            x.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCount)});
            return ayVar;
        }
        com.tencent.mm.plugin.sns.storage.b bxR;
        int width;
        f Ec;
        String str;
        a WN;
        a aVar;
        String AQ;
        com.tencent.mm.plugin.sns.storage.b bxR2;
        boolean z;
        com.tencent.mm.plugin.sns.storage.a bxT;
        Iterator it;
        StringBuffer stringBuffer;
        Iterator it2;
        Object obj;
        bjk com_tencent_mm_protocal_c_bjk;
        a WN2;
        com.tencent.mm.vending.d.b.a aVar2;
        bjr com_tencent_mm_protocal_c_bjr;
        a WN3;
        com.tencent.mm.vending.d.b.a aVar3;
        Iterator it3;
        Object AQ2;
        com.tencent.mm.plugin.sns.storage.a aVar4;
        String AQ3;
        aqs byi;
        long currentTimeMillis2;
        bnp bxV = mVar.bxV();
        bjv n = ai.n(mVar);
        int d = av.d(bxV);
        ayVar.aac = d;
        ayVar.rJK = mVar.field_snsId;
        ayVar.rJO = mVar.field_likeFlag;
        ayVar.rJP = mVar.bym();
        ayVar.rJQ = mVar.byz();
        ayVar.qyg = mVar;
        ayVar.qyk = bxV;
        ayVar.qyf = n;
        String str2 = ayVar.qyk.wQl;
        Context context = this.mContext;
        d.bCF();
        CharSequence a = e.a(context, str2, d.getTextSize());
        ayVar.rJH = a;
        int bCH = d.bCF().bCH();
        if (i < this.rJk.getCount()) {
            m mVar2 = (m) super.getItem(i);
            if (mVar2 != null && mVar2.xl(32)) {
                bxR = mVar2.bxR();
                if (bxR != null && bxR.reX == 1) {
                    width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bv.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mContext, 12);
                    if (this.DEBUG) {
                        x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
                    }
                    Ec = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bCF().bCE()).Ec();
                    c.gTj.a(d.bCF().bCE(), Ec);
                    if (Ec.gTO.getLineCount() > 6) {
                        c.gTj.a(d.bCF().bCG(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bCF().bCG()).Ec());
                    }
                    a(i, ayVar);
                    if (ayVar.qyg.xl(32)) {
                        ae.bvs().a(mVar, null);
                    } else {
                        ae.bvs().b(mVar, null);
                    }
                    f(ayVar.qyk);
                    str = mVar.field_userName;
                    WN = this.hhy.WN(str);
                    if (str != null) {
                        if (str.equals(this.rIa)) {
                            aVar = WN;
                        } else if (this.rJm != null) {
                            this.rJm = WN;
                            aVar = WN;
                        } else {
                            aVar = this.rJm;
                        }
                        AQ = aVar != null ? str : aVar.AQ();
                        if (mVar.xl(32) && bh.ov(AQ)) {
                            bxR2 = mVar.bxR();
                            if (!(bxR2 == null || bh.ov(bxR2.fpL))) {
                                AQ = bxR2.fpL;
                            }
                        }
                        ayVar.jKk = str;
                        ayVar.rJY = AQ;
                        ayVar.rrf = mVar.xl(32);
                        ayVar.rsD = mVar.byq();
                        z = aVar != null ? true : ((int) aVar.gJd) != 0;
                        ayVar.rJZ = z;
                        ayVar.rJI = aVar;
                    }
                    ayVar.rJJ = mVar.bxW();
                    ayVar.rJL = bxV.wQl;
                    ayVar.rJM = bxV.wQq;
                    ayVar.rJN = mVar.field_createTime;
                    ayVar.rJR = az.f(this.mContext, ((long) ayVar.rJN) * 1000);
                    ayVar.rKb = false;
                    if (!(d != 11 || q.FS().equals(bxV.ksU) || n.wNo == null || n.wNo.wNQ == 0)) {
                        ayVar.rKc = n.wNo.wNQ;
                        ayVar.rKb = true;
                    }
                    if (ayVar.rrf) {
                        AQ = bxV.wQm != null ? null : bxV.wQm.hvv;
                        str = bxV.wQm != null ? null : bxV.wQm.nTe;
                        if (bh.ov(str)) {
                            if (mVar.field_snsId == 0 || bh.ov(AQ)) {
                                ayVar.rKe = str;
                            } else {
                                ayVar.rKe = AQ + "·" + str;
                            }
                            ayVar.rKf = true;
                        } else {
                            ayVar.rKe = AQ;
                            ayVar.rKf = false;
                        }
                    } else {
                        bxT = mVar.bxT();
                        if (bxT != null) {
                            ayVar.rKe = bxT.rdT;
                            if (bh.ov(bxT.rdU)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ayVar.rKf = z;
                        }
                    }
                    str2 = f(bxV);
                    if (!com.tencent.mm.plugin.sns.c.a.ift.cz(str2) && g(bxV)) {
                        ayVar.rKg = true;
                        boolean z2 = true;
                        if (bxV.wQn == null) {
                            z = false;
                        } else {
                            if (!this.rJr.containsKey(bxV.wQn.nGJ)) {
                                if (!g.cA(bxV.wQn.nGJ)) {
                                    z = g.RB(bxV.wQn.nGJ);
                                    if (!z) {
                                        z2 = false;
                                    }
                                } else if (bxV.wQn.vHN == 0) {
                                    z = false;
                                    z2 = false;
                                } else {
                                    z = true;
                                    z2 = true;
                                }
                                this.rJr.put(bxV.wQn.nGJ, Boolean.valueOf(z));
                            } else if (!((Boolean) this.rJr.get(bxV.wQn.nGJ)).booleanValue()) {
                                z = false;
                            }
                            z = z2;
                        }
                        ayVar.mAppName = str2;
                        ayVar.rKi = z;
                    } else if (bh.ov(bxV.wQp) && g(bxV)) {
                        ayVar.mAppName = str2;
                        ayVar.rKh = true;
                        ayVar.rKk = bxV.vmT;
                        ayVar.rKj = bxV.wQp;
                    } else {
                        ayVar.rKg = false;
                        ayVar.rKh = false;
                    }
                    if (!(bxV.qYw == null || bh.ov(bxV.qYw.tnm))) {
                        ayVar.mAppName = h.NT("discoverRecommendEntry").optString("wording");
                        ayVar.rKg = true;
                    }
                    z = ayVar.jKk == null && ayVar.jKk.equals(this.rIa);
                    ayVar.rKa = z;
                    ayVar.rKm = mVar.bys();
                    ayVar.rKn = mVar.byi().wyj;
                    ayVar.rKo = false;
                    if (n != null && ayVar.rKa) {
                        width = n.wzw;
                        if (width == 3 || width == 5) {
                            ayVar.rKo = true;
                        }
                    }
                    if (n != null) {
                        if (n.wNg.size() > 0) {
                            if (this.rIa.equals(n.vIy)) {
                                it = n.wNg.iterator();
                                while (it.hasNext()) {
                                    if (this.rIa.equals(((bjk) it.next()).vIy)) {
                                        ayVar.rKp = true;
                                        ayVar.rKr = true;
                                        break;
                                    }
                                }
                            }
                            ayVar.rKp = true;
                            stringBuffer = new StringBuffer();
                            it2 = n.wNg.iterator();
                            obj = null;
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                                if (obj != null) {
                                    obj = 1;
                                    stringBuffer.append("  ");
                                } else {
                                    stringBuffer.append(",  ");
                                }
                                if (com_tencent_mm_protocal_c_bjk.wvW == null) {
                                    stringBuffer.append(com_tencent_mm_protocal_c_bjk.wvW);
                                } else {
                                    WN2 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                                    stringBuffer.append(WN2 != null ? com_tencent_mm_protocal_c_bjk.vIy : WN2.AQ());
                                }
                            }
                            ayVar.rKq = stringBuffer.toString();
                        } else {
                            ayVar.rKp = false;
                        }
                        if (n.wNo != null && q.FS().equals(bxV.ksU) && n.wNo.wNQ > 0) {
                            ayVar.rKu = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
                            ayVar.rKt = n.wNo.wNQ;
                            ayVar.rKs = true;
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.wNo.wNR.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bjr = (bjr) it2.next();
                                WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjr.vIy);
                                if (WN3 == null) {
                                    obj = bh.ou(WN3.AQ());
                                } else {
                                    obj = bh.ou(com_tencent_mm_protocal_c_bjr.vIy);
                                }
                                aVar2.s(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.v(com_tencent_mm_protocal_c_bjr.vIy, obj)});
                            }
                            ayVar.rKv = aVar2.czO();
                        }
                        if (n.wNa.size() > 0) {
                            aVar2 = new com.tencent.mm.vending.d.b.a();
                            it2 = n.wNa.iterator();
                            while (it2.hasNext()) {
                                com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                                WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                                if (WN3 == null) {
                                    obj = bh.ou(WN3.AQ());
                                } else {
                                    obj = bh.ou(com_tencent_mm_protocal_c_bjk.vIy);
                                }
                                aVar2.s(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.v(com_tencent_mm_protocal_c_bjk.vIy, obj)});
                            }
                            ayVar.rKw = aVar2.czO();
                        }
                        if (n.wNd.size() > 0) {
                            aVar3 = new com.tencent.mm.vending.d.b.a();
                            it3 = n.wNd.iterator();
                            while (it3.hasNext()) {
                                com_tencent_mm_protocal_c_bjk = (bjk) it3.next();
                                long j = com_tencent_mm_protocal_c_bjk.wMw == 0 ? (long) com_tencent_mm_protocal_c_bjk.wMw : com_tencent_mm_protocal_c_bjk.wMz;
                                String str3 = com_tencent_mm_protocal_c_bjk.vIy;
                                if (com_tencent_mm_protocal_c_bjk.vIy.equals(this.rIa)) {
                                    WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                                } else if (this.rJm != null) {
                                    WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                                    this.rJm = WN3;
                                } else {
                                    WN3 = this.rJm;
                                }
                                if (WN3 != null) {
                                    AQ2 = WN3.AQ();
                                } else {
                                    str2 = com_tencent_mm_protocal_c_bjk.wvW == null ? com_tencent_mm_protocal_c_bjk.wvW : com_tencent_mm_protocal_c_bjk.vIy;
                                }
                                String str4 = com_tencent_mm_protocal_c_bjk.nje;
                                CharSequence charSequence = (CharSequence) ayVar.rJG.qQQ.get(com_tencent_mm_protocal_c_bjk.wMw + "-" + com_tencent_mm_protocal_c_bjk.wMz + "-" + com_tencent_mm_protocal_c_bjk.nje);
                                com.tencent.mm.vending.j.a[] aVarArr = new com.tencent.mm.vending.j.a[1];
                                Long valueOf = Long.valueOf(j);
                                com.tencent.mm.vending.j.a fVar = new com.tencent.mm.vending.j.f();
                                fVar.zDa = new Object[]{valueOf, str3, AQ2, str4, charSequence};
                                aVarArr[0] = (com.tencent.mm.vending.j.f) fVar;
                                aVar3.s(aVarArr);
                            }
                            ayVar.rKx = aVar3.czO();
                        }
                    }
                    ag.a(this.mContext, ayVar, bxV.qYu);
                    if (ayVar.rrf) {
                        ayVar.rJS = mVar.bxT();
                        ayVar.rJT = mVar.bxR();
                        bxR = mVar.bxR();
                        ayVar.rJU = bxR == null ? bxR.rev : "";
                    }
                    if (ayVar.rrf) {
                        aVar4 = ayVar.rJS;
                        if (ayVar.rJS.rdV != com.tencent.mm.plugin.sns.storage.a.rdH) {
                            ayVar.rJV = aVar4.rdW;
                        } else if (aVar4.rdV == com.tencent.mm.plugin.sns.storage.a.rdI && !bh.ov(aVar4.rdW)) {
                            str = "";
                            it2 = aVar4.rdY.iterator();
                            while (it2.hasNext()) {
                                AQ = (String) it2.next();
                                WN2 = ae.bvj().WN(AQ);
                                if (WN2 == null) {
                                    AQ3 = WN2.AQ();
                                    if (bh.ov(AQ3)) {
                                        str = str + AQ3;
                                    } else {
                                        str = str + AQ;
                                    }
                                } else {
                                    str = str + AQ;
                                }
                                if (aVar4.rdY.getLast() != AQ) {
                                    str = str + ",";
                                }
                            }
                            ayVar.rJX = str;
                            ayVar.rJW = String.format(aVar4.rdW, new Object[]{str});
                        }
                    }
                    byi = mVar.byi();
                    ayVar.rKA = byi;
                    if (!(byi == null || q.FS().equals(bxV.ksU) || !com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n))) {
                        ayVar.rKd = true;
                    }
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
                    return ayVar;
                }
            }
        }
        width = bCH;
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str2);
        }
        Ec = com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bCF().bCE()).Ec();
        c.gTj.a(d.bCF().bCE(), Ec);
        if (Ec.gTO.getLineCount() > 6) {
            c.gTj.a(d.bCF().bCG(), com.tencent.mm.kiss.widget.textview.d.a(a, width, d.bCF().bCG()).Ec());
        }
        a(i, ayVar);
        if (ayVar.qyg.xl(32)) {
            ae.bvs().a(mVar, null);
        } else {
            ae.bvs().b(mVar, null);
        }
        f(ayVar.qyk);
        str = mVar.field_userName;
        WN = this.hhy.WN(str);
        if (str != null) {
            if (str.equals(this.rIa)) {
                aVar = WN;
            } else if (this.rJm != null) {
                aVar = this.rJm;
            } else {
                this.rJm = WN;
                aVar = WN;
            }
            if (aVar != null) {
            }
            bxR2 = mVar.bxR();
            AQ = bxR2.fpL;
            ayVar.jKk = str;
            ayVar.rJY = AQ;
            ayVar.rrf = mVar.xl(32);
            ayVar.rsD = mVar.byq();
            if (aVar != null) {
                if (((int) aVar.gJd) != 0) {
                }
            }
            ayVar.rJZ = z;
            ayVar.rJI = aVar;
        }
        ayVar.rJJ = mVar.bxW();
        ayVar.rJL = bxV.wQl;
        ayVar.rJM = bxV.wQq;
        ayVar.rJN = mVar.field_createTime;
        ayVar.rJR = az.f(this.mContext, ((long) ayVar.rJN) * 1000);
        ayVar.rKb = false;
        ayVar.rKc = n.wNo.wNQ;
        ayVar.rKb = true;
        if (ayVar.rrf) {
            if (bxV.wQm != null) {
            }
            if (bxV.wQm != null) {
            }
            if (bh.ov(str)) {
                ayVar.rKe = AQ;
                ayVar.rKf = false;
            } else {
                if (mVar.field_snsId == 0) {
                }
                ayVar.rKe = str;
                ayVar.rKf = true;
            }
        } else {
            bxT = mVar.bxT();
            if (bxT != null) {
                ayVar.rKe = bxT.rdT;
                if (bh.ov(bxT.rdU)) {
                    z = false;
                } else {
                    z = true;
                }
                ayVar.rKf = z;
            }
        }
        str2 = f(bxV);
        if (!com.tencent.mm.plugin.sns.c.a.ift.cz(str2)) {
        }
        if (bh.ov(bxV.wQp)) {
        }
        ayVar.rKg = false;
        ayVar.rKh = false;
        ayVar.mAppName = h.NT("discoverRecommendEntry").optString("wording");
        ayVar.rKg = true;
        if (ayVar.jKk == null) {
        }
        ayVar.rKa = z;
        ayVar.rKm = mVar.bys();
        ayVar.rKn = mVar.byi().wyj;
        ayVar.rKo = false;
        width = n.wzw;
        ayVar.rKo = true;
        if (n != null) {
            if (n.wNg.size() > 0) {
                ayVar.rKp = false;
            } else if (this.rIa.equals(n.vIy)) {
                it = n.wNg.iterator();
                while (it.hasNext()) {
                    if (this.rIa.equals(((bjk) it.next()).vIy)) {
                        ayVar.rKp = true;
                        ayVar.rKr = true;
                        break;
                    }
                }
            } else {
                ayVar.rKp = true;
                stringBuffer = new StringBuffer();
                it2 = n.wNg.iterator();
                obj = null;
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                    if (obj != null) {
                        stringBuffer.append(",  ");
                    } else {
                        obj = 1;
                        stringBuffer.append("  ");
                    }
                    if (com_tencent_mm_protocal_c_bjk.wvW == null) {
                        WN2 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                        if (WN2 != null) {
                        }
                        stringBuffer.append(WN2 != null ? com_tencent_mm_protocal_c_bjk.vIy : WN2.AQ());
                    } else {
                        stringBuffer.append(com_tencent_mm_protocal_c_bjk.wvW);
                    }
                }
                ayVar.rKq = stringBuffer.toString();
            }
            ayVar.rKu = ((double) com.tencent.mm.plugin.sns.lucky.a.m.b(mVar, n)) * 1.0d;
            ayVar.rKt = n.wNo.wNQ;
            ayVar.rKs = true;
            aVar2 = new com.tencent.mm.vending.d.b.a();
            it2 = n.wNo.wNR.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_bjr = (bjr) it2.next();
                WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjr.vIy);
                if (WN3 == null) {
                    obj = bh.ou(com_tencent_mm_protocal_c_bjr.vIy);
                } else {
                    obj = bh.ou(WN3.AQ());
                }
                aVar2.s(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.v(com_tencent_mm_protocal_c_bjr.vIy, obj)});
            }
            ayVar.rKv = aVar2.czO();
            if (n.wNa.size() > 0) {
                aVar2 = new com.tencent.mm.vending.d.b.a();
                it2 = n.wNa.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it2.next();
                    WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                    if (WN3 == null) {
                        obj = bh.ou(com_tencent_mm_protocal_c_bjk.vIy);
                    } else {
                        obj = bh.ou(WN3.AQ());
                    }
                    aVar2.s(new com.tencent.mm.vending.j.a[]{com.tencent.mm.vending.j.a.v(com_tencent_mm_protocal_c_bjk.vIy, obj)});
                }
                ayVar.rKw = aVar2.czO();
            }
            if (n.wNd.size() > 0) {
                aVar3 = new com.tencent.mm.vending.d.b.a();
                it3 = n.wNd.iterator();
                while (it3.hasNext()) {
                    com_tencent_mm_protocal_c_bjk = (bjk) it3.next();
                    if (com_tencent_mm_protocal_c_bjk.wMw == 0) {
                    }
                    String str32 = com_tencent_mm_protocal_c_bjk.vIy;
                    if (com_tencent_mm_protocal_c_bjk.vIy.equals(this.rIa)) {
                        WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                    } else if (this.rJm != null) {
                        WN3 = this.rJm;
                    } else {
                        WN3 = this.hhy.WN(com_tencent_mm_protocal_c_bjk.vIy);
                        this.rJm = WN3;
                    }
                    if (WN3 != null) {
                        AQ2 = WN3.AQ();
                    } else if (com_tencent_mm_protocal_c_bjk.wvW == null) {
                    }
                    String str42 = com_tencent_mm_protocal_c_bjk.nje;
                    CharSequence charSequence2 = (CharSequence) ayVar.rJG.qQQ.get(com_tencent_mm_protocal_c_bjk.wMw + "-" + com_tencent_mm_protocal_c_bjk.wMz + "-" + com_tencent_mm_protocal_c_bjk.nje);
                    com.tencent.mm.vending.j.a[] aVarArr2 = new com.tencent.mm.vending.j.a[1];
                    Long valueOf2 = Long.valueOf(j);
                    com.tencent.mm.vending.j.a fVar2 = new com.tencent.mm.vending.j.f();
                    fVar2.zDa = new Object[]{valueOf2, str32, AQ2, str42, charSequence2};
                    aVarArr2[0] = (com.tencent.mm.vending.j.f) fVar2;
                    aVar3.s(aVarArr2);
                }
                ayVar.rKx = aVar3.czO();
            }
        }
        ag.a(this.mContext, ayVar, bxV.qYu);
        if (ayVar.rrf) {
            ayVar.rJS = mVar.bxT();
            ayVar.rJT = mVar.bxR();
            bxR = mVar.bxR();
            if (bxR == null) {
            }
            ayVar.rJU = bxR == null ? bxR.rev : "";
        }
        if (ayVar.rrf) {
            aVar4 = ayVar.rJS;
            if (ayVar.rJS.rdV != com.tencent.mm.plugin.sns.storage.a.rdH) {
                str = "";
                it2 = aVar4.rdY.iterator();
                while (it2.hasNext()) {
                    AQ = (String) it2.next();
                    WN2 = ae.bvj().WN(AQ);
                    if (WN2 == null) {
                        str = str + AQ;
                    } else {
                        AQ3 = WN2.AQ();
                        if (bh.ov(AQ3)) {
                            str = str + AQ;
                        } else {
                            str = str + AQ3;
                        }
                    }
                    if (aVar4.rdY.getLast() != AQ) {
                        str = str + ",";
                    }
                }
                ayVar.rJX = str;
                ayVar.rJW = String.format(aVar4.rdW, new Object[]{str});
            } else {
                ayVar.rJV = aVar4.rdW;
            }
        }
        byi = mVar.byi();
        ayVar.rKA = byi;
        ayVar.rKd = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2)});
        return ayVar;
    }

    private String f(bnp com_tencent_mm_protocal_c_bnp) {
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 26) {
            return this.mContext.getString(j.eeE);
        }
        if (com_tencent_mm_protocal_c_bnp.wQn == null) {
            return "";
        }
        if (bh.ov(com_tencent_mm_protocal_c_bnp.wQn.nGJ)) {
            return "";
        }
        if (this.rJq.containsKey(com_tencent_mm_protocal_c_bnp.wQn.nGJ)) {
            return (String) this.rJq.get(com_tencent_mm_protocal_c_bnp.wQn.nGJ);
        }
        String a = g.a(this.mContext, g.cQ(com_tencent_mm_protocal_c_bnp.wQn.nGJ, bh.getInt(com_tencent_mm_protocal_c_bnp.wQn.ktA, 0)), null);
        if (bh.ov(a)) {
            return a;
        }
        this.rJq.put(com_tencent_mm_protocal_c_bnp.wQn.nGJ, a);
        return a;
    }

    private static boolean g(bnp com_tencent_mm_protocal_c_bnp) {
        if (!bh.ov(com_tencent_mm_protocal_c_bnp.wQp) && (al.a.bvV() & 2) > 0) {
            return false;
        }
        return true;
    }

    private void a(int i, ay ayVar) {
        List<bjk> list = ayVar.qyf.wNd;
        com.tencent.mm.kiss.widget.textview.a.a bCE = com.tencent.mm.plugin.sns.ui.widget.b.bCD().bCE();
        ayVar.rJG = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            x.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + list.size() + " commentData:" + ayVar.rJG.qQQ.size());
        }
        for (bjk com_tencent_mm_protocal_c_bjk : list) {
            String str;
            Object obj;
            int i2;
            c cVar = c.gTj;
            Context context = this.mContext;
            String str2 = ayVar.qyg.field_userName;
            String str3 = "";
            String a = com.tencent.mm.plugin.sns.ui.widget.c.a(com_tencent_mm_protocal_c_bjk);
            String str4 = com_tencent_mm_protocal_c_bjk.nje;
            com.tencent.mm.storage.x xVar = null;
            if (!bh.ov(str2)) {
                com.tencent.mm.kernel.g.Dk();
                xVar = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WM(str2);
            }
            if (com_tencent_mm_protocal_c_bjk.wMB == 1) {
                if (xVar != null) {
                    str = (a + context.getString(j.qKi)) + (xVar == null ? str2 : xVar.AQ());
                }
                str = a;
            } else {
                if (!bh.ov(com_tencent_mm_protocal_c_bjk.wMQ)) {
                    a WN = ae.bvj().WN(com_tencent_mm_protocal_c_bjk.wMQ);
                    str = (a + context.getString(j.qLZ)) + (WN == null ? com_tencent_mm_protocal_c_bjk.wMQ : WN.AQ());
                }
                str = a;
            }
            CharSequence charSequence = (str3 + str + ": ") + str4;
            if (bCE != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.gTk.get(Integer.valueOf(c.a(bCE)));
                if (bVar != null) {
                    LinkedList linkedList = (LinkedList) bVar.gTi.get(charSequence.toString());
                    if (linkedList == null || linkedList.size() == 0) {
                        obj = null;
                    } else {
                        i2 = 1;
                    }
                    if (obj == null) {
                        ayVar.rJG.a(com_tencent_mm_protocal_c_bjk, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, com_tencent_mm_protocal_c_bjk, this.rJk, ayVar.qyg.field_type, ayVar.qyg.field_userName));
                    } else {
                        com.tencent.mm.plugin.sns.ui.widget.b bCD;
                        charSequence = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, com_tencent_mm_protocal_c_bjk, this.rJk, ayVar.qyg.field_type, ayVar.qyg.field_userName);
                        ayVar.rJG.a(com_tencent_mm_protocal_c_bjk, charSequence);
                        bCD = com.tencent.mm.plugin.sns.ui.widget.b.bCD();
                        if (bCD.rRJ <= 0) {
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            i2 = displayMetrics.widthPixels;
                            int dimension = (int) (ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ) + ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ));
                            int dimension2 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qyM);
                            int dimension3 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ);
                            bCD.rRJ = ((i2 - dimension2) - dimension) - dimension3;
                            x.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + bCD.rRJ + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
                        }
                        i2 = bCD.rRJ;
                        if (i2 > 0) {
                            c.gTj.a(bCE, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, bCE).Ec());
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                charSequence = com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, com_tencent_mm_protocal_c_bjk, this.rJk, ayVar.qyg.field_type, ayVar.qyg.field_userName);
                ayVar.rJG.a(com_tencent_mm_protocal_c_bjk, charSequence);
                bCD = com.tencent.mm.plugin.sns.ui.widget.b.bCD();
                if (bCD.rRJ <= 0) {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    int dimension4 = (int) (ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ) + ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ));
                    int dimension22 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qyM);
                    int dimension32 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ);
                    bCD.rRJ = ((i2 - dimension22) - dimension4) - dimension32;
                    x.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i2 + " textViewWidth " + bCD.rRJ + " padding: " + dimension4 + " marginLeft: " + dimension22 + " thisviewPadding: " + dimension32);
                }
                i2 = bCD.rRJ;
                if (i2 > 0) {
                    c.gTj.a(bCE, com.tencent.mm.kiss.widget.textview.d.a(charSequence, i2, bCE).Ec());
                }
            } else {
                ayVar.rJG.a(com_tencent_mm_protocal_c_bjk, com.tencent.mm.plugin.sns.ui.widget.c.a(this.mContext, com_tencent_mm_protocal_c_bjk, this.rJk, ayVar.qyg.field_type, ayVar.qyg.field_userName));
            }
        }
    }

    protected final Cursor bBU() {
        if (!this.rJn) {
            synchronized (this.rJp) {
                this.maQ = q(0, this.maQ);
            }
            this.rJn = true;
        }
        int Lz = ae.bvv().Lz(this.maQ);
        x.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", new Object[]{Integer.valueOf(this.rJl), Integer.valueOf(Lz), this.maQ});
        if (this.rJl != Lz) {
            com.tencent.mm.plugin.sns.storage.f bvy = ae.bvy();
            String str = ("select *,rowid from AdSnsInfo  where createTime > " + Lz + " and createTime <= " + this.rJl) + " order by  createTime desc";
            x.d("MicroMsg.AdSnsInfoStorage", "getAdInTime " + str);
            Cursor rawQuery = bvy.gJP.rawQuery(str, null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.b(rawQuery);
                    m bxX = eVar.bxX();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    com.tencent.mm.plugin.sns.storage.e byB = bxX.byB();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(bxX.field_stringSeq);
                    stringBuffer.append(byB.field_adxml);
                    stringBuffer.append(" <createtime " + bxX.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + byB.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + byB.field_createAdTime + "> ");
                    stringBuffer.append(byB.bxV().wQl);
                    x.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a bxT = bxX.bxT();
                    int i2 = bxX.field_createTime;
                    boolean z = (eVar.field_localFlag & FileUtils.S_IWUSR) > 0;
                    if (bxT == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * bxT.rdL;
                        i = eVar.field_exposureTime;
                    } else {
                        j = 60 * bxT.rdK;
                        i = eVar.field_createAdTime;
                    }
                    long by = bh.by((long) i);
                    if (by >= j) {
                        Object obj;
                        bjv n = ai.n(bxX);
                        if (bxX.field_likeFlag == 0) {
                            Iterator it = n.wNd.iterator();
                            while (it.hasNext()) {
                                bjk com_tencent_mm_protocal_c_bjk = (bjk) it.next();
                                if (com_tencent_mm_protocal_c_bjk == null || bh.ov(com_tencent_mm_protocal_c_bjk.vIy) || !com_tencent_mm_protocal_c_bjk.vIy.equals(this.rIa)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                ae.bvy().delete(bxX.field_snsId);
                                x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bxX.field_snsId + " exposureTime: " + j + " field_createTime: " + bxX.field_createTime + " checktime: " + by + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                                if (!z) {
                                    linkedList.add(eVar);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                            ae.bvy().delete(bxX.field_snsId);
                            x.i("MicroMsg.SnsTimeLineVendingSide", "~~addelete the item " + bxX.field_snsId + " exposureTime: " + j + " field_createTime: " + bxX.field_createTime + " checktime: " + by + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                            if (z) {
                                linkedList.add(eVar);
                            }
                        }
                    }
                    long j2 = bxX.field_snsId;
                    x.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid " + j2);
                    if (l.ev(j2)) {
                        k lVar = new l(j2, 1, bxX.bxT().rek);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(lVar, 0);
                    }
                } while (rawQuery.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.plugin.sns.storage.e eVar2 = (com.tencent.mm.plugin.sns.storage.e) it2.next();
                        com.tencent.mm.protocal.c.bh bhVar = new com.tencent.mm.protocal.c.bh();
                        bhVar.vGy = 13298;
                        bhVar.vGz = new com.tencent.mm.bq.b(eVar2.bxT().qZM.getBytes());
                        bhVar.vGA = System.currentTimeMillis() / 1000;
                        linkedList2.add(bhVar);
                    }
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.plugin.sns.model.k(linkedList2), 0);
                }
            }
            if (rawQuery != null) {
                x.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + rawQuery.getCount());
                rawQuery.close();
            }
        }
        this.rJl = Lz;
        Cursor cg = ae.bvv().cg(this.maQ, Lz);
        x.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(500);
        if (iu.St()) {
            int i3 = this.mCount;
            if (i3 == 0) {
                iu.ix(0).ix(0).ix(0);
                iu.Sx();
            } else {
                int i4 = i3 - 1;
                String g = i.g((m) getItem(1));
                String g2 = i.g((m) getItem(i4));
                if (!(g.equals(this.rJs) && g2.equals(this.rJt))) {
                    this.rJs = g;
                    this.rJt = g2;
                    iu.ix(i3).mB(g).mB(g2);
                    iu.Sx();
                }
            }
        }
        return cg;
    }

    public final void destroyAsynchronous() {
        super.destroyAsynchronous();
        c.gTj.Eb();
        this.rJr.clear();
    }
}
