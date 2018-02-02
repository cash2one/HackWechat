package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.EOFException;
import java.util.Arrays;

public final class b implements e {
    private static final byte[] aiA = new byte[Downloads.RECV_BUFFER_SIZE];
    private final f aiB;
    private final long aiC;
    private byte[] aiD = new byte[65536];
    private int aiE;
    private int aiF;
    private long position;

    public b(f fVar, long j, long j2) {
        this.aiB = fVar;
        this.position = j;
        this.aiC = j2;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int c = c(bArr, i, i2);
        if (c == 0) {
            c = a(bArr, i, i2, 0, true);
        }
        cj(c);
        return c;
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        int c = c(bArr, i, i2);
        while (c < i2 && c != -1) {
            c = a(bArr, i, i2, c, z);
        }
        cj(c);
        return c != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        a(bArr, i, i2, false);
    }

    public final int ce(int i) {
        int ch = ch(i);
        if (ch == 0) {
            ch = a(aiA, 0, Math.min(i, aiA.length), 0, true);
        }
        cj(ch);
        return ch;
    }

    public final void cf(int i) {
        int ch = ch(i);
        while (ch < i && ch != -1) {
            ch = a(aiA, -ch, Math.min(i, aiA.length + ch), ch, false);
        }
        cj(ch);
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) {
        if (!j(i2, z)) {
            return false;
        }
        System.arraycopy(this.aiD, this.aiE - i2, bArr, i, i2);
        return true;
    }

    public final void b(byte[] bArr, int i, int i2) {
        b(bArr, i, i2, false);
    }

    private boolean j(int i, boolean z) {
        int i2 = this.aiE + i;
        if (i2 > this.aiD.length) {
            this.aiD = Arrays.copyOf(this.aiD, t.u(this.aiD.length * 2, 65536 + i2, i2 + SQLiteGlobal.journalSizeLimit));
        }
        int min = Math.min(this.aiF - this.aiE, i);
        while (min < i) {
            min = a(this.aiD, this.aiE, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.aiE += i;
        this.aiF = Math.max(this.aiF, this.aiE);
        return true;
    }

    public final void cg(int i) {
        j(i, false);
    }

    public final void js() {
        this.aiE = 0;
    }

    public final long jt() {
        return this.position + ((long) this.aiE);
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getLength() {
        return this.aiC;
    }

    private int ch(int i) {
        int min = Math.min(this.aiF, i);
        ci(min);
        return min;
    }

    private int c(byte[] bArr, int i, int i2) {
        if (this.aiF == 0) {
            return 0;
        }
        int min = Math.min(this.aiF, i2);
        System.arraycopy(this.aiD, 0, bArr, i, min);
        ci(min);
        return min;
    }

    private void ci(int i) {
        this.aiF -= i;
        this.aiE = 0;
        Object obj = this.aiD;
        if (this.aiF < this.aiD.length - SQLiteGlobal.journalSizeLimit) {
            obj = new byte[(this.aiF + 65536)];
        }
        System.arraycopy(this.aiD, i, obj, 0, this.aiF);
        this.aiD = obj;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.aiB.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void cj(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }
}
