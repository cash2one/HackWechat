package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.a;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.c;

class SeeAccessVerifyInfoUI$b$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ b lcU;

    SeeAccessVerifyInfoUI$b$1(b bVar, int i) {
        this.lcU = bVar;
        this.kI = i;
    }

    public final void onClick(View view) {
        String AQ;
        String str = ((a) this.lcU.kFz.get(this.kI)).fpL;
        String str2 = null;
        if (SeeAccessVerifyInfoUI.c(this.lcU.lcQ) != null) {
            str2 = SeeAccessVerifyInfoUI.c(this.lcU.lcQ).gu(((a) this.lcU.kFz.get(this.kI)).username);
        }
        if (bh.ov(str2)) {
            SeeAccessVerifyInfoUI.b(this.lcU.lcQ);
            AQ = c.EY().WO(bh.ou(((a) this.lcU.kFz.get(this.kI)).username)).AQ();
        } else {
            AQ = str2;
        }
        SeeAccessVerifyInfoUI.a(this.lcU.lcQ, ((a) this.lcU.kFz.get(this.kI)).username, AQ, str, true);
    }
}
