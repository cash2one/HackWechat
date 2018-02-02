package com.tencent.mm.ui.tools;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.k;

class MMTextInputUI$4 implements TextWatcher {
    final /* synthetic */ MMTextInputUI zlE;

    MMTextInputUI$4(MMTextInputUI mMTextInputUI) {
        this.zlE = mMTextInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = false;
        String obj = editable.toString();
        if (!MMTextInputUI.c(this.zlE)) {
            if (obj.trim().length() > 0) {
                this.zlE.enableOptionMenu(true);
            } else {
                this.zlE.enableOptionMenu(false);
            }
        }
        if (MMTextInputUI.d(this.zlE) > 0) {
            MMTextInputUI.a(this.zlE, 0);
            for (int i = 0; i < obj.length(); i++) {
                if (bh.n(obj.charAt(i))) {
                    MMTextInputUI.a(this.zlE, MMTextInputUI.e(this.zlE) + 2);
                } else {
                    MMTextInputUI.a(this.zlE, MMTextInputUI.e(this.zlE) + 1);
                }
            }
            if (MMTextInputUI.e(this.zlE) >= MMTextInputUI.f(this.zlE) && MMTextInputUI.e(this.zlE) <= MMTextInputUI.d(this.zlE)) {
                this.zlE.enableOptionMenu(true);
                MMTextInputUI.g(this.zlE).setVisibility(0);
                MMTextInputUI.g(this.zlE).setTextColor(this.zlE.getResources().getColor(d.gUF));
                MMTextInputUI.g(this.zlE).setText(this.zlE.getString(k.gUF, new Object[]{Integer.valueOf((MMTextInputUI.d(this.zlE) - MMTextInputUI.e(this.zlE)) >> 1)}));
            } else if (MMTextInputUI.e(this.zlE) > MMTextInputUI.d(this.zlE)) {
                this.zlE.enableOptionMenu(false);
                MMTextInputUI.g(this.zlE).setVisibility(0);
                MMTextInputUI.g(this.zlE).setTextColor(this.zlE.getResources().getColor(d.gUG));
                MMTextInputUI.g(this.zlE).setText(this.zlE.getString(k.gYJ, new Object[]{Integer.valueOf(((MMTextInputUI.e(this.zlE) - MMTextInputUI.d(this.zlE)) >> 1) + 1)}));
            } else {
                MMTextInputUI mMTextInputUI = this.zlE;
                if (MMTextInputUI.c(this.zlE)) {
                    z = true;
                } else if (MMTextInputUI.e(this.zlE) > 0) {
                    z = true;
                }
                mMTextInputUI.enableOptionMenu(z);
                MMTextInputUI.g(this.zlE).setVisibility(8);
            }
        }
    }
}
