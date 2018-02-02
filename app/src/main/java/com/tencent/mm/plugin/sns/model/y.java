package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.protocal.c.bky;
import com.tencent.mm.protocal.c.bkz;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class y extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    private int hBH;
    public String hBn;
    int hBo;
    private a hBx;
    private int hlp;
    private int offset;
    private String path;
    private int qQY;
    private String qUG;
    private bky qUH;
    private String qUI;
    private boolean qUJ;
    private boolean qUK;
    private boolean qUL;
    long qUM;
    int qUN;
    long startTime;

    static /* synthetic */ void a(y yVar, int i) {
        for (int i2 : com.tencent.mm.modelcdntran.a.hrI) {
            if (i == i2) {
                yVar.wz(0);
                return;
            }
        }
        yVar.onError();
    }

    public y(int i, String str, boolean z, int i2) {
        this.hBH = 8192;
        this.offset = 0;
        this.path = "";
        this.qUG = "";
        this.qQY = 0;
        this.qUI = "";
        this.hBn = "";
        this.qUJ = false;
        this.qUK = false;
        this.qUL = false;
        this.qUM = 0;
        this.startTime = 0;
        this.hBo = 0;
        this.qUN = 0;
        this.hBx = new a(this) {
            final /* synthetic */ y qUO;

            {
                this.qUO = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    x.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qUO.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.qUO.gJT.a(3, -1, "doScene failed", this.qUO);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qUO.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.qUO.a(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, 1, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, 1, "upload_" + this.qUO.hBn, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    x.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.qUO.qUM) + " " + com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    g.pQN.h(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.qUO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qUO.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.qUO.gJT.a(0, 0, "doScene", this.qUO);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qUO.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    if (this.qUO.qUN == 21) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -10000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -20000) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(10);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -20000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= -22000) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(11);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -5103000 || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode < -5103087) {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(15);
                        } else {
                            com.tencent.mm.plugin.sns.lucky.a.b.pY(9);
                        }
                    }
                    y.a(this.qUO, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    g.pQN.h(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qUO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qUO.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.pQN.h(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.qUO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qUO.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.qUO.gJT.a(3, -1, "doScene failed", this.qUO);
                    return 0;
                } else if (i != 0) {
                    x.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qUO.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.qUO.wz(0);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        g.pQN.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.qUO.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(this.qUO.hBo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    this.qUO.gJT.a(3, -1, "doScene failed", this.qUO);
                    return 0;
                } else {
                    x.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.qUO.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        this.qUM = System.currentTimeMillis();
        this.qQY = i;
        this.qUI = str;
        this.qUN = i2;
        b.a aVar = new b.a();
        aVar.hmj = new bky();
        aVar.hmk = new bkz();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.hmi = 207;
        aVar.hml = 95;
        aVar.hmm = 1000000095;
        this.gJQ = aVar.JZ();
        this.qUH = (bky) this.gJQ.hmg.hmo;
        q eS = ae.bvk().eS((long) i);
        this.qUL = z;
        x.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + eS.offset + " path " + eS.rpp + " totallen " + eS.rpo);
        if (!z) {
            this.qUH.wzw = 1;
            x.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            this.qUG = i.JH(eS.rpp);
            this.path = am.r(ae.getAccSnsPath(), eS.rpp) + this.qUG;
            this.hlp = (int) FileOp.me(this.path);
            this.qUJ = i.JQ(this.path);
            x.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.hlp + " isLongPic: " + this.qUJ);
            String str2 = com_tencent_mm_protocal_c_aqu.wyB;
            if (bh.ov(str2)) {
                str2 = com.tencent.mm.a.g.s((bh.Wq()).getBytes());
                com_tencent_mm_protocal_c_aqu.wyB = str2;
                try {
                    eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
                    ae.bvk().a(eS.roJ, eS);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.qUH.vIB = this.hlp;
            this.qUH.vIC = eS.offset;
            this.qUH.vGQ = str2;
            this.hBn = str2;
            x.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + com_tencent_mm_protocal_c_aqu.wya);
            this.qUH.wya = com_tencent_mm_protocal_c_aqu.wya;
            x.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + com_tencent_mm_protocal_c_aqu.wyb);
            this.qUH.vIO = com_tencent_mm_protocal_c_aqu.nfe;
            this.qUH.wyb = com_tencent_mm_protocal_c_aqu.wyb;
            x.i("MicroMsg.NetSceneMMSnsUpload", "request upload type " + eS.type + " md5: " + com_tencent_mm_protocal_c_aqu.fqR + " appid " + com_tencent_mm_protocal_c_aqu.fFm + " contenttype " + com_tencent_mm_protocal_c_aqu.afu);
            this.qUH.ktN = eS.type;
            bos com_tencent_mm_protocal_c_bos = new bos();
            com_tencent_mm_protocal_c_bos.wRe = com_tencent_mm_protocal_c_aqu.token;
            com_tencent_mm_protocal_c_bos.wRf = com_tencent_mm_protocal_c_aqu.wyk;
            this.qUH.wEF = com_tencent_mm_protocal_c_bos;
            if (!bh.ov(com_tencent_mm_protocal_c_aqu.fqR)) {
                this.qUH.vZU = com_tencent_mm_protocal_c_aqu.fqR;
            }
            if (!bh.ov(com_tencent_mm_protocal_c_aqu.fFm)) {
                this.qUH.ngo = com_tencent_mm_protocal_c_aqu.fFm;
            }
            this.qUH.wOq = com_tencent_mm_protocal_c_aqu.afu;
            if (r.icW) {
                this.qUH.ktN = 0;
            }
            if (this.startTime == 0) {
                this.startTime = bh.Wp();
                this.hBo = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            }
            bky com_tencent_mm_protocal_c_bky = this.qUH;
            com.tencent.mm.modelcdntran.g.MJ();
            if (!c.hu(32)) {
                Object[] objArr = new Object[1];
                com.tencent.mm.modelcdntran.g.MJ();
                objArr[0] = Boolean.valueOf(c.hu(32));
                x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (r.idL == 2) {
                obj = null;
            } else {
                this.hBn = com_tencent_mm_protocal_c_bky.vGQ;
                if (bh.ov(this.hBn)) {
                    x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.qUK = true;
            } else if (!buT()) {
                onError();
            }
        } catch (Exception e2) {
            x.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    private boolean buT() {
        q eS = ae.bvk().eS((long) this.qQY);
        int i = eS.rpo - eS.offset;
        if (i > this.hBH) {
            i = this.hBH;
        }
        this.offset = eS.offset;
        byte[] d = FileOp.d(this.path, this.offset, i);
        if (d == null || d.length <= 0) {
            return false;
        }
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(d);
        this.qUH.vKf = com_tencent_mm_protocal_c_bdn;
        this.qUH.vIC = this.offset;
        return true;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        if (this.qUJ) {
            return 675;
        }
        return 100;
    }

    public final int getType() {
        return 207;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkz com_tencent_mm_protocal_c_bkz = (bkz) ((b) qVar).hmh.hmo;
        if (i2 == 4) {
            wz(i3);
            if (this.qUN == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.pY(12);
            }
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            q eS = ae.bvk().eS((long) this.qQY);
            if (com_tencent_mm_protocal_c_bkz.vIC < 0 || (com_tencent_mm_protocal_c_bkz.vIC > eS.rpo && eS.rpo > 0)) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.pY(14);
                }
            } else if (com_tencent_mm_protocal_c_bkz.vIC < eS.offset) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.pY(14);
                }
            } else {
                x.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + com_tencent_mm_protocal_c_bkz.wOr.nfX + " bufferUrlType: " + com_tencent_mm_protocal_c_bkz.wOr.ktN + "  id:" + com_tencent_mm_protocal_c_bkz.vPO + " thumb Count: " + com_tencent_mm_protocal_c_bkz.wyy + "  type " + com_tencent_mm_protocal_c_bkz.ktN + " startPos : " + com_tencent_mm_protocal_c_bkz.vIC);
                eS.offset = com_tencent_mm_protocal_c_bkz.vIC;
                ae.bvk().a(this.qQY, eS);
                Object obj = (eS.offset != eS.rpo || eS.rpo == 0) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.qUM));
                    if (com_tencent_mm_protocal_c_bkz.wyz.size() == 0 || com_tencent_mm_protocal_c_bkz.wyz.size() <= 0) {
                        a(com_tencent_mm_protocal_c_bkz.wOr.nfX, com_tencent_mm_protocal_c_bkz.wOr.ktN, "", 0, com_tencent_mm_protocal_c_bkz.vPO, this.qUH.vZU);
                    } else {
                        a(com_tencent_mm_protocal_c_bkz.wOr.nfX, com_tencent_mm_protocal_c_bkz.wOr.ktN, ((bjh) com_tencent_mm_protocal_c_bkz.wyz.get(0)).nfX, ((bjh) com_tencent_mm_protocal_c_bkz.wyz.get(0)).ktN, com_tencent_mm_protocal_c_bkz.vPO, this.qUH.vZU);
                    }
                    this.gJT.a(i2, i3, str, this);
                } else if (buT() && a(this.hmA, this.gJT) < 0) {
                    this.gJT.a(3, -1, "doScene failed", this);
                }
            }
        } else {
            onError();
            if (this.qUN == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.pY(13);
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3, String str4) {
        aqu com_tencent_mm_protocal_c_aqu;
        q eS = ae.bvk().eS((long) this.qQY);
        x.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(this.path, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i3 = -1;
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg")) {
            i3 = MMNativeJpeg.queryQuality(this.path);
            if (i3 == 0) {
                i3 = -1;
            }
        }
        com.tencent.mm.plugin.sns.h.c.a(str, options.outMimeType, options.outWidth, options.outHeight, i3, FileOp.me(this.path));
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
        com_tencent_mm_protocal_c_aqo.ktN = i;
        com_tencent_mm_protocal_c_aqo.nfX = str;
        com_tencent_mm_protocal_c_aqu.wyx = com_tencent_mm_protocal_c_aqo;
        com_tencent_mm_protocal_c_aqu.wyA = 0;
        com_tencent_mm_protocal_c_aqu.fqR = str4;
        if (!bh.ov(str2)) {
            com_tencent_mm_protocal_c_aqo = new aqo();
            com_tencent_mm_protocal_c_aqo.ktN = i2;
            com_tencent_mm_protocal_c_aqo.nfX = str2;
            com_tencent_mm_protocal_c_aqu.wyz.add(com_tencent_mm_protocal_c_aqo);
        }
        try {
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
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
        q eS = ae.bvk().eS((long) this.qQY);
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            com_tencent_mm_protocal_c_aqu.wyA = 1;
            com_tencent_mm_protocal_c_aqu.wyj = i;
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
        } catch (Exception e) {
        }
        ae.bvu().wE(this.qQY);
        ae.bvk().a(this.qQY, eS);
    }

    private void onError() {
        q eS = ae.bvk().eS((long) this.qQY);
        eS.offset = 0;
        try {
            aqu com_tencent_mm_protocal_c_aqu = (aqu) new aqu().aF(eS.rpt);
            com_tencent_mm_protocal_c_aqu.wyB = "";
            eS.rpt = com_tencent_mm_protocal_c_aqu.toByteArray();
            ae.bvk().a(this.qQY, eS);
            ae.bvu().wE(this.qQY);
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    protected final void cancel() {
        super.cancel();
        if (this.qUK && !bh.ov(this.hBn)) {
            x.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.hBn);
            com.tencent.mm.modelcdntran.g.MJ().kH(this.hBn);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 108;
        this.gJT = eVar2;
        if (!this.qUK) {
            return a(eVar, this.gJQ, this);
        }
        this.hBn = this.qUH.vGQ;
        if (bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        } else {
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.htt = this.hBx;
            iVar.field_mediaId = this.hBn;
            iVar.field_fullpath = this.path;
            iVar.field_thumbpath = "";
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            iVar.field_talker = "";
            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
            iVar.field_needStorage = true;
            iVar.field_isStreamMedia = false;
            if (com.tencent.mm.plugin.sns.storage.r.byP()) {
                if (!this.qUL) {
                    i = 107;
                }
                iVar.field_appType = i;
            } else if (com.tencent.mm.plugin.sns.storage.r.byO()) {
                if (!this.qUL) {
                    i = 107;
                }
                iVar.field_appType = i;
            } else {
                com.tencent.mm.modelcdntran.g.MJ();
                if (c.hu(64)) {
                    iVar.field_appType = this.qUL ? 104 : 103;
                } else {
                    iVar.field_appType = this.qUL ? 101 : 100;
                }
            }
            iVar.field_bzScene = 1;
            if (!com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                x.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{this.hBn});
                this.hBn = "";
            }
        }
        return 0;
    }
}
