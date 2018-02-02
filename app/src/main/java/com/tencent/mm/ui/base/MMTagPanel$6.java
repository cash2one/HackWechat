package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$6 implements OnClickListener {
    final /* synthetic */ MMTagPanel ydR;

    MMTagPanel$6(MMTagPanel mMTagPanel) {
        this.ydR = mMTagPanel;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[]{Boolean.valueOf(MMTagPanel.f(this.ydR))});
        if (MMTagPanel.f(this.ydR)) {
            this.ydR.cpJ();
            MMTagPanel.a(this.ydR).requestFocus();
            MMTagPanel.a(this.ydR).setSelection(MMTagPanel.a(this.ydR).getText().length());
            ((InputMethodManager) this.ydR.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(this.ydR), 0);
            x.d("MicroMsg.MMTagPanel", "on content click");
            if (MMTagPanel.e(this.ydR) != null) {
                MMTagPanel.e(this.ydR).aDz();
            }
        }
    }
}
