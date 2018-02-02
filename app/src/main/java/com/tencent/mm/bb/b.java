package com.tencent.mm.bb;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bpz;
import com.tencent.mm.protocal.c.bqa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class b extends k implements com.tencent.mm.network.k {
    private String clientId;
    private String fzs;
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String hKt;
    private int hlp;
    private int hlq;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.fzs = str2;
    }

    private b(String str) {
        this.username = str;
        this.hlp = 0;
        this.hlq = 0;
        StringBuilder stringBuilder = new StringBuilder();
        g.Dh();
        this.clientId = stringBuilder.append(a.Cg()).append(System.currentTimeMillis()).toString();
    }

    public final int getType() {
        return 575;
    }

    protected final int a(q qVar) {
        if (this.fzs == null || this.fzs.length() == 0) {
            return com.tencent.mm.ae.k.b.hmQ;
        }
        return com.tencent.mm.ae.k.b.hmP;
    }

    protected final int Bh() {
        return 100;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.fzs == null || this.fzs.length() == 0) {
            x.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            return -1;
        } else if (com.tencent.mm.a.e.bO(this.fzs)) {
            if (this.hlp == 0) {
                this.hlp = (int) new File(this.fzs).length();
            }
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new bpz();
            aVar.hmk = new bqa();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.hmi = 575;
            aVar.hml = 0;
            aVar.hmm = 0;
            this.gJQ = aVar.JZ();
            byte[] d = com.tencent.mm.a.e.d(this.fzs, this.hlq, Math.min(this.hlp - this.hlq, WXMediaMessage.THUMB_LENGTH_LIMIT));
            if (d == null) {
                x.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[]{Integer.valueOf(d.length), Integer.valueOf(this.hlp)});
            bpz com_tencent_mm_protocal_c_bpz = (bpz) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_bpz.vYX = this.username;
            com_tencent_mm_protocal_c_bpz.vIB = this.hlp;
            com_tencent_mm_protocal_c_bpz.vIC = this.hlq;
            com_tencent_mm_protocal_c_bpz.vXz = new bdn().bj(d);
            com_tencent_mm_protocal_c_bpz.vID = com_tencent_mm_protocal_c_bpz.vXz.wJB;
            com_tencent_mm_protocal_c_bpz.vGQ = this.clientId;
            return a(eVar, this.gJQ, this);
        } else {
            x.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.fzs);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            bqa com_tencent_mm_protocal_c_bqa = (bqa) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
            this.hKt = com_tencent_mm_protocal_c_bqa.wzs;
            this.hlq = com_tencent_mm_protocal_c_bqa.vIC;
            if (this.hlq < this.hlp) {
                if (a(this.hmA, this.gJT) < 0) {
                    x.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.gJT.a(3, -1, "", this);
                }
                x.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                return;
            }
            if (!bh.ov(this.hKt)) {
                af WO = ((h) g.h(h.class)).EY().WO(this.username);
                if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                    WO.dx(this.hKt);
                    ((h) g.h(h.class)).EY().a(this.username, WO);
                }
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.gJT.a(i2, i3, str, this);
    }
}
