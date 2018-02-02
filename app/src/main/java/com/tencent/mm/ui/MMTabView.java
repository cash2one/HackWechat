package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.b;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.i;

public class MMTabView extends ViewGroup {
    private TextView iiq;
    private int index;
    private int padding;
    public int qhf;
    private TextView xHK;
    private ImageView xKt;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhf = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qhf = 3;
        this.padding = 0;
        init();
    }

    private MMTabView(Context context) {
        super(context);
        this.qhf = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, int i) {
        this(context);
        this.index = i;
        cne();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cne() {
        x.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", Integer.valueOf(this.index), cnf());
        a cnI = a.xNi;
        String charSequence = this.iiq.getText().toString();
        String cnf = cnf();
        int i = this.index;
        if (cnI.cnH() && this != null && !bh.ov(charSequence) && cnI.tI != null) {
            int i2;
            b bVar = new b();
            bVar.Ys(charSequence);
            if (!bh.ov(cnf)) {
                try {
                    i2 = bh.getInt(cnf, 0);
                } catch (Exception e) {
                }
            }
            i2 = 0;
            if (i2 > 0) {
                bVar.Ys(cnI.tI.getResources().getQuantityString(i.gYl, 1, new Object[]{Integer.valueOf(i2)}));
            }
            bVar.Ys(cnI.tI.getResources().getQuantityString(i.gYm, 5, new Object[]{Integer.valueOf(3), Integer.valueOf(i + 1)}));
            bVar.dg(this);
        }
    }

    private void init() {
        int eu;
        this.padding = getResources().getDimensionPixelSize(e.bvV);
        String cfi = w.cfi();
        boolean cfe = w.cfe();
        boolean equalsIgnoreCase = cfi.equalsIgnoreCase("en");
        if (cfe) {
            eu = (int) (com.tencent.mm.bv.a.eu(getContext()) * ((float) com.tencent.mm.bv.a.fromDPToPix(getContext(), 2)));
        } else {
            eu = 0;
        }
        this.iiq = new TextView(getContext());
        this.iiq.setSingleLine();
        this.iiq.setEllipsize(TruncateAt.END);
        this.iiq.setTextColor(getResources().getColorStateList(d.bui));
        this.iiq.setTextSize(0, (float) com.tencent.mm.bv.a.aa(getContext(), e.bvs));
        this.iiq.setText("");
        if (cfe) {
            this.iiq.setTextSize(0, ((float) eu) + this.iiq.getTextSize());
            this.iiq.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.iiq.setTypeface(null, 1);
        }
        addView(this.iiq);
        this.xKt = new ImageView(getContext());
        this.xKt.setBackgroundResource(f.gVe);
        this.xKt.setVisibility(4);
        addView(this.xKt);
        this.xHK = new TextView(getContext());
        this.xHK.setTextColor(getResources().getColor(d.white));
        this.xHK.setTextSize(1, 11.0f);
        this.xHK.setBackgroundResource(s.gd(getContext()));
        this.xHK.setTypeface(Typeface.DEFAULT_BOLD);
        this.xHK.setGravity(17);
        this.xHK.setVisibility(4);
        addView(this.xHK);
        setBackgroundResource(f.bDq);
    }

    public final void setText(int i) {
        this.iiq.setText(i);
    }

    public final void setTextColor(ColorStateList colorStateList) {
        this.iiq.setTextColor(colorStateList);
    }

    private String cnf() {
        return this.xHK.getText().toString();
    }

    public final void Yo(String str) {
        if (bh.ov(str)) {
            this.xHK.setVisibility(4);
            return;
        }
        this.xHK.setVisibility(0);
        this.xHK.post(new 1(this, str));
    }

    public final void lX(boolean z) {
        this.xKt.setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.iiq.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.xKt.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.xHK.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.iiq.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.iiq.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.iiq.getMeasuredHeight()) / 2;
        this.iiq.layout(measuredWidth, measuredHeight, measuredWidth2, this.iiq.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.xKt.getMeasuredHeight()) / 2;
        this.xKt.layout(measuredHeight, measuredHeight2, this.xKt.getMeasuredWidth() + measuredHeight, this.xKt.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.xHK.getMeasuredWidth()) {
            i5 -= this.xHK.getMeasuredWidth();
            i6 = (i6 - this.xHK.getMeasuredHeight()) / 2;
            this.xHK.layout(i5, i6, this.xHK.getMeasuredWidth() + i5, this.xHK.getMeasuredHeight() + i6);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.xHK.getMeasuredHeight()) / 2;
        this.xHK.layout(i5, i6, this.xHK.getMeasuredWidth() + i5, this.xHK.getMeasuredHeight() + i6);
    }
}
