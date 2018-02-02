package com.tencent.mm.plugin.label.ui.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;

class InputClearablePreference$b implements InputFilter {
    final /* synthetic */ InputClearablePreference nQr;
    public final char[] nQs = new char[]{'\n', ',', ';', '、', '，', '；'};

    InputClearablePreference$b(InputClearablePreference inputClearablePreference) {
        this.nQr = inputClearablePreference;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        x.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4));
        int i5 = i;
        while (i5 < i2) {
            char[] cArr = new char[(i2 - i)];
            TextUtils.getChars(charSequence, i, i2, cArr, 0);
            for (char c : this.nQs) {
                if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                    return "";
                }
                if (cArr[i5] == c) {
                    this.nQr.gk(true);
                    return "";
                }
            }
            i5++;
        }
        return null;
    }
}
