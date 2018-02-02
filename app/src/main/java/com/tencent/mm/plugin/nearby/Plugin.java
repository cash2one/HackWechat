package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    private b kAA = new b(this) {
        final /* synthetic */ Plugin oNU;

        {
            this.oNU = r1;
        }

        public final a Q(Context context, String str) {
            return new com.tencent.mm.plugin.nearby.ui.a(context);
        }
    };

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.kAA;
    }

    public ap createSubCore() {
        return new f();
    }
}
