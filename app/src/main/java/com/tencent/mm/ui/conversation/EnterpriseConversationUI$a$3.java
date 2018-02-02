package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$3 implements OnItemClickListener {
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$3(a aVar) {
        this.yZh = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = null;
        ae aeVar = (ae) a.f(this.yZh).getItem(i);
        if (aeVar == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.f(this.yZh).getCount())});
            a.f(this.yZh).notifyDataSetChanged();
        } else if (f.eE(aeVar.field_username)) {
            Intent intent = new Intent(this.yZh.thisActivity(), BizChatConversationUI.class);
            intent.putExtra("Contact_User", aeVar.field_username);
            intent.putExtra("biz_chat_from_scene", 7);
            intent.addFlags(67108864);
            this.yZh.startActivity(intent);
        } else if (f.jY(aeVar.field_username)) {
            d jS = f.jS(aeVar.field_username);
            if (jS != null) {
                str = jS.Li();
            }
            if (str == null) {
                str = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", aeVar.field_username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bm.d.b(this.yZh.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
            a.a(this.yZh, jS, 2, aeVar.field_unReadCount);
        } else {
            this.yZh.ui.startChatting(aeVar.field_username, null, true);
            a.a(this.yZh, f.jS(aeVar.field_username), 1, aeVar.field_unReadCount);
        }
    }
}
