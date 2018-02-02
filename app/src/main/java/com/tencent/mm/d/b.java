package com.tencent.mm.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.a;

public abstract class b<T extends d> {
    public static final b fie = new b() {
        public final a uG() {
            return a.DEFAULT;
        }

        public final void uH() {
        }

        public final void onDraw(Canvas canvas) {
        }
    };
    public com.tencent.mm.bo.b fhY;
    private Matrix fhZ;
    Rect fia;
    private boolean fib;
    public boolean fic;
    private Bitmap fid;
    private Canvas fif = new Canvas();
    private Runnable fig;
    PointF fih = new PointF();
    private PointF fii = new PointF();
    private Context mContext;
    float[] values = new float[9];

    public abstract void onDraw(Canvas canvas);

    public abstract a uG();

    public abstract void uH();

    public final void b(Canvas canvas) {
        if (this.fid != null && !this.fid.isRecycled()) {
            canvas.drawBitmap(this.fid, 0.0f, 0.0f, null);
        }
    }

    public final T uI() {
        return this.fhY.a(uG());
    }

    public void a(com.tencent.mm.bo.b bVar, Matrix matrix, Rect rect) {
        x.i("MicroMsg.BaseArtist" + uG(), "[onCreate]");
        this.fic = true;
        this.mContext = bVar.getContext();
        this.fhY = bVar;
        this.fhZ = matrix;
        this.fia = rect;
    }

    public void uJ() {
        x.i("MicroMsg.BaseArtist" + uG(), "[onAlive] isAlive:%s", Boolean.valueOf(this.fib));
        if (!this.fib) {
            this.fib = true;
            d uI = uI();
            if (uI != null) {
                uI.xv();
                uI.aY(false);
            } else {
                x.e("MicroMsg.BaseArtist", "[onAlive] type:%s cache is null", uG());
            }
            this.fid = uN();
        }
    }

    public void uK() {
        x.i("MicroMsg.BaseArtist" + uG(), "[onSelected] ");
    }

    public final void onFinish() {
        x.i("MicroMsg.BaseArtist", "[onFinish] type:%s", uG());
        this.fib = false;
        this.fic = false;
        d uI = uI();
        if (uI != null) {
            uI.aY(true);
        } else {
            x.e("MicroMsg.BaseArtist", "[onFinish] type:%s cache is null", uG());
        }
        uL();
    }

    public void onDestroy() {
        this.fic = false;
        this.fib = false;
        x.i("MicroMsg.BaseArtist" + uG(), "[onDestroy]");
        uL();
    }

    public final void uL() {
        if (this.fid != null && !this.fid.isRecycled()) {
            this.fid.recycle();
        }
    }

    public boolean uM() {
        try {
            if (uI().aZ(true) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void aI(boolean z) {
        this.fif.setBitmap(uN());
        uI().a(this.fif, z);
    }

    protected final Bitmap uN() {
        if (this.fid == null || this.fid.isRecycled()) {
            this.fid = Bitmap.createBitmap(this.fhY.cdh().cAf().zEC.width(), this.fhY.cdh().cAf().zEC.height(), Config.ARGB_4444);
        }
        return this.fid;
    }

    protected final void d(Bitmap bitmap) {
        if (!(uN() == null || uN().isRecycled())) {
            uN().recycle();
        }
        this.fid = bitmap;
    }

    public final void aJ(boolean z) {
        this.fhY.cdh().cAf().zEH = z;
    }

    public final boolean isAlive() {
        return this.fic && this.fib;
    }

    protected final boolean uO() {
        return this.fhY.cdj().uG() == uG();
    }

    public final void uP() {
        if (uI().pop() != null) {
            uI().uP();
        }
        this.fhY.cdh().removeCallbacks(this.fig);
        a cdh = this.fhY.cdh();
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ b fij;

            {
                this.fij = r1;
            }

            public final void run() {
                this.fij.uH();
                this.fij.uS();
                this.fij.fig = null;
            }
        };
        this.fig = anonymousClass2;
        cdh.postDelayed(anonymousClass2, 66);
    }

    public boolean q(MotionEvent motionEvent) {
        if (u(motionEvent)) {
            t(motionEvent);
        }
        return false;
    }

    protected final Rect uQ() {
        return this.fhY.cdh().cAf().zEC;
    }

    public final Matrix uR() {
        return this.fhY.cdh().cAf().uR();
    }

    public final void uS() {
        this.fhY.cdh().cAf().postInvalidate();
    }

    public final void uT() {
        this.fhY.cdh().cAe().postInvalidate();
    }

    public final float getScale() {
        float a = a(this.fhZ, 3);
        float a2 = a(this.fhZ, 0);
        return (float) Math.sqrt((double) ((a * a) + (a2 * a2)));
    }

    public final float getRotation() {
        return (float) Math.round(Math.atan2((double) a(this.fhZ, 1), (double) a(this.fhZ, 0)) * 57.29577951308232d);
    }

    public final float a(Matrix matrix) {
        return (float) Math.round(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.values);
        return this.values[i];
    }

    protected final float[] l(float f, float f2) {
        Matrix matrix = new Matrix(this.fhZ);
        this.fhZ.invert(matrix);
        float[] fArr = new float[]{f, f2};
        matrix.mapPoints(fArr);
        return fArr;
    }

    protected final float[] m(float f, float f2) {
        float[] fArr = new float[]{f, f2};
        this.fhZ.mapPoints(fArr);
        return fArr;
    }

    protected static int r(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1) {
            return 0;
        }
        int x = (int) (motionEvent.getX(0) - motionEvent.getX(1));
        int y = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        return (int) Math.sqrt((double) ((y * y) + (x * x)));
    }

    protected static int[] s(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (motionEvent.getPointerCount() > 1) {
            iArr[0] = (int) (motionEvent.getX(0) - motionEvent.getX(1));
            iArr[1] = (int) (motionEvent.getY(0) - motionEvent.getY(1));
        }
        return iArr;
    }

    protected final void t(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            this.fii.x = motionEvent.getX(1);
            this.fii.y = motionEvent.getY(1);
        } else if (motionEvent.getPointerCount() == 1) {
            this.fih.x = motionEvent.getX(0);
            this.fih.y = motionEvent.getY(0);
        }
        if (motionEvent.getActionMasked() != 6) {
            return;
        }
        if (motionEvent.getPointerCount() <= 1 || 1 - motionEvent.getActionIndex() < 0 || 1 - motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
            this.fih.x = motionEvent.getX(0);
            this.fih.y = motionEvent.getY(0);
            return;
        }
        this.fih.x = motionEvent.getX(1 - motionEvent.getActionIndex());
        this.fih.y = motionEvent.getY(1 - motionEvent.getActionIndex());
    }

    protected final boolean u(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            if (Math.abs(this.fih.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.fih.y - motionEvent.getY(0)) > 3.0f || Math.abs(this.fii.x - motionEvent.getX(1)) > 3.0f || Math.abs(this.fii.y - motionEvent.getY(1)) > 3.0f) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            if (Math.abs(this.fih.x - motionEvent.getX(0)) > 3.0f || Math.abs(this.fih.y - motionEvent.getY(0)) > 3.0f) {
                return true;
            }
            return false;
        }
    }
}
