package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private String clientId = "";
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private long hUa = -1;
    private r hUb = null;
    private keep_SceneResult hUc = null;

    public e(long j, r rVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str) {
        x.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[]{Long.valueOf(j), str});
        this.hUa = j;
        this.hUb = rVar;
        this.hUc = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.clientId = str;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        int i = 0;
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new bgb();
        aVar.hmk = new bgc();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.hmi = 245;
        this.gJQ = aVar.JZ();
        bgb com_tencent_mm_protocal_c_bgb = (bgb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bgb.hbp = this.hUc.field_aesKey;
        com_tencent_mm_protocal_c_bgb.raP = this.clientId;
        com_tencent_mm_protocal_c_bgb.fqR = this.hUb.fHk;
        com_tencent_mm_protocal_c_bgb.wKJ = this.hUb.hVH;
        o.TU();
        Options UL = d.UL(s.nu(this.hUb.getFileName()));
        if (UL != null) {
            com_tencent_mm_protocal_c_bgb.hbo = UL.outWidth;
            com_tencent_mm_protocal_c_bgb.hbn = UL.outHeight;
        } else {
            x.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[]{r2});
        }
        com_tencent_mm_protocal_c_bgb.hUs = this.hUb.hVD;
        String[] split = bh.az(this.hUb.hVP, "").split(",");
        if (split == null || split.length <= 0) {
            x.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[]{Long.valueOf(this.hUa)});
            return -1;
        }
        int length = split.length;
        while (i < length) {
            String str = split[i];
            bnx com_tencent_mm_protocal_c_bnx = new bnx();
            com_tencent_mm_protocal_c_bnx.username = str;
            com_tencent_mm_protocal_c_bgb.wKI.add(com_tencent_mm_protocal_c_bnx);
            i++;
        }
        com_tencent_mm_protocal_c_bgb.url = this.hUc.field_fileId;
        com_tencent_mm_protocal_c_bgb.hVH = this.hUb.hlp;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.hUa);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 245;
    }
}
