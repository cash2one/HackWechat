package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;

public class MemberCardTopCropImageView extends ImageView {
    protected int itemPadding = -1;
    protected int kVD = -1;
    protected int kYJ = -1;
    private float kYK;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        this.kVD = a.aa(ac.getContext(), R.f.bwq);
        this.itemPadding = a.aa(ac.getContext(), R.f.bvB) * 2;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            return super.setFrame(i, i2, i3, i4);
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.kYJ = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i5 = this.kYJ;
        int i6 = this.kVD;
        if (intrinsicWidth * i6 > intrinsicHeight * i5) {
            this.kYK = ((float) i6) / ((float) intrinsicHeight);
        } else {
            this.kYK = ((float) i5) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.kYK, this.kYK);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
