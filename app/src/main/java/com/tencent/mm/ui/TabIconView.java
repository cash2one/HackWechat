package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.wcdb.FileUtils;

public class TabIconView extends ImageView {
    private Paint iYm;
    private Bitmap xMU;
    private Bitmap xMV;
    private Bitmap xMW;
    private Rect xMX;
    private Rect xMY;
    private Rect xMZ;
    private int xNa = 0;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(int i, int i2, int i3, boolean z) {
        if (z) {
            this.xMU = d.Da(i);
            this.xMV = d.Da(i3);
            this.xMW = d.Da(i2);
        } else {
            this.xMU = d.CZ(i);
            this.xMV = d.CZ(i3);
            this.xMW = d.CZ(i2);
        }
        this.xMX = new Rect(0, 0, this.xMU.getWidth(), this.xMU.getHeight());
        this.xMY = new Rect(0, 0, this.xMV.getWidth(), this.xMV.getHeight());
        this.xMZ = new Rect(0, 0, this.xMW.getWidth(), this.xMW.getHeight());
        this.iYm = new Paint(1);
    }

    public final void Ed(int i) {
        this.xNa = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.iYm != null) {
            if (this.xNa < FileUtils.S_IWUSR) {
                this.iYm.setAlpha(255 - (this.xNa * 2));
                canvas.drawBitmap(this.xMV, null, this.xMY, this.iYm);
                this.iYm.setAlpha(this.xNa * 2);
                canvas.drawBitmap(this.xMW, null, this.xMZ, this.iYm);
                return;
            }
            this.iYm.setAlpha(255 - (this.xNa * 2));
            canvas.drawBitmap(this.xMW, null, this.xMZ, this.iYm);
            this.iYm.setAlpha(this.xNa * 2);
            canvas.drawBitmap(this.xMU, null, this.xMX, this.iYm);
        }
    }
}
