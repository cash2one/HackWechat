package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bpx;
import com.tencent.mm.protocal.c.bpy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class ak extends k implements com.tencent.mm.network.k {
    a fnC = null;
    String fqu;
    private b gJQ;
    e gJT;
    private boolean gLT = false;
    int gLV = 0;
    keep_SceneResult gLW;
    c gLY = new 2(this);
    boolean hBF = true;
    String hBn = "";
    private i$a hBx = new 1(this);
    private String hbd = null;
    int retCode = 0;
    long startTime = 0;
    String toUser;
    b veF = null;
    long veI = -1;
    private boolean vfc = true;
    private long vfd = -1;

    public ak(long j, String str, String str2) {
        this.veI = j;
        this.hbd = str;
        this.fqu = str2;
        b.a aVar = new b.a();
        aVar.hmj = new bpx();
        aVar.hmk = new bpy();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.hmi = 220;
        aVar.hml = 105;
        aVar.hmm = 1000000105;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[]{Long.valueOf(j), str, bh.cgy()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        this.veF = new b();
        if (!an.aqd().b(this.veI, this.veF) || this.veF == null) {
            x.e("MicroMsg.NetSceneUploadAppAttach", g.zh() + " summerbig get info failed rowid:" + this.veI);
            this.retCode = -10000 - g.getLine();
            this.veF = null;
            return -1;
        } else if (this.veF.field_status != 101) {
            x.e("MicroMsg.NetSceneUploadAppAttach", g.zh() + " summerbig get field_status failed rowid:" + this.veI + " status:" + this.veF.field_status);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = bh.Wp();
                this.vfd = this.veF.field_offset;
            }
            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[]{Long.valueOf(this.veI), this.veF.field_fileFullPath, Long.valueOf(this.veF.field_totalLen), Boolean.valueOf(this.veF.field_isUpload), Integer.valueOf(this.veF.field_isUseCdn), Long.valueOf(this.veF.field_type)});
            if (bh.ov(this.veF.field_appId)) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.veF.field_type == 8 || this.veF.field_type == 6)) {
                    this.retCode = -10000 - g.getLine();
                    return -1;
                }
            }
            if (this.veF.field_type == 8 || this.veF.field_type == 9) {
                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[]{Long.valueOf(this.veF.field_type)});
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.MJ();
                if (com.tencent.mm.modelcdntran.c.hu(4) || this.veF.field_isUseCdn == 1) {
                    ar.Hg();
                    cf dH = com.tencent.mm.z.c.Fa().dH(this.veF.field_msgInfoId);
                    if (dH.field_msgId != this.veF.field_msgInfoId) {
                        x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[]{Long.valueOf(this.veF.field_msgInfoId), Long.valueOf(this.veF.xjy), Long.valueOf(this.veF.field_createTime), Long.valueOf(this.veF.field_totalLen), Long.valueOf(this.veF.field_status), Boolean.valueOf(this.veF.field_isUpload), Integer.valueOf(this.veF.field_isUseCdn), this.veF.field_mediaId});
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = dH.field_talker;
                        String str = "";
                        if (!bh.ov(dH.field_imgPath)) {
                            str = o.Pw().lm(dH.field_imgPath);
                        }
                        int bN = com.tencent.mm.a.e.bN(str);
                        int bN2 = com.tencent.mm.a.e.bN(this.veF.field_fileFullPath);
                        if (bN >= com.tencent.mm.modelcdntran.b.hsf) {
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(bN)});
                            obj = null;
                        } else {
                            this.hBn = d.a("upattach", this.veF.field_createTime, dH.field_talker, this.veI);
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[]{Long.valueOf(this.veF.field_createTime), this.hBn});
                            if (bh.ov(this.hBn)) {
                                x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[]{Long.valueOf(this.veI)});
                                obj = null;
                            } else {
                                Object obj2;
                                i iVar = new i();
                                String str2 = dH.field_content;
                                if (s.eV(dH.field_talker)) {
                                    int hO = ba.hO(dH.field_content);
                                    if (hO != -1) {
                                        str2 = (dH.field_content + " ").substring(hO + 2).trim();
                                    }
                                }
                                this.fnC = a.fT(bh.VH(str2));
                                if (this.fnC != null) {
                                    x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[]{this.fnC.hbi, bh.VT(this.fnC.hbp), this.fnC.filemd5, Integer.valueOf(this.fnC.type)});
                                    iVar.field_fileId = this.fnC.hbi;
                                    iVar.field_aesKey = this.fnC.hbp;
                                    iVar.field_filemd5 = this.fnC.filemd5;
                                    obj2 = (this.fnC.hbf != 0 || this.fnC.hbb > 26214400) ? 1 : null;
                                } else {
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                iVar.htt = this.hBx;
                                iVar.field_mediaId = this.hBn;
                                iVar.field_fullpath = this.veF.field_fileFullPath;
                                iVar.field_thumbpath = str;
                                iVar.field_fileType = obj2 != null ? com.tencent.mm.modelcdntran.b.hrM : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                                iVar.field_svr_signature = obj2 != null ? bh.ou(this.veF.field_signature) : "";
                                iVar.field_onlycheckexist = obj2 != null ? bh.ov(this.veF.field_signature) : false;
                                iVar.field_fake_bigfile_signature_aeskey = this.veF.field_fakeAeskey;
                                iVar.field_fake_bigfile_signature = this.veF.field_fakeSignature;
                                iVar.field_talker = dH.field_talker;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                                iVar.field_totalLen = bN2;
                                iVar.field_needStorage = false;
                                iVar.field_isStreamMedia = false;
                                iVar.field_enable_hitcheck = this.hBF;
                                iVar.field_chattype = s.eV(dH.field_talker) ? 1 : 0;
                                iVar.field_force_aeskeycdn = false;
                                iVar.field_trysafecdn = true;
                                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[]{Long.valueOf(this.veF.field_msgInfoId), iVar.field_fullpath, Integer.valueOf(bN2), str, Integer.valueOf(bN), this.hBn, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), bh.VT(iVar.field_aesKey), iVar.field_filemd5, bh.VT(iVar.field_svr_signature), bh.VT(iVar.field_fake_bigfile_signature_aeskey), bh.VT(iVar.field_fake_bigfile_signature)});
                                if (com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
                                    if (this.veF.field_isUseCdn != 1) {
                                        this.veF.field_isUseCdn = 1;
                                        boolean c = an.aqd().c(this.veF, new String[0]);
                                        if (!c) {
                                            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                            this.retCode = -10000 - g.getLine();
                                            this.gJT.a(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[]{this.hBn});
                                    obj = 1;
                                } else {
                                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.hBn = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.modelcdntran.g.MJ();
                    r2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(4));
                    r2[1] = Integer.valueOf(this.veF.field_isUseCdn);
                    x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[]{Long.valueOf(this.veI)});
                return 0;
            } else if (this.veF.field_netTimes > 3200) {
                l.fr(this.veF.xjy);
                x.e("MicroMsg.NetSceneUploadAppAttach", g.zh() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.veI);
                return -1;
            } else {
                b bVar = this.veF;
                bVar.field_netTimes++;
                if (bh.ov(this.veF.field_clientAppDataId)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - g.getLine();
                    return -1;
                } else if (this.veF.field_totalLen <= 0 || this.veF.field_totalLen > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.veF.field_totalLen);
                    this.retCode = -10000 - g.getLine();
                    if (this.veF.field_totalLen > 26214400) {
                        l.fr(this.veF.xjy);
                    }
                    return -1;
                } else if (bh.ov(this.veF.field_fileFullPath)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - g.getLine();
                    return -1;
                } else if (com.tencent.mm.a.e.bN(this.veF.field_fileFullPath) > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    l.fr(this.veF.xjy);
                    return -1;
                } else {
                    byte[] e;
                    if (bh.ov(this.hbd)) {
                        e = com.tencent.mm.a.e.e(this.veF.field_fileFullPath, (int) this.veF.field_offset, 8192);
                    } else {
                        e = com.tencent.mm.a.e.e(this.veF.field_fileFullPath, (int) this.veF.field_offset, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (bh.bw(e)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - g.getLine();
                        return -1;
                    }
                    bpx com_tencent_mm_protocal_c_bpx = (bpx) this.gJQ.hmg.hmo;
                    com_tencent_mm_protocal_c_bpx.ngo = this.veF.field_appId;
                    com_tencent_mm_protocal_c_bpx.vHT = (int) this.veF.field_sdkVer;
                    com_tencent_mm_protocal_c_bpx.wRD = this.veF.field_clientAppDataId;
                    com_tencent_mm_protocal_c_bpx.ktN = (int) this.veF.field_type;
                    com_tencent_mm_protocal_c_bpx.ksU = q.FS();
                    com_tencent_mm_protocal_c_bpx.vIB = (int) this.veF.field_totalLen;
                    com_tencent_mm_protocal_c_bpx.vIC = (int) this.veF.field_offset;
                    if (this.hbd == null || !this.vfc) {
                        com_tencent_mm_protocal_c_bpx.vID = e.length;
                        com_tencent_mm_protocal_c_bpx.vXz = new bdn().bj(e);
                        if (this.hbd != null) {
                            com_tencent_mm_protocal_c_bpx.vZU = this.hbd;
                        }
                        return a(eVar, this.gJQ, this);
                    }
                    com_tencent_mm_protocal_c_bpx.vZU = this.hbd;
                    com_tencent_mm_protocal_c_bpx.vIB = (int) this.veF.field_totalLen;
                    com_tencent_mm_protocal_c_bpx.vID = 0;
                    com_tencent_mm_protocal_c_bpx.vXz = new bdn().bj(new byte[0]);
                    this.vfc = false;
                    return a(eVar, this.gJQ, this);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.hBn});
        } else if (i2 == 0 && i3 == 0) {
            bpy com_tencent_mm_protocal_c_bpy = (bpy) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bpy.ngo != null && this.hbd == null && (!com_tencent_mm_protocal_c_bpy.ngo.equals(this.veF.field_appId) || !com_tencent_mm_protocal_c_bpy.wRD.equals(this.veF.field_clientAppDataId))) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            } else if (com_tencent_mm_protocal_c_bpy.vIB < 0 || ((long) com_tencent_mm_protocal_c_bpy.vIB) != this.veF.field_totalLen || com_tencent_mm_protocal_c_bpy.vIC < 0 || ((long) com_tencent_mm_protocal_c_bpy.vIC) > this.veF.field_totalLen) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            } else {
                this.veF.field_offset = (long) com_tencent_mm_protocal_c_bpy.vIC;
                this.veF.field_mediaSvrId = l.RG(com_tencent_mm_protocal_c_bpy.vZq) ? com_tencent_mm_protocal_c_bpy.vZq : "";
                if (this.veF.field_status == 105) {
                    x.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.veF.field_mediaSvrId + "," + this.veF.field_offset + "] ");
                    this.gJT.a(i2, -1, "", this);
                    return;
                }
                if (this.veF.field_offset == this.veF.field_totalLen) {
                    if (bh.ov(this.veF.field_mediaSvrId)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - g.getLine();
                        this.gJT.a(3, -1, "", this);
                        l.fr(this.veF.xjy);
                        return;
                    }
                    this.veF.field_status = 199;
                    com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.veF.field_totalLen - this.vfd)});
                }
                boolean c = an.aqd().c(this.veF, new String[0]);
                if (!c) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + c);
                    this.retCode = -10000 - g.getLine();
                    d(null);
                    this.gJT.a(3, -1, "", this);
                } else if (this.veF.field_status == 199) {
                    this.gJT.a(0, 0, "", this);
                } else if (a(this.hmA, this.gJT) < 0) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                    this.gJT.a(3, -1, "", this);
                }
            }
        } else {
            x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - g.getLine();
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.veF.field_totalLen - this.vfd)});
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int Bh() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    final void d(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.veF.field_type == 2) {
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100131");
            if (fn.isValid()) {
                this.gLV = t.getInt((String) fn.chI().get("needUploadData"), 1);
            }
            if (!this.gLT && this.gLV != 0) {
                this.gLW = com_tencent_mm_modelcdntran_keep_SceneResult;
                this.gLT = true;
                com.tencent.mm.sdk.b.b mpVar = new mp();
                com.tencent.mm.sdk.b.a.xef.b(this.gLY);
                mpVar.fEA.filePath = this.veF.field_fileFullPath;
                com.tencent.mm.sdk.b.a.xef.m(mpVar);
            }
        }
    }
}
