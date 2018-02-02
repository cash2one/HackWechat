package com.tencent.mm.ag;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.List;

class a$1 implements p$a<p> {
    final /* synthetic */ String gIT;
    final /* synthetic */ WeakReference hoa;
    final /* synthetic */ a hob;

    a$1(a aVar, WeakReference weakReference, String str) {
        this.hob = aVar;
        this.hoa = weakReference;
        this.gIT = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        p pVar = (p) kVar;
        x.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.hoa != null) {
            this.hoa.get();
        }
        if (pVar == null) {
            x.e("MicroMsg.BizAttrRenovator", "scene == null");
        } else if (i == 0 && i2 == 0) {
            hh hhVar = (pVar.gJQ == null || pVar.gJQ.hmh.hmo == null) ? null : (hh) pVar.gJQ.hmh.hmo;
            if (hhVar == null) {
                x.e("MicroMsg.BizAttrRenovator", "resp is null.");
                return;
            }
            String str2 = "MicroMsg.BizAttrRenovator";
            String str3 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.gIT;
            objArr[1] = hhVar.vNh == null ? null : new String(hhVar.vNh.oz);
            objArr[2] = Integer.valueOf(hhVar.vNi == null ? 0 : hhVar.vNi.size());
            x.i(str2, str3, objArr);
            if (hhVar.vNi == null) {
                x.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                return;
            }
            boolean z;
            String str4 = this.gIT;
            List list = hhVar.vNi;
            if (bh.ov(str4)) {
                x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                z = false;
            } else {
                d jK = y.Mf().jK(str4);
                if (a.b(jK)) {
                    af WO = ((h) g.h(h.class)).EY().WO(str4);
                    if (WO == null || ((int) WO.gJd) == 0 || !WO.cia()) {
                        x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str4);
                        z = false;
                    } else {
                        if (bh.ov(WO.field_username)) {
                            WO.setUsername(str4);
                        }
                        z = a.a(WO, jK, list);
                    }
                } else {
                    x.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str4);
                    z = false;
                }
            }
            if (!z) {
                x.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
            } else if (hhVar.vNh != null) {
                z = (bh.ov(this.gIT) || bh.ov(bh.by(hhVar.vNh.oz))) ? false : y.Mf().fx("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", bh.by(hhVar.vNh.oz), "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", this.gIT}));
                x.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
            }
        } else {
            x.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(pVar.getType()));
        }
    }
}
