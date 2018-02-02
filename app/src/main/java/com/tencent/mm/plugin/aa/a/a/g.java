package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private e gJT;
    private b hNJ;
    private h igW;
    public i igX;

    public g(String str, long j, List<j> list, int i, String str2, long j2) {
        a aVar = new a();
        aVar.hmj = new h();
        aVar.hmk = new i();
        aVar.hmi = 1655;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.igW = (h) this.hNJ.hmg.hmo;
        this.hNJ.hmx = true;
        try {
            this.igW.title = p.encode(str, "UTF-8");
            this.igW.vDf = j;
            this.igW.vDb = new LinkedList();
            this.igW.vDb.addAll(list);
            this.igW.scene = i;
            this.igW.vCX = str2;
            this.igW.vDc = com.tencent.mm.plugin.wallet_core.model.i.bLf();
            this.igW.vDd = j2;
            x.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[]{this.igW.vDc});
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[]{e.getMessage()});
        }
        this.chatroomName = str2;
        x.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{this.igW.title, Long.valueOf(this.igW.vDf), this.igW.vDb, Integer.valueOf(this.igW.scene), this.igW.vCX, Long.valueOf(this.igW.vDd)});
    }

    public final int getType() {
        return 1655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.igX = (i) ((b) qVar).hmh.hmo;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.igX.liH);
        objArr[1] = this.igX.liI;
        objArr[2] = this.igX.vCW;
        objArr[3] = Boolean.valueOf(this.igX.vCY == null);
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[]{this.igX.vCY});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
