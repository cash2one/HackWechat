package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class aw {
    private static final Pattern ime = Pattern.compile("(\n){3,}");
    public int afu;
    public aqc fHP;
    private String gze;
    int qQW;
    int qQX;
    List<h> qYl;
    String qYm;
    String qYn;
    LinkedList<bld> qYo;
    LinkedList<Long> qYp;
    public bnp qYq = e.SA();
    public aqs qYr = new aqs();
    m qYs = new m();
    bjv qYt = null;
    at qYu;
    public bme qYv;
    public bzu qYw;
    private boolean qYx;

    public aw(int i) {
        at atVar = new at();
        atVar.vFI = new ar();
        atVar.vFK = new cp();
        atVar.vFL = new cw();
        this.qYu = atVar;
        this.qYv = new bme();
        this.fHP = new aqc();
        this.qYw = null;
        this.gze = "";
        this.qYx = false;
        this.gze = ae.bvb();
        this.afu = i;
        this.qYq.wQo.vYc = i;
        x.d("MicroMsg.UploadPackHelper", "contentType " + i);
        this.qYq.wxG = 0;
        this.qYq.ksU = this.gze;
        this.qYr.vGQ = g.s((ae.bvb() + bh.Wq() + System.currentTimeMillis()).getBytes());
        this.qYr.wya = 0;
        this.qYr.wyb = 0;
        this.qYr.wxG = 0;
        this.qYr.wye = 0;
        this.qYr.hkU = 0;
        this.qYr.wyg = 0;
        this.qYr.wyi = 0;
        bjv com_tencent_mm_protocal_c_bjv = new bjv();
        com_tencent_mm_protocal_c_bjv.vPO = 0;
        com_tencent_mm_protocal_c_bjv.pbl = 0;
        com_tencent_mm_protocal_c_bjv.wMX = 0;
        com_tencent_mm_protocal_c_bjv.vIy = ae.bvb();
        com_tencent_mm_protocal_c_bjv.wNa = new LinkedList();
        com_tencent_mm_protocal_c_bjv.wMY = 0;
        com_tencent_mm_protocal_c_bjv.wMZ = 0;
        com_tencent_mm_protocal_c_bjv.wNg = new LinkedList();
        com_tencent_mm_protocal_c_bjv.wNe = 0;
        com_tencent_mm_protocal_c_bjv.wNf = 0;
        com_tencent_mm_protocal_c_bjv.wNd = new LinkedList();
        com_tencent_mm_protocal_c_bjv.wNb = 0;
        com_tencent_mm_protocal_c_bjv.wNc = 0;
        com_tencent_mm_protocal_c_bjv.wzw = 1;
        com_tencent_mm_protocal_c_bjv.wMX = 0;
        com_tencent_mm_protocal_c_bjv.wNh = 0;
        com_tencent_mm_protocal_c_bjv.wMW = new bdn().bj(new byte[0]);
        this.qYt = com_tencent_mm_protocal_c_bjv;
        m mVar = this.qYs;
        mVar.field_localFlag |= 16;
        this.qYs.hK((int) (System.currentTimeMillis() / 1000));
        this.qYs.field_type = i;
        this.qYs.field_userName = this.gze;
        this.qYs.field_pravited = 0;
        this.qYs.field_stringSeq = "0000099999999999999999999";
        this.qYs.xj(2);
        this.qYs.byn();
        if (i == 1 || i == 2) {
            this.qYs.xj(4);
        }
        if (i == 7) {
            this.qYs.xm(2);
        }
        this.qYp = new LinkedList();
        this.qYr.wyh = this.qYp;
        Iterator it = this.qYp.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            bjq com_tencent_mm_protocal_c_bjq = new bjq();
            com_tencent_mm_protocal_c_bjq.wMU = longValue;
            this.qYt.vHz.add(com_tencent_mm_protocal_c_bjq);
        }
        this.qYt.wAO = this.qYp.size();
    }

    private static String Ky(String str) {
        String str2;
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                x.e("MicroMsg.UploadPackHelper", "filter desc error ");
                return str2;
            }
        }
        str2 = str;
        try {
            str2 = ime.matcher(str2.trim().replace("\r\n", "\n")).replaceAll("\n\n");
        } catch (Exception e2) {
            x.e("MicroMsg.UploadPackHelper", "filter desc error ");
            return str2;
        }
        return str2;
    }

    public final aw Kz(String str) {
        this.qYm = Ky(str);
        this.qYq.wQl = this.qYm;
        return this;
    }

    public final aw ed(String str, String str2) {
        this.qYr.token = str;
        this.qYr.wyk = str2;
        return this;
    }

    public final aw wM(int i) {
        this.qYq.wQq = 1;
        this.qYq.wQr = i;
        return this;
    }

    public final aw KA(String str) {
        this.qYq.wQs = str;
        this.qYu.vFI.vFC = str;
        return this;
    }

    public final aw KB(String str) {
        this.qYq.rLO = str;
        return this;
    }

    public final aw U(String str, String str2, String str3) {
        ar arVar = this.qYu.vFI;
        if (bh.ov(str)) {
            str = "";
        }
        arVar.ngo = str;
        arVar = this.qYu.vFI;
        if (bh.ov(str2)) {
            str2 = "";
        }
        arVar.vFD = str2;
        arVar = this.qYu.vFI;
        if (bh.ov(str3)) {
            str3 = "";
        }
        arVar.vFE = str3;
        return this;
    }

    public final aw KC(String str) {
        this.qYn = str;
        this.qYq.wQo.nfe = str;
        return this;
    }

    public final aw KD(String str) {
        this.qYq.wQo.nfX = str;
        return this;
    }

    public final aw KE(String str) {
        this.qYq.wQo.fon = str;
        return this;
    }

    public final void wN(int i) {
        x.d("MicroMsg.UploadPackHelper", "set post form " + i);
        this.qYr.wyg = i;
    }

    public final aw a(aoy com_tencent_mm_protocal_c_aoy) {
        if (com_tencent_mm_protocal_c_aoy != null) {
            this.qYq.wQm = com_tencent_mm_protocal_c_aoy;
        }
        return this;
    }

    public final aw wO(int i) {
        this.qQX = i;
        this.qYr.wxG = i;
        this.qYq.wxG = i;
        if (i > 0) {
            this.qYs.field_pravited = i;
            this.qYs.byk();
            this.qYs.xm(2);
            this.qYs.byo();
        }
        return this;
    }

    public final aw wP(int i) {
        this.qQW = i;
        this.qYr.wyb = i;
        return this;
    }

    public final aw ai(LinkedList<bld> linkedList) {
        this.qYo = linkedList;
        this.qYr.wyd = linkedList;
        Iterator it = this.qYo.iterator();
        while (it.hasNext()) {
            bld com_tencent_mm_protocal_c_bld = (bld) it.next();
            bjk com_tencent_mm_protocal_c_bjk = new bjk();
            com_tencent_mm_protocal_c_bjk.vIy = com_tencent_mm_protocal_c_bld.ksU;
            this.qYt.wNg.add(com_tencent_mm_protocal_c_bjk);
        }
        this.qYt.wNe = this.qYo.size();
        this.qYt.wNf = this.qYo.size();
        return this;
    }

    public final aw wQ(int i) {
        this.qYr.wyi = i;
        return this;
    }

    public final aw KF(String str) {
        cu cuVar = this.qYq.wQn;
        if (cuVar == null) {
            cuVar = new cu();
        }
        cuVar.nGJ = str;
        this.qYq.wQn = cuVar;
        return this;
    }

    public final aw KG(String str) {
        cu cuVar = this.qYq.wQn;
        if (cuVar == null) {
            cuVar = new cu();
        }
        cuVar.niZ = str;
        this.qYq.wQn = cuVar;
        return this;
    }

    public final aw KH(String str) {
        this.qYq.vmS = bh.ou(str);
        return this;
    }

    public final aw KI(String str) {
        this.qYq.vmT = bh.ou(str);
        return this;
    }

    public final aw bM(List<String> list) {
        if (list == null || list.size() == 0) {
            this.qYt.wzw = 1;
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bdo com_tencent_mm_protocal_c_bdo = new bdo();
                com_tencent_mm_protocal_c_bdo.UA(str);
                linkedList.add(com_tencent_mm_protocal_c_bdo);
            }
            this.qYr.wym = linkedList;
            if (this.qYt.wzw == 3) {
                this.qYt.wNl = linkedList;
                this.qYt.wNk = linkedList.size();
            } else if (this.qYt.wzw == 5) {
                this.qYt.wym = linkedList;
                this.qYt.wNm = linkedList.size();
            }
        }
        return this;
    }

    public final aw wR(int i) {
        if (i == 1) {
            this.qYt.wzw = 3;
        } else if (i == 0) {
            this.qYt.wzw = 5;
        }
        this.qYr.wyl = i;
        return this;
    }

    private static aqr r(String str, byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zh() + " attachBuf is null");
            return null;
        }
        String str2 = ae.getAccSnsTmpPath() + g.s((" " + System.currentTimeMillis()).getBytes());
        FileOp.mh(ae.getAccSnsTmpPath());
        x.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zh() + " buildUploadAttachInfo file:" + str2);
        if (FileOp.b(str2, bArr, bArr.length) >= 0) {
            return s(str, 2, str2);
        }
        x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zh() + " writeFile error file:" + str2);
        return null;
    }

    public static aqr a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        aqr SB = e.SB();
        SB.nGJ = str;
        x.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[]{Integer.valueOf(6), str2, str4, str5, str6});
        SB.ktN = 6;
        if (FileOp.me(str2) <= 0) {
            return null;
        }
        aqt com_tencent_mm_protocal_c_aqt;
        h hVar = new h(str2, 6);
        hVar.qRb = str4;
        hVar = ae.bvk().a(hVar, str2, str3, str5, str6);
        if (hVar.height <= 0 || hVar.width <= 0 || hVar.fileSize <= 0) {
            com_tencent_mm_protocal_c_aqt = null;
        } else {
            com_tencent_mm_protocal_c_aqt = new aqt();
            com_tencent_mm_protocal_c_aqt.wyv = (float) hVar.height;
            com_tencent_mm_protocal_c_aqt.wyu = (float) hVar.width;
            com_tencent_mm_protocal_c_aqt.wyw = (float) hVar.fileSize;
        }
        SB.nGJ = "Locall_path" + hVar.qQY;
        SB.wxH = com_tencent_mm_protocal_c_aqt;
        SB.qQY = hVar.qQY;
        return SB;
    }

    private static aqr s(String str, int i, String str2) {
        aqt com_tencent_mm_protocal_c_aqt = null;
        aqr SB = e.SB();
        SB.nGJ = str;
        x.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        SB.ktN = 2;
        if (FileOp.me(str2) <= 0) {
            return null;
        }
        String str3 = ae.getAccSnsTmpPath() + g.s((str2 + System.currentTimeMillis()).getBytes());
        FileOp.x(str2, str3);
        h hVar = new h(str3, 2);
        List linkedList = new LinkedList();
        linkedList.add(hVar);
        linkedList = ae.bvk().bR(linkedList);
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        h hVar2 = (h) linkedList.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            com_tencent_mm_protocal_c_aqt = new aqt();
            com_tencent_mm_protocal_c_aqt.wyv = (float) hVar2.height;
            com_tencent_mm_protocal_c_aqt.wyu = (float) hVar2.width;
            com_tencent_mm_protocal_c_aqt.wyw = (float) hVar2.fileSize;
        }
        SB.nGJ = "Locall_path" + hVar2.qQY;
        SB.wxH = com_tencent_mm_protocal_c_aqt;
        SB.qQY = hVar2.qQY;
        return SB;
    }

    public static aqr V(String str, String str2, String str3) {
        aqr SB = e.SB();
        SB.nGJ = str;
        x.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        SB.ktN = 2;
        SB.nfX = str2;
        SB.wxD = 0;
        SB.wxE = str3;
        SB.wxF = 0;
        SB.wxK = 1;
        return SB;
    }

    public final boolean l(String str, String str2, String str3, String str4) {
        String str5 = ae.getAccSnsTmpPath() + g.s(str.getBytes());
        KJ(str5);
        FileOp.x(str, str5);
        String str6 = ae.getAccSnsTmpPath() + g.s(str2.getBytes());
        FileOp.x(str2, str6);
        aqr a = a("", 6, str5, str6, str4, "", "");
        if (a == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        a.nfe = str3;
        if (bh.ov(a.fon)) {
            a.fon = str3;
        }
        this.qYq.wQo.vYd.add(a);
        aox com_tencent_mm_protocal_c_aox = new aox();
        com_tencent_mm_protocal_c_aox.wvG = a.qQY;
        this.qYr.wyc.add(com_tencent_mm_protocal_c_aox);
        return true;
    }

    public static void KJ(String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public final boolean ee(String str, String str2) {
        String str3 = ae.getAccSnsTmpPath() + g.s(str.getBytes());
        KJ(str3);
        FileOp.x(str, str3);
        aqr s = s("", 2, str3);
        if (s == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        s.nfe = str2;
        if (bh.ov(s.fon)) {
            s.fon = str2;
        }
        this.qYq.wQo.vYd.add(s);
        aox com_tencent_mm_protocal_c_aox = new aox();
        com_tencent_mm_protocal_c_aox.wvG = s.qQY;
        this.qYr.wyc.add(com_tencent_mm_protocal_c_aox);
        return true;
    }

    @Deprecated
    public final boolean b(String str, String str2, String str3, int i, String str4) {
        aqr V = V("", str, str2);
        if (V == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            return false;
        }
        V.nfe = str3;
        if (i > 0) {
            V.fpn = i;
        }
        if (!bh.ov(str4)) {
            V.rsn = str4;
        }
        this.qYq.wQo.vYd.add(V);
        return true;
    }

    public final boolean b(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, -1, "");
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        aqr r = r("", bArr);
        if (r == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            return false;
        }
        r.nfe = str;
        if (i > 0) {
            r.fpn = i;
        }
        if (!bh.ov(str3)) {
            r.rsn = str3;
        }
        if (!bh.ov(str2)) {
            r.fon = str2;
        }
        if (!bh.ov(str)) {
            r.nfe = str;
        }
        this.qYq.wQo.vYd.add(r);
        aox com_tencent_mm_protocal_c_aox = new aox();
        com_tencent_mm_protocal_c_aox.wvG = r.qQY;
        this.qYr.wyc.add(com_tencent_mm_protocal_c_aox);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        aqr r = r("", bArr);
        if (r == null || (bh.ov(str2) && bh.ov(str3))) {
            x.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            return false;
        }
        if (!bh.ov(str)) {
            this.qYq.wQo.nfX = str;
        }
        if (!bh.ov(str3)) {
            r.nfX = str3;
            r.wxD = 0;
        } else if (!bh.ov(str2)) {
            r.nfX = str2;
            r.wxD = 0;
        }
        if (!bh.ov(str2)) {
            r.wxI = str2;
            r.wxJ = 0;
        }
        r.ktN = i;
        r.fon = bh.az(str4, "");
        r.nfe = bh.az(str5, "");
        this.qYq.wQo.vYd.add(r);
        aox com_tencent_mm_protocal_c_aox = new aox();
        com_tencent_mm_protocal_c_aox.wvG = r.qQY;
        this.qYr.wyc.add(com_tencent_mm_protocal_c_aox);
        return true;
    }

    public final void bN(List<h> list) {
        this.qYl = list;
        List<h> bR = ae.bvk().bR(this.qYl);
        LinkedList linkedList = new LinkedList();
        if (bR != null) {
            for (h hVar : bR) {
                aox com_tencent_mm_protocal_c_aox = new aox();
                com_tencent_mm_protocal_c_aox.wvG = hVar.qQY;
                linkedList.add(com_tencent_mm_protocal_c_aox);
            }
            this.qYr.wyc = linkedList;
            for (h hVar2 : bR) {
                aqt com_tencent_mm_protocal_c_aqt = new aqt();
                com_tencent_mm_protocal_c_aqt.wyv = 0.0f;
                com_tencent_mm_protocal_c_aqt.wyu = 0.0f;
                com_tencent_mm_protocal_c_aqt.wyw = 0.0f;
                if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                    com_tencent_mm_protocal_c_aqt.wyv = (float) hVar2.height;
                    com_tencent_mm_protocal_c_aqt.wyu = (float) hVar2.width;
                    com_tencent_mm_protocal_c_aqt.wyw = (float) hVar2.fileSize;
                }
                this.qYq.wQo.vYd.add(e.a("Locall_path" + hVar2.qQY, hVar2.type, "", "", 0, 0, this.qQX, "", com_tencent_mm_protocal_c_aqt));
            }
        }
    }

    public final void e(String str, String str2, String str3, int i, int i2) {
        bkf com_tencent_mm_protocal_c_bkf = new bkf();
        com_tencent_mm_protocal_c_bkf.vHY = str;
        com_tencent_mm_protocal_c_bkf.vHZ = str2;
        com_tencent_mm_protocal_c_bkf.vIa = str3;
        com_tencent_mm_protocal_c_bkf.rwT = i;
        com_tencent_mm_protocal_c_bkf.rwU = i2;
        this.qYr.wyn = com_tencent_mm_protocal_c_bkf;
    }

    public final void qf(String str) {
        this.qYr.fqu = str;
    }

    public final int commit() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qYr.wyf = System.currentTimeMillis();
            this.qYr.hkU = 0;
            this.qYs.aJ(this.qYt.toByteArray());
            this.qYs.field_postBuf = this.qYr.toByteArray();
            x.d("MicroMsg.UploadPackHelper", "snsObj " + this.qYt.toString());
            x.d("MicroMsg.UploadPackHelper", "postinfo " + this.qYr.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        x.d("MicroMsg.UploadPackHelper", "timelineObj " + this.qYq.toString());
        if (this.qYq.wQo.vYd != null) {
            x.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[]{Integer.valueOf(this.qYq.wQo.vYd.size())});
            for (int i = 0; i < this.qYq.wQo.vYd.size(); i++) {
                if (((aqr) this.qYq.wQo.vYd.get(i)) != null) {
                    x.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[]{Integer.valueOf(((aqr) this.qYq.wQo.vYd.get(i)).qQY), bh.az(((aqr) this.qYq.wQo.vYd.get(i)).nfX, "")});
                }
            }
        }
        if (this.qYu != null) {
            this.qYq.qYu = this.qYu;
        }
        if (this.qYw != null) {
            this.qYq.qYw = this.qYw;
        }
        this.qYs.c(this.qYq);
        int y = ae.bvv().y(this.qYs);
        Iterator it = this.qYr.wyc.iterator();
        int i2 = 0;
        String str = null;
        while (it.hasNext()) {
            aox com_tencent_mm_protocal_c_aox = (aox) it.next();
            q eS = ae.bvk().eS((long) com_tencent_mm_protocal_c_aox.wvG);
            try {
                aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
                if (this.qYq.wQn != null) {
                    com_tencent_mm_protocal_c_aqu.fFm = this.qYq.wQn.nGJ;
                }
                if (this.fHP != null) {
                    this.fHP.wwQ = 0;
                }
                com_tencent_mm_protocal_c_aqu.wyE = this.fHP;
                com_tencent_mm_protocal_c_aqu.afu = this.qYq.wQo.vYc;
                if (com_tencent_mm_protocal_c_aqu.afu == 1 || com_tencent_mm_protocal_c_aqu.afu == 15) {
                    int i3;
                    aqu com_tencent_mm_protocal_c_aqu2;
                    if (!bh.ov(com_tencent_mm_protocal_c_aqu.fFm)) {
                        i3 = 5;
                        com_tencent_mm_protocal_c_aqu2 = com_tencent_mm_protocal_c_aqu;
                    } else if (com_tencent_mm_protocal_c_aqu.wyE != null && com_tencent_mm_protocal_c_aqu.afu == 15) {
                        if (com_tencent_mm_protocal_c_aqu.wyE.wwP) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        com_tencent_mm_protocal_c_aqu.wyF = i3;
                    } else if (((h) this.qYl.get(i2)).qRc) {
                        i3 = 1;
                        com_tencent_mm_protocal_c_aqu2 = com_tencent_mm_protocal_c_aqu;
                    } else {
                        i3 = 2;
                        com_tencent_mm_protocal_c_aqu2 = com_tencent_mm_protocal_c_aqu;
                    }
                    com_tencent_mm_protocal_c_aqu2.wyF = i3;
                }
                eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
                ae.bvk().a(com_tencent_mm_protocal_c_aox.wvG, eS);
                i2++;
                str = com_tencent_mm_protocal_c_aqu.fqR;
            } catch (Exception e2) {
                x.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        x.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[]{Integer.valueOf(y), Integer.valueOf(this.qYs.field_type), str});
        if (y > 0 && this.qYs.field_type == 15) {
            ap.ec(u.ab("sns_table_", (long) y), str);
        }
        x.d("MicroMsg.UploadPackHelper", "pack commit result " + y + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return y;
    }
}
