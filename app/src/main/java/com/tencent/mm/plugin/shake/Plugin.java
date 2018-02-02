package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    private b qnn = new b(this) {
        final /* synthetic */ Plugin qno;

        {
            this.qno = r1;
        }

        public final a Q(Context context, String str) {
            return new com.tencent.mm.plugin.shake.ui.a(context);
        }
    };

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.qnn;
    }

    public ap createSubCore() {
        return new m();
    }
}
