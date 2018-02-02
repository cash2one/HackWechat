package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.a;

public final class e {
    public static void l(Intent intent, String str) {
        intent.putExtra("Contact_User", str);
    }

    public static void a(Intent intent, String str) {
        if (intent == null || str == null || str.length() == 0) {
            x.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            return;
        }
        ad lc = af.OI().lc(str);
        if (lc != null) {
            intent.putExtra("Contact_Uin", lc.hwR);
            intent.putExtra("Contact_QQNick", lc.getDisplayName());
        }
        b kR = af.OD().kR(str);
        if (kR != null) {
            intent.putExtra("Contact_Mobile_MD5", kR.Nr());
        }
    }

    public static void a(Context context, a aVar) {
        a(context, aVar, false, false, null);
    }

    public static void a(Context context, a aVar, boolean z, boolean z2, Bundle bundle) {
        if (context != null && aVar != null) {
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
            xVar.setUsername(aVar.rYX);
            xVar.dc(aVar.getDisplayName());
            xVar.dd(aVar.hwU);
            xVar.de(aVar.hwV);
            a(context, xVar, aVar, z, z2, bundle, aVar.pjU);
        }
    }

    public static void a(Context context, com.tencent.mm.storage.x xVar, a aVar) {
        a(context, xVar, aVar, false, false, null, aVar.pjU);
    }

    public static void a(Context context, com.tencent.mm.storage.x xVar, a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        if (xVar != null && aVar != null && xVar.field_username != null && xVar.field_username.length() > 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", xVar.field_username);
            intent.putExtra("Contact_Alias", xVar.vN());
            intent.putExtra("Contact_Nick", xVar.AP());
            intent.putExtra("Contact_QuanPin", xVar.vR());
            intent.putExtra("Contact_PyInitial", xVar.vQ());
            intent.putExtra("Contact_Sex", aVar.fWf);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.signature);
            intent.putExtra("Contact_Uin", aVar.pjS);
            intent.putExtra("Contact_Mobile_MD5", aVar.xzj);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.xzk);
            intent.putExtra("Contact_QQNick", aVar.cjG());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            d.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
