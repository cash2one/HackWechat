package com.tencent.mm.z;

import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;

class ar$5 implements a {
    final /* synthetic */ ar hgf;

    ar$5(ar arVar) {
        this.hgf = arVar;
    }

    public final void a(ae aeVar, as asVar) {
        if (aeVar != null) {
            if (!x.Wx(aeVar.field_username) && !x.Wz(aeVar.field_username) && !x.gy(aeVar.field_username) && !s.gF(aeVar.field_username)) {
                return;
            }
            au Ez;
            b uw;
            PString pString;
            PString pString2;
            PInt pInt;
            if (x.gy(aeVar.field_username)) {
                ae aeVar2;
                Object obj;
                aj WY = asVar.WY("floatbottle");
                if (WY == null) {
                    aeVar2 = new ae("floatbottle");
                    obj = 1;
                } else {
                    aj ajVar = WY;
                    obj = null;
                }
                aeVar2.eP(1);
                aeVar2.eO(k.FO());
                ar.Hg();
                Ez = c.Fa().Ez(" and not ( type = 10000 and isSend != 2 ) ");
                if (Ez == null || Ez.field_msgId <= 0) {
                    aeVar2.ciy();
                } else {
                    aeVar2.ac(Ez);
                    aeVar2.setContent(x.WD(Ez.field_talker) + ":" + Ez.field_content);
                    aeVar2.dE(Integer.toString(Ez.getType()));
                    uw = asVar.uw();
                    if (uw != null) {
                        pString = new PString();
                        pString2 = new PString();
                        pInt = new PInt();
                        Ez.dS("floatbottle");
                        Ez.setContent(aeVar2.field_content);
                        uw.a(Ez, pString, pString2, pInt, false);
                        aeVar2.dF(pString.value);
                        aeVar2.dG(pString2.value);
                        aeVar2.eS(pInt.value);
                    }
                }
                if (obj != null) {
                    asVar.d(aeVar2);
                } else {
                    asVar.a(aeVar2, aeVar2.field_username);
                }
            } else if (!x.Wx(aeVar.field_username) && !x.Wz(aeVar.field_username)) {
                if (s.gF(aeVar.field_username) && !bh.ov(aeVar.field_parentRef)) {
                    Object obj2;
                    Object obj3;
                    ae aeVar3;
                    aj WY2 = asVar.WY(aeVar.field_parentRef);
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.MMCore", "postConvExt, username = %s, parentRef = %s", aeVar.field_username, aeVar.field_parentRef);
                    if (aeVar.field_parentRef.equals("officialaccounts")) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (WY2 == null) {
                        WY2 = new ae(aeVar.field_parentRef);
                        if (obj2 != null) {
                            WY2.gb(2097152);
                        }
                        obj3 = 1;
                        aeVar3 = WY2;
                    } else {
                        obj3 = null;
                        aj ajVar2 = WY2;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCore", "enterprise cvs count is %d", Integer.valueOf(aeVar3.field_unReadCount));
                    ar.Hg();
                    String Xj = c.Fd().Xj(aeVar.field_parentRef);
                    ar.Hg();
                    Ez = c.Fa().Ex(Xj);
                    if (Ez == null || Ez.field_msgId <= 0) {
                        aeVar3.ciy();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMCore", "lastOfMsg is null or MsgId <= 0, lastConvBiz is %s", Xj);
                    } else {
                        aeVar3.ac(Ez);
                        aeVar3.setContent(Ez.field_talker + ":" + Ez.field_content);
                        aeVar3.dE(Integer.toString(Ez.getType()));
                        uw = asVar.uw();
                        if (uw != null) {
                            pString = new PString();
                            pString2 = new PString();
                            pInt = new PInt();
                            Ez.dS(aeVar.field_parentRef);
                            Ez.setContent(aeVar3.field_content);
                            uw.a(Ez, pString, pString2, pInt, true);
                            aeVar3.dF(pString.value);
                            aeVar3.dG(pString2.value);
                            aeVar3.eS(pInt.value);
                        }
                    }
                    Object obj4 = null;
                    if (obj2 != null) {
                        ar.Hg();
                        if (c.Fd().Xi(aeVar3.field_username) <= 0) {
                            obj4 = 1;
                        }
                    }
                    if (obj4 != null) {
                        asVar.WX(aeVar3.field_username);
                    } else if (obj3 != null) {
                        asVar.d(aeVar3);
                    } else {
                        asVar.a(aeVar3, aeVar3.field_username);
                    }
                }
                if ("@blacklist".equals(aeVar.field_parentRef)) {
                    ar.Hg();
                    af WO = c.EY().WO(aeVar.field_username);
                    if (WO != null && !bh.ov(WO.field_username) && !WO.AF()) {
                        ar.Hg();
                        c.Fd().d(new String[]{aeVar.field_username}, "");
                    }
                }
            }
        }
    }
}
