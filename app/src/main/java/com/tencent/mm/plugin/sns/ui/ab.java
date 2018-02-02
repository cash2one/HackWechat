package com.tencent.mm.plugin.sns.ui;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.SysTextView;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class ab implements OnTouchListener {
    private static n run;
    private static TextView ruo;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        TextView textView = (TextView) view;
        textView.getTag();
        CharSequence text = textView.getText();
        Layout layout = textView.getLayout();
        if (layout == null && (textView instanceof SysTextView)) {
            layout = ((SysTextView) textView).gTP.Eh();
        }
        if (!(text instanceof Spannable) || r0 == null) {
            return false;
        }
        Layout Eh;
        Spannable spannable = (Spannable) text;
        int action = motionEvent.getAction();
        Layout layout2 = textView.getLayout();
        if (layout2 == null && (textView instanceof SysTextView)) {
            Eh = ((SysTextView) textView).gTP.Eh();
        } else {
            Eh = layout2;
        }
        textView.invalidate();
        if (action == 1 || action == 0 || action == 2) {
            int Ea;
            boolean z;
            action = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (textView instanceof PLSysTextView) {
                if (action >= ((PLSysTextView) textView).DZ()) {
                    if (action <= ((PLSysTextView) textView).DZ() + Eh.getWidth()) {
                        if (y >= ((PLSysTextView) textView).Ea()) {
                        }
                        return false;
                    }
                }
                return false;
            } else if (textView instanceof TextView) {
                if (action < textView.getTotalPaddingLeft() || action > Eh.getWidth() + textView.getTotalPaddingLeft()) {
                    return false;
                }
                if (y < textView.getTotalPaddingTop() || y > Eh.getHeight() + textView.getTotalPaddingTop()) {
                    return false;
                }
            }
            if (textView instanceof PLSysTextView) {
                action -= ((PLSysTextView) textView).DZ();
                Ea = y - ((PLSysTextView) textView).Ea();
            } else if (textView instanceof TextView) {
                action -= textView.getTotalPaddingLeft();
                Ea = y - textView.getTotalPaddingTop();
            } else {
                action -= textView.getPaddingLeft();
                Ea = y - textView.getPaddingTop();
            }
            Ea = Eh.getOffsetForHorizontal(Eh.getLineForVertical(Ea + textView.getScrollY()), (float) (action + textView.getScrollX()));
            int action2 = motionEvent.getAction();
            n[] nVarArr = (n[]) spannable.getSpans(Ea, Ea, n.class);
            Ea = nVarArr.length - 1;
            x.d("MicroMsg.MMOnTouchListener", " action span Len: " + nVarArr.length);
            textView.getLayout();
            if (nVarArr.length == 0) {
                bzE();
                z = false;
            } else if (action2 == 1) {
                nVarArr[Ea].onClick(textView);
                new af().postDelayed(new 1(this), 300);
                z = true;
            } else {
                if (action2 == 0 || action2 == 2 || action2 == 3) {
                    bzE();
                    run = nVarArr[Ea];
                    ruo = textView;
                    nVarArr[Ea].ozA = true;
                    textView.invalidate();
                    z = true;
                }
                z = false;
            }
            if (z) {
                return true;
            }
        }
        bzE();
        return false;
    }

    public static void bzE() {
        if (run != null) {
            run.ozA = false;
            ruo.invalidate();
            ruo = null;
            run = null;
        }
    }
}
