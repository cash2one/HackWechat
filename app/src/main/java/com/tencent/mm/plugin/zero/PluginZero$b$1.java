package com.tencent.mm.plugin.zero;

import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cd.a.a;
import com.tencent.mm.plugin.zero.PluginZero.b;
import com.tencent.mm.plugin.zero.a.c;

class PluginZero$b$1 implements a<c> {
    final /* synthetic */ NotifyService vaL;
    final /* synthetic */ int vaM;
    final /* synthetic */ byte[] vaN;
    final /* synthetic */ byte[] vaO;
    final /* synthetic */ long vaP;
    final /* synthetic */ b vaQ;

    PluginZero$b$1(b bVar, NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        this.vaQ = bVar;
        this.vaL = notifyService;
        this.vaM = i;
        this.vaN = bArr;
        this.vaO = bArr2;
        this.vaP = j;
    }

    public final /* synthetic */ void az(Object obj) {
        ((c) obj).a(this.vaL, this.vaM, this.vaN, this.vaO, this.vaP);
    }
}
