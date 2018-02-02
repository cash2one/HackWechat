package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public abstract class a {

    class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream AhE;
        final /* synthetic */ a AhF;

        public AnonymousClass1(a aVar, ByteArrayInputStream byteArrayInputStream) {
            this.AhF = aVar;
            this.AhE = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.AhE.read() & 255);
        }
    }

    class AnonymousClass4 implements b {
        final /* synthetic */ a AhF;
        final /* synthetic */ ByteArrayOutputStream AhG;

        public AnonymousClass4(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
            this.AhF = aVar;
            this.AhG = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AhG.write(i);
        }
    }

    public abstract int ID(int i);

    public abstract int IE(int i);

    public abstract int IF(int i);

    public abstract int IG(int i);

    public abstract int IH(int i);

    public abstract int II(int i);

    public abstract int IJ(int i);

    public abstract int IK(int i);

    public abstract int IL(int i);

    public abstract int IM(int i);

    public abstract int IN(int i);

    public abstract int IO(int i);

    public abstract int IP(int i);

    public abstract int IQ(int i);

    public final com.tencent.tinker.a.a.e.a[] b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(IG(aVar.Aer), aVar.Aes);
        }
        return aVarArr2;
    }

    public final e.b[] b(e.b[] bVarArr) {
        e.b[] bVarArr2 = new e.b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            e.b bVar = bVarArr[i];
            bVarArr2[i] = new e.b(IH(bVar.Aet), bVar.Aes, IQ(bVar.Aeu));
        }
        return bVarArr2;
    }
}
