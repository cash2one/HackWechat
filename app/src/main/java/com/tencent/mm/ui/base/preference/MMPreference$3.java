package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MMPreference$3 implements OnItemLongClickListener {
    final /* synthetic */ MMPreference yjh;

    MMPreference$3(MMPreference mMPreference) {
        this.yjh = mMPreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < MMPreference.e(this.yjh).getHeaderViewsCount()) {
            return false;
        }
        int headerViewsCount = i - MMPreference.e(this.yjh).getHeaderViewsCount();
        if (headerViewsCount >= MMPreference.d(this.yjh).getCount()) {
            x.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.d(this.yjh).getCount()));
            return false;
        }
        MMPreference.d(this.yjh).getItem(headerViewsCount);
        MMPreference.d(this.yjh);
        MMPreference.e(this.yjh);
        return MMPreference.cqp();
    }
}
