package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public final class ab extends k implements com.tencent.mm.network.k {
    au fEJ;
    public long fqm;
    private b gJQ;
    e gJT;
    f hBj;
    public String hBn;
    private com.tencent.mm.modelcdntran.i.a hBx;
    private long knc;
    public String mediaId;
    int retCode;
    long startTime;
    private int type;
    public b veF;
    long veI;
    private int veJ;
    String veK;
    public boolean veL;
    private boolean veM;
    private boolean veN;

    public interface a {
        void bYO();
    }

    public ab(String str) {
        this(str, null, 0);
    }

    public ab(long j, String str, f fVar) {
        this(str, fVar, 0);
        this.fqm = j;
    }

    public ab(long j, long j2, f fVar) {
        this.veF = null;
        this.veI = -1;
        this.mediaId = "";
        this.fqm = 0;
        this.fEJ = null;
        this.hBn = "";
        this.startTime = 0;
        this.veJ = -1;
        this.veK = "";
        this.type = 0;
        this.retCode = 0;
        this.veL = false;
        this.veM = false;
        this.knc = 0;
        this.veN = false;
        this.hBx = new 1(this);
        this.knc = j2;
        this.fqm = j;
        this.veF = an.aqd().fo(j);
        this.hBj = fVar;
        this.veM = true;
        if (this.veF == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + j, Long.valueOf(j2));
            return;
        }
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ri();
        aVar.hmk = new rj();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hmi = 221;
        aVar.hml = 106;
        aVar.hmm = 1000000106;
        this.gJQ = aVar.JZ();
    }

    public ab(b bVar) {
        this.veF = null;
        this.veI = -1;
        this.mediaId = "";
        this.fqm = 0;
        this.fEJ = null;
        this.hBn = "";
        this.startTime = 0;
        this.veJ = -1;
        this.veK = "";
        this.type = 0;
        this.retCode = 0;
        this.veL = false;
        this.veM = false;
        this.knc = 0;
        this.veN = false;
        this.hBx = new 1(this);
        this.veF = bVar;
        this.veL = true;
        this.mediaId = this.veF.field_mediaId;
        this.hBj = null;
        this.type = 0;
        if (bVar == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            return;
        }
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ri();
        aVar.hmk = new rj();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hmi = 221;
        aVar.hml = 106;
        aVar.hmm = 1000000106;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", bVar.field_fileFullPath, Boolean.valueOf(true), bh.cgy());
    }

    public ab(String str, f fVar, int i) {
        this.veF = null;
        this.veI = -1;
        this.mediaId = "";
        this.fqm = 0;
        this.fEJ = null;
        this.hBn = "";
        this.startTime = 0;
        this.veJ = -1;
        this.veK = "";
        this.type = 0;
        this.retCode = 0;
        this.veL = false;
        this.veM = false;
        this.knc = 0;
        this.veN = false;
        this.hBx = new 1(this);
        this.mediaId = str;
        this.hBj = fVar;
        this.type = i;
        this.veF = an.aqd().Rz(str);
        if (this.veF == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + str);
            return;
        }
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ri();
        aVar.hmk = new rj();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hmi = 221;
        aVar.hml = 106;
        aVar.hmm = 1000000106;
        this.gJQ = aVar.JZ();
        x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(i), this.veF.field_fileFullPath, Long.valueOf(this.veF.field_type), this.veF.field_signature, bh.cgy());
    }

    public final void bYN() {
        this.veN = true;
        if (this.veN) {
            com.tencent.mm.a.e.d(this.veF.field_fileFullPath, "#!AMR\n".getBytes());
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.veF == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", g.zh() + " get info failed mediaId:" + this.mediaId);
            this.retCode = -10000 - g.getLine();
            return -1;
        }
        ar.Hg();
        this.fEJ = c.Fa().dH(this.fqm);
        if (this.fEJ == null || this.fEJ.field_msgId != this.fqm) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", g.zh() + " get msginfo failed mediaId:%s  msgId:%d", this.mediaId, Long.valueOf(this.fqm));
            this.retCode = -10000 - g.getLine();
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = bh.Wp();
            this.veJ = (int) this.veF.field_offset;
        }
        if (this.knc != 0) {
            ri riVar = (ri) this.gJQ.hmg.hmo;
            riVar.ksU = q.FS();
            riVar.vIB = (int) this.veF.field_totalLen;
            riVar.vIC = (int) this.veF.field_offset;
            riVar.vID = 0;
            riVar.ktN = 40;
            riVar.vHe = this.knc;
            return a(eVar, this.gJQ, this);
        }
        Object obj;
        String str = this.fEJ.field_content;
        if (s.eV(this.fEJ.field_talker)) {
            int hO = ba.hO(this.fEJ.field_content);
            if (hO != -1) {
                str = (this.fEJ.field_content + " ").substring(hO + 2).trim();
            }
        }
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(str));
        if (fT == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.mediaId);
            obj = null;
        } else {
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.fqm), Long.valueOf(this.veF.field_totalLen), this.veF.field_fileFullPath, fT.hbi, bh.VT(fT.hbp));
            if (bh.ov(fT.hbi) || bh.ov(fT.hbp)) {
                x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.fqm), fT.hbi, bh.VT(fT.hbp));
                obj = null;
            } else {
                this.hBn = d.a("downattach", this.veF.field_createTime, this.fEJ.field_talker, this.veI);
                if (bh.ov(this.hBn)) {
                    x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.veI));
                    obj = null;
                } else {
                    com.tencent.mm.a.e.bU(this.veF.field_fileFullPath);
                    this.veK = this.veF.field_fileFullPath + "_tmp";
                    i iVar = new i();
                    iVar.field_mediaId = this.hBn;
                    iVar.field_fullpath = this.veK;
                    int i = (fT.hbf != 0 || fT.hbb > 26214400) ? com.tencent.mm.modelcdntran.b.hrM : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                    iVar.field_fileType = i;
                    iVar.field_totalLen = (int) this.veF.field_totalLen;
                    iVar.field_aesKey = fT.hbp;
                    iVar.field_fileId = fT.hbi;
                    iVar.field_svr_signature = this.veF.field_signature;
                    iVar.field_fake_bigfile_signature_aeskey = this.veF.field_fakeAeskey;
                    iVar.field_fake_bigfile_signature = this.veF.field_fakeSignature;
                    iVar.field_onlycheckexist = false;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                    iVar.htt = this.hBx;
                    iVar.field_chattype = s.eV(this.fEJ.field_talker) ? 1 : 0;
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(iVar.field_fileType), iVar.field_fullpath, bh.VT(iVar.field_aesKey), bh.VT(iVar.field_svr_signature), bh.VT(iVar.field_fake_bigfile_signature_aeskey), bh.VT(iVar.field_fake_bigfile_signature), Boolean.valueOf(iVar.field_onlycheckexist));
                    if (com.tencent.mm.modelcdntran.g.MJ().b(iVar, -1)) {
                        if (this.veF.field_isUseCdn != 1) {
                            this.veF.field_isUseCdn = 1;
                            boolean c = an.aqd().c(this.veF, new String[0]);
                            if (!c) {
                                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                this.retCode = -10000 - g.getLine();
                                this.gJT.a(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.hBn = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.mediaId);
            return 0;
        }
        if (this.veF.field_status == 102) {
            this.veF.field_status = 101;
            if (!this.veL) {
                an.aqd().c(this.veF, new String[0]);
            }
        }
        this.veI = this.veF.xjy;
        if (bh.ov(this.veF.field_mediaSvrId) && this.knc == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - g.getLine();
            return -1;
        } else if (this.veF.field_totalLen <= 0 || this.veF.field_totalLen > 26214400) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.veF.field_totalLen);
            this.retCode = -10000 - g.getLine();
            return -1;
        } else if (bh.ov(this.veF.field_fileFullPath) && this.knc == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - g.getLine();
            return -1;
        } else {
            i = com.tencent.mm.a.e.bN(this.veF.field_fileFullPath);
            if (this.veN) {
                i -= 6;
                if (i <= 0) {
                    i = 0;
                }
            }
            if (((long) i) != this.veF.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.veF.field_offset);
                this.retCode = -10000 - g.getLine();
                return -1;
            }
            x.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.veF.field_appId, this.veF.field_mediaSvrId, Long.valueOf(this.veF.field_sdkVer));
            riVar = (ri) this.gJQ.hmg.hmo;
            riVar.ngo = this.veF.field_appId;
            riVar.vZq = this.veF.field_mediaSvrId;
            riVar.vHT = (int) this.veF.field_sdkVer;
            riVar.ksU = q.FS();
            riVar.vIB = (int) this.veF.field_totalLen;
            riVar.vIC = (int) this.veF.field_offset;
            riVar.vID = 0;
            if (this.knc != 0) {
                riVar.vHe = this.knc;
            }
            if (this.type != 0) {
                riVar.ktN = this.type;
            } else {
                riVar.ktN = (int) this.veF.field_type;
            }
            return a(eVar, this.gJQ, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hBn);
        } else if (i2 == 0 && i3 == 0) {
            rj rjVar = (rj) ((b) qVar).hmh.hmo;
            this.veF.field_totalLen = (long) rjVar.vIB;
            if (rjVar.vZq != null && !rjVar.vZq.equals(this.veF.field_mediaSvrId)) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            } else if (((long) rjVar.vIC) != this.veF.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + rjVar.vIC);
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            } else if (((long) rjVar.vID) + this.veF.field_offset > this.veF.field_totalLen) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + rjVar.vID + " off:" + this.veF.field_offset + " total?:" + this.veF.field_totalLen);
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            } else {
                byte[] a = n.a(rjVar.vXz);
                if (a == null || a.length == 0 || a.length != rjVar.vID) {
                    x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - g.getLine();
                    this.gJT.a(3, -1, "", this);
                    return;
                }
                String str2 = new String(a);
                x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.veM));
                if (this.veF.field_offset < this.veF.field_totalLen && this.veM) {
                    ar.Hg();
                    au dH = c.Fa().dH(this.veF.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!dH.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(dH.field_content).append(str2);
                            this.veF.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.veF.field_offset + ((long) a.length) == this.veF.field_totalLen) {
                            if (s.eV(dH.field_talker)) {
                                String[] split = dH.field_content.split("\n", 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split[1]).append(str2).append("</msg>");
                                this.veF.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.veF.field_fullXml).append("</msg>");
                                this.veF.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!s.eV(dH.field_talker)) {
                        this.veF.field_fullXml = str2;
                    } else if (!bh.ov(dH.field_content)) {
                        String str4 = dH.field_content.split("\n", 2)[0];
                        this.veF.field_fullXml = new StringBuffer().append(str4).append("\n").toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.veF.field_fullXml).append(str2);
                        this.veF.field_fullXml = stringBuffer.toString();
                    }
                    dH.setContent(this.veF.field_fullXml);
                    ar.Hg();
                    c.Fa().a(this.veF.field_msgInfoId, dH);
                    x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                }
                int d = com.tencent.mm.a.e.d(this.veF.field_fileFullPath, a);
                if (bh.ov(this.veF.field_fileFullPath) || d == 0) {
                    b bVar = this.veF;
                    bVar.field_offset += (long) a.length;
                    if (this.veF.field_offset == this.veF.field_totalLen) {
                        this.veF.field_status = 199;
                    }
                    if (this.hBj != null) {
                        ag.y(new 2(this));
                    }
                    if (!(this.veL ? true : an.aqd().c(this.veF, new String[0]))) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + d);
                        this.retCode = -10000 - g.getLine();
                        this.gJT.a(3, -1, "", this);
                        return;
                    } else if (this.veF.field_status == 199) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.veF.field_totalLen - ((long) this.veJ)));
                        ar.Hg();
                        au dH2 = c.Fa().dH(this.veF.field_msgInfoId);
                        ar.Hg();
                        c.Fa().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(dH2.field_talker, "update", dH2));
                        this.gJT.a(0, 0, "", this);
                        return;
                    } else if (this.veF.field_status == 102) {
                        this.gJT.a(3, -1, "", this);
                        this.retCode = -20102;
                        return;
                    } else if (a(this.hmA, this.gJT) < 0) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                        this.gJT.a(3, -1, "", this);
                        return;
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + d);
                this.retCode = -10000 - g.getLine();
                this.gJT.a(3, -1, "", this);
            }
        } else {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - g.getLine();
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0));
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 221;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 400;
    }

    public final String getMediaId() {
        if (this.veF == null) {
            return "";
        }
        return this.veF.field_mediaSvrId;
    }
}
