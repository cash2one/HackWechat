package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.b;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;

public class MMAutoSwitchEditText$a implements TextWatcher, OnKeyListener {
    private String jUJ;
    private EditText kT;
    int mIndex = 0;
    b xZA;
    d xZB;
    int xZC = 4;
    MMAutoSwitchEditText$c xZz;

    public MMAutoSwitchEditText$a(EditText editText) {
        this.kT = editText;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int i = 0;
        this.jUJ = editable.toString();
        Object obj = "";
        if (this.xZB != null) {
            this.xZB.coU();
        }
        int i2 = 0;
        while (i < this.jUJ.length()) {
            i2++;
            if (i2 > this.xZC) {
                break;
            }
            obj = obj + this.jUJ.charAt(i);
            i++;
        }
        if (i2 > this.xZC) {
            this.kT.setText(obj);
            this.kT.setSelection(obj.length());
        }
        if (i2 >= this.xZC && this.xZz != null) {
            this.xZz.EF(this.mIndex);
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67 && this.kT.getText().toString().trim().length() == 0 && this.xZA != null) {
            this.xZA.EE(this.mIndex);
        }
        return false;
    }
}
