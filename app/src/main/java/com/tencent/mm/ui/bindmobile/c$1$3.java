package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.bindmobile.c.1;

class c$1$3 implements a {
    final /* synthetic */ b yms;
    final /* synthetic */ 1 ymy;

    c$1$3(1 1, b bVar) {
        this.ymy = 1;
        this.yms = bVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == 1 && i == -1) {
            ((MobileFriendUI) c.d(this.ymy.ymx)).b(this.yms);
        }
    }
}
