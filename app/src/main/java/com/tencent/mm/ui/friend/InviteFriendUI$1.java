package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class InviteFriendUI$1 implements OnClickListener {
    final /* synthetic */ InviteFriendUI zcP;

    InviteFriendUI$1(InviteFriendUI inviteFriendUI) {
        this.zcP = inviteFriendUI;
    }

    public final void onClick(View view) {
        String string;
        switch (InviteFriendUI.a(this.zcP)) {
            case 0:
                new g(this.zcP, new 5(this)).q(new int[]{o.bY(InviteFriendUI.b(this.zcP))});
                return;
            case 1:
                ar.Hg();
                String str = (String) c.CU().get(42, "");
                if (str == null || str.length() == 0) {
                    ar.Hg();
                    str = (String) c.CU().get(2, "");
                }
                string = this.zcP.getString(R.l.epT, new Object[]{str});
                Uri parse = Uri.parse("smsto:" + InviteFriendUI.b(this.zcP));
                Intent intent = new Intent("android.intent.action.SENDTO", parse);
                intent.putExtra("sms_body", string);
                PackageManager packageManager = this.zcP.getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                HashMap hashMap = new HashMap();
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                        hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                    }
                }
                if (hashMap.size() == 1) {
                    Iterator it = hashMap.keySet().iterator();
                    if (it.hasNext()) {
                        str = (String) it.next();
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                        intent2.setAction("android.intent.action.SENDTO");
                        intent2.setData(parse);
                        intent2.putExtra("sms_body", string);
                        this.zcP.startActivity(intent2);
                        InviteFriendUI.c(this.zcP);
                        return;
                    }
                    return;
                } else if (hashMap.size() > 1) {
                    l lVar = new l(this.zcP);
                    lVar.zlt = new 1(this, hashMap, packageManager);
                    lVar.zlu = new 2(this, hashMap, packageManager);
                    lVar.rKC = new 3(this, hashMap);
                    lVar.rKD = new 4(this, hashMap, parse, string);
                    lVar.bBX();
                    InviteFriendUI.c(this.zcP);
                    return;
                } else {
                    Toast.makeText(this.zcP, R.l.eJv, 1).show();
                    return;
                }
            case 2:
                h hVar = new h(this.zcP, new 6(this));
                String e = InviteFriendUI.e(this.zcP);
                string = InviteFriendUI.b(this.zcP);
                ar.CG().a(489, hVar);
                Cursor kZ = af.OL().kZ(e);
                if (kZ == null || kZ.getCount() <= 1) {
                    hVar.ZP(string);
                } else {
                    hVar.n(kZ);
                }
                if (kZ != null) {
                    kZ.close();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
