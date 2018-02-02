package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

class MMNeatTextView$2 implements OnLongClickListener {
    final /* synthetic */ MMNeatTextView ztZ;

    MMNeatTextView$2(MMNeatTextView mMNeatTextView) {
        this.ztZ = mMNeatTextView;
    }

    public final boolean onLongClick(View view) {
        if (MMNeatTextView.ztU) {
            Toast.makeText(this.ztZ.getContext(), MMNeatTextView.aal(this.ztZ.mText.toString()), 1).show();
        }
        if (MMNeatTextView.a(this.ztZ) != null) {
            return MMNeatTextView.a(this.ztZ).onLongClick(view);
        }
        return false;
    }
}
