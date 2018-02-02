package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.protocal.c.aea;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends k implements com.tencent.mm.network.k {
    private RandomAccessFile aBB = null;
    private String filePath = null;
    private e gJT;
    private int hlp = 0;
    private int kAL = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new aea();
        aVar.hmk = new aeb();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.hmi = j.CTRL_INDEX;
        aVar.hml = 29;
        aVar.hmm = 1000000029;
        q JZ = aVar.JZ();
        aea com_tencent_mm_protocal_c_aea = (aea) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_aea.URL = this.url;
        com_tencent_mm_protocal_c_aea.vNW = this.kAL;
        x.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.kAL + " totallen:" + this.hlp);
        return a(eVar, JZ, this);
    }

    protected final int a(q qVar) {
        String str = ((aea) ((b) qVar).hmg.hmo).URL;
        Object obj = str == null ? null : str.indexOf("weixin://") != 0 ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            return k.b.hmQ;
        } else if (this.kAL < 0 || this.hlp < 0) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kAL + " total:" + this.hlp);
            return k.b.hmQ;
        } else {
            if (this.kAL == 0) {
                if (this.hlp != 0) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kAL + " total:" + this.hlp);
                    return k.b.hmQ;
                }
            } else if (this.kAL >= this.hlp) {
                x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.kAL + " total:" + this.hlp);
                return k.b.hmQ;
            }
            return k.b.hmP;
        }
    }

    protected final int Bh() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            aeb com_tencent_mm_protocal_c_aeb = (aeb) ((b) qVar).hmh.hmo;
            x.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.kAL + " Resp[ totallen:" + com_tencent_mm_protocal_c_aeb.vNV + " bufSize:" + com_tencent_mm_protocal_c_aeb.vXz.wJB + " ]");
            if (com_tencent_mm_protocal_c_aeb.vNV > 0) {
                this.hlp = com_tencent_mm_protocal_c_aeb.vNV;
            }
            if (d(this.url, com_tencent_mm_protocal_c_aeb.vXz.wJD.oz, this.kAL)) {
                this.kAL = com_tencent_mm_protocal_c_aeb.vXz.wJB + this.kAL;
                if (this.hlp <= this.kAL) {
                    x.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hlp);
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else if (a(this.hmA, this.gJT) < 0) {
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else {
                    return;
                }
            }
            this.gJT.a(3, -1, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    private boolean d(String str, byte[] bArr, int i) {
        if (i == 0) {
            if (this.aBB == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.j.a.a.Sb(str);
                if (this.filePath == null) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    return false;
                }
                try {
                    this.aBB = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    return false;
                }
            }
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            return false;
        }
        try {
            this.aBB.seek((long) i);
            this.aBB.write(bArr, 0, bArr.length);
            return true;
        } catch (IOException e2) {
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            return false;
        }
    }

    public final int getType() {
        return j.CTRL_INDEX;
    }
}
