package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class MMAutoSwitchEditText extends EditText {
    a xZy = new a(this);

    public interface b {
        void EE(int i);
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(this.xZy);
        setOnKeyListener(this.xZy);
    }
}
