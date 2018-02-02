package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ba;
import java.util.HashMap;
import java.util.HashSet;

public final class z {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> pLG;
    public HashMap<String, String> pLH;

    public z() {
        this.pLG = null;
        this.pLH = new HashMap();
        this.pLG = new HashSet();
        this.lock = new Object();
    }

    public final boolean Iq(String str) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.pLG.contains(str);
        }
        return contains;
    }

    private synchronized boolean Ir(String str) {
        boolean z;
        if (this.pLG.contains(str)) {
            x.i(TAG, "it is a duplicate msg");
            z = false;
        } else {
            z = this.pLG.add(str);
        }
        return z;
    }

    public final boolean dP(String str, String str2) {
        String str3 = (String) this.pLH.get(str);
        if (!bh.ov(str3)) {
            return P(str, str3, str2);
        }
        x.w(TAG, "empty transid: %s", str);
        return false;
    }

    public final boolean P(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            x.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            return false;
        } else if (!Ir(str)) {
            return false;
        } else {
            cf auVar = new au();
            auVar.setContent(str2);
            auVar.eQ(2);
            auVar.dS(str3);
            auVar.aq(ba.hR(str3));
            auVar.eR(1);
            auVar.setType(419430449);
            long Q = ((h) g.h(h.class)).aZi().Q(auVar);
            if (Q < 0) {
                x.e(TAG, com.tencent.mm.compatible.util.g.zh() + "insert msg failed :" + Q);
                this.pLG.remove(str);
                return false;
            }
            boolean b;
            auVar.ao(Q);
            if (auVar.aNc()) {
                b.hPA.a(auVar, com.tencent.mm.y.h.g(auVar));
            } else {
                b.hPA.f(auVar);
            }
            c gVar = new com.tencent.mm.y.g();
            gVar.field_xml = auVar.field_content;
            String VH = bh.VH(str2);
            a aVar = null;
            if (VH != null) {
                aVar = a.I(VH, auVar.field_reserved);
                if (aVar != null) {
                    gVar.field_title = aVar.title;
                    gVar.field_description = aVar.description;
                }
            }
            gVar.field_type = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
            gVar.field_msgId = Q;
            com.tencent.mm.y.g fp = com.tencent.mm.plugin.y.a.bio().fp(Q);
            if (fp == null || fp.field_msgId != Q) {
                b = com.tencent.mm.plugin.y.a.bio().b(gVar);
                if (!b) {
                    x.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:" + Q);
                }
            } else {
                b = com.tencent.mm.plugin.y.a.bio().c(gVar, new String[0]);
            }
            if (aVar != null) {
                com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                cVar.field_locaMsgId = auVar.field_msgId;
                cVar.field_transferId = aVar.hcg;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.b.bnm();
                com.tencent.mm.plugin.remittance.a.b.bno().a(cVar);
            }
            return b;
        }
    }
}
