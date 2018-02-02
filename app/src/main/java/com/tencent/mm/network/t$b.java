package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.network.j.a;

class t$b extends a implements l {
    private t gxO;
    private WakerLock iao;

    public t$b(t tVar, WakerLock wakerLock) {
        this.gxO = tVar;
        this.iao = wakerLock;
    }

    public final void a(r rVar, int i, int i2, String str) {
        this.iao.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
        new 1(this, rVar, i, i2).b(this.gxO.handler);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
    }
}
