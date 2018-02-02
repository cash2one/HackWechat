package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.as;
import com.tencent.mm.z.au;
import com.tencent.mm.z.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements com.tencent.mm.network.k {
    e gJT;
    private final String hNN;
    private final String hNO;
    private final String hNP;
    private final String hNQ;
    private final String hNR;
    private final String hNS;
    private final int hNT;
    private final int hNU;
    private boolean hNV = true;
    public boolean hNW = false;
    private int hmS = 2;
    public q hnp;

    public y(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        x.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.hNU = i2;
        this.hnp = new au();
        a aVar = (a) this.hnp.Kb();
        aVar.eE(0);
        aVar.vBS.ksU = str;
        aVar.vBS.vMp = bh.VB(str2);
        if (i2 == 4) {
            aVar.vBS.vMp = str6;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.vBS.vMp);
        }
        aVar.vBS.kub = str3;
        aVar.vBS.vFr = i;
        aVar.vBS.vFs = str4;
        aVar.vBS.vFt = str5;
        aVar.vBS.vZK = str6;
        aVar.vBS.wnM = i2;
        aVar.vBS.lOn = bh.cgr();
        aVar.vBS.vZI = com.tencent.mm.compatible.d.q.getSimCountryIso();
        aVar.vBS.lOo = w.cfi();
        aVar.vBS.vJy = 0;
        aVar.vBS.wAX = 0;
        aVar.vBS.wAY = com.tencent.mm.compatible.d.q.getAndroidId();
        aVar.vBS.wcs = com.tencent.mm.compatible.d.q.yG();
        aVar.vBS.wAZ = ac.getContext().getSharedPreferences(ac.cfs(), 0).getString("installreferer", "");
        aVar.vBS.wBa = d.oSu.tX(2);
        aVar.vBS.wBb = ac.getContext().getSharedPreferences(ac.cfs() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hNN = str;
        this.hNO = str2;
        this.hNP = str3;
        this.hNQ = str4;
        this.hNR = str5;
        this.hNT = i;
        this.hNS = "";
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.hNV = z;
        aVar.vBS.vJz = com.tencent.mm.kernel.a.CB();
    }

    public y(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        x.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[]{str, bh.VT(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.hNU = i2;
        this.hnp = new au();
        a aVar = (a) this.hnp.Kb();
        aVar.eE(0);
        aVar.vBS.ksU = str;
        aVar.vBS.vMp = bh.VB(str2);
        if (i2 == 4) {
            aVar.vBS.vMp = str8;
            x.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.vBS.vMp);
        }
        aVar.vBS.kub = str3;
        aVar.vBS.vFr = i;
        aVar.vBS.vFs = str4;
        aVar.vBS.vFt = str5;
        aVar.vBS.vZK = str8;
        aVar.vBS.wnM = i2;
        aVar.vBS.lOn = bh.cgr();
        aVar.vBS.vZI = com.tencent.mm.compatible.d.q.getSimCountryIso();
        aVar.vBS.lOo = w.cfi();
        aVar.vBS.vJy = 0;
        aVar.vBS.hvy = str9;
        aVar.vBS.wnL = str11;
        aVar.vBS.wnK = str10;
        aVar.vBS.vMf = z ? 1 : 0;
        aVar.vBS.wAW = z2 ? 1 : 0;
        aVar.vBS.vJz = com.tencent.mm.kernel.a.CB();
        aVar.vBS.wAY = com.tencent.mm.compatible.d.q.getAndroidId();
        aVar.vBS.wcs = com.tencent.mm.compatible.d.q.yG();
        aVar.vBS.wAZ = ac.getContext().getSharedPreferences(ac.cfs(), 0).getString("installreferer", "");
        aVar.vBS.wBa = d.oSu.tX(2);
        aVar.vBS.wBb = ac.getContext().getSharedPreferences(ac.cfs() + "_google_aid", 4).getString("getgoogleaid", "");
        this.hNN = str;
        this.hNO = str2;
        this.hNP = str3;
        this.hNQ = str4;
        this.hNR = str5;
        this.hNT = i;
        this.hNS = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.hNV = z3;
    }

    public final void is(int i) {
        ((a) this.hnp.Kb()).vBS.vMl = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(k.a aVar) {
    }

    public final void mx(String str) {
        if (!bh.ov(str)) {
            ((a) this.hnp.Kb()).vBS.vMm = str;
        }
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        com.tencent.mm.protocal.y.b bVar = (com.tencent.mm.protocal.y.b) qVar.Hp();
        if (bVar.vBT != null) {
            i4 = bVar.vBT.vJp;
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg:%s", new Object[]{Integer.valueOf(i4)});
            g.Dk();
            g.Dj().gQd.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Di().gPJ.hmV;
            if (eVar != null) {
                eVar.bH((i4 & 1) == 0);
            }
        } else {
            x.i("MicroMsg.NetSceneReg", "summerauth mmtls reg not set as ret:%s", new Object[]{Integer.valueOf(bVar.vBp)});
        }
        if (i2 == 4 && i3 == -301) {
            as.a(true, bVar.vBT.vMr, bVar.vBT.vMs, bVar.vBT.vMq);
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
            } else {
                a(this.hmA, this.gJT);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.hmS)});
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
            } else {
                a(this.hmA, this.gJT);
            }
        } else if (i2 == 4 && i3 == -102) {
            x.i("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            g.Dm().F(new 1(this, i4));
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) qVar.Kb();
            x.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.vBT.lOf + " regtype:" + bVar.vBT.vFv + " mode:" + aVar.vBS.wnM);
            if (!(bVar.vBT.lOd == 0 || this.hNV)) {
                g.Dk();
                g.gC(bVar.vBT.lOd);
                if (aVar.vBS.wnM == 4) {
                    g.Dj().CU().set(2, aVar.vBS.ksU);
                }
                g.Dj().CU().set(16, Integer.valueOf(1));
                g.Dj().CU().set(52, Integer.valueOf(bVar.vBT.vFv));
                g.Dj().CU().set(340240, Long.valueOf(System.currentTimeMillis()));
                g.Dj().CU().set(340241, Boolean.valueOf(true));
                if (!(this.hNN == null || this.hNN.length() <= 0 || this.hNU == 1)) {
                    bVar.vBT.ksU = this.hNN;
                }
                bVar.vBT.vFs = this.hNQ;
                bVar.vBT.ktm = 0;
                if (!g.Dh().Cy() || g.Dj().CU() == null) {
                    r7 = new Object[3];
                    g.Dh();
                    r7[1] = o.getString(com.tencent.mm.kernel.a.Cg());
                    r7[2] = g.Dj().CU();
                    x.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", r7);
                } else {
                    String str2 = this.hNS;
                    int i5 = this.hNT;
                    String str3 = this.hNP;
                    String str4 = this.hNR;
                    String str5 = bVar.vBT.ksU;
                    String str6 = bVar.vBT.vFs;
                    int i6 = bVar.vBT.ktm;
                    String str7 = bVar.vBT.vFy;
                    String str8 = bVar.vBT.vFz;
                    int i7 = bVar.vBT.vFA;
                    int i8 = bVar.vBT.wBg;
                    String str9 = bVar.vBT.vDZ;
                    String str10 = bVar.vBT.vFB;
                    String str11 = bVar.vBT.vJh;
                    String str12 = bVar.vBT.wBf;
                    x.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[]{str5, str2, o.getString(i5), str3, str6, str4, Integer.valueOf(i6), str7, str8, Integer.valueOf(i7), Integer.valueOf(i8), bh.VT(str9), str10, Integer.valueOf(0), bh.VT(str11), bh.VT(null), bh.VT(null), bh.VT(null), Integer.valueOf(-1), str12, Integer.valueOf(0)});
                    t CU = g.Dj().CU();
                    aq.hfP.S("login_weixin_username", str5);
                    aq.hfP.S("last_login_nick_name", str3);
                    aq.hfP.c(str4, i5, str6);
                    CU.set(2, str5);
                    CU.set(42, str2);
                    CU.set(9, Integer.valueOf(i5));
                    CU.set(4, str3);
                    CU.set(5, str6);
                    CU.set(6, str4);
                    CU.set(7, Integer.valueOf(i6));
                    CU.set(21, str7);
                    CU.set(22, str8);
                    CU.set(57, Integer.valueOf(0));
                    CU.set(17, Integer.valueOf(i7));
                    CU.set(25, Integer.valueOf(i8));
                    CU.set(1, str9);
                    CU.set(29, str10);
                    CU.set(34, Integer.valueOf(0));
                    CU.set(256, Boolean.valueOf(false));
                    x.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
                    CU.set(-1535680990, str11);
                    CU.set(46, null);
                    CU.set(72, null);
                    CU.set(64, Integer.valueOf(-1));
                    CU.lH(true);
                    ((PluginAuth) g.k(PluginAuth.class)).getHandleAuthResponseCallbacks().a(bVar, this.hNS, this.hNT, this.hNP, this.hNR, 0);
                }
                as.a(false, bVar.vBT.vMr, bVar.vBT.vMs, bVar.vBT.vMq);
                g.Dj().CU().lH(true);
                g.CG().a(new bd(new 2(this, bVar)), 0);
                x.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.vBT.wBi);
                this.hNW = (bVar.vBT.wBi & 1) != 0;
            }
            List linkedList = new LinkedList();
            linkedList.add(new i.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((h) g.h(h.class)).EX().b(new i(linkedList));
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jd(Og());
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final byte[] Oo() {
        return n.a(((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.wnN, new byte[0]);
    }

    public final String Op() {
        return ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.wnK;
    }

    public final String Sh() {
        return ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.wBm;
    }

    public final int Og() {
        bin com_tencent_mm_protocal_c_bin = ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 1) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                }
            }
        }
        return 0;
    }

    public final String Si() {
        bin com_tencent_mm_protocal_c_bin = ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.vJk;
        String str = "";
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 2) {
                    return com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
        }
        return str;
    }

    public final int Sj() {
        bin com_tencent_mm_protocal_c_bin = ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 3) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 2);
                }
            }
        }
        return 2;
    }

    public final String Sk() {
        bin com_tencent_mm_protocal_c_bin = ((com.tencent.mm.protocal.y.b) this.hnp.Hp()).vBT.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 17) {
                    return com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
        }
        return null;
    }
}
