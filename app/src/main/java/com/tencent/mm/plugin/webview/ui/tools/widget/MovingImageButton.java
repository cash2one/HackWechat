package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

public class MovingImageButton extends ImageView {
    private int jED;
    private int jEE;
    private int kDP;
    private int kDQ;
    private Context mContext;
    private int nmE;
    private int tKA = 0;
    private MarginLayoutParams tKB;
    private final int tKC = 100;
    private int tKD;
    private boolean tKE = false;
    public boolean tKF = true;
    private int tKx;
    private int tKy;
    private int tKz = 0;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.tKD = a.fromDPToPix(this.mContext, 100);
        this.kDP = a.eA(this.mContext);
        this.kDQ = a.eB(this.mContext);
        this.nmE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.tKF) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.tKz == 0 || this.tKA == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.tKz = rect.right - rect.left;
            this.tKA = rect.bottom - rect.top;
            x.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[]{Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.tKz), Integer.valueOf(this.tKA)});
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.tKx = this.x;
                this.tKy = this.y;
                break;
            case 1:
                if (Math.abs(this.tKx - this.x) + Math.abs(this.tKy - this.y) <= this.nmE) {
                    performClick();
                    break;
                }
                if (this.y < this.tKD) {
                    this.tKB.topMargin = 0;
                } else if (this.y > this.tKA - this.tKD) {
                    this.tKB.topMargin = this.tKA - getHeight();
                } else if (this.x > this.tKz / 2) {
                    this.tKB.rightMargin = 0;
                } else {
                    this.tKB.rightMargin = this.tKz - getWidth();
                }
                requestLayout();
                break;
            case 2:
                int i = this.x - this.jED;
                int i2 = this.y - this.jEE;
                if (!(i == 0 && i2 == 0)) {
                    this.tKB = (MarginLayoutParams) getLayoutParams();
                    MarginLayoutParams marginLayoutParams = this.tKB;
                    marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                    marginLayoutParams = this.tKB;
                    marginLayoutParams.topMargin += i2;
                    if (this.tKB.rightMargin < 0) {
                        this.tKB.rightMargin = 0;
                    } else if (this.tKB.rightMargin > this.tKz - getWidth()) {
                        this.tKB.rightMargin = this.tKz - getWidth();
                    }
                    if (this.tKB.topMargin < 0) {
                        this.tKB.topMargin = 0;
                    } else if (this.tKB.topMargin > this.tKA - getHeight()) {
                        this.tKB.topMargin = this.tKA - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.jED = this.x;
        this.jEE = this.y;
        return true;
    }
}
