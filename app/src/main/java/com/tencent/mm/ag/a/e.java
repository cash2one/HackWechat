package com.tencent.mm.ag.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ag.o;
import com.tencent.mm.ag.y;
import com.tencent.mm.api.a;
import com.tencent.mm.api.g;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static String gjF = null;
    public static final Object hqR = new Object();

    public static boolean km(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            return true;
        }
        return false;
    }

    public static boolean kn(String str) {
        if (str != null) {
            return str.endsWith("@qy_g");
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
        return false;
    }

    public static boolean c(c cVar) {
        if (cVar == null) {
            return false;
        }
        List<String> Ms = cVar.Ms();
        String cb = ((g) com.tencent.mm.kernel.g.h(g.class)).cb(cVar.field_brandUserName);
        if (cb == null) {
            x.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            return false;
        }
        for (String equals : Ms) {
            if (cb.equals(equals)) {
                return true;
            }
        }
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[]{cb});
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[]{Arrays.toString(Ms.toArray())});
        return false;
    }

    public static int aY(long j) {
        List aZ = aZ(j);
        if (aZ != null) {
            return aZ.size();
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        return 0;
    }

    public static List<String> aZ(long j) {
        return y.Mh().ag(j).Ms();
    }

    public static String ko(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            return null;
        }
        j ca = y.Mj().ca(str);
        if (ca != null) {
            return ca.field_userName;
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String kp(String str) {
        j ca = y.Mj().ca(str);
        if (ca != null) {
            return ca.field_headImageUrl;
        }
        return null;
    }

    public static c a(c cVar, long j) {
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        x.w(str, str2, objArr);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.field_bizChatLocalId = j;
        y.Mh().b(cVar2);
        return y.Mh().ag(j);
    }

    public static j a(j jVar, String str) {
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        x.w(str2, str3, objArr);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.field_userId = str;
        y.Mj().b(jVar2);
        jVar = y.Mj().ca(str);
        if (jVar != null) {
            return jVar;
        }
        x.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
        return jVar2;
    }

    public static j kq(String str) {
        j jVar = null;
        if (bh.ov(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
        } else {
            f kv = y.Mk().kv(str);
            if (kv == null) {
                x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
            } else {
                jVar = y.Mj().ca(kv.field_userId);
                if (jVar == null) {
                    x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
            }
        }
        return jVar;
    }

    public static String kr(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[]{Integer.valueOf(indexOf), Integer.valueOf(indexOf2)});
            return null;
        }
        CharSequence substring = str.substring(indexOf, indexOf2);
        return str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
    }

    public static String HD() {
        String str;
        synchronized (hqR) {
            str = gjF;
        }
        return str;
    }

    public static String d(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            return null;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[]{cVar.field_bizChatServId});
            return null;
        }
        j kq = kq(cVar.field_brandUserName);
        if (kq == null || kq.field_userId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[]{cVar.field_bizChatServId});
            return null;
        }
        synchronized (hqR) {
            gjF = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), kq.field_userId});
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[]{gjF});
        return gjF;
    }

    public static void ks(String str) {
        synchronized (hqR) {
            gjF = str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static c e(c cVar) {
        if (cVar.field_bizChatServId == null) {
            return null;
        }
        c kl = y.Mh().kl(cVar.field_bizChatServId);
        if (kl != null) {
            if (cVar.field_chatVersion > kl.field_chatVersion || bh.ov(kl.field_brandUserName)) {
                if (!bh.ov(cVar.field_chatName)) {
                    kl.field_chatName = cVar.field_chatName;
                }
                kl.field_brandUserName = cVar.field_brandUserName;
                kl.field_needToUpdate = true;
                kl.field_chatType = cVar.field_chatType;
                y.Mh().b(kl);
                cVar = kl;
            }
            cVar = kl;
        } else {
            cVar.field_needToUpdate = true;
        }
        if (!cVar.Mu()) {
            return cVar;
        }
        if (cVar.Mt()) {
            y.Ml().ah(cVar.field_bizChatServId, cVar.field_brandUserName);
            return cVar;
        }
        y.Ml().ai(cVar.field_bizChatServId, cVar.field_brandUserName);
        return cVar;
    }

    public static boolean f(c cVar) {
        x.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            return false;
        }
        List<String> Ms = cVar.Ms();
        if (Ms == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : Ms) {
            j ca = y.Mj().ca(str);
            if (ca != null && ca.Mu()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            y.Ml().b(linkedList, cVar.field_brandUserName);
            return true;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        return false;
    }

    public static String ba(long j) {
        return y.Mh().ag(j).field_bizChatServId;
    }

    public static long kt(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            return -1;
        }
        c kl = y.Mh().kl(str);
        if (kl != null) {
            return kl.field_bizChatLocalId;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        return -1;
    }

    public static void A(String str, boolean z) {
        if (bh.ov(str)) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            return;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        com.tencent.mm.kernel.g.Dm().F(new 1(str, z, null));
    }

    public static void l(String str, String str2, String str3) {
        x.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[]{str, str2, str3});
        com.tencent.mm.kernel.g.Dm().F(new 2(str2, str3, str));
    }

    public static String bZ(String str) {
        return a.bZ(str);
    }

    public static String ku(String str) {
        if (bh.ov(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(c.Fj());
        stringBuilder.append(com.tencent.mm.a.g.s(str.getBytes())).append("/");
        stringBuilder.append("user/");
        return stringBuilder.toString();
    }

    public static boolean a(c cVar, String str, String str2, wj wjVar) {
        if (!(str == null || bh.ov(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && bh.ov(str2)) {
                    j jVar;
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j ca = y.Mj().ca(string);
                    if (ca == null) {
                        jVar = new j();
                        z = true;
                    } else {
                        jVar = ca;
                        z = false;
                    }
                    jVar.field_userId = string;
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    if (jVar.field_brandUserName == null || jVar.field_brandUserName.length() == 0) {
                        jVar.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (jVar.field_addMemberUrl == null || jVar.field_addMemberUrl.length() == 0) {
                        jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!y.Mj().b(jVar)) {
                        y.Mj().a(jVar);
                    }
                    if (z) {
                        y.Ml().aj(jVar.field_userId, jVar.field_brandUserName);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = jVar.field_userId;
                    cVar2.field_brandUserName = jVar.field_brandUserName;
                    cVar2.field_chatName = jVar.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = e(cVar2);
                    if (cVar2 == null) {
                        return false;
                    }
                    cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                    cVar.field_chatName = jVar.field_userName;
                    return true;
                }
                LinkedList linkedList = new LinkedList();
                if (!bh.ov(str2)) {
                    hl hlVar = new hl();
                    hlVar.vNr = str2;
                    linkedList.add(hlVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar2 = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar2.field_userId = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                    jVar2.field_userName = jSONObject2.getString("nick_name");
                    jVar2.field_brandUserName = cVar.field_brandUserName;
                    jVar2.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar2.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar2.field_UserVersion = jSONObject2.getInt("ver");
                    jVar2.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!y.Mj().b(jVar2)) {
                        y.Mj().a(jVar2);
                    }
                    hl hlVar2 = new hl();
                    hlVar2.vNr = jVar2.field_userId;
                    linkedList.add(hlVar2);
                }
                wjVar.vNs = linkedList;
                cVar.field_bizChatLocalId = -1;
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        return false;
    }

    public static void g(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            return;
        }
        boolean aV = y.Mi().aV(cVar.field_bizChatLocalId);
        boolean ho = cVar.ho(16);
        x.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[]{Boolean.valueOf(aV), Boolean.valueOf(ho), cVar.field_chatName});
        if (ho && !aV) {
            y.Mi().aW(cVar.field_bizChatLocalId);
        } else if (!ho && aV) {
            y.Mi().aX(cVar.field_bizChatLocalId);
        }
    }

    public static void h(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            return;
        }
        aj WY = ((h) com.tencent.mm.kernel.g.h(h.class)).Fd().WY(cVar.field_brandUserName);
        if (WY == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            return;
        }
        cf Ex = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().Ex(cVar.field_brandUserName);
        cf ak = ((o) com.tencent.mm.kernel.g.h(o.class)).Fb().ak(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (Ex != null && ak != null && Ex.field_msgId == ak.field_msgId) {
            String str = WY.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (substring != null && !substring.equals(cVar.field_chatName)) {
                        WY.dF(cVar.field_chatName + ":" + str);
                        ((h) com.tencent.mm.kernel.g.h(h.class)).Fd().a(WY, WY.field_username);
                    }
                }
            }
        }
    }
}
