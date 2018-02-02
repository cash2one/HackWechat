package com.tencent.mm.plugin.music.model.g;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b {
    MediaPlayer hXM = new j();
    a oMl;
    boolean otH = true;

    private class a implements Runnable {
        boolean isStop;
        final /* synthetic */ d oMm;

        private a(d dVar) {
            this.oMm = dVar;
            this.isStop = true;
        }

        public final void run() {
            x.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (this.oMm.hXM != null && this.oMm.hXM.isPlaying()) {
                        int currentPosition = this.oMm.hXM.getCurrentPosition();
                        int duration = this.oMm.hXM.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            this.oMm.tF((currentPosition * 100) / duration);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
                }
            }
        }
    }

    public d() {
        this.hXM.setAudioStreamType(3);
        this.hXM.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ d oMm;

            {
                this.oMm = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                x.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
                this.oMm.gX(true);
            }
        });
        this.hXM.setOnSeekCompleteListener(new 2(this));
        this.hXM.setOnPreparedListener(new OnPreparedListener(this) {
            final /* synthetic */ d oMm;

            {
                this.oMm = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (this.oMm.hXM != null) {
                    x.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                    try {
                        this.oMm.hXM.start();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                    this.oMm.otH = false;
                    this.oMm.onStart();
                    if (this.oMm.oMl != null) {
                        this.oMm.oMl.isStop = true;
                    }
                    this.oMm.oMl = new a();
                    Runnable runnable = this.oMm.oMl;
                    runnable.isStop = false;
                    e.post(runnable, "music_play_progress_runnable");
                }
            }
        });
        this.hXM.setOnErrorListener(new 4(this));
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            z = this.hXM.isPlaying();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
        }
        return z;
    }

    public final boolean bey() {
        return !this.otH;
    }

    public final void Gv(String str) {
        x.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[]{str});
        try {
            this.hXM.setDataSource(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
        }
    }

    public final int bez() {
        return this.hXM.getCurrentPosition();
    }

    public final int getDuration() {
        return this.hXM.getDuration();
    }

    public final void play() {
        x.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (bey()) {
            try {
                if (!this.hXM.isPlaying()) {
                    this.hXM.start();
                    return;
                }
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                return;
            }
        }
        try {
            this.hXM.prepareAsync();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.otH = true;
        try {
            if (this.hXM != null) {
                this.hXM.stop();
                this.hXM.release();
            }
            if (this.oMl != null) {
                this.oMl.isStop = true;
                this.oMl = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        gX(false);
    }

    public final void pause() {
        x.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (bey()) {
            this.hXM.pause();
        }
    }

    public final void seek(long j) {
        x.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[]{Long.valueOf(j)});
        this.hXM.seekTo((int) j);
    }

    public final String beA() {
        return null;
    }
}
