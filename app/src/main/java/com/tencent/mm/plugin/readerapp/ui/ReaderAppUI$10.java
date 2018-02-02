package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.z.bf;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class ReaderAppUI$10 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ ReaderAppUI pAY;
    final /* synthetic */ bf pAZ;
    final /* synthetic */ int pBa;

    ReaderAppUI$10(ReaderAppUI readerAppUI, int i, bf bfVar, int i2) {
        this.pAY = readerAppUI;
        this.iGh = i;
        this.pAZ = bfVar;
        this.pBa = i2;
    }

    public final void onClick(View view) {
        if (20 == this.iGh) {
            Intent intent = new Intent();
            intent.putExtra("mode", 1);
            String url = this.pAZ.getUrl();
            intent.putExtra("news_svr_id", this.pAZ.hhm);
            intent.putExtra("news_svr_tweetid", this.pAZ.HH());
            intent.putExtra("rawUrl", ReaderAppUI.a(this.pAY, url));
            intent.putExtra("title", this.pAZ.getName());
            intent.putExtra("webpageTitle", this.pAZ.getTitle());
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            Bundle bundle = new Bundle();
            bundle.putInt("snsWebSource", 3);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("shortUrl", this.pAZ.HI());
            intent.putExtra(DownloadSettingTable$Columns.TYPE, this.pAZ.type);
            intent.putExtra("tweetid", this.pAZ.HH());
            intent.putExtra("geta8key_username", "newsapp");
            intent.putExtra("KPublisherId", "msg_" + Long.toString(this.pAZ.hhm));
            intent.putExtra("pre_username", "newsapp");
            intent.putExtra("prePublishId", "msg_" + Long.toString(this.pAZ.hhm));
            intent.putExtra("preUsername", "newsapp");
            intent.putExtra("preChatName", "newsapp");
            intent.putExtra("preMsgIndex", this.pBa);
            a.ifs.j(intent, this.pAY);
        }
    }
}
