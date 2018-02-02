package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.j;

public class MMVisiblePasswordEditText extends EditText {
    public String kbH = "";
    final Drawable yeS = getResources().getDrawable(j.gYq);
    final Drawable yeT = getResources().getDrawable(j.gYr);
    private boolean yeU = false;

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        coW();
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        coW();
    }

    private void coW() {
        this.yeS.setBounds(0, 0, this.yeS.getIntrinsicWidth(), this.yeS.getIntrinsicHeight());
        this.yeT.setBounds(0, 0, this.yeT.getIntrinsicWidth(), this.yeT.getIntrinsicHeight());
        x.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[]{Integer.valueOf(this.yeS.getIntrinsicWidth()), Integer.valueOf(this.yeS.getIntrinsicHeight())});
        cpO();
        setHeight(this.yeS.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.bvL) * 5));
        setOnTouchListener(new 1(this));
    }

    private void cpO() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.yeU) {
            setInputType(1);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yeT, getCompoundDrawables()[3]);
        } else {
            setInputType(129);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yeS, getCompoundDrawables()[3]);
        }
        setSelection(selectionStart, selectionEnd);
    }
}
