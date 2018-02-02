package com.tencent.mm.ag;

import com.tencent.mm.ag.e.a;
import com.tencent.mm.ag.e.a.b;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.s;

class y$2 implements a {
    final /* synthetic */ y hqy;

    y$2(y yVar) {
        this.hqy = yVar;
    }

    public final void a(b bVar) {
        if ((bVar.hpD == a.a.hpz || bVar.hpD == a.a.hpB) && bVar.hpE != null) {
            af WO = ((h) g.h(h.class)).EY().WO(bVar.hog);
            if (WO == null) {
                return;
            }
            if (!WO.cia()) {
                y.h(bVar.hpE);
            } else if (!s.gR(WO.field_username)) {
                aj WY = ((h) g.h(h.class)).Fd().WY(bVar.hog);
                x.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", new Object[]{bVar.hog});
                if (!(!bVar.hpE.Lf() || bVar.hpE.bI(false) == null || bVar.hpE.bI(false).LG() == null || bh.ov(bVar.hpE.Lm()) || !bh.ov(bVar.hpE.field_enterpriseFather))) {
                    bVar.hpE.field_enterpriseFather = bVar.hpE.Lm();
                    y.Mf().e(bVar.hpE);
                    x.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", new Object[]{bVar.hog, bVar.hpE.field_enterpriseFather});
                }
                if (WY != null) {
                    int i;
                    boolean z;
                    if (bVar.hpE.Lf()) {
                        if (bVar.hpE.bI(false) == null) {
                            x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            return;
                        } else if (bVar.hpE.bI(false).LG() == null) {
                            x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            return;
                        } else {
                            String str = WY.field_parentRef;
                            if (bVar.hpE.Lg()) {
                                WY.dH(null);
                            } else {
                                x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", new Object[]{bVar.hpE.Lm(), bVar.hog});
                                WY.dH(bh.ou(bVar.hpE.Lm()));
                            }
                            if (str != null && WY.field_parentRef != null && !str.equals(WY.field_parentRef)) {
                                i = 1;
                            } else if (str == null && WY.field_parentRef != null) {
                                i = 1;
                            } else if (str == null || WY.field_parentRef != null) {
                                z = false;
                            } else {
                                i = 1;
                            }
                            x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", new Object[]{bVar.hog, WY.field_parentRef});
                        }
                    } else if (bVar.hpE.Le()) {
                        x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", new Object[]{bVar.hog});
                        i = 1;
                    } else if (!bVar.hpE.Lb() && !s.hl(WO.field_username) && !"officialaccounts".equals(WY.field_parentRef)) {
                        WY.dH("officialaccounts");
                        i = 1;
                    } else if (!bVar.hpE.Lb() || WY.field_parentRef == null) {
                        z = false;
                    } else {
                        WY.dH(null);
                        i = 1;
                    }
                    if (i != 0) {
                        ((h) g.h(h.class)).Fd().a(WY, WY.field_username);
                        if (!bh.ov(WY.field_parentRef)) {
                            aj WY2;
                            String ciI;
                            cf Ex;
                            if ("officialaccounts".equals(WY.field_parentRef)) {
                                WY2 = ((h) g.h(h.class)).Fd().WY("officialaccounts");
                                if (WY2 == null) {
                                    aj aeVar = new ae("officialaccounts");
                                    aeVar.ciy();
                                    ((h) g.h(h.class)).Fd().d(aeVar);
                                    WY2 = aeVar;
                                }
                                if (bh.ov(WY2.field_content)) {
                                    x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                    ciI = ((h) g.h(h.class)).Fd().ciI();
                                    if (bh.ov(ciI)) {
                                        x.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                        return;
                                    }
                                    Ex = ((h) g.h(h.class)).aZi().Ex(ciI);
                                    if (Ex == null || Ex.field_msgId == 0) {
                                        x.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                        return;
                                    } else {
                                        ((h) g.h(h.class)).aZi().a(Ex.field_msgId, Ex);
                                        return;
                                    }
                                }
                                return;
                            }
                            x.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", new Object[]{bVar.hog, WY.field_parentRef});
                            WY2 = ((h) g.h(h.class)).Fd().WY(WY.field_parentRef);
                            if (WY2 != null && bh.ov(WY2.field_content)) {
                                x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                ciI = ((h) g.h(h.class)).Fd().Xj(WY.field_parentRef);
                                if (bh.ov(ciI)) {
                                    x.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                    return;
                                }
                                Ex = ((h) g.h(h.class)).aZi().Ex(ciI);
                                if (Ex == null || Ex.field_msgId == 0) {
                                    x.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                } else {
                                    ((h) g.h(h.class)).aZi().a(Ex.field_msgId, Ex);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
