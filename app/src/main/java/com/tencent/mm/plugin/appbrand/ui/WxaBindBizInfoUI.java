package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class WxaBindBizInfoUI extends DrawStatusBarActivity {
    private ThreeDotsLoadingView jJq;
    private String jNk;
    a jNl;
    private LoadMoreRecyclerView jNm;
    private View jNn;
    private String mAppId;

    private static class b extends t {
        TextView ihS;
        View iiS;
        ImageView jNs;

        public b(View view) {
            super(view);
            this.jNs = (ImageView) view.findViewById(q$g.icon);
            this.ihS = (TextView) view.findViewById(q$g.iwf);
            this.iiS = view.findViewById(q$g.divider);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this), f.itj);
        setMMTitle(j.iBa);
        nR(WebView.NIGHT_MODE_COLOR);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1052684));
        k.a(this);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        this.mAppId = getIntent().getStringExtra("app_id");
        this.jNm = (LoadMoreRecyclerView) findViewById(q$g.ivK);
        this.jNl = new a(getLayoutInflater());
        this.jNm.a(new a(this) {
            final /* synthetic */ WxaBindBizInfoUI jNo;

            {
                this.jNo = r1;
            }

            public final void lB(int i) {
                WxaEntryInfo lC = this.jNo.jNl.lC(i);
                if (lC != null) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", lC.username);
                    intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.jNo, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        });
        this.jNl.ac(parcelableArrayListExtra);
        this.jNm.a(null);
        this.jNm.kge = new 3(this);
        this.jNm.a(this.jNl);
        View inflate = getLayoutInflater().inflate(h.ixM, this.jNm, false);
        this.jJq = (ThreeDotsLoadingView) inflate.findViewById(q$g.ctD);
        this.jJq.cze();
        this.jNm.cg(inflate);
        this.jNn = getLayoutInflater().inflate(h.ixN, this.jNm, false);
        this.jNm.addFooterView(this.jNn);
        this.jNn.setVisibility(8);
        if (this.jNl.getItemCount() > 20) {
            this.jNm.dB(true);
            this.jNl.jNr = false;
        }
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1052684, true);
        this.mController.contentView.setBackgroundColor(-1052684);
    }

    protected final int getLayoutId() {
        return h.ixL;
    }
}
