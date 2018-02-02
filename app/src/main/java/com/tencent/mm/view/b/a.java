package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.bo.b;
import com.tencent.mm.sdk.platformtools.x;

public class a extends View {
    b fhY;
    protected Matrix fhZ;
    private boolean fiD = false;
    private Rect fia;
    Rect gNA;
    public float gNH = 1.0f;
    private float lEa;
    private float lEb;
    float[] values = new float[9];
    protected Matrix zEB;
    public Rect zEC;
    public Rect zED;
    private Runnable zEE;
    protected float zEF;
    protected float zEG;
    public boolean zEH = true;

    public a(Context context, b bVar) {
        super(context);
        this.fhY = bVar;
        this.fhZ = new Matrix();
        this.zEB = new Matrix();
        this.fia = new Rect();
        this.zEC = new Rect();
        this.zED = new Rect();
        this.gNA = new Rect();
        Bitmap cdm = bVar.cdm();
        if (cdm != null) {
            this.gNA.set(0, 0, cdm.getWidth(), cdm.getHeight());
            this.fia.set(this.gNA);
        }
        if (!cAt() && bVar.cdi().rect != null) {
            Rect rect = bVar.cdi().rect;
            this.fia.set(0, 0, rect.width(), rect.height());
            this.fhZ.postTranslate(0.0f, (float) rect.top);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.i("changelcai", "[onLayout] %s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.zEC.set(i, i2, i3, i4);
            this.zED.set(this.zEC);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(this.fhZ);
        this.fhY.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fhY.cdn()) {
            if (motionEvent.getAction() == 0) {
                this.lEa = motionEvent.getX();
                this.lEb = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                removeCallbacks(this.zEE);
                long j = 0;
                if (this.fiD) {
                    j = 700;
                }
                if (this.fhY.cdj().uG() != com.tencent.mm.d.a.fhU) {
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ a zEI;

                        {
                            this.zEI = r1;
                        }

                        public final void run() {
                            if (this.zEI.fhY.cdh().fdG) {
                                this.zEI.fhY.cdh().aB(false);
                                this.zEI.fhY.cdh().aC(false);
                                return;
                            }
                            this.zEI.fhY.cdh().aB(true);
                            this.zEI.fhY.cdh().aC(true);
                        }
                    };
                    this.zEE = anonymousClass1;
                    postDelayed(anonymousClass1, j);
                } else {
                    this.fhY.cdh().nH(true);
                    if (this.fhY.cdh().fdG) {
                        this.fhY.cdh().aB(false);
                        this.fhY.cdh().aC(false);
                    } else {
                        com.tencent.mm.view.a cdh = this.fhY.cdh();
                        boolean z = cdh.zDg.getVisibility() == 0 || cdh.cAi().getVisibility() == 0;
                        if (!z) {
                            this.fhY.cdh().aB(true);
                            this.fhY.cdh().aC(true);
                        }
                    }
                    this.fhY.cdh().cAe().cAI();
                }
                this.fiD = false;
            } else if (motionEvent.getAction() == 2) {
                if (Math.abs(motionEvent.getX() - this.lEa) >= 3.0f || Math.abs(motionEvent.getY() - this.lEb) >= 3.0f) {
                    this.fiD = true;
                    removeCallbacks(this.zEE);
                    if (this.fhY.cdh().fdG) {
                        this.fhY.cdh().aB(false);
                        this.fhY.cdh().aC(false);
                    }
                }
                this.lEa = motionEvent.getX();
                this.lEb = motionEvent.getY();
            }
        }
        if (!this.fhY.H(motionEvent) && cAt()) {
            R(motionEvent);
        }
        return true;
    }

    protected void R(MotionEvent motionEvent) {
    }

    protected boolean cAs() {
        return this.zEH;
    }

    public boolean cAt() {
        return true;
    }

    public Rect cAu() {
        return this.fia;
    }

    public final Matrix uR() {
        return this.fhZ;
    }

    public final void cAv() {
        float width;
        float height;
        Rect rect = this.gNA;
        if (a(this.fhZ) % 180.0f == 0.0f) {
            width = (((float) rect.width()) * 1.0f) / ((float) rect.height());
        } else {
            width = (((float) rect.height()) * 1.0f) / ((float) rect.width());
        }
        if (width < (((float) this.zEC.width()) * 1.0f) / ((float) this.zEC.height())) {
            width = ((float) this.zEC.width()) / width;
            height = (float) this.zEC.height();
        } else {
            float height2 = (float) this.zEC.height();
            height = ((float) this.zEC.width()) / width;
            width = height2;
        }
        if (a(this.fhZ) % 180.0f == 0.0f) {
            height = (height * 1.0f) / ((float) rect.height());
        } else {
            height = (height * 1.0f) / ((float) rect.width());
        }
        if (a(this.fhZ) % 180.0f == 0.0f) {
            width = (width * 1.0f) / ((float) rect.height());
        } else {
            width = (width * 1.0f) / ((float) rect.width());
        }
        this.fhZ.postScale(height, height, (float) rect.centerX(), (float) rect.centerY());
        RectF cAw = cAw();
        int centerX = (int) cAw.centerX();
        this.fhZ.postTranslate((float) (this.zEC.centerX() - centerX), (float) (this.zEC.centerY() - ((int) cAw.centerY())));
        this.zEB.set(this.fhZ);
        this.zEF = c(this.zEB) * 3.0f;
        this.zEG = c(this.zEB) * 1.0f;
        if (this.zEF < width) {
            this.zEF = width * 1.2f;
        }
    }

    public final void a(b bVar, float f, boolean z) {
        float width;
        float height;
        RectF cAw = cAw();
        int centerX = (int) cAw.centerX();
        int centerY = (int) cAw.centerY();
        int centerX2 = this.zEC.centerX() - centerX;
        int centerY2 = this.zEC.centerY() - centerY;
        if (f % 180.0f == 0.0f) {
            width = (1.0f * cAw.width()) / cAw.height();
        } else {
            width = (1.0f * cAw.height()) / cAw.width();
        }
        if (width < (1.0f * ((float) this.zEC.width())) / ((float) this.zEC.height())) {
            this.zEC.width();
            width = (float) this.zEC.height();
        } else {
            this.zEC.height();
            width = ((float) this.zEC.width()) / width;
        }
        if (f % 180.0f == 0.0f) {
            height = (width * 1.0f) / cAw.height();
        } else {
            height = (width * 1.0f) / cAw.width();
        }
        a aVar = new a(this, height, (float) centerX2, (float) centerY2, (float) centerX, (float) centerY, f, z);
        aVar.zEM = bVar;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 166.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, aVar.zEJ});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, aVar.zEK});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("rotation", new float[]{0.0f, aVar.fN});
        aVar.fcO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        aVar.fcO.addUpdateListener(new a$a$1(aVar));
        aVar.fcO.addListener(new 2(aVar));
        aVar.fcO.setInterpolator(new LinearInterpolator());
        aVar.fcO.setDuration(166);
        aVar.fcO.start();
    }

    public final RectF cAw() {
        RectF rectF = new RectF(this.gNA);
        this.fhZ.mapRect(rectF);
        return rectF;
    }

    public final void l(Rect rect) {
        this.gNA.set(rect);
        this.fia.set(rect);
        x.i("MicroMsg.BaseBoardView", "[resetImageRect] rect");
    }

    public float cAx() {
        return this.zEG;
    }

    public final float cAy() {
        return this.zEF;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    protected final float c(Matrix matrix) {
        float a = a(matrix, 3);
        float a2 = a(matrix, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float cdl() {
        return c(this.fhZ);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }
}
