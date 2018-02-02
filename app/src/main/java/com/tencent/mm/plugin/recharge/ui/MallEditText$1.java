package com.tencent.mm.plugin.recharge.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MallEditText$1 implements TextWatcher {
    final /* synthetic */ MallEditText pCy;

    MallEditText$1(MallEditText mallEditText) {
        this.pCy = mallEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        int selectionStart = MallEditText.a(this.pCy).getSelectionStart();
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
            if (length > MallEditText.b(this.pCy)) {
                if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                    selectionStart++;
                } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                    selectionStart += i3;
                }
            } else if (length < MallEditText.b(this.pCy) && (selectionStart == 4 || selectionStart == 9)) {
                selectionStart--;
            }
            MallEditText.a(this.pCy, length);
        }
        String str2 = str;
        int i4 = selectionStart;
        String str3 = str2;
        if (charSequence2.equals(str3)) {
            MallEditText.c(this.pCy);
            return;
        }
        MallEditText.a(this.pCy).setText(str3);
        if (i4 < MallEditText.b(this.pCy)) {
            MallEditText.a(this.pCy).setSelection(i4);
        } else {
            MallEditText.a(this.pCy).setSelection(MallEditText.b(this.pCy));
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
