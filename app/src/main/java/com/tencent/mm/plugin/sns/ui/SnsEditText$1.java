package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class SnsEditText$1 implements TextWatcher {
    final /* synthetic */ SnsEditText rBC;

    SnsEditText$1(SnsEditText snsEditText) {
        this.rBC = snsEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SnsEditText.a(this.rBC, charSequence.length());
        if (i2 <= 0) {
            try {
                if (SnsEditText.a(this.rBC) > SnsEditText.b(this.rBC) && i3 > 30) {
                    String substring = charSequence.toString().substring(i, i + i3);
                    if ((substring.indexOf("\n") >= 0 && i3 > 30) || i3 > 100) {
                        SnsEditText.b(this.rBC, SnsEditText.c(this.rBC) + substring.length());
                        x.d("MicroMsg.SnsEditText", "parsterLen: %d %d", new Object[]{Integer.valueOf(substring.length()), Integer.valueOf(SnsEditText.c(this.rBC))});
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsEditText", e, "", new Object[0]);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            SnsEditText.c(this.rBC, charSequence.length());
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
