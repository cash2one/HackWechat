package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.s.c;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView extends MMTextureView implements f {
    public boolean HE;
    private boolean kTc;
    public Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    public b opG;
    public boolean opy;
    public boolean opz;
    public String path;
    public f$a quG;
    public i vye;
    private int vyf;
    private boolean vyg;
    private long vyh;
    private boolean vyi;
    public boolean vyj;
    public f$e vyk;
    private f$c vyl;
    private f$d vym;
    public boolean vyn;
    protected boolean vyo;
    protected boolean vyp;
    public c vyq;
    private SurfaceTextureListener vyr;
    public o vys;

    static /* synthetic */ void f(VideoPlayerTextureView videoPlayerTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoPlayerTextureView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            videoPlayerTextureView.setLayoutParams(layoutParams);
        }
    }

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vyf = 0;
        this.HE = false;
        this.vyg = true;
        this.vyh = 0;
        this.vyi = false;
        this.vyj = false;
        this.opy = false;
        this.opz = false;
        this.vyn = false;
        this.vyo = false;
        this.vyp = false;
        this.vyq = new c(this) {
            final /* synthetic */ VideoPlayerTextureView vyt;

            {
                this.vyt = r1;
            }

            public final void hX() {
                this.vyt.HE = true;
                this.vyt.setMute(this.vyt.kTc);
                if (this.vyt.quG != null) {
                    this.vyt.quG.hX();
                }
                this.vyt.requestLayout();
            }

            public final void vh() {
                if (this.vyt.quG != null) {
                    this.vyt.quG.vh();
                }
            }

            public final void onError(int i, int i2) {
                if (this.vyt.quG != null) {
                    this.vyt.quG.onError(i, i2);
                }
            }

            public final void aZA() {
                if (this.vyt.vyl != null) {
                    this.vyt.vyl.bW(this.vyt.vyg);
                }
                if (!this.vyt.vyg) {
                    x.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                    this.vyt.vyg = true;
                } else if (this.vyt.vye != null) {
                    x.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[]{this.vyt.vye.asP()});
                    this.vyt.vye.start();
                }
            }

            public final void O(int i, int i2, int i3) {
                x.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                this.vyt.vys.reset();
                this.vyt.vyf = i3;
                this.vyt.mVideoWidth = i;
                this.vyt.mVideoHeight = i2;
                VideoPlayerTextureView.f(this.vyt);
                if (this.vyt.quG != null) {
                    this.vyt.quG.cg(this.vyt.mVideoWidth, this.vyt.mVideoHeight);
                }
            }
        };
        this.vyr = new SurfaceTextureListener(this) {
            final /* synthetic */ VideoPlayerTextureView vyt;

            {
                this.vyt = r1;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[]{Integer.valueOf(this.vyt.hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.vyt.vyo)});
                try {
                    this.vyt.cpK();
                    this.vyt.mSurface = new Surface(surfaceTexture);
                    if (this.vyt.vye == null || !this.vyt.HE) {
                        this.vyt.aJH();
                    } else {
                        i iVar = this.vyt.vye;
                        Surface surface = this.vyt.mSurface;
                        if (surface != null) {
                            x.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[]{iVar.opV.opD.asP(), Integer.valueOf(surface.hashCode())});
                            k kVar = r0.oqe;
                            x.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[]{kVar.asP()});
                            kVar.aeI = surface;
                            if (d.fM(23)) {
                                kVar.aZN();
                            } else {
                                kVar.aZO();
                            }
                        }
                        if (this.vyt.vyo) {
                            this.vyt.vye.start();
                        } else {
                            this.vyt.vyp = true;
                            this.vyt.vyh = 0;
                            this.vyt.vye.setMute(true);
                            this.vyt.vye.start();
                        }
                        this.vyt.vyo = false;
                    }
                    VideoPlayerTextureView.f(this.vyt);
                    if (this.vyt.vym != null) {
                        this.vyt.vym.TI();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                x.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[]{Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
                VideoPlayerTextureView.f(this.vyt);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[]{Integer.valueOf(this.vyt.hashCode()), Integer.valueOf(surfaceTexture.hashCode())});
                this.vyt.mSurface = null;
                this.vyt.vyo = false;
                this.vyt.vyp = false;
                if (this.vyt.vye == null) {
                    this.vyt.vyo = false;
                } else if (this.vyt.isPlaying()) {
                    this.vyt.vyo = true;
                    this.vyt.vye.pause();
                }
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.vyt.vyp && this.vyt.vyh > 0) {
                    this.vyt.vye.pause();
                    this.vyt.vye.setMute(this.vyt.kTc);
                    this.vyt.vyp = false;
                }
                if (this.vyt.vyh > 0 && this.vyt.vyk != null) {
                    x.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[]{Integer.valueOf(this.vyt.hashCode())});
                    this.vyt.vyk.bbH();
                    this.vyt.vyk = null;
                }
                this.vyt.vyh = System.currentTimeMillis();
            }
        };
        this.vys = new o();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vyr);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void a(f$e com_tencent_mm_pluginsdk_ui_tools_f_e) {
        this.vyk = com_tencent_mm_pluginsdk_ui_tools_f_e;
    }

    public final void a(f$c com_tencent_mm_pluginsdk_ui_tools_f_c) {
        this.vyl = com_tencent_mm_pluginsdk_ui_tools_f_c;
    }

    public final void a(f.b bVar) {
    }

    public final void a(f$d com_tencent_mm_pluginsdk_ui_tools_f_d) {
        this.vym = com_tencent_mm_pluginsdk_ui_tools_f_d;
    }

    public final void gz(boolean z) {
        this.opy = z;
        if (this.vye != null) {
            this.vye.gz(z);
        }
    }

    public final void gA(boolean z) {
        this.opz = z;
        if (this.vye != null) {
            this.vye.gA(z);
        }
    }

    public final boolean isPlaying() {
        if (this.vye != null) {
            return this.vye.isPlaying();
        }
        return false;
    }

    public final boolean ccI() {
        if (this.mSurface == null || this.vyp) {
            return false;
        }
        return true;
    }

    public void setVideoPath(String str) {
        x.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[]{Integer.valueOf(hashCode()), str});
        this.path = str;
        aJH();
        requestLayout();
    }

    public final String Ur() {
        return this.path;
    }

    public boolean start() {
        if (this.vye == null || !this.HE) {
            boolean z;
            String str = "MicroMsg.VideoPlayerTextureView";
            String str2 = "%d player is null[%b] or it prepared [%b]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.vye == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.HE);
            x.w(str, str2, objArr);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vyp);
        objArr[2] = Boolean.valueOf(this.vyo);
        objArr[3] = Boolean.valueOf(this.mSurface != null);
        x.i(str, str2, objArr);
        if (this.mSurface == null) {
            this.vyo = true;
            return true;
        } else if (this.vyp) {
            this.vyo = true;
            this.vyp = false;
            setMute(this.kTc);
            return true;
        } else {
            this.vye.start();
            return true;
        }
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public void stop() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        if (this.vye != null) {
            this.vye.opW = null;
            this.vye.opV.stop();
            this.vye.release();
            this.vye = null;
        }
        this.vyf = 0;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vys.reset();
        this.HE = false;
        this.path = null;
        this.vyh = 0;
    }

    public void pause() {
        if (this.vye != null && this.vye.isPlaying()) {
            this.vye.pause();
        }
        this.vyo = false;
    }

    public final void onDetach() {
    }

    public final void cP(boolean z) {
    }

    public final void a(f$a com_tencent_mm_pluginsdk_ui_tools_f_a) {
        this.quG = com_tencent_mm_pluginsdk_ui_tools_f_a;
    }

    public final int getCurrentPosition() {
        if (this.vye != null) {
            return this.vye.aZK();
        }
        return 0;
    }

    public final int getDuration() {
        if (this.vye != null) {
            return (int) this.vye.opV.aqA;
        }
        return 0;
    }

    public final double btg() {
        return 0.0d;
    }

    public void q(double d) {
        if (this.vye != null) {
            this.vye.sD((int) d);
        }
    }

    public final void c(double d, boolean z) {
        this.vyg = z;
        q(d);
    }

    public final void id(boolean z) {
    }

    public final long bth() {
        return this.vyh;
    }

    public final void ccJ() {
        this.vyi = true;
        this.vys.vyi = this.vyi;
    }

    public void setMute(boolean z) {
        this.kTc = z;
        if (this.vye != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z)});
            this.vye.setMute(z);
        }
    }

    public void aJH() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", new Object[]{Integer.valueOf(hashCode()), this.path});
        if (this.vye != null) {
            this.vye.opW = null;
            this.vye.opV.stop();
            this.vye.release();
            this.vye = null;
        }
        if (bh.ov(this.path) || this.mSurface == null) {
            x.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        try {
            this.HE = false;
            this.vye = new i(Looper.getMainLooper());
            this.vye.setPath(this.path);
            this.vye.a(this.opG);
            this.vye.gz(this.opy);
            this.vye.gA(this.opz);
            this.vye.opW = this.vyq;
            this.vye.setSurface(this.mSurface);
            this.vye.gy(this.vyn);
            if (this.mSurface != null) {
                this.vye.aZJ();
            } else if (this.vyj) {
                this.vye.aZJ();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", new Object[]{e.getMessage()});
            if (this.quG != null) {
                this.quG.onError(-1, -1);
            }
        }
    }

    public final void aZM() {
        if (this.vye != null && this.HE && this.mSurface != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[]{Integer.valueOf(hashCode())});
            i iVar = this.vye;
            if (iVar.opV != null) {
                iVar.opV.aZM();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.vys.u(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        int i3 = this.vys.vyS;
        int i4 = this.vys.vyT;
        if (this.vyf == 90 || this.vyf == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f = ((float) i3) / 2.0f;
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i4) / ((float) i3);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix.setScale(getScaleX(), getScaleY(), f, f2);
            }
            matrix.postRotate((float) this.vyf, f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
        }
        setMeasuredDimension(i3, i4);
    }
}
