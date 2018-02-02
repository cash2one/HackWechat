package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
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
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public class VideoView extends SurfaceView {
    public OnCompletionListener hXa;
    public OnErrorListener hXb;
    private Context mContext;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    public MediaPlayer qxO;
    private SurfaceHolder rZQ;
    public String vyB;
    public boolean vyC;
    public boolean vyD;
    OnVideoSizeChangedListener vyE;
    OnPreparedListener vyF;
    private OnCompletionListener vyG;
    private OnErrorListener vyH;
    Callback vyI;
    private int zql;
    private int zqm;
    public OnPreparedListener zqn;
    private int zqo;
    public int zqp;
    private OnBufferingUpdateListener zqq;

    public final void cyx() {
        if (this.mVideoHeight != 0 && this.mVideoWidth != 0) {
            int i;
            int i2 = this.mVideoWidth;
            int i3 = this.mVideoHeight;
            x.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
            x.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
            int width = getWidth();
            int height = getHeight();
            if (width <= 0) {
                i = i2;
            } else {
                i = width;
            }
            if (height <= 0) {
                width = i3;
            } else {
                width = height;
            }
            float f = (((float) i) * 1.0f) / ((float) i2);
            float f2 = (((float) width) * 1.0f) / ((float) i3);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i2) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (((float) i3) * f);
            }
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
            invalidate();
            x.v("MicroMsg.VideoView", "video size after:" + this.qxO.getVideoWidth() + "   " + this.qxO.getVideoHeight());
            x.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        cyy();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rZQ = null;
        this.qxO = null;
        this.vyE = new 1(this);
        this.vyF = new 2(this);
        this.vyG = new 3(this);
        this.vyH = new 4(this);
        this.zqq = new OnBufferingUpdateListener(this) {
            final /* synthetic */ VideoView zqr;

            {
                this.zqr = r1;
            }

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                this.zqr.zqo = i;
            }
        };
        this.vyI = new 6(this);
        this.mContext = context;
        cyy();
    }

    private void cyy() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vyI);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void stopPlayback() {
        if (this.qxO != null) {
            this.qxO.stop();
            this.qxO.release();
            this.qxO = null;
        }
    }

    public final void aJH() {
        if (this.vyB != null && this.rZQ != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mContext.sendBroadcast(intent);
            if (this.qxO != null) {
                this.qxO.reset();
                this.qxO.release();
                this.qxO = null;
            }
            try {
                this.qxO = new j();
                this.qxO.setOnPreparedListener(this.vyF);
                this.qxO.setOnVideoSizeChangedListener(this.vyE);
                this.vyC = false;
                x.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.qxO.setOnCompletionListener(this.vyG);
                this.qxO.setOnErrorListener(this.vyH);
                this.qxO.setOnBufferingUpdateListener(this.zqq);
                this.zqo = 0;
                this.qxO.setDataSource(this.vyB);
                this.qxO.setDisplay(this.rZQ);
                this.qxO.setAudioStreamType(3);
                this.qxO.setScreenOnWhilePlaying(true);
                this.qxO.prepareAsync();
                this.mVideoHeight = this.qxO.getVideoHeight();
                this.mVideoWidth = this.qxO.getVideoWidth();
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public final boolean isPlaying() {
        if (this.qxO == null || !this.vyC) {
            return false;
        }
        return this.qxO.isPlaying();
    }
}
