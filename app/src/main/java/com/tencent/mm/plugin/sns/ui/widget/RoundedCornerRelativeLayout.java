package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.bv.a;

public class RoundedCornerRelativeLayout extends RelativeLayout {
    private Paint iYm;
    private a rRC;
    private Bitmap rlH;

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dy(context);
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dy(context);
    }

    private void dy(Context context) {
        int fromDPToPix = a.fromDPToPix(context, 8);
        this.rRC = new a(this, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        this.iYm = new Paint(1);
        this.iYm.setColor(-1);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.rlH == null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint = new Paint(1);
                paint.setColor(-1);
                canvas2.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
                paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
                RectF rectF = new RectF(0.0f, 0.0f, (float) this.rRC.rRD, (float) this.rRC.rRD);
                RectF rectF2 = new RectF((float) (width - this.rRC.rRE), 0.0f, (float) width, (float) this.rRC.rRE);
                RectF rectF3 = new RectF(0.0f, (float) (height - this.rRC.rRF), (float) this.rRC.rRF, (float) height);
                RectF rectF4 = new RectF((float) (width - this.rRC.rRG), (float) (height - this.rRC.rRG), (float) width, (float) height);
                Path path = new Path();
                path.moveTo(rectF.left, rectF.bottom);
                path.arcTo(rectF, 180.0f, 90.0f);
                path.lineTo(rectF2.left, rectF2.top);
                path.arcTo(rectF2, 270.0f, 90.0f);
                path.lineTo(rectF4.right, rectF4.top);
                path.arcTo(rectF4, 0.0f, 90.0f);
                path.lineTo(rectF3.right, rectF3.bottom);
                path.arcTo(rectF3, 90.0f, 90.0f);
                path.lineTo(rectF.left, rectF.bottom);
                canvas2.drawPath(path, paint);
                this.rlH = createBitmap;
            }
            canvas.drawBitmap(this.rlH, 0.0f, 0.0f, this.iYm);
        }
    }
}
