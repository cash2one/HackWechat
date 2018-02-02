package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class ChatFooterBottom extends FrameLayout {
    boolean fJl = false;

    public ChatFooterBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatFooterBottom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ChatFooterBottom", "jacks onMeasure  width:%d, height:%d, isHide: %B", new Object[]{Integer.valueOf(MeasureSpec.getSize(i)), Integer.valueOf(MeasureSpec.getSize(i2)), Boolean.valueOf(this.fJl)});
        if (this.fJl) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ChatFooterBottom", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ChatFooterBottom", "jacks onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.fJl = false;
        }
        super.setVisibility(i);
    }
}
