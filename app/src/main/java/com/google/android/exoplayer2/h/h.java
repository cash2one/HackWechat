package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import java.io.InputStream;

public final class h extends InputStream {
    private final byte[] aAG;
    private boolean aAH = false;
    long aAI;
    private final f aiB;
    private final i asH;
    private boolean opened = false;

    public h(f fVar, i iVar) {
        this.aiB = fVar;
        this.asH = iVar;
        this.aAG = new byte[1];
    }

    public final int read() {
        if (read(this.aAG) == -1) {
            return -1;
        }
        return this.aAG[0] & 255;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        a.an(!this.aAH);
        lp();
        int read = this.aiB.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.aAI += (long) read;
        return read;
    }

    public final void close() {
        if (!this.aAH) {
            this.aiB.close();
            this.aAH = true;
        }
    }

    final void lp() {
        if (!this.opened) {
            this.aiB.a(this.asH);
            this.opened = true;
        }
    }
}
