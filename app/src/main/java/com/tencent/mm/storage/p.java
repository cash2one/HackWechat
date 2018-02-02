package com.tencent.mm.storage;

import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.o;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.s;
import java.util.Iterator;

public final class p implements d, e {
    private as xmw;

    public p(as asVar) {
        y.Mr();
        this.xmw = asVar;
        this.xmw.a(this);
        this.xmw.a(this);
    }

    public final void a(au auVar, ae aeVar) {
        String str = null;
        if (aeVar != null && auVar != null && auVar.field_bizChatId != -1 && aeVar.gc(8388608)) {
            c ag = y.Mh().ag(auVar.field_bizChatId);
            String str2 = aeVar.field_digest;
            if (bh.ov(auVar.field_bizChatUserId)) {
                x.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", new Object[]{ag.field_bizChatServId, ag.field_chatName});
                return;
            }
            String str3;
            j ca = y.Mj().ca(auVar.field_bizChatUserId);
            if (ca != null) {
                str3 = ca.field_userName;
            } else {
                str3 = null;
            }
            boolean equals = auVar.field_bizChatUserId.equals(y.Mj().cb(auVar.field_talker));
            if (ca != null && equals) {
                aeVar.dF(ac.getContext().getString(b.dFB) + ":" + str2);
            } else if (!(ca == null || bh.ov(ca.field_userName))) {
                aeVar.dF(ca.field_userName + ":" + str2);
            }
            if (!ag.Mt()) {
                if (equals || str3 == null || str3.length() <= 0 || str3.equals(ag.field_chatName)) {
                    j ca2 = y.Mj().ca(ag.field_bizChatServId);
                    if (ca2 != null) {
                        str = ca2.field_userName;
                    }
                    if (str != null && str.length() > 0 && !str.equals(ag.field_chatName)) {
                        ag.field_chatName = str;
                        y.Mh().b(ag);
                        return;
                    }
                    return;
                }
                ag.field_chatName = str3;
                y.Mh().b(ag);
            }
        }
    }

