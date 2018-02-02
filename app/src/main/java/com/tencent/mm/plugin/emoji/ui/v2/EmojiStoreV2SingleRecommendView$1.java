package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class EmojiStoreV2SingleRecommendView$1 extends af {
    final /* synthetic */ EmojiStoreV2SingleRecommendView lHV;

    EmojiStoreV2SingleRecommendView$1(EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView) {
        this.lHV = emojiStoreV2SingleRecommendView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 131075:
                int i = message.getData().getInt("progress");
                if (bh.ov(message.getData().getString("product_id"))) {
                    x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    return;
                }
                if (EmojiStoreV2SingleRecommendView.a(this.lHV) != null) {
                    EmojiStoreV2SingleRecommendView.a(this.lHV).setVisibility(8);
                }
                if (EmojiStoreV2SingleRecommendView.b(this.lHV) != null) {
                    EmojiStoreV2SingleRecommendView.b(this.lHV).setVisibility(0);
                    EmojiStoreV2SingleRecommendView.b(this.lHV).setProgress(i);
                    return;
                }
                return;
            case 131076:
                message.getData().getInt(DownloadInfo.STATUS);
                if (bh.ov(message.getData().getString("product_id"))) {
                    x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                    return;
                }
                if (EmojiStoreV2SingleRecommendView.a(this.lHV) != null) {
                    EmojiStoreV2SingleRecommendView.a(this.lHV).setVisibility(0);
                }
                if (EmojiStoreV2SingleRecommendView.b(this.lHV) != null) {
                    EmojiStoreV2SingleRecommendView.b(this.lHV).setVisibility(8);
                    EmojiStoreV2SingleRecommendView.b(this.lHV).setProgress(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
