package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends Drawable implements b {
    private static final Paint hap = new Paint();
    private static Rect rect = null;
    protected int ftE = 0;
    protected ImageView lIo;
    private Bitmap mBitmap;
    protected String mFilePath = "";
    protected String mQx = "";
    protected long mQy = 0;
    protected boolean mUU = false;
    public a mUV;
    long mUW;
    boolean mUX = false;
    private Rect mUY = new Rect();
    private Runnable mUZ = new 1(this);
    private int mWidth;

    static {
        hap.setAntiAlias(true);
        hap.setFilterBitmap(true);
    }

    private h(ImageView imageView) {
        this.lIo = imageView;
        this.mFilePath = "";
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        x.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        x.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[]{rect.toString()});
        super.setBounds(rect);
    }

    public final void draw(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mUW)) / 200.0f;
        if (this.mUW == 0) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[]{this.mFilePath});
            uptimeMillis = 0.0f;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[]{Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.mUX), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis))});
        if (!this.mUX) {
            c(canvas, 255);
            setAlpha(255);
        } else if (uptimeMillis >= 1.0f) {
            this.mUX = false;
            c(canvas, 255);
        } else if (c(canvas, (int) (uptimeMillis * 255.0f))) {
            invalidateSelf();
        }
    }

    private boolean c(Canvas canvas, int i) {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.mUX = true;
                this.mUW = 0;
                this.mBitmap = c.aND().b(this.mFilePath, this.ftE, this.mQx, this.mQy);
                if (!(this.mUV == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mUV.aOn();
                }
            }
            return false;
        }
        x.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.mUY;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        hap.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.mUY, getBounds(), hap);
        x.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[]{getBounds().toString()});
        return true;
    }

    public final void Bs(String str) {
        if (bh.ov(str)) {
            x.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
        } else if (this.mFilePath.equals(str)) {
            x.d("MicroMsg.ThumbDrawable", "notify thumb get " + str);
            this.lIo.post(this.mUZ);
        } else {
            x.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", new Object[]{str});
        }
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        a(imageView, i, str, str2, j, -1, null);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        h hVar;
        String str3;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof h)) {
            hVar = new h(imageView);
        } else {
            hVar = (h) drawable;
        }
        if (i2 > 0) {
            hVar.mWidth = i2;
        }
        hVar.mUV = aVar;
        if (bh.ov(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (bh.ov(str3)) {
            x.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
        } else {
            if (bh.ov(str)) {
                hVar.mUU = false;
            } else {
                hVar.mUU = true;
            }
            c.aND().a(hVar);
            String str4;
            String str5;
            Object[] objArr;
            if (!hVar.mFilePath.equals(str3) || hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                hVar.mFilePath = str3;
                hVar.mQx = str2;
                hVar.mQy = j;
                hVar.ftE = i;
                hVar.mBitmap = c.aND().Br(hVar.mFilePath);
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
                if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                    hVar.mUX = true;
                    hVar.mUW = 0;
                    hVar.mBitmap = c.aND().b(str3, i, str2, j);
                } else {
                    hVar.mUX = false;
                }
                if (!(hVar.mUV == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                    hVar.mUV.aOn();
                }
                hVar.lIo.invalidate();
            } else {
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                x.d(str4, str5, objArr);
            }
        }
        imageView.setImageDrawable(hVar);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
