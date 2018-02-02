package com.tencent.mm.modelvoice;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.q;
import junit.framework.Assert;

public final class f extends k implements com.tencent.mm.network.k {
    private int endFlag;
    public String fileName;
    private b gJQ;
    e gJT;
    private int hWC;
    long hWD;
    private int hWh;
    private boolean hWy;
    ak hkO;
    public int retCode;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        boolean z = true;
        this.retCode = 0;
        this.hWh = 0;
        this.hWy = false;
        this.endFlag = 0;
        this.hkO = new ak(new 1(this), true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + str);
        this.fileName = str;
        this.hWC = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        this.hWy = false;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        p oc = q.oc(this.fileName);
        if (oc == null || !oc.UH()) {
            x.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        x.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fileName + " netTimes:" + oc.hVJ);
        if (q.nS(this.fileName)) {
            g gVar;
            int i;
            int i2;
            g gVar2 = new g();
            if (oc.status == 8) {
                x.v("MicroMsg.NetSceneUploadVoice", this.fileName + " cancelFlag = 1");
                this.endFlag = 0;
                q.nY(oc.fileName);
                gVar = gVar2;
                i = 1;
                i2 = 0;
            } else {
                if (oc.status == 3) {
                    this.hWy = true;
                }
                b nT = q.nT(this.fileName);
                if (nT == null) {
                    this.retCode = g.getLine() + 10000;
                    x.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", new Object[]{this.fileName});
                    return -1;
                }
                int format = nT.getFormat();
                x.d("MicroMsg.NetSceneUploadVoice", "format " + format);
                g bp = nT.bp(oc.hUp, 6000);
                x.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fileName + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + oc.hUp + " line:" + g.getLine());
                if (bp.ret < 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 241, 1, false);
                    x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read ret:" + bp.ret + " readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + oc.hUp);
                    q.ny(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.hWh = bp.hWh;
                if (this.hWh < oc.hUp || this.hWh >= 469000) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 240, 1, false);
                    x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] newOff:" + this.hWh + " OldtOff:" + oc.hUp);
                    q.ny(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (bp.flp != 0 || this.hWy) {
                    if (this.hWy) {
                        if (oc.hlp <= 0) {
                            x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] read totalLen:" + oc.hlp);
                            q.ny(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (oc.hlp > this.hWh && bp.flp < 6000) {
                            x.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fileName + "] readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + oc.hUp + " totalLen:" + oc.hlp);
                            q.ny(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (oc.hlp <= this.hWh) {
                            Integer num = (Integer) q.hXG.get(q.getFullPath(this.fileName));
                            if (!(num == null || num.intValue() == 0)) {
                                g bp2 = nT.bp(0, ((Integer) q.hXH.get(q.getFullPath(this.fileName))).intValue());
                                int b = q.b(num.intValue() & 255, bp2.buf, 0, bp2.flp);
                                if (num.intValue() != b) {
                                    x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. realChecksum:%d, tempChecksum:%d, total:%d, rr.length:%d", new Object[]{Integer.valueOf(b), num, Integer.valueOf(i2), Integer.valueOf(bp2.flp)});
                                    x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file[" + this.fileName + "] readlen:" + bp.flp + " newOff:" + bp.hWh + " netOff:" + oc.hUp + " totalLen:" + oc.hlp);
                                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 173, 1, false);
                                    q.hXG.put(q.getFullPath(this.fileName), Integer.valueOf(b));
                                    num = (Integer) q.hXI.get(q.getFullPath(this.fileName));
                                    if (!(num == null || num.intValue() == 0 || num.intValue() == q.a(0, bp2.buf, 0, bp2.flp))) {
                                        x.e("MicroMsg.NetSceneUploadVoice", "Checksum error file. cacheSimpleChecksum:%d, realSimpleChecksum:%d", new Object[]{num, Integer.valueOf(q.a(0, bp2.buf, 0, bp2.flp))});
                                        q.ny(this.fileName);
                                        this.retCode = g.getLine() + 10000;
                                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 174, 1, false);
                                        return -1;
                                    }
                                }
                            }
                            this.endFlag = 1;
                        }
                    }
                    i2 = format;
                    i = 0;
                    gVar = bp;
                } else {
                    x.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
            }
            int i3 = oc.hXC;
            x.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                i3 = q.od(this.fileName);
                x.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", new Object[]{Integer.valueOf(i3)});
                if (i3 < 0) {
                    i3 = q.iK(this.hWh);
                    x.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", new Object[]{Integer.valueOf(i3)});
                }
            }
            int i4 = i3;
            a aVar = new a();
            aVar.hmj = new brg();
            aVar.hmk = new brh();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            aVar.hmi = 127;
            aVar.hml = 19;
            aVar.hmm = 1000000019;
            this.gJQ = aVar.JZ();
            brg com_tencent_mm_protocal_c_brg = (brg) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_brg.nkp = q.FS();
            com_tencent_mm_protocal_c_brg.nko = oc.fDC;
            com_tencent_mm_protocal_c_brg.vNW = oc.hUp;
            com_tencent_mm_protocal_c_brg.vHU = oc.clientId;
            com_tencent_mm_protocal_c_brg.vZy = i4;
            com_tencent_mm_protocal_c_brg.vLj = this.endFlag;
            com_tencent_mm_protocal_c_brg.vHe = oc.fFo;
            com_tencent_mm_protocal_c_brg.vZz = i;
            com_tencent_mm_protocal_c_brg.wSM = this.hWC;
            com_tencent_mm_protocal_c_brg.vHc = bc.HE();
            com_tencent_mm_protocal_c_brg.vHc = com.tencent.mm.j.a.a.xD().z(oc.fDC, oc.hVI);
            com_tencent_mm_protocal_c_brg.wxw = i2;
            if (i != 1) {
                com_tencent_mm_protocal_c_brg.vXz = new bdn().N(gVar.buf, gVar.flp);
                com_tencent_mm_protocal_c_brg.vZw = gVar.flp;
            } else {
                com_tencent_mm_protocal_c_brg.vXz = new bdn().b(com.tencent.mm.bq.b.bc(new byte[1]));
                com_tencent_mm_protocal_c_brg.vZw = 1;
            }
            x.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + oc.fFo);
            x.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + com_tencent_mm_protocal_c_brg.vHe + " user:" + com_tencent_mm_protocal_c_brg.nko + " offset:" + com_tencent_mm_protocal_c_brg.vNW + " dataLen:" + com_tencent_mm_protocal_c_brg.vXz.wJB + " endFlag:" + com_tencent_mm_protocal_c_brg.vLj);
            x.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + oc.fFo + " voiceFormat:" + i2 + " file:" + this.fileName + " readBytes:" + gVar.flp + " neTTTOff:" + oc.hUp + " neWWWOff:" + this.hWh + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + oc.status + " voiceLen:" + i4);
            this.hWD = System.currentTimeMillis();
            return a(eVar, this.gJQ, this);
        }
        x.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.ny(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        brg com_tencent_mm_protocal_c_brg = (brg) ((b) qVar).hmg.hmo;
        x.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + com_tencent_mm_protocal_c_brg.vHe + " offset:" + com_tencent_mm_protocal_c_brg.vNW + " dataLen:" + com_tencent_mm_protocal_c_brg.vXz.wJB + " endFlag:" + com_tencent_mm_protocal_c_brg.vLj);
        if ((com_tencent_mm_protocal_c_brg.vHe != 0 || com_tencent_mm_protocal_c_brg.vNW == 0) && ((com_tencent_mm_protocal_c_brg.vXz != null && com_tencent_mm_protocal_c_brg.vXz.wJB != 0) || com_tencent_mm_protocal_c_brg.vLj == 1 || com_tencent_mm_protocal_c_brg.vZz == 1)) {
            return k.b.hmP;
        }
        return k.b.hmQ;
    }

    protected final int Bh() {
        return 60;
    }

    public final boolean Ke() {
        boolean Ke = super.Ke();
        if (Ke) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 239, 1, false);
        }
        return Ke;
    }

    protected final void a(k.a aVar) {
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 238, 1, false);
        q.ny(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        brg com_tencent_mm_protocal_c_brg = (brg) ((b) qVar).hmg.hmo;
        brh com_tencent_mm_protocal_c_brh = (brh) ((b) qVar).hmh.hmo;
        if (i2 == 4 && i3 == -22) {
            q.nz(this.fileName);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            q.ny(this.fileName);
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 237, 1, false);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_brh.vHe + " toUser:" + com_tencent_mm_protocal_c_brg.nko);
            if (com_tencent_mm_protocal_c_brh.vHe > 0 || com.tencent.mm.storage.x.gy(com_tencent_mm_protocal_c_brg.nko)) {
                x.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_brh.vHe), Integer.valueOf(r.idu)});
                if (CdnLogic.kMediaTypeFavoriteBigFile == r.idt && r.idu != 0) {
                    com_tencent_mm_protocal_c_brh.vHe = (long) r.idu;
                    r.idu = 0;
                }
                int a = q.a(this.fileName, this.hWh, com_tencent_mm_protocal_c_brh.vHe, com_tencent_mm_protocal_c_brh.vHU, this.endFlag, this.hWC);
                x.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a + " file:" + this.fileName + " MsgSvrId:" + com_tencent_mm_protocal_c_brh.vHe + " clientId:" + com_tencent_mm_protocal_c_brh.vHU + " neWWOff:" + this.hWh + " neTTTT:" + com_tencent_mm_protocal_c_brh.vZw + " forwardflag:" + this.hWC);
                if (a < 0) {
                    q.ny(this.fileName);
                    x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + a);
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else if (a == 1) {
                    x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fileName);
                    com.tencent.mm.modelstat.b.hPA.f(((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) q.oc(this.fileName).hVI));
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else {
                    long j = this.hWy ? 0 : 500;
                    x.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " delay:" + j);
                    this.hkO.J(j, j);
                    return;
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 235, 1, false);
            x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " getMsgId:" + com_tencent_mm_protocal_c_brh.vHe + " netoff:" + com_tencent_mm_protocal_c_brh.vNW);
            q.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 236, 1, false);
            x.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 127;
    }
}
