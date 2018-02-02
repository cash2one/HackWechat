package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectDecorView extends View {
    public boolean mmn;
    public boolean mmo;
    public boolean mmp;
    public RectF mmq;
    private Paint mmr;

    public FaceDetectDecorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectDecorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mmn = false;
        this.mmo = false;
        this.mmp = false;
        this.mmq = null;
        this.mmr = null;
        this.mmr = new Paint();
        this.mmr.setColor(getResources().getColor(b.black));
        this.mmr.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", new Object[]{Boolean.valueOf(this.mmo), Boolean.valueOf(this.mmn), this.mmq});
        if (this.mmo != this.mmn || this.mmp) {
            if (this.mmo) {
                canvas.drawColor(getResources().getColor(b.mct));
                canvas.drawRect(this.mmq, this.mmr);
            } else {
                canvas.drawColor(getResources().getColor(b.transparent));
            }
        }
        this.mmn = this.mmo;
    }
}
