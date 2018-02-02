package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.bh;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics ygl = new Metrics();
    private int KD;
    private ColorStateList ek;
    public TextPaint gu;
    private int iX;
    private CharSequence mText;
    private int ug;
    private boolean ydi;
    private int yfE;
    private Factory yfF;
    private Spannable.Factory yfG;
    private TruncateAt yfH;
    private CharSequence yfI;
    private int yfJ;
    private KeyListener yfK;
    private Layout yfL;
    private float yfM;
    private float yfN;
    private int yfO;
    private int yfP;
    private int yfQ;
    private int yfR;
    private boolean yfS;
    private boolean yfT;
    private int yfU;
    private boolean yfV;
    private BoringLayout yfW;
    private boolean yfX;
    private int yfY;
    private FontMetricsInt yfZ;
    private boolean yga;
    public boolean ygb;
    private b ygc;
    private boolean ygd;
    private boolean yge;
    private boolean ygf;
    private boolean ygg;
    private int ygh;
    private int ygi;
    private int ygj;
    private int ygk;

    public final void mt(boolean z) {
        if (this.ygd != z) {
            invalidate();
        }
        this.ygd = z;
    }

    public final void mu(boolean z) {
        if (this.yge != z) {
            invalidate();
        }
        this.yge = z;
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yfF = Factory.getInstance();
        this.yfG = Spannable.Factory.getInstance();
        this.yfH = null;
        this.yfJ = a.ygm;
        this.ug = 51;
        this.yfM = 1.0f;
        this.yfN = 0.0f;
        this.yfO = Integer.MAX_VALUE;
        this.yfP = 1;
        this.yfQ = 0;
        this.yfR = 1;
        this.iX = Integer.MAX_VALUE;
        this.yfS = false;
        this.KD = 0;
        this.yfT = false;
        this.yfU = -1;
        this.yfV = true;
        this.yfX = false;
        this.yga = false;
        this.ygb = false;
        this.ygd = false;
        this.yge = false;
        this.ygf = false;
        this.ygg = false;
        this.ygh = -1;
        this.ygi = -1;
        this.ygj = -1;
        this.ygk = -1;
        this.mText = "";
        this.yfI = "";
        this.gu = new TextPaint(1);
        this.gu.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.yfZ = this.gu.getFontMetricsInt();
        cqb();
        cpw();
        setEllipsize(null);
    }

    private void a(Drawable drawable, Drawable drawable2) {
        b bVar = this.ygc;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b(this);
                this.ygc = bVar;
            }
            if (!(bVar.ygt == drawable || bVar.ygt == null)) {
                bVar.ygt.setCallback(null);
            }
            bVar.ygt = drawable;
            if (!(bVar.ygr == null || bVar.ygr == null)) {
                bVar.ygr.setCallback(null);
            }
            bVar.ygr = null;
            if (!(bVar.ygu == drawable2 || bVar.ygu == null)) {
                bVar.ygu.setCallback(null);
            }
            bVar.ygu = drawable2;
            if (!(bVar.ygs == null || bVar.ygs == null)) {
                bVar.ygs.setCallback(null);
            }
            bVar.ygs = null;
            Rect rect = bVar.ygq;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.ygx = rect.width();
                bVar.ygB = rect.height();
            } else {
                bVar.ygB = 0;
                bVar.ygx = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.ygy = rect.width();
                bVar.ygC = rect.height();
                bVar.ygz = 0;
                bVar.ygv = 0;
                bVar.ygA = 0;
                bVar.ygw = 0;
            }
            bVar.ygC = 0;
            bVar.ygy = 0;
            bVar.ygz = 0;
            bVar.ygv = 0;
            bVar.ygA = 0;
            bVar.ygw = 0;
        } else if (bVar != null) {
            if (bVar.ygD == 0) {
                this.ygc = null;
            } else {
                if (bVar.ygt != null) {
                    bVar.ygt.setCallback(null);
                }
                bVar.ygt = null;
                if (bVar.ygr != null) {
                    bVar.ygr.setCallback(null);
                }
                bVar.ygr = null;
                if (bVar.ygu != null) {
                    bVar.ygu.setCallback(null);
                }
                bVar.ygu = null;
                if (bVar.ygs != null) {
                    bVar.ygs.setCallback(null);
                }
                bVar.ygs = null;
                bVar.ygB = 0;
                bVar.ygx = 0;
                bVar.ygC = 0;
                bVar.ygy = 0;
                bVar.ygz = 0;
                bVar.ygv = 0;
                bVar.ygA = 0;
                bVar.ygw = 0;
            }
        }
        invalidate();
    }

    public final void ES(int i) {
        if (i != this.ygh) {
            this.ygh = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.ygc == null || this.ygc.ygt != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(drawable, null);
            }
        }
    }

    public final void ET(int i) {
        if (i != this.ygi) {
            this.ygi = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.ygc == null || this.ygc.ygu != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(null, drawable);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ek != null && this.ek.isStateful()) {
            updateTextColors();
        }
        b bVar = this.ygc;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.ygr != null && bVar.ygr.isStateful()) {
                bVar.ygr.setState(drawableState);
            }
            if (bVar.ygs != null && bVar.ygs.isStateful()) {
                bVar.ygs.setState(drawableState);
            }
            if (bVar.ygt != null && bVar.ygt.isStateful()) {
                bVar.ygt.setState(drawableState);
            }
            if (bVar.ygu != null && bVar.ygu.isStateful()) {
                bVar.ygu.setState(drawableState);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.ygc == null) {
            return verifyDrawable;
        }
        return drawable == this.ygc.ygt || drawable == this.ygc.ygr || drawable == this.ygc.ygu || drawable == this.ygc.ygs;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.ygc;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.ygt) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.ygB) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.ygu) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.ygy;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.ygC) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.ygr) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.ygz) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.ygs) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.ygA) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.ygw;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
    }

    private int getCompoundPaddingTop() {
        b bVar = this.ygc;
        if (bVar == null || bVar.ygr == null || !this.ygf) {
            return getPaddingTop();
        }
        return bVar.ygv + (getPaddingTop() + bVar.ygD);
    }

    private int getCompoundPaddingBottom() {
        b bVar = this.ygc;
        if (bVar == null || bVar.ygs == null || !this.ygg) {
            return getPaddingBottom();
        }
        return bVar.ygw + (getPaddingBottom() + bVar.ygD);
    }

    private int getCompoundPaddingLeft() {
        b bVar = this.ygc;
        if (bVar == null || bVar.ygt == null || !this.ygd) {
            return getPaddingLeft();
        }
        return bVar.ygx + (getPaddingLeft() + bVar.ygD);
    }

    private int getCompoundPaddingRight() {
        b bVar = this.ygc;
        if (bVar == null || bVar.ygu == null || !this.yge) {
            return getPaddingRight();
        }
        return bVar.ygy + (getPaddingRight() + bVar.ygD);
    }

    private int getExtendedPaddingTop() {
        if (this.yfL == null || this.yfP != 1) {
            return getCompoundPaddingTop();
        }
        if (this.yfL.getLineCount() <= this.yfO) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.yfL.getLineTop(this.yfO);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    private int getExtendedPaddingBottom() {
        if (this.yfL == null || this.yfP != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.yfL.getLineCount() <= this.yfO) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.yfL.getLineTop(this.yfO);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            cpZ();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public final void O(float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(0, f, system.getDisplayMetrics());
        if (applyDimension != this.gu.getTextSize()) {
            this.gu.setTextSize(applyDimension);
            this.yfZ = this.gu.getFontMetricsInt();
            this.yfY = (int) (Math.ceil((double) (this.yfZ.descent - this.yfZ.ascent)) + 2.0d);
            if (this.yfL != null) {
                cpZ();
                requestLayout();
                invalidate();
            }
        }
    }

    public final void setTextColor(int i) {
        this.ek = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        } else if (this.ek != colorStateList) {
            this.ek = colorStateList;
            updateTextColors();
        }
    }

    public final void Eg() {
        Object obj = null;
        if (5 != (this.ug & 7)) {
            obj = 1;
        }
        if (53 != this.ug) {
            invalidate();
        }
        this.ug = 53;
        if (this.yfL != null && r0 != null) {
            eT(this.yfL.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    private void updateTextColors() {
        int i = 0;
        int colorForState = this.ek.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yfE) {
            this.yfE = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
    }

    public final void setText(CharSequence charSequence) {
        int i = this.yfJ;
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(this.mText)) {
            int i2;
            if (charSequence instanceof Spanned) {
                this.yfX = false;
            } else {
                this.yfX = true;
            }
            if (i == a.ygo || this.yfK != null) {
                charSequence = this.yfF.newEditable(charSequence);
            } else if (i == a.ygn) {
                charSequence = this.yfG.newSpannable(charSequence);
            }
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.ygb) {
                if (this.yfS) {
                    i2 = this.iX;
                    if (getMeasuredWidth() > 0) {
                        i2 = Math.min(this.iX, getMeasuredWidth());
                    }
                    charSequence = TextUtils.ellipsize(charSequence, this.gu, (float) (i2 - compoundPaddingLeft), TruncateAt.END);
                } else if (getMeasuredWidth() > 0) {
                    charSequence = TextUtils.ellipsize(charSequence, this.gu, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
                } else {
                    this.yga = true;
                }
            }
            this.yfJ = i;
            this.mText = charSequence;
            this.yfI = charSequence;
            if (this.yfX) {
                cqb();
                invalidate();
                return;
            }
            if (getWidth() != 0) {
                if (this.yfL == null) {
                    cqa();
                    if (this.yfL.getHeight() != getHeight()) {
                        requestLayout();
                    }
                    invalidate();
                    return;
                }
                i2 = this.yfL.getHeight();
                i = this.yfL.getWidth();
                eT(i, i - compoundPaddingLeft);
                if (this.yfH != TruncateAt.MARQUEE) {
                    if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                        i = this.yfL.getHeight();
                        if (i == i2 && i == getHeight()) {
                            invalidate();
                            return;
                        }
                    }
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.yga && getMeasuredWidth() > 0) {
            setText(TextUtils.ellipsize(this.mText, this.gu, (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            this.yga = false;
        }
    }

    private int cpY() {
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        Layout layout = this.yfL;
        if (i == 48) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 80) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.ygc;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.ygd && bVar.ygt != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.ygB) / 2)));
                bVar.ygt.draw(canvas);
                canvas.restore();
            }
            if (this.yge && bVar.ygu != null) {
                float measureText;
                canvas.save();
                if (this.yfX) {
                    measureText = this.gu.measureText(this.mText, 0, this.mText.length());
                    f = measureText;
                } else {
                    measureText = (float) Math.ceil((double) Layout.getDesiredWidth(this.yfI, this.gu));
                }
                canvas.translate((measureText + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((compoundPaddingTop + scrollY) + ((i - bVar.ygC) / 2)));
                bVar.ygu.draw(canvas);
                canvas.restore();
            }
            if (this.ygf && bVar.ygr != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.ygz) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.ygr.draw(canvas);
                canvas.restore();
            }
            if (this.ygg && bVar.ygs != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.ygA) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.ygw));
                bVar.ygs.draw(canvas);
                canvas.restore();
            }
        }
        this.gu.setColor(this.yfE);
        this.gu.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f2 = (float) (extendedPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f2, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        compoundPaddingTop = 0;
        compoundPaddingBottom = 0;
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            compoundPaddingTop = cpY();
            compoundPaddingBottom = cpY();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + compoundPaddingTop));
        if (this.yfX) {
            float f3 = (float) (((height - (this.yfZ.bottom - this.yfZ.top)) / 2) - this.yfZ.top);
            compoundPaddingBottom = 0;
            if ((this.ug & 7) != 3) {
                switch (this.ug & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.gu.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.gu.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f3, this.gu);
        } else {
            if (this.yfL == null) {
                cqa();
            }
            this.yfL.draw(canvas, null, null, compoundPaddingBottom - compoundPaddingTop);
        }
        canvas.restore();
    }

    public void getFocusedRect(Rect rect) {
        if (this.yfL == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = Selection.getSelectionEnd(this.mText);
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int lineForOffset = this.yfL.getLineForOffset(selectionEnd);
        rect.top = this.yfL.getLineTop(lineForOffset);
        rect.bottom = this.yfL.getLineBottom(lineForOffset);
        rect.left = (int) this.yfL.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            selectionEnd += cpY();
        }
        rect.offset(lineForOffset, selectionEnd);
    }

    public int getBaseline() {
        if (this.yfL == null) {
            return super.getBaseline();
        }
        int cpY;
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            cpY = cpY();
        } else {
            cpY = 0;
        }
        return (cpY + getExtendedPaddingTop()) + this.yfL.getLineBaseline(0);
    }

    private void cpZ() {
        if ((this.yfL instanceof BoringLayout) && this.yfW == null) {
            this.yfW = (BoringLayout) this.yfL;
        }
        this.yfL = null;
    }

    private void cqa() {
        int compoundPaddingLeft;
        if (this.yfS) {
            compoundPaddingLeft = (this.iX - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        eT(compoundPaddingLeft, compoundPaddingLeft);
    }

    private void eT(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.ug & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.yfH == null || this.yfK != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.yfL = new StaticLayout(this.yfI, 0, this.yfI.length(), this.gu, i3, alignment, this.yfM, this.yfN, this.yfV, this.yfH, i2);
        } else {
            this.yfL = new StaticLayout(this.yfI, this.gu, i3, alignment, this.yfM, this.yfN, this.yfV);
        }
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.yfY);
        } else if (this.yfX) {
            if (this.yfY == 0) {
                cqb();
            }
            setMeasuredDimension(size, this.yfY);
        } else {
            int i3;
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.yfS) {
                compoundPaddingLeft = this.iX - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.yfL == null) {
                eT(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                if (this.yfL.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    eT(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == 1073741824) {
                this.yfU = -1;
                compoundPaddingLeft = size2;
            } else {
                Layout layout = this.yfL;
                if (layout == null) {
                    compoundPaddingLeft = 0;
                } else {
                    i3 = layout.getLineCount();
                    int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
                    compoundPaddingLeft = layout.getLineTop(i3) + compoundPaddingBottom;
                    if (this.yfP != 1) {
                        compoundPaddingLeft = Math.min(compoundPaddingLeft, this.yfO);
                    } else if (i3 > this.yfO) {
                        compoundPaddingLeft = (layout.getLineTop(this.yfO) + layout.getBottomPadding()) + compoundPaddingBottom;
                        i3 = this.yfO;
                    }
                    if (this.yfR != 1) {
                        compoundPaddingLeft = Math.max(compoundPaddingLeft, this.yfQ);
                    } else if (i3 < this.yfQ) {
                        compoundPaddingLeft += (this.yfQ - i3) * Math.round((((float) this.gu.getFontMetricsInt(null)) * this.yfM) + this.yfN);
                    }
                    compoundPaddingLeft = Math.max(compoundPaddingLeft, getSuggestedMinimumHeight());
                }
                this.yfU = compoundPaddingLeft;
                if (mode == Integer.MIN_VALUE) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
        }
    }

    private void cqb() {
        if (this.yfY == 0) {
            this.yfY = (int) (Math.ceil((double) (this.yfZ.descent - this.yfZ.ascent)) + 2.0d);
        }
    }

    public final void cpw() {
        this.ydi = true;
        this.yfQ = 1;
        this.yfO = 1;
        this.yfR = 1;
        this.yfP = 1;
        requestLayout();
        invalidate();
    }

    public final void setEllipsize(TruncateAt truncateAt) {
        this.yfH = truncateAt;
        if (this.yfL != null) {
            cpZ();
            requestLayout();
            invalidate();
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.yfL != null) {
            return this.yfL.getWidth();
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollRange() {
        if (this.yfL != null) {
            return this.yfL.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bh.ov((String) contentDescription)) {
            contentDescription = this.mText;
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}
