package com.tencent.mm.ui.account;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.plugin.accountsync.a.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pluginsdk.model.app.v.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;

class SimpleLoginUI$11 implements a {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$11(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final void Xo() {
        LinkedList linkedList;
        LinkedList linkedList2;
        Iterator it;
        String str;
        f aZ;
        LinkedList linkedList3 = null;
        v vVar = new v(this.xSL, new 1(this));
        SharedPreferences cft = ac.cft();
        if (cft != null) {
            String string = cft.getString("key_app_ids_registion_while_not_login", "");
            if (bh.ov(string)) {
                x.i("MicroMsg.AppUtil", "no saved appids while not login");
            } else {
                String[] split = string.split("\\|");
                if (split != null && split.length > 0) {
                    linkedList = new LinkedList();
                    int i = 1;
                    for (String str2 : split) {
                        if (!bh.ov(str2)) {
                            linkedList.add(str2);
                            i++;
                        }
                        if (i > 5) {
                            break;
                        }
                    }
                    linkedList2 = linkedList;
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        linkedList = new LinkedList();
                        it = linkedList2.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            aZ = g.aZ(str, false);
                            if (aZ != null || aZ.field_status == 0) {
                                linkedList.add(str);
                            }
                        }
                        linkedList3 = linkedList;
                    }
                    if (linkedList3 != null || linkedList3.isEmpty()) {
                        x.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
                        g.bYG();
                        if (vVar.veB != null) {
                            vVar.veB.bFx();
                        }
                    }
                    x.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", new Object[]{Integer.valueOf(linkedList3.size())});
                    an.aRi().a(7, vVar);
                    an.bim().at(linkedList3);
                    if (vVar.mContext == null || ((Activity) vVar.mContext).isFinishing()) {
                        if (vVar.veB != null) {
                            vVar.veB.bFx();
                        }
                        x.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
                        return;
                    }
                    Context context = vVar.mContext;
                    vVar.mContext.getString(R.l.dGO);
                    vVar.tipDialog = h.a(context, vVar.mContext.getString(R.l.dHc), true, new 1(vVar));
                    return;
                }
            }
        }
        linkedList2 = null;
        linkedList = new LinkedList();
        it = linkedList2.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            aZ = g.aZ(str, false);
            if (aZ != null) {
            }
            linkedList.add(str);
        }
        linkedList3 = linkedList;
        if (linkedList3 != null) {
        }
        x.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
        g.bYG();
        if (vVar.veB != null) {
            vVar.veB.bFx();
        }
    }
}
