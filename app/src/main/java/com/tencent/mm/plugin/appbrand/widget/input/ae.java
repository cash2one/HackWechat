package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;

final class ae {

    private static class a implements NoCopySpan {
        public float abo;
        public float abp;
        public int jZD;
        public int jZE;
        public boolean jZF;
        public boolean jZG;
        public boolean jZH;
        @Deprecated
        public boolean jZI;

        public a(float f, float f2, int i, int i2) {
            this.abo = f;
            this.abp = f2;
            this.jZD = i;
            this.jZE = i2;
        }
    }

    static a[] e(TextView textView) {
        int i = 0;
        a[] aVarArr = null;
        if (textView != null && (textView.getText() instanceof Spannable)) {
            Spannable spannable = (Spannable) textView.getText();
            aVarArr = (a[]) spannable.getSpans(0, spannable.length(), a.class);
            int length = aVarArr.length;
            while (i < length) {
                spannable.removeSpan(aVarArr[i]);
                i++;
            }
        }
        return aVarArr;
    }
}
