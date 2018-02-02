package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;

public final class b extends FileInputStream {
    private boolean hLV = false;
    private a hLZ;
    private long hMa = 0;

    public b(String str, long j) {
        super(str);
        this.hLZ = new a(j);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.hLV) {
            x.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bh.cgy().toString());
        }
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
        x.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    }

    public final void mark(int i) {
        this.hMa = this.hLZ.Ru();
    }

    public final void reset() {
        getChannel().position(this.hMa);
        this.hLZ.reset();
    }

    public final boolean markSupported() {
        return true;
    }
}
