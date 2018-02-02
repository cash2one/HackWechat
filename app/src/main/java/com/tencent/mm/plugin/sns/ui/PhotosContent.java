package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent extends MMFrameLayout {
    private int iYg = 120;
    public ArrayList<TagImageView> rvB = new ArrayList();
    private float rvC;

    public final void bzX() {
        this.rvB.clear();
    }

    public final void a(TagImageView tagImageView) {
        this.rvB.add(tagImageView);
    }

    public final void xx(int i) {
        if (i > 0) {
            this.rvC = getResources().getDisplayMetrics().density;
            this.iYg = (int) (((float) this.iYg) * this.rvC);
            if (i >= this.iYg) {
                i = this.iYg;
            }
            for (int i2 = 0; i2 < this.rvB.size(); i2++) {
                View childAt = getChildAt(i2);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(childAt.getLayoutParams());
                marginLayoutParams.width = i;
                marginLayoutParams.height = i;
                marginLayoutParams.leftMargin = (int) (((float) (i2 % 3)) * (((float) i) + (this.rvC * 3.0f)));
                marginLayoutParams.topMargin = (int) (((float) (i2 / 3)) * (((float) i) + (this.rvC * 3.0f)));
                LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
                layoutParams.gravity = 51;
                childAt.setLayoutParams(layoutParams);
            }
            int size = this.rvB.size() / 3;
            if (size > 0) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
                marginLayoutParams2.height = (int) ((((float) (size - 1)) * (this.rvC * 3.0f)) + ((float) (i * size)));
                setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public final TagImageView xy(int i) {
        if (i < this.rvB.size()) {
            return (TagImageView) this.rvB.get(i);
        }
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
