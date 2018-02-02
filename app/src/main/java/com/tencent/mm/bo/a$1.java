package com.tencent.mm.bo;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.widget.EditText;
import com.tencent.mm.api.d;
import com.tencent.mm.api.l;
import com.tencent.mm.bj.a.e;
import com.tencent.mm.bo.a.7;
import com.tencent.mm.d.a;
import com.tencent.mm.d.b;
import com.tencent.mm.d.c;
import com.tencent.mm.d.c.5;
import com.tencent.mm.d.c.8;
import com.tencent.mm.d.c.9;
import com.tencent.mm.d.f;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements l {
    final /* synthetic */ a vAf;

    a$1(a aVar) {
        this.vAf = aVar;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[]{dVar});
        if (this.vAf.vzW.fds != null) {
            this.vAf.vzW.fds.a(dVar);
        }
        if (dVar == d.fdA) {
            this.vAf.vzW.cAg().setVisibility(8);
        }
        b bVar = (b) this.vAf.vzX.get(dVar);
        if (bVar != null) {
            if (bVar.fic && !bVar.isAlive()) {
                bVar.uJ();
            }
            if (bVar.uG() != a.fhR) {
                bVar.aJ(false);
            }
            bVar.uK();
            this.vAf.vAe = bVar;
            switch (7.vAh[dVar.ordinal()]) {
                case 1:
                    ((EditText) this.vAf.vzW.cAi().findViewById(e.gWv)).setTextColor(com.tencent.mm.view.footer.a.zFl[0]);
                    this.vAf.lr(true);
                    this.vAf.vzW.aB(false);
                    break;
                case 2:
                    this.vAf.vzW.aC(false);
                    this.vAf.vzW.aB(false);
                    this.vAf.vzW.nH(false);
                    break;
                case 3:
                    this.vAf.vAc = this.vAf.vAd;
                    return;
            }
            this.vAf.vAd = dVar;
        }
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar, Integer.valueOf(i)});
        if (this.vAf.vzW.fds != null) {
            this.vAf.vzW.fds.a(dVar, i);
        }
        this.vAf.vAe = (b) this.vAf.vzX.get(dVar);
        if (this.vAf.cdj().uG() != a.fhR) {
            if (this.vAf.vzW.cAg().getVisibility() == 8) {
                this.vAf.vzW.cAg().setVisibility(0);
            }
            switch (7.vAh[dVar.ordinal()]) {
                case 3:
                    c cVar = (c) this.vAf.cdj();
                    float width;
                    if (i == 0) {
                        cVar.fiM++;
                        cVar.fiw.cancel();
                        if (cVar.fiK != null) {
                            cVar.fiK.cancel();
                        }
                        Matrix matrix = new Matrix();
                        matrix.postRotate(-90.0f, (float) cVar.fcT.centerX(), (float) cVar.fcT.centerY());
                        if (cVar.fiL.isEmpty()) {
                            cVar.fiL.set(cVar.fcT);
                        }
                        RectF rectF = new RectF(cVar.fiL);
                        matrix.mapRect(rectF);
                        width = (1.0f * ((float) cVar.fis.width())) / rectF.width();
                        float height = (1.0f * ((float) cVar.fis.height())) / rectF.height();
                        if (width >= height) {
                            width = height;
                        }
                        matrix.postScale(width, width, (float) cVar.fcT.centerX(), (float) cVar.fcT.centerY());
                        rectF.set(cVar.fiL);
                        matrix.mapRect(rectF);
                        cVar.fiL.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        height = (float) cVar.fcT.centerX();
                        float centerY = (float) cVar.fcT.centerY();
                        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, cVar.fis.centerX() - ((int) height)});
                        PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, cVar.fis.centerY() - ((int) centerY)});
                        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                        ofPropertyValuesHolder.addUpdateListener(new 8(cVar, height, centerY, width));
                        ofPropertyValuesHolder.addListener(new 9(cVar));
                        ofPropertyValuesHolder.setDuration(200);
                        ofPropertyValuesHolder.start();
                        return;
                    } else if (1 == i) {
                        x.i("MicroMsg.CropArtist", "[cancel]");
                        cVar.fiw.cancel();
                        if (cVar.fiK != null) {
                            cVar.fiK.cancel();
                        }
                        cVar.fhY.cdh().cAf().zEC = cVar.fhY.cdh().cAf().zED;
                        com.tencent.mm.t.a xw = ((com.tencent.mm.cache.a) cVar.uI()).xw();
                        width = 0.0f;
                        if (xw != null) {
                            width = cVar.getRotation() - cVar.a(xw.mMatrix);
                        }
                        if (!(xw == null || xw.gNA.isEmpty())) {
                            cVar.fhY.cdh().cAf().l(xw.gNA);
                        }
                        cVar.fhY.cdh().cAf().a(null, width, true);
                        cVar.fhY.cdh().cAh().setVisibility(0);
                        this.vAf.vAe = (b) this.vAf.vzX.get(this.vAf.vAc);
                        this.vAf.vzW.cAe().c(this.vAf.vAc);
                        return;
                    } else if (2 == i) {
                        x.i("MicroMsg.CropArtist", "[doCrop]");
                        if (cVar.fiK != null) {
                            cVar.fiK.cancel();
                        }
                        if (cVar.fiw.fdb) {
                            cVar.fiw.fcX = null;
                            cVar.uX();
                        } else {
                            if (!cVar.fiw.fdc) {
                                cVar.fiw.cancel();
                                cVar.fiw.play();
                            }
                            cVar.fiw.fcX = new 5(cVar);
                        }
                        this.vAf.vAe = (b) this.vAf.vzX.get(this.vAf.vAc);
                        this.vAf.vzW.cAe().c(this.vAf.vAc);
                        return;
                    } else if (3 == i) {
                        x.i("MicroMsg.CropArtist", "[reset]");
                        cVar.fiN = true;
                        cVar.fiw.cancel();
                        if (cVar.fiK != null) {
                            cVar.fiK.cancel();
                        }
                        cVar.fiL.setEmpty();
                        cVar.uW();
                        cVar.fiC = false;
                        cVar.fhY.cdh().cAf().zEC = cVar.fcT;
                        cVar.fhY.cdh().cAf().a(new c.7(cVar), cVar.getRotation(), true);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    com.tencent.mm.d.d dVar2 = (com.tencent.mm.d.d) this.vAf.cdj();
                    if (i != -1) {
                        this.vAf.vzW.cAe();
                        dVar2.su = com.tencent.mm.view.footer.a.getColor(i);
                        return;
                    }
                    dVar2.uP();
                    return;
                case 5:
                    f fVar = (f) this.vAf.cdj();
                    if (i == 0) {
                        fVar.fjr = com.tencent.mm.t.d.a.gNX;
                        return;
                    } else if (1 == i) {
                        fVar.fjr = com.tencent.mm.t.d.a.gNY;
                        return;
                    } else {
                        fVar.uP();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final void aD(boolean z) {
    }
}
