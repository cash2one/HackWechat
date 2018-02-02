package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.net.URL;

class CleanNewUI$4 implements OnClickListener {
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$4(CleanNewUI cleanNewUI) {
        this.lhD = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "qq mgr btn click");
        g.pQN.a(714, 3, 1, false);
        if (!CleanNewUI.b(this.lhD)) {
            if (CleanNewUI.c(this.lhD)) {
                h.a(this.lhD, this.lhD.getString(R.l.dTE, new Object[]{bh.fK(CleanNewUI.d(this.lhD))}), "", this.lhD.getString(R.l.dEz), this.lhD.getString(R.l.dEn), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CleanNewUI$4 lhE;

                    {
                        this.lhE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            x.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[]{new URL(CleanNewUI.e(this.lhE.lhD).getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), CleanNewUI.e(this.lhE.lhD).getString("md5")});
                            a aVar = new a();
                            aVar.xN("wesecure.apk");
                            aVar.xL(r0.toString());
                            aVar.ep(true);
                            aVar.xO(r1);
                            aVar.ox(1);
                            f.aAd().a(aVar.lsE);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        }
                        g.pQN.a(714, 4, 1, false);
                    }
                }, null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            d.b(this.lhD.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
            g.pQN.a(714, 5, 1, false);
        }
    }
}
