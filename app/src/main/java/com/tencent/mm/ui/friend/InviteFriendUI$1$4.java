package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.friend.InviteFriendUI.1;
import java.util.HashMap;

class InviteFriendUI$1$4 implements d {
    final /* synthetic */ HashMap zcQ;
    final /* synthetic */ 1 zcS;
    final /* synthetic */ Uri zcT;
    final /* synthetic */ String zcU;

    InviteFriendUI$1$4(1 1, HashMap hashMap, Uri uri, String str) {
        this.zcS = 1;
        this.zcQ = hashMap;
        this.zcT = uri;
        this.zcU = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(((ResolveInfo) this.zcQ.get(str)).activityInfo.packageName, ((ResolveInfo) this.zcQ.get(str)).activityInfo.name));
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(this.zcT);
        intent.putExtra("sms_body", this.zcU);
        this.zcS.zcP.startActivity(intent);
    }
}
