package com.tencent.mm.plugin.music.model.g;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements i {
    long oMG;
    final /* synthetic */ f oMH;

    f$1(f fVar) {
        this.oMH = fVar;
    }

    public final void n(a aVar) {
        x.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
        this.oMH.p(aVar.Qn());
    }

    public final void o(a aVar) {
        a bdo = h.bdz().bdo();
        if (bdo != null && bdo.a(aVar) && this.oMH.oMr != null && this.oMH.oMr.isPlaying()) {
            int bez = this.oMH.oMr.bez();
            int duration = this.oMH.oMr.getDuration();
            if (bez > 0 && duration > 0) {
                float f = ((float) bez) / ((float) duration);
                if (this.oMH.oMs != null) {
                    float f2;
                    com.tencent.mm.plugin.music.model.c.a aVar2 = this.oMH.oMs;
                    aVar2.oLp = f;
                    boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
                    if (aVar2.isStop && isNetworkConnected) {
                        if (aVar2.mrc) {
                            if (aVar2.fAA.field_songWifiFileLength != 0) {
                                f2 = ((float) aVar2.fAA.field_wifiDownloadedLength) / ((float) aVar2.fAA.field_songWifiFileLength);
                            }
                        } else if (aVar2.fAA.field_songFileLength != 0) {
                            f2 = ((float) aVar2.fAA.field_downloadedLength) / ((float) aVar2.fAA.field_songFileLength);
                        }
                        if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                            x.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected)});
                            aVar2.start();
                        }
                    }
                    if (this.oMH.oMs != null && this.oMH.oMs.isStop) {
                        Object obj;
                        com.tencent.mm.plugin.music.model.c.a aVar3 = this.oMH.oMs;
                        if (aVar3.mrc) {
                            if (aVar3.fAA.field_songWifiFileLength != 0) {
                                f2 = ((float) aVar3.fAA.field_wifiDownloadedLength) / ((float) aVar3.fAA.field_songWifiFileLength);
                            }
                            obj = null;
                            if (obj == null) {
                                x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                this.oMH.stopPlay();
                            }
                        } else {
                            if (aVar3.fAA.field_songFileLength != 0) {
                                f2 = ((float) aVar3.fAA.field_downloadedLength) / ((float) aVar3.fAA.field_songFileLength);
                            }
                            obj = null;
                            if (obj == null) {
                                x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                this.oMH.stopPlay();
                            }
                        }
                        if (f2 >= 1.0f) {
                            obj = 1;
                        } else {
                            if (f2 - f > 0.05f) {
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj == null) {
                            x.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                            this.oMH.stopPlay();
                        }
                    }
                }
                if (this.oMH.oKB != null) {
                    this.oMH.oKB.cj(bez, duration);
                }
            }
        }
    }

    public final void e(a aVar, boolean z) {
        x.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
        a bdo = h.bdz().bdo();
        if (bdo != null) {
            if (bdo.a(aVar)) {
                this.oMH.stopPlay();
            }
            asv Qn = aVar.Qn();
            this.oMH.s(Qn);
            if (z) {
                this.oMH.v(Qn);
            }
        }
    }

    public final void f(a aVar, boolean z) {
        a bdo = h.bdz().bdo();
        if (bdo != null) {
            x.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                f.a(this.oMH, aVar, 20);
            } else {
                f.a(this.oMH, aVar, 21);
            }
            asv Qn = aVar.Qn();
            if (bdo.a(aVar)) {
                x.i("MicroMsg.Music.MusicPlayer", "stop");
                this.oMH.stopPlay();
                if (z) {
                    x.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                    this.oMH.d(bdo, true);
                    this.oMH.oMs = new com.tencent.mm.plugin.music.model.c.a(bdo);
                    this.oMH.oMs.oLs = this.oMH.oMF;
                    this.oMH.oMs.start();
                    return;
                }
                ag.y(new Runnable(this) {
                    final /* synthetic */ f$1 oMI;

                    {
                        this.oMI = r1;
                    }

                    public final void run() {
                        if (System.currentTimeMillis() - this.oMI.oMG > 10000) {
                            this.oMI.oMG = System.currentTimeMillis();
                            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewQ), 0).show();
                        }
                    }
                });
                this.oMH.s(Qn);
                return;
            }
            x.i("MicroMsg.Music.MusicPlayer", "send stop event");
            this.oMH.s(Qn);
        }
    }
}
