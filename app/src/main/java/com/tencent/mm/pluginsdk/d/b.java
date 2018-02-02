package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.g.a.ka;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b extends c<ka> {
    protected ArrayList<String> vcO;

    public abstract void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar);

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ka kaVar = (ka) bVar;
        if ((kaVar instanceof ka) && kaVar.fBm.fBn != null && this.vcO.contains(kaVar.fBm.fBn.getClass().getName())) {
            a(kaVar.fBm.errType, kaVar.fBm.errCode, kaVar.fBm.fnL, kaVar.fBm.fBn);
        }
        return false;
    }

    public b(int i) {
        super(0);
        this.vcO = new ArrayList(3);
        this.xen = ka.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.vcO.contains(str)) {
            bVar.vcO.add(str);
        }
        a.xef.b(bVar);
        e.Rm(str);
    }

    public static void b(String str, b bVar) {
        e.Rn(str);
        a.xef.c(bVar);
        if (bVar.vcO.contains(str)) {
            bVar.vcO.remove(str);
        }
    }
}
