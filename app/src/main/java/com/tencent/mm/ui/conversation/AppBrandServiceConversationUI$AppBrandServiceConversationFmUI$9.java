package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9 implements OnItemClickListener {
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.yVG = appBrandServiceConversationFmUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppBrandServiceConversationFmUI.access$402(this.yVG, (ae) AppBrandServiceConversationFmUI.access$100(this.yVG).getItem(i));
        aj access$400 = AppBrandServiceConversationFmUI.access$400(this.yVG);
        if (access$400 == null) {
            x.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(AppBrandServiceConversationFmUI.access$100(this.yVG).getCount())});
            AppBrandServiceConversationFmUI.access$100(this.yVG).notifyDataSetChanged();
            return;
        }
        AppBrandServiceConversationFmUI.access$502(this.yVG, access$400.field_username);
        Bundle bundle = new Bundle();
        bundle.putBoolean("finish_direct", false);
        bundle.putBoolean("key_need_send_video", false);
        bundle.putString("key_scene_id", AppBrandServiceConversationFmUI.access$000(this.yVG));
        bundle.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationFmUI.access$600(this.yVG));
        this.yVG.ui.startChatting(access$400.field_username, bundle, true);
        this.yVG.entryCustomerMsgDialogReport(access$400.field_username, AppBrandServiceConversationFmUI.access$600(this.yVG));
    }
}
