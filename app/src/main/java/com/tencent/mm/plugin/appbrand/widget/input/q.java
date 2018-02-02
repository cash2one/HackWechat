package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.plugin.appbrand.widget.input.af.b;

final class q extends p {
    public q(Context context) {
        super(context);
        super.setKeyListener(new 1(this));
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
        while (i < inputFilterArr.length) {
            inputFilterArr2[i] = inputFilterArr[i];
            i++;
        }
        inputFilterArr2[i] = new AllCaps();
        super.setFilters(inputFilterArr2);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public final void dv(boolean z) {
        anf();
        int inputType = getInputType() | 2;
        if (z) {
            inputType |= 16;
        } else {
            inputType &= -17;
        }
        setInputType(inputType);
        super.dv(z);
        ang();
    }

    public final View getInputPanel() {
        return t.bW(this);
    }

    public final void amM() {
        t.bW(this).setInputEditText(this);
        b.c(this);
    }
}
