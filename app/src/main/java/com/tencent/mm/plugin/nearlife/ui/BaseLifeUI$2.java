package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BaseLifeUI$2 implements OnClickListener {
    final /* synthetic */ BaseLifeUI oQu;

    BaseLifeUI$2(BaseLifeUI baseLifeUI) {
        this.oQu = baseLifeUI;
    }

    public final void onClick(View view) {
        if (this.oQu.oQf == null) {
            x.e("MicroMsg.BaseLifeUI", "Location is null");
            return;
        }
        g.pQN.h(11138, new Object[]{"1", Integer.valueOf(BaseLifeUI.b(this.oQu).getCount() + 1), this.oQu.iRN});
        Intent intent = new Intent();
        intent.setClass(this.oQu, NearLifeCreatePoiUI.class);
        intent.putExtra("get_lat", this.oQu.oQf.vQu);
        intent.putExtra("get_lng", this.oQu.oQf.vQt);
        intent.putExtra("get_preci", this.oQu.oQf.wcr);
        intent.putExtra("get_poi_name", BaseLifeUI.b(this.oQu).bfd());
        intent.putExtra("get_cur_lat", this.oQu.oQg);
        intent.putExtra("get_cur_lng", this.oQu.oQh);
        intent.putExtra("get_accuracy", this.oQu.oQj);
        intent.putExtra("get_loctype", this.oQu.oQi);
        intent.putExtra("search_id", this.oQu.iRN);
        intent.putExtra("get_is_mars", this.oQu.hxP);
        this.oQu.startActivityForResult(intent, 1);
    }
}
