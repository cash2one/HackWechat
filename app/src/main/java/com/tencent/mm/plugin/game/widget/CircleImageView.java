package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class CircleImageView extends ImageView {
    private static final Config gZZ = Config.ARGB_8888;
    private static final ScaleType nxJ = ScaleType.CENTER_CROP;
    private int hV;
    private boolean iZv;
    private float jjd;
    private int jje;
    private final Paint jjg;
    private Bitmap mBitmap;
    private ColorFilter mr;
    private final RectF nxK;
    private final RectF nxL;
    private final Paint nxM;
    private float nxN;
    private boolean nxO;
    private boolean nxP;
    private BitmapShader uh;
    private final Matrix uj;
    private int uo;
    private int uq;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nxK = new RectF();
        this.nxL = new RectF();
        this.uj = new Matrix();
        this.nxM = new Paint();
        this.jjg = new Paint();
        this.jje = WebView.NIGHT_MODE_COLOR;
        this.hV = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZA, i, 0);
        this.hV = obtainStyledAttributes.getDimensionPixelSize(R.n.eZB, 0);
        this.jje = obtainStyledAttributes.getColor(R.n.eZC, WebView.NIGHT_MODE_COLOR);
        this.nxP = obtainStyledAttributes.getBoolean(R.n.eZD, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(nxJ);
        this.iZv = true;
        if (this.nxO) {
            setup();
            this.nxO = false;
        }
    }

    public ScaleType getScaleType() {
        return nxJ;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != nxJ) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.nxN, this.nxM);
            if (this.hV != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.jjd, this.jjg);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = q(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = q(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = q(getDrawable());
        setup();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mr) {
            this.mr = colorFilter;
            this.nxM.setColorFilter(this.mr);
            invalidate();
        }
    }

    private static Bitmap q(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, gZZ);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), gZZ);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void setup() {
        float f = 0.0f;
        if (!this.iZv) {
            this.nxO = true;
        } else if (this.mBitmap != null) {
            float height;
            float width;
            this.uh = new BitmapShader(this.mBitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.nxM.setAntiAlias(true);
            this.nxM.setShader(this.uh);
            this.jjg.setStyle(Style.STROKE);
            this.jjg.setAntiAlias(true);
            this.jjg.setColor(this.jje);
            this.jjg.setStrokeWidth((float) this.hV);
            this.uq = this.mBitmap.getHeight();
            this.uo = this.mBitmap.getWidth();
            this.nxL.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.jjd = Math.min((this.nxL.height() - ((float) this.hV)) / 2.0f, (this.nxL.width() - ((float) this.hV)) / 2.0f);
            this.nxK.set(this.nxL);
            if (!this.nxP) {
                this.nxK.inset((float) this.hV, (float) this.hV);
            }
            this.nxN = Math.min(this.nxK.height() / 2.0f, this.nxK.width() / 2.0f);
            this.uj.set(null);
            if (((float) this.uo) * this.nxK.height() > this.nxK.width() * ((float) this.uq)) {
                height = this.nxK.height() / ((float) this.uq);
                width = (this.nxK.width() - (((float) this.uo) * height)) * 0.5f;
            } else {
                height = this.nxK.width() / ((float) this.uo);
                width = 0.0f;
                f = (this.nxK.height() - (((float) this.uq) * height)) * 0.5f;
            }
            this.uj.setScale(height, height);
            this.uj.postTranslate(((float) ((int) (width + 0.5f))) + this.nxK.left, ((float) ((int) (f + 0.5f))) + this.nxK.top);
            this.uh.setLocalMatrix(this.uj);
            invalidate();
        }
    }
}
