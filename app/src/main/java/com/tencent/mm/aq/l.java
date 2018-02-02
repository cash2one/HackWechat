package com.tencent.mm.aq;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Map;
import junit.framework.Assert;

public final class l extends k implements com.tencent.mm.network.k {
    public static boolean DEBUG = true;
    private static long hBO;
    private String TAG;
    public String fGJ;
    public au fnB;
    private float fzt;
    private final b gJQ;
    private e gJT;
    private long gLP;
    private int gLQ;
    private e gLR;
    private boolean gLX;
    private String hBD;
    private String hBE;
    private boolean hBF;
    private e hBG;
    private int hBH;
    b hBI;
    private String hBJ;
    private boolean hBK;
    private float hBL;
    private String hBM;
    private String hBN;
    private final f hBj;
    public long hBk;
    private h hBm;
    private String hBn;
    private int hBo;
    private int hBr;
    private a hBx;
    private int hzT;
    private long hzX;
    private int scene;
    private int startOffset;
    private long startTime;

    private e Pk() {
        if (this.gLR == null) {
            this.gLR = o.Pw().b(Long.valueOf(this.gLP));
        }
        return this.gLR;
    }

    private e Pl() {
        if (this.hBG == null) {
            this.hBG = o.Pw().b(Long.valueOf(this.hBk));
        }
        return this.hBG;
    }

    public l(String str, String str2, String str3, int i) {
        this(4, str, str2, str3, i, null, "", "");
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, a aVar, int i4) {
        this(3, str, str2, str3, i2, fVar, i3, "", "", true, i4);
        this.hBI = new b(this, aVar);
    }

