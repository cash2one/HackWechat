package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class CardAcceptCardListUI$3 implements OnClickListener {
    final /* synthetic */ CardAcceptCardListUI kQf;

    CardAcceptCardListUI$3(CardAcceptCardListUI cardAcceptCardListUI) {
        this.kQf = cardAcceptCardListUI;
    }

    public final void onClick(View view) {
        if (CardAcceptCardListUI.a(this.kQf)) {
            CardAcceptCardListUI.a(this.kQf, CardAcceptCardListUI.b(this.kQf));
            return;
        }
        CardAcceptCardListUI cardAcceptCardListUI = this.kQf;
        LinkedList b = CardAcceptCardListUI.b(this.kQf);
        cardAcceptCardListUI.dY(true);
        ar.CG().a(new p(b, cardAcceptCardListUI.fGW, cardAcceptCardListUI.kQa, cardAcceptCardListUI.kQb, cardAcceptCardListUI.kPZ), 0);
    }
}
