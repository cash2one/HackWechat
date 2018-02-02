package com.tencent.mm.q;

import com.tencent.mm.q.b.d;
import com.tencent.mm.q.b.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;

class b$1 implements b {
    final /* synthetic */ b gJn;

    b$1(b bVar) {
        this.gJn = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (b.Ba()) {
            obj = (obj == null || !(obj instanceof String)) ? null : (String) obj;
            switch (i) {
                case 2:
                    if (obj != null) {
                        this.gJn.gJk.a(65636, new f(this.gJn, obj));
                        return;
                    }
                    return;
                case 5:
                    if (obj == null) {
                        this.gJn.gJk.a(65636, new b$c(this.gJn));
                        return;
                    } else {
                        this.gJn.gJk.a(65636, new d(this.gJn, obj));
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
