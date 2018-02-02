package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Intent b(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.AddrUtil", "addressObj == null");
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.imr);
        intent.putExtra("userName", bVar.imp);
        intent.putExtra("telNumber", bVar.imq);
        intent.putExtra("addressPostalCode", bVar.imn);
        intent.putExtra("proviceFirstStageName", bVar.imk);
        intent.putExtra("addressCitySecondStageName", bVar.iml);
        intent.putExtra("addressCountiesThirdStageName", bVar.imm);
        intent.putExtra("addressDetailInfo", bVar.imo);
        return intent;
    }
}
