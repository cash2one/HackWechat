package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.s.5;
import java.util.List;

class s$5$2 implements d {
    final /* synthetic */ 5 ytW;

    s$5$2(5 5) {
        this.ytW = 5;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 0) {
            s.a(this.ytW.ytT, true);
            s.h(this.ytW.ytT);
        } else if (2 == menuItem.getItemId()) {
            Context context = s.b(this.ytW.ytT).getContext();
            x g = s.g(this.ytW.ytT);
            List e = s.e(this.ytW.ytT);
            boolean f = s.f(this.ytW.ytT);
            if (!(e == null || e.size() == 0)) {
                if (i.dd(e)) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                    h.a(context, context.getString(R.l.dXB), "", new ai$1(), null);
                } else if (i.a(e, null)) {
                    ai.a(context, g, e, f);
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                    h.a(context, context.getString(R.l.epD), "", context.getString(R.l.eEC), context.getString(R.l.dEn), new ai$2(context, g, e, f), null);
                }
            }
            this.ytW.ytT.crR();
            return;
        } else {
            s.a(this.ytW.ytT, false);
        }
        j.a(s.b(this.ytW.ytT).getContext(), s.e(this.ytW.ytT), s.f(this.ytW.ytT), s.g(this.ytW.ytT).field_username, this.ytW.ytT);
    }
}
