package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView extends MMTagPanelScrollView {
    private int wM;
    boolean wY = true;
    float xd;
    float xe;
    float xf;
    float xg;
    boolean ySM = false;
    boolean ySN = true;
    boolean ySO = false;
    float ySP;
    float ySQ;
    float ySR;
    float ySS;
    public a yST;

    public interface a {
        void aDx();

        void aDy();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cvY();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cvY();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.ySN = true;
                this.ySQ = f2;
                this.ySP = f2;
                this.ySS = f3;
                this.ySR = f3;
                this.ySO = true;
                break;
            case 1:
            case 3:
                this.ySN = true;
                this.ySO = false;
                break;
            case 2:
                int i2 = (int) (f2 - this.ySP);
                actionIndex = (int) (f3 - this.ySR);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.wM) {
                    this.ySN = false;
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void cvY() {
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.wM = scaledTouchSlop * scaledTouchSlop;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.wY = true;
                this.xd = f2;
                this.xf = f2;
                this.xe = f3;
                this.xg = f3;
                this.ySM = true;
                break;
            case 1:
            case 3:
                if ((this.wY || !this.ySM) && this.yST != null) {
                    this.yST.aDx();
                }
                this.wY = true;
                this.ySM = false;
                break;
            case 2:
                if (!this.ySM) {
                    this.wY = true;
                    this.xd = f2;
                    this.xf = f2;
                    this.xe = f3;
                    this.xg = f3;
                    this.ySM = true;
                }
                if (this.yST != null) {
                    this.yST.aDy();
                }
                int i2 = (int) (f2 - this.xf);
                actionIndex = (int) (f3 - this.xg);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.wM) {
                    this.wY = false;
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
