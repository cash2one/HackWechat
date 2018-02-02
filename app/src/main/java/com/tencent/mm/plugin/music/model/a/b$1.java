package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.plugin.music.model.a.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b oKy;

    b$1(b bVar) {
        this.oKy = bVar;
    }

    public final void onStart(String str) {
        e FV = this.oKy.FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
            return;
        }
        this.oKy.e(str, FV);
        synchronized (this.oKy.lKI) {
            this.oKy.oKr = false;
        }
        ag.K(this.oKy.oKx);
    }

    public final void Ge(String str) {
        e FV = this.oKy.FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
            return;
        }
        this.oKy.b(str, FV);
        this.oKy.f(str, FV);
        b.a(this.oKy);
        this.oKy.bdH();
    }

    public final void zN(String str) {
        e FV = this.oKy.FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
            return;
        }
        this.oKy.b(str, FV);
        this.oKy.f(str, FV);
        b.a(this.oKy);
        this.oKy.bdH();
    }

    public final void Gf(String str) {
        e FV = this.oKy.FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
            return;
        }
        this.oKy.b(str, FV);
        this.oKy.f(str, FV);
        b.a(this.oKy);
        this.oKy.bdH();
    }

    public final void onError(String str) {
        e FV = this.oKy.FV(str);
        if (FV == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
            return;
        }
        int intValue;
        Object obj;
        this.oKy.b(str, FV);
        b bVar = this.oKy;
        int i = FV.lJY;
        if (bVar.oKp.containsKey(str)) {
            intValue = ((Integer) bVar.oKp.get(str)).intValue();
        } else {
            intValue = 0;
        }
        if (intValue > 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
            bVar.oKp.remove(str);
        } else if (66 != i) {
            bVar.oKp.remove(str);
        } else if (bVar.Gd(str)) {
            bVar.oKp.put(str, Integer.valueOf(intValue + 1));
            obj = 1;
            if (obj == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
                this.oKy.bdL();
                this.oKy.a(str, null);
            }
            x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
            this.oKy.f(str, FV);
            b.a(this.oKy);
            this.oKy.bdH();
            return;
        }
        obj = null;
        if (obj == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
            this.oKy.f(str, FV);
            b.a(this.oKy);
            this.oKy.bdH();
            return;
        }
        x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
        this.oKy.bdL();
        this.oKy.a(str, null);
    }
}
