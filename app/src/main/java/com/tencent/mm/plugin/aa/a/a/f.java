package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private e gJT;
    private b hNJ;
    private com.tencent.mm.protocal.c.f igU;
    public g igV;

    public f(long j, String str, List<String> list, int i, long j2, String str2) {
        a aVar = new a();
        aVar.hmj = new com.tencent.mm.protocal.c.f();
        aVar.hmk = new g();
        aVar.hmi = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.chatroomName = str2;
        this.hNJ = aVar.JZ();
        this.igU = (com.tencent.mm.protocal.c.f) this.hNJ.hmg.hmo;
        this.hNJ.hmx = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.igU.vCZ = list.size();
                    this.igU.vDa = j;
                    this.igU.title = URLEncoder.encode(str, "UTF-8");
                    this.igU.vDb = new LinkedList();
                    this.igU.vDb.addAll(list);
                    this.igU.scene = i;
                    this.igU.vCX = str2;
                    this.igU.vDc = i.bLf();
                    this.igU.vDd = j2;
                    x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.igU.vDc});
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
            }
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{Integer.valueOf(this.igU.vCZ), Long.valueOf(this.igU.vDa), this.igU.title, this.igU.vDb, Integer.valueOf(this.igU.scene), this.igU.vCX, Long.valueOf(this.igU.vDd)});
    }

    public f(long j, String str, int i, int i2, long j2, String str2) {
        a aVar = new a();
        aVar.hmj = new com.tencent.mm.protocal.c.f();
        aVar.hmk = new g();
        aVar.hmi = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.igU = (com.tencent.mm.protocal.c.f) this.hNJ.hmg.hmo;
        this.chatroomName = str2;
        try {
            this.igU.vCZ = i;
            this.igU.vDa = j;
            this.igU.title = URLEncoder.encode(str, "UTF-8");
            this.igU.vDb = new LinkedList();
            this.igU.scene = i2;
            this.igU.vCX = str2;
            this.igU.vDc = i.bLf();
            x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.igU.vDc});
            this.igU.vDd = j2;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[]{Integer.valueOf(this.igU.vCZ), Long.valueOf(this.igU.vDa), this.igU.title, this.igU.vDb, Integer.valueOf(this.igU.scene), this.igU.vCX, Long.valueOf(this.igU.vDd)});
    }

    public final int getType() {
        return 1624;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.igV = (g) ((b) qVar).hmh.hmo;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.igV.liH);
        objArr[1] = this.igV.liI;
        objArr[2] = Boolean.valueOf(this.igV.vCY == null);
        objArr[3] = this.igV.vCW;
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[]{this.igV.vCY});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
