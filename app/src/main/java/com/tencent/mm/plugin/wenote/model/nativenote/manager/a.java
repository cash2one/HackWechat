package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import java.lang.reflect.Array;

public final class a extends SpannableString {
    private int Rw;
    private Object[] tSx;
    private int[] tSy;

    public a(CharSequence charSequence) {
        super(charSequence.toString());
        d(charSequence, charSequence.length());
    }

    private void d(CharSequence charSequence, int i) {
        this.tSx = new Object[20];
        this.tSy = new int[60];
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            for (Object obj : spanned.getSpans(0, i, Object.class)) {
                if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    int spanFlags = spanned.getSpanFlags(obj);
                    if (spanStart < 0) {
                        spanStart = 0;
                    }
                    if (spanEnd > i) {
                        spanEnd = i;
                    }
                    setSpan(obj, spanStart + 0, spanEnd + 0, spanFlags);
                }
            }
        }
    }

    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (this.Rw + 1 >= this.tSx.length) {
            int i4 = this.Rw + 10;
            Object obj2 = new Object[i4];
            Object obj3 = new int[(i4 * 3)];
            System.arraycopy(this.tSx, 0, obj2, 0, this.Rw);
            System.arraycopy(this.tSy, 0, obj3, 0, this.Rw * 3);
            this.tSx = obj2;
            this.tSy = obj3;
        }
        this.tSx[this.Rw] = obj;
        this.tSy[(this.Rw * 3) + 0] = i;
        this.tSy[(this.Rw * 3) + 1] = i2;
        this.tSy[(this.Rw * 3) + 2] = i3;
        this.Rw++;
    }

    public final void removeSpan(Object obj) {
        int i = this.Rw;
        Object obj2 = this.tSx;
        Object obj3 = this.tSy;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (obj2[i2] == obj) {
                i -= i2 + 1;
                System.arraycopy(obj2, i2 + 1, obj2, i2, i);
                System.arraycopy(obj3, (i2 + 1) * 3, obj3, i2 * 3, i * 3);
                this.Rw--;
                return;
            }
        }
    }

    public final int getSpanStart(Object obj) {
        int i = this.Rw;
        Object[] objArr = this.tSx;
        int[] iArr = this.tSy;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 0];
            }
        }
        return -1;
    }

    public final int getSpanEnd(Object obj) {
        int i = this.Rw;
        Object[] objArr = this.tSx;
        int[] iArr = this.tSy;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 1];
            }
        }
        return -1;
    }

    public final int getSpanFlags(Object obj) {
        int i = this.Rw;
        Object[] objArr = this.tSx;
        int[] iArr = this.tSy;
        for (i--; i >= 0; i--) {
            if (objArr[i] == obj) {
                return iArr[(i * 3) + 2];
            }
        }
        return 0;
    }

    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        int i3 = this.Rw;
        Object[] objArr = this.tSx;
        int[] iArr = this.tSy;
        Object obj = null;
        int i4 = 0;
        Object obj2 = null;
        int i5 = 0;
        while (i4 < i3) {
            Object obj3;
            if (cls == null || cls.isInstance(objArr[i4])) {
                int i6 = iArr[(i4 * 3) + 0];
                int i7 = iArr[(i4 * 3) + 1];
                if (i6 <= i2 && i7 >= i && (i6 == i7 || i == i2 || !(i6 == i2 || i7 == i))) {
                    if (i5 == 0) {
                        i5++;
                        obj = obj2;
                        obj2 = objArr[i4];
                    } else {
                        if (i5 == 1) {
                            obj2 = (Object[]) Array.newInstance(cls, (i3 - i4) + 1);
                            obj2[0] = obj;
                        }
                        i7 = 16711680 & iArr[(i4 * 3) + 2];
                        if (i7 != 0) {
                            i6 = 0;
                            while (i6 < i5 && i7 <= (getSpanFlags(obj2[i6]) & 16711680)) {
                                i6++;
                            }
                            System.arraycopy(obj2, i6, obj2, i6 + 1, i5 - i6);
                            obj2[i6] = objArr[i4];
                            i5++;
                            obj3 = obj;
                            obj = obj2;
                            obj2 = obj3;
                        } else {
                            i6 = i5 + 1;
                            obj2[i5] = objArr[i4];
                            i5 = i6;
                            obj3 = obj2;
                            obj2 = obj;
                            obj = obj3;
                        }
                    }
                    i4++;
                    obj3 = obj2;
                    obj2 = obj;
                    obj = obj3;
                }
            }
            obj3 = obj;
            obj = obj2;
            obj2 = obj3;
            i4++;
            obj3 = obj2;
            obj2 = obj;
            obj = obj3;
        }
        if (i5 == 0) {
            return (Object[]) Array.newInstance(cls, 0);
        }
        if (i5 == 1) {
            Object[] objArr2 = (Object[]) Array.newInstance(cls, 1);
            objArr2[0] = obj;
            return objArr2;
        } else if (i5 == obj2.length) {
            return (Object[]) obj2;
        } else {
            Object[] objArr3 = (Object[]) Array.newInstance(cls, i5);
            System.arraycopy(obj2, 0, objArr3, 0, i5);
            return objArr3;
        }
    }

    public final int nextSpanTransition(int i, int i2, Class cls) {
        int i3 = this.Rw;
        Object[] objArr = this.tSx;
        int[] iArr = this.tSy;
        if (cls == null) {
            cls = Object.class;
        }
        int i4 = 0;
        int i5 = i2;
        while (i4 < i3) {
            int i6 = iArr[(i4 * 3) + 0];
            int i7 = iArr[(i4 * 3) + 1];
            if (i6 <= i || i6 >= i5 || !r11.isInstance(objArr[i4])) {
                i6 = i5;
            }
            if (i7 <= i || i7 >= i6 || !r11.isInstance(objArr[i4])) {
                i7 = i6;
            }
            i4++;
            i5 = i7;
        }
        return i5;
    }
}
