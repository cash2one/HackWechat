package com.tencent.mm.pluginsdk.ui.tools;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class AppChooserUI$4 implements OnClickListener {
    final /* synthetic */ AppChooserUI vwh;

    AppChooserUI$4(AppChooserUI appChooserUI) {
        this.vwh = appChooserUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(this.vwh) != null) {
            int i = AppChooserUI.a(this.vwh).vwi;
            if (i == f.vwt) {
                if (AppChooserUI.b(this.vwh) != null && AppChooserUI.b(this.vwh).iol.isShowing()) {
                    AppChooserUI.a(this.vwh).vwi = f.vwu;
                    AppChooserUI.a(this.vwh).notifyDataSetChanged();
                }
                a aVar = new a();
                if (AppChooserUI.f(this.vwh) == 1) {
                    aVar.xL("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
                } else {
                    aVar.xL(AppChooserUI.h(this.vwh).Wg());
                }
                aVar.xN(AppChooserUI.h(this.vwh).bYk());
                aVar.ox(1);
                aVar.ep(true);
                com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE);
                v.bYu();
                v.BF(AppChooserUI.g(this.vwh));
                if (AppChooserUI.g(this.vwh) == 0) {
                    if (AppChooserUI.i(this.vwh)) {
                        g.pQN.h(11168, new Object[]{Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(this.vwh))});
                    } else {
                        g.pQN.h(11168, new Object[]{Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(this.vwh))});
                    }
                }
                if (AppChooserUI.g(this.vwh) == 1) {
                    g.pQN.h(12809, new Object[]{Integer.valueOf(5), ""});
                }
            } else if (i == f.vwv) {
                MMActivity mMActivity = this.vwh;
                long j = AppChooserUI.j(this.vwh);
                x.i("MicroMsg.AppChooserUI", "installRecommendApp");
                x.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[]{com.tencent.mm.plugin.downloader.model.f.aAd().bY(j).path});
                if (!q.e(mMActivity.mController.xIM, Uri.fromFile(new File(r1)))) {
                    ar.Hg();
                    c.CU().set(mMActivity.Cx(274560), Long.valueOf(0));
                    if (mMActivity.vvK != null) {
                        mMActivity.vvK.vwi = f.vwt;
                        mMActivity.vvK.notifyDataSetChanged();
                    }
                } else if (mMActivity.vvK != null) {
                    mMActivity.vvK.vwi = f.vwv;
                    mMActivity.vvK.notifyDataSetChanged();
                }
            }
        }
    }
}
