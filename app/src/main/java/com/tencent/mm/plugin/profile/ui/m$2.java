package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URI;
import java.net.URL;

class m$2 implements OnClickListener {
    final /* synthetic */ m pjK;

    m$2(m mVar) {
        this.pjK = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
        if (f.fdS == 1) {
            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bh.k(this.pjK.context, addFlags)) {
                this.pjK.context.startActivity(addFlags);
                return;
            }
            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
        }
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
            com_tencent_mm_plugin_downloader_model_g_a.xN("qqpim.apk");
            com_tencent_mm_plugin_downloader_model_g_a.xL(toURL.toString());
            com_tencent_mm_plugin_downloader_model_g_a.ep(true);
            com_tencent_mm_plugin_downloader_model_g_a.ox(1);
            com.tencent.mm.plugin.downloader.model.f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
        } catch (Exception e) {
            x.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[]{e.toString()});
        }
    }
}
