package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.b.d;
import com.tencent.mm.b.d.1;
import com.tencent.mm.b.d.2;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    private d zEP = new d(this);
    private PointF zEQ = new PointF();
    private float zER = 0.0f;
    private float zES = 0.0f;
    private boolean zET = false;
    public boolean zEU = false;

    public b(Context context, com.tencent.mm.bo.b bVar) {
        super(context, bVar);
    }

    public final boolean cAt() {
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(uR());
        canvas.save();
        canvas.clipRect(cAu());
        Bitmap cdm = this.fhY.cdm();
        if (!(cdm == null || cdm.isRecycled())) {
            canvas.drawBitmap(cdm, 0.0f, 0.0f, null);
        }
        canvas.restore();
        this.fhY.onDraw(canvas);
    }

    protected final void R(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
        float centerX;
        float cAx;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.zEQ.set(x, y);
                this.zER = 0.0f;
                this.zES = cdl();
                d dVar = this.zEP;
                x.d("MicroMsg.StickRoundAnim", "[cancel]");
                if (dVar.fcO != null && (dVar.fcO.isRunning() || dVar.fcO.isStarted())) {
                    dVar.fcO.cancel();
                }
                this.zEU = false;
                break;
            case 1:
                this.zER = 0.0f;
                if (this.zEU) {
                    com.tencent.mm.b.b bVar = this.zEP;
                    if (bVar.fdb) {
                        x.d("MicroMsg.StickRoundAnim", "[play] start");
                        RectF cAw = bVar.fdj.cAw();
                        Rect rect = bVar.fdj.zEC;
                        bVar.fdk = cAw.centerX();
                        bVar.fdl = cAw.centerY();
                        float centerY = ((float) rect.centerY()) - cAw.centerY();
                        centerX = ((float) rect.centerX()) - cAw.centerX();
                        float cdl = bVar.fdj.cdl();
                        float cAy = bVar.fdj.cAy();
                        cAx = bVar.fdj.cAx();
                        if (cdl > cAy) {
                            bVar.gr = cAy;
                            bVar.fdm = true;
                        } else if (cdl < cAx) {
                            bVar.gr = cAx;
                            bVar.fdm = true;
                        } else {
                            bVar.fdm = false;
                        }
                        Object obj = ((float) rect.height()) < cAw.height() ? 1 : null;
                        Object obj2 = ((float) rect.width()) < cAw.width() ? 1 : null;
                        if (obj != null) {
                            centerY = 0.0f;
                        }
                        if (obj2 != null) {
                            centerX = 0.0f;
                        }
                        cAx = (cAw.top <= ((float) rect.top) || obj == null) ? (cAw.bottom >= ((float) rect.bottom) || obj == null) ? centerY : ((float) rect.bottom) - cAw.bottom : ((float) rect.top) - cAw.top;
                        if (cAw.left > ((float) rect.left) && obj2 != null) {
                            centerX = ((float) rect.left) - cAw.left;
                        } else if (cAw.right < ((float) rect.right) && obj2 != null) {
                            centerX = ((float) rect.right) - cAw.right;
                        }
                        x.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[]{Float.valueOf(centerX), Float.valueOf(cAx)});
                        if (cdl > cAy) {
                            bVar.fdn = true;
                        } else {
                            bVar.fdn = false;
                        }
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, cAx});
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, centerX});
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 80.0f});
                        bVar.fcO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
                        bVar.fcO.addUpdateListener(new 1(bVar, cdl));
                        bVar.fcO.addListener(new 2(bVar));
                        bVar.fcO.setInterpolator(new LinearInterpolator());
                        bVar.fcO.setDuration(80);
                        bVar.fcO.start();
                        break;
                    }
                }
                break;
            case 2:
                if (!this.zET) {
                    if (motionEvent.getPointerCount() != 2) {
                        if (motionEvent.getPointerCount() == 1 && cAs()) {
                            this.zEU = true;
                            this.zEP.fdb = true;
                            translate(x, y);
                            postInvalidate();
                            break;
                        }
                    }
                    this.zEU = true;
                    cAx = motionEvent.getX(0) - motionEvent.getX(1);
                    centerX = motionEvent.getY(0) - motionEvent.getY(1);
                    cAx = (float) Math.sqrt((double) ((cAx * cAx) + (centerX * centerX)));
                    if (this.zER != 0.0f) {
                        cAx = (cAx / this.zER) * this.zES;
                        if (this.zEG * 0.5f <= cAx) {
                            if (cAx > this.zEF) {
                                cAx = ((cAx - this.zEF) * 0.2f) + this.zEF;
                            }
                            uR().postScale(cAx / cdl(), cAx / cdl(), x, y);
                        }
                        this.zEP.fdb = true;
                        translate(x, y);
                        postInvalidate();
                        break;
                    }
                    this.zER = cAx;
                    break;
                }
                this.zET = false;
                return;
            case 5:
                this.zER = 0.0f;
                this.zES = cdl();
                break;
            case 6:
                this.zER = 0.0f;
                this.zET = true;
                break;
        }
        this.zEQ.x = x;
        this.zEQ.y = y;
    }

    private void translate(float f, float f2) {
        RectF cAw = cAw();
        float f3 = f - this.zEQ.x;
        float f4 = f2 - this.zEQ.y;
        if (f3 > 0.0f) {
            if (((float) this.zEC.left) <= cAw.left) {
                f3 *= 0.5f;
            } else if (Math.abs(f3) > Math.abs(cAw.left - ((float) this.zEC.left))) {
                f3 = ((float) this.zEC.left) - cAw.left;
            }
        } else if (((float) this.zEC.right) >= cAw.right) {
            f3 *= 0.5f;
        } else if (Math.abs(f3) > Math.abs(((float) this.zEC.right) - cAw.right)) {
            f3 = ((float) this.zEC.right) - cAw.right;
        }
        if (f4 > 0.0f) {
            if (((float) this.zEC.top) <= cAw.top) {
                f4 *= 0.5f;
            } else if (Math.abs(f4) > Math.abs(cAw.top - ((float) this.zEC.top))) {
                f4 = ((float) this.zEC.top) - cAw.top;
            }
        } else if (((float) this.zEC.bottom) >= cAw.bottom) {
            f4 *= 0.5f;
        } else if (Math.abs(f4) > Math.abs(((float) this.zEC.bottom) - cAw.bottom)) {
            f4 = ((float) this.zEC.bottom) - cAw.bottom;
        }
        uR().postTranslate(f3, f4);
    }

    public final float cAx() {
        if (this.fhY.cdj().uG() != a.fhV) {
            return super.cAx();
        }
        float width = ((float) this.zEC.width()) / cAw().width();
        float height = ((float) this.zEC.height()) / cAw().height();
        if (width <= height) {
            width = height;
        }
        return width * cdl();
    }
}
