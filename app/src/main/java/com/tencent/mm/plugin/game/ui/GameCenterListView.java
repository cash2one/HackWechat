package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Scroller;
import com.tencent.mm.R;

public class GameCenterListView extends ListView {
    static boolean nmG;
    static int nmI;
    private View Lr;
    private Context mContext;
    private boolean nmC;
    private float nmD;
    private int nmE;
    private boolean nmF;
    private boolean nmH;
    private ImageView nmJ;
    private ImageView nmK;
    private Scroller yJ;

    public GameCenterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nmE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.yJ = new Scroller(this.mContext);
        super.setOnScrollListener(new 1(this));
    }

    public static void fG(boolean z) {
        nmG = z;
    }

    public static void qS(int i) {
        nmI = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.nmC) {
            this.Lr = getChildAt(0);
            this.nmK = (ImageView) this.Lr.findViewById(R.h.cOM);
            this.nmJ = (ImageView) this.Lr.findViewById(R.h.bMX);
            this.nmC = true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!nmG || this.Lr == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nmH = false;
                this.nmD = motionEvent.getRawY();
                break;
            case 2:
                if (this.nmF) {
                    if (this.nmH) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nmD);
                    if (this.Lr.getPaddingTop() <= nmI + this.nmE) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nmE) {
                            this.nmH = true;
                            this.yJ.startScroll(0, this.Lr.getPaddingTop(), 0, -this.Lr.getPaddingTop(), 500);
                            this.nmJ.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Lr.getPaddingTop() >= (-this.nmE) && rawY < 0 && Math.abs(rawY) >= this.nmE) {
                        this.nmH = true;
                        this.yJ.startScroll(0, 0, 0, nmI, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Lr != null && this.yJ.computeScrollOffset()) {
            int currY = this.yJ.getCurrY();
            this.Lr.setPadding(0, currY, 0, 0);
            float f = (((float) (nmI - currY)) / ((float) nmI)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nmK.setAlpha(i);
            this.nmJ.setAlpha(currY);
            invalidate();
        }
    }
}
