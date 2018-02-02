package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.neattextview.textview.a.a;

public class NeatLayout extends b {
    private native int nComputeBreak(String str, float[] fArr, float f, float f2, int[] iArr, float[] fArr2, float f3, boolean[] zArr, char[] cArr, float[] fArr3, char[] cArr2, float[] fArr4, boolean[] zArr2);

    static {
        System.loadLibrary("linebreak");
    }

    public NeatLayout(CharSequence charSequence, float[] fArr) {
        super(charSequence, fArr);
    }

    public final void a(TextPaint textPaint, float f, int i, boolean z) {
        float textSize = textPaint.getTextSize() / 2.0f;
        float textSize2 = z ? textPaint.getTextSize() / 6.0f : 0.0f;
        int length = this.zKu.length();
        int[] iArr = new int[length];
        float[] fArr = new float[length];
        boolean[] zArr = new boolean[length];
        int nComputeBreak = nComputeBreak(this.zKu, this.zKw, 0.0f, f + textSize, iArr, fArr, textSize2, zArr, a.zKp, this.zKz, a.zKo, this.zKy, this.zKO);
        int i2 = 0;
        int i3 = 0;
        while (i3 < nComputeBreak && i3 < i) {
            int i4 = iArr[i3];
            boolean z2 = zArr[i3];
            length = i4 - i2;
            float f2 = 0.0f;
            float f3 = f - fArr[i3];
            Object obj = Math.abs(f3) <= textSize ? 1 : null;
            if (obj != null) {
                if (i4 - 1 >= 0 && this.zKv[i4 - 1] == '\n') {
                    length--;
                }
                f2 = f3 / ((float) (length - 1));
            }
            a(this.zKv, i2, i4, obj != null ? f : fArr[i3], this.zKw, f2, z2);
            i3++;
            i2 = i4;
        }
    }
}
