package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.cb.a$c;
import com.tencent.mm.cb.a$j;

public class MMAutoAdjustTextView extends TextView {
    private float gOa;
    private float gUh;
    private Paint nx;
    private float zta;
    private boolean ztb = true;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, a$j.faD));
        init();
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context.obtainStyledAttributes(attributeSet, a$j.faD));
        init();
    }

    private void init() {
        this.zta = (float) a.aa(getContext(), a$c.bvW);
        this.gUh = getTextSize();
        this.gOa = a.eu(getContext());
        this.nx = new Paint();
        this.nx.set(getPaint());
    }

    private void b(TypedArray typedArray) {
        if (typedArray != null) {
            this.ztb = typedArray.getBoolean(a$j.zAw, true);
            typedArray.recycle();
        }
    }

    private void GW(int i) {
        if (i > 0) {
            measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            float measuredWidth = (float) getMeasuredWidth();
            while (measuredWidth > ((float) i)) {
                this.gUh -= a.getDensity(getContext());
                setTextSize(0, this.gUh * this.gOa);
                measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                measuredWidth = (float) getMeasuredWidth();
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        GW(getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            GW(i);
        }
    }
}
