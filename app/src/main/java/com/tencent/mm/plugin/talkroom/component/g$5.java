package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.sdk.platformtools.bc;

class g$5 extends bc<Integer> {
    final /* synthetic */ int lwE;
    final /* synthetic */ long saA;
    final /* synthetic */ int[] saB;
    final /* synthetic */ short[] saC;
    final /* synthetic */ int saD;
    final /* synthetic */ g sav;
    final /* synthetic */ b sax;
    final /* synthetic */ int say;
    final /* synthetic */ int saz;

    g$5(g gVar, Integer num, b bVar, int i, int i2, int i3, long j, int[] iArr, short[] sArr, int i4) {
        this.sav = gVar;
        this.sax = bVar;
        this.lwE = i;
        this.say = i2;
        this.saz = i3;
        this.saA = j;
        this.saB = iArr;
        this.saC = sArr;
        this.saD = i4;
        super(3000, num);
    }

    protected final /* synthetic */ Object run() {
        return Integer.valueOf(g.a(this.sav).Open(this.sax, this.lwE, this.say, this.saz, this.saA, this.saB, this.saC, this.saD));
    }
}
