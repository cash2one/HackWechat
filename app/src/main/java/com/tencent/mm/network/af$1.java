package com.tencent.mm.network;

class af$1 implements Runnable {
    final /* synthetic */ int ibm;
    final /* synthetic */ byte[] ibn;
    final /* synthetic */ af ibo;

    af$1(af afVar, int i, byte[] bArr) {
        this.ibo = afVar;
        this.ibm = i;
        this.ibn = bArr;
    }

    public final void run() {
        aa.VS().onPush(this.ibm, this.ibn);
    }
}
