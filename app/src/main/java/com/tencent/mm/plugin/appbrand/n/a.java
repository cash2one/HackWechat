package com.tencent.mm.plugin.appbrand.n;

import android.database.Cursor;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.s;
import java.util.Map;
import org.xwalk.core.R$styleable;

public final class a implements com.tencent.mm.storage.as.a {
    public final void a(ae aeVar, as asVar) {
        if (aeVar != null && !bh.ov(aeVar.field_username)) {
            String str = aeVar.field_username;
            com.tencent.mm.l.a WO = ((h) g.h(h.class)).EY().WO(str);
            if (WO == null || ((int) WO.gJd) == 0) {
                x.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", str);
            } else if (com.tencent.mm.storage.x.fV(str) && !s.gR(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                aeVar.dH("appbrandcustomerservicemsg");
                ae WY = ((h) g.h(h.class)).Fd().WY("appbrandcustomerservicemsg");
                if (WY == null) {
                    x.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    WY = new ae("appbrandcustomerservicemsg");
                    WY.ciy();
                    a(aeVar, WY);
                    ((h) g.h(h.class)).Fd().d(WY);
                    return;
                }
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                WY.dH(null);
                a(aeVar, WY);
                ((h) g.h(h.class)).Fd().a(WY, "appbrandcustomerservicemsg");
            } else if (s.hm(str)) {
                x.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aeVar.dH(null);
            }
        }
    }

    private static void a(ae aeVar, ae aeVar2) {
        aj ajVar;
        au Ex;
        String str = null;
        Cursor c = ((h) g.h(h.class)).Fd().c(s.hfp, null, "appbrandcustomerservicemsg");
        if (c != null) {
            aj ajVar2;
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                ajVar2 = null;
            } else {
                ajVar2 = new ae();
                ajVar2.b(c);
            }
            c.close();
            ajVar = ajVar2;
        } else {
            ajVar = null;
        }
        if (ajVar != null) {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", ajVar.field_username);
            Ex = ((h) g.h(h.class)).aZi().Ex(ajVar.field_username);
        } else {
            x.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            Ex = ((h) g.h(h.class)).aZi().Ex(aeVar.field_username);
        }
        if (Ex == null || Ex.field_msgId <= 0) {
            x.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            aeVar2.ciy();
            return;
        }
        aeVar2.ac(Ex);
        aeVar2.setContent(Ex.field_talker + ":" + Ex.field_content);
        aeVar2.dE(Integer.toString(Ex.getType()));
        b uw = ((h) g.h(h.class)).Fd().uw();
        if (uw != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            Ex.dS(aeVar.field_parentRef);
            Ex.setContent(aeVar2.field_content);
            uw.a(Ex, pString, pString2, pInt, true);
            int type = Ex.getType();
            String str2 = Ex.field_content;
            if (!bh.ov(str2)) {
                switch (type) {
                    case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                        Map y = bi.y(str2, "msg");
                        if (y != null) {
                            x.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", (String) y.get(".msg.appmsg.title"));
                            str = r0;
                            break;
                        }
                        break;
                }
            }
            aeVar2.dF(bh.ou(pString.value).concat(bh.ov(str) ? "" : " " + bh.ou(str)));
            aeVar2.dG(pString2.value);
            aeVar2.eS(pInt.value);
        }
    }
}
