package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class m implements h {
    private final String ael;
    private int afs;
    private long aig;
    private k alW;
    private String amW;
    private boolean ana;
    private long anl;
    private final j aor;
    private final i aos;
    private int aot;
    private boolean aou;
    private int state;

    public m() {
        this(null);
    }

    public m(String str) {
        this.state = 0;
        this.aor = new j(4);
        this.aor.data[0] = (byte) -1;
        this.aos = new i();
        this.ael = str;
    }

    public final void jx() {
        this.state = 0;
        this.aot = 0;
        this.aou = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.jF();
        this.amW = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
    }

    public final void c(long j, boolean z) {
        this.aig = j;
    }

    public final void b(j jVar) {
        while (jVar.lF() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    byte[] bArr = jVar.data;
                    i = jVar.position;
                    int i2 = jVar.asN;
                    for (int i3 = i; i3 < i2; i3++) {
                        boolean z = (bArr[i3] & 255) == 255;
                        boolean z2 = this.aou && (bArr[i3] & 224) == 224;
                        this.aou = z;
                        if (z2) {
                            jVar.cR(i3 + 1);
                            this.aou = false;
                            this.aor.data[1] = bArr[i3];
                            this.aot = 2;
                            this.state = 1;
                            break;
                        }
                    }
                    jVar.cR(i2);
                    break;
                case 1:
                    i = Math.min(jVar.lF(), 4 - this.aot);
                    jVar.readBytes(this.aor.data, this.aot, i);
                    this.aot = i + this.aot;
                    if (this.aot < 4) {
                        break;
                    }
                    this.aor.cR(0);
                    if (!i.a(this.aor.readInt(), this.aos)) {
                        this.aot = 0;
                        this.state = 1;
                        break;
                    }
                    this.afs = this.aos.afs;
                    if (!this.ana) {
                        this.anl = (1000000 * ((long) this.aos.aiP)) / ((long) this.aos.sampleRate);
                        this.alW.f(Format.a(this.amW, this.aos.mimeType, -1, Downloads.RECV_BUFFER_SIZE, this.aos.channels, this.aos.sampleRate, null, null, this.ael));
                        this.ana = true;
                    }
                    this.aor.cR(0);
                    this.alW.a(this.aor, 4);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(jVar.lF(), this.afs - this.aot);
                    this.alW.a(jVar, i);
                    this.aot = i + this.aot;
                    if (this.aot < this.afs) {
                        break;
                    }
                    this.alW.a(this.aig, 1, this.afs, 0, null);
                    this.aig += this.anl;
                    this.aot = 0;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public final void jy() {
    }
}
