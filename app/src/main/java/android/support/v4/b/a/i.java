package android.support.v4.b.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;

public abstract class i extends Drawable {
    public final Paint fC = new Paint(3);
    public float jf;
    final Bitmap mBitmap;
    private int uf = JsApiSetBackgroundAudioState.CTRL_INDEX;
    private int ug = 119;
    public final BitmapShader uh;
    private final Matrix uj = new Matrix();
    final Rect uk = new Rect();
    private final RectF ul = new RectF();
    private boolean um = true;
    public boolean un;
    private int uo;
    private int uq;

    public void setFilterBitmap(boolean z) {
        this.fC.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.fC.setDither(z);
        invalidateSelf();
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    final void bq() {
        if (this.um) {
            if (this.un) {
                int min = Math.min(this.uo, this.uq);
                a(this.ug, min, min, getBounds(), this.uk);
                int min2 = Math.min(this.uk.width(), this.uk.height());
                this.uk.inset(Math.max(0, (this.uk.width() - min2) / 2), Math.max(0, (this.uk.height() - min2) / 2));
                this.jf = ((float) min2) * 0.5f;
            } else {
                a(this.ug, this.uo, this.uq, getBounds(), this.uk);
            }
            this.ul.set(this.uk);
            if (this.uh != null) {
                this.uj.setTranslate(this.ul.left, this.ul.top);
                this.uj.preScale(this.ul.width() / ((float) this.mBitmap.getWidth()), this.ul.height() / ((float) this.mBitmap.getHeight()));
                this.uh.setLocalMatrix(this.uj);
                this.fC.setShader(this.uh);
            }
            this.um = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bq();
            if (this.fC.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.uk, this.fC);
            } else {
                canvas.drawRoundRect(this.ul, this.jf, this.jf, this.fC);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.fC.getAlpha()) {
            this.fC.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.fC.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.fC.getColorFilter();
    }

    public final void br() {
        this.un = true;
        this.um = true;
        bs();
        this.fC.setShader(this.uh);
        invalidateSelf();
    }

    private void bs() {
        this.jf = (float) (Math.min(this.uq, this.uo) / 2);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.un) {
            bs();
        }
        this.um = true;
    }

    public int getIntrinsicWidth() {
        return this.uo;
    }

    public int getIntrinsicHeight() {
        return this.uq;
    }

    public int getOpacity() {
        if (this.ug != 119 || this.un) {
            return -3;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.fC.getAlpha() < 255 || o(this.jf)) {
            return -3;
        }
        return -1;
    }

    i(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.uf = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (this.mBitmap != null) {
            this.uo = this.mBitmap.getScaledWidth(this.uf);
            this.uq = this.mBitmap.getScaledHeight(this.uf);
            this.uh = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            return;
        }
        this.uq = -1;
        this.uo = -1;
        this.uh = null;
    }

    public static boolean o(float f) {
        return f > 0.05f;
    }
}
