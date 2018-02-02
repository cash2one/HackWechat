package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

class z$b extends View {
    private Paint fC;
    private int lee = 25;
    private int mHeight = (this.tUy * 2);
    int mWidth = (this.tUy * 2);
    private int tUy = (this.yhd.ygW / 2);
    final /* synthetic */ z yhd;
    public PopupWindow yhg;
    boolean yhh;
    private int yhi;
    private int yhj;
    private int yhk;
    private int yhl;
    int[] yhm = new int[2];

    public z$b(z zVar, boolean z) {
        this.yhd = zVar;
        super(zVar.mContext);
        this.yhh = z;
        this.fC = new Paint(1);
        this.fC.setColor(zVar.mContext.getResources().getColor(zVar.ygV));
        this.yhg = new PopupWindow(this);
        this.yhg.setClippingEnabled(false);
        this.yhg.setWidth(this.mWidth + (this.lee * 2));
        this.yhg.setHeight(this.mHeight + (this.lee / 2));
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawCircle((float) (this.tUy + this.lee), (float) this.tUy, (float) this.tUy, this.fC);
        if (this.yhh) {
            canvas.drawRect((float) (this.tUy + this.lee), 0.0f, (float) ((this.tUy * 2) + this.lee), (float) this.tUy, this.fC);
            return;
        }
        canvas.drawRect((float) this.lee, 0.0f, (float) (this.tUy + this.lee), (float) this.tUy, this.fC);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.yhk = this.yhd.ygO.Ww;
                this.yhl = this.yhd.ygO.wq;
                this.yhi = (int) motionEvent.getX();
                this.yhj = (int) motionEvent.getY();
                break;
            case 1:
            case 3:
                this.yhd.cqe();
                break;
            case 2:
                this.yhd.ygR.cro();
                int rawX = (((int) motionEvent.getRawX()) + this.yhi) - this.mWidth;
                int rawY = (this.yhj + ((int) motionEvent.getRawY())) - this.mHeight;
                this.yhd.kO.getLocationInWindow(this.yhm);
                int i = this.yhh ? this.yhd.ygO.Ww : this.yhd.ygO.wq;
                int i2 = rawY - this.yhm[1];
                TextView textView = this.yhd.kO;
                Layout layout = textView.getLayout();
                if (layout != null) {
                    int lineRight;
                    int lineBottom;
                    int i3;
                    int lineForVertical = layout.getLineForVertical(i2);
                    if (ab.a(layout, i)) {
                        lineRight = (int) layout.getLineRight(lineForVertical);
                        if (rawX > lineRight - ((lineRight - ((int) layout.getPrimaryHorizontal(i - 1))) / 2)) {
                            rawY = i - 1;
                            rawY = layout.getLineForOffset(rawY);
                            lineRight = layout.getLineTop(rawY);
                            lineBottom = layout.getLineBottom(rawY);
                            i3 = (lineBottom - lineRight) / 2;
                            if ((lineForVertical != rawY + 1 || i2 - lineBottom >= i3) && (lineForVertical != rawY - 1 || lineRight - i2 >= i3)) {
                                rawY = lineForVertical;
                            }
                            lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                            if (lineForVertical < textView.getText().length() - 1 && ab.a(layout, lineForVertical + 1)) {
                                rawY = (int) layout.getLineRight(rawY);
                                if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                                    rawY = lineForVertical + 1;
                                }
                            }
                            rawY = lineForVertical;
                        }
                    }
                    rawY = i;
                    rawY = layout.getLineForOffset(rawY);
                    lineRight = layout.getLineTop(rawY);
                    lineBottom = layout.getLineBottom(rawY);
                    i3 = (lineBottom - lineRight) / 2;
                    rawY = lineForVertical;
                    lineForVertical = layout.getOffsetForHorizontal(rawY, (float) rawX);
                    rawY = (int) layout.getLineRight(rawY);
                    if (rawX > rawY - ((rawY - ((int) layout.getPrimaryHorizontal(lineForVertical))) / 2)) {
                        rawY = lineForVertical + 1;
                    }
                    rawY = lineForVertical;
                    break;
                }
                rawY = -1;
                if (rawY != i) {
                    this.yhd.cqd();
                    z$b a;
                    if (!this.yhh) {
                        if (rawY < this.yhk) {
                            a = z.a(this.yhd, true);
                            a.cqf();
                            cqf();
                            this.yhl = this.yhk;
                            this.yhd.eU(rawY, this.yhk);
                            a.cqg();
                        } else {
                            this.yhd.eU(this.yhk, rawY);
                        }
                        cqg();
                        break;
                    }
                    if (rawY > this.yhl) {
                        a = z.a(this.yhd, false);
                        cqf();
                        a.cqf();
                        this.yhk = this.yhl;
                        this.yhd.eU(this.yhl, rawY);
                        a.cqg();
                    } else {
                        this.yhd.eU(rawY, -1);
                    }
                    cqg();
                    break;
                }
                break;
        }
        return true;
    }

    private void cqf() {
        this.yhh = !this.yhh;
        invalidate();
    }

    private void cqg() {
        this.yhd.kO.getLocationInWindow(this.yhm);
        Layout layout = this.yhd.kO.getLayout();
        if (this.yhh) {
            this.yhg.update((((int) layout.getPrimaryHorizontal(this.yhd.ygO.Ww)) - this.mWidth) + cqh(), layout.getLineBottom(layout.getLineForOffset(this.yhd.ygO.Ww)) + cqi(), -1, -1);
            return;
        }
        int[] eV = eV((int) layout.getPrimaryHorizontal(this.yhd.ygO.wq), layout.getLineBottom(layout.getLineForOffset(this.yhd.ygO.wq)));
        this.yhg.update(eV[0] + cqh(), eV[1] + cqi(), -1, -1);
    }

    public final int cqh() {
        return (this.yhm[0] - this.lee) + this.yhd.kO.getPaddingLeft();
    }

    public final int cqi() {
        return this.yhm[1] + this.yhd.kO.getPaddingTop();
    }

    final int[] eV(int i, int i2) {
        int[] iArr = new int[2];
        if (i == 0 && this.yhd.ygO.wq > 1) {
            this.yhd.kO.getLocationInWindow(this.yhm);
            Layout layout = this.yhd.kO.getLayout();
            if (layout != null) {
                i = (int) layout.getLineWidth(layout.getLineForOffset(this.yhd.ygO.wq - 1));
                i2 = layout.getLineBottom(layout.getLineForOffset(this.yhd.ygO.wq - 1));
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}
