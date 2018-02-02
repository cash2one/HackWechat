package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

public class MMAutoSizeTextView extends TextView {
    private Paint nx;
    private float nxF;
    private float xZw;
    private float xZx;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.xZw = (float) a.fromDPToPix(getContext(), 8);
        this.xZx = (float) a.fromDPToPix(getContext(), 22);
        this.nx = new Paint();
        this.nx.set(getPaint());
        coT();
    }

    private void dg(String str, int i) {
        x.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[]{str, Integer.valueOf(i)});
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            coT();
            float f = this.nxF;
            this.nx.setTextSize(f);
            while (f > this.xZw && this.nx.measureText(str) > ((float) paddingLeft)) {
                f -= 1.0f;
                if (f <= this.xZw) {
                    f = this.xZw;
                    break;
                }
                this.nx.setTextSize(f);
            }
            x.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[]{Float.valueOf(f), Float.valueOf(this.nxF), Float.valueOf(this.nx.measureText(str)), Integer.valueOf(paddingLeft)});
            setTextSize(0, f);
        }
    }

    private void coT() {
        this.nxF = getTextSize();
        if (this.nxF <= this.xZw) {
            this.nxF = this.xZx;
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        x.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        dg(charSequence.toString(), getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        x.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            dg(getText().toString(), i);
        }
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
