package com.tencent.mm.modelsfs;

public final class e extends SFSOutputStream {
    private a hLZ;

    public e(long j, String str) {
        super(j);
        this.hLZ = new a(str);
    }

    public final void write(int i) {
        super.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.hLZ.w(bArr, i2);
        super.write(bArr, i, i2);
    }

    public final void close() {
        super.close();
        if (this.hLZ != null) {
            this.hLZ.free();
        }
    }

    protected final void finalize() {
        super.finalize();
    }
}
