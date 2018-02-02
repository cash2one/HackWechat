package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.permission.b.b;
import com.tencent.mm.plugin.appbrand.permission.c.a;

class c$4 implements b {
    final /* synthetic */ c jGI;
    final /* synthetic */ c.b jGJ;

    c$4(c cVar, c.b bVar) {
        this.jGI = cVar;
        this.jGJ = bVar;
    }

    public final void ajx() {
        if (this.jGJ != null) {
            this.jGJ.a(a.ajC());
        }
    }

    public final void ajy() {
        if (this.jGJ != null) {
            this.jGJ.a(a.ajD());
        }
    }

    public final void onCancel() {
        if (this.jGJ != null) {
            this.jGJ.a(a.ajE());
        }
    }
}
