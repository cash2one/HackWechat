package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oJd = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture aDa;
    int index;
    private int ioA;
    private int ioz;
    private Paint oJe;
    private a oJf = a.oJj;
    public int position;
    public String username;

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.oJe = new Paint();
        this.oJe.setColor(WebView.NIGHT_MODE_COLOR);
        this.oJe.setFilterBitmap(false);
        this.oJe.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public final synchronized void a(int[] iArr, int i, int i2, int i3, int i4) {
        if (bdk()) {
            o.bcW().a(this, iArr, i, i2, i3, i4);
        }
    }

    public final synchronized void b(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(this.aDa == null || this.ioz == 0 || this.ioA == 0)) {
                    Canvas lockCanvas = lockCanvas(null);
                    if (lockCanvas == null) {
                        x.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[]{this.username});
                    } else {
                        Matrix matrix = new Matrix();
                        if (i == OpenGlRender.suj) {
                            matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                        } else if (i == OpenGlRender.sui) {
                            matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                        }
                        if (i2 == OpenGlRender.suk) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                        lockCanvas.drawColor(0, Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            lockCanvas.drawBitmap(bitmap, matrix, this.oJe);
                        }
                        try {
                            unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                }
            }
        }
        x.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
    }

    public final void bde() {
        if (bdj()) {
            o.bcW().a(this, true);
        }
    }

    public final void bdf() {
        if (!bh.ov(this.username)) {
            x.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[]{this.username, this.oJf.name()});
            this.oJf = a.oJh;
            bde();
        }
    }

    public final void bdg() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[]{this.username, this.oJf.name()});
        this.oJf = a.oJi;
    }

    public final void bdh() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[]{this.username, this.oJf.name()});
        this.oJf = a.oJj;
        this.username = null;
        bdi();
    }

    private void bdi() {
        if (this.aDa != null && this.ioz != 0 && this.ioA != 0) {
            Canvas lockCanvas = lockCanvas(null);
            if (lockCanvas == null) {
                x.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
                return;
            }
            lockCanvas.drawColor(0, Mode.CLEAR);
            lockCanvas.drawColor(-14737113);
            lockCanvas.drawColor(oJd[this.index]);
            try {
                unlockCanvasAndPost(lockCanvas);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            }
        }
    }

    public final void FI(String str) {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[]{this.username, str});
        this.username = str;
    }

    public final void amg() {
        if (bdj()) {
            o.bcW().a(this, false);
        } else if (bdk()) {
            l$a com_tencent_mm_plugin_multitalk_a_l_a = (l$a) o.bcW().oHn.get(this.username);
            Bitmap bitmap = com_tencent_mm_plugin_multitalk_a_l_a != null ? com_tencent_mm_plugin_multitalk_a_l_a.oHq : null;
            if (bitmap != null) {
                b(bitmap, com_tencent_mm_plugin_multitalk_a_l_a.angle, com_tencent_mm_plugin_multitalk_a_l_a.oGY);
            }
        } else {
            bdi();
        }
    }

    private boolean bdj() {
        return this.oJf == a.oJh;
    }

    public final boolean bdk() {
        return this.oJf == a.oJi;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.aDa = surfaceTexture;
        this.ioz = i;
        this.ioA = i2;
        cpK();
        e.post(new 1(this), "onSurfaceTextureAvailable_refreshView");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.ioz = i;
        this.ioA = i2;
        e.post(new 2(this), "onSurfaceTextureSizeChanged_refreshView");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.aDa = null;
        this.ioA = 0;
        this.ioz = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
    }
}
