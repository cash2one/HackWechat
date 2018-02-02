package com.google.android.exoplayer2.h;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p implements f {
    private final t<? super p> aAB;
    private long aAD;
    private RandomAccessFile aBB;
    private boolean opened;
    private Uri uri;

    public p() {
        this(null);
    }

    public p(t<? super p> tVar) {
        this.aAB = tVar;
    }

    public final long a(i iVar) {
        try {
            this.uri = iVar.uri;
            this.aBB = new RandomAccessFile(iVar.uri.getPath(), "r");
            this.aBB.seek(iVar.position);
            this.aAD = iVar.aAL == -1 ? this.aBB.length() - iVar.position : iVar.aAL;
            if (this.aAD < 0) {
                throw new EOFException();
            }
            this.opened = true;
            if (this.aAB != null) {
                this.aAB.ls();
            }
            return this.aAD;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.aAD == 0) {
            return -1;
        }
        try {
            int read = this.aBB.read(bArr, i, (int) Math.min(this.aAD, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.aAD -= (long) read;
            if (this.aAB == null) {
                return read;
            }
            this.aAB.cQ(read);
            return read;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        this.uri = null;
        try {
            if (this.aBB != null) {
                this.aBB.close();
            }
            this.aBB = null;
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        } catch (IOException e) {
            throw new a(e);
        } catch (Throwable th) {
            this.aBB = null;
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        }
    }
}
