package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$3 implements OnClickListener {
    final /* synthetic */ String lAT;
    final /* synthetic */ String lAU;
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;
    final /* synthetic */ String lwx;

    EmojiStoreV2DesignerUI$3(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI, String str, String str2, String str3) {
        this.lFV = emojiStoreV2DesignerUI;
        this.lwx = str;
        this.lAT = str2;
        this.lAU = str3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lFV.J(this.lwx, this.lAT, this.lAU);
        this.lFV.aCu();
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.lwx});
        EmojiStoreV2DesignerUI.a(this.lFV, this.lwx);
    }
}
