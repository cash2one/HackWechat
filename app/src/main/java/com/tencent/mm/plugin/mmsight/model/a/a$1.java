package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.b.a;

class a$1 implements a {
    final /* synthetic */ a otJ;

    a$1(a aVar) {
        this.otJ = aVar;
    }

    public final void a(final b bVar) {
        a.a(this.otJ).post(new Runnable(this) {
            final /* synthetic */ a$1 otL;

            public final void run() {
                a.a(this.otL.otJ, bVar);
            }
        });
    }
}
