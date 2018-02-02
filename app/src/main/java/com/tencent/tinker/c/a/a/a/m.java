package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.3;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class m extends i<k> {
    private a AgY = null;
    private e AgZ = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGD();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        k kVar = (k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar.data.length);
        new a$a(aVar, new 3(aVar, byteArrayOutputStream)).c(new com.tencent.tinker.a.a.m(kVar, 28));
        return new k(kVar.dzw, byteArrayOutputStream.toByteArray());
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        k kVar = (k) comparable;
        a aVar = this.AgY;
        aVar.size++;
        return this.AgZ.a(kVar);
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AgY = iVar2.AeT.AfE;
            this.AgZ = iVar2.a(this.AgY);
        }
    }

    protected final a c(i iVar) {
        return iVar.AeT.AfE;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AhU.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Aii.IA(i2);
        }
    }
}
