package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public class f implements ap {
    private static HashMap<Integer, d> neK;
    private d pRh;
    private c pRi = new 2(this);
    private c pRj = new 3(this);
    private c pRk = new 4(this);
    private c pRl = new 5(this);

    private static f bor() {
        ar.Ha();
        f fVar = (f) bp.hY(f.class.getName());
        if (fVar != null) {
            return fVar;
        }
        Object fVar2 = new f();
        ar.Ha().a(f.class.getName(), fVar2);
        return fVar2;
    }

    public static d bos() {
        g.Dh().Ct();
        if (bor().pRh == null) {
            f bor = bor();
            ar.Hg();
            bor.pRh = new d(com.tencent.mm.z.c.EV());
        }
        return bor().pRh;
    }

    static {
        HashMap hashMap = new HashMap();
        neK = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        return neK;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        a.xef.b(this.pRi);
        a.xef.b(this.pRj);
        a.xef.b(this.pRk);
        a.xef.b(this.pRl);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        a.xef.c(this.pRi);
        a.xef.c(this.pRj);
        a.xef.c(this.pRk);
        a.xef.c(this.pRl);
    }
}
