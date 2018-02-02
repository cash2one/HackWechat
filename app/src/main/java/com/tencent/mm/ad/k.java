package com.tencent.mm.ad;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import java.io.OutputStream;

final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gJT;
    private int hlE;
    private OutputStream hlF = null;
    private String hlG;
    private String hli;
    private int hlm;
    private String hlo;
    private String username;

    public k(String str) {
        this.username = str;
        if (x.gy(str)) {
            this.username = x.WD(str);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.hlm = 480;
        this.hlE = 480;
        this.hlo = "jpg";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gJT = eVar2;
        if (this.username == null || this.username.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            return -1;
        } else {
            g JR = n.JR();
            n.Jz();
            this.hli = d.x(this.username, true);
            if (FileOp.bO(this.hli)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                return 0;
            }
            f fVar;
            this.hlG = this.hli + ".tmp";
            f jk = JR.jk(this.username);
            if (jk == null) {
                FileOp.deleteFile(this.hlG);
                jk = new f();
                jk.username = this.username;
                jk.hlo = this.hlo;
                jk.hlm = this.hlm;
                jk.hln = this.hlE;
                jk.fDt = -1;
                JR.hhp.insert("hdheadimginfo", "username", jk.vI());
                fVar = jk;
            } else {
                String str = this.hlG;
                if (jk != null && str != null && str.length() != 0 && jk.JE().equals(this.hlo) && jk.hlm == this.hlm && jk.hln == this.hlE && FileOp.me(str) == ((long) jk.hlq)) {
                    z = true;
                }
                if (!z) {
                    FileOp.deleteFile(this.hlG);
                    jk.reset();
                    jk.username = this.username;
                    jk.hlo = this.hlo;
                    jk.hlm = this.hlm;
                    jk.hln = this.hlE;
                    JR.a(this.username, jk);
                }
                fVar = jk;
            }
            a aVar = new a();
            aVar.hmj = new acp();
            aVar.hmk = new acq();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.hmi = 158;
            aVar.hml = 47;
            aVar.hmm = 1000000047;
            q JZ = aVar.JZ();
            acp com_tencent_mm_protocal_c_acp = (acp) JZ.hmg.hmo;
            if (!x.gy(this.username)) {
                com_tencent_mm_protocal_c_acp.ksU = this.username;
                com_tencent_mm_protocal_c_acp.wln = 1;
            } else if (this.username.equals(com.tencent.mm.z.q.FS() + "@bottle")) {
                com_tencent_mm_protocal_c_acp.ksU = com.tencent.mm.z.q.FS();
                com_tencent_mm_protocal_c_acp.wln = 2;
            } else {
                com_tencent_mm_protocal_c_acp.ksU = this.username;
                com_tencent_mm_protocal_c_acp.wln = 2;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + com_tencent_mm_protocal_c_acp.ksU + " outType:" + com_tencent_mm_protocal_c_acp.wln);
            com_tencent_mm_protocal_c_acp.wlk = this.hlm;
            com_tencent_mm_protocal_c_acp.wll = this.hlE;
            com_tencent_mm_protocal_c_acp.wlm = this.hlo;
            com_tencent_mm_protocal_c_acp.vIB = fVar.hlp;
            com_tencent_mm_protocal_c_acp.vIC = fVar.hlq;
            return a(eVar, JZ, this);
        }
    }

    protected final int a(q qVar) {
        if (this.username == null || this.username.length() == 0) {
            return b.hmQ;
        }
        return b.hmP;
    }

    protected final int Bh() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        acq com_tencent_mm_protocal_c_acq = (acq) ((b) qVar).hmh.hmo;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
            JJ();
        } else if (i2 == 4 || i2 == 5) {
            this.gJT.a(i2, i3, str, this);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:" + i2);
            JJ();
        } else {
            Object obj;
            int i4 = qVar.Hp().vBp;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == " + i4);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.gJT.a(i2, i3, str, this);
                JJ();
                return;
            }
            i4 = -1;
            if (!(com_tencent_mm_protocal_c_acq.vXz == null || com_tencent_mm_protocal_c_acq.vXz.wJD == null)) {
                i4 = F(com_tencent_mm_protocal_c_acq.vXz.wJD.oz);
            }
            if (i4 < 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.gJT.a(i2, i3, str, this);
                JJ();
                return;
            }
            g JR = n.JR();
            f jk = JR.jk(this.username);
            jk.hlq = i4 + com_tencent_mm_protocal_c_acq.vIC;
            jk.hlp = com_tencent_mm_protocal_c_acq.vIB;
            JR.a(this.username, jk);
            if ((jk.hlq >= jk.hlp ? 1 : null) == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(jk.hlq), Integer.valueOf(jk.hlp));
                if (a(this.hmA, this.gJT) < 0) {
                    this.gJT.a(3, -1, "", this);
                    return;
                }
                return;
            }
            FileOp.at(this.hlG, this.hli);
            ad(this.hli, this.username);
            JJ();
            this.gJT.a(i2, i3, str, this);
        }
    }

    public static void ad(String str, String str2) {
        n.Jz().ac(str, str2);
    }

    protected final void cancel() {
        super.cancel();
        JJ();
    }

    public final int getType() {
        return 158;
    }

    private int F(byte[] bArr) {
        try {
            if (this.hlF == null) {
                this.hlF = FileOp.iE(this.hlG);
            }
            this.hlF.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bh.i(e));
            return -1;
        }
    }

    private void JJ() {
        try {
            if (this.hlF != null) {
                this.hlF.flush();
                this.hlF.close();
                this.hlF = null;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bh.i(e));
        }
    }
}
