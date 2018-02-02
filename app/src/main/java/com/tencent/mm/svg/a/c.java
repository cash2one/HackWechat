package com.tencent.mm.svg.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.mm.svg.b.b;

public final class c extends b {
    private a xCA;

    public static class a extends ConstantState {
        protected int sgU;
        protected Picture xCB;
        protected Bitmap xCC;

        public a(Picture picture, int i) {
            this.xCB = picture;
            this.sgU = i;
        }

        public final Drawable newDrawable() {
            return new c(this.xCB, this.sgU);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        this.xCA = new a(picture, i);
        clc();
    }

    public final ConstantState getConstantState() {
        return this.xCA;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        long clj = b.clj();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.xCA.xCB == null) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.xCs));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.xCA.xCC == null || this.xCA.xCC.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.xCs));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.xCA.xCB.draw(canvas2);
                            this.xCA.xCC = createBitmap;
                            b.fT(nanoTime);
                            j(canvas2);
                        }
                    }
                }
                if (this.xCA.xCC == null || this.xCA.xCC.isRecycled()) {
                    obj = null;
                } else {
                    cld();
                    canvas.drawBitmap(this.xCA.xCC, null, this.uk, this.xCu);
                }
                obj2 = obj;
            } else if (!(this.xCA.xCC == null || this.xCA.xCC.isRecycled())) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.xCA.xCC.toString());
                this.xCA.xCC.recycle();
                this.xCA.xCC = null;
            }
            if (this.mnm == null) {
                this.mnm = a.v(this);
            }
            a.b(this.mnm, this.xCu);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.xCA.xCB;
                    if (picture != null) {
                        cld();
                        canvas.save();
                        canvas.drawPicture(picture, this.uk);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.mDuration = b.fT(clj);
            j(canvas);
        } finally {
            this.mDuration = b.fT(clj);
            j(canvas);
        }
    }
}
