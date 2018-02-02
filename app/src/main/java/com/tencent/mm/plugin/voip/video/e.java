package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.bv.a;

public final class e extends View {
    private Paint fC = new Paint();
    public int fp;
    private RectF kcv;
    private Matrix mMatrix;
    public int stt;
    public int stu;
    public int stv;

    public e(Context context) {
        super(context);
        this.fC.setStyle(Style.STROKE);
        this.fC.setColor(-65536);
        this.fC.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
    }

    protected final void onDraw(Canvas canvas) {
        if (this.kcv != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.kcv, this.fC);
            canvas.restore();
        }
    }
}
