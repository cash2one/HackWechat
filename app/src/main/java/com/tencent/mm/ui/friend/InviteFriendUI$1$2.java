package com.tencent.mm.ui.friend;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.ui.friend.InviteFriendUI.1;
import java.util.HashMap;

class InviteFriendUI$1$2 implements b {
    final /* synthetic */ HashMap zcQ;
    final /* synthetic */ PackageManager zcR;
    final /* synthetic */ 1 zcS;

    InviteFriendUI$1$2(1 1, HashMap hashMap, PackageManager packageManager) {
        this.zcS = 1;
        this.zcQ = hashMap;
        this.zcR = packageManager;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        textView.setText(((ResolveInfo) this.zcQ.get(menuItem.getTitle())).loadLabel(this.zcR).toString());
    }
}
