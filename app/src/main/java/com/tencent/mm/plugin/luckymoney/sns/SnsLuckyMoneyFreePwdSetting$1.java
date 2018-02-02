package com.tencent.mm.plugin.luckymoney.sns;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLuckyMoneyFreePwdSetting$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLuckyMoneyFreePwdSetting ofo;

    SnsLuckyMoneyFreePwdSetting$1(SnsLuckyMoneyFreePwdSetting snsLuckyMoneyFreePwdSetting) {
        this.ofo = snsLuckyMoneyFreePwdSetting;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ofo.finish();
        return false;
    }
}
