package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

class SelectContactUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$17(SelectContactUI selectContactUI) {
        this.yUy = selectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List c = SelectContactUI.c(this.yUy, s.fa(SelectContactUI.a(this.yUy), 8192));
        c.remove(q.FS());
        boolean z = s.fa(SelectContactUI.a(this.yUy), Downloads.RECV_BUFFER_SIZE) && c.size() > 1;
        if (!z) {
            return SelectContactUI.b(this.yUy, SelectContactUI.a(this.yUy, s.fa(SelectContactUI.a(this.yUy), 8192)));
        }
        if (!SelectContactUI.c(this.yUy)) {
            SelectContactUI.d(this.yUy, true);
            SelectContactUI.d(this.yUy);
        }
        x.i("MicroMsg.SelectContactUI", "Create the chatroom");
        return true;
    }
}
