package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

class CustomSmileyPreviewUI$8 implements OnClickListener {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$8(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
    }

    public final void onClick(View view) {
        if (CustomSmileyPreviewUI.g(this.lBm) == null || CustomSmileyPreviewUI.g(this.lBm).wkv == null) {
            x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.lBm.mController.xIM, EmojiStoreV2DesignerUI.class);
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, CustomSmileyPreviewUI.g(this.lBm).wkv.wko);
        intent.putExtra("name", CustomSmileyPreviewUI.g(this.lBm).wkv.nfp);
        intent.putExtra("headurl", CustomSmileyPreviewUI.g(this.lBm).wkv.waN);
        intent.putExtra("extra_scence", 9);
        this.lBm.mController.xIM.startActivity(intent);
    }
}
