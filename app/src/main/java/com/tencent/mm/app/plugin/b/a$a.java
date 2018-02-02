package com.tencent.mm.app.plugin.b;

import com.tencent.mm.app.plugin.b.a.f;
import com.tencent.mm.app.plugin.b.a.g;
import com.tencent.mm.app.plugin.b.a.h;
import com.tencent.mm.app.plugin.b.a.i;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class a$a extends c<eq> {
    a$e fhA;
    f fhB;
    a$d fhC;
    h fhD;
    g fhE;
    a.c fhF;
    a$b fhG;
    i fhz;

    public a$a() {
        this.xen = eq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        eq eqVar = (eq) bVar;
        if (eqVar.fth.op == 1) {
            x.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
            this.fhz = new i();
            this.fhA = new a$e();
            this.fhB = new f();
            this.fhC = new a$d();
            this.fhD = new h();
            this.fhE = new g();
            this.fhF = new a.c();
            this.fhG = new a$b();
            a.xef.b(this.fhz);
            a.xef.b(this.fhA);
            a.xef.b(this.fhB);
            a.xef.b(this.fhC);
            a.xef.b(this.fhD);
            a.xef.b(this.fhE);
            a.xef.b(this.fhF);
            a.xef.b(this.fhG);
        } else if (eqVar.fth.op == 2) {
            if (this.fhz != null) {
                a.xef.c(this.fhz);
            }
            if (this.fhA != null) {
                a.xef.c(this.fhA);
            }
            if (this.fhB != null) {
                a.xef.c(this.fhB);
            }
            if (this.fhC != null) {
                a.xef.c(this.fhC);
            }
            if (this.fhD != null) {
                a.xef.c(this.fhD);
            }
            if (this.fhE != null) {
                a.xef.c(this.fhE);
            }
            if (this.fhF != null) {
                a.xef.c(this.fhF);
            }
            if (this.fhG != null) {
                a.xef.c(this.fhG);
            }
        }
        return true;
    }
}
