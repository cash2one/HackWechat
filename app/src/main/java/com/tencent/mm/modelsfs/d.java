package com.tencent.mm.modelsfs;

public final class d extends SFSInputStream {
    private a hLZ;

    public d(long j, long j2) {
        super(j);
        this.hLZ = new a(j2);
    }

    public final void mark(int i) {
        super.mark(i);
        this.hLZ.Ru();
    }

    public final void reset() {
        super.reset();
        this.hLZ.reset();
    }

    public final int read() {
        return super.read();
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read >= 0) {
            this.hLZ.w(bArr, i2);
        }
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.hLZ.seek(j);
        return skip;
    }

    public final void close() {
        super.close();
        if (this.hLZ != null) {
            this.hLZ.free();
        }
    }
}