    private l(int i, String str, String str2, String str3, int i2, f fVar, String str4, String str5) {
        this(4, str, str2, str3, i2, null, 0, str4, str5, false, -1);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, fVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hBD = "";
        this.hBE = "";
        this.hBF = true;
        this.hBH = 16384;
        this.hzT = 0;
        this.fnB = null;
        this.hBm = null;
        this.hBn = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hBo = 0;
        this.hBI = new b(this, null);
        this.hBx = new 4(this);
        this.gLX = false;
        x.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[]{Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(true), bh.cgy(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2)});
        this.hBK = z;
        this.hBr = i4;
        this.hBj = fVar;
        this.hzT = i2;
        this.scene = i5;
        this.fzt = f2;
        this.hBL = f;
        this.gLQ = i;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hBJ = str4;
        pString.value = str5;
        this.hBk = o.Pw().a(str3, i2, i, i3, pString, pInt, pInt2);
        this.gLP = this.hBk;
        x.i(this.TAG, "FROM A UI :" + str2 + " " + this.hBk);
        if (this.hBk < 0 || !i.hS((int) this.hBk)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.hBk);
            this.hzX = -1;
            this.gJQ = null;
            return;
        }
        e Pk;
        Assert.assertTrue(this.hBk >= 0);
        b.a aVar = new b.a();
        aVar.hmj = new bqt();
        aVar.hmk = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hmi = 110;
        aVar.hml = 9;
        aVar.hmm = 1000000009;
        this.gJQ = aVar.JZ();
        this.fGJ = str2;
        this.fnB = new au();
        this.fnB.setType(s.hq(str2));
        this.fnB.dS(str2);
        this.fnB.eR(1);
        this.fnB.eQ(1);
        this.fnB.dT(pString.value);
        this.fnB.fc(pInt.value);
        this.fnB.fd(pInt2.value);
        this.fnB.aq(ba.hR(this.fnB.field_talker));
        this.fnB.setContent(str4);
        com.tencent.mm.j.a.a.xD().b(this.fnB);
        this.hzX = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().Q(this.fnB);
        Assert.assertTrue(this.hzX >= 0);
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hzX);
        e Pl = Pl();
        Pl.bf((long) ((int) this.hzX));
        o.Pw().a(Long.valueOf(this.hBk), Pl);
        if (i2 == 1) {
            this.gLP = (long) Pl.hzZ;
            Pk = Pk();
        } else {
            Pk = Pl;
        }
        Pk.hL(com.tencent.mm.a.e.bN(o.Pw().m(Pk.hzQ, "", "")));
        o.Pw().a(Long.valueOf(this.gLP), Pk);
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gLP + " img len = " + Pk.hlp);
        bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqt.vGX = new bdo().UA(str);
        com_tencent_mm_protocal_c_bqt.vGY = new bdo().UA(str2);
        com_tencent_mm_protocal_c_bqt.vIC = Pk.offset;
        com_tencent_mm_protocal_c_bqt.vIB = Pk.hlp;
        com_tencent_mm_protocal_c_bqt.ngq = this.fnB.getType();
        com_tencent_mm_protocal_c_bqt.wmj = i2;
        com_tencent_mm_protocal_c_bqt.vWK = ab.bC(ac.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bqt.wOp = Pk.cOY;
        com_tencent_mm_protocal_c_bqt.vQD = Pk.hzU;
        com_tencent_mm_protocal_c_bqt.wSm = pInt2.value;
        com_tencent_mm_protocal_c_bqt.wSn = pInt.value;
        a lk = f.lk(str4);
        if (!(lk == null || bh.ov(lk.appId))) {
            com_tencent_mm_protocal_c_bqt.ngo = lk.appId;
            com_tencent_mm_protocal_c_bqt.vFC = lk.mediaTagName;
            com_tencent_mm_protocal_c_bqt.vFE = lk.messageAction;
            com_tencent_mm_protocal_c_bqt.vFD = lk.messageExt;
        }
        x.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSm), Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSn)});
        if (com_tencent_mm_protocal_c_bqt.vQD == 0) {
            com_tencent_mm_protocal_c_bqt.vQD = i == 4 ? 2 : 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(Pk.cOY), Integer.valueOf(com_tencent_mm_protocal_c_bqt.vQD)});
        if (Pk.offset == 0) {
            this.hBm = new h(110, true, (long) Pk.hlp);
        }
        long currentTimeMillis = System.currentTimeMillis();
        hV(i2);
        x.d(this.TAG, "hy: create HDThumb using %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (fVar != null) {
            final int i6 = Pk.offset;
            final int i7 = Pk.hlp;
            final f fVar2 = fVar;
            ag.y(new Runnable(this) {
                final /* synthetic */ l hBQ;

                public final void run() {
                    fVar2.a(i6, i7, this.hBQ);
                }
            });
        }
    }

    public l(long j, int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, int i4) {
        e Pk;
        String str6;
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hBD = "";
        this.hBE = "";
        this.hBF = true;
        this.hBH = 16384;
        this.hzT = 0;
        this.fnB = null;
        this.hBm = null;
        this.hBn = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hBo = 0;
        this.hBI = new b(this, null);
        this.hBx = new 4(this);
        this.gLX = false;
        x.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[]{Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(true), Integer.valueOf(i4), Boolean.valueOf(true), bh.cgy()});
        this.hBK = true;
        this.hBr = i4;
        this.hBj = fVar;
        this.hzT = i2;
        this.gLQ = 3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hBJ = str4;
        this.hBk = j;
        this.gLP = this.hBk;
        e Pl = Pl();
        this.fnB = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(Pl.hzX);
        this.hzX = this.fnB.field_msgId;
        pInt2.value = this.fnB.gjH;
        pInt.value = this.fnB.gjG;
        if (i2 == 1) {
            this.gLP = (long) Pl.hzZ;
            this.gLR = null;
            Pk = Pk();
        } else {
            Pk = Pl;
        }
        if (this.fnB.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            x.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[]{str2, this.fnB.field_talker});
            com.tencent.mm.plugin.report.service.g.pQN.a(594, 4, 1, true);
            str6 = this.fnB.field_talker;
        }
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fnB.field_msgId);
        x.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.hBk);
        if (this.hBk < 0 || !i.hS((int) this.hBk)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.hBk);
            this.hzX = -1;
            this.gJQ = null;
            return;
        }
        Assert.assertTrue(this.hBk >= 0);
        b.a aVar = new b.a();
        aVar.hmj = new bqt();
        aVar.hmk = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hmi = 110;
        aVar.hml = 9;
        aVar.hmm = 1000000009;
        this.gJQ = aVar.JZ();
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gLP + " img len = " + Pk.hlp);
        bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqt.vGX = new bdo().UA(str);
        com_tencent_mm_protocal_c_bqt.vGY = new bdo().UA(str6);
        com_tencent_mm_protocal_c_bqt.vIC = Pk.offset;
        com_tencent_mm_protocal_c_bqt.vIB = Pk.hlp;
        com_tencent_mm_protocal_c_bqt.ngq = this.fnB.getType();
        com_tencent_mm_protocal_c_bqt.wmj = i2;
        com_tencent_mm_protocal_c_bqt.vWK = ab.bC(ac.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bqt.wOp = Pk.cOY;
        com_tencent_mm_protocal_c_bqt.vQD = Pk.hzU;
        com_tencent_mm_protocal_c_bqt.wSm = pInt2.value;
        com_tencent_mm_protocal_c_bqt.wSn = pInt.value;
        x.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSm), Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSn)});
        if (com_tencent_mm_protocal_c_bqt.vQD == 0) {
            com_tencent_mm_protocal_c_bqt.vQD = 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(Pk.cOY), Integer.valueOf(com_tencent_mm_protocal_c_bqt.vQD)});
        if (Pk.offset == 0) {
            this.hBm = new h(110, true, (long) Pk.hlp);
        }
        if (fVar != null) {
            ag.y(new 3(this, fVar, Pk.offset, Pk.hlp));
        }
    }

    public final void hV(int i) {
        int i2 = 0;
        if (this.fnB == null) {
            x.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[]{Long.valueOf(this.hzX), Integer.valueOf(i)});
        } else if (!this.hBK) {
            o.Pw().a(this.fnB.field_imgPath, com.tencent.mm.bv.a.getDensity(ac.getContext()), true);
        } else if (this.fnB.gjK == 0) {
            boolean z;
            g Pw = o.Pw();
            cf cfVar = this.fnB;
            int i3 = this.hBr;
            String p = g.p(cfVar);
            if (bh.ov(p)) {
                z = false;
            } else {
                z = Pw.a(p, cfVar.field_imgPath, i3, i);
            }
            cfVar = this.fnB;
            if (z) {
                i2 = 1;
            }
            cfVar.gjK = i2;
            cfVar.gfw = true;
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.hzX, this.fnB);
        }
    }

    public l(int i, int i2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hBD = "";
        this.hBE = "";
        this.hBF = true;
        this.hBH = 16384;
        this.hzT = 0;
        this.fnB = null;
        this.hBm = null;
        this.hBn = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hBo = 0;
        this.hBI = new b(this, null);
        this.hBx = new 4(this);
        this.gLX = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bh.cgy()});
        this.hBk = (long) i;
        this.gLP = (long) i;
        this.hzT = i2;
        b.a aVar = new b.a();
        aVar.hmj = new bqt();
        aVar.hmk = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hmi = 110;
        aVar.hml = 9;
        aVar.hmm = 1000000009;
        this.gJQ = aVar.JZ();
        this.hBj = null;
        x.d(this.TAG, "FROM B SERVICE:" + this.hBk);
        if (i.hS((int) this.hBk)) {
            e b;
            e b2 = o.Pw().b(Long.valueOf(this.hBk));
            this.hzX = b2.hzX;
            if (i2 == 1) {
                this.gLP = (long) b2.hzZ;
                b = o.Pw().b(Long.valueOf(this.gLP));
            } else {
                b = b2;
            }
            b2 = o.Pw().hR((int) b.hzP);
            if (b2 != null) {
                this.hzX = b2.hzX;
            }
            this.fnB = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(this.hzX);
            if (this.fnB != null && this.fnB.field_msgId != this.hzX) {
                x.w(this.TAG, "init get msg by id failed:%d", new Object[]{Long.valueOf(this.hzX)});
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 206, 1, false);
                this.fnB = null;
                return;
            } else if (this.fnB != null) {
                bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gJQ.hmg.hmo;
                com_tencent_mm_protocal_c_bqt.vGX = new bdo().UA(q.FS());
                com_tencent_mm_protocal_c_bqt.vGY = new bdo().UA(this.fnB.field_talker);
                com_tencent_mm_protocal_c_bqt.vIC = b.offset;
                com_tencent_mm_protocal_c_bqt.vIB = b.hlp;
                com_tencent_mm_protocal_c_bqt.ngq = this.fnB.getType();
                com_tencent_mm_protocal_c_bqt.wmj = i2;
                com_tencent_mm_protocal_c_bqt.vWK = ab.bC(ac.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bqt.wOp = b.cOY;
                com_tencent_mm_protocal_c_bqt.vQD = b.hzU;
                com_tencent_mm_protocal_c_bqt.vQD = b.hzU;
                com_tencent_mm_protocal_c_bqt.wSm = this.fnB.gjH;
                com_tencent_mm_protocal_c_bqt.wSn = this.fnB.gjG;
                x.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSm), Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSn)});
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(b.cOY), Integer.valueOf(com_tencent_mm_protocal_c_bqt.vQD)});
                if (b.offset == 0) {
                    this.hBm = new h(110, true, (long) b.hlp);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        this.hBk = -1;
    }

    public l(int i, int i2, byte b) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hBD = "";
        this.hBE = "";
        this.hBF = true;
        this.hBH = 16384;
        this.hzT = 0;
        this.fnB = null;
        this.hBm = null;
        this.hBn = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hBo = 0;
        this.hBI = new b(this, null);
        this.hBx = new 4(this);
        this.gLX = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), null, bh.cgy()});
        this.hBk = (long) i;
        this.gLP = (long) i;
        this.hzT = i2;
        b.a aVar = new b.a();
        aVar.hmj = new bqt();
        aVar.hmk = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hmi = 110;
        aVar.hml = 9;
        aVar.hmm = 1000000009;
        this.gJQ = aVar.JZ();
        this.hBj = null;
        x.d(this.TAG, "FROM C SERVICE:" + this.hBk);
        if (i.hS((int) this.hBk)) {
            e b2;
            e b3 = o.Pw().b(Long.valueOf(this.hBk));
            this.hzX = b3.hzX;
            b3.eQ(0);
            b3.ap(0);
            b3.setOffset(0);
            o.Pw().a((int) this.gLP, b3);
            if (i2 == 1) {
                this.gLP = (long) b3.hzZ;
                b2 = o.Pw().b(Long.valueOf(this.gLP));
            } else {
                b2 = b3;
            }
            this.fnB = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH(this.hzX);
            if (this.fnB != null) {
                this.fnB.eQ(1);
                String str = b2.hzS;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.fnB.dT("THUMBNAIL://" + b2.hzP);
                } else {
                    this.fnB.dT(str);
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.hzX, this.fnB);
                bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gJQ.hmg.hmo;
                com_tencent_mm_protocal_c_bqt.vGX = new bdo().UA(q.FS());
                com_tencent_mm_protocal_c_bqt.vGY = new bdo().UA(this.fnB.field_talker);
                com_tencent_mm_protocal_c_bqt.vIC = b2.offset;
                com_tencent_mm_protocal_c_bqt.vIB = b2.hlp;
                com_tencent_mm_protocal_c_bqt.ngq = this.fnB.getType();
                com_tencent_mm_protocal_c_bqt.wmj = i2;
                com_tencent_mm_protocal_c_bqt.vWK = ab.bC(ac.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bqt.wOp = b2.cOY;
                com_tencent_mm_protocal_c_bqt.vQD = b2.hzU;
                com_tencent_mm_protocal_c_bqt.wSm = this.fnB.gjH;
                com_tencent_mm_protocal_c_bqt.wSn = this.fnB.gjG;
                x.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSm), Integer.valueOf(com_tencent_mm_protocal_c_bqt.wSn)});
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(b2.cOY), Integer.valueOf(com_tencent_mm_protocal_c_bqt.vQD)});
                if (b2.offset == 0) {
                    this.hBm = new h(110, true, (long) b2.hlp);
                    return;
                }
                return;
            }
            return;
        }
        this.hBk = -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Dk();
        g.Dm().g(new 5(this), 100);
        if (this.gLP < 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 204, 1, false);
            x.e(this.TAG, "doScene invalid imgLocalId:" + this.gLP);
            return hW(-1);
        } else if (this.fnB == null) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 203, 1, false);
            x.e(this.TAG, "doScene msg is null imgid:%d", new Object[]{Long.valueOf(this.gLP)});
            i.hU((int) this.hBk);
            return hW(-2);
        } else {
            String HD;
            this.gJT = eVar2;
            c(eVar);
            bqt com_tencent_mm_protocal_c_bqt = (bqt) this.gJQ.hmg.hmo;
            e Pk = Pk();
            e hR = o.Pw().hR((int) Pk.hzP);
            if (hR != null) {
                if (hR.status == -1) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 202, 1, false);
                    x.e(this.TAG, "doScene hd img info is null or error.");
                    return hW(-3);
                }
            } else if (Pk == null || Pk.status == -1) {
                x.e(this.TAG, "doScene img info is null or error.");
                return hW(-4);
            }
            if (com.tencent.mm.j.a.a.xD().eE(this.fnB.field_talker)) {
                com_tencent_mm_protocal_c_bqt.vHc = com.tencent.mm.j.a.a.xD().c(this.fnB);
            } else {
                HD = bc.HD();
                if (!(HD == null || HD.equals(this.fnB.gjF)) || (HD == null && !bh.ov(this.fnB.gjF))) {
                    this.fnB.dY(HD);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.fnB.field_msgId, this.fnB);
                }
                com_tencent_mm_protocal_c_bqt.vHc = this.fnB.gjF;
            }
            String m = o.Pw().m(Pk.hzQ, "", "");
            String m2 = o.Pw().m(Pk.hzS, "", "");
            HD = "";
            if (!bh.ov(Pk.hzR)) {
                HD = o.Pw().m(Pk.hzR, "", "");
            }
            if (com.tencent.mm.a.e.bN(m) <= 0 || com.tencent.mm.a.e.bN(m2) <= 0) {
                x.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[]{Long.valueOf(this.gLP), Integer.valueOf(com.tencent.mm.a.e.bN(m)), Integer.valueOf(com.tencent.mm.a.e.bN(m2)), m, m2});
                return hW(-5);
            }
            Object obj;
            if (com_tencent_mm_protocal_c_bqt.wSf == null || bh.ov(com_tencent_mm_protocal_c_bqt.wSf.wJF)) {
                if (bh.ov(this.hBn)) {
                    x.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(this.fnB.field_createTime), this.fnB.field_talker, Long.valueOf(this.fnB.field_msgId), Long.valueOf(this.gLP), Integer.valueOf(this.hzT)});
                    this.hBn = d.a("upimg", this.fnB.field_createTime, this.fnB.field_talker, this.fnB.field_msgId + "_" + this.gLP + "_" + this.hzT);
                }
                com_tencent_mm_protocal_c_bqt.wSf = new bdo().UA(this.hBn);
                cf cfVar = this.fnB;
                cfVar.gjM = this.hBn;
                cfVar.gfw = true;
            }
            if (this.startTime == 0) {
                this.startTime = bh.Wp();
                this.startOffset = Pk.offset;
                this.hBo = this.hzT == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            x.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[]{m, m2, Pk.hzQ});
            if (s.ho(this.fnB.field_talker)) {
                x.w(this.TAG, "cdntra not use cdn user:%s", new Object[]{this.fnB.field_talker});
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.MJ();
                if (!c.hu(1) && bh.ov(Pk.hAa)) {
                    r7 = new Object[2];
                    com.tencent.mm.modelcdntran.g.MJ();
                    r7[0] = Boolean.valueOf(c.hu(1));
                    r7[1] = Pk.hAa;
                    x.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r7);
                    obj = null;
                } else if (bh.ov(this.hBn)) {
                    x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[]{Long.valueOf(this.gLP)});
                    obj = null;
                } else {
                    i iVar = new i();
                    iVar.htt = this.hBx;
                    iVar.field_mediaId = this.hBn;
                    iVar.field_fullpath = m;
                    iVar.field_thumbpath = m2;
                    iVar.field_fileType = this.hBo;
                    iVar.field_talker = this.fnB.field_talker;
                    iVar.field_chattype = s.eV(this.fnB.field_talker) ? 1 : 0;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_sendmsg_viacdn = true;
                    iVar.field_enable_hitcheck = this.hBF;
                    iVar.field_midimgpath = HD;
                    iVar.field_force_aeskeycdn = false;
                    iVar.field_trysafecdn = true;
                    if (iVar.field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE && bh.ov(iVar.field_midimgpath)) {
                        com.tencent.mm.modelcdntran.g.MJ();
                        if (c.hu(256)) {
                            x.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                        }
                    }
                    Map y = bi.y(this.hBJ, "msg");
                    if (y != null) {
                        if (this.hzT != 1) {
                            iVar.field_fileId = (String) y.get(".msg.img.$cdnmidimgurl");
                            iVar.field_midFileLength = bh.getInt((String) y.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        } else {
                            iVar.field_fileId = (String) y.get(".msg.img.$cdnbigimgurl");
                            iVar.field_midFileLength = bh.getInt((String) y.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        }
                        iVar.field_aesKey = (String) y.get(".msg.img.$aeskey");
                    } else {
                        x.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[]{Pk.hAa});
                    }
                    if (bh.ov(iVar.field_aesKey)) {
                        com.tencent.mm.modelcdntran.g.MK();
                        iVar.field_aesKey = com.tencent.mm.modelcdntran.b.MC();
                        x.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[]{iVar.field_aesKey});
                    }
                    x.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[]{Integer.valueOf(Pk.cOY), iVar.field_fileId});
                    this.hBD = iVar.field_fileId;
                    this.hBE = iVar.field_aesKey;
                    x.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_enable_hitcheck), Integer.valueOf(iVar.field_fileType), iVar.field_midimgpath, iVar.field_fullpath, iVar.field_aesKey, iVar.field_fileId, Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                    this.hBN = null;
                    if (com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                        if (bh.ou(Pk.hAa).length() <= 0) {
                            Pk.lj("CDNINFO_SEND");
                            Pk.fDt = Downloads.RECV_BUFFER_SIZE;
                        }
                        obj = 1;
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 205, 1, false);
                        x.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[]{this.hBn});
                        this.hBn = "";
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[]{com_tencent_mm_protocal_c_bqt.wSf.wJF});
                return 0;
            }
            x.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = Pk.hzY;
            if (i >= Bh()) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 201, 1, false);
                x.e(this.TAG, "doScene limit net time:" + i);
                i.hU((int) this.hBk);
                return hW(-6);
            }
            Pk.hJ(i + 1);
            Pk.fDt = WXMediaMessage.TITLE_LENGTH_LIMIT;
            o.Pw().a(Long.valueOf(this.gLP), Pk);
            int i2 = Pk.hlp - Pk.offset;
            if (i2 > this.hBH) {
                i2 = this.hBH;
            }
            if (com.tencent.mm.a.e.bN(m) > 10485760) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 200, 1, false);
                x.e(this.TAG, "doScene, file size is too large");
                return hW(-7);
            }
            byte[] d = com.tencent.mm.a.e.d(m, Pk.offset, i2);
            if (d == null || d.length <= 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 199, 1, false);
                x.e(this.TAG, "doScene, file read buf error.");
                return hW(-8);
            }
            com_tencent_mm_protocal_c_bqt.vID = d.length;
            com_tencent_mm_protocal_c_bqt.vIC = Pk.offset;
            com_tencent_mm_protocal_c_bqt.vXz = new bdn().bj(d);
            if (this.hBm != null) {
                this.hBm.SW();
            }
            int a = a(eVar, this.gJQ, this);
            if (a >= 0) {
                return a;
            }
            x.e(this.TAG, "doScene netId error");
            i.hU((int) this.hBk);
            return hW(-9);
        }
    }

    private int hW(int i) {
        x.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.hBI != null) {
            this.hBI.Pj();
        }
        return -1;
    }

    public final int getType() {
        return 110;
    }

    protected final int Bh() {
        if (this.hzT == 0) {
            return 100;
        }
        return 1350;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bqu com_tencent_mm_protocal_c_bqu = (bqu) ((b) qVar).hmh.hmo;
        x.i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hBn);
        if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.hBn});
        } else if (i2 == 0 && i3 == 0) {
            this.hBH = com_tencent_mm_protocal_c_bqu.vID;
            if (this.hBH > 16384) {
                this.hBH = 16384;
            }
            e Pk = Pk();
            x.v(this.TAG, "onGYNetEnd localId:" + this.gLP + "  totalLen:" + Pk.hlp + " offSet:" + Pk.offset);
            if (com_tencent_mm_protocal_c_bqu.vIC < 0 || (com_tencent_mm_protocal_c_bqu.vIC > Pk.hlp && Pk.hlp > 0)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 197, 1, false);
                x.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + com_tencent_mm_protocal_c_bqu.vIC + " img totalLen = " + Pk.hlp);
                i.hU((int) this.hBk);
                i.hT((int) this.hBk);
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(0)});
                this.gJT.a(4, -2, "", this);
                if (this.hBI != null) {
                    this.hBI.Pj();
                }
            } else if (com_tencent_mm_protocal_c_bqu.vIC < Pk.offset || (f.b(Pk) && this.hBH <= 0)) {
                x.e(this.TAG, "onGYNetEnd invalid data startPos = " + com_tencent_mm_protocal_c_bqu.vIC + " totalLen = " + Pk.hlp + " off:" + Pk.offset);
                i.hU((int) this.hBk);
                i.hT((int) this.hBk);
                this.gJT.a(4, -1, "", this);
                if (this.hBI != null) {
                    this.hBI.Pj();
                }
            } else {
                x.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + com_tencent_mm_protocal_c_bqu.vIC);
                if (a(Pk, com_tencent_mm_protocal_c_bqu.vIC, com_tencent_mm_protocal_c_bqu.vHe, com_tencent_mm_protocal_c_bqu.pbl, null) && a(this.hmA, this.gJT) < 0) {
                    i.hT((int) this.hBk);
                    this.gJT.a(3, -1, "", this);
                    if (this.hBI != null) {
                        this.hBI.Pj();
                    }
                }
            }
        } else {
            x.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 198, 1, false);
            i.hU((int) this.hBk);
            i.hT((int) this.hBk);
            com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(0)});
            this.gJT.a(i2, i3, str, this);
            if (this.hBI != null) {
                this.hBI.Pj();
            }
        }
    }

    public final void Pm() {
        x.i(this.TAG, "send img from system");
        this.gLX = true;
    }

    private boolean a(e eVar, int i, long j, int i2, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        x.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[]{this.hBn, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        x.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(j), Integer.valueOf(r.idu)});
        if (CdnLogic.kMediaTypeFavoriteBigFile == r.idt && r.idu != 0) {
            j = (long) r.idu;
            r.idu = 0;
        }
        long j2 = eVar.hzP;
        int i3 = eVar.hlp;
        if (this.hBj != null) {
            ag.y(new 6(this, j2, i3, i));
        }
        eVar.setOffset(i);
        eVar.ap(j);
        if (f.b(eVar) && this.hBk != this.gLP) {
            e b = o.Pw().b(Long.valueOf(this.hBk));
            b.ap(j);
            b.hL(eVar.hlp);
            b.setOffset(eVar.hlp);
            o.Pw().a(Long.valueOf(this.hBk), b);
        }
        if (!f.b(eVar)) {
            return true;
        }
        if (bh.ov(this.hBn)) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.hBo), Integer.valueOf(eVar.hlp - this.startOffset)});
        }
        this.fnB.eQ(2);
        this.fnB.ap(j);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().a(this.hzX, this.fnB);
        if (com.tencent.mm.modelstat.r.hSU != null) {
            com.tencent.mm.modelstat.r.hSU.f(this.fnB);
        }
        i.hT((int) this.hBk);
        if (this.hBm != null) {
            this.hBm.br(0);
        }
        this.gJT.a(0, 0, "", this);
        if (r.hCQ != null) {
            r.hCQ.a(this.gLP, this.fnB, this.gJQ, this.gLQ, this.gLX, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        if (this.hBI != null) {
            this.hBI.Pj();
        }
        return false;
    }

    public static void bj(long j) {
        hBO = j;
    }

    public static String lo(String str) {
        try {
            if (!bh.ov(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 19) {
                    StringBuilder stringBuilder = new StringBuilder();
                    long j = hBO;
                    hBO = -1;
                    split[19] = stringBuilder.append(j).toString();
                    str = bh.d(bh.F(split), ",");
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
