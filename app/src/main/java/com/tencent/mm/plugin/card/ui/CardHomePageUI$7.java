package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class CardHomePageUI$7 implements OnClickListener {
    final /* synthetic */ CardHomePageUI kTC;

    CardHomePageUI$7(CardHomePageUI cardHomePageUI) {
        this.kTC = cardHomePageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kTC, ShareCardListUI.class);
        intent.putExtra("key_layout_buff", CardHomePageUI.e(this.kTC));
        CardHomePageUI.f(this.kTC);
        this.kTC.startActivity(intent);
        l lVar = (l) am.auF().getValue("key_share_card_layout_data");
        if (lVar != null) {
            int i;
            int i2;
            int i3;
            int i4 = lVar.fHd ? 1 : 0;
            if (lVar.fHe) {
                i = 1;
            } else {
                i = 0;
            }
            if (lVar.kNr != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (TextUtils.isEmpty(lVar.kNs)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            g.pQN.h(13685, new Object[]{Integer.valueOf(2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            if (lVar.fHe) {
                CardHomePageUI.g(this.kTC);
                lVar.fHe = false;
            }
            if (lVar.fHd) {
                CardHomePageUI.g(this.kTC);
                lVar.fHd = false;
                lVar.kNr = null;
                lVar.kNs = "";
            }
        }
        ar.Hg();
        c.CU().a(a.xok, "");
        g.pQN.h(11324, new Object[]{"ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
