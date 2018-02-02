package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bj.a.c;
import com.tencent.smtt.sdk.WebView;

public class SelectColorBar extends View {
    public static final int[] zFl = new int[]{-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private Paint gNB;
    private Paint zDB = new Paint(1);
    private final float zEV = getResources().getDimension(c.vbi);
    public a zFM;
    private int zFN = -1;
    private Rect[] zFh;
    private boolean zFo = true;

    public SelectColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zDB.setColor(-16711936);
        this.zFh = new Rect[zFl.length];
        this.gNB = new Paint(1);
        this.gNB.setStyle(Style.FILL);
        this.gNB.setStrokeCap(Cap.ROUND);
    }

    public final void Hu(int i) {
        for (int i2 = 0; i2 < zFl.length; i2++) {
            if (zFl[i2] == i) {
                this.zFN = i2;
                break;
            }
        }
        this.zFo = false;
        postInvalidate();
    }

    protected void onMeasure(int i, int i2) {
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec((int) getResources().getDimension(c.vaZ), 1073741824));
        if (this.zFh == null) {
            this.zFh = new Rect[zFl.length];
        }
        float dimension = getResources().getDimension(c.vbe);
        float measuredWidth = (((float) (getMeasuredWidth() - ((int) (this.zEV * 2.0f)))) - ((2.0f * dimension) * ((float) zFl.length))) / ((float) (zFl.length - 1));
        int i3 = (int) (dimension * 2.0f);
        int i4 = (int) ((((float) (((int) (this.zEV * 2.0f)) / 2)) + dimension) + 5.0f);
        int cAE = cAE() / 2;
        for (size = 0; size < zFl.length; size++) {
            this.zFh[size] = new Rect(i4 - i3, cAE - i3, i4 + i3, cAE + i3);
            i4 = (int) (((float) i4) + ((2.0f * dimension) + measuredWidth));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (i < this.zFh.length) {
                    if (this.zFh[i].contains(x, y)) {
                        this.zFN = i;
                        break;
                    }
                    i++;
                }
                break;
            case 1:
            case 3:
                while (this.zFh != null && i < this.zFh.length) {
                    if (this.zFh[i].contains(x, y) && i == this.zFN && this.zFM != null) {
                        this.zFM.Ho(zFl[i]);
                        break;
                    }
                    i++;
                }
                break;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        float dimension = getResources().getDimension(c.vbe);
        float measuredWidth = (((float) (getMeasuredWidth() - ((int) (this.zEV * 2.0f)))) - ((2.0f * dimension) * ((float) zFl.length))) / ((float) (zFl.length - 1));
        float cAE = (1.0f * ((float) cAE())) / 2.0f;
        float f = (((float) (((int) (this.zEV * 2.0f)) / 2)) + dimension) + 5.0f;
        int i = 0;
        while (i < zFl.length) {
            float f2 = 0.0f;
            if (this.zFN == i) {
                this.zFo = false;
                f2 = 6.0f;
            } else if (this.zFo && i == 2) {
                f2 = 6.0f;
            }
            this.gNB.setColor(-1);
            canvas.drawCircle(f, cAE, (dimension + 5.0f) + f2, this.gNB);
            this.gNB.setColor(zFl[i]);
            canvas.drawCircle(f, cAE, f2 + dimension, this.gNB);
            f += (2.0f * dimension) + measuredWidth;
            i++;
        }
    }

    private int cAE() {
        return (int) getResources().getDimension(c.vaZ);
    }
}
