package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.z.bf;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class ReaderItemListView$a$2 implements OnClickListener {
    final /* synthetic */ a pBA;
    final /* synthetic */ int pBB;

    ReaderItemListView$a$2(a aVar, int i) {
        this.pBA = aVar;
        this.pBB = i;
    }

    public final void onClick(View view) {
        int i = this.pBB;
        Intent intent = new Intent();
        intent.putExtra("mode", 1);
        String url = ((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).getUrl();
        if (url.contains("?")) {
            url = url + "&dt=2&cv=0x" + Integer.toHexString(d.vAz) + "&w=" + ReaderItemListView.f(this.pBA.pBz).widthPixels;
        } else {
            url = url + "?dt=2&cv=0x" + Integer.toHexString(d.vAz) + "&w=" + ReaderItemListView.f(this.pBA.pBz).widthPixels;
        }
        intent.putExtra("rawUrl", url);
        intent.putExtra("webpageTitle", ((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).getTitle());
        intent.putExtra("title", ReaderItemListView.g(this.pBA.pBz).getString(R.l.eoL));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        Bundle bundle = new Bundle();
        if (((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).type == 20) {
            bundle.putInt("snsWebSource", 3);
        } else {
            bundle.putInt("snsWebSource", 2);
        }
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("shortUrl", ((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).HI());
        intent.putExtra(DownloadSettingTable$Columns.TYPE, ((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).type);
        intent.putExtra("tweetid", ((bf) ReaderItemListView.a(this.pBA.pBz).get(i)).HH());
        intent.putExtra("geta8key_username", "blogapp");
        com.tencent.mm.plugin.readerapp.a.a.ifs.j(intent, ReaderItemListView.g(this.pBA.pBz));
    }
}
