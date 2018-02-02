package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements f {
    private float aew;
    private int kDP;
    private int kDQ;
    private boolean kTc;
    private int mDuration;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private boolean nDu;
    private f$a quG;
    private MediaPlayer qxO;
    private long startTime;
    private String vyB;
    private boolean vyC;
    private boolean vyD;
    OnVideoSizeChangedListener vyE;
    OnPreparedListener vyF;
    private OnCompletionListener vyG;
    private OnErrorListener vyH;
    private b vyK;
    private long vyL;
    public int vyM;
    private OnSeekCompleteListener vyN;
    private OnBufferingUpdateListener vyO;
    private OnInfoListener vyP;
    private boolean vyQ;
    private long vyh;
    private boolean vyi;
    private f$e vyk;
    private f$c vyl;
    private f$d vym;
    private boolean vyo;
    private boolean vyp;
    SurfaceTextureListener vyr;
    public o vys;

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSurface = null;
        this.qxO = null;
        this.startTime = 0;
        this.vyL = 0;
        this.kDP = 0;
        this.kDQ = 0;
        this.vyM = 0;
        this.nDu = false;
        this.vyi = false;
        this.vyE = new 2(this);
        this.vyF = new 3(this);
        this.vyN = new 4(this);
        this.vyO = new 5(this);
        this.vyP = new 6(this);
        this.vyG = new 7(this);
        this.vyH = new 8(this);
        this.vyh = 0;
        this.vyo = false;
        this.vyp = false;
        this.vyQ = false;
        this.vyr = new 9(this);
        this.kTc = false;
        this.vys = new o();
        this.aew = -1.0f;
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

    public final void a(b bVar) {
        this.vyK = bVar;
    }

    public final void a(f$d com_tencent_mm_pluginsdk_ui_tools_f_d) {
        this.vym = com_tencent_mm_pluginsdk_ui_tools_f_d;
    }

    public final void setVideoPath(String str) {
        this.vyB = str;
        this.vyD = false;
        aJH();
        requestLayout();
    }

    public final String Ur() {
        return this.vyB;
    }

    public final void stop() {
        long j;
        long j2 = this.vyL > 0 ? this.vyL - this.startTime : 2147483647L;
        long Wo = bh.Wo() - this.startTime;
        if (j2 > Wo) {
            j = Wo;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        x.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[]{Integer.valueOf(getDuration()), Long.valueOf(Wo), Long.valueOf(j2)});
        if (this.quG != null) {
            this.quG.cf(i, getDuration());
        }
        ccL();
        this.vys.reset();
        try {
            if (this.mSurface != null && this.vyC) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    x.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[]{Integer.valueOf(hashCode())});
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, null);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.vyB = "";
        this.vyM = 0;
        this.vyC = false;
        this.vyD = false;
        this.vyh = 0;
    }

    private void ccL() {
        boolean z = true;
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vyC);
        if (this.qxO != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.qxO != null) {
            this.qxO.setOnErrorListener(null);
            this.qxO.setOnVideoSizeChangedListener(null);
            try {
                this.qxO.stop();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.qxO.reset();
                this.qxO.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.qxO = null;
    }

    private void aJH() {
        if (!bh.ov(this.vyB) && this.mSurface != null) {
            ccL();
            x.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[]{Integer.valueOf(hashCode()), this.vyB});
            try {
                this.qxO = new j();
                this.qxO.setOnPreparedListener(this.vyF);
                this.qxO.setOnVideoSizeChangedListener(this.vyE);
                this.vyC = false;
                x.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.vyM = 0;
                this.qxO.setOnCompletionListener(this.vyG);
                this.qxO.setOnErrorListener(this.vyH);
                this.qxO.setOnSeekCompleteListener(this.vyN);
                this.qxO.setOnBufferingUpdateListener(this.vyO);
                this.qxO.setOnInfoListener(this.vyP);
                this.qxO.setDataSource(this.vyB);
                this.qxO.setSurface(this.mSurface);
                this.qxO.setAudioStreamType(3);
                this.qxO.setScreenOnWhilePlaying(true);
                this.qxO.prepareAsync();
                this.mVideoHeight = this.qxO.getVideoHeight();
                this.mVideoWidth = this.qxO.getVideoWidth();
                setMute(this.kTc);
                aa(this.aew);
                x.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qxO.hashCode())});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.quG != null) {
                    this.quG.onError(-1, -1);
                }
            }
        }
    }

    public final void aZM() {
        if (this.qxO != null && this.vyC && this.mSurface != null && this.mSurface.isValid()) {
            x.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition())});
            this.vyQ = true;
            this.qxO.setVolume(0.0f, 0.0f);
            this.qxO.start();
        }
    }

    public final void pause() {
        if (this.qxO != null && this.vyC && this.qxO.isPlaying()) {
            x.d("MicroMsg.VideoTextureView", "pause video.");
            this.qxO.pause();
        }
        this.vyD = false;
    }

    public final int getDuration() {
        if (this.qxO == null || !this.vyC) {
            this.mDuration = -1;
            return this.mDuration;
        } else if (this.mDuration > 0) {
            return this.mDuration;
        } else {
            this.mDuration = this.qxO.getDuration();
            return this.mDuration;
        }
    }

    public final int getCurrentPosition() {
        if (this.qxO != null && this.vyC) {
            return this.qxO.getCurrentPosition();
        }
        if (this.qxO == null) {
            return -1;
        }
        return 0;
    }

    public final boolean isPlaying() {
        boolean z;
        if (this.qxO == null || !this.vyC || this.vyp) {
            z = false;
        } else {
            z = this.qxO.isPlaying();
        }
        x.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.vyp), Boolean.valueOf(this.vyC)});
        return z;
    }

    public final void cP(boolean z) {
        if (this.qxO != null) {
            this.qxO.setLooping(z);
        }
        this.nDu = true;
    }

    public final void a(f$a com_tencent_mm_pluginsdk_ui_tools_f_a) {
        this.quG = com_tencent_mm_pluginsdk_ui_tools_f_a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.mSurface == null) {
            x.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[]{Integer.valueOf(hashCode())});
            this.vyo = true;
            this.vyD = true;
            return false;
        }
        this.startTime = this.startTime == 0 ? bh.Wo() : this.startTime;
        x.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[]{Long.valueOf(this.startTime), Boolean.valueOf(this.vyC), Boolean.valueOf(this.vyp)});
        if (this.qxO != null && this.vyC) {
            if (this.vyp) {
                this.vyp = false;
                setMute(this.kTc);
            }
            this.qxO.start();
            this.vyD = true;
            return true;
        } else if (this.qxO == null && this.vyC) {
            this.vyD = true;
            aJH();
            requestLayout();
            return true;
        } else {
            this.vyD = true;
            return false;
        }
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public final double btg() {
        return 0.0d;
    }

    public final void q(double d) {
        if (this.qxO != null) {
            this.qxO.seekTo((int) d);
            this.vyD = true;
            x.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.qxO.getCurrentPosition());
        }
    }

    public final void c(double d, boolean z) {
        q(d);
        this.vyD = z;
    }

    public final void id(boolean z) {
    }

    public final long bth() {
        return this.vyh;
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z)});
        this.kTc = z;
        if (this.qxO == null) {
            return;
        }
        if (this.kTc) {
            this.qxO.setVolume(0.0f, 0.0f);
        } else {
            this.qxO.setVolume(1.0f, 1.0f);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.vys.u(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.vys.vyS, this.vys.vyT);
    }

    public final boolean aa(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.aew = f;
        if (d.fM(23)) {
            return aB(this.aew);
        }
        return false;
    }

    private boolean aB(float f) {
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.qxO != null && d.fM(23)) {
                    PlaybackParams playbackParams = this.qxO.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.qxO.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", new Object[]{Integer.valueOf(hashCode())});
                return false;
            }
        }
        return true;
    }
}
