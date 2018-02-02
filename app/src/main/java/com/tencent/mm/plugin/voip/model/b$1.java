package com.tencent.mm.plugin.voip.model;

import android.os.Process;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b sjt;

    b$1(b bVar) {
        this.sjt = bVar;
    }

    public final void run() {
        Process.setThreadPriority(-19);
        x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
        int i = 0;
        while (this.sjt.siI && this.sjt.afZ != null) {
            int playbackHeadPosition;
            int m;
            try {
                playbackHeadPosition = this.sjt.afZ.getPlaybackHeadPosition();
            } catch (Exception e) {
                x.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[]{e});
                b.i(this.sjt);
                playbackHeadPosition = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b.d(this.sjt, b.j(this.sjt) - playbackHeadPosition);
            if (b.k(this.sjt) == 1) {
                b.e(this.sjt, playbackHeadPosition);
                b.a(this.sjt, currentTimeMillis);
                b.b(this.sjt, currentTimeMillis);
                b.l(this.sjt);
                b.c(this.sjt, currentTimeMillis);
            } else {
                m = playbackHeadPosition - b.m(this.sjt);
                if (m > b.n(this.sjt)) {
                    b.f(this.sjt, m);
                } else {
                    b.f(this.sjt, (int) (((((float) b.n(this.sjt)) * 49999.0f) / 50000.0f) + (((float) m) / 50000.0f)));
                }
                b.c(this.sjt, currentTimeMillis);
                if (b.o(this.sjt) == 0) {
                    b.g(this.sjt, b.p(this.sjt) + b.q(this.sjt));
                } else if (currentTimeMillis > b.r(this.sjt) + 5000) {
                    b.b(this.sjt, currentTimeMillis);
                    if (b.n(this.sjt) < (b.p(this.sjt) >> 1)) {
                        b.g(this.sjt, b.p(this.sjt) - (b.q(this.sjt) >> 2));
                    }
                    if (b.n(this.sjt) > b.p(this.sjt)) {
                        b.g(this.sjt, b.n(this.sjt));
                    }
                }
                if (b.p(this.sjt) < b.s(this.sjt)) {
                    b.g(this.sjt, b.s(this.sjt));
                }
                if (b.p(this.sjt) < b.q(this.sjt)) {
                    b.g(this.sjt, b.q(this.sjt));
                }
                if (m > 0) {
                    b.e(this.sjt, playbackHeadPosition);
                }
            }
            if (playbackHeadPosition != 0 && this.sjt.siK) {
                b.t(this.sjt);
            }
            if (this.sjt.siT != null) {
                b.h(this.sjt, b.u(this.sjt) + this.sjt.hXm);
                if (b.a(this.sjt) == 0) {
                    playbackHeadPosition = this.sjt.siT.L(b.v(this.sjt), this.sjt.hXm);
                } else {
                    System.currentTimeMillis();
                    if (b.b(this.sjt) >= this.sjt.hXm) {
                        synchronized (b.f(this.sjt)) {
                            System.arraycopy(b.g(this.sjt), 0, b.v(this.sjt), 0, this.sjt.hXm);
                            m = b.b(this.sjt) - this.sjt.hXm;
                            System.arraycopy(b.g(this.sjt), this.sjt.hXm, b.w(this.sjt), 0, m);
                            System.arraycopy(b.w(this.sjt), 0, b.g(this.sjt), 0, m);
                            b.b(this.sjt, b.b(this.sjt) - this.sjt.hXm);
                        }
                        playbackHeadPosition = 0;
                    } else if (b.o(this.sjt) >= (b.x(this.sjt) * 5) / 1000 || b.y(this.sjt) != 0) {
                        a.yN(2);
                    } else {
                        b.i(this.sjt, 1);
                        playbackHeadPosition = this.sjt.siT.L(b.v(this.sjt), this.sjt.hXm);
                        b.i(this.sjt, 0);
                    }
                }
                if (playbackHeadPosition < 0) {
                    a.yN(5);
                    x.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + playbackHeadPosition);
                } else if (b.z(this.sjt)) {
                    x.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + b.z(this.sjt));
                    a.yN(10);
                } else {
                    b.a(this.sjt, currentTimeMillis);
                    if (b.A(this.sjt) < this.sjt.hXm) {
                        System.arraycopy(b.v(this.sjt), 0, b.B(this.sjt), i, b.A(this.sjt) - i);
                        playbackHeadPosition = this.sjt.afZ.write(b.B(this.sjt), 0, b.B(this.sjt).length);
                        if (playbackHeadPosition < 0) {
                            b.j(this.sjt, playbackHeadPosition);
                            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                        }
                        b.k(this.sjt, b.j(this.sjt) + (b.B(this.sjt).length >> 1));
                        playbackHeadPosition = b.A(this.sjt) - i;
                        i = this.sjt.hXm - playbackHeadPosition;
                        while (i >= b.A(this.sjt)) {
                            this.sjt.afZ.write(b.v(this.sjt), playbackHeadPosition, b.A(this.sjt));
                            playbackHeadPosition += b.A(this.sjt);
                            i -= b.A(this.sjt);
                            b.k(this.sjt, b.j(this.sjt) + (b.A(this.sjt) >> 1));
                        }
                        System.arraycopy(b.v(this.sjt), playbackHeadPosition, b.B(this.sjt), 0, i);
                    } else if (!b.z(this.sjt)) {
                        playbackHeadPosition = this.sjt.afZ.write(b.v(this.sjt), 0, this.sjt.hXm);
                        if (playbackHeadPosition < 0) {
                            b.j(this.sjt, playbackHeadPosition);
                            x.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                        }
                        b.k(this.sjt, b.j(this.sjt) + (this.sjt.hXm >> 1));
                    }
                }
            } else {
                a.yN(10);
            }
        }
    }
}
