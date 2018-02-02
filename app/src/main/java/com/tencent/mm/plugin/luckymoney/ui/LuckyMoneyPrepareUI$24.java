package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.ui.a.a.a;

class LuckyMoneyPrepareUI$24 implements OnClickListener {
    final /* synthetic */ SpannableString ofK;
    final /* synthetic */ LuckyMoneyPrepareUI ojC;
    final /* synthetic */ g ojI;
    final /* synthetic */ g ojJ;

    LuckyMoneyPrepareUI$24(LuckyMoneyPrepareUI luckyMoneyPrepareUI, SpannableString spannableString, g gVar, g gVar2) {
        this.ojC = luckyMoneyPrepareUI;
        this.ofK = spannableString;
        this.ojI = gVar;
        this.ojJ = gVar2;
    }

    public final void onClick(View view) {
        if (!a.cnI().cnH()) {
            return;
        }
        if (LuckyMoneyPrepareUI.e(this.ojC).getText().toString().equals(this.ofK.toString())) {
            this.ojI.onClick(view);
        } else {
            this.ojJ.onClick(view);
        }
    }
}
