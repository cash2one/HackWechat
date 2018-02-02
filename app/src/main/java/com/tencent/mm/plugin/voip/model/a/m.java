package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class m extends n<bvf, bvg> {
    public m(int i, bud com_tencent_mm_protocal_c_bud, byte[] bArr, long j, int i2) {
        a aVar = new a();
        aVar.hmj = new bvf();
        aVar.hmk = new bvg();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.hmi = GameJsApiOperateGameCenterMsg.CTRL_BYTE;
        aVar.hml = 62;
        aVar.hmm = 1000000062;
        this.gJQ = aVar.JZ();
        bvf com_tencent_mm_protocal_c_bvf = (bvf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bvf.wbh = i;
        com_tencent_mm_protocal_c_bvf.wWH = com_tencent_mm_protocal_c_bud;
        com_tencent_mm_protocal_c_bvf.wbi = j;
        com_tencent_mm_protocal_c_bvf.wFM = q.FS();
        com_tencent_mm_protocal_c_bvf.vRz = i2;
        com_tencent_mm_protocal_c_bvf.vRA = new bdn().bj(bArr);
        com_tencent_mm_protocal_c_bvf.wUq = System.currentTimeMillis();
        x.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + com_tencent_mm_protocal_c_bvf.wUq);
    }

    public final int getType() {
        return GameJsApiOperateGameCenterMsg.CTRL_BYTE;
    }

    public final int bHL() {
        return ((bvf) this.gJQ.hmg.hmo).vRz;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
