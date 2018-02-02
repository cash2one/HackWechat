package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class MMRadioGroupView$b implements OnHierarchyChangeListener {
    private OnHierarchyChangeListener hz;
    final /* synthetic */ MMRadioGroupView ydc;

    private MMRadioGroupView$b(MMRadioGroupView mMRadioGroupView) {
        this.ydc = mMRadioGroupView;
    }

    public final void onChildViewAdded(View view, View view2) {
        if (view == this.ydc && (view2 instanceof MMRadioImageButton)) {
            if (view2.getId() == -1) {
                int hashCode = view2.hashCode();
                if (hashCode < 0) {
                    hashCode &= Integer.MAX_VALUE;
                }
                view2.setId(hashCode);
            }
            ((MMRadioImageButton) view2).ydh = MMRadioGroupView.b(this.ydc);
        }
        if (this.hz != null) {
            this.hz.onChildViewAdded(view, view2);
        }
    }

    public final void onChildViewRemoved(View view, View view2) {
        if (view == this.ydc && (view2 instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) view2).ydh = null;
        }
        if (this.hz != null) {
            this.hz.onChildViewRemoved(view, view2);
        }
    }
}
