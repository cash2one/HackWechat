package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class AppBrandProfileUI$a extends t implements OnClickListener {
    WxaBindBizInfoView jLE;
    final /* synthetic */ AppBrandProfileUI jLy;
    String mAppId;

    static /* synthetic */ void a(AppBrandProfileUI$a appBrandProfileUI$a, List list) {
        WxaBindBizInfoView wxaBindBizInfoView = appBrandProfileUI$a.jLE;
        wxaBindBizInfoView.jVn.clear();
        if (!(list == null || list.isEmpty())) {
            wxaBindBizInfoView.jVn.addAll(list);
        }
        wxaBindBizInfoView.dn(true);
    }

    AppBrandProfileUI$a(AppBrandProfileUI appBrandProfileUI, View view) {
        this.jLy = appBrandProfileUI;
        super(view);
        this.jLE = (WxaBindBizInfoView) view.findViewById(g.iwg);
        view.setOnClickListener(this);
    }

    public final void onClick(View view) {
        Collection collection = this.jLE.jVn;
        if (collection == null || collection.isEmpty()) {
            x.i("MicroMsg.AppBrandProfileUI", "deal onBindBizInfo click failed, bindBizInfoList is null or nil.");
        } else if (collection.size() == 1) {
            d.b(this.VU.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", ((WxaEntryInfo) collection.get(0)).username).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
            AppBrandProfileUI.a(this.jLy, 3, 1);
        } else {
            Intent intent = new Intent(this.jLy.mController.xIM, WxaBindBizInfoUI.class);
            intent.putExtra("app_id", this.mAppId);
            intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(collection));
            this.jLy.mController.xIM.startActivity(intent);
        }
    }
}
