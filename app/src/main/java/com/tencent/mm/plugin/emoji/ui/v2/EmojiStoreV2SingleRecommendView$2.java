package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class EmojiStoreV2SingleRecommendView$2 extends c<cs> {
    final /* synthetic */ EmojiStoreV2SingleRecommendView lHV;

    EmojiStoreV2SingleRecommendView$2(EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView) {
        this.lHV = emojiStoreV2SingleRecommendView;
        this.xen = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        if (csVar instanceof cs) {
            EmojiStoreV2SingleRecommendView.a(this.lHV, csVar.fqU.fqW);
            if (!bh.ov(csVar.fqU.fqV) && csVar.fqU.fqV.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.c(this.lHV))) {
                EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = this.lHV;
                String str = csVar.fqU.fqV;
                int i = csVar.fqU.status;
                int i2 = csVar.fqU.progress;
                String str2 = csVar.fqU.fqW;
                x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    emojiStoreV2SingleRecommendView.m(obtain);
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", new Object[]{Integer.valueOf(i)});
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt(DownloadInfo.STATUS, i);
                    obtain2.what = 131076;
                    emojiStoreV2SingleRecommendView.m(obtain2);
                }
            }
        }
        return false;
    }
}
