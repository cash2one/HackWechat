package com.tencent.mm.memory.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class a extends Drawable implements i {
    public static final Paint hap;
    private static final af haq = new af(Looper.getMainLooper());
    boolean DEBUG = false;
    public n har;
    private Runnable has = new Runnable(this) {
        final /* synthetic */ a hat;

        {
            this.hat = r1;
        }

        public final void run() {
            x.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[]{this.hat.tag});
            this.hat.invalidateSelf();
        }
    };
    protected String tag;

    static {
        Paint paint = new Paint();
        hap = paint;
        paint.setAntiAlias(true);
        hap.setFilterBitmap(false);
        hap.setColor(-1118482);
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.har = nVar;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        n nVar = this.har;
        if (nVar == null || nVar.isRecycled()) {
            canvas.drawColor(-1118482);
            return;
        }
        canvas.drawBitmap(nVar.bitmap, null, bounds, hap);
    }

    public final void Ey() {
        if (this.har != null) {
            this.har.Ey();
        }
    }

    public final void Ez() {
        if (this.har != null) {
            this.har.Ez();
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getIntrinsicWidth() {
        if (this.har == null) {
            return 0;
        }
        n nVar = this.har;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getWidth();
    }

    public int getIntrinsicHeight() {
        if (this.har == null) {
            return 0;
        }
        n nVar = this.har;
        if (nVar == null || nVar.isRecycled()) {
            return 0;
        }
        return nVar.bitmap.getHeight();
    }

    public final n EH() {
        if (this.har != null) {
            return this.har;
        }
        return null;
    }

    public String toString() {
        if (!this.DEBUG) {
            return super.toString();
        }
        String str = super.toString() + " code: " + hashCode();
        if (this.har != null) {
            return str + this.har;
        }
        return str;
    }
}
