package com.tencent.mm.plugin.card.base;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.ui.base.h;

class CardBaseUI$6 implements o$a {
    final /* synthetic */ String gIT;
    final /* synthetic */ CardBaseUI kIn;
    final /* synthetic */ boolean kIq;

    CardBaseUI$6(CardBaseUI cardBaseUI, String str, boolean z) {
        this.kIn = cardBaseUI;
        this.gIT = str;
        this.kIq = z;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            CardBaseUI.c(this.kIn, this.gIT);
            h.bu(this.kIn, this.kIn.getResources().getString(R.l.dOo));
            if (this.kIq) {
                Context context = this.kIn;
                String str2 = this.gIT;
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", str2);
                a.ifs.e(intent, context);
            }
        }
    }
}
