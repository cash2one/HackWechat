package com.tencent.tinker.d.a;

import java.io.InputStream;
import java.io.RandomAccessFile;

public class g$a extends InputStream {
    private final RandomAccessFile Amj;
    private long aqI;
    private long oJ;

    private g$a(RandomAccessFile randomAccessFile, long j, long j2) {
        this.Amj = randomAccessFile;
        this.oJ = j;
        this.aqI = j2;
    }

    public g$a(RandomAccessFile randomAccessFile, long j) {
        this(randomAccessFile, j, randomAccessFile.length());
    }

    public final int available() {
        return this.oJ < this.aqI ? 1 : 0;
    }

    public final int read() {
        return e.x(this);
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read;
        synchronized (this.Amj) {
            long j = this.aqI - this.oJ;
            if (((long) i2) > j) {
                i2 = (int) j;
            }
            this.Amj.seek(this.oJ);
            read = this.Amj.read(bArr, i, i2);
            if (read > 0) {
                this.oJ += (long) read;
            } else {
                read = -1;
            }
        }
        return read;
    }

    public final long skip(long j) {
        if (j > this.aqI - this.oJ) {
            j = this.aqI - this.oJ;
        }
        this.oJ += j;
        return j;
    }
}
