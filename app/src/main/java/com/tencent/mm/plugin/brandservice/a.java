package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a implements p {
    public static n ifs;
    public static m ift;

    public final void a(n nVar) {
        ifs = nVar;
    }

    public final void a(m mVar) {
        ift = mVar;
    }

    public static void f(int i, Object obj) {
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        ar.Hg();
        c.CU().set(i, obj);
    }
}
