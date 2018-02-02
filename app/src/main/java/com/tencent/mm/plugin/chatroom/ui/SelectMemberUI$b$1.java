package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.a;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b.3;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.c;
import java.util.Collections;
import java.util.List;

class SelectMemberUI$b$1 implements Runnable {
    final /* synthetic */ b ldU;

    SelectMemberUI$b$1(b bVar) {
        this.ldU = bVar;
    }

    public final void run() {
        b.a(this.ldU, true);
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.ldU;
        List Ms = b.a(this.ldU).Ms();
        if (Ms != null) {
            bVar.fAN.clear();
            for (int i = 0; i < Ms.size(); i++) {
                af WO = c.EY().WO((String) Ms.get(i));
                boolean equals = WO.field_username.equals(bVar.ldj);
                if (!equals || SelectMemberUI.h(bVar.ldP)) {
                    if (equals && SelectMemberUI.h(bVar.ldP)) {
                        bVar.fAN.add(0, new a(bVar.ldP, WO));
                    } else {
                        bVar.fAN.add(new a(bVar.ldP, WO));
                    }
                }
            }
            Collections.sort(bVar.fAN, new 3(bVar));
            bVar.ldk = bVar.fAN;
        }
        b.b(this.ldU);
        x.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ag.y(new Runnable(this) {
            final /* synthetic */ SelectMemberUI$b$1 ldV;

            {
                this.ldV = r1;
            }

            public final void run() {
                b.a(this.ldV.ldU, false);
                SelectMemberUI.f(this.ldV.ldU.ldP).setVisibility(8);
                this.ldV.ldU.notifyDataSetChanged();
            }
        });
    }
}
