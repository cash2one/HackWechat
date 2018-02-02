package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class CardHomePageUI$6 implements OnClickListener {
    final /* synthetic */ CardHomePageUI kTC;

    CardHomePageUI$6(CardHomePageUI cardHomePageUI) {
        this.kTC = cardHomePageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kTC, CardIndexUI.class);
        intent.putExtra("key_card_type", 1);
        this.kTC.startActivity(intent);
        g.pQN.h(11324, "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
    }
}
