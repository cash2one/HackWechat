package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView extends AppCompatImageView {
    public String ltJ;
    private float mDensity;
    public int nyC;
    private int nyD;
    private boolean nyE;

    public MMAnimateView(Context context) {
        this(context, null);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nyC = d.lJf;
        this.nyD = d.bEl;
        this.nyE = true;
        this.mDensity = 0.0f;
        if (com.tencent.mm.compatible.util.d.fM(26)) {
            setLayerType(1, null);
        }
    }

    public void setImageResource(int i) {
        a(getResources(), i, true);
    }

    public void setBackgroundResource(int i) {
        a(getResources(), i, false);
    }

    public final void Cq(String str) {
        cR(str, null);
    }

    public final void cQ(String str, String str2) {
        cR(str, str2);
    }

    public final void g(byte[] bArr, String str) {
        if (bArr == null) {
            try {
                x.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[]{Boolean.valueOf(true), str});
                return;
            } catch (MMGIFException e) {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap bl = com.tencent.mm.sdk.platformtools.d.bl(bArr);
                    if (bl != null) {
                        bl.setDensity(320);
                        setImageBitmap(bl);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[]{bArr.toString()});
                    init();
                    return;
                }
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[]{e.toString()});
                init();
                return;
            } catch (IOException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[]{e2.toString()});
                init();
                return;
            }
        }
        Drawable fVar;
        if (bh.ov(str)) {
            fVar = p.bq(bArr) ? new f(bArr) : new c(bArr);
            fVar.start();
        } else {
            this.ltJ = str;
            fVar = b.aSk().o(this.ltJ, bArr);
        }
        setImageDrawable(fVar);
    }

    public final void a(InputStream inputStream, String str) {
        Drawable drawable = null;
        try {
            if (bh.ov(str)) {
                drawable = new c(inputStream);
            } else {
                this.ltJ = str;
                b aSk = b.aSk();
                String str2 = this.ltJ;
                if (inputStream != null) {
                    x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[]{str2});
                    if (aSk.nyA.get(str2) != null) {
                        drawable = (a) ((WeakReference) aSk.nyA.get(str2)).get();
                    }
                    if (drawable == null) {
                        drawable = new c(inputStream);
                        aSk.nyA.put(str2, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(320);
                    setImageBitmap(decodeStream);
                    return;
                }
                x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                return;
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[]{e.toString()});
            init();
        } catch (IOException e2) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[]{e2.toString()});
            init();
        }
    }

    public final float aSl() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ac.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    private void a(Resources resources, int i, boolean z) {
        Drawable drawable = null;
        try {
            if (bh.ov(null)) {
                drawable = new c(resources, i);
            } else {
                this.ltJ = null;
                b aSk = b.aSk();
                if (aSk.nyA.get(null) != null) {
                    drawable = (a) ((WeakReference) aSk.nyA.get(null)).get();
                }
                if (drawable == null) {
                    drawable = new c(resources, i);
                    aSk.nyA.put(null, new WeakReference(drawable));
                }
            }
            if (z) {
                setImageDrawable(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        } catch (IOException e) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public final void a(String str, h hVar) {
        try {
            Drawable cVar = new c(str);
            setImageDrawable(cVar);
            cVar.nyX = Integer.MAX_VALUE;
            cVar.nyZ = hVar;
            return;
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(new FileInputStream(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(320);
                        setImageBitmap(decodeStream);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[]{str});
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (FileNotFoundException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
        } catch (IOException e3) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
        }
        init();
    }

    public final void cR(String str, String str2) {
        try {
            Drawable fVar;
            if (p.US(str)) {
                fVar = new f(e.d(str, 0, e.bN(str)));
                fVar.start();
                setImageDrawable(fVar);
                return;
            }
            if (bh.ov(str2)) {
                fVar = new c(str);
            } else {
                this.ltJ = str2;
                fVar = b.aSk().cP(this.ltJ, str);
            }
            setImageDrawable(fVar);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(320);
                            setImageBitmap(decodeFile);
                            return;
                        }
                        x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[]{str});
                        init();
                        b.deleteFile(str);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[]{str});
                        init();
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[]{bh.i(e22)});
            }
        } catch (Throwable e222) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[]{bh.i(e222)});
            b.deleteFile(str);
            init();
        } catch (NullPointerException e3) {
            init();
        }
    }

    public final void init() {
        this.nyE = f.ze();
        if (this.nyE) {
            if (this.nyC > 0) {
                super.setImageResource(this.nyC);
            }
        } else if (this.nyD > 0) {
            super.setImageResource(this.nyD);
        }
    }

    public final void resume() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            c cVar = (c) getDrawable();
            if (!cVar.nyF) {
                cVar.mIsRunning = true;
                cVar.e(cVar.nzb, 0);
            }
        }
    }

    public static void a(MMGIFException mMGIFException) {
        com.tencent.mm.sdk.b.b hxVar = new hx();
        hxVar.fyq.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.b.a.xef.m(hxVar);
    }

    public final void recycle() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            ((c) getDrawable()).recycle();
        }
    }
}
