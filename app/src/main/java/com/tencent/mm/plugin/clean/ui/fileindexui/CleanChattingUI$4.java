package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingUI$4 implements OnClickListener {
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$4(CleanChattingUI cleanChattingUI) {
        this.lgN = cleanChattingUI;
    }

    public final void onClick(View view) {
        a a = CleanChattingUI.a(this.lgN);
        if (a.kmb.size() == a.getCount()) {
            a.kmb.clear();
        } else {
            for (int i = 0; i < a.getCount(); i++) {
                a.kmb.add(Integer.valueOf(i));
            }
        }
        a.notifyDataSetChanged();
        a.lgk.a(a.kmb);
    }
}
