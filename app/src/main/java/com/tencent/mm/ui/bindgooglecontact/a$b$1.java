package com.tencent.mm.ui.bindgooglecontact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindgooglecontact.a.b;

class a$b$1 implements OnClickListener {
    final /* synthetic */ a ykP;
    final /* synthetic */ b ykQ;

    a$b$1(b bVar, a aVar) {
        this.ykQ = bVar;
        this.ykP = aVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
        if (a.a(this.ykQ.ykO) != null) {
            a.a(this.ykQ.ykO).Fj(this.ykQ.position);
        }
    }
}
