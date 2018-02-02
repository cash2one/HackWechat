package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends i<a> {
    public static final String[] iEK = new String[]{i.a(a.iEJ, "AppBrandCommonKVBinaryData")};

    public a(e eVar) {
        super(eVar, a.iEJ, "AppBrandCommonKVBinaryData", null);
    }

    public final void k(String str, byte[] bArr) {
        if (!bh.ov(str)) {
            c aVar = new a();
            aVar.field_key = str;
            aVar.field_value = bArr;
            super.a(aVar);
        }
    }

    public final <T extends com.tencent.mm.bq.a> T g(String str, Class<T> cls) {
        byte[] bArr;
        if (!bh.ov(str)) {
            c aVar = new a();
            aVar.field_key = str;
            if (super.b(aVar, new String[0])) {
                bArr = aVar.field_value;
                if (bh.bw(bArr)) {
                    return null;
                }
                try {
                    T t = (com.tencent.mm.bq.a) cls.newInstance();
                    t.aF(bArr);
                    return t;
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", new Object[]{cls.getSimpleName(), e});
                    return null;
                }
            }
        }
        bArr = null;
        if (bh.bw(bArr)) {
            return null;
        }
        T t2 = (com.tencent.mm.bq.a) cls.newInstance();
        t2.aF(bArr);
        return t2;
    }
}
