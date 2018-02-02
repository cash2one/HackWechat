package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;

public final class i extends ArrowKeyMovementMethod {
    private static i tVF;

    public static i bXx() {
        if (tVF == null) {
            tVF = new i();
        }
        return tVF;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
            int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            scrollY = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            k[] kVarArr = (k[]) spannable.getSpans(scrollY, scrollY + 1, k.class);
            if (scrollX < b.bWo() && kVarArr.length != 0 && action == 0) {
                kVarArr[0].a(textView, spannable, motionEvent, kVarArr[0]);
            }
        }
        return false;
    }
}
