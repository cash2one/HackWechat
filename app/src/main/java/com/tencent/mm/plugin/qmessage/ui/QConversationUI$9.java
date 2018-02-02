package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.storage.ae;

class QConversationUI$9 implements OnItemClickListener {
    final /* synthetic */ QConversationUI pnT;

    QConversationUI$9(QConversationUI qConversationUI) {
        this.pnT = qConversationUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar = (ae) QConversationUI.b(this.pnT).getItem(i);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", aeVar.field_username);
        intent.putExtra("key_need_send_video", false);
        a.ifs.e(intent, this.pnT.mController.xIM);
    }
}
