package com.tencent.mm.plugin.music.model.d;

import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.q;
import com.google.android.exoplayer2.h.q$c;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.n;
import com.tencent.mm.plugin.music.model.d.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class a$a implements a {
    final /* synthetic */ a oLJ;

    private a$a(a aVar) {
        this.oLJ = aVar;
    }

    public final void ag(boolean z) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
    }

    public final void a(boolean z, int i) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "state [" + this.oLJ.ben() + ", " + z + ", " + b.tE(i) + "]");
        a aVar = this.oLJ;
        if (aVar.oLx != null) {
            boolean ib = aVar.oLx.ib();
            int ia = aVar.oLx.ia();
            if (ib && ia == 3) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                if (aVar.oLG != null) {
                    aVar.oLG.bep();
                }
            } else if (!ib && ia == 3 && aVar.oLw == 2) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                if (aVar.oLG != null) {
                    aVar.oLG.beq();
                }
            } else if (!ib && ia == 3 && aVar.oLw == 3) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                if (aVar.oLG != null) {
                    aVar.oLG.ber();
                }
            }
            int r = f.r(ib, ia);
            if (r != aVar.oLC.oLK[3]) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + ib + "," + ia + "]");
                aVar.oLC.q(ib, ia);
                if (r == f.r(true, 4)) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                    if (aVar.oLG != null) {
                        aVar.oLG.bet();
                        return;
                    }
                    return;
                }
                if (aVar.oLC.a(new int[]{f.r(false, 1), f.r(false, 2), f.r(false, 3)}, false)) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                    if (aVar.oLG != null) {
                        aVar.oLG.beo();
                    }
                } else if (((aVar.oLC.a(new int[]{100, 2, 3}, true) | aVar.oLC.a(new int[]{2, 100, 3}, true)) | aVar.oLC.a(new int[]{100, 3, 2, 3}, true)) != 0) {
                    x.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                    if (aVar.oLG != null) {
                        aVar.oLG.bes();
                    }
                } else {
                    if (aVar.oLC.a(new int[]{f.r(true, 3), f.r(true, 2)}, false)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                        aVar.cV(701, aVar.bem());
                        return;
                    }
                    if (aVar.oLC.a(new int[]{f.r(true, 2), f.r(true, 3)}, false)) {
                        x.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                        aVar.cV(702, aVar.bem());
                    }
                }
            }
        }
    }

    public final void a(e eVar) {
        x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "playerFailed [" + this.oLJ.ben() + "]", new Object[0]);
        a aVar = this.oLJ;
        if (eVar != null) {
            Throwable cause = eVar.getCause();
            if (cause == null) {
                aVar.cU(-4999, -1);
            } else if (cause instanceof q$c) {
                if (cause.toString().contains("Unable to connect")) {
                    boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
                    x.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                    if (isNetworkConnected) {
                        aVar.cU(-4000, -3);
                        return;
                    } else {
                        aVar.cU(-4000, -2);
                        return;
                    }
                } else if (cause instanceof q.e) {
                    String th = cause.toString();
                    if (th.contains("403")) {
                        aVar.cU(-4000, -10);
                    } else if (th.contains("404")) {
                        aVar.cU(-4000, -11);
                    } else if (th.contains("500")) {
                        aVar.cU(-4000, -12);
                    } else if (th.contains("502")) {
                        aVar.cU(-4000, -13);
                    } else {
                        aVar.cU(-4000, -30);
                    }
                }
            } else if (cause instanceof n) {
                aVar.cU(-4001, -1);
            } else if (cause instanceof IllegalStateException) {
                aVar.cU(-4002, -1);
            } else if (cause instanceof b.a) {
                aVar.cU(-4003, -1);
            } else {
                aVar.cU(-4999, -1);
            }
        }
        x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "ExoPlaybackException", new Object[0]);
    }

    public final void ir() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
    }

    public final void a(p pVar) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(pVar.aew), Float.valueOf(pVar.pitch)}));
    }
}
