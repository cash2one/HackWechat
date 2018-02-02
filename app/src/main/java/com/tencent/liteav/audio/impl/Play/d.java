package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;

public class d {
    static d a = new d();
    private static final String b = ("AudioCenter:" + d.class.getSimpleName());
    private Thread c;
    private AudioTrack d;
    private volatile boolean e = true;
    private boolean f = false;
    private volatile boolean g = false;
    private Context h = null;
    private int i = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
    private volatile boolean j = false;
    private int k = a.e;
    private int l = a.f;
    private int m = a.h;

    private d() {
    }

    public static d a() {
        return a;
    }

    public void b() {
        TXCLog.w(b, "mult-track-player start!");
        if (this.g) {
            TXCLog.e(b, "mult-track-player can not start because of has started!");
        } else if (this.k == 0 || this.l == 0) {
            TXCLog.e(b, "strat mult-track-player failed with invalid audio info , samplerate:" + this.k + ", channels:" + this.l);
        } else {
            this.g = true;
            if (this.c == null) {
                this.e = true;
                this.c = new 1(this, "AUDIO_TRACK");
                this.c.start();
            }
            TXCLog.w(b, "mult-track-player thread start finish!");
        }
    }

    public void c() {
        TXCLog.w(b, "mult-track-player stop!");
        if (this.g) {
            if (this.c != null) {
                this.e = false;
                try {
                    this.c.join();
                } catch (InterruptedException e) {
                }
                this.c = null;
            }
            this.i = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
            this.h = null;
            this.j = false;
            this.g = false;
            TXCLog.w(b, "mult-track-player stop finish!");
            return;
        }
        TXCLog.w(b, "mult-track-player can not stop because of not started yet!");
    }

    public synchronized void a(Context context, int i) {
        this.h = context;
        this.i = i;
        if (this.j) {
            com.tencent.liteav.audio.a.a(context, i);
        }
    }

    public boolean d() {
        return this.g;
    }
}
