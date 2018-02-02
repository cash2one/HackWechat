package com.tencent.mm.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$8 extends c<iq> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$8(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = iq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z;
        iq iqVar = (iq) bVar;
        Context context = iqVar.fza.context;
        if (context == null) {
            context = ac.getContext();
        }
        iq.b bVar2 = iqVar.fzb;
        String str = iqVar.fza.appId;
        WXMediaMessage wXMediaMessage = iqVar.fza.fzc;
        int i = iqVar.fza.showType;
        a aVar = iqVar.fza.fzd;
        Bundle bundle = iqVar.fza.fqh;
        if (context == null) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
            if (aVar != null) {
                aVar.cG(false);
            }
            z = false;
        } else if (bh.ov(str)) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
            if (aVar != null) {
                aVar.cG(false);
            }
            z = false;
        } else if (wXMediaMessage == null) {
            x.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
            if (aVar != null) {
                aVar.cG(false);
            }
            z = false;
        } else {
            f aZ = g.aZ(str, true);
            if (aZ == null) {
                x.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", new Object[]{str});
                if (aVar != null) {
                    aVar.cG(false);
                }
                z = false;
            } else if (aZ.field_status == 3) {
                x.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
                if (aVar != null) {
                    aVar.cG(false);
                }
                z = false;
            } else {
                z = g.a(context, aZ.field_packageName, wXMediaMessage, str, aZ.field_openId, i, aVar, bundle);
            }
        }
        bVar2.fze = z;
        return false;
    }
}
