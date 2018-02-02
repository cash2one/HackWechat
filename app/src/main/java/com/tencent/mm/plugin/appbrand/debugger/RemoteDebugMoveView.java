package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mm.bv.a;

public class RemoteDebugMoveView extends FrameLayout {
    int iQI;
    int iQJ;
    float iQK;
    float iQL;
    float iQM;
    float iQN;

    static /* synthetic */ int b(RemoteDebugMoveView remoteDebugMoveView) {
        int width = remoteDebugMoveView.getWidth();
        return width > 0 ? width : a.fromDPToPix(remoteDebugMoveView.getContext(), 200);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.iQK = motionEvent.getRawX();
                this.iQL = motionEvent.getRawY();
                break;
            case 2:
                this.iQM = motionEvent.getRawX();
                this.iQN = motionEvent.getRawY();
                float x = getX() + (this.iQM - this.iQK);
                if (0.0f < x && x < ((float) (this.iQI - getWidth()))) {
                    setX(x);
                }
                x = this.iQN - this.iQL;
                float height = (float) (this.iQJ - getHeight());
                float y = getY() + x;
                if ((0.0f < y && y < height) || ((y <= 0.0f && x > 0.0f) || (y >= height && x < 0.0f))) {
                    setY(y);
                }
                this.iQK = this.iQM;
                this.iQL = this.iQN;
                break;
        }
        return true;
    }
}
