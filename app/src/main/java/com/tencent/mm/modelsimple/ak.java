package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

public final class ak extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public ak(String str, int i, LinkedList<cl> linkedList) {
        x.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        a aVar = new a();
        aVar.hmj = new bon();
        aVar.hmk = new boo();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        aVar.hmi = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bon com_tencent_mm_protocal_c_bon = (bon) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bon.hOf = str;
        com_tencent_mm_protocal_c_bon.scene = i;
        com_tencent_mm_protocal_c_bon.wQV = linkedList;
    }

    public final int getType() {
        return TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final String Sp() {
        boo com_tencent_mm_protocal_c_boo = (boo) this.gJQ.hmh.hmo;
        if (com_tencent_mm_protocal_c_boo == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_boo.wQW;
    }

    public final boo Sq() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (boo) this.gJQ.hmh.hmo;
    }
}
