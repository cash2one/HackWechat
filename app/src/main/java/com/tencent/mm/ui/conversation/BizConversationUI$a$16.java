package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$16 implements OnItemClickListener {
    final /* synthetic */ a yWk;

    BizConversationUI$a$16(a aVar) {
        this.yWk = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.a(this.yWk, (ae) a.e(this.yWk).getItem(i));
        a.a(this.yWk, a.f(this.yWk).field_username);
        aj f = a.f(this.yWk);
        if (f == null) {
            x.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.e(this.yWk).getCount())});
            a.e(this.yWk).notifyDataSetChanged();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("biz_click_item_unread_count", a.f(this.yWk).field_unReadCount);
        bundle.putInt("biz_click_item_position", i + 1);
        this.yWk.ui.startChatting(f.field_username, bundle, true);
        a.e(this.yWk).a(f, i);
    }
}
