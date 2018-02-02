package com.tencent.mm.t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d implements Cloneable {
    private static int gNU = a.aJ(12.0f);
    private static Paint gNW;
    private LinkedList<b> fjq;
    public int fjr;
    private Bitmap gNV;
    private float gr;
    private Path mY;

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float gOa = 0.0f;
        public float rotation = 0.0f;

        public b(float f, int i, float f2, float f3, float f4) {
            this.gOa = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        Paint paint = new Paint();
        gNW = paint;
        paint.setAntiAlias(true);
        gNW.setStyle(Style.STROKE);
        gNW.setColor(-16776961);
        gNW.setStrokeCap(Cap.ROUND);
    }

    public d(int i, Path path, float f, Bitmap bitmap) {
        this.fjr = i;
        this.gNV = bitmap;
        this.mY = path;
        this.gr = f;
        gNW.setStrokeWidth(((float) a.aJ(24.0f)) * f);
    }

    public d(int i, a<LinkedList> aVar, float f) {
        this.fjr = i;
        this.fjq = aVar;
        this.gr = f;
        gNW.setStrokeWidth(((float) a.aJ(24.0f)) * f);
    }

    public final void draw(Canvas canvas) {
        float f = 0.0f;
        Bitmap bitmap;
        if (this.fjr == a.gNX) {
            bitmap = this.gNV;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.mY, gNW);
                gNW.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, gNW);
                gNW.setXfermode(null);
                canvas.restore();
            }
        } else if (this.fjr == a.gNY && this.fjq.size() > 0) {
            b bVar = (b) this.fjq.getLast();
            float f2 = bVar.gOa;
            int i = bVar.color;
            int random = (int) (Math.random() * 100.0d);
            float f3 = ((float) gNU) * f2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ac.getContext().getResources(), com.tencent.mm.bj.a.d.vbs, options);
            options.inSampleSize = a.a(options, Math.round((((float) options.outWidth) * f2) * 0.7f), Math.round((f2 * ((float) options.outHeight)) * 0.7f));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(ac.getContext().getResources(), com.tencent.mm.bj.a.d.vbs, options);
            gNW.setStyle(Style.FILL);
            gNW.setColorFilter(new LightingColorFilter(i, 1));
            if (bitmap != null) {
                f2 = bVar.centerX - ((((float) bitmap.getWidth()) * 1.0f) / 2.0f);
                f = bVar.centerY - ((((float) bitmap.getHeight()) * 1.0f) / 2.0f);
            } else {
                f2 = 0.0f;
            }
            if (random > 0 && random <= 20) {
                f2 += f3;
                f += f3;
            } else if (80 < random) {
                f2 -= f3;
                f -= f3;
            }
            canvas.save();
            canvas.rotate(-bVar.rotation, bVar.centerX, bVar.centerY);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, f2, f, gNW);
            }
            canvas.restore();
            gNW.setStyle(Style.STROKE);
            gNW.setColorFilter(null);
        }
    }

    public static void clear() {
    }
}
