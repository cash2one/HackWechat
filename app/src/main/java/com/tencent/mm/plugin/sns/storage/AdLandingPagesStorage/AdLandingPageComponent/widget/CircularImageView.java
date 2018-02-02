package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.smtt.sdk.WebView;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private Paint iYm;
    private boolean nuE;
    private int ozg;
    private int rnA;
    private int rnB;
    private boolean rnC;
    private float rnD;
    private float rnE;
    private float rnF;
    private BitmapShader rnG;
    private Bitmap rnH;
    private Paint rnI;
    private Paint rnJ;
    private ColorFilter rnK;
    private boolean rny;
    private boolean rnz;
    private int shadowColor;

    public CircularImageView(Context context) {
        this(context, null, i$l.qNg);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i$l.qNg);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelOffset;
        float f = 0.0f;
        super(context, attributeSet, i);
        this.iYm = new Paint();
        this.iYm.setAntiAlias(true);
        this.rnI = new Paint();
        this.rnI.setAntiAlias(true);
        this.rnI.setStyle(Style.STROKE);
        this.rnJ = new Paint();
        this.rnJ.setAntiAlias(true);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i$l.qMS, i, 0);
        this.rny = obtainStyledAttributes.getBoolean(i$l.qMT, false);
        this.rnz = obtainStyledAttributes.getBoolean(i$l.qMW, false);
        this.rnC = obtainStyledAttributes.getBoolean(i$l.qNa, false);
        if (this.rny) {
            dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i$l.qMV, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f));
            this.ozg = dimensionPixelOffset;
            if (this.rnI != null) {
                this.rnI.setStrokeWidth((float) dimensionPixelOffset);
            }
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(i$l.qMU, -1);
            if (this.rnI != null) {
                this.rnI.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.rnz) {
            dimensionPixelOffset = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            this.rnK = new PorterDuffColorFilter(obtainStyledAttributes.getColor(i$l.qMX, 0), Mode.SRC_ATOP);
            invalidate();
            this.rnB = obtainStyledAttributes.getDimensionPixelOffset(i$l.qMZ, dimensionPixelOffset);
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(i$l.qMY, -16776961);
            if (this.rnJ != null) {
                this.rnJ.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.rnC) {
            this.rnD = obtainStyledAttributes.getFloat(i$l.qNb, 4.0f);
            this.rnE = obtainStyledAttributes.getFloat(i$l.qNc, 0.0f);
            this.rnF = obtainStyledAttributes.getFloat(i$l.qNd, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(i$l.qNe, WebView.NIGHT_MODE_COLOR);
            this.rnC = true;
            if (this.rnC) {
                f = this.rnD;
            }
            this.rnI.setShadowLayer(f, this.rnE, this.rnF, this.shadowColor);
            this.rnJ.setShadowLayer(f, this.rnE, this.rnF, this.shadowColor);
        }
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        int i = 0;
        if (this.rnH != null && this.rnH.getHeight() != 0 && this.rnH.getWidth() != 0) {
            int i2 = this.rnA;
            this.rnA = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i2 != this.rnA) {
                bxL();
            }
            this.iYm.setShader(this.rnG);
            int i3 = this.rnA / 2;
            if (this.rnz && this.nuE) {
                i = this.rnB;
                i3 = (this.rnA - (i * 2)) / 2;
                this.iYm.setColorFilter(this.rnK);
                canvas.drawCircle((float) (i3 + i), (float) (i3 + i), ((float) (((this.rnA - (i * 2)) / 2) + i)) - 4.0f, this.rnJ);
            } else if (this.rny) {
                int i4 = this.ozg;
                int i5 = (this.rnA - (i4 * 2)) / 2;
                this.iYm.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i4 / 2) + 0), (float) ((i4 / 2) + 0), (float) (this.rnA - (i4 / 2)), (float) (this.rnA - (i4 / 2))), 360.0f, 360.0f, false, this.rnI);
                i3 = i5;
                i = i4;
            } else {
                this.iYm.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i), (float) (i3 + i), (float) ((this.rnA - (i * 2)) / 2), this.iYm);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nuE = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.nuE = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.nuE = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.rnH = s(getDrawable());
        if (this.rnA > 0) {
            bxL();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.rnH = s(getDrawable());
        if (this.rnA > 0) {
            bxL();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.rnH = s(getDrawable());
        if (this.rnA > 0) {
            bxL();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.rnH = bitmap;
        if (this.rnA > 0) {
            bxL();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.rnA;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            mode = this.rnA;
        }
        setMeasuredDimension(size, mode + 2);
    }

    private static Bitmap s(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void bxL() {
        if (this.rnH != null) {
            this.rnG = new BitmapShader(this.rnH, TileMode.CLAMP, TileMode.CLAMP);
            if (this.rnA != this.rnH.getWidth() || this.rnA != this.rnH.getHeight()) {
                Matrix matrix = new Matrix();
                float width = ((float) this.rnA) / ((float) this.rnH.getWidth());
                matrix.setScale(width, width);
                this.rnG.setLocalMatrix(matrix);
            }
        }
    }

    public boolean isSelected() {
        return this.nuE;
    }
}
