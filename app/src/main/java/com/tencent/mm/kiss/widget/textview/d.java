package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static e gTv = new e();
    private static final SpannableString gTw = new SpannableString("");
    int gTA = 0;
    TextPaint gTB = null;
    Alignment gTC = Alignment.ALIGN_NORMAL;
    TruncateAt gTD = null;
    int gTE = -1;
    TextDirectionHeuristic gTF = null;
    float gTG = 0.0f;
    float gTH = 1.0f;
    boolean gTI = false;
    LengthFilter gTJ = null;
    CharSequence gTx = null;
    CharSequence gTy = null;
    int gTz = 0;
    int gravity = 51;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d Ed = gTv.Ed();
        if (Ed == null) {
            Ed = new d();
        }
        Ed.gTx = charSequence.toString();
        Ed.gTy = charSequence;
        Ed.gTz = 0;
        Ed.gTA = length;
        Ed.width = i;
        Ed.gTB = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                Ed.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                Ed.maxLength = length;
                Ed.gTJ = new LengthFilter(Ed.maxLength);
            }
        }
        Alignment alignment = aVar.gTC;
        if (alignment != null) {
            Ed.gTC = alignment;
        }
        if (aVar.gTD != null) {
            TruncateAt truncateAt = aVar.gTD;
            if (truncateAt != null) {
                Ed.gTD = truncateAt;
            }
        }
        Ed.gravity = aVar.gravity;
        if (aVar.gUf != -1) {
            length = aVar.gUf;
            if (length >= 0) {
                Ed.gTE = length;
            }
        }
        if (aVar.gTF != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.gTF;
            if (VERSION.SDK_INT >= 18) {
                Ed.gTF = textDirectionHeuristic;
            }
        }
        float f = aVar.gTG;
        float f2 = aVar.gTH;
        Ed.gTG = f;
        Ed.gTH = f2;
        Ed.gTI = aVar.gTI;
        if (aVar.boj != null) {
            if (aVar.gUg != -1) {
                Typeface typeface = aVar.boj;
                int i2 = aVar.gUg;
                if (i2 > 0) {
                    typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                    Ed.a(typeface);
                    length = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i2;
                    TextPaint textPaint = Ed.gTB;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    Ed.gTB.setTextSkewX((length & 2) != 0 ? -0.25f : 0.0f);
                } else {
                    Ed.gTB.setFakeBoldText(false);
                    Ed.gTB.setTextSkewX(0.0f);
                    Ed.a(typeface);
                }
            } else {
                Ed.a(aVar.boj);
            }
        }
        if (aVar.gUh != -1.0f) {
            Ed.gTB.setTextSize(aVar.gUh);
        }
        if (aVar.textColor != -1) {
            Ed.gTB.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            Ed.gTB.linkColor = aVar.linkColor;
        }
        if (aVar.gTN != null) {
            Ed.gTB = aVar.gTN;
        }
        return Ed;
    }

    private d a(Typeface typeface) {
        this.gTB.setTypeface(typeface);
        return this;
    }

    @TargetApi(18)
    public final f Ec() {
        int i;
        boolean z;
        StaticLayout a;
        if (this.gTD == null || this.gTE <= 0) {
            i = this.width;
        } else {
            i = this.gTE;
        }
        if (this.gTD == null && this.maxLines == 1) {
            this.gTD = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.gTJ != null) {
            CharSequence filter = this.gTJ.filter(this.gTy, 0, this.gTy.length(), gTw, 0, 0);
            if (filter != null) {
                this.gTy = filter;
                if (this.gTA > this.gTy.length()) {
                    this.gTA = this.gTy.length();
                }
            }
        }
        if (h.DEBUG) {
            x.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.gTy + " " + this.width);
        }
        if (this.gTC == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.gTC = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.gTC = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.gTC = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.gTC = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.gTB.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.gTF == null || (com.tencent.mm.compatible.util.d.fM(18) && this.gTF == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.gTy, z, i);
        } catch (Exception e) {
            x.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.gTy);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.gTy = spannableStringBuilder;
                    staticLayout = a(this.gTy, z, i);
                    x.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    x.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.gTy = this.gTy.toString();
            a = a(this.gTy, z, i);
        }
        f fVar = new f(a);
        fVar.gTM = this.gTx;
        fVar.text = this.gTy;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.gTC = this.gTC;
        fVar.gTD = this.gTD;
        fVar.gTN = this.gTB;
        fVar.gravity = this.gravity;
        gTv.a(this);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        if (z) {
            return new StaticLayout(charSequence, this.gTz, this.gTA, this.gTB, this.width, this.gTC, this.gTH, this.gTG, this.gTI, this.gTD, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.gTF == null) {
                this.gTF = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.gTz, this.gTA, this.gTB, this.width, this.gTC, this.gTF, this.gTH, this.gTG, this.gTI, this.gTD, i, this.maxLines);
        } else {
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.gTz, this.gTA, this.gTB, this.width, this.gTC, this.gTH, this.gTG, this.gTI, this.gTD, i, this.maxLines);
        }
    }
}
