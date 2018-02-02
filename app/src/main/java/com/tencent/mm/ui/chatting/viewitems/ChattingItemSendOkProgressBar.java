package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> yMV = null;
    private static SoftReference<Bitmap> yMW = null;
    private static SoftReference<Bitmap> yMX = null;
    private static int yNd;
    private static int yNe;
    private boolean huK = false;
    private float rotation = 0.0f;
    private int yMR = 0;
    private int yMS = 0;
    private boolean yMT = false;
    private boolean yMU = false;
    private Bitmap yMY = null;
    private Bitmap yMZ = null;
    private Bitmap yNa = null;
    private boolean yNb = false;
    private a yNc = null;

    public interface a {
    }

    static {
        yNd = 0;
        yNe = 0;
        yNd = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 1);
        yNe = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 6);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        if (this.yNb) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.yMY.getWidth(), (float) this.yMY.getHeight()), 255, 31);
            if (!this.huK) {
                canvas.drawBitmap(this.yNa, new Rect(0, 0, this.yNa.getWidth(), this.yNa.getHeight()), new Rect(yNd, yNe, this.yNa.getWidth() + yNd, this.yNa.getHeight() + yNe), null);
                return;
            } else if (this.yMT) {
                if (this.yMR <= this.yMZ.getWidth()) {
                    Matrix matrix = new Matrix();
                    this.rotation += 6.0f;
                    matrix.setRotate(this.rotation, (float) (this.yMY.getWidth() / 2), (float) (this.yMY.getHeight() / 2));
                    int i = ((int) this.rotation) % 360;
                    if (i < 270) {
                        i += 360;
                    }
                    if (i >= 270 && i < 450) {
                        Paint paint = new Paint();
                        paint.setColor(-16776961);
                        canvas.drawBitmap(this.yMY, matrix, paint);
                        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                        canvas.drawRect(0.0f, 0.0f, (float) this.yMY.getWidth(), (float) (this.yMY.getHeight() / 2), paint);
                    }
                    canvas.drawBitmap(this.yMZ, new Rect(0, 0, this.yMR, this.yMZ.getHeight()), new Rect(yNd, yNe, this.yMR + yNd, this.yMZ.getHeight() + yNe), null);
                    this.yMR += 2;
                    invalidate();
                    return;
                }
                Rect rect = new Rect(0, 0, this.yMZ.getWidth(), this.yMZ.getHeight());
                Rect rect2 = new Rect(yNd, yNe, this.yMZ.getWidth() + yNd, this.yMZ.getHeight() + yNe);
                canvas.drawBitmap(this.yMZ, rect, rect2, null);
                if (this.yMS < 255) {
                    Paint paint2 = new Paint();
                    paint2.setAlpha(this.yMS);
                    canvas.drawBitmap(this.yNa, rect, rect2, paint2);
                    this.yMS += 20;
                    invalidate();
                    return;
                }
                canvas.drawBitmap(this.yNa, rect, rect2, null);
                this.huK = false;
                this.rotation = 0.0f;
                this.yMR = 0;
                this.yMS = 0;
                this.yMU = false;
                this.yMT = false;
                return;
            } else if (((int) (this.rotation - 270.0f)) % 360 == 0 && this.yMU) {
                this.yMT = true;
                invalidate();
                return;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(this.rotation, (float) (this.yMY.getWidth() / 2), (float) (this.yMY.getHeight() / 2));
                canvas.drawBitmap(this.yMY, matrix2, null);
                this.rotation += 6.0f;
                invalidate();
                return;
            }
        }
        super.onDraw(canvas);
    }
}
