package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.x;

@RemoteView
public class QImageView extends View {
    private static final a[] zvZ = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] zwa = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private int Dd;
    private boolean RQ;
    private Uri aMK;
    private int iX;
    private Context mContext;
    public Drawable mDrawable;
    public Matrix mMatrix;
    private ColorFilter mr;
    private int vqO;
    private int zvK;
    private a zvL;
    private boolean zvM;
    private boolean zvN;
    private int zvO;
    private boolean zvP;
    private int[] zvQ;
    private boolean zvR;
    private int zvS;
    private int zvT;
    private int zvU;
    private Matrix zvV;
    private final RectF zvW;
    private final RectF zvX;
    private boolean zvY;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int zwj;

        private a(int i) {
            this.zwj = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        cyY();
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zvK = 0;
        this.zvM = false;
        this.zvN = false;
        this.iX = Integer.MAX_VALUE;
        this.vqO = Integer.MAX_VALUE;
        this.Dd = 255;
        this.zvO = 256;
        this.zvP = false;
        this.mDrawable = null;
        this.zvQ = null;
        this.zvR = false;
        this.zvS = 0;
        this.zvV = null;
        this.zvW = new RectF();
        this.zvX = new RectF();
        this.RQ = false;
        this.mContext = context;
        cyY();
        this.RQ = false;
        this.zvN = false;
        this.iX = Integer.MAX_VALUE;
        this.vqO = Integer.MAX_VALUE;
        this.zvY = false;
    }

    private void cyY() {
        this.mMatrix = new Matrix();
        this.zvL = a.FIT_CENTER;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() != null) {
            return false;
        }
        int i2 = (i >> 7) + i;
        if (this.zvO == i2) {
            return true;
        }
        this.zvO = i2;
        this.zvP = true;
        czb();
        return true;
    }

    public final void setImageResource(int i) {
        if (this.aMK != null || this.zvK != i) {
            x(null);
            this.zvK = i;
            this.aMK = null;
            cyZ();
            invalidate();
        }
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        if (!(this.mDrawable instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.zvK = 0;
            this.aMK = null;
            x(drawable);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    private void cyZ() {
        Drawable drawable = null;
        if (this.mDrawable == null) {
            Resources resources = getResources();
            if (resources != null) {
                if (this.zvK != 0) {
                    try {
                        drawable = resources.getDrawable(this.zvK);
                    } catch (Exception e) {
                        x.w("ImageView", "Unable to find resource: " + this.zvK, new Object[]{e});
                        this.aMK = drawable;
                    }
                } else if (this.aMK == null) {
                    return;
                }
                x(drawable);
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.zvT;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.zvU;
            }
            if (intrinsicWidth != this.zvT || intrinsicHeight != this.zvU) {
                this.zvT = intrinsicWidth;
                this.zvU = intrinsicHeight;
                requestLayout();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        } else if (this.zvL != aVar) {
            this.zvL = aVar;
            setWillNotCacheDrawing(this.zvL == a.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.zvQ == null) {
            return super.onCreateDrawableState(i);
        }
        if (this.zvR) {
            return mergeDrawableStates(super.onCreateDrawableState(this.zvQ.length + i), this.zvQ);
        }
        return this.zvQ;
    }

    private void x(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.zvS);
            this.zvT = drawable.getIntrinsicWidth();
            this.zvU = drawable.getIntrinsicHeight();
            czb();
            cza();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Object obj;
        float f;
        int i5;
        int mode;
        cyZ();
        Object obj2 = null;
        if (this.mDrawable == null) {
            this.zvT = -1;
            this.zvU = -1;
            i3 = 0;
            i4 = 0;
            obj = null;
            f = 0.0f;
        } else {
            i3 = this.zvT;
            i5 = this.zvU;
            if (i3 <= 0) {
                i3 = 1;
            }
            if (i5 <= 0) {
                i5 = 1;
            }
            if (this.zvN) {
                mode = MeasureSpec.getMode(i);
                i4 = MeasureSpec.getMode(i2);
                Object obj3 = mode != 1073741824 ? 1 : null;
                obj2 = i4 != 1073741824 ? 1 : null;
                Object obj4 = obj3;
                f = ((float) i3) / ((float) i5);
                i4 = i5;
                obj = obj4;
            } else {
                f = 0.0f;
                i4 = i5;
                obj = null;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && r3 == null) {
            mode = (paddingTop + paddingBottom) + i4;
            i5 = Math.max((paddingLeft + paddingRight) + i3, getSuggestedMinimumWidth());
            int max = Math.max(mode, getSuggestedMinimumHeight());
            mode = resolveSize(i5, i);
            i5 = resolveSize(max, i2);
        } else {
            i3 = al((i3 + paddingLeft) + paddingRight, this.iX, i);
            i4 = al((i4 + paddingTop) + paddingBottom, this.vqO, i2);
            if (f != 0.0f && ((double) Math.abs((((float) ((i3 - paddingLeft) - paddingRight)) / ((float) ((i4 - paddingTop) - paddingBottom))) - f)) > 1.0E-7d) {
                if (obj != null) {
                    int i6 = (((int) (((float) ((i4 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i6 <= i3) {
                        obj = 1;
                        i3 = i6;
                        if (obj == null && r3 != null) {
                            i5 = (((int) (((float) ((i3 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i5 <= i4) {
                                mode = i3;
                            }
                        }
                    }
                }
                obj = null;
                i5 = (((int) (((float) ((i3 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i5 <= i4) {
                    mode = i3;
                }
            }
            i5 = i4;
            mode = i3;
        }
        setMeasuredDimension(mode, i5);
    }

    private static int al(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zvM = true;
        cza();
    }

    private void cza() {
        float f = 0.0f;
        if (this.mDrawable != null && this.zvM) {
            int i = this.zvT;
            int i2 = this.zvU;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
            if (i <= 0 || i2 <= 0 || a.FIT_XY == this.zvL) {
                this.mDrawable.setBounds(0, 0, width, height);
                this.zvV = null;
                return;
            }
            this.mDrawable.setBounds(0, 0, i, i2);
            if (a.MATRIX == this.zvL) {
                if (this.mMatrix.isIdentity()) {
                    this.zvV = null;
                } else {
                    this.zvV = this.mMatrix;
                }
            } else if (i3 != 0) {
                this.zvV = null;
            } else if (a.CENTER == this.zvL) {
                this.zvV = this.mMatrix;
                this.zvV.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            } else if (a.CENTER_CROP == this.zvL) {
                this.zvV = this.mMatrix;
                if (i * height > width * i2) {
                    r2 = ((float) height) / ((float) i2);
                    r1 = (((float) width) - (((float) i) * r2)) * 0.5f;
                } else {
                    r2 = ((float) width) / ((float) i);
                    r1 = 0.0f;
                    f = (((float) height) - (((float) i2) * r2)) * 0.5f;
                }
                this.zvV.setScale(r2, r2);
                this.zvV.postTranslate((float) ((int) (r1 + 0.5f)), (float) ((int) (f + 0.5f)));
            } else if (a.CENTER_INSIDE == this.zvL) {
                this.zvV = this.mMatrix;
                if (i > width || i2 > height) {
                    f = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
                } else {
                    f = 1.0f;
                }
                r1 = (float) ((int) (((((float) width) - (((float) i) * f)) * 0.5f) + 0.5f));
                r2 = (float) ((int) (((((float) height) - (((float) i2) * f)) * 0.5f) + 0.5f));
                this.zvV.setScale(f, f);
                this.zvV.postTranslate(r1, r2);
            } else {
                this.zvW.set(0.0f, 0.0f, (float) i, (float) i2);
                this.zvX.set(0.0f, 0.0f, (float) width, (float) height);
                this.zvV = this.mMatrix;
                this.zvV.setRectToRect(this.zvW, this.zvX, zwa[this.zvL.zwj - 1]);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable != null && this.zvT != 0 && this.zvU != 0) {
            if (this.zvV == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.zvY) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.zvV != null) {
                canvas.concat(this.zvV);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public int getBaseline() {
        return this.RQ ? getMeasuredHeight() : -1;
    }

    public final void setAlpha(int i) {
        int i2 = i & 255;
        if (this.Dd != i2) {
            this.Dd = i2;
            this.zvP = true;
            czb();
            invalidate();
        }
    }

    private void czb() {
        if (this.mDrawable != null && this.zvP) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.mr);
            this.mDrawable.setAlpha((this.Dd * this.zvO) >> 8);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
