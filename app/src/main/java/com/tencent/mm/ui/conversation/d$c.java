package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class d$c implements b {
    final /* synthetic */ d yWX;

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        String str = (String) obj;
        if (!d.a(this.yWX) && str != null && !str.equals("") && d.b(this.yWX) != null && d.b(this.yWX).containsKey(Integer.valueOf(i))) {
            d.b(this.yWX).remove(Integer.valueOf(i));
            d.c(this.yWX);
        }
    }
}
