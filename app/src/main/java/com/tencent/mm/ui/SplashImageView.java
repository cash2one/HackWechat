package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ak;

public class SplashImageView extends ImageView {
    private boolean hasDrawed;
    ak xML;

    public SplashImageView(Context context) {
        super(context);
        setImageResource(R.g.bHV);
    }

    public SplashImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageResource(R.g.bHV);
    }

    public SplashImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setImageResource(R.g.bHV);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.xML != null) {
                this.xML.aOk();
            }
        }
    }
}
