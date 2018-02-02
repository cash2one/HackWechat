package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

class EmojiStoreDetailUI$6 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$6(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lDM.mController.xIM, EmojiStoreV2DesignerUI.class);
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.b(this.lDM).waM.wko);
        intent.putExtra("name", EmojiStoreDetailUI.b(this.lDM).waM.nfp);
        intent.putExtra("headurl", EmojiStoreDetailUI.b(this.lDM).waM.waN);
        intent.putExtra("rediret_url", EmojiStoreDetailUI.b(this.lDM).waK);
        intent.putExtra("searchID", EmojiStoreDetailUI.d(this.lDM));
        intent.putExtra("extra_scence", 26);
        this.lDM.mController.xIM.startActivity(intent);
    }
}
