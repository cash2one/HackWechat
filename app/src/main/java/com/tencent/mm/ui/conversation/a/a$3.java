package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.ay.o;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.a.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class a$3 implements a {
    final /* synthetic */ a zaq;

    a$3(a aVar) {
        this.zaq = aVar;
    }

    public final void fO(String str, String str2) {
        com.tencent.mm.pluginsdk.j.a.a.bZH();
        ar.Hg();
        c.EX().b(new o(2, str));
        x.d("MicroMsg.ADBanner", "jump to " + str2);
        q$a.vcy.a((Context) this.zaq.voC.get(), str2, true);
    }

    public final void OH(String str) {
        com.tencent.mm.pluginsdk.j.a.a.bZH();
        ar.Hg();
        c.EX().b(new o(3, str));
    }
}
