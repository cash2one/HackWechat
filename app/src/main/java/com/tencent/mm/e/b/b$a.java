package com.tencent.mm.e.b;

import com.tencent.mm.modelvoice.q;
import java.io.FileOutputStream;

class b$a extends FileOutputStream {
    final /* synthetic */ b fkh;
    private String path;

    public b$a(b bVar, String str) {
        this.fkh = bVar;
        super(str);
        this.path = str;
    }

    public final void write(byte[] bArr, int i, int i2) {
        super.write(bArr, i, i2);
        q.a(this.path, bArr, i, i2);
    }
}
