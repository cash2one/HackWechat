package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.chatting.e.c;
import com.tencent.mm.ui.u;

final class e$b implements c {
    e$b() {
    }

    public final boolean a(String str, Context context, u uVar, String str2) {
        if (bh.ov(str)) {
            return false;
        }
        if (!str.startsWith("weixin://openNativeUrl/myDeviceList")) {
            return str.startsWith("weixin://openNativeUrl/bindMyDevice") ? false : false;
        } else {
            Intent intent = new Intent();
            intent.putExtra("device_brand_name", str2);
            d.b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
            return true;
        }
    }
}
