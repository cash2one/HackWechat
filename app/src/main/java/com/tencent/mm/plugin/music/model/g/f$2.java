package com.tencent.mm.plugin.music.model.g;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.model.c.a.b;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements b {
    final /* synthetic */ f oMH;

    f$2(f fVar) {
        this.oMH = fVar;
    }

    public final void tC(int i) {
        if (i == 1) {
            if (this.oMH.oMs != null && !this.oMH.oKF && this.oMH.oMr != null) {
                this.oMH.oMr.Gv(g.b(this.oMH.oMs.fAA, this.oMH.oMs.mrc));
                f fVar = this.oMH;
                if (h.bdC().requestFocus()) {
                    x.i("MicroMsg.Music.MusicPlayer", "startPlay");
                    try {
                        if (fVar.oMr != null) {
                            fVar.oMr.play();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                    }
                    fVar.oKF = true;
                    fVar.oMt = false;
                    return;
                }
                x.e("MicroMsg.Music.MusicPlayer", "request focus error");
            }
        } else if (i == -2 || i == 5 || i == 19) {
            ag.y(new 1(this, i));
        } else if (i == -1 || i == 6 || i == 4) {
            ag.y(new Runnable(this) {
                final /* synthetic */ f$2 oMJ;

                {
                    this.oMJ = r1;
                }

                public final void run() {
                    Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewS), 1).show();
                }
            });
            f.a(this.oMH, h.bdz().bdo(), i);
        }
    }
}
