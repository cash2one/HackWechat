package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.subapp.c.c.a;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.brg;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import junit.framework.Assert;

public final class b extends k implements com.tencent.mm.network.k {
    private int endFlag = 0;
    String fileName;
    private com.tencent.mm.ae.b gJQ;
    e gJT;
    long hWD;
    private int hWh = 0;
    private boolean hWy = false;
    ak hkO = new ak(new 1(this), true);
    int retCode = 0;

    public b(String str) {
        boolean z = true;
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + str);
        this.fileName = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        this.hWy = false;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        g Mk = h.Mk(this.fileName);
        if (Mk == null || !Mk.UH()) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        boolean z;
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + Mk.field_nettimes);
        String str = this.fileName;
        if (str == null) {
            z = false;
        } else {
            g Mk2 = h.Mk(str);
            if (Mk2 == null) {
                z = false;
            } else if (Mk2.field_nettimes >= 80) {
                z = false;
            } else {
                Mk2.field_nettimes++;
                Mk2.fDt = 16384;
                z = h.a(Mk2);
            }
        }
        if (z) {
            a aVar;
            int i;
            int i2;
            a aVar2 = new a();
            if (Mk.field_status == 8) {
                x.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
                this.endFlag = 1;
                h.nY(Mk.field_filename);
                aVar = aVar2;
                i = 1;
            } else {
                if (Mk.field_status == 3) {
                    this.hWy = true;
                }
                c Ml = h.Ml(this.fileName);
                if (Ml == null) {
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                aVar2 = Ml.yf(Mk.field_offset);
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + aVar2.ret + " readlen:" + aVar2.flp + " newOff:" + aVar2.hWh + " netOff:" + Mk.field_offset + " line:" + g.getLine());
                if (aVar2.ret < 0) {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + aVar2.ret + " readlen:" + aVar2.flp + " newOff:" + aVar2.hWh + " netOff:" + Mk.field_offset);
                    h.ny(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.hWh = aVar2.hWh;
                if (this.hWh < Mk.field_offset || this.hWh >= 469000) {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.hWh + " OldtOff:" + Mk.field_offset);
                    h.ny(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (aVar2.flp != 0 || this.hWy) {
                    if (this.hWy) {
                        if (Mk.field_totallen <= 0) {
                            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + Mk.field_totallen);
                            h.ny(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (Mk.field_totallen > this.hWh && aVar2.flp < 6000) {
                            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + aVar2.flp + " newOff:" + aVar2.hWh + " netOff:" + Mk.field_offset + " totalLen:" + Mk.field_totallen);
                            h.ny(this.fileName);
                            this.retCode = g.getLine() + 10000;
                            return -1;
                        } else if (Mk.field_totallen <= this.hWh) {
                            this.endFlag = 1;
                        }
                    }
                    aVar = aVar2;
                    i = 0;
                } else {
                    x.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
                    h.ny(this.fileName);
                    this.retCode = g.getLine() + 10000;
                    return -1;
                }
            }
            int i3 = Mk.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.hWh - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + Mk.field_msgid);
            com.tencent.mm.ae.b.a aVar3 = new com.tencent.mm.ae.b.a();
            aVar3.hmj = new brg();
            aVar3.hmk = new brh();
            aVar3.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            aVar3.hmi = 329;
            aVar3.hml = 157;
            aVar3.hmm = 1000000157;
            this.gJQ = aVar3.JZ();
            brg com_tencent_mm_protocal_c_brg = (brg) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_brg.nkp = q.FS();
            com_tencent_mm_protocal_c_brg.nko = Mk.field_user;
            com_tencent_mm_protocal_c_brg.vNW = Mk.field_offset;
            com_tencent_mm_protocal_c_brg.vHU = Mk.field_clientid;
            com_tencent_mm_protocal_c_brg.vZy = i2;
            com_tencent_mm_protocal_c_brg.vLj = this.endFlag;
            com_tencent_mm_protocal_c_brg.vHe = Mk.field_msgid;
            com_tencent_mm_protocal_c_brg.vZz = i;
            com_tencent_mm_protocal_c_brg.wSL = (int) (Mk.field_createtime / 1000);
            com_tencent_mm_protocal_c_brg.wxw = 1;
            if (i != 1) {
                com_tencent_mm_protocal_c_brg.vXz = new bdn().N(aVar.buf, aVar.flp);
                com_tencent_mm_protocal_c_brg.vZw = aVar.flp;
            } else {
                com_tencent_mm_protocal_c_brg.vXz = new bdn().b(com.tencent.mm.bq.b.bc(new byte[1]));
                com_tencent_mm_protocal_c_brg.vZw = 1;
            }
            x.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + Mk.field_msgid);
            x.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + com_tencent_mm_protocal_c_brg.vHe + " user:" + com_tencent_mm_protocal_c_brg.nko + " offset:" + com_tencent_mm_protocal_c_brg.vNW + " dataLen:" + com_tencent_mm_protocal_c_brg.vXz.wJB + " endFlag:" + com_tencent_mm_protocal_c_brg.vLj);
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + Mk.field_msgid + " file:" + this.fileName + " readBytes:" + aVar.flp + " neTTTOff:" + Mk.field_offset + " neWWWOff:" + this.hWh + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + Mk.field_status);
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + com_tencent_mm_protocal_c_brg.toString());
            this.hWD = System.currentTimeMillis();
            return a(eVar, this.gJQ, this);
        }
        x.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
        h.ny(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        brg com_tencent_mm_protocal_c_brg = (brg) ((com.tencent.mm.ae.b) qVar).hmg.hmo;
        x.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + com_tencent_mm_protocal_c_brg.vNW + " dataLen:" + com_tencent_mm_protocal_c_brg.vXz.wJB + " endFlag:" + com_tencent_mm_protocal_c_brg.vLj);
        return com.tencent.mm.ae.k.b.hmP;
    }

    protected final int Bh() {
        return 240;
    }

    protected final void a(k.a aVar) {
        h.ny(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + i2 + " errCode:" + i3);
        brg com_tencent_mm_protocal_c_brg = (brg) ((com.tencent.mm.ae.b) qVar).hmg.hmo;
        brh com_tencent_mm_protocal_c_brh = (brh) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        x.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + com_tencent_mm_protocal_c_brh.toString());
        if (i2 == 4 && i3 == -22) {
            g Mk = h.Mk(this.fileName);
            if (Mk != null) {
                if (Mk.field_status == 3) {
                    ar.Hg();
                    au dH = c.Fa().dH((long) Mk.field_msglocalid);
                    dH.setContent(f.b(Mk.field_human, (long) Mk.field_voicelenght, false));
                    dH.eQ(2);
                    ar.Hg();
                    c.Fa().a((long) Mk.field_msglocalid, dH);
                }
                Mk.field_status = 97;
                Mk.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Mk.fDt = 320;
                h.a(Mk);
            }
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            h.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_brh.vHe + " toUser:" + com_tencent_mm_protocal_c_brg.nko);
            String str2 = this.fileName;
            int i5 = this.hWh;
            long j = com_tencent_mm_protocal_c_brh.vHe;
            String str3 = com_tencent_mm_protocal_c_brh.vHU;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                x.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                g Mk2 = h.Mk(str2);
                if (Mk2 == null) {
                    i4 = -1;
                } else {
                    Mk2.field_offset = i5;
                    Mk2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Mk2.fDt = 264;
                    if (bh.ov(Mk2.field_clientid) && str3 != null) {
                        Mk2.field_clientid = str3;
                        Mk2.fDt |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                    }
                    if (Mk2.field_msgid == 0 && j != 0) {
                        Mk2.field_msgid = j;
                        Mk2.fDt |= 4;
                    }
                    i4 = 0;
                    x.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + Mk2.field_totallen + "  newOffset " + i5 + "  " + Mk2.field_status);
                    if (Mk2.field_totallen <= i5 && Mk2.field_status == 3 && i6 == 1) {
                        Mk2.field_status = 99;
                        Mk2.fDt |= 64;
                        ar.Hg();
                        au dH2 = c.Fa().dH((long) Mk2.field_msglocalid);
                        dH2.dS(Mk2.field_user);
                        dH2.ap(Mk2.field_msgid);
                        dH2.eQ(2);
                        dH2.setContent(f.b(Mk2.field_human, (long) Mk2.field_voicelenght, false));
                        ar.Hg();
                        c.Fa().a((long) Mk2.field_msglocalid, dH2);
                        x.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + Mk2.field_totallen + " status:" + Mk2.field_status + " netTimes:" + Mk2.field_nettimes);
                        i4 = 1;
                        h.nU(str2);
                    }
                    if (!h.a(Mk2)) {
                        i4 = -4;
                    }
                }
            }
            x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.fileName + " MsgSvrId:" + com_tencent_mm_protocal_c_brh.vHe + " clientId:" + com_tencent_mm_protocal_c_brh.vHU + " neWWOff:" + this.hWh + " neTTTT:" + com_tencent_mm_protocal_c_brh.vZw);
            if (i4 < 0) {
                h.ny(this.fileName);
                x.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + i4);
                this.gJT.a(i2, i3, str, this);
            } else if (i4 == 1) {
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
                this.gJT.a(i2, i3, str, this);
            } else {
                long j2 = this.hWy ? 0 : 500;
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + j2);
                this.hkO.J(j2, j2);
            }
        } else {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 329;
    }
}
