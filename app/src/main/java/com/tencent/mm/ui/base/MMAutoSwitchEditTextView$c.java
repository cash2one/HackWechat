package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.b;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.c;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import java.util.Iterator;

class MMAutoSwitchEditTextView$c implements b, c, d {
    final /* synthetic */ MMAutoSwitchEditTextView xZJ;

    private MMAutoSwitchEditTextView$c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView) {
        this.xZJ = mMAutoSwitchEditTextView;
    }

    public final void EF(int i) {
        String str = "";
        Iterator it = MMAutoSwitchEditTextView.a(this.xZJ).iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bh.ov(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        if (bh.ov(str) || str.length() != MMAutoSwitchEditTextView.b(this.xZJ) * MMAutoSwitchEditTextView.c(this.xZJ)) {
            if (MMAutoSwitchEditTextView.e(this.xZJ) != null) {
                MMAutoSwitchEditTextView.e(this.xZJ).cnK();
            }
            if (MMAutoSwitchEditTextView.a(this.xZJ) != null && i < MMAutoSwitchEditTextView.a(this.xZJ).size() - 1) {
                mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.a(this.xZJ).get(i + 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
        } else if (MMAutoSwitchEditTextView.d(this.xZJ) != null) {
            MMAutoSwitchEditTextView.d(this.xZJ).Yt(str);
        }
    }

    public final void EE(int i) {
        if (MMAutoSwitchEditTextView.a(this.xZJ) != null && i < MMAutoSwitchEditTextView.a(this.xZJ).size() && i != 0) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.a(this.xZJ).get(i - 1);
            if (mMAutoSwitchEditText != null) {
                mMAutoSwitchEditText.requestFocus();
            }
        }
    }

    public final void coU() {
        String str = "";
        Iterator it = MMAutoSwitchEditTextView.a(this.xZJ).iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bh.ov(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        if (MMAutoSwitchEditTextView.e(this.xZJ) != null) {
            MMAutoSwitchEditTextView.e(this.xZJ).cnK();
        }
    }
}
