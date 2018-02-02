package com.tencent.mm.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.g;
import com.tencent.mm.cache.g.1;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.d;
import com.tencent.mm.t.d.a;
import com.tencent.mm.t.d.b;
import java.util.LinkedList;

public final class f extends b<g> {
    private float YR;
    private float YS;
    private boolean fiD = false;
    private float fiE;
    private float fiF;
    private boolean fjb = true;
    private Bitmap fjp;
    private LinkedList<b> fjq = new LinkedList();
    public int fjr = a.gNX;
    private Path mY = new Path();

    public final a uG() {
        return a.fhT;
    }

    public final void uJ() {
        Bitmap bitmap;
        super.uJ();
        d(((g) uI()).xC());
        Bitmap cdm = this.fhY.cdm();
        if (cdm == null) {
            x.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
            bitmap = null;
        } else {
            int width = cdm.getWidth();
            int height = cdm.getHeight();
            int aJ = com.tencent.mm.cc.a.aJ(6.0f);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int ceil = (int) Math.ceil((double) (((float) width) / ((float) aJ)));
            int ceil2 = (int) Math.ceil((double) (((float) height) / ((float) aJ)));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            for (int i = 0; i < ceil; i++) {
                for (int i2 = 0; i2 < ceil2; i2++) {
                    int i3 = aJ * i;
                    int i4 = aJ * i2;
                    int i5 = i3 + aJ;
                    int i6 = i5 > width ? width : i5;
                    i5 = i4 + aJ;
                    if (i5 > height) {
                        i5 = height;
                    }
                    int pixel = cdm.getPixel(i3, i4);
                    Rect rect = new Rect(i3, i4, i6, i5);
                    paint.setColor(pixel);
                    canvas.drawRect(rect, paint);
                }
            }
            bitmap = createBitmap;
        }
        this.fjp = bitmap;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.fjp != null && !this.fjp.isRecycled()) {
            this.fjp.recycle();
        }
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.fia);
        if (this.fjr == a.gNX) {
            b(canvas);
            new d(this.fjr, this.mY, 1.0f / getScale(), this.fjp).draw(canvas);
        } else if (this.fjr == a.gNY) {
            new d(this.fjr, new LinkedList(this.fjq), 1.0f / getScale()).draw(new Canvas(uN()));
            b(canvas);
        }
        canvas.restore();
    }

    public final boolean q(MotionEvent motionEvent) {
        int i = 0;
        if (!uO()) {
            return false;
        }
        float[] l = l(motionEvent.getX(), motionEvent.getY());
        float f;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.fia.contains((int) l[0], (int) l[1])) {
                    f = l[0];
                    this.fiE = f;
                    this.YR = f;
                    float f2 = l[1];
                    this.fiF = f2;
                    this.YS = f2;
                    this.fjb = true;
                } else {
                    this.fjb = false;
                }
                this.fiD = false;
                break;
            case 1:
            case 5:
                if (this.fjb && this.fiD) {
                    if (this.fjr == a.gNX) {
                        ((g) uI()).a(new d(this.fjr, new Path(this.mY), 1.0f / getScale(), this.fjp));
                        aI(false);
                    } else if (this.fjr == a.gNY) {
                        ((g) uI()).a(new d(this.fjr, new LinkedList(this.fjq), 1.0f / getScale()));
                        aI(false);
                    }
                    uT();
                }
                this.fjq.clear();
                this.mY.reset();
                this.fiD = false;
                this.fjb = false;
                break;
            case 2:
                if (!this.fjb || !this.fiD) {
                    if (this.fjb && !this.fiD) {
                        if (this.fjr == a.gNX) {
                            this.mY.moveTo(l[0], l[1]);
                        }
                        this.fiD = true;
                        break;
                    }
                }
                this.fiE = this.YR;
                this.fiF = this.YS;
                this.YR = l[0];
                this.YS = l[1];
                if (this.fjr == a.gNX) {
                    this.mY.quadTo(this.fiE, this.fiF, (this.YR + this.fiE) / 2.0f, (this.YS + this.fiF) / 2.0f);
                } else if (this.fjr == a.gNY) {
                    int i2;
                    double toDegrees = Math.toDegrees(Math.atan((double) ((this.YR - this.fiE) / (this.YS - this.fiF))));
                    if (getRotation() == 180.0f) {
                        i2 = 180;
                    } else {
                        i2 = 0;
                    }
                    float f3 = ((float) (((double) i2) + toDegrees)) % 360.0f;
                    LinkedList linkedList = this.fjq;
                    f = 1.0f / getScale();
                    float f4 = this.YR;
                    float f5 = this.YS;
                    Bitmap cdm = this.fhY.cdm();
                    if (cdm == null || f4 >= ((float) cdm.getWidth()) || f5 >= ((float) cdm.getHeight()) || f4 <= 0.0f || f5 <= 0.0f) {
                        x.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[]{Float.valueOf(f4), Float.valueOf(f5)});
                    } else {
                        i = cdm.getPixel((int) f4, (int) f5);
                    }
                    linkedList.add(new b(f, i, f3, this.YR, this.YS));
                }
                uS();
                break;
                break;
        }
        return this.fjb;
    }

    public final void aI(boolean z) {
        super.aI(z);
        g gVar = (g) uI();
        Bitmap copy = uN().copy(Config.ARGB_8888, true);
        String aVar = a.fhT.toString();
        String str = e.gHt + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), aVar});
        x.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[]{str, Integer.valueOf(gVar.aZ(true))});
        aVar = (String) gVar.gBC.get(gVar.aZ(true));
        if (!bh.ov(aVar)) {
            FileOp.deleteFile(aVar);
            gVar.gBC.remove(gVar.aZ(true));
        }
        gVar.gBC.put(gVar.aZ(true), str);
        gVar.gBD.put(str, copy);
        com.tencent.mm.sdk.f.e.cgR();
        com.tencent.mm.sdk.f.e.a(new 1(gVar, copy, str), "[saveCacheToLocal] mosaic path:" + str);
    }

    public final void uH() {
        if (!(uN() == null || uN().isRecycled())) {
            uN().recycle();
        }
        d(((g) uI()).xC());
    }
}
