package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.b.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private af handler;
    public Map<String, Integer> iUO;
    public List<r> qkX;
    public List<r> vec;
    private ak ved;

    public e() {
        this.vec = null;
        this.qkX = null;
        this.iUO = null;
        this.ved = new ak(new 1(this), false);
        this.handler = new 2(this, g.Dm().oAt.getLooper());
        this.vec = new ArrayList();
        this.qkX = new ArrayList();
        this.iUO = new HashMap();
        this.ved.J(600000, 600000);
    }

    public final void cP(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppIconService", "push fail, appId is null");
            return;
        }
        r rVar = new r(str, i);
        if (this.vec.contains(rVar)) {
            x.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
        } else if (this.vec.size() >= 5) {
            x.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.qkX.contains(rVar)) {
                this.qkX.add(rVar);
            }
        } else if (a(rVar)) {
            this.vec.add(rVar);
        }
    }

    final boolean a(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            return false;
        }
        int i;
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            i = 0;
        } else {
            Integer valueOf = Integer.valueOf(bh.a((Integer) this.iUO.get(rVar.toString()), 0));
            if (valueOf.intValue() >= 5) {
                x.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
                i = 0;
            } else {
                this.iUO.put(rVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
                i = 1;
            }
        }
        if (i == 0) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail");
            return false;
        }
        n RF = a.bin().RF(rVar.appId);
        if (RF == null) {
            x.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + rVar.appId);
            return false;
        }
        String str;
        switch (rVar.hNr) {
            case 1:
                if (RF.field_appIconUrl != null && RF.field_appIconUrl.length() != 0) {
                    str = RF.field_appIconUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + rVar.appId);
                return false;
            case 2:
                if (RF.field_appWatermarkUrl != null && RF.field_appWatermarkUrl.length() != 0) {
                    str = RF.field_appWatermarkUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + rVar.appId);
                return false;
            case 3:
                if (RF.fQL != null && RF.fQL.length() != 0) {
                    str = RF.fQL;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 4:
                if (RF.fQW != null && RF.fQW.length() != 0) {
                    str = RF.fQW;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 5:
                if (RF.fQX != null && RF.fQX.length() != 0) {
                    str = RF.fQX;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + rVar.appId);
                return false;
            default:
                x.e("MicroMsg.AppIconService", "push, unknown iconType = " + rVar.hNr);
                return false;
        }
        x.i("MicroMsg.AppIconService", "appIconUrl = " + str);
        com.tencent.mm.sdk.f.e.post(new s(this.handler, rVar.appId, rVar.hNr, str), "AppIconService_getIcon");
        return true;
    }
}
