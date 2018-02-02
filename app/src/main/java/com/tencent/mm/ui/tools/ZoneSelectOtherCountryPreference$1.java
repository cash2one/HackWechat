package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class ZoneSelectOtherCountryPreference$1 implements OnClickListener {
    final /* synthetic */ ZoneSelectOtherCountryPreference znH;

    ZoneSelectOtherCountryPreference$1(ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference) {
        this.znH = zoneSelectOtherCountryPreference;
    }

    public final void onClick(View view) {
        if (ZoneSelectOtherCountryPreference.a(this.znH) != null) {
            ZoneSelectOtherCountryPreference.a(this.znH).onClick();
        }
    }
}
