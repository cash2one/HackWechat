package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ani;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class v extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    public String hqf;
    public int hqg;
    public String tag;

    public v(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private v(String str, LinkedList<String> linkedList, byte b) {
        this.hqg = 1;
        a aVar = new a();
        aVar.hmj = new ani();
        aVar.hmk = new anj();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.hmi = 675;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ani com_tencent_mm_protocal_c_ani = (ani) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ani.wuq = str;
        com_tencent_mm_protocal_c_ani.wut = linkedList;
        this.hqf = str;
        this.hqg = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 675;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final anj Mc() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (anj) this.gJQ.hmh.hmo;
    }
}
