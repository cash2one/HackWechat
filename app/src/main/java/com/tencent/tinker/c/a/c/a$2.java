package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import java.io.ByteArrayOutputStream;

class a$2 implements b {
    final /* synthetic */ ByteArrayOutputStream AfU;
    final /* synthetic */ a AhF;

    public a$2(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.AhF = aVar;
        this.AfU = byteArrayOutputStream;
    }

    public final void writeByte(int i) {
        this.AfU.write(i);
    }
}
