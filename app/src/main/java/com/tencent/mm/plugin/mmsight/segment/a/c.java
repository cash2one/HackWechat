package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

public final class c implements a {
    private ak hHu;
    int oAl;
    int oAm;
    private a oAs;
    private HandlerThread oAt = e.cZ("check auto job", 10);
    com.tencent.mm.plugin.mmsight.segment.a.a.c oAu = null;
    private com.tencent.mm.plugin.mmsight.segment.a.a.c oAv = new 1(this);
    private a oAw = new a(this) {
        final /* synthetic */ c oAx;

        {
            this.oAx = r1;
        }

        public final boolean uF() {
            if (this.oAx.released) {
                return false;
            }
            try {
                if (!this.oAx.isPlaying()) {
                    return true;
                }
                int currentPosition = this.oAx.getCurrentPosition();
                if (this.oAx.ozV != null) {
                    this.oAx.ozV.sX(currentPosition);
                }
                x.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[]{Integer.valueOf(currentPosition), Integer.valueOf(this.oAx.oAl), Integer.valueOf(this.oAx.oAm), Integer.valueOf(this.oAx.getDuration())});
                if (currentPosition < this.oAx.oAm) {
                    return true;
                }
                x.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[]{Integer.valueOf(this.oAx.oAm)});
                this.oAx.seekTo(this.oAx.oAl);
                return false;
            } catch (IllegalStateException e) {
                x.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[]{e.getMessage()});
                if (this.oAx.released) {
                    return false;
                }
                return true;
            }
        }
    };
    public a ozV;
    boolean released;

    public c() {
        int i = CaptureMMProxy.getInstance().getInt(w.a.xsQ, -1);
        if (i == 1) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.oAs = new d();
        } else if (i == 2) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.oAs = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.oAs = new b();
        } else {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.oAs = new d();
        }
        this.oAt.start();
        this.hHu = new ak(this.oAt.getLooper(), this.oAw, true);
    }

    public final void setLoop(int i, int i2) {
        this.oAl = i;
        this.oAm = i2;
        if (this.oAs != null) {
            this.oAs.setLoop(this.oAl, this.oAm);
        }
    }

    public final void setDataSource(String str) {
        this.oAs.setDataSource(str);
    }

    public final void release() {
        this.released = true;
        this.oAs.release();
        if (this.hHu != null) {
            this.hHu.TG();
        }
        if (this.oAt != null) {
            this.oAt.quit();
        }
    }

    public final void start() {
        this.oAs.start();
        this.hHu.J(30, 30);
    }

    public final void pause() {
        this.oAs.pause();
        this.hHu.TG();
    }

    public final void stop() {
        this.oAs.stop();
        this.hHu.TG();
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.c cVar) {
        this.oAs.a(cVar);
    }

    public final void setAudioStreamType(int i) {
        this.oAs.setAudioStreamType(i);
    }

    public final int getCurrentPosition() {
        return this.oAs.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.oAs != null) {
            return this.oAs.getDuration();
        }
        return 0;
    }

    public final void setSurface(Surface surface) {
        this.oAs.setSurface(surface);
    }

    public final boolean isPlaying() {
        return this.oAs.isPlaying();
    }

    public final void seekTo(int i) {
        this.oAs.seekTo(i);
    }

    public final void prepareAsync() {
        this.oAs.prepareAsync();
    }

    public final void setLooping(boolean z) {
        this.oAs.setLooping(z);
    }

    public final void a(a.a aVar) {
        this.oAs.a(aVar);
    }

    public final void a(d dVar) {
        this.oAs.a(dVar);
    }

    public final void a(b bVar) {
        this.oAs.a(bVar);
    }
}
