package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ab {
    private String beo;
    private String clientId;
    private String fvC;
    String hBn;
    int hBo;
    private i$a hBx;
    int hVm;
    private String jcx;
    private int qQY;
    private long qUM;
    q qVd;
    a qVe;
    private aqu qVf;
    long startTime;

    static /* synthetic */ void a(ab abVar) {
        try {
            abVar.qVf = (aqu) new aqu().aF(abVar.qVd.rpt);
            abVar.jcx = g.bV(abVar.beo);
            abVar.qVf.fqR = abVar.jcx;
            abVar.qVd.rpt = abVar.qVf.toByteArray();
            x.i("MicroMsg.SightCdnUpload", "new md5 is %s %s", new Object[]{abVar.beo, abVar.jcx});
            ae.bvk().a(abVar.qVd.roJ, abVar.qVd);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[]{e.getMessage()});
        }
    }

    public ab(int i, q qVar, String str, String str2, a aVar) {
        this.clientId = "";
        this.qUM = 0;
        this.startTime = 0;
        this.hBo = 0;
        this.jcx = "";
        this.qVf = new aqu();
        this.hBx = new 4(this);
        this.qUM = System.currentTimeMillis();
        this.beo = str;
        this.fvC = str2;
        this.qVe = aVar;
        this.qQY = i;
        this.qVd = qVar;
        try {
            this.qVf = (aqu) new aqu().aF(qVar.rpt);
            this.clientId = this.qVf.wyB;
            this.jcx = this.qVf.fqR;
            if (bh.ov(this.clientId)) {
                this.clientId = g.s((bh.Wq()).getBytes());
                this.qVf.wyB = this.clientId;
                try {
                    qVar.rpt = this.qVf.toByteArray();
                    ae.bvk().a(qVar.roJ, qVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int me = (int) FileOp.me(str);
            x.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(me), this.jcx});
        } catch (Exception e2) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    public final boolean buV() {
        String bV = g.bV(this.beo);
        if (bh.ov(this.jcx) || this.jcx.equals(bV)) {
            aqc com_tencent_mm_protocal_c_aqc;
            if (this.qVf.wyE != null) {
                com_tencent_mm_protocal_c_aqc = this.qVf.wyE;
            } else {
                com_tencent_mm_protocal_c_aqc = new aqc();
            }
            x.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", new Object[]{this.beo, Integer.valueOf(com_tencent_mm_protocal_c_aqc.wwQ), Boolean.valueOf(com_tencent_mm_protocal_c_aqc.wwP)});
            if (com_tencent_mm_protocal_c_aqc.wwP) {
                int i = h.osS;
                if (com_tencent_mm_protocal_c_aqc.wwQ >= 3) {
                    onError();
                    return false;
                }
                x.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[]{Integer.valueOf(i), this.beo});
                b qeVar = new qe();
                qeVar.fqI = new 1(this, qeVar, com_tencent_mm_protocal_c_aqc);
                qeVar.fHN.fHR = new 2(this);
                qeVar.fHN.fHA = this.beo;
                qeVar.fHN.scene = i;
                qeVar.fHN.fHP = com_tencent_mm_protocal_c_aqc;
                qeVar.fHN.fHQ = new 3(this, com_tencent_mm_protocal_c_aqc);
                a.xef.a(qeVar, ae.bvi().getLooper());
                return true;
            }
            a(com_tencent_mm_protocal_c_aqc);
            return true;
        }
        x.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.jcx, bV});
        wz(-2);
        this.qVe.ij(false);
        return false;
    }

    final boolean a(aqc com_tencent_mm_protocal_c_aqc) {
        if (this.startTime == 0) {
            this.startTime = bh.Wp();
            this.hBo = com.tencent.mm.modelcdntran.b.hrO;
        }
        String str = this.clientId;
        if (bh.ov(str)) {
            x.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            return false;
        }
        i iVar = new i();
        iVar.htt = this.hBx;
        iVar.field_mediaId = str;
        iVar.field_fullpath = this.beo;
        iVar.field_thumbpath = this.fvC;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrO;
        iVar.field_talker = "";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
        iVar.field_needStorage = true;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 102;
        iVar.field_bzScene = 1;
        iVar.field_largesvideo = true;
        String bV = g.bV(this.beo);
        if (!bh.ov(this.jcx) && !this.jcx.equals(bV)) {
            x.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.jcx, bV});
            wz(-2);
            this.qVe.ij(false);
            return false;
        } else if (com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
            int i = (com_tencent_mm_protocal_c_aqc == null || !com_tencent_mm_protocal_c_aqc.wwP) ? 5 : 4;
            this.hVm = i;
            return true;
        } else {
            x.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{str});
            return false;
        }
    }

    public final boolean T(String str, String str2, String str3) {
        aqu com_tencent_mm_protocal_c_aqu;
        q eS = ae.bvk().eS((long) this.qQY);
        x.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
        eS.rps = str3;
        try {
            com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
        } catch (Exception e) {
            com_tencent_mm_protocal_c_aqu = null;
        }
        if (com_tencent_mm_protocal_c_aqu == null) {
            com_tencent_mm_protocal_c_aqu = new aqu();
        }
        aqo com_tencent_mm_protocal_c_aqo = new aqo();
        com_tencent_mm_protocal_c_aqo.ktN = 1;
        com_tencent_mm_protocal_c_aqo.nfX = str;
        com_tencent_mm_protocal_c_aqu.wyx = com_tencent_mm_protocal_c_aqo;
        com_tencent_mm_protocal_c_aqu.wyA = 0;
        com.tencent.mm.modelcdntran.g.MK();
        com_tencent_mm_protocal_c_aqu.wxZ = com.tencent.mm.modelcdntran.b.kD(this.beo);
        x.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[]{com_tencent_mm_protocal_c_aqu.wxZ});
        if (!bh.ov(str2)) {
            com_tencent_mm_protocal_c_aqo = new aqo();
            com_tencent_mm_protocal_c_aqo.ktN = 1;
            com_tencent_mm_protocal_c_aqo.nfX = str2;
            com_tencent_mm_protocal_c_aqu.wyz.add(com_tencent_mm_protocal_c_aqo);
        }
        try {
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
        }
        eS.byN();
        ae.bvk().a(this.qQY, eS);
        ae.bvu().wE(this.qQY);
        if (ae.bvr() != null) {
            ae.bvr().buj();
        }
        return true;
    }

    final void wz(int i) {
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q eS = ae.bvk().eS((long) this.qQY);
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            com_tencent_mm_protocal_c_aqu.wyA = 1;
            com_tencent_mm_protocal_c_aqu.wyj = i;
            if (this.qVf.wyE != null) {
                this.qVf.wyE.wwQ = 0;
            }
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Exception e) {
        }
        ae.bvu().wE(this.qQY);
        ae.bvk().a(this.qQY, eS);
    }

    final void onError() {
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q eS = ae.bvk().eS((long) this.qQY);
        eS.offset = 0;
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            com_tencent_mm_protocal_c_aqu.wyB = "";
            if (com_tencent_mm_protocal_c_aqu.wyE != null) {
                com_tencent_mm_protocal_c_aqu.wyE.wwQ = 0;
            }
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
            ae.bvk().a(this.qQY, eS);
            ae.bvu().wE(this.qQY);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }
}
