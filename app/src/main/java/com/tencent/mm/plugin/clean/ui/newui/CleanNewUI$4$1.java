package com.tencent.mm.plugin.clean.ui.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.clean.ui.newui.CleanNewUI.4;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URL;

class CleanNewUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 lhY;

    CleanNewUI$4$1(4 4) {
        this.lhY = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            x.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[]{new URL(this.lhY.lhX.lfU.getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), this.lhY.lhX.lfU.getString("md5")});
            g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
            com_tencent_mm_plugin_downloader_model_g_a.xN("wesecure.apk");
            com_tencent_mm_plugin_downloader_model_g_a.xL(r0.toString());
            com_tencent_mm_plugin_downloader_model_g_a.ep(true);
            com_tencent_mm_plugin_downloader_model_g_a.xO(r1);
            com_tencent_mm_plugin_downloader_model_g_a.ox(1);
            f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        g.pQN.a(282, 7, 1, false);
    }
}
