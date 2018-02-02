package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> lZL = null;
    final e gJT = new 1(this);
    private String lZJ = "";
    private boolean lZK = false;
    private Context mContext = null;

    class a {
        final /* synthetic */ c lZM;
        bem lZN = null;
        bek lZO = null;
        String userName = "";

        public a(c cVar, String str, bem com_tencent_mm_protocal_c_bem, bek com_tencent_mm_protocal_c_bek) {
            this.lZM = cVar;
            this.userName = str;
            this.lZN = com_tencent_mm_protocal_c_bem;
            this.lZO = com_tencent_mm_protocal_c_bek;
        }
    }

    static /* synthetic */ void a(c cVar, bem com_tencent_mm_protocal_c_bem) {
        Intent intent = new Intent();
        intent.putExtra("add_more_friend_search_scene", 3);
        if (com_tencent_mm_protocal_c_bem != null) {
            try {
                intent.putExtra("result", com_tencent_mm_protocal_c_bem.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: IOException: %s", new Object[]{e.toString()});
            }
        }
        x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
        com.tencent.mm.plugin.ext.a.ifs.w(intent, cVar.mContext);
    }

    public c(Context context, String str) {
        this.mContext = context;
        this.lZJ = str;
        this.lZK = true;
    }

    public final int aFI() {
        if (this.mContext == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            return -1;
        } else if (bh.ov(this.lZJ)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            return -1;
        } else {
            String Vk = ao.Vk(this.lZJ);
            if (bh.ov(Vk)) {
                x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                return -1;
            }
            a aVar;
            String str = this.lZJ;
            if (bh.ov(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (lZL == null) {
                    lZL = new HashMap();
                }
                aVar = (a) lZL.get(str);
            }
            if (aVar != null) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                return a(aVar.userName, aVar.lZN, aVar.lZO);
            }
            b hbVar = new hb();
            hbVar.fxj.fxl = Vk;
            com.tencent.mm.sdk.b.a.xef.m(hbVar);
            str = hbVar.fxk.userName;
            if (bh.ov(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                ar.CG().a(106, this.gJT);
                ar.CG().a(new ac(Vk, 3), 0);
                Intent intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.mContext.startActivity(intent);
                return 2;
            }
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", new Object[]{str});
            return a(str, null, null);
        }
    }

    private static void a(String str, a aVar) {
        if (bh.ov(str)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            return;
        }
        if (lZL == null) {
            lZL = new HashMap();
        }
        lZL.put(str, aVar);
    }

    private int a(String str, bem com_tencent_mm_protocal_c_bem, bek com_tencent_mm_protocal_c_bek) {
        if (this.mContext == null) {
            x.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            return -1;
        }
        if (!bh.ov(str)) {
            ar.Hg();
            if (com.tencent.mm.z.c.EY().WK(str)) {
                x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                zy(str);
                return 0;
            }
        }
        if (com_tencent_mm_protocal_c_bem != null) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(com_tencent_mm_protocal_c_bem);
            return 1;
        } else if (com_tencent_mm_protocal_c_bek != null) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(com_tencent_mm_protocal_c_bek);
            return 1;
        } else {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            return -1;
        }
    }

    private void zy(String str) {
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        d.a(this.mContext, ".ui.chatting.ChattingUI", intent);
    }

    private void a(bem com_tencent_mm_protocal_c_bem) {
        if (com_tencent_mm_protocal_c_bem == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            return;
        }
        String a = n.a(com_tencent_mm_protocal_c_bem.vYI);
        if (bh.ov(a)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.lZJ, new a(this, n.a(com_tencent_mm_protocal_c_bem.vYI), com_tencent_mm_protocal_c_bem, null));
        ar.Hg();
        if (com.tencent.mm.z.c.EY().WK(a)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            zy(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_bem, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.ifs.d(intent, this.mContext);
    }

    private void a(bek com_tencent_mm_protocal_c_bek) {
        if (com_tencent_mm_protocal_c_bek == null) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            return;
        }
        String a = n.a(com_tencent_mm_protocal_c_bek.vYI);
        if (bh.ov(a)) {
            x.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.lZJ, new a(this, n.a(com_tencent_mm_protocal_c_bek.vYI), null, com_tencent_mm_protocal_c_bek));
        ar.Hg();
        if (com.tencent.mm.z.c.EY().WK(a)) {
            x.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            zy(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_bek, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.ifs.d(intent, this.mContext);
    }
}
