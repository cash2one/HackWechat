package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends BitmapDrawable implements a {
    private static Bitmap feJ;
    private static af haq = new af(Looper.getMainLooper());
    private Runnable has;
    private Bitmap kHc;
    private String mUrl;

    private k(String str) {
        Bitmap createBitmap;
        if (feJ == null || feJ.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            feJ = createBitmap;
        } else {
            createBitmap = feJ;
        }
        this(str, createBitmap);
    }

    private k(String str, Bitmap bitmap) {
        super(bitmap);
        this.has = new 1(this);
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        j.a(this);
        setUrl(str);
    }

    public final void l(String str, Bitmap bitmap) {
        if (this.mUrl != null && (this.mUrl.hashCode()).equals(str) && bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.kHc = bitmap;
            haq.post(this.has);
        }
    }

    public final void draw(Canvas canvas) {
        if (this.kHc == null || this.kHc.isRecycled()) {
            super.draw(canvas);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.kHc, new Rect(0, 0, this.kHc.getWidth(), this.kHc.getHeight()), bounds, getPaint());
    }

    public final void setUrl(String str) {
        if (str != null && !str.equals(this.mUrl)) {
            x.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", new Object[]{str});
            this.mUrl = str;
            Bitmap a = j.a(new ar(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.kHc = a;
            }
            haq.post(this.has);
        }
    }
}
