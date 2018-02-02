package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class al$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ al jdv;

    al$1(al alVar, j jVar, int i) {
        this.jdv = alVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jdv.hashCode() & 65535)) {
            if (i2 == -1 && intent != null) {
                String az = bh.az(intent.getStringExtra("nationalCode"), "");
                String az2 = bh.az(intent.getStringExtra("userName"), "");
                String az3 = bh.az(intent.getStringExtra("telNumber"), "");
                String az4 = bh.az(intent.getStringExtra("addressPostalCode"), "");
                String az5 = bh.az(intent.getStringExtra("proviceFirstStageName"), "");
                String az6 = bh.az(intent.getStringExtra("addressCitySecondStageName"), "");
                String az7 = bh.az(intent.getStringExtra("addressCountiesThirdStageName"), "");
                String az8 = bh.az(intent.getStringExtra("addressDetailInfo"), "");
                x.i("MicroMsg.JsApiOpenAddress", "first =  " + az5 + " ; detail =" + az8 + "; second = " + az6 + " ; tel = " + az3 + "; third = " + az7);
                if (!bh.ov(az2)) {
                    Map hashMap = new HashMap();
                    hashMap.put("nationalCode", az);
                    hashMap.put("userName", az2);
                    hashMap.put("telNumber", az3);
                    hashMap.put("addressPostalCode", az4);
                    hashMap.put("proviceFirstStageName", az5);
                    hashMap.put("addressCitySecondStageName", az6);
                    hashMap.put("addressCountiesThirdStageName", az7);
                    hashMap.put("addressDetailInfo", az8);
                    this.iZy.E(this.gOK, this.jdv.e("ok", hashMap));
                    return;
                }
            }
            if (i2 == 0) {
                this.iZy.E(this.gOK, this.jdv.e("cancel", null));
            } else {
                this.iZy.E(this.gOK, this.jdv.e("fail", null));
            }
        }
    }
}
