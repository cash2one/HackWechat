package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aq implements a {
    boolean hUF;
    boolean hUG;
    f hUJ;
    ax qXC;
    LinkedList<ax> qXD;
    Map<String, ax> qXE;
    LinkedList<m> qXF;
    c qXG;
    c qXs;
    c qXt;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Object[] htc;
        final /* synthetic */ aq qXH;
        final /* synthetic */ String qXI;

        public AnonymousClass5(aq aqVar, String str, Object[] objArr) {
            this.qXH = aqVar;
            this.qXI = str;
            this.htc = objArr;
        }

        public final void run() {
            o.TV().b(this.qXI, this.htc);
            if (this.qXH.qXC != null && bh.fu(this.qXH.qXC.hTu, this.qXI)) {
                aq.a(this.qXH);
            }
            this.qXH.qXD.remove((ax) this.qXH.qXE.get(this.qXI));
        }
    }

    static /* synthetic */ void a(aq aqVar) {
        g.Dk();
        g.Dm().F(new 8(aqVar));
    }

    static /* synthetic */ j b(m mVar, int i, String str) {
        if (mVar == null) {
            return null;
        }
        aqr com_tencent_mm_protocal_c_aqr = (aqr) mVar.bxV().wQo.vYd.get(0);
        String byq = mVar.byq();
        String a = ap.a(byq, com_tencent_mm_protocal_c_aqr);
        if (bh.ov(a)) {
            boolean bS = e.bS(ap.Kt(com_tencent_mm_protocal_c_aqr.nGJ));
            a = ap.D(com_tencent_mm_protocal_c_aqr);
            r Ku = ap.Ku(byq);
            if (Ku == null) {
                ap.ce(byq, 30);
            } else {
                ap.c(Ku, 30);
            }
            x.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", a, Boolean.valueOf(bS));
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(com_tencent_mm_protocal_c_aqr.nGJ);
            aVar.qTV = com_tencent_mm_protocal_c_aqr;
            an ciT = an.ciT();
            ciT.time = mVar.field_createTime;
            aVar.qYC = ciT;
            aVar.qYA = true;
            aVar.url = com_tencent_mm_protocal_c_aqr.nfX;
            int i2 = com_tencent_mm_protocal_c_aqr.ktN;
            aVar.qYz = false;
            n.TS();
            o.TV();
            j a2 = com.tencent.mm.modelcdntran.f.a(aVar.qYC, aVar.url, a, ap.ns(byq), 2);
            if (a2 == null) {
                return null;
            }
            a2.fek = com_tencent_mm_protocal_c_aqr.wxZ;
            a2.field_preloadRatio = i;
            a2.fzW = str;
            String str2 = mVar.field_userName;
            a2.htK = str2;
            a2.fzO = str2;
            return a2;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", a);
        o.TW().a(com_tencent_mm_protocal_c_aqr.wxZ, 3, (long) e.bN(a), mVar.field_userName, "", 0, "", com_tencent_mm_protocal_c_aqr.nfX, str);
        com.tencent.mm.plugin.report.service.g.pQN.a(354, 147, 1, false);
        return null;
    }

    public aq() {
        this.qXD = null;
        this.qXE = null;
        this.hUJ = null;
        this.qXF = null;
        this.hUF = false;
        this.hUG = false;
        this.qXG = new c<kz>(this) {
            final /* synthetic */ aq qXH;

            {
                this.qXH = r2;
                this.xen = kz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                kz kzVar = (kz) bVar;
                if (this.qXH.qXC != null && bh.fu(this.qXH.qXC.hTu, kzVar.fCj.mediaId)) {
                    if (kzVar.fCj.retCode != 0) {
                        this.qXH.bwb();
                    } else if (kzVar.fCj.fuL == 4 || kzVar.fCj.fuL == 6) {
                        aq.a(this.qXH);
                    }
                }
                return false;
            }
        };
        this.qXs = new 10(this);
        this.qXt = new c<ar>(this) {
            final /* synthetic */ aq qXH;

            {
                this.qXH = r2;
                this.xen = ar.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ar arVar = (ar) bVar;
                this.qXH.hUF = arVar.foP.foQ;
                x.d("MicroMsg.SnsVideoService", "set isInChatting:%b", Boolean.valueOf(this.qXH.hUF));
                if (this.qXH.hUG || this.qXH.hUF) {
                    this.qXH.bwa();
                }
                if (!(this.qXH.hUF || this.qXH.hUG)) {
                    this.qXH.bvZ();
                }
                i TW = o.TW();
                TW.hUF = this.qXH.hUF;
                if (TW.hUF) {
                    TW.stopDownload();
                } else {
                    TW.TN();
                }
                return false;
            }
        };
        this.qXC = null;
        this.qXD = new LinkedList();
        this.qXE = new HashMap();
        this.qXF = new LinkedList();
        com.tencent.mm.sdk.b.a.xef.b(this.qXG);
        com.tencent.mm.sdk.b.a.xef.b(this.qXs);
        com.tencent.mm.sdk.b.a.xef.b(this.qXt);
    }

    public final void bvZ() {
        g.Dm().F(new 3(this));
    }

    public final void bwa() {
        x.d("MicroMsg.SnsVideoService", "%d stop preload %s", Integer.valueOf(hashCode()), bh.cgy());
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ aq qXH;

            {
                this.qXH = r1;
            }

            public final void run() {
                if (this.qXH.hUJ != null) {
                    this.qXH.hUJ.stop();
                }
                this.qXH.hUJ = null;
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            return;
        }
        if (this.hUJ != fVar) {
            x.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        x.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.TM(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ aq qXH;

            public final void run() {
                String str = fVar.frH;
                synchronized (this.qXH.qXF) {
                    Iterator it = this.qXH.qXF.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        if (mVar != null && bh.fu(str, mVar.byq())) {
                            x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", Integer.valueOf(this.qXH.hashCode()), str);
                            it.remove();
                        }
                    }
                }
                o.TW().bY(false);
                if (this.qXH.hUJ != null) {
                    this.qXH.hUJ.hUk = null;
                }
                this.qXH.hUJ = null;
                this.qXH.dv(130, 1);
                this.qXH.bvZ();
            }
        });
    }

    final boolean dv(int i, int i2) {
        int i3;
        long Wq = bh.Wq();
        x.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(bh.Wo() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("SnSPreLoadVideoExpiredTime", 1)) * 86400)));
        List<r> a = o.TU().a(130, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i4 = 0;
        for (r rVar : a) {
            if (rVar != null) {
                try {
                    int i5;
                    String D = ap.D((aqr) ae.bvv().Lm(ap.Ks(rVar.getFileName())).bxV().wQo.vYd.get(0));
                    if (!bh.ov(D)) {
                        File file = new File(D);
                        if (file.exists()) {
                            long length = file.length();
                            x.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fzU), Long.valueOf(rVar.hVF), D);
                            if (length > 0 && length <= ((long) rVar.fzU)) {
                                file.delete();
                                i5 = i4 + 1;
                                rVar.fzU = 0;
                                rVar.fDt = 1;
                                t.e(rVar);
                                i4 = i5;
                            }
                        }
                    }
                    i5 = i4;
                    try {
                        rVar.fzU = 0;
                        rVar.fDt = 1;
                        t.e(rVar);
                        i4 = i5;
                    } catch (Exception e) {
                        i3 = i5;
                        i4 = i3;
                    }
                } catch (Exception e2) {
                    i3 = i4;
                    i4 = i3;
                }
            }
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(354, 145, (long) i4, false);
        x.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i4), Long.valueOf(bh.bA(Wq)));
        return false;
    }

    public final boolean a(aqr com_tencent_mm_protocal_c_aqr, int i, String str, boolean z, final boolean z2, int i2) {
        int i3 = 0;
        if (com_tencent_mm_protocal_c_aqr.wxD == 2) {
            x.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            return false;
        }
        final ax axVar = new ax();
        axVar.hTu = ap.aF(i, com_tencent_mm_protocal_c_aqr.nfX);
        axVar.fHC = com_tencent_mm_protocal_c_aqr;
        axVar.hzW = i;
        axVar.frH = str;
        if (z) {
            i3 = 1;
        }
        axVar.htJ = i3;
        axVar.htL = i2;
        g.Dk();
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ aq qXH;

            public final void run() {
                m Lm = ae.bvv().Lm(axVar.frH);
                axVar.qYy = Lm != null ? Lm.field_userName : "";
                x.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", Boolean.valueOf(z2), axVar);
                if (z2) {
                    this.qXH.qXD.offerFirst(axVar);
                } else {
                    this.qXH.qXD.offerLast(axVar);
                }
                this.qXH.qXE.put(axVar.hTu, axVar);
            }
        });
        if (z2) {
            bwb();
        }
        return true;
    }

    final void bwb() {
        g.Dk();
        g.Dm().F(new 7(this));
    }

    final boolean a(ax axVar, boolean z) {
        if (bh.ov(ap.a(axVar.frH, axVar.fHC))) {
            boolean bS = e.bS(ap.Kt(axVar.fHC.nGJ));
            String D = ap.D(axVar.fHC);
            r Ku = ap.Ku(axVar.frH);
            if (Ku == null) {
                ap.ce(axVar.frH, axVar.htL);
            } else {
                ap.c(Ku, axVar.htL);
            }
            x.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", D, Boolean.valueOf(bS));
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(axVar.fHC.nGJ);
            aVar.qTV = axVar.fHC;
            an ciT = an.ciT();
            ciT.time = axVar.hzW;
            aVar.qYC = ciT;
            aVar.qYA = true;
            aVar.url = axVar.fHC.nfX;
            int i = axVar.fHC.ktN;
            aVar.qYz = false;
            n.TS();
            o.TV();
            j a = com.tencent.mm.modelcdntran.f.a(aVar.qYC, aVar.url, D, ap.ns(axVar.frH), axVar.htJ);
            if (a == null) {
                return false;
            }
            D = axVar.qYy;
            a.htK = D;
            a.fzO = D;
            try {
                bjv m = ai.m(ae.bvv().Lm(axVar.frH));
                if (m != null) {
                    a.fzW = m.vPO;
                    a.htO = m.wNp.wEL;
                }
            } catch (Exception e) {
            }
            this.qXC = axVar;
            this.qXC.hTu = a.field_mediaId;
            x.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", this.qXC.hTu, Boolean.valueOf(z));
            o.TV().a(a, z);
            return true;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", axVar.hTu, axVar.frH, ap.a(axVar.frH, axVar.fHC));
        return false;
    }
}
