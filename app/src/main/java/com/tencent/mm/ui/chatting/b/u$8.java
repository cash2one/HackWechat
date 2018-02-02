package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;

class u$8 implements OnItemClickListener {
    final /* synthetic */ u yAV;

    public u$8(u uVar) {
        this.yAV = uVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        au auVar = (au) this.yAV.ytQ.getItem(i);
        if (auVar != null && !bh.ov(auVar.field_talker)) {
            g.pQN.h(10450, new Object[]{Integer.valueOf(1)});
            Intent intent = new Intent(this.yAV.fhr.csq().getContext(), ChattingUI.class);
            intent.putExtra("Chat_User", auVar.field_talker);
            intent.putExtra("finish_direct", true);
            intent.putExtra("show_search_chat_content_result", false);
            intent.putExtra("msg_local_id", auVar.field_msgId);
            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
            this.yAV.fhr.csq().startActivity(intent);
        }
    }
}
