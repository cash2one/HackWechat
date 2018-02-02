package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class VideoAdPlayerUI$4 implements OnClickListener {
    final /* synthetic */ VideoAdPlayerUI rNx;

    VideoAdPlayerUI$4(VideoAdPlayerUI videoAdPlayerUI) {
        this.rNx = videoAdPlayerUI;
    }

    public final void onClick(View view) {
        if (VideoAdPlayerUI.q(this.rNx) != 0) {
            j.a(j$a.DetailInVideo, this.rNx.rNh, this.rNx.rNg, VideoAdPlayerUI.r(this.rNx), VideoAdPlayerUI.q(this.rNx), VideoAdPlayerUI.s(this.rNx), VideoAdPlayerUI.t(this.rNx), VideoAdPlayerUI.u(this.rNx), VideoAdPlayerUI.v(this.rNx), VideoAdPlayerUI.w(this.rNx), VideoAdPlayerUI.x(this.rNx));
        }
        if (VideoAdPlayerUI.e(this.rNx) != 0) {
            int i = VideoAdPlayerUI.a(this.rNx).qPt.qQr;
            if (VideoAdPlayerUI.b(this.rNx) && VideoAdPlayerUI.a(this.rNx).qPt.qQv != 0) {
                i += (int) (bh.bA(VideoAdPlayerUI.a(this.rNx).qPt.qQv) / 1000);
            }
            k iVar = new i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(this.rNx) + "," + VideoAdPlayerUI.g(this.rNx) + "," + bh.Wo() + "," + VideoAdPlayerUI.h(this.rNx) + "," + VideoAdPlayerUI.i(this.rNx), (int) bh.Wo());
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
        }
        this.rNx.finish();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(this.rNx));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", VideoAdPlayerUI.z(this.rNx));
        intent.putExtra("useJs", true);
        if (VideoAdPlayerUI.A(this.rNx)) {
            k cVar = new c(VideoAdPlayerUI.B(this.rNx), 18, 6, "", 2, VideoAdPlayerUI.C(this.rNx).bxW());
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
        }
        new af(Looper.getMainLooper()).post(new 1(this, intent));
    }
}
