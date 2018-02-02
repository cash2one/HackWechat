package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class SettingsTrustFriendUI$10 implements OnClickListener {
    final /* synthetic */ SettingsTrustFriendUI qlt;

    SettingsTrustFriendUI$10(SettingsTrustFriendUI settingsTrustFriendUI) {
        this.qlt = settingsTrustFriendUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
        d.b(this.qlt, "webview", ".ui.tools.WebViewUI", intent);
    }
}
