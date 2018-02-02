package com.tencent.mm.vending.g;

import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;
import com.tencent.mm.vending.j.f;
import java.util.Stack;

public final class g {
    private static final a zCN = new a();

    public static final c<Void> czW() {
        return new e().u(new Object[0]);
    }

    public static final <Var1> c<Var1> cp(Var1 var1) {
        return new e().u(var1);
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> t(Var1 var1, Var2 var2) {
        return new e().u(var1, var2);
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> a(Var1 var1, Var2 var2, Var3 var3) {
        return new e().u(var1, var2, var3);
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        return new e().u(var1, var2, var3, var4);
    }

    public static final <Var1, Var2, Var3, Var4, Var5> c<f<Var1, Var2, Var3, Var4, Var5>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        return new e().u(var1, var2, var3, var4, var5);
    }

    public static <$1> b<$1> cq($1 $1) {
        b bVar = new b();
        return a.cr($1);
    }

    public static <$1, $2> c<$1, $2> u($1 $1, $2 $2) {
        c cVar = new c();
        return a.v($1, $2);
    }

    public static final b czQ() {
        f czV = f.czV();
        Stack stack = (Stack) czV.zCM.get();
        c cVar = stack == null ? null : stack.size() == 0 ? null : (c) ((Stack) czV.zCM.get()).peek();
        return cVar != null ? cVar.czQ() : zCN;
    }

    public static final b czX() {
        b czQ = czQ();
        if (czQ != null) {
            czQ.czP();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        return czQ;
    }

    public static final void a(b bVar, Object... objArr) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else if (objArr.length > 0) {
            bVar.t(objArr);
        } else {
            bVar.resume();
        }
    }

    public static final void a(b bVar) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else {
            bVar.cl(null);
        }
    }

    public static final <_Var> void a(d<_Var> dVar) {
        final b czX = czX();
        dVar.a(new d.b<_Var>() {
            public final void aB(_Var _Var) {
                g.a(czX, _Var);
            }
        }).a(new d.a() {
            public final void aW(Object obj) {
                czX.cl(obj);
            }
        });
    }
}
