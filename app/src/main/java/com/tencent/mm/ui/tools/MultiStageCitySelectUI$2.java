package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference.a;

class MultiStageCitySelectUI$2 implements a {
    final /* synthetic */ MultiStageCitySelectUI zlZ;

    MultiStageCitySelectUI$2(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.zlZ = multiStageCitySelectUI;
    }

    public final void onClick() {
        Intent intent = new Intent(this.zlZ, MultiStageCitySelectUI.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GetAddress", MultiStageCitySelectUI.e(this.zlZ));
        bundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.f(this.zlZ));
        bundle.putBoolean("IsSelectNonChinaCountry", true);
        bundle.putBoolean("IsAutoPosition", false);
        bundle.putBoolean("IsNeedShowSearchBar", true);
        intent.putExtras(bundle);
        this.zlZ.startActivityForResult(intent, 1);
    }
}
