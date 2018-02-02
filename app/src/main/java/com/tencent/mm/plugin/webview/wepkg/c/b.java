package com.tencent.mm.plugin.webview.wepkg.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private long size;
    private a tNT;

    public b(File file, long j, long j2) {
        this.size = j2;
        this.tNT = new a(new FileInputStream(file));
        fl(j);
        this.tNT.bVm();
    }

    public final int read() {
        if ((bVn() <= 0 ? 1 : null) != null) {
            return -1;
        }
        return this.tNT.read();
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        long fk = fk((long) i2);
        if (fk != 0 || i2 <= 0) {
            return this.tNT.read(bArr, i, (int) fk);
        }
        return -1;
    }

    public final long skip(long j) {
        return this.tNT.skip(fk(j));
    }

    public final int available() {
        return (int) fk((long) this.tNT.available());
    }

    private long fk(long j) {
        return Math.min(bVn(), j);
    }

    private long bVn() {
        return this.size - ((long) this.tNT.count);
    }

    private void fl(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.tNT.skip(j - j2);
            if (skip <= 0) {
                break;
            }
            j2 += skip;
        }
        if (j2 < j) {
            throw new IOException("could not seek pos " + j);
        }
    }
}
