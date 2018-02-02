package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.af;

public class FirstScreenFrameLayout extends FrameLayout {
    public a gxG;

    public interface a {
        void wy();
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gxG != null) {
            new af(Looper.getMainLooper()).postAtFrontOfQueueV2(new Runnable(this) {
                final /* synthetic */ FirstScreenFrameLayout gxH;

                {
                    this.gxH = r1;
                }

                public final void run() {
                    if (this.gxH.gxG != null) {
                        this.gxH.gxG.wy();
                        this.gxH.gxG = null;
                    }
                }
            });
        }
    }
}
