package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.av;

class f$4 implements Runnable {
    final /* synthetic */ f Aog;
    final /* synthetic */ av[] Aoi;
    final /* synthetic */ as Aoj;
    final /* synthetic */ byte[] Aok;
    final /* synthetic */ boolean Aol;
    final /* synthetic */ String Aom;
    final /* synthetic */ int Aon;
    final /* synthetic */ int Aoo;
    final /* synthetic */ byte[] Aop;
    final /* synthetic */ int kss;
    final /* synthetic */ long saA;
    final /* synthetic */ int saz;

    f$4(f fVar, int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2) {
        this.Aog = fVar;
        this.kss = i;
        this.Aoi = avVarArr;
        this.Aoj = asVar;
        this.Aok = bArr;
        this.Aol = z;
        this.Aom = str;
        this.saz = i2;
        this.saA = j;
        this.Aon = i3;
        this.Aoo = i4;
        this.Aop = bArr2;
    }

    public final void run() {
        f.a(this.Aog, this.kss - 1, this.Aoi, this.Aoj, this.Aok, this.Aol, this.Aom, this.saz, this.saA, this.Aon, this.Aoo, this.Aop);
    }
}
