package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.recharge.ui.form.c.b;

class c$b$1 implements TextWatcher {
    private int pCx = 0;
    final /* synthetic */ b pEe;

    public c$b$1(b bVar) {
        this.pEe = bVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        int selectionStart = this.pEe.pEb.pEh.getSelectionStart();
        String str = "";
        if (charSequence2 != null) {
            StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
            int length = stringBuilder.length();
            if (length >= 4) {
                stringBuilder.insert(3, ' ');
            }
            if (length >= 8) {
                stringBuilder.insert(8, ' ');
            }
            str = stringBuilder.toString();
            length = str.length();
            if (length > this.pCx) {
                if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                    selectionStart++;
                } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                    selectionStart += i3;
                }
            } else if (length < this.pCx && (selectionStart == 4 || selectionStart == 9)) {
                selectionStart--;
            }
            this.pCx = length;
        }
        String str2 = str;
        int i4 = selectionStart;
        String str3 = str2;
        if (!charSequence2.equals(str3)) {
            this.pEe.pEb.pEh.setText(str3);
            if (i4 < this.pCx) {
                this.pEe.pEb.pEh.setSelection(i4);
            } else {
                this.pEe.pEb.pEh.setSelection(this.pCx);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
