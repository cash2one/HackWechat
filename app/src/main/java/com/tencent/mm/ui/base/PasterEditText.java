package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText extends EditText {
    private Context context;
    private ClipboardManager rBx = null;
    private int rBy = 0;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int bAS() {
        return this.rBy;
    }

    private void init() {
        this.rBx = (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        if (!(this.rBx == null || this.rBx.getText() == null || !(this.rBx.getText() instanceof String) || this.rBx.getText() == null || this.rBx.getText().length() <= 0)) {
            this.rBy += this.rBx.getText().length();
        }
        return super.onTextContextMenuItem(i);
    }
}
