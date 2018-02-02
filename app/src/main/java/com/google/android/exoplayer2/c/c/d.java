package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {
    private static final byte[] amS = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final String ael;
    long aig;
    private k alW;
    private int amN;
    private long amP;
    private final boolean amT;
    private final i amU;
    private final j amV;
    private String amW;
    private k amX;
    private int amY;
    private boolean amZ;
    private boolean ana;
    private k anb;
    private long anc;
    private int sampleSize;
    private int state;

    public d() {
        this(true, null);
    }

    public d(boolean z, String str) {
        this.amU = new i(new byte[7]);
        this.amV = new j(Arrays.copyOf(amS, 10));
        jz();
        this.amT = z;
        this.ael = str;
    }

    public final void jx() {
        jz();
    }

    public final void a(f fVar, com.google.android.exoplayer2.c.c.u.d dVar) {
        dVar.jF();
        this.amW = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
        if (this.amT) {
            dVar.jF();
            this.amX = fVar.ck(dVar.jG());
            this.amX.f(Format.g(dVar.jH(), "application/id3"));
            return;
        }
        this.amX = new c();
    }

    public final void c(long j, boolean z) {
        this.aig = j;
    }

    public final void b(j jVar) {
        while (jVar.lF() > 0) {
            int i;
            int i2;
            switch (this.state) {
                case 0:
                    byte[] bArr = jVar.data;
                    i = jVar.position;
                    int i3 = jVar.asN;
                    i2 = i;
                    while (i2 < i3) {
                        i = i2 + 1;
                        i2 = bArr[i2] & 255;
                        if (this.amY == WXMediaMessage.TITLE_LENGTH_LIMIT && i2 >= 240 && i2 != 255) {
                            this.amZ = (i2 & 1) == 0;
                            this.state = 2;
                            this.amN = 0;
                            jVar.cR(i);
                            break;
                        }
                        switch (i2 | this.amY) {
                            case 329:
                                this.amY = 768;
                                i2 = i;
                                break;
                            case 511:
                                this.amY = WXMediaMessage.TITLE_LENGTH_LIMIT;
                                i2 = i;
                                break;
                            case 836:
                                this.amY = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                                i2 = i;
                                break;
                            case 1075:
                                this.state = 1;
                                this.amN = amS.length;
                                this.sampleSize = 0;
                                this.amV.cR(0);
                                break;
                            default:
                                if (this.amY == 256) {
                                    i2 = i;
                                    break;
                                }
                                this.amY = 256;
                                i2 = i - 1;
                                break;
                        }
                    }
                    i = i2;
                    jVar.cR(i);
                    break;
                case 1:
                    if (!a(jVar, this.amV.data, 10)) {
                        break;
                    }
                    this.amX.a(this.amV, 10);
                    this.amV.cR(6);
                    a(this.amX, 0, 10, this.amV.lH() + 10);
                    break;
                case 2:
                    if (!a(jVar, this.amU.data, this.amZ ? 7 : 5)) {
                        break;
                    }
                    this.amU.cR(0);
                    if (this.ana) {
                        this.amU.cS(10);
                    } else {
                        i2 = this.amU.cT(2) + 1;
                        if (i2 != 2) {
                            new StringBuilder("Detected audio object type: ").append(i2).append(", but assuming AAC LC.");
                            i2 = 2;
                        }
                        i = this.amU.cT(4);
                        this.amU.cS(1);
                        Object t = com.google.android.exoplayer2.i.c.t(i2, i, this.amU.cT(3));
                        Pair h = com.google.android.exoplayer2.i.c.h(t);
                        Format a = Format.a(this.amW, "audio/mp4a-latm", -1, -1, ((Integer) h.second).intValue(), ((Integer) h.first).intValue(), Collections.singletonList(t), null, this.ael);
                        this.amP = 1024000000 / ((long) a.sampleRate);
                        this.alW.f(a);
                        this.ana = true;
                    }
                    this.amU.cS(4);
                    int cT = (this.amU.cT(13) - 2) - 5;
                    if (this.amZ) {
                        cT -= 2;
                    }
                    a(this.alW, this.amP, 0, cT);
                    break;
                case 3:
                    i2 = Math.min(jVar.lF(), this.sampleSize - this.amN);
                    this.anb.a(jVar, i2);
                    this.amN = i2 + this.amN;
                    if (this.amN != this.sampleSize) {
                        break;
                    }
                    this.anb.a(this.aig, 1, this.sampleSize, 0, null);
                    this.aig += this.anc;
                    jz();
                    break;
                default:
                    break;
            }
        }
    }

    public final void jy() {
    }

    private boolean a(j jVar, byte[] bArr, int i) {
        int min = Math.min(jVar.lF(), i - this.amN);
        jVar.readBytes(bArr, this.amN, min);
        this.amN = min + this.amN;
        return this.amN == i;
    }

    private void jz() {
        this.state = 0;
        this.amN = 0;
        this.amY = 256;
    }

    private void a(k kVar, long j, int i, int i2) {
        this.state = 3;
        this.amN = i;
        this.anb = kVar;
        this.anc = j;
        this.sampleSize = i2;
    }
}
