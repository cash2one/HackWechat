package com.tencent.mm.ui.widget.celltextview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class CellTextView$a extends SimpleOnGestureListener {
    final /* synthetic */ CellTextView zwY;

    private CellTextView$a(CellTextView cellTextView) {
        this.zwY = cellTextView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (CellTextView.a(this.zwY) != null) {
            CellTextView.a(this.zwY);
        }
        return true;
    }
}
