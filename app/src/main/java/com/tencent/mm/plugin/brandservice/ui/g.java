package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g extends a {
    private static b kFf;

    public g(Object obj) {
        super(0, obj);
        this.yjT = true;
    }

    public final b asm() {
        if (kFf == null) {
            kFf = new 1(this);
        }
        return kFf;
    }

    public final a.a asn() {
        return new a();
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
    }
}
