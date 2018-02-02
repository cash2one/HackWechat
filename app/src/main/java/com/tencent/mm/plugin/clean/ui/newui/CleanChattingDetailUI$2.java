package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingDetailUI$2 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI lhN;

    CleanChattingDetailUI$2(CleanChattingDetailUI cleanChattingDetailUI) {
        this.lhN = cleanChattingDetailUI;
    }

    public final void onClick(View view) {
        b a = CleanChattingDetailUI.a(this.lhN);
        if (a.kmb.size() == a.jMd.size()) {
            a.kmb.clear();
        } else {
            for (int i = 0; i < a.jMd.size(); i++) {
                a.kmb.add(Integer.valueOf(i));
            }
        }
        a.ayz();
        CleanChattingDetailUI.a(this.lhN).notifyDataSetChanged();
    }
}