    public final void a(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            return;
        }
        String str = cVar.talker;
        if (z) {
            if (!(auVar == null || auVar.field_isSend == 1 || (bc.k(auVar) & 1) == 0)) {
                x.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                aeVar.gb(4194304);
            }
            if (auVar != null && f.eE(str)) {
                x.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                aeVar.gb(8388608);
            }
        } else {
            af WO = ((h) g.h(h.class)).EY().WO(str);
            if (!(WO == null || !WO.cia() || a.fZ(WO.field_type) || auVar == null || auVar.field_isSend == 1 || aeVar.gc(4194304) || (aeVar.field_conversationTime >= y.Mr() && (bc.k(auVar) & 1) == 0))) {
                aeVar.gb(4194304);
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", new Object[]{str});
            }
            if (auVar != null && f.eE(str)) {
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", new Object[]{str});
                aeVar.gb(8388608);
            }
        }
        if (cVar != null && !cVar.ooV.isEmpty() && cVar.ooV.get(0) != null) {
            aeVar.eR(((au) cVar.ooV.get(0)).field_isSend);
            if (cVar.ooU.equals("insert")) {
                aeVar.xye = (au) cVar.ooV.get(cVar.ooV.size() - 1);
            }
        }
    }

    public final void b(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        int i;
        int i2;
        as Fd = ((h) g.h(h.class)).Fd();
        String str = cVar == null ? null : cVar.talker;
        if (cVar == null || !cVar.ooU.equals("delete") || cVar.ooY <= 0) {
            i = 0;
        } else {
            i = cVar.ooY;
        }
        if (cVar == null || !cVar.ooU.equals("insert") || cVar.ooX <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.ooX;
        }
        if (!bh.ov(aeVar.field_parentRef)) {
            aj WY = Fd.WY(aeVar.field_parentRef);
            if (WY != null && WY.gc(2097152)) {
                if (i2 > 0) {
                    if ((cVar.ooU.equals("insert") && cVar.ooW > 0) || (cVar.ooU.equals("update") && WY.field_unReadCount + cVar.ooW >= 0)) {
                        x WO = ((h) g.h(h.class)).EY().WO(str);
                        if (WO == null || !WO.AI()) {
                            WY.eO(WY.field_unReadCount + i2);
                        } else {
                            WY.eV(WY.field_unReadMuteCount + i2);
                        }
                    }
                    Fd.a(aeVar, i, i2);
                }
                cf Ex = ((h) g.h(h.class)).aZi().Ex(((h) g.h(h.class)).Fd().Xj(aeVar.field_parentRef));
                if (Ex == null || Ex.field_msgId <= 0) {
                    WY.ciy();
                } else {
                    WY.ac(Ex);
                    WY.setContent(Ex.field_talker + ":" + Ex.field_content);
                    WY.dE(Integer.toString(Ex.getType()));
                    if (Fd.uw() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Ex.dS(aeVar.field_parentRef);
                        Ex.setContent(WY.field_content);
                        Fd.uw().a(Ex, pString, pString2, pInt, true);
                        String aS = Fd.aS(Ex.getType(), Ex.field_content);
                        WY.dF(bh.ou(pString.value).concat(bh.ov(aS) ? "" : " " + bh.ou(aS)));
                        WY.dG(pString2.value);
                        WY.eS(pInt.value);
                    }
                }
                if (Fd.a(WY, aeVar.field_parentRef) > 0) {
                    x.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", new Object[]{aeVar.field_parentRef, Integer.valueOf(WY.field_unReadCount + i2)});
                    Fd.b(3, (m) Fd, aeVar.field_parentRef);
                }
            } else if (WY == null || !"officialaccounts".equals(WY.field_username)) {
                if (WY != null && "appbrandcustomerservicemsg".equals(WY.field_username) && i2 > 0) {
                    if ((cVar.ooU.equals("insert") && cVar.ooW > 0) || (cVar.ooU.equals("update") && WY.field_unReadCount + cVar.ooW >= 0)) {
                        WY.eO(WY.field_unReadCount + i2);
                    }
                    Fd.a(aeVar, i, i2);
                    Fd.a(WY, aeVar.field_parentRef);
                }
            } else if (i2 > 0 && ((cVar.ooU.equals("insert") && cVar.ooW > 0) || (cVar.ooU.equals("update") && WY.field_unReadCount + cVar.ooW >= 0))) {
                WY.eO(WY.field_unReadCount + i2);
                Fd.a(WY, aeVar.field_parentRef);
            }
        }
        a(str, aeVar, i2, i, cVar);
    }

    private void a(String str, ae aeVar, int i, int i2, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (aeVar != null && cVar != null && cVar.kGB != -1 && aeVar.gc(8388608)) {
            cf ak = ((o) g.h(o.class)).Fb().ak(str, cVar.kGB);
            com.tencent.mm.ag.a.a aS = y.Mi().aS(cVar.kGB);
            c ag = y.Mh().ag(cVar.kGB);
            if (ag.field_bizChatServId == null) {
                x.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
            } else if (ak == null || ak.field_msgId == 0) {
                x.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + str);
                aS.field_status = 0;
                aS.field_isSend = 0;
                aS.field_content = "";
                aS.field_msgType = "0";
                aS.field_unReadCount = 0;
                aS.field_digest = "";
                aS.field_digestUser = "";
                y.Mi();
                com.tencent.mm.ag.a.b.a(aS, i2, i);
                y.Mi().b(aS);
            } else {
                com.tencent.mm.ag.a.a aVar;
                long j;
                Object obj;
                int i3;
                String cb;
                Iterator it;
                Object obj2;
                au auVar;
                boolean Mt = ag.Mt();
                aS.field_brandUserName = str;
                if (ak.cjd()) {
                    aS.field_content = ak.cjE();
                } else {
                    aS.field_content = ak.field_content;
                }
                PString pString = new PString();
                this.xmw.uw().a(ak, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                j ca = y.Mj().ca(ak.field_bizChatUserId);
                if (!Mt) {
                    aS.field_digest = str2;
                    str2 = null;
                } else if (ak.field_isSend == 1 && ca != null) {
                    aS.field_digest = ac.getContext().getString(b.dFB) + ":" + str2;
                    ca.field_userName = ac.getContext().getString(b.dFB);
                    str2 = null;
                } else if (ca == null || bh.ov(ca.field_userName)) {
                    aS.field_digest = str2;
                    str2 = null;
                } else {
                    aS.field_digest = ca.field_userName + ":" + str2;
                    str2 = ca.field_userName;
                }
                String aS2 = this.xmw.aS(ak.getType(), ak.field_content);
                aS.field_digest = bh.ou(aS.field_digest).concat(bh.ov(aS2) ? "" : " " + bh.ou(aS2));
                aS.field_digestUser = "";
                aS.field_chatType = ag.field_chatType;
                aS.field_lastMsgID = ak.field_msgId;
                if (ak.cji()) {
                    aVar = aS;
                } else if (ak.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = aS;
                    aVar.field_lastMsgTime = j;
                    aS.field_status = ak.field_status;
                    aS.field_isSend = ak.field_isSend;
                    aS.field_msgType = Integer.toString(ak.getType());
                    aS.field_flag = com.tencent.mm.ag.a.b.a(aS, 1, ak.field_createTime);
                    obj = null;
                    if ((cVar.ooU.equals("insert") && cVar.ooW > 0) || (cVar.ooU.equals("update") && aS.field_unReadCount + cVar.ooW >= 0)) {
                        aS.field_unReadCount += cVar.ooW;
                        aS.field_newUnReadCount += cVar.ooW;
                        if (cVar.ooW > 0 && ag.ho(1)) {
                            i3 = aeVar.field_unReadCount - cVar.ooW;
                            if (i3 > 0) {
                                aeVar.eO(0);
                            } else {
                                aeVar.eO(i3);
                            }
                            aeVar.eV(aeVar.field_unReadMuteCount + cVar.ooW);
                            obj = 1;
                        }
                    }
                    if (cVar.ooU.equals("insert") && cVar.ooV.size() > 0 && ag.Mt()) {
                        cb = y.Mj().cb(ak.field_talker);
                        it = cVar.ooV.iterator();
                        obj2 = obj;
                        while (it.hasNext()) {
                            auVar = (au) it.next();
                            if (cb == null && auVar.field_isSend != 1 && auVar.cjg() && auVar.Xq(cb)) {
                                aS.field_atCount++;
                                aeVar.eU(aeVar.field_atCount + 1);
                                obj = 1;
                            } else {
                                obj = obj2;
                            }
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    y.Mi();
                    com.tencent.mm.ag.a.b.a(aS, i2, i);
                    if (bh.ov(str2)) {
                        str2 = ag.gu(ak.field_bizChatUserId);
                    }
                    x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[]{str, ag.field_bizChatServId, ak.field_bizChatUserId, str2});
                    y.Mi().b(aS);
                    if (obj != null) {
                        this.xmw.a(aeVar, str);
                    }
                } else {
                    aVar = aS;
                }
                j = ak.field_createTime;
                aVar.field_lastMsgTime = j;
                aS.field_status = ak.field_status;
                aS.field_isSend = ak.field_isSend;
                aS.field_msgType = Integer.toString(ak.getType());
                aS.field_flag = com.tencent.mm.ag.a.b.a(aS, 1, ak.field_createTime);
                obj = null;
                aS.field_unReadCount += cVar.ooW;
                aS.field_newUnReadCount += cVar.ooW;
                i3 = aeVar.field_unReadCount - cVar.ooW;
                if (i3 > 0) {
                    aeVar.eO(i3);
                } else {
                    aeVar.eO(0);
                }
                aeVar.eV(aeVar.field_unReadMuteCount + cVar.ooW);
                obj = 1;
                cb = y.Mj().cb(ak.field_talker);
                it = cVar.ooV.iterator();
                obj2 = obj;
                while (it.hasNext()) {
                    auVar = (au) it.next();
                    if (cb == null) {
                    }
                    obj = obj2;
                    obj2 = obj;
                }
                obj = obj2;
                y.Mi();
                com.tencent.mm.ag.a.b.a(aS, i2, i);
                if (bh.ov(str2)) {
                    str2 = ag.gu(ak.field_bizChatUserId);
                }
                x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", new Object[]{str, ag.field_bizChatServId, ak.field_bizChatUserId, str2});
                y.Mi().b(aS);
                if (obj != null) {
                    this.xmw.a(aeVar, str);
                }
            }
        }
    }

    public final void Wt(String str) {
        if (str != null && s.gF(str) && f.jX(str)) {
            aj WY = this.xmw.WY(str);
            if (WY != null) {
                cf Ex = ((h) g.h(h.class)).aZi().Ex(((h) g.h(h.class)).Fd().Xj(str));
                if (Ex != null && Ex.field_msgId > 0) {
                    WY.ac(Ex);
                    WY.setContent(Ex.field_talker + ":" + Ex.field_content);
                    WY.dE(Integer.toString(Ex.getType()));
                    as.b uw = this.xmw.uw();
                    if (uw != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Ex.dS(str);
                        Ex.setContent(WY.field_content);
                        uw.a(Ex, pString, pString2, pInt, true);
                        WY.dF(pString.value);
                        WY.dG(pString2.value);
                        WY.eS(pInt.value);
                    } else {
                        WY.ciy();
                    }
                    this.xmw.a(WY, WY.field_username);
                }
            }
        }
    }
}
