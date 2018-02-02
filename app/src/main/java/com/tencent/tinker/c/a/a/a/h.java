package com.tencent.tinker.c.a.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.1;
import com.tencent.tinker.c.a.c.a.2;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class h extends i<com.tencent.tinker.a.a.h> {
    private a AgQ = null;
    private i$e AgR = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGx();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        int[] iArr = hVar.AeQ;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = aVar.ID(iArr[i]);
        }
        byte[] bArr = hVar.AeR;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.tencent.tinker.a.a.b.a 1 = new 1(aVar, byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + WXMediaMessage.TITLE_LENGTH_LIMIT);
        b 2 = new 2(aVar, byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new com.tencent.tinker.a.a.h(hVar.dzw, hVar.AeP, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    o.a(2, o.b(1));
                    break;
                case 2:
                    o.c(2, o.a(1));
                    break;
                case 3:
                case 4:
                    o.a(2, o.b(1));
                    o.b(2, aVar.ID(o.c(1)));
                    o.b(2, aVar.IE(o.c(1)));
                    if (read != 4) {
                        break;
                    }
                    o.b(2, aVar.ID(o.c(1)));
                    break;
                case 5:
                case 6:
                    o.a(2, o.b(1));
                    break;
                case 9:
                    o.b(2, aVar.ID(o.c(1)));
                    break;
                default:
                    break;
            }
        }
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        a aVar = this.AgQ;
        aVar.size++;
        return this.AgR.a(hVar);
    }

    public h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgQ = iVar2.AeT.AfC;
            this.AgR = iVar2.a(this.AgQ);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.AfC;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhW.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aik.IA(i2);
        }
    }
}
