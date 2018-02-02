package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.x;

class CardShopUI$1 implements OnItemClickListener {
    final /* synthetic */ CardShopUI kVo;
    final /* synthetic */ Intent val$intent;

    CardShopUI$1(CardShopUI cardShopUI, Intent intent) {
        this.kVo = cardShopUI;
        this.val$intent = intent;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
            return;
        }
        if (i > 0) {
            i--;
        }
        kj kjVar = (kj) CardShopUI.a(this.kVo).get(i);
        if (!TextUtils.isEmpty(kjVar.vRx) && !TextUtils.isEmpty(kjVar.vRy)) {
            b.d(CardShopUI.b(this.kVo), kjVar.vRx, kjVar.vRy, 1052, this.val$intent.getIntExtra("key_from_appbrand_type", 0));
        } else if (!TextUtils.isEmpty(kjVar.kLB)) {
            b.a(this.kVo, kjVar.kLB, 1);
            g.pQN.h(11941, new Object[]{Integer.valueOf(4), CardShopUI.c(this.kVo).atF(), CardShopUI.c(this.kVo).atG(), "", kjVar.name});
        }
    }
}
