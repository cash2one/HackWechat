package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMRadioImageButton.a;

class MMRadioGroupView$a implements a {
    final /* synthetic */ MMRadioGroupView ydc;

    MMRadioGroupView$a(MMRadioGroupView mMRadioGroupView) {
        this.ydc = mMRadioGroupView;
    }

    public final void a(MMRadioImageButton mMRadioImageButton) {
        if (MMRadioGroupView.a(this.ydc) != -1) {
            MMRadioGroupView.a(this.ydc, MMRadioGroupView.a(this.ydc));
        }
        int id = mMRadioImageButton.getId();
        MMRadioGroupView.a(this.ydc, mMRadioImageButton);
        MMRadioGroupView.b(this.ydc, id);
    }

    public final void b(MMRadioImageButton mMRadioImageButton) {
        MMRadioGroupView.c(this.ydc, mMRadioImageButton.getId());
    }
}
