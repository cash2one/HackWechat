package com.tencent.mm.plugin.radar.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import b.c.b.e;
import b.c.b.l;
import com.tencent.mm.bm.d;
import com.tencent.mm.storage.x;
import java.util.Arrays;

final class RadarMemberView$g implements OnClickListener {
    final /* synthetic */ RadarMemberView pyq;

    RadarMemberView$g(RadarMemberView radarMemberView) {
        this.pyq = radarMemberView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        String str = "k_username";
        x c = RadarMemberView.c(this.pyq);
        intent.putExtra(str, c != null ? c.getUsername() : null);
        intent.putExtra("showShare", false);
        l lVar = l.AuT;
        str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(38)}, 1));
        e.h(str, "java.lang.String.format(format, *args)");
        intent.putExtra("rawUrl", str);
        d.b(this.pyq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
