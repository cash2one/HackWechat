package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class av extends k implements com.tencent.mm.network.k {
    public String fod;
    private e gJT;
    public final b lMW;

    public av(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hmj = new wo();
        aVar.hmk = new wp();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        aVar.hmi = 1329;
        aVar.hml = 0;
        aVar.hmm = 0;
        if (str2 == null) {
            this.fod = "";
        } else {
            this.fod = str2.trim();
        }
        this.lMW = aVar.JZ();
        wo woVar = (wo) this.lMW.hmg.hmo;
        woVar.nhF = str;
        woVar.wgS = str2;
        woVar.wgT = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1329;
    }
}
