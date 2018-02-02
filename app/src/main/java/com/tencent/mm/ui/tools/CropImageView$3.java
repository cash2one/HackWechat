package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.g;
import java.util.Timer;

class CropImageView$3 implements OnTouchListener {
    final /* synthetic */ CropImageView zhQ;

    CropImageView$3(CropImageView cropImageView) {
        this.zhQ = cropImageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!CropImageView.u(this.zhQ) || CropImageView.i(this.zhQ) == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        x.d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + CropImageView.v(this.zhQ));
        if (!CropImageView.v(this.zhQ) && action != 0) {
            return false;
        }
        switch (action) {
            case 0:
                x.d("MicroMsg.CropImageView", "action_down");
                CropImageView.a(this.zhQ, motionEvent.getRawX());
                CropImageView.b(this.zhQ, motionEvent.getRawY());
                x.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(this.zhQ) + ",lastY=" + CropImageView.x(this.zhQ));
                CropImageView.c(this.zhQ, CropImageView.w(this.zhQ));
                CropImageView.d(this.zhQ, CropImageView.x(this.zhQ));
                Matrix imageMatrix = this.zhQ.getImageMatrix();
                RectF rectF = new RectF();
                rectF.set(0.0f, 0.0f, (float) CropImageView.i(this.zhQ).getWidth(), (float) CropImageView.i(this.zhQ).getHeight());
                imageMatrix.mapRect(rectF);
                CropImageView.a(this.zhQ, rectF.contains(CropImageView.w(this.zhQ), CropImageView.x(this.zhQ)));
                CropImageView.a(this.zhQ, System.currentTimeMillis());
                return false;
            case 1:
                x.d("MicroMsg.CropImageView", "action_up");
                if (CropImageView.z(this.zhQ)) {
                    CropImageView.c(this.zhQ, false);
                    if (CropImageView.A(this.zhQ)) {
                        CropImageView.d(this.zhQ, false);
                        this.zhQ.cxK();
                        this.zhQ.cxK();
                        this.zhQ.cxK();
                        this.zhQ.cxK();
                        this.zhQ.cxK();
                        return false;
                    }
                    CropImageView.d(this.zhQ, true);
                    this.zhQ.cxJ();
                    this.zhQ.cxJ();
                    this.zhQ.cxJ();
                    this.zhQ.cxJ();
                    this.zhQ.cxJ();
                    return false;
                }
                CropImageView.c(this.zhQ, true);
                CropImageView.a(this.zhQ, new Timer());
                CropImageView.B(this.zhQ).schedule(new 1(this, motionEvent), 200);
                return false;
            case 2:
                float f;
                x.d("MicroMsg.CropImageView", "action_move");
                if (this.zhQ.zhx) {
                    x.d("MicroMsg.CropImageView", "is valid mult down");
                    this.zhQ.nqV = g.J(motionEvent);
                    f = this.zhQ.nqV - this.zhQ.nqU;
                    if (this.zhQ.nqV > 5.0f && Math.abs(f) > 5.0f) {
                        g.a(CropImageView.h(this.zhQ), motionEvent);
                        x.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(this.zhQ).x + ",mY=" + CropImageView.h(this.zhQ).y);
                        if (f > 0.0f) {
                            x.d("MicroMsg.CropImageView", "zoom in");
                            this.zhQ.cxJ();
                        } else {
                            x.d("MicroMsg.CropImageView", "zoom out");
                            this.zhQ.cxK();
                        }
                    }
                    this.zhQ.nqU = this.zhQ.nqV;
                }
                if (!CropImageView.y(this.zhQ)) {
                    f = motionEvent.getRawX() - CropImageView.w(this.zhQ);
                    float rawY = motionEvent.getRawY() - CropImageView.x(this.zhQ);
                    if (Math.abs(f) > 5.0f || Math.abs(rawY) > 5.0f) {
                        this.zhQ.getImageMatrix().postTranslate(f, rawY);
                    }
                    this.zhQ.invalidate();
                }
                CropImageView.b(this.zhQ, false);
                CropImageView.a(this.zhQ, motionEvent.getRawX());
                CropImageView.b(this.zhQ, motionEvent.getRawY());
                return false;
            case 5:
                x.d("MicroMsg.CropImageView", "action_mult_down");
                CropImageView.b(this.zhQ, true);
                this.zhQ.nqU = g.J(motionEvent);
                if (this.zhQ.nqU <= 5.0f) {
                    return false;
                }
                this.zhQ.zhx = true;
                g.a(CropImageView.h(this.zhQ), motionEvent);
                return true;
            case 6:
                x.d("MicroMsg.CropImageView", "action_mult_up");
                this.zhQ.zhx = false;
                CropImageView.b(this.zhQ, true);
                return true;
            default:
                return false;
        }
    }
}
