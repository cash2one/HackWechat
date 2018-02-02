package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.sdk.e.c;

class b$b implements j<ContentValues, Bundle> {
    private b$b() {
    }

    public final /* synthetic */ Object at(Object obj) {
        ContentValues contentValues = (ContentValues) obj;
        h Zp = ((a) g.h(a.class)).Zp();
        c a = b.a(contentValues);
        boolean b = (a == null || (a.xjy > 0 && Zp.a(a))) ? false : Zp.b(a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", b);
        return bundle;
    }
}
