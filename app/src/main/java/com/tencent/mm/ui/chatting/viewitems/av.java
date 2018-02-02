package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.ui.base.a.a;

final class av extends LinkMovementMethod {
    private a yOT;

    av() {
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.yOT = a(textView, spannable, motionEvent);
            if (this.yOT != null) {
                this.yOT.lo(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.yOT), spannable.getSpanEnd(this.yOT));
            }
        } else if (motionEvent.getAction() == 2) {
            a a = a(textView, spannable, motionEvent);
            if (!(this.yOT == null || a == this.yOT)) {
                this.yOT.lo(false);
                this.yOT = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.yOT != null) {
                this.yOT.lo(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.yOT = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }

    private static a a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        a[] aVarArr = (a[]) spannable.getSpans(x, x, a.class);
        if (aVarArr.length > 0) {
            return aVarArr[0];
        }
        return null;
    }
}
