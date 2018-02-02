package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class BizBindWxaInfoUI$2 implements OnItemClickListener {
    final /* synthetic */ BizBindWxaInfoUI phn;

    BizBindWxaInfoUI$2(BizBindWxaInfoUI bizBindWxaInfoUI) {
        this.phn = bizBindWxaInfoUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        WxaAttributes$WxaEntryInfo wxaAttributes$WxaEntryInfo = (WxaAttributes$WxaEntryInfo) adapterView.getAdapter().getItem(i);
        if (wxaAttributes$WxaEntryInfo != null) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.fnp = BizBindWxaInfoUI.a(this.phn);
            ((c) g.h(c.class)).a(this.phn, wxaAttributes$WxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.b(this.phn));
        }
    }
}
