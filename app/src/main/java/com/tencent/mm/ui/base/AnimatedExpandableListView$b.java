package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class AnimatedExpandableListView$b extends View {
    int dividerHeight;
    Drawable xNm;
    int xXA;
    List<View> xXz = new ArrayList();

    public AnimatedExpandableListView$b(Context context) {
        super(context);
    }

    public final void di(View view) {
        view.layout(0, 0, getWidth(), getHeight());
        this.xXz.add(view);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int size = this.xXz.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((View) this.xXz.get(i5)).layout(i, i2, i3, i4);
        }
    }

    public final void dispatchDraw(Canvas canvas) {
        canvas.save();
        if (this.xNm != null) {
            this.xNm.setBounds(0, 0, this.xXA, this.dividerHeight);
        }
        int size = this.xXz.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.xXz.get(i);
            view.draw(canvas);
            canvas.translate(0.0f, (float) view.getMeasuredHeight());
            if (this.xNm != null) {
                this.xNm.draw(canvas);
                canvas.translate(0.0f, (float) this.dividerHeight);
            }
        }
        canvas.restore();
    }
}
