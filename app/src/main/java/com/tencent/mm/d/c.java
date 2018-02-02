package com.tencent.mm.d;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import com.tencent.mm.bo.b;
import com.tencent.mm.cache.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b<a> {
    public Rect fcT;
    boolean fiA = false;
    boolean fiB = false;
    public boolean fiC = true;
    boolean fiD = false;
    float fiE;
    float fiF;
    float fiG;
    float fiH;
    float fiI;
    float fiJ;
    public ValueAnimator fiK;
    public Rect fiL = new Rect();
    public int fiM = 0;
    public boolean fiN = false;
    private int fik = ((int) ac.getResources().getDimension(com.tencent.mm.bj.a.c.vaY));
    private int fil = ((int) ac.getResources().getDimension(com.tencent.mm.bj.a.c.vbl));
    private int fim = ((int) ac.getResources().getDimension(com.tencent.mm.bj.a.c.vbd));
    private Matrix fin = new Matrix();
    private RectF fio;
    private RectF fip;
    private RectF fiq;
    private RectF fir;
    public final Rect fis = new Rect();
    public com.tencent.mm.t.a fit;
    private boolean fiu = false;
    private boolean fiv = false;
    public com.tencent.mm.b.a fiw;
    boolean fix = false;
    boolean fiy = false;
    boolean fiz = false;

    class AnonymousClass8 implements AnimatorUpdateListener {
        int fdo = 0;
        float fdp = ((float) Math.pow((double) this.fiZ, 0.0833333358168602d));
        final /* synthetic */ c fiO;
        int fiQ = 0;
        float fiR;
        float fiS = 0.0f;
        float fiT;
        float fiU = 0.0f;
        float fiV = this.fiX;
        float fiW = this.fiY;
        final /* synthetic */ float fiX;
        final /* synthetic */ float fiY;
        final /* synthetic */ float fiZ;

        public AnonymousClass8(c cVar, float f, float f2, float f3) {
            this.fiO = cVar;
            this.fiX = f;
            this.fiY = f2;
            this.fiZ = f3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.fdo < 12) {
                this.fiO.uR().postScale(this.fdp, this.fdp, ((float) this.fiO.fcT.centerX()) + this.fiS, ((float) this.fiO.fcT.centerY()) + this.fiU);
                this.fiO.fin.postScale(this.fdp, this.fdp, ((float) this.fiO.fcT.centerX()) + this.fiS, ((float) this.fiO.fcT.centerY()) + this.fiU);
                this.fdo++;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
            this.fiO.uR().postRotate((float) (intValue - this.fiQ), this.fiX + this.fiS, this.fiY + this.fiU);
            this.fiO.fin.postRotate((float) (intValue - this.fiQ), this.fiX + this.fiS, this.fiY + this.fiU);
            RectF rectF = new RectF();
            rectF.set(this.fiO.fcT);
            this.fiO.fin.mapRect(rectF);
            this.fiV += ((float) intValue2) - this.fiR;
            this.fiW += ((float) intValue3) - this.fiT;
            this.fiS = this.fiV - rectF.centerX();
            this.fiU = this.fiW - rectF.centerY();
            this.fiO.uR().postTranslate(this.fiS, this.fiU);
            this.fiO.fin.postTranslate(this.fiS, this.fiU);
            this.fiO.uS();
            this.fiQ = intValue;
            this.fiR = (float) intValue2;
            this.fiT = (float) intValue3;
        }
    }

    static /* synthetic */ void a(c cVar, long j, boolean z, boolean z2) {
        if (cVar.fiK != null) {
            cVar.fiK.cancel();
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        PropertyValuesHolder ofInt2 = z ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{282, 255}) : z2 ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255}) : PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        cVar.fiK = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2});
        cVar.fiK.addUpdateListener(new 3(cVar));
        cVar.fiK.addListener(new 4(cVar));
        cVar.fiK.setStartDelay(j);
        cVar.fiK.setDuration(300);
        cVar.fiK.start();
    }

    public final a uG() {
        return a.CROP_PHOTO;
    }

    public final void a(b bVar, Matrix matrix, Rect rect) {
        super.a(bVar, matrix, rect);
        this.fcT = new Rect();
        this.fip = new RectF();
        this.fio = new RectF();
        this.fiq = new RectF();
        this.fir = new RectF();
        this.fit = new com.tencent.mm.t.a(this.fcT);
        this.fiw = new com.tencent.mm.b.a(this);
    }

    public final void uJ() {
        super.uJ();
        if (this.fis.isEmpty()) {
            this.fis.set(this.fik, this.fik * 2, uQ().width() - this.fik, ((uQ().height() - this.fil) - this.fim) - (this.fik * 2));
        }
        x.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", this.fis);
        com.tencent.mm.t.a xx = ((a) uI()).xx();
        if (xx != null && !xx.gNA.isEmpty()) {
            this.fhY.cdh().cAf().l(xx.gNA);
            x.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", Float.valueOf(a(xx.mMatrix)));
            uR().postRotate(-r1, (float) xx.gNA.centerX(), (float) xx.gNA.centerY());
        }
    }

    public final void uK() {
        super.uK();
        this.fhY.cdh().cAh().setVisibility(8);
        this.fiL.setEmpty();
        com.tencent.mm.t.a aVar;
        if (((a) uI()).aZ(true) <= 0) {
            aVar = new com.tencent.mm.t.a();
            aVar.mMatrix.set(uR());
            ((a) uI()).a(aVar);
            uW();
            this.fhY.cdh().cAf().zEC = this.fcT;
            this.fhY.cdh().cAf().a(new 1(this), 0.0f, false);
        } else {
            aVar = ((a) uI()).xx();
            if (aVar == null) {
                x.e("MicroMsg.CropArtist", "item is null!!!");
                return;
            }
            this.fcT.set(new Rect(aVar.fcT));
            this.fhY.cdh().cAf().zEC = aVar.fcT;
            try {
                ((a) uI()).a((com.tencent.mm.t.a) aVar.clone());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
            }
            this.fhY.cdh().cAf().a(new 2(this), 0.0f, false);
        }
        aJ(true);
    }

    public final boolean uM() {
        return !((a) uI()).gBw.equals(uR());
    }

    public final void uH() {
    }

    public final void onDraw(Canvas canvas) {
        if (this.fiv) {
            canvas.setMatrix(this.fin);
        } else {
            canvas.setMatrix(null);
        }
        com.tencent.mm.t.a aVar = this.fit;
        boolean z = this.fiC;
        boolean z2 = this.fiu;
        if (aVar.fcT == null) {
            x.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.fcT, Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.t.a.gNw);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.t.a.gO.equals(aVar.fcT)) {
                com.tencent.mm.t.a.gNt.reset();
                com.tencent.mm.t.a.gNt.moveTo((float) aVar.fcT.left, (float) aVar.fcT.top);
                com.tencent.mm.t.a.gNt.lineTo((float) aVar.fcT.right, (float) aVar.fcT.top);
                com.tencent.mm.t.a.gNt.lineTo((float) aVar.fcT.right, (float) aVar.fcT.bottom);
                com.tencent.mm.t.a.gNt.lineTo((float) aVar.fcT.left, (float) aVar.fcT.bottom);
                com.tencent.mm.t.a.gNt.close();
                com.tencent.mm.t.a.gNs.reset();
                for (int i = 1; i < 3; i++) {
                    com.tencent.mm.t.a.gNs.moveTo((float) (aVar.fcT.left + ((aVar.fcT.width() / 3) * i)), (float) aVar.fcT.top);
                    com.tencent.mm.t.a.gNs.lineTo((float) (aVar.fcT.left + ((aVar.fcT.width() / 3) * i)), (float) aVar.fcT.bottom);
                    com.tencent.mm.t.a.gNs.moveTo((float) aVar.fcT.left, (float) (aVar.fcT.top + ((aVar.fcT.height() / 3) * i)));
                    com.tencent.mm.t.a.gNs.lineTo((float) aVar.fcT.right, (float) (aVar.fcT.top + ((aVar.fcT.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) aVar.fcT.left, (float) aVar.fcT.top, (float) aVar.fcT.right, (float) aVar.fcT.bottom, com.tencent.mm.t.a.gNv);
            canvas.drawPath(com.tencent.mm.t.a.gNs, com.tencent.mm.t.a.gNx);
            canvas.drawPath(com.tencent.mm.t.a.gNt, com.tencent.mm.t.a.gNu);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fcT.left) - com.tencent.mm.t.a.gNq, ((float) aVar.fcT.top) - (com.tencent.mm.t.a.gNq / 2.0f), com.tencent.mm.t.a.gNr + ((float) aVar.fcT.left), ((float) aVar.fcT.top) - (com.tencent.mm.t.a.gNq / 2.0f), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.gNq / 2.0f) + (((float) aVar.fcT.right) - com.tencent.mm.t.a.gNr), ((float) aVar.fcT.top) - (com.tencent.mm.t.a.gNq / 2.0f), com.tencent.mm.t.a.gNq + ((float) aVar.fcT.right), ((float) aVar.fcT.top) - (com.tencent.mm.t.a.gNq / 2.0f), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fcT.left) - (com.tencent.mm.t.a.gNq / 2.0f), ((float) aVar.fcT.top) - (com.tencent.mm.t.a.gNq / 2.0f), ((float) aVar.fcT.left) - (com.tencent.mm.t.a.gNq / 2.0f), com.tencent.mm.t.a.gNr + ((float) aVar.fcT.top), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fcT.left) - (com.tencent.mm.t.a.gNq / 2.0f), (com.tencent.mm.t.a.gNq / 2.0f) + (((float) aVar.fcT.bottom) - com.tencent.mm.t.a.gNr), ((float) aVar.fcT.left) - (com.tencent.mm.t.a.gNq / 2.0f), (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.right), (float) aVar.fcT.top, (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.right), com.tencent.mm.t.a.gNr + ((float) aVar.fcT.top), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.right), (com.tencent.mm.t.a.gNq / 2.0f) + (((float) aVar.fcT.bottom) - com.tencent.mm.t.a.gNr), (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.right), (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fcT.left) - com.tencent.mm.t.a.gNq, (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNr + ((float) aVar.fcT.left), (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNy);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fcT.right) - com.tencent.mm.t.a.gNr, (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNq + ((float) aVar.fcT.right), (com.tencent.mm.t.a.gNq / 2.0f) + ((float) aVar.fcT.bottom), com.tencent.mm.t.a.gNy);
            if (!com.tencent.mm.t.a.gO.equals(aVar.fcT)) {
                com.tencent.mm.t.a.gO.set(aVar.fcT);
            }
        }
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!uO()) {
            return false;
        }
        RectF cAw = this.fhY.cdh().cAf().cAw();
        this.fiG = cAw.top - (cAw.bottom - ((float) this.fcT.bottom));
        this.fiH = cAw.bottom + (((float) this.fcT.top) - cAw.top);
        this.fiI = cAw.left - (cAw.right - ((float) this.fcT.right));
        this.fiJ = cAw.right + (((float) this.fcT.left) - cAw.left);
        if (this.fiJ > ((float) this.fis.right)) {
            this.fiJ = (float) this.fis.right;
        }
        if (this.fiI < ((float) this.fik)) {
            this.fiI = (float) this.fik;
        }
        if (this.fiH > ((float) this.fis.bottom)) {
            this.fiH = (float) this.fis.bottom;
        }
        if (this.fiG < ((float) this.fik)) {
            this.fiG = (float) this.fik;
        }
        float width;
        float height;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.fiD = false;
                if (this.fiw != null) {
                    this.fiw.cancel();
                }
                if (this.fip.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiA = true;
                }
                if (this.fio.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiz = true;
                }
                if (this.fiq.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiy = true;
                }
                if (this.fir.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiB = true;
                }
                this.fiC = false;
                if (uU()) {
                    if (this.fiA && this.fiy) {
                        this.fiA = true;
                        this.fiy = true;
                        this.fiz = false;
                        this.fiB = false;
                    } else if (this.fiA && this.fiB) {
                        this.fiA = true;
                        this.fiy = false;
                        this.fiz = false;
                        this.fiB = true;
                    } else if (this.fiz && this.fiB) {
                        this.fiA = false;
                        this.fiy = false;
                        this.fiz = true;
                        this.fiB = true;
                    } else if (this.fiz && this.fiB) {
                        this.fiA = false;
                        this.fiy = false;
                        this.fiz = true;
                        this.fiB = true;
                    }
                    this.fiE = motionEvent.getX();
                    this.fiF = motionEvent.getY();
                    break;
                }
                break;
            case 1:
                width = (((float) this.fis.width()) * 1.0f) / ((float) this.fcT.width());
                height = (((float) this.fis.height()) * 1.0f) / ((float) this.fcT.height());
                if (width >= height) {
                    width = height;
                }
                height = ((float) this.fis.centerX()) - ((float) this.fcT.centerX());
                float centerY = ((float) this.fis.centerY()) - ((float) this.fcT.centerY());
                if (this.fiD) {
                    this.fiw.fcW = 1000;
                    com.tencent.mm.b.a aVar = this.fiw;
                    Rect rect = this.fcT;
                    aVar.fcR = height;
                    aVar.fcS = centerY;
                    aVar.fcT = rect;
                    aVar.fcU.set(aVar.fcT);
                    aVar.fcQ = width;
                    this.fiw.play();
                }
                if (uU()) {
                    this.fix = true;
                } else {
                    this.fix = false;
                }
                this.fiA = false;
                this.fiy = false;
                this.fiz = false;
                this.fiB = false;
                uT();
                break;
            case 2:
                this.fiD = true;
                if (motionEvent.getPointerCount() == 1 && uU()) {
                    Rect rect2;
                    if (this.fiB && this.fcT.right >= this.fcT.left) {
                        if (this.fcT.right <= this.fis.right) {
                            if (motionEvent.getX() - this.fiE > ((float) (this.fis.right - this.fcT.right))) {
                                this.fcT.right = this.fis.right;
                            } else {
                                rect2 = this.fcT;
                                rect2.right = (int) (((float) rect2.right) + (motionEvent.getX() - this.fiE));
                            }
                        }
                        if (this.fcT.right < this.fcT.left + (this.fik * 2)) {
                            this.fcT.right = this.fcT.left + (this.fik * 2);
                        }
                        if (this.fcT.right > this.fis.right) {
                            this.fcT.right = this.fis.right;
                        }
                        if (((int) cAw.right) <= ((int) this.fiJ) && ((int) cAw.right) <= this.fcT.right) {
                            if (motionEvent.getX() - this.fiE > this.fiJ - cAw.right) {
                                uR().postTranslate(this.fiJ - cAw.right, 0.0f);
                            } else {
                                uR().postTranslate(motionEvent.getX() - this.fiE, 0.0f);
                            }
                        }
                        if (((float) this.fcT.width()) > cAw.width() && this.fcT.right < this.fis.right) {
                            height = ((float) this.fcT.width()) / cAw.width();
                            uR().postScale(height, height, (float) this.fcT.left, (float) this.fcT.centerY());
                        }
                    }
                    if (this.fiy && this.fcT.right >= this.fcT.left) {
                        if (this.fcT.left >= this.fis.left) {
                            if (this.fiE - motionEvent.getX() > ((float) (this.fcT.left - this.fis.left))) {
                                this.fcT.left = this.fis.left;
                            } else {
                                rect2 = this.fcT;
                                rect2.left = (int) (((float) rect2.left) - (this.fiE - motionEvent.getX()));
                            }
                        }
                        if (this.fcT.left > this.fcT.right - (this.fik * 2)) {
                            this.fcT.left = this.fcT.right - (this.fik * 2);
                        }
                        if (this.fcT.left < this.fis.left) {
                            this.fcT.left = this.fis.left;
                        }
                        if (((int) cAw.left) >= ((int) this.fiI) && ((int) cAw.left) >= this.fcT.left) {
                            if (this.fiE - motionEvent.getX() > cAw.left - this.fiI) {
                                uR().postTranslate(this.fiI - cAw.left, 0.0f);
                            } else {
                                uR().postTranslate(motionEvent.getX() - this.fiE, 0.0f);
                            }
                        }
                        if (((float) this.fcT.width()) > cAw.width() && this.fcT.left > this.fis.left) {
                            height = ((float) this.fcT.width()) / cAw.width();
                            uR().postScale(height, height, (float) this.fcT.right, (float) this.fcT.centerY());
                        }
                    }
                    if (this.fiz && this.fcT.bottom >= this.fcT.top) {
                        if (this.fcT.top >= this.fis.top) {
                            if (this.fiF - motionEvent.getY() > ((float) (this.fcT.top - this.fis.top))) {
                                this.fcT.top = this.fis.top;
                            } else {
                                rect2 = this.fcT;
                                rect2.top = (int) (((float) rect2.top) - (this.fiF - motionEvent.getY()));
                            }
                        }
                        if (this.fcT.top > this.fcT.bottom - (this.fik * 2)) {
                            this.fcT.top = this.fcT.bottom - (this.fik * 2);
                        }
                        if (this.fcT.top < this.fis.top) {
                            this.fcT.top = this.fis.top;
                        }
                        if (((int) cAw.top) >= ((int) this.fiG) && ((int) cAw.top) >= this.fcT.top) {
                            if (this.fiF - motionEvent.getY() > cAw.top - this.fiG) {
                                uR().postTranslate(0.0f, this.fiG - cAw.top);
                            } else {
                                uR().postTranslate(0.0f, motionEvent.getY() - this.fiF);
                            }
                        }
                        if (((float) this.fcT.height()) > cAw.height() && this.fcT.top > this.fis.top) {
                            height = ((float) this.fcT.height()) / cAw.height();
                            uR().postScale(height, height, (float) this.fcT.centerX(), (float) this.fcT.bottom);
                        }
                    }
                    if (this.fiA && this.fcT.bottom >= this.fcT.top) {
                        if (this.fcT.bottom <= this.fis.bottom) {
                            if (motionEvent.getY() - this.fiF > ((float) (this.fis.bottom - this.fcT.bottom))) {
                                this.fcT.bottom = this.fis.bottom;
                            } else {
                                rect2 = this.fcT;
                                rect2.bottom = (int) (((float) rect2.bottom) + (motionEvent.getY() - this.fiF));
                            }
                        }
                        if (this.fcT.bottom < this.fcT.top + (this.fik * 2)) {
                            this.fcT.bottom = this.fcT.top + (this.fik * 2);
                        }
                        if (this.fcT.bottom > this.fis.bottom) {
                            this.fcT.bottom = this.fis.bottom;
                        }
                        if (((int) cAw.bottom) <= ((int) this.fiH) && ((int) cAw.bottom) <= this.fcT.bottom) {
                            if (motionEvent.getY() - this.fiF > this.fiH - cAw.bottom) {
                                uR().postTranslate(0.0f, this.fiH - cAw.bottom);
                            } else {
                                uR().postTranslate(0.0f, motionEvent.getY() - this.fiF);
                            }
                        }
                        if (((float) this.fcT.height()) > cAw.height() && this.fcT.bottom < this.fis.bottom) {
                            width = ((float) this.fcT.height()) / cAw.height();
                            uR().postScale(width, width, (float) this.fcT.centerX(), (float) this.fcT.top);
                        }
                    }
                    uV();
                    this.fix = true;
                    uS();
                    this.fiE = motionEvent.getX();
                    this.fiF = motionEvent.getY();
                } else {
                    this.fix = false;
                }
                t(motionEvent);
                break;
            case 5:
                this.fiA = false;
                this.fiy = false;
                this.fiz = false;
                this.fiB = false;
                this.fix = false;
                break;
        }
        return this.fix;
    }

    private boolean uU() {
        return this.fiA || this.fiy || this.fiz || this.fiB;
    }

    public final void uV() {
        this.fip.set((float) (this.fcT.left - this.fik), (float) (this.fcT.bottom - this.fik), (float) (this.fcT.right + this.fik), (float) (this.fcT.bottom + this.fik));
        this.fio.set((float) (this.fcT.left - this.fik), (float) (this.fcT.top - this.fik), (float) (this.fcT.right + this.fik), (float) (this.fcT.top + this.fik));
        this.fiq.set((float) (this.fcT.left - this.fik), (float) (this.fcT.top - this.fik), (float) (this.fcT.left + this.fik), (float) (this.fcT.bottom + this.fik));
        this.fir.set((float) (this.fcT.right - this.fik), (float) (this.fcT.top - this.fik), (float) (this.fcT.right + this.fik), (float) (this.fcT.bottom + this.fik));
    }

    public final void uW() {
        float width = (((float) this.fhY.cdm().getWidth()) * 1.0f) / ((float) this.fhY.cdm().getHeight());
        int width2;
        if (width < (((float) this.fis.width()) * 1.0f) / ((float) this.fis.height())) {
            width2 = (int) ((((float) this.fis.width()) - (width * ((float) this.fis.height()))) / 2.0f);
            this.fcT.set(this.fis.left + width2, this.fis.top, this.fis.right - width2, this.fis.bottom);
        } else {
            width2 = (int) ((((float) this.fis.height()) - (((float) this.fis.width()) / width)) / 2.0f);
            this.fcT.set(this.fis.left, this.fis.top + width2, this.fis.right, this.fis.bottom - width2);
        }
        uV();
    }

    public final void uX() {
        this.fhY.cdh().cAf().zEC = this.fhY.cdh().cAf().zED;
        RectF rectF = new RectF(this.fcT);
        Matrix matrix = new Matrix();
        uR().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.fhY.cdh().cAf().l(rect);
        final com.tencent.mm.t.a aVar = new com.tencent.mm.t.a();
        aVar.fcT = new Rect(this.fcT);
        aVar.gNA.set(rect);
        this.fhY.cdh().cAf().a(new com.tencent.mm.view.b.a.b(this) {
            final /* synthetic */ c fiO;

            public final void uY() {
                com.tencent.mm.t.a aVar = aVar;
                aVar.mMatrix.set(this.fiO.uR());
                a aVar2 = (a) this.fiO.uI();
                if (aVar2.gBu != null) {
                    aVar2.gBu.clear();
                }
                ((a) this.fiO.uI()).a(aVar);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        this.fhY.cdh().cAh().setVisibility(0);
    }
}
