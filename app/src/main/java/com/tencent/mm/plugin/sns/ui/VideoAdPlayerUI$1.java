package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class VideoAdPlayerUI$1 implements a {
    final /* synthetic */ VideoAdPlayerUI rNx;

    VideoAdPlayerUI$1(VideoAdPlayerUI videoAdPlayerUI) {
        this.rNx = videoAdPlayerUI;
    }

    public final void ie(boolean z) {
        if (z) {
            VideoAdPlayerUI.a(this.rNx).qPt.qQu = this.rNx.getResources().getConfiguration().orientation == 2 ? 2 : 1;
            VideoAdPlayerUI.a(this.rNx).qPt.qQv = bh.Wq();
            VideoAdPlayerUI.a(this.rNx).qPt.qQt = 2;
            VideoAdPlayerUI.a(this.rNx).qPt.qQr = 0;
        }
        if (!VideoAdPlayerUI.b(this.rNx) && ((int) VideoAdPlayerUI.c(this.rNx).btg()) == 0) {
            com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.rNx).qPt;
            aVar.qQp++;
        }
        VideoAdPlayerUI.a(this.rNx).qPt.qQv = bh.Wq();
        VideoAdPlayerUI.d(this.rNx).a(VideoAdPlayerUI.c(this.rNx));
        if (VideoAdPlayerUI.e(this.rNx) != 0) {
            k iVar = new i(13227, "1,1,0," + VideoAdPlayerUI.f(this.rNx) + "," + VideoAdPlayerUI.g(this.rNx) + "," + bh.Wo() + "," + VideoAdPlayerUI.h(this.rNx) + "," + VideoAdPlayerUI.i(this.rNx), (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
        VideoAdPlayerUI.a(this.rNx, true);
    }

    public final void bti() {
        VideoAdPlayerUI.d(this.rNx).bx(false);
        com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.rNx).qPt;
        aVar.qQr += (int) bh.bA(VideoAdPlayerUI.a(this.rNx).qPt.qQv);
        VideoAdPlayerUI.a(this.rNx, false);
    }

    public final void btj() {
        x.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
        com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.a(this.rNx).qPt;
        aVar.qQq++;
        VideoAdPlayerUI.a(this.rNx, false);
        if (VideoAdPlayerUI.e(this.rNx) != 0) {
            k iVar = new i(13227, "1,2," + VideoAdPlayerUI.i(this.rNx) + "," + VideoAdPlayerUI.f(this.rNx) + "," + VideoAdPlayerUI.g(this.rNx) + "," + bh.Wo() + "," + VideoAdPlayerUI.h(this.rNx) + "," + VideoAdPlayerUI.i(this.rNx), (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
    }

    public final void btk() {
        x.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
        VideoAdPlayerUI.a(this.rNx, false);
        VideoAdPlayerUI.c(this.rNx).btd();
    }

    public final void wn(int i) {
        if (VideoAdPlayerUI.i(this.rNx) == 0) {
            VideoAdPlayerUI.a(this.rNx, i);
            VideoAdPlayerUI.j(this.rNx).rNe = i;
        }
    }
}
