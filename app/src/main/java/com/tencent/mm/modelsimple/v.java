package com.tencent.mm.modelsimple;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.a;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.c.aq;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.as;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.y;
import java.util.Iterator;

public final class v extends k implements com.tencent.mm.network.k {
    private int errCode;
    private int errType;
    e gJT;
    private int hNA;
    private int hNB;
    public String hNC;
    private boolean hND;
    public String hNv;
    private String hNw;
    private String hNx;
    private boolean hNy;
    private boolean hNz;
    private int hmS;
    public final q hnp;

    public v(int i, String str, String str2, String str3) {
        this("", "", i, str, str2, str3, 0, "", false, false);
    }

    public v(String str, String str2, String str3, int i) {
        this(str, str2, 0, "", "", "", i, str3, false, false);
    }

    public v(String str, String str2, String str3, String str4) {
        this(str2, str3, 0, "", "", "", 0, str4, true, false);
        this.hNC = str;
    }

    public v(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        this.hNw = "";
        this.hNx = "";
        this.hNy = false;
        this.hNz = false;
        this.errType = 0;
        this.errCode = 0;
        this.hmS = 3;
        this.hNA = 0;
        this.hNB = 0;
        this.hND = false;
        x.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " useRawPwd: " + z + " isMobileAutoLogin: " + z2 + " stack: " + bh.cgy());
        this.hNz = z2;
        this.hNv = str;
        this.hnp = new as(701);
        d dVar = (d) this.hnp.Kb();
        int i3 = as.Hn().getInt("key_auth_update_version", 0);
        x.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.vAz)});
        if (i3 == 0) {
            dVar.vBj = 1;
            com.tencent.mm.plugin.report.d.pPH.a(148, 0, 1, false);
            dVar.vAX = true;
        } else if (i3 < com.tencent.mm.protocal.d.vAz) {
            dVar.vBj = 16;
            com.tencent.mm.plugin.report.d.pPH.a(148, 1, 1, false);
        } else {
            dVar.vBj = 1;
        }
        dVar.eE(0);
        aqf com_tencent_mm_protocal_c_aqf = new aqf();
        aqd com_tencent_mm_protocal_c_aqd = new aqd();
        dVar.vAW.wwY = com_tencent_mm_protocal_c_aqf;
        dVar.vAW.wwZ = com_tencent_mm_protocal_c_aqd;
        com_tencent_mm_protocal_c_aqd.wwX = i2;
        fb fbVar = new fb();
        com_tencent_mm_protocal_c_aqd.vJw = fbVar;
        fbVar.vJl = str6;
        fbVar.vKU = 0;
        fbVar.vJg = new bdn().bj(new byte[0]);
        fbVar.vJf = new bdn().bj(new byte[0]);
        bwv com_tencent_mm_protocal_c_bwv = new bwv();
        fbVar.vKS = com_tencent_mm_protocal_c_bwv;
        com_tencent_mm_protocal_c_bwv.vMD = "";
        com_tencent_mm_protocal_c_bwv.vMC = "";
        com_tencent_mm_protocal_c_bwv.wXK = "";
        cak com_tencent_mm_protocal_c_cak = new cak();
        fbVar.vKT = com_tencent_mm_protocal_c_cak;
        com_tencent_mm_protocal_c_cak.wnL = "";
        com_tencent_mm_protocal_c_cak.wnK = "";
        if (i == 1) {
            com_tencent_mm_protocal_c_bwv.vMD = str3;
            com_tencent_mm_protocal_c_bwv.vMC = str4;
            com_tencent_mm_protocal_c_bwv.wXK = str5;
            com_tencent_mm_protocal_c_cak.wnL = "";
            com_tencent_mm_protocal_c_cak.wnK = "";
        } else if (i == 3) {
            com_tencent_mm_protocal_c_bwv.vMD = "";
            com_tencent_mm_protocal_c_bwv.vMC = "";
            com_tencent_mm_protocal_c_bwv.wXK = "";
            com_tencent_mm_protocal_c_cak.wnL = str3;
            com_tencent_mm_protocal_c_cak.wnK = str4;
        }
        if (bh.ov(str) && g.Dh().Cy()) {
            com.tencent.mm.plugin.report.d.pPH.a(148, 2, 1, false);
            this.hNw = (String) g.Dj().CU().get(3, null);
            this.hNx = (String) g.Dj().CU().get(19, null);
            i.e eVar = (i.e) this.hnp.Hp();
            str = bh.ou((String) g.Dj().CU().get(2, null));
            if (bh.ov(str)) {
                str = new o(bh.a((Integer) g.Dj().CU().get(9, null), 0)).toString();
            } else {
                eVar.hZv = str;
            }
        } else if (z || z2) {
            this.hNw = str2;
            this.hNx = str2;
        } else {
            this.hNw = bh.VB(bh.ou(str2));
            this.hNx = bh.VC(bh.ou(str2));
        }
        com_tencent_mm_protocal_c_aqf.ksU = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = g.Dh().Cq().c(bh.getLong(str, 0), str3);
            } else if (bh.Vs(str)) {
                bArr = g.Dh().Cq().a(bh.getLong(str, 0), this.hNx, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = bh.VT(bh.bv(bArr));
        x.i(str7, str8, objArr);
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        if (bh.bw(bArr)) {
            bArr = new byte[0];
        }
        fbVar.vKR = com_tencent_mm_protocal_c_bdn.bj(bArr);
        com_tencent_mm_protocal_c_aqf.vMp = this.hNx;
        com_tencent_mm_protocal_c_aqf.vMB = this.hNw;
    }

    public final void mw(String str) {
        d dVar = (d) this.hnp.Kb();
        dVar.vAW.wwY.vMp = str;
        dVar.vAW.wwY.vMB = str;
        dVar.vAW.wwZ.vJw.vKR = new bdn().bj(new byte[0]);
        this.hNw = str;
        this.hNx = str;
    }

    public final int getType() {
        return 701;
    }

    protected final int Bh() {
        return 5;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final v RX() {
        this.hND = true;
        return this;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        d dVar = (d) qVar.Kb();
        i.e eVar = (i.e) qVar.Hp();
        if (eVar.vAZ == null || eVar.vAZ.wRq == null) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual not set as ret:%s", new Object[]{Integer.valueOf(eVar.vBp)});
        } else {
            i4 = eVar.vAZ.wRq.vJp;
            x.i("MicroMsg.NetSceneManualAuth", "summerauth mmtls manual:%s", new Object[]{Integer.valueOf(i4)});
            g.Dk();
            g.Dj().gQd.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar2 = g.Di().gPJ.hmV;
            if (eVar2 != null) {
                eVar2.bH((i4 & 1) == 0);
            }
        }
        this.errType = i2;
        this.errCode = i3;
        bpb com_tencent_mm_protocal_c_bpb = eVar.vAZ;
        if (com_tencent_mm_protocal_c_bpb == null) {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.gJT.a(4, -1, "", this);
            com.tencent.mm.plugin.report.d.pPH.a(148, 3, 1, false);
            return;
        }
        x.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, com_tencent_mm_protocal_c_bpb, Integer.valueOf(com_tencent_mm_protocal_c_bpb.wRp), com_tencent_mm_protocal_c_bpb.wRq, com_tencent_mm_protocal_c_bpb.wRr, com_tencent_mm_protocal_c_bpb.wRs});
        int i5;
        if (i2 == 0 && i3 == 0) {
            if ((i4 & 2) != 0) {
                aq aqVar = com_tencent_mm_protocal_c_bpb.wRr;
                if (aqVar == null || bh.ov(aqVar.ksU)) {
                    x.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.gJT.a(4, -1, "", this);
                    return;
                } else if (as.b(qVar) == 2) {
                    com.tencent.mm.plugin.report.d.pPH.a(148, 7, 1, false);
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[]{Integer.valueOf(this.hNB)});
                    this.hNB++;
                    if (this.hNB > 1) {
                        this.gJT.a(4, -1, "", this);
                        return;
                    }
                    ((d) this.hmG.Kb()).vAW.wwZ.vJw.vKU = 1;
                    a(this.hmA, this.gJT);
                    return;
                } else {
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
                    g.Dm().tS();
                    x.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid()))});
                    y.a(eVar.vAZ, false);
                    ((PluginAuth) g.k(PluginAuth.class)).getHandleAuthResponseCallbacks().a(dVar, eVar, false);
                    if (!bh.ov(this.hNv)) {
                        g.Dj().CU().a(w.a.xxM, this.hNv);
                        com.tencent.mm.z.aq.hfP.S("login_user_name", this.hNv);
                    }
                    if (this.hNz) {
                        g.Dj().CU().set(2, dVar.vAW.wwY.ksU);
                    }
                    g.Di().gPJ.a(new bd(new 2(this, eVar)), 0);
                    if (bh.e((Integer) g.Dj().CU().get(15, null)) != 0) {
                        ((com.tencent.mm.plugin.zero.b.b) g.h(com.tencent.mm.plugin.zero.b.b.class)).Qc().id(10);
                    }
                    if ((com_tencent_mm_protocal_c_bpb.wRq.vJo & 8) == 0) {
                        Object FS = com.tencent.mm.z.q.FS();
                        if (!TextUtils.isEmpty(FS)) {
                            g.Di().gPJ.a(new r(FS), 0);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bpb.wRq.vJo)});
                        com.tencent.mm.plugin.report.d.pPH.a(148, 9, 1, false);
                    }
                    int i6 = 4;
                    if (dVar.vAW.wwZ.vJw.vKR != null && dVar.vAW.wwZ.vJw.vKR.wJB > 0) {
                        i6 = 1;
                    } else if (dVar.vAW.wwZ.wwX == 1) {
                        i6 = 2;
                    }
                    com.tencent.mm.plugin.report.b.d.n(1, i6, dVar.vAW.wwY.ksU);
                    if (i2 == 0 && i3 == 0) {
                        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
                        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
                            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
                            while (it.hasNext()) {
                                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                                if (com_tencent_mm_protocal_c_bmg.pQj == 1) {
                                    i5 = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                                    break;
                                }
                            }
                        }
                        i5 = 0;
                        com.tencent.mm.plugin.c.b.jd(i5);
                        x.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        com.tencent.mm.sdk.b.b jhVar = new jh();
                        jhVar.fzJ.fnI = true;
                        com.tencent.mm.sdk.b.a.xef.m(jhVar);
                    }
                    g.Dm().cfE();
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
            }
            x.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.gJT.a(4, -1, "", this);
        } else if (i2 == 4 && i3 == -301) {
            x.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            com.tencent.mm.plugin.report.d.pPH.a(148, 4, 1, false);
            if (com_tencent_mm_protocal_c_bpb == null || com_tencent_mm_protocal_c_bpb.wRs == null) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                as.a(true, com_tencent_mm_protocal_c_bpb.wRs.vMr, com_tencent_mm_protocal_c_bpb.wRs.vMs, com_tencent_mm_protocal_c_bpb.wRs.vMq);
            }
            this.hmS--;
            if (this.hmS <= 0) {
                x.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.gJT.a(3, -1, "", this);
                return;
            }
            x.i("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[]{Integer.valueOf(this.hmS)});
            a(this.hmA, this.gJT);
        } else if (!this.hND && i2 == 4 && i3 == -102) {
            com.tencent.mm.plugin.report.d.pPH.a(148, 5, 1, false);
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            g.Dm().F(new 1(this, i5));
        } else if (i2 == 4 && i3 == -217) {
            this.gJT.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pPH.a(148, 47, 1, false);
        } else if (i2 == 4 && i3 == -218) {
            this.gJT.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pPH.a(148, 53, 1, false);
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.hmS)});
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
                return;
            }
            com.tencent.mm.plugin.report.d.pPH.a(148, 57, 1, false);
            a(this.hmA, this.gJT);
        } else {
            x.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), str});
            this.gJT.a(i2, i3, str, this);
            com.tencent.mm.plugin.report.d.pPH.a(148, 6, 1, false);
        }
    }

    public final int Oc() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return 3;
        }
        int i;
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 6) {
                    i = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 3);
                    break;
                }
            }
        }
        i = 3;
        return i;
    }

    public final String RY() {
        return ((i.e) this.hnp.Hp()).vAZ.wRq == null ? "" : ((i.e) this.hnp.Hp()).vAZ.wRq.vJj;
    }

    public final String Op() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return "";
        }
        int RZ = RZ();
        if (RZ == 3) {
            if (((i.e) this.hnp.Hp()).vAZ.wRq.vJe != null) {
                return bh.ou(((i.e) this.hnp.Hp()).vAZ.wRq.vJe.wnK);
            }
        } else if (RZ == 1 && ((i.e) this.hnp.Hp()).vAZ.wRq.vJd != null) {
            return bh.ou(((i.e) this.hnp.Hp()).vAZ.wRq.vJd.vMC);
        }
        return "";
    }

    public final byte[] Oo() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return new byte[0];
        }
        int RZ = RZ();
        if (RZ == 3) {
            if (((i.e) this.hnp.Hp()).vAZ.wRq.vJe != null) {
                return n.a(((i.e) this.hnp.Hp()).vAZ.wRq.vJe.wnN, new byte[0]);
            }
        } else if (RZ == 1) {
            if (((i.e) this.hnp.Hp()).vAZ.wRq.vJd != null) {
                return n.a(((i.e) this.hnp.Hp()).vAZ.wRq.vJd.vHb, new byte[0]);
            }
        } else if (RZ == 2 && ((d) this.hnp.Kb()).vAW.wwY != null) {
            g.Dh().Cq().a(bh.getLong(((d) this.hnp.Kb()).vAW.wwY.ksU, 0), n.a(((i.e) this.hnp.Hp()).vAZ.wRq.vJc));
            return g.Dh().Cq().aP(bh.getLong(((d) this.hnp.Kb()).vAW.wwY.ksU, 0));
        }
        return new byte[0];
    }

    public final int RZ() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            return 0;
        } else if (this.errType != 4) {
            x.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[]{Integer.valueOf(this.errType)});
            return 0;
        } else if (this.errCode == -311) {
            return 2;
        } else {
            if (this.errCode == -6) {
                return 1;
            }
            return this.errCode == -310 ? 3 : 0;
        }
    }

    public final String Sa() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return "";
        }
        if (RZ() != 1 || ((i.e) this.hnp.Hp()).vAZ.wRq.vJd == null) {
            return "";
        }
        return ((i.e) this.hnp.Hp()).vAZ.wRq.vJd.wXK != null ? ((i.e) this.hnp.Hp()).vAZ.wRq.vJd.wXK : null;
    }

    public final String NX() {
        return ((i.e) this.hnp.Hp()).vAZ.wRq.vJl;
    }

    public final String Sb() {
        return ((i.e) this.hnp.Hp()).vAZ.wRr.vFt;
    }

    public final int Sc() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return 0;
        }
        int i;
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 11) {
                    i = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final BindWordingContent Sd() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return null;
        }
        String str;
        BindWordingContent mr;
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 12) {
                    str = com_tencent_mm_protocal_c_bmg.wPM;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            a aVar = new a();
            try {
                mr = a.mr(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e, "", new Object[0]);
                mr = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneManualAuth", e2, "", new Object[0]);
            }
            return mr;
        }
        mr = null;
        return mr;
    }

    public final String Se() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return "";
        }
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 16) {
                    return com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
        }
        return "";
    }

    public final int Sf() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return 0;
        }
        int i;
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 13) {
                    i = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final boolean Sg() {
        if (((i.e) this.hnp.Hp()).vAZ.wRq == null) {
            return true;
        }
        bin com_tencent_mm_protocal_c_bin = ((i.e) this.hnp.Hp()).vAZ.wRq.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 18) {
                    if (bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
