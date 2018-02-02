package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gJT;
    public long hFb = -1;
    private byte[] hFw;
    private q hnp;
    private int uin = 0;

    public h(long j, byte[] bArr) {
        this.hFb = j;
        this.hFw = bArr;
    }

    public h(long j, byte[] bArr, int i) {
        this.hFb = j;
        this.hFw = bArr;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bh.bw(this.hFw)) {
            x.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[]{"get keyBuf failed"});
            return -1;
        }
        if (this.uin == 0) {
            this.hnp = new a();
        } else {
            this.hnp = new b();
            ((b) this.hnp).uin = this.uin;
        }
        x.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[]{Long.valueOf(this.hFb), bh.bu(this.hFw)});
        ((a) this.hnp.Kb()).hHE = this.hFb;
        ((a) this.hnp.Kb()).fvp = this.hFw;
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 268369922;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
