package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.z.ap;

public class Plugin implements c {
    private b kAA = new b(this) {
        final /* synthetic */ Plugin omL;

        {
            this.omL = r1;
        }

        public final a Q(Context context, String str) {
            return new com.tencent.mm.plugin.masssend.ui.a(context);
        }
    };

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.kAA;
    }

    public ap createSubCore() {
        return new h();
    }
}
