package com.tencent.mm.plugin.game.model;

import com.tencent.mm.aq.a.c.c;
import com.tencent.mm.plugin.game.model.as.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class as$3 implements c {
    final /* synthetic */ String lwH;
    final /* synthetic */ List ney;
    final /* synthetic */ b nez;

    as$3(String str, List list, b bVar) {
        this.lwH = str;
        this.ney = list;
        this.nez = bVar;
    }

    public final void a(boolean z, Object... objArr) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[]{Boolean.valueOf(z), this.lwH});
        as.b(this.ney, this.nez);
    }
}
