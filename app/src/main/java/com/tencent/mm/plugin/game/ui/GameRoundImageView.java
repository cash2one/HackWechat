package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class GameRoundImageView extends AppCompatImageView {
    private static final PorterDuffXfermode nuK = new PorterDuffXfermode(Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF nuI;
    private Bitmap nuJ;
    private Rect rect;

    public GameRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (this.rect == null) {
            this.rect = new Rect(0, 0, getWidth(), getHeight());
        }
        if (this.nuI == null) {
            this.nuI = new RectF(this.rect);
        }
        if (!(this.bitmap == null || this.nuJ == null)) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            canvas.drawBitmap(this.nuJ, this.rect, this.rect, paint);
            paint.setXfermode(nuK);
            canvas.drawBitmap(this.bitmap, null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(R.e.bss));
        canvas.drawRoundRect(this.nuI, 18.0f, 18.0f, paint);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.nuI = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        this.rect = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawRoundRect(this.nuI, 18.0f, 18.0f, paint);
        this.nuJ = createBitmap;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        super.setImageBitmap(bitmap);
    }
}
