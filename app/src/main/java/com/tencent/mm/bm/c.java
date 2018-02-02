package com.tencent.mm.bm;

import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;

public final class c {
    public static n vzM;
    public static m vzN;

    public static void Tb(String str) {
        if (((h) g.Dg().CN()).DS()) {
            d.a(str, vzM, vzN);
        }
    }

    public static void b(final String str, final p pVar) {
        new a() {
            public final void execute(com.tencent.mm.kernel.b.g gVar) {
                String str = str;
                p pVar = pVar;
                d.a(str, c.vzM, c.vzN);
                if (pVar == null) {
                    pVar = new p(c.Tc(str));
                }
                p.a("plugin." + str, pVar);
            }
        }.alone();
    }

    public static p.a Tc(final String str) {
        x.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new p.a() {
            public final ap createSubCore() {
                return d.Te(str);
            }
        }, str);
        return /* anonymous class already generated */;
    }
}
