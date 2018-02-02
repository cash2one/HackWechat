package com.tencent.xweb.xwalk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import org.xwalk.core.XWalkEnvironment;

class a$22 implements TextWatcher {
    final /* synthetic */ EditText AsE;
    final /* synthetic */ a Asx;

    a$22(a aVar, EditText editText) {
        this.Asx = aVar;
        this.AsE = editText;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int i = 0;
        try {
            i = Integer.parseInt(this.AsE.getText().toString());
        } catch (Exception e) {
        }
        XWalkEnvironment.setGrayValueForTest(i);
    }
}
