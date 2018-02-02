package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreDetailUI$16 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$16(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + w.cfi());
        String str = this.lDM.getString(R.l.dZH) + w.cfi();
        Intent intent = new Intent();
        intent.putExtra("title", this.lDM.getString(R.l.eao));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.lDM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
