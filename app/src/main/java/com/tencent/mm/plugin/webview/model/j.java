package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afe;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;
    public Object tag;

    public j(String str, String str2, int i, int i2) {
        x.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hmj = new afe();
        aVar.hmk = new aff();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        aVar.hmi = 673;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        afe com_tencent_mm_protocal_c_afe = (afe) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_afe.URL = str;
        com_tencent_mm_protocal_c_afe.wnd = str2;
        com_tencent_mm_protocal_c_afe.Width = i;
        com_tencent_mm_protocal_c_afe.Height = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.gOB.a(i2, i3, str, this);
        if (i2 != 0 || i3 != 0) {
            x.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final int getType() {
        return 673;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
