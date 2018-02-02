package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class LuckyMoneyPrepareUI$28 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$28(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (LuckyMoneyPrepareUI.j(this.ojC) == 1) {
            e.l(this.ojC.mController.xIM, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
        } else {
            e.l(this.ojC.mController.xIM, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
        }
        return true;
    }
}
