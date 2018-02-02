package com.tencent.mm.aq.a.a;

import android.content.Context;
import com.tencent.mm.aq.a.b.c;
import com.tencent.mm.aq.a.b.d;
import com.tencent.mm.aq.a.c.a;
import com.tencent.mm.aq.a.c.b;
import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.aq.a.c.f;
import com.tencent.mm.aq.a.c.h;
import com.tencent.mm.aq.a.c.j;
import com.tencent.mm.aq.a.c.k;
import com.tencent.mm.aq.a.c.m;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b$a {
    Context context;
    int hDl = b.hDj;
    int hDm = 5;
    c hDn = null;
    public m hDo = null;
    a hDp = null;
    public b hDq = null;
    f hDr = null;
    j hDs = null;
    e hDu = null;
    h hDv = null;
    Executor hDw;
    k hDx = null;

    public b$a(Context context) {
        this.context = context.getApplicationContext();
    }

    public final b PJ() {
        if (this.hDn == null) {
            this.hDn = new c$a().PK();
        }
        if (this.hDo == null) {
            this.hDo = new com.tencent.mm.aq.a.b.f();
        }
        if (this.hDp == null) {
            this.hDp = new com.tencent.mm.aq.a.b.a();
        }
        if (this.hDq == null) {
            this.hDq = new com.tencent.mm.aq.a.b.b();
        }
        if (this.hDr == null) {
            this.hDr = new d();
        }
        if (this.hDs == null) {
            this.hDs = new com.tencent.mm.aq.a.b.h();
        }
        if (this.hDv == null) {
            this.hDv = a.bb(this.hDl, this.hDm);
        }
        if (this.hDw == null) {
            this.hDw = Executors.newSingleThreadExecutor();
        }
        if (this.hDx == null) {
            this.hDx = new com.tencent.mm.aq.a.b.e();
        }
        if (this.hDu == null) {
            this.hDu = new c();
        }
        return new b(this);
    }
}
