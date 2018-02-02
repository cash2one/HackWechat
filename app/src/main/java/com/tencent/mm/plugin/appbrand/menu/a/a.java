package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.ui.base.n;

public abstract class a {
    public int jAX;

    public abstract void a(Context context, p pVar, n nVar, String str);

    public abstract void a(Context context, p pVar, String str, l lVar);

    public a(int i) {
        this.jAX = i;
    }
}
