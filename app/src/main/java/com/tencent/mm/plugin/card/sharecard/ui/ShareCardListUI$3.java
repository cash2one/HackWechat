package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.report.service.g;

class ShareCardListUI$3 implements OnClickListener {
    final /* synthetic */ ShareCardListUI kPj;

    ShareCardListUI$3(ShareCardListUI shareCardListUI) {
        this.kPj = shareCardListUI;
    }

    public final void onClick(View view) {
        ShareCardListUI.c(this.kPj);
        if (b.auW()) {
            ShareCardListUI.c(this.kPj);
            if (b.auV()) {
                ShareCardListUI.a(this.kPj, 2);
                g.pQN.h(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
                am.auF().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.kPj)));
                ShareCardListUI.e(this.kPj);
                ShareCardListUI.f(this.kPj).au();
                ShareCardListUI.c(this.kPj);
                b.kMY = true;
            }
        }
        ShareCardListUI.c(this.kPj);
        if (b.auV()) {
            ShareCardListUI.a(this.kPj, 3);
        }
        g.pQN.h(11582, new Object[]{"OperChangeOtherCity ", Integer.valueOf(0), Integer.valueOf(0), "", "", ""});
        am.auF().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.d(this.kPj)));
        ShareCardListUI.e(this.kPj);
        ShareCardListUI.f(this.kPj).au();
        ShareCardListUI.c(this.kPj);
        b.kMY = true;
    }
}
