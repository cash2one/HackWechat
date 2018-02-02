package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingUI$4 implements OnClickListener {
    final /* synthetic */ CleanChattingUI lhQ;

    CleanChattingUI$4(CleanChattingUI cleanChattingUI) {
        this.lhQ = cleanChattingUI;
    }

    public final void onClick(View view) {
        a b = CleanChattingUI.b(this.lhQ);
        if (b.kmb.size() == b.getCount()) {
            b.kmb.clear();
        } else {
            for (int i = 0; i < b.getCount(); i++) {
                b.kmb.add(Integer.valueOf(i));
            }
        }
        b.notifyDataSetChanged();
        b.lhG.a(b.kmb);
    }
}
