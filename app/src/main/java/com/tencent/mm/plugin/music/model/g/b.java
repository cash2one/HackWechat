package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.av.a;
import com.tencent.mm.sdk.platformtools.ag;

public abstract class b {
    protected a fAA;
    protected i oMg;
    protected j oMh = new j();

    public abstract void Gv(String str);

    public abstract String beA();

    public abstract boolean bey();

    public abstract int bez();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public final void a(i iVar) {
        this.oMg = iVar;
    }

    public final void m(a aVar) {
        this.fAA = aVar;
    }

    protected void gW(boolean z) {
        if (this.oMg != null) {
            ag.y(new 1(this, z));
        }
    }

    protected final void onStart() {
        if (this.oMg != null) {
            ag.y(new 2(this));
        }
    }

    protected final void tF(int i) {
        if (this.oMg != null) {
            ag.y(new 3(this, i));
        }
    }

    protected void gX(boolean z) {
        if (this.oMg != null) {
            ag.y(new 4(this, z));
        }
    }
}
