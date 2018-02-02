package com.tencent.mm.storage;

import com.tencent.mm.by.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.z.ba.b;

public abstract class e {
    public static j xmt;
    protected c xms;

    public abstract String Wq(String str);

    protected boolean a(au auVar, b bVar) {
        return true;
    }

    public e(c cVar) {
        this.xms = cVar;
    }

    public final h aZl() {
        return this.xms.aZl();
    }

    protected final void a(h hVar, String str) {
        this.xms.a(hVar, str);
    }

    protected final void a(c.b bVar) {
        this.xms.a(bVar);
    }

    protected final String EQ(String str) {
        return this.xms.EQ(str);
    }

    protected final void a(c.c cVar) {
        this.xms.a(cVar);
    }

    protected final void fA(String str, String str2) {
        this.xms.b(str, str2, null);
    }
}
