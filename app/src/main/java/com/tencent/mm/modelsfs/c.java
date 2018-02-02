package com.tencent.mm.modelsfs;

import java.io.File;
import java.io.FileOutputStream;

public final class c extends FileOutputStream {
    private a hLZ;

    public c(File file, long j) {
        super(file);
        this.hLZ = new a(j);
    }

    public c(String str, String str2) {
        super(str);
        this.hLZ = new a(str2);
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
}
