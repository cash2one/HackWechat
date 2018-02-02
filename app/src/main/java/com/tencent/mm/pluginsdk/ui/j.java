package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class j extends BitmapDrawable implements com.tencent.mm.pluginsdk.ui.d.a {
    protected static final Paint hap;
    protected static final af haq = new af(Looper.getMainLooper());
    private Runnable has;
    private Paint iYm = new Paint();
    protected boolean oxd = false;
    protected final a plt;
    private Rect rect = new Rect();
    protected String tag;
    protected boolean vkd = false;
    private int vke = 0;
    private int vkf = 0;
    protected boolean vkg;
    protected boolean vkh;
    protected float vki = 1.0f;
    private PaintFlagsDrawFilter vkj = new PaintFlagsDrawFilter(0, 3);
    private Path vkk;

    public interface a {
        void a(j jVar);

        Bitmap b(String str, int i, int i2, int i3);

        Bitmap cm(String str);

        Bitmap cn(String str);

        Bitmap tJ();
    }

    static {
        Paint paint = new Paint();
        hap = paint;
        paint.setAntiAlias(true);
        hap.setFilterBitmap(true);
    }

    public j(a aVar, String str) {
        super(aVar.tJ());
        this.iYm.setStyle(Style.STROKE);
        this.iYm.setFlags(1);
        this.iYm.setAntiAlias(true);
        this.vkk = new Path();
        this.has = new Runnable(this) {
            final /* synthetic */ j vkl;

            {
                this.vkl = r1;
            }

            public final void run() {
                this.vkl.invalidateSelf();
            }
        };
        this.plt = aVar;
        this.tag = str;
        this.plt.a(this);
    }

    public j(a aVar, String str, boolean z) {
        super(aVar.tJ());
        this.iYm.setStyle(Style.STROKE);
        this.iYm.setFlags(1);
        this.iYm.setAntiAlias(true);
        this.vkk = new Path();
        this.has = /* anonymous class already generated */;
        this.oxd = false;
        this.plt = aVar;
        this.tag = str;
        this.plt.a(this);
    }

    public final void qw(String str) {
        if (str != null && str.length() > 0 && !str.equals(this.tag)) {
            this.tag = str;
            haq.post(this.has);
        }
    }

    public final void kT(boolean z) {
        this.vkd = z;
    }

    public void draw(Canvas canvas) {
        Bitmap b;
        if (this.vkd) {
            b = this.plt.b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else if (this.vkg) {
            b = this.plt.cn(this.tag);
        } else {
            b = this.plt.cm(this.tag);
        }
        if (b == null || b.isRecycled()) {
            b = this.plt.tJ();
            if (this.vkg) {
                this.vkh = true;
            } else {
                this.vkh = false;
            }
        } else {
            this.vkh = false;
        }
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vki > 1.0f || this.oxd) {
            int height = (b.getHeight() / 15) / 2;
            int width = (b.getWidth() / 15) / 2;
            rect = new Rect(width, height, b.getWidth() - width, b.getHeight() - height);
        }
        canvas.drawBitmap(b, rect, bounds, hap);
    }

    public void jh(String str) {
        if (str != null && str.equals(this.tag)) {
            x.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", str);
            haq.post(this.has);
        }
    }

    public final void cac() {
        this.vkg = true;
    }

    public final void cad() {
        if (this.vkg) {
            this.vkg = false;
            if (this.vkh) {
                this.vkh = false;
                invalidateSelf();
            }
        }
    }

    public void onScrollStateChanged(boolean z) {
        if (z) {
            this.vkg = true;
        } else {
            cad();
        }
    }
}
