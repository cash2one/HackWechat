package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.media.MediaPlayer;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$i implements Runnable {
    double qtN;
    MediaPlayer que;
    final /* synthetic */ a rmk;
    int type;

    private a$i(a aVar) {
        this.rmk = aVar;
        this.qtN = -1.0d;
    }

    private void bdm() {
        x.i("MicroMsg.SightPlayController", "stopPlayer");
        try {
            if (this.que != null) {
                this.que.stop();
                this.que.release();
                this.que = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", new Object[]{e.getMessage()});
            this.que = null;
        }
    }

    public final double bsU() {
        if (this.que == null) {
            return 0.0d;
        }
        return (double) this.que.getCurrentPosition();
    }

    public final void run() {
        String str;
        String str2 = "MicroMsg.SightPlayController";
        String str3 = "do play sound, operation %s";
        Object[] objArr = new Object[1];
        switch (this.type) {
            case 0:
                str = "stop";
                break;
            case 1:
                str = "start";
                break;
            case 2:
                str = "pause";
                break;
            case 3:
                str = "resume";
                break;
            case 4:
                str = "seek";
                break;
            default:
                str = "unknown";
                break;
        }
        objArr[0] = str;
        x.i(str2, str3, objArr);
        switch (this.type) {
            case 0:
                bdm();
                return;
            case 1:
                bdm();
                if (!bh.ov(a.a(this.rmk))) {
                    try {
                        this.que = new j();
                        this.que.setDisplay(null);
                        this.que.reset();
                        this.que.setDataSource(a.a(this.rmk));
                        this.que.setAudioStreamType(3);
                        this.que.setOnErrorListener(new 1(this));
                        this.que.prepare();
                        this.que.start();
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", new Object[]{e.getMessage()});
                        x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[]{a.a(this.rmk)});
                        this.rmk.clear();
                        if (a.b(this.rmk) != null) {
                            a.b(this.rmk).xb(-1);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 2:
                try {
                    if (this.que != null && this.que.isPlaying()) {
                        this.que.pause();
                        return;
                    }
                    return;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", new Object[]{e2.getMessage()});
                    bdm();
                    return;
                }
            case 3:
                try {
                    if (this.que != null) {
                        this.que.start();
                        return;
                    }
                    return;
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", new Object[]{e22.getMessage()});
                    bdm();
                    return;
                }
            case 4:
                try {
                    x.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[]{Double.valueOf(this.qtN)});
                    this.que.seekTo((int) (this.qtN * 1000.0d));
                    return;
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", new Object[]{e222.getMessage()});
                    return;
                }
            default:
                return;
        }
    }
}
