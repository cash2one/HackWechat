package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    private boolean ipq = true;
    public int maxLines;
    private Paint zhT;
    private String zhU;
    private Rect zhV = new Rect();
    private LinkedList<String> zhW = new LinkedList();
    public int zhX;
    private Drawable zhY;
    public boolean zhZ;
    private int zia = 0;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void b(String str, int i, boolean z, int i2) {
        a(str, i, z, i2, getCurrentTextColor());
    }

    public final void a(String str, int i, boolean z, int i2, int i3) {
        this.maxLines = i;
        this.zhU = str;
        if (this.zhU == null) {
            x.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.zhU = "";
        }
        if (this.maxLines <= 0) {
            x.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.zia = getResources().getDimensionPixelSize(e.buo);
        this.zhZ = z;
        this.zhX = i2;
        if (this.zhZ) {
            this.zhY = getResources().getDrawable(this.zhX);
        }
        this.zhT = new Paint();
        this.zhT.set(getPaint());
        this.zhT.setAntiAlias(true);
        this.zhT.setColor(i3);
        ds(this.zhU, getWidth());
        setHeight(Math.max(cxN(), a.fromDPToPix(getContext(), 32)));
    }

    private int cxN() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) ((((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.zhW.size())) + ((float) getPaddingTop())) + ((float) getPaddingBottom()))) + (Math.max(0, this.zhW.size() - 1) * this.zia);
    }

    private boolean ds(String str, int i) {
        if (!this.ipq || i <= 0 || str == null || "".equals(str)) {
            return false;
        }
        int ceil;
        this.zhW.clear();
        int i2 = 0;
        int length = str.length();
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.zhZ ? this.zhY.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i3 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            ceil = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            ceil = i3;
        }
        for (int i4 = 0; i4 < ceil; i4++) {
            if (i4 == ceil - 1) {
                ZX(str.substring(i2, d(str, i2, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                i3 = d(str, i2, length, 0, paddingLeft);
                ZX(str.substring(i2, i3).trim());
                if (i3 >= length) {
                    x.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i2 = i3;
            }
        }
        return true;
    }

    private void ZX(String str) {
        if (this.zhW != null && str != null && !"".equals(str)) {
            this.zhW.add(str);
        }
    }

    private int d(String str, int i, int i2, int i3, int i4) {
        if (i2 <= i) {
            return i + 1;
        }
        if (getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            return i2;
        }
        int length = str.length();
        while (getPaint().measureText(str, i, i2) + ((float) i3) > ((float) i4)) {
            i2 = (i2 + i) >> 1;
        }
        while (i2 <= length && getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            i2++;
        }
        int min = Math.min(length, i2) - 1;
        length = min;
        while (length >= 0 && bh.o(str.charAt(length))) {
            length--;
        }
        if (length < 0 || length == min) {
            return i2 - 1;
        }
        return length + 1;
    }

    protected void onDraw(Canvas canvas) {
        if (this.ipq && this.zhU != null && !"".equals(this.zhU) && this.zhW.size() != 0) {
            FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            float paddingTop = (float) getPaddingTop();
            Iterator it = this.zhW.iterator();
            float f2 = paddingTop;
            while (it.hasNext()) {
                float f3 = (fontMetrics.leading + f) + f2;
                canvas.drawText((String) it.next(), paddingLeft, f3, this.zhT);
                f2 = f3;
            }
            if (this.zhZ) {
                getPaint().getTextBounds((String) this.zhW.getLast(), 0, ((String) this.zhW.getLast()).length(), this.zhV);
                int paddingLeft2 = getPaddingLeft() + this.zhV.right;
                int i = (int) ((f2 - f) - fontMetrics.leading);
                this.zhY.setBounds(paddingLeft2, i, this.zhY.getIntrinsicWidth() + paddingLeft2, this.zhY.getIntrinsicHeight() + i);
                this.zhY.draw(canvas);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = (i == i3 && i2 == i4) ? false : true;
        this.ipq = z;
        if (this.ipq) {
            ds(this.zhU, i);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (ds(this.zhU, size)) {
            fromDPToPix = Math.max(cxN(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
    }
}
