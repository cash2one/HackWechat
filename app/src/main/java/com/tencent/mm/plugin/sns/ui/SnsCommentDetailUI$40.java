package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$40 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$40(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + str);
        Intent intent = new Intent();
        m e = SnsCommentDetailUI.e(this.rAr);
        if (e.xl(32)) {
            k cVar = new c(e.byz(), 1, 2, "", e.byD(), e.bxW());
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_Scene", 37);
            a.ifs.d(intent, this.rAr);
            return;
        }
        intent.putExtra("Contact_User", str);
        a.ifs.d(intent, this.rAr);
    }
}
