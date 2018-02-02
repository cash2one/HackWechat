package com.tencent.mm.ui.widget.celltextview.f;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.c.a;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.Stack;

public final class b implements a {
    private static float[] zxU = new float[26];
    private Paint fC;
    private float zxV;

    public final a a(d dVar, Paint paint, int i, int i2, boolean z) {
        int i3;
        float floatValue;
        d.czl();
        this.fC = paint;
        int indexOf = dVar.getText().indexOf(10);
        Object obj = indexOf >= 0 ? 1 : null;
        String text = obj == null ? dVar.getText() : dVar.getText().substring(0, indexOf + 1);
        int length = text.length() - (obj != null ? 1 : 0);
        float f = -2.14748365E9f;
        Stack stack = new Stack();
        int i4 = 0;
        while (i4 < length) {
            i3 = 25;
            if (i4 + 25 >= length) {
                i3 = length - i4;
            } else if (Character.isHighSurrogate(text.charAt((i4 + 25) - 1))) {
                i3 = 26;
            }
            int a = dVar.a(i4, i3, zxU);
            if (f == -2.14748365E9f) {
                if (com.tencent.mm.ui.widget.celltextview.g.a.s(text.charAt(0))) {
                    char charAt = text.charAt(0);
                    b(this.fC);
                    f = -com.tencent.mm.ui.widget.celltextview.g.a.b(charAt, this.fC);
                } else {
                    f = 0.0f;
                }
            }
            int i5 = 0;
            while (i5 < a) {
                float f2 = zxU[i5] + f;
                stack.push(Float.valueOf(f2));
                f = f2 - ((float) i);
                char dv;
                if (f > 0.0f) {
                    float a2;
                    int i6;
                    int i7;
                    i5 += i4;
                    dv = com.tencent.mm.ui.widget.celltextview.g.a.dv(text, i5);
                    if (com.tencent.mm.ui.widget.celltextview.g.a.r(dv)) {
                        b(this.fC);
                        a2 = f - com.tencent.mm.ui.widget.celltextview.g.a.a(dv, this.fC);
                    } else {
                        a2 = f;
                    }
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                    if (a2 > b(paint) && com.tencent.mm.ui.widget.celltextview.g.a.r(com.tencent.mm.ui.widget.celltextview.g.a.dv(text, i5 - 1))) {
                        a2 = ((Float) stack.pop()).floatValue();
                        charAt = com.tencent.mm.ui.widget.celltextview.g.a.dv(text, i5 - 1);
                        b(this.fC);
                        stack.push(Float.valueOf(a2 - com.tencent.mm.ui.widget.celltextview.g.a.a(charAt, this.fC)));
                        a2 = f2;
                        i6 = i5;
                    } else if (a2 <= b(paint)) {
                        i6 = i5 + 1;
                        a2 += (float) i;
                        stack.push(Float.valueOf(a2));
                    } else {
                        a2 = f2;
                        i6 = i5;
                    }
                    f2 = (float) i2;
                    i5 = i6 - 1;
                    char[] ag = com.tencent.mm.ui.widget.celltextview.g.a.ag(text, i5 + 1, (i5 + 2) + 1);
                    boolean t = com.tencent.mm.ui.widget.celltextview.g.a.t(ag[1]);
                    boolean t2 = com.tencent.mm.ui.widget.celltextview.g.a.t(ag[0]);
                    x.i("MicroMsg.NewBreakText", "[isBreakPunc] [%s:%s]", new Object[]{Boolean.valueOf(t2), Boolean.valueOf(t)});
                    if (!t2 || t) {
                        if (t2 && t) {
                            i4 = com.tencent.mm.ui.widget.celltextview.g.a.dy(text, i5);
                            if (i4 > 0) {
                                if (this.fC.measureText(text.substring(dw(text, i4 - 1), com.tencent.mm.ui.widget.celltextview.g.a.dz(text, i5 + 2) + 1)) <= f2) {
                                    i7 = i4 - 1;
                                }
                            } else {
                                i7 = i6;
                            }
                        }
                        i7 = i6;
                    } else {
                        i7 = com.tencent.mm.ui.widget.celltextview.g.a.dy(text, i5);
                        i7 = i7 > 1 ? dw(text, i7 - 1) : i6;
                    }
                    i7 = dw(text, i7);
                    if (i7 == 0) {
                        i5 = i6;
                    } else {
                        i5 = i7;
                    }
                    i7 = i6 - i5;
                    if (i7 < 0) {
                        stack.push(Float.valueOf(a2));
                    } else {
                        i3 = i7;
                        while (stack.size() > 0 && i3 > 0) {
                            stack.pop();
                            i3--;
                        }
                        char dv2 = com.tencent.mm.ui.widget.celltextview.g.a.dv(text, i5 - 1);
                        if (i6 - i5 > 0 && com.tencent.mm.ui.widget.celltextview.g.a.r(dv2)) {
                            a2 = ((Float) stack.pop()).floatValue();
                            b(this.fC);
                            stack.push(Float.valueOf(a2 - com.tencent.mm.ui.widget.celltextview.g.a.a(dv2, this.fC)));
                        }
                    }
                    if (stack.size() > 0) {
                        floatValue = ((Float) stack.peek()).floatValue();
                    } else {
                        floatValue = 0.0f;
                    }
                    return new a(i5 + (indexOf == i5 ? 1 : 0), floatValue);
                }
                i5++;
                f = f2;
            }
            i4 = i3 + i4;
        }
        if (z || !com.tencent.mm.ui.widget.celltextview.g.a.r(com.tencent.mm.ui.widget.celltextview.g.a.dv(text, length - 1))) {
            floatValue = f;
        } else {
            dv = com.tencent.mm.ui.widget.celltextview.g.a.dv(text, length - 1);
            b(this.fC);
            floatValue = f - com.tencent.mm.ui.widget.celltextview.g.a.a(dv, this.fC);
        }
        i3 = (obj != null ? 1 : 0) + length;
        if (i3 == 0) {
            i3 = 0;
            floatValue = (float) i;
        }
        if (floatValue < 0.0f) {
            floatValue = 0.0f;
        }
        return new a(i3, floatValue);
    }

    public final float b(Paint paint) {
        if (0.0f == this.zxV) {
            this.zxV = paint.measureText("A");
        }
        return this.zxV;
    }

    private static int dw(String str, int i) {
        int i2 = i - 1;
        char[] ag = com.tencent.mm.ui.widget.celltextview.g.a.ag(str, i2, (i2 + 1) + 1);
        if (com.tencent.mm.ui.widget.celltextview.g.a.q(ag[0]) && com.tencent.mm.ui.widget.celltextview.g.a.q(ag[1])) {
            return com.tencent.mm.ui.widget.celltextview.g.a.dx(str, i2);
        }
        return i;
    }
}
