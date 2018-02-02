package com.tencent.neattextview.textview.view;

import android.graphics.Paint.FontMetricsInt;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.CharacterStyle;

class NeatTextView$a {
    float fontScale;
    float gUh;
    int orientation;
    CharSequence text;
    FontMetricsInt zLA;
    int[] zLB;
    final /* synthetic */ NeatTextView zLC;
    int zLz = 1;

    NeatTextView$a(NeatTextView neatTextView, CharSequence charSequence, int[] iArr, float f, FontMetricsInt fontMetricsInt) {
        int i = 0;
        this.zLC = neatTextView;
        this.zLB = iArr;
        this.text = TextUtils.isEmpty(charSequence) ? "" : charSequence;
        this.gUh = f;
        this.zLA = fontMetricsInt;
        this.fontScale = neatTextView.getResources().getConfiguration().fontScale;
        this.orientation = neatTextView.getResources().getConfiguration().orientation;
        if (charSequence instanceof Spannable) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), CharacterStyle.class);
            int length = characterStyleArr.length;
            while (i < length) {
                this.zLz = characterStyleArr[i].hashCode() + this.zLz;
                i++;
            }
        }
    }

    public final int hashCode() {
        return (int) (((((float) (this.zLz + this.text.hashCode())) + ((this.gUh * this.fontScale) * ((float) this.orientation))) + ((float) this.zLB[0])) + ((float) this.zLB[1]));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof NeatTextView$a)) {
            return false;
        }
        NeatTextView$a neatTextView$a = (NeatTextView$a) obj;
        if (this.gUh == neatTextView$a.gUh && this.fontScale == neatTextView$a.fontScale && this.zLB[0] == neatTextView$a.zLB[0] && this.zLB[1] == neatTextView$a.zLB[1] && this.zLA.descent == neatTextView$a.zLA.descent && this.zLA.top == neatTextView$a.zLA.top && this.zLA.bottom == neatTextView$a.zLA.bottom && this.zLA.ascent == neatTextView$a.zLA.ascent && this.zLA.leading == neatTextView$a.zLA.leading && this.text.equals(neatTextView$a.text)) {
            return true;
        }
        return false;
    }
}
