package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.List;

final class c$a {
    public static final int awT = g(2, 2, 2, 0);
    public static final int awU = g(0, 0, 0, 0);
    public static final int awV = g(0, 0, 0, 3);
    static final int[] awW = new int[]{0, 0, 0, 0, 0, 2, 0};
    private static final int[] awX = new int[]{0, 0, 0, 0, 0, 0, 2};
    private static final int[] awY = new int[]{3, 3, 3, 3, 3, 3, 1};
    private static final boolean[] awZ = new boolean[]{false, false, false, true, true, true, false};
    static final int[] axa = new int[]{awU, awV, awU, awU, awV, awU, awU};
    private static final int[] axb = new int[]{0, 1, 2, 3, 4, 3, 4};
    private static final int[] axc = new int[]{0, 0, 0, 0, 0, 3, 3};
    static final int[] axd = new int[]{awU, awU, awU, awU, awU, awV, awV};
    final List<SpannableString> awH = new LinkedList();
    final SpannableStringBuilder awI = new SpannableStringBuilder();
    private int awK;
    boolean axe;
    boolean axf;
    int axg;
    int axh;
    int axi;
    boolean axj;
    private int axk;
    int axl;
    int axm;
    private int axn;
    private int axo;
    private int axp;
    private int axq;
    private int backgroundColor;
    private int foregroundColor;
    int priority;
    int row;
    int rowCount;
    boolean visible;

    public c$a() {
        reset();
    }

    public final boolean isEmpty() {
        return !this.axe || (this.awH.isEmpty() && this.awI.length() == 0);
    }

    public final void reset() {
        clear();
        this.axe = false;
        this.visible = false;
        this.priority = 4;
        this.axf = false;
        this.axg = 0;
        this.axh = 0;
        this.axi = 0;
        this.rowCount = 15;
        this.axj = true;
        this.axk = 0;
        this.axl = 0;
        this.axm = 0;
        this.axn = awU;
        this.foregroundColor = awT;
        this.backgroundColor = awU;
    }

    public final void clear() {
        this.awH.clear();
        this.awI.clear();
        this.axo = -1;
        this.awK = -1;
        this.axp = -1;
        this.axq = -1;
        this.row = 0;
    }

    public final void ap(int i, int i2) {
        this.axn = i;
        this.axk = i2;
    }

    public final void e(boolean z, boolean z2) {
        if (this.axo != -1) {
            if (!z) {
                this.awI.setSpan(new StyleSpan(2), this.axo, this.awI.length(), 33);
                this.axo = -1;
            }
        } else if (z) {
            this.axo = this.awI.length();
        }
        if (this.awK != -1) {
            if (!z2) {
                this.awI.setSpan(new UnderlineSpan(), this.awK, this.awI.length(), 33);
                this.awK = -1;
            }
        } else if (z2) {
            this.awK = this.awI.length();
        }
    }

    public final void aq(int i, int i2) {
        if (!(this.axp == -1 || this.foregroundColor == i)) {
            this.awI.setSpan(new ForegroundColorSpan(this.foregroundColor), this.axp, this.awI.length(), 33);
        }
        if (i != awT) {
            this.axp = this.awI.length();
            this.foregroundColor = i;
        }
        if (!(this.axq == -1 || this.backgroundColor == i2)) {
            this.awI.setSpan(new BackgroundColorSpan(this.backgroundColor), this.axq, this.awI.length(), 33);
        }
        if (i2 != awU) {
            this.axq = this.awI.length();
            this.backgroundColor = i2;
        }
    }

    public final void append(char c) {
        if (c == '\n') {
            this.awH.add(kW());
            this.awI.clear();
            if (this.axo != -1) {
                this.axo = 0;
            }
            if (this.awK != -1) {
                this.awK = 0;
            }
            if (this.axp != -1) {
                this.axp = 0;
            }
            if (this.axq != -1) {
                this.axq = 0;
            }
            while (true) {
                if ((this.axj && this.awH.size() >= this.rowCount) || this.awH.size() >= 15) {
                    this.awH.remove(0);
                } else {
                    return;
                }
            }
        }
        this.awI.append(c);
    }

    private SpannableString kW() {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(this.awI);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.axo != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.axo, length, 33);
            }
            if (this.awK != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.awK, length, 33);
            }
            if (this.axp != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.axp, length, 33);
            }
            if (this.axq != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.axq, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final b kZ() {
        boolean z = false;
        if (isEmpty()) {
            return null;
        }
        Alignment alignment;
        float f;
        float f2;
        int i;
        int i2;
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < this.awH.size(); i3++) {
            spannableStringBuilder.append((CharSequence) this.awH.get(i3));
            spannableStringBuilder.append('\n');
        }
        spannableStringBuilder.append(kW());
        switch (this.axk) {
            case 0:
            case 3:
                alignment = Alignment.ALIGN_NORMAL;
                break;
            case 1:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            case 2:
                alignment = Alignment.ALIGN_CENTER;
                break;
            default:
                throw new IllegalArgumentException("Unexpected justification value: " + this.axk);
        }
        if (this.axf) {
            f = ((float) this.axh) / 99.0f;
            f2 = ((float) this.axg) / 99.0f;
        } else {
            f = ((float) this.axh) / 209.0f;
            f2 = ((float) this.axg) / 74.0f;
        }
        float f3 = (f * 0.9f) + 0.05f;
        f = (f2 * 0.9f) + 0.05f;
        if (this.axi % 3 == 0) {
            i = 0;
        } else if (this.axi % 3 == 1) {
            i = 1;
        } else {
            i = 2;
        }
        if (this.axi / 3 == 0) {
            i2 = 0;
        } else if (this.axi / 3 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        if (this.axn != awU) {
            z = true;
        }
        return new b(spannableStringBuilder, alignment, f, i, f3, i2, z, this.axn, this.priority);
    }

    public static int s(int i, int i2, int i3) {
        return g(i, i2, i3, 0);
    }

    public static int g(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 255;
        a.as(i, 4);
        a.as(i2, 4);
        a.as(i3, 4);
        a.as(i4, 4);
        switch (i4) {
            case 0:
            case 1:
                i5 = 255;
                break;
            case 2:
                i5 = 127;
                break;
            case 3:
                i5 = 0;
                break;
            default:
                i5 = 255;
                break;
        }
        if (i > 1) {
            i6 = 255;
        } else {
            i6 = 0;
        }
        if (i2 > 1) {
            i7 = 255;
        } else {
            i7 = 0;
        }
        if (i3 <= 1) {
            i8 = 0;
        }
        return Color.argb(i5, i6, i7, i8);
    }
}
