package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSurfaceView extends SurfaceView implements f {
    private boolean kTc;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private f$a quG;
    private MediaPlayer qxO;
    private SurfaceHolder rZQ;
    private String vyB;
    private boolean vyC;
    private boolean vyD;
    OnVideoSizeChangedListener vyE;
    OnPreparedListener vyF;
    private OnCompletionListener vyG;
    private OnErrorListener vyH;
    Callback vyI;

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        if (videoSurfaceView.mVideoHeight != 0 && videoSurfaceView.mVideoWidth != 0) {
            int i = videoSurfaceView.mVideoWidth;
            int i2 = videoSurfaceView.mVideoHeight;
            x.v("MicroMsg.VideoSurfaceView", "video size before:" + i + "   " + i2);
            x.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
            int width = videoSurfaceView.getWidth();
            int height = videoSurfaceView.getHeight();
            int i3 = width <= 0 ? i : width;
            width = height <= 0 ? i2 : height;
            float f = (((float) i3) * 1.0f) / ((float) i);
            float f2 = (((float) width) * 1.0f) / ((float) i2);
            LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) (((float) i2) * f);
            }
            layoutParams.addRule(13);
            videoSurfaceView.setLayoutParams(layoutParams);
            x.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.qxO.getVideoWidth() + "   " + videoSurfaceView.qxO.getVideoHeight());
            x.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rZQ = null;
        this.qxO = null;
        this.vyE = new 1(this);
        this.vyF = new 2(this);
        this.vyG = new 3(this);
        this.vyH = new OnErrorListener(this) {
            final /* synthetic */ VideoSurfaceView vyJ;

            {
                this.vyJ = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (this.vyJ.quG != null) {
                    this.vyJ.quG.onError(i, i2);
                }
                return true;
            }
        };
        this.vyI = new 5(this);
        this.kTc = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vyI);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
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
        if (this.qxO != null) {
            this.qxO.stop();
            this.qxO.release();
            this.qxO = null;
        }
    }

    private void aJH() {
        if (this.vyB != null && this.rZQ != null) {
            if (this.qxO != null) {
                this.qxO.stop();
                this.qxO.release();
                this.qxO = null;
            }
            try {
                this.qxO = new j();
                this.qxO.setOnPreparedListener(this.vyF);
                this.qxO.setOnVideoSizeChangedListener(this.vyE);
                this.vyC = false;
                x.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.qxO.setOnCompletionListener(this.vyG);
                this.qxO.setOnErrorListener(this.vyH);
                this.qxO.setDataSource(this.vyB);
                this.qxO.setDisplay(this.rZQ);
                this.qxO.setAudioStreamType(3);
                this.qxO.setScreenOnWhilePlaying(true);
                this.qxO.prepareAsync();
                this.mVideoHeight = this.qxO.getVideoHeight();
                this.mVideoWidth = this.qxO.getVideoWidth();
                setMute(this.kTc);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", new Object[]{e.getMessage()});
                if (this.quG != null) {
                    this.quG.onError(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.qxO != null && this.vyC && this.qxO.isPlaying()) {
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
        if (this.qxO == null || !this.vyC) {
            return 0;
        }
        return this.qxO.getCurrentPosition();
    }

    public final boolean isPlaying() {
        if (this.qxO == null || !this.vyC) {
            return false;
        }
        return this.qxO.isPlaying();
    }

    public final void cP(boolean z) {
        if (this.qxO != null) {
            this.qxO.setLooping(z);
        }
    }

    public final void a(f$a com_tencent_mm_pluginsdk_ui_tools_f_a) {
        this.quG = com_tencent_mm_pluginsdk_ui_tools_f_a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.qxO == null || !this.vyC) {
            this.vyD = true;
        } else {
            this.qxO.start();
            this.vyD = false;
        }
        return true;
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public final double btg() {
        return 0.0d;
    }

    public final void q(double d) {
        if (this.qxO != null) {
            x.d("MicroMsg.VideoSurfaceView", "seek to time: " + d);
            this.qxO.seekTo((int) d);
            start();
        }
    }

    public final void id(boolean z) {
    }

    public final long bth() {
        return 0;
    }

    public final void setMute(boolean z) {
        this.kTc = z;
        if (this.qxO == null) {
            return;
        }
        if (this.kTc) {
            this.qxO.setVolume(0.0f, 0.0f);
        } else {
            this.qxO.setVolume(0.5f, 0.5f);
        }
    }

    public final void c(double d, boolean z) {
        q(d);
    }

    public final void a(f$e com_tencent_mm_pluginsdk_ui_tools_f_e) {
    }

    public final void a(f$c com_tencent_mm_pluginsdk_ui_tools_f_c) {
    }

    public final void a(b bVar) {
    }

    public final void a(f$d com_tencent_mm_pluginsdk_ui_tools_f_d) {
    }
}
