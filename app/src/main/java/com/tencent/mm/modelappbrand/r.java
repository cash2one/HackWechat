package com.tencent.mm.modelappbrand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r implements q {
    private f hjH;
    protected Map<String, i> hjI = new HashMap();

    public r(f fVar) {
        this.hjH = fVar;
    }

    public r(q qVar) {
        if (qVar != null) {
            this.hjH = qVar.Jg();
            a(qVar);
        }
    }

    private void a(q qVar) {
        for (i a : qVar.Jh()) {
            a(a);
        }
    }

    public final f Jg() {
        return this.hjH;
    }

    public final <T> T iy(String str) {
        return this.hjI.get(str);
    }

    public final void a(i iVar) {
        this.hjI.put(iVar.getName(), iVar);
    }

    public final List<i> Jh() {
        return new ArrayList(this.hjI.values());
    }
}
