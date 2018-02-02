package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public String fBZ;
    private b gJQ;
    private e gJT;

    public c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new ack();
        aVar.hmk = new acl();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        aVar.hmi = 1337;
        this.gJQ = aVar.JZ();
        ack com_tencent_mm_protocal_c_ack = (ack) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ack.ngo = str;
        com_tencent_mm_protocal_c_ack.wlh = str2;
        com_tencent_mm_protocal_c_ack.wli = str3;
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
    }

    public c(String str) {
        a aVar = new a();
        aVar.hmj = new att();
        aVar.hmk = new atu();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
        aVar.hmi = 2721;
        this.gJQ = aVar.JZ();
        ((att) this.gJQ.hmg.hmo).wBP = str;
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:" + str);
    }

    public final int getType() {
        return this.gJQ.hmi;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " sceneType: " + this.gJQ.hmi);
        if (this.gJQ.hmi == 1337) {
            this.fBZ = ((acl) ((b) qVar).hmh.hmo).wii;
        } else if (this.gJQ.hmi == 2721) {
            this.fBZ = ((atu) ((b) qVar).hmh.hmo).wBQ;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
