package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.e.c;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.q;

final class e$d implements c {
    e$d() {
    }

    public final boolean a(String str, Context context, u uVar, String str2) {
        if (bh.ov(str)) {
            x.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
            return false;
        } else if (str.startsWith("weixin://wesport/recommend") && uVar != null) {
            r0 = new Intent(context, SelectConversationUI.class);
            r0.putExtra("Select_Talker_Name", str2);
            r0.putExtra("Select_block_List", str2);
            r0.putExtra("Select_Conv_Type", 3);
            r0.putExtra("Select_Send_Card", true);
            uVar.startActivityForResult(r0, 224);
            return true;
        } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
            String FS = q.FS();
            if (bh.ov(FS)) {
                x.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                return false;
            }
            r0 = new Intent();
            r0.putExtra("username", FS);
            d.b(context, "exdevice", ".ui.ExdeviceProfileUI", r0);
            x.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
            return true;
        } else if (!str.startsWith("weixin://openNativeUrl/rankSetting")) {
            return false;
        } else {
            d.y(context, "exdevice", ".ui.ExdeviceSettingUI");
            return true;
        }
    }
}
