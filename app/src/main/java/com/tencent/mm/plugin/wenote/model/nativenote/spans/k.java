package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class k implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private int tVC;
    public boolean tVD;
    public boolean tVG = false;
    public boolean tVH = false;
    public boolean tVI = false;
    public boolean tVJ = false;
    private WeakReference<Drawable> tVK;

    public final /* synthetic */ f bXw() {
        return bXy();
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public k(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        this.tVC = i;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.tVD = z5;
        this.tVJ = z;
        this.tVG = z3;
        this.tVH = z4;
        this.tVI = z2;
    }

    public int getLeadingMargin(boolean z) {
        return this.tVD ? 0 : this.tVC;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.tVD && spanned.getSpanStart(this) == i6) {
            WeakReference weakReference = this.tVK;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = (Drawable) weakReference.get();
            }
            if (drawable == null) {
                drawable = this.tVJ ? a.b(ac.getContext(), R.g.bEn) : a.b(ac.getContext(), R.g.bEo);
                this.tVK = new WeakReference(drawable);
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                canvas.save();
                FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable.getBounds().bottom / 2)));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private k bXy() {
        return new k(this.tVJ, this.tVC, this.tVI, this.tVG, this.tVH);
    }

    public final void a(TextView textView, Spannable spannable, MotionEvent motionEvent, k kVar) {
        if (motionEvent.getX() > ((float) this.tVC)) {
            x.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            return;
        }
        boolean z;
        int spanStart = spannable.getSpanStart(kVar);
        int spanEnd = spannable.getSpanEnd(kVar);
        String str = "MicroMsg.NoteTodoSpan";
        String str2 = "current mIsTodoCheck: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.tVJ ? "true" : "false";
        x.i(str, str2, objArr);
        spannable.removeSpan(this);
        if (this.tVJ) {
            z = false;
        } else {
            z = true;
        }
        this.tVJ = z;
        spannable.setSpan(bXy(), spanStart, spanEnd, 33);
        WXRTEditText wXRTEditText = (WXRTEditText) textView;
        if (wXRTEditText.tTw == 0) {
            b Bt = c.bWp().Bt(wXRTEditText.bWO());
            if (Bt != null && Bt.getType() == 1) {
                ((h) Bt).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannable);
            }
        }
    }
}
