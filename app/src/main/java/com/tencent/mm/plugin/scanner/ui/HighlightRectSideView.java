package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public class HighlightRectSideView extends View {
    private ak ikI = new ak(new 1(this), true);
    private Paint nd;
    private boolean[] pVn;
    private Rect pVo;
    private int pVp;
    private int pVq;
    private int pVr;
    private int pVs = 0;

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap decodeResource = a.decodeResource(getResources(), R.g.bFC);
        this.pVp = decodeResource.getWidth();
        this.pVq = decodeResource.getHeight();
        if (this.pVq != this.pVp) {
            x.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.pVr = (this.pVp * 6) / 24;
        this.pVn = new boolean[4];
        this.nd = new Paint();
        this.nd.setColor(6676738);
        this.nd.setAlpha(255);
        this.nd.setStrokeWidth((float) this.pVr);
        this.nd.setStyle(Style.STROKE);
        this.ikI.J(300, 300);
    }

    public final void i(Rect rect) {
        this.pVo = rect;
        x.d("MicroMsg.HighlightRectSideView", "rect:%s", new Object[]{rect});
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ikI != null) {
            this.ikI.TG();
            this.ikI = null;
        }
    }

    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.pVn[i2]) {
                i = 0;
                break;
            }
        }
        i = 1;
        int i3 = this.pVr / 2;
        if (this.pVn[0] && (1 == i || this.pVs % 2 == 0)) {
            canvas.drawLine((float) (this.pVo.left + i3), (float) (this.pVo.top + this.pVq), (float) (this.pVo.left + i3), (float) (this.pVo.bottom - this.pVq), this.nd);
        }
        if (this.pVn[1] && (1 == i || this.pVs % 2 == 0)) {
            canvas.drawLine((float) (this.pVo.right - i3), (float) (this.pVo.top + this.pVq), (float) (this.pVo.right - i3), (float) (this.pVo.bottom - this.pVq), this.nd);
        }
        if (this.pVn[2] && (1 == i || this.pVs % 3 == 0)) {
            canvas.drawLine((float) (this.pVo.left + this.pVp), (float) (this.pVo.top + i3), (float) (this.pVo.right - this.pVp), (float) (this.pVo.top + i3), this.nd);
        }
        if (!this.pVn[3]) {
            return;
        }
        if (1 == i || this.pVs % 3 == 0) {
            canvas.drawLine((float) (this.pVo.left + this.pVp), (float) (this.pVo.bottom - i3), (float) (this.pVo.right - this.pVp), (float) (this.pVo.bottom - i3), this.nd);
        }
    }

    public final void b(boolean[] zArr) {
        int i = 0;
        if (zArr != null && 4 == zArr.length) {
            x.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3])});
            while (i < 4) {
                this.pVn[i] = zArr[i];
                i++;
            }
            invalidate();
        }
    }
}
