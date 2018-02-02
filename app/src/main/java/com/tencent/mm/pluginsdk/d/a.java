package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.g.a.jd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a extends c<jd> {
    protected ArrayList<String> vcO;

    public abstract void j(b bVar);

    public a() {
        this.vcO = new ArrayList(3);
        this.xen = jd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jd jdVar = (jd) bVar;
        if ((jdVar instanceof jd) && jdVar.fzH.fzI != null && this.vcO.contains(jdVar.fzH.fzI.getClass().getName())) {
            j(jdVar.fzH.fzI);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.vcO.contains(str)) {
            aVar.vcO.add(str);
        }
        com.tencent.mm.sdk.b.a.xef.b(aVar);
        e.Rm(str);
    }

    public static void b(String str, a aVar) {
        e.Rn(str);
        com.tencent.mm.sdk.b.a.xef.c(aVar);
        if (aVar.vcO.contains(str)) {
            aVar.vcO.remove(str);
        }
    }
}
