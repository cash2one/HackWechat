package com.tencent.mm.t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.api.i;
import com.tencent.mm.bj.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    public String gNC;
    private i gND;
    public Bitmap gNE;
    public PointF gNF;
    public int gNG = 0;
    private float gNH = 1.0f;
    public boolean gNI;
    public PointF gNJ;
    private float gNK;
    private float gNL;
    public boolean gNM = false;
    public List<PointF> gNN = new ArrayList();
    public float gNO;
    private float gNP;
    private Rect gNz;
    public float gr = 1.0f;
    protected Context mContext;
    private Matrix mMatrix;

    public /* synthetic */ Object clone() {
        return BM();
    }

    public c(Context context, Matrix matrix, String str, i iVar, Rect rect) {
        this.gNC = str;
        this.mMatrix = matrix;
        this.gND = iVar;
        this.mContext = context;
        this.gNz = rect;
        this.gNF = new PointF();
        this.gNJ = new PointF();
    }

    public c(Context context, Matrix matrix, String str, Rect rect) {
        this.gNC = str;
        this.mMatrix = matrix;
        this.mContext = context;
        this.gNz = rect;
        this.gNF = new PointF();
        this.gNJ = new PointF();
    }

    public final void a(float f, float f2, float f3, int i) {
        this.gNE = e(BK());
        this.gNK = (1.2f * ((float) this.gNz.width())) / ((float) this.gNE.getWidth());
        this.gNL = (0.1f * ((float) this.gNz.width())) / ((float) this.gNE.getWidth());
        this.gNH = f3;
        this.gNG = i;
        this.gr *= f3;
        x.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", new Object[]{Float.valueOf(this.gNK), Float.valueOf(this.gNL), Float.valueOf(this.gNH)});
        this.gNF.set(f, f2);
        x.d("MicroMsg.EmojiItem", "[setPoint] point:%s", new Object[]{this.gNF});
        BL();
    }

    public final boolean BH() {
        x.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.gNE != null && !this.gNE.isRecycled()) {
            return false;
        }
        this.gNE = e(BK());
        return true;
    }

    public void setSelected(boolean z) {
        this.gNI = z;
    }

    public final void b(float f, float f2, float f3, int i) {
        this.gNF.offset(f, f2);
        if (0.0f != f3) {
            this.gr = f3;
        }
        this.gNG = i;
    }

    public final void clear() {
        x.i("MicroMsg.EmojiItem", "[clear]");
        if (this.gNE != null && !this.gNE.isRecycled()) {
            this.gNE.recycle();
            this.gNE = null;
        }
    }

    public final void draw(Canvas canvas) {
        if (this.gNE == null || this.gNE.isRecycled()) {
            x.w("MicroMsg.EmojiItem", "[draw] null == bitmap || bitmap isRecycled");
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.gNK < this.gr * this.gNH) {
            this.gr = this.gNK / this.gNH;
        } else if (this.gNL > this.gr * this.gNH) {
            this.gr = this.gNL / this.gNH;
        }
        canvas.save();
        canvas.translate(this.gNF.x, this.gNF.y);
        canvas.rotate((float) this.gNG);
        canvas.scale(this.gr, this.gr);
        if (this.gNI) {
            canvas.drawBitmap(this.gNE, (float) ((-BI()) / 2), (float) ((-BJ()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-BI()) / 2)) + 40.0f, ((float) ((-BJ()) / 2)) + 40.0f, ((float) (this.gNE.getWidth() / 2)) - 40.0f, ((float) (this.gNE.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.gNE, (float) ((-BI()) / 2), (float) ((-BJ()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
    }

    private int BI() {
        if (this.gNE != null) {
            return this.gNE.getWidth();
        }
        return 0;
    }

    private int BJ() {
        if (this.gNE != null) {
            return this.gNE.getHeight();
        }
        return 0;
    }

    protected Bitmap BK() {
        if (this.gNE == null || this.gNE.isRecycled()) {
            this.gNE = this.gND.aj(this.mContext);
        }
        if (this.gNE == null) {
            x.e("MicroMsg.EmojiItem", "[getEmojiBitmap] NULL!");
            d dVar = new d();
            this.gNE = d.createBitmap(120, 120, Config.ARGB_4444);
            new Canvas(this.gNE).drawColor(-7829368);
        }
        return this.gNE;
    }

    private Bitmap e(Bitmap bitmap) {
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), a.d.vbp), BitmapFactory.decodeResource(this.mContext.getResources(), a.d.vbp).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        return createBitmap;
    }

    public final void BL() {
        double BI = (double) ((((float) BI()) * 1.0f) / 2.0f);
        double BJ = (double) ((((float) BJ()) * 1.0f) / 2.0f);
        this.gNP = (float) Math.sqrt((BI * BI) + (BJ * BJ));
        this.gNP *= this.gr / this.gNH;
        this.gNO = (float) Math.toDegrees(Math.atan(BJ / BI));
    }

    public PointF N(float f) {
        PointF pointF = new PointF();
        double d = (((double) (((float) this.gNG) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.gNF.x + ((float) (((double) this.gNP) * Math.cos(d)));
        pointF.y = this.gNF.y + ((float) (Math.sin(d) * ((double) this.gNP)));
        return pointF;
    }

    public final c BM() {
        c cVar;
        Throwable e;
        try {
            cVar = (c) super.clone();
            try {
                cVar.gNF = new PointF(this.gNF.x, this.gNF.y);
                cVar.gND = this.gND;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                return cVar;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            cVar = null;
            e = th;
            x.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            return cVar;
        }
        return cVar;
    }
}
