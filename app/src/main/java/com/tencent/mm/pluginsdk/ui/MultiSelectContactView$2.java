package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class MultiSelectContactView$2 implements OnKeyListener {
    final /* synthetic */ MultiSelectContactView vkE;

    MultiSelectContactView$2(MultiSelectContactView multiSelectContactView) {
        this.vkE = multiSelectContactView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.c(this.vkE).getSelectionStart() == 0 && MultiSelectContactView.c(this.vkE).getSelectionEnd() == 0) {
            MultiSelectContactView.d(this.vkE);
        }
        return false;
    }
}
