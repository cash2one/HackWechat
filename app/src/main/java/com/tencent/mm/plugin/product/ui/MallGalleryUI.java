package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager pfp;
    private g pfq;
    private List<String> pfr;
    private int pfs = 0;
    private boolean pft;

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        mallGalleryUI.pft = !mallGalleryUI.pft;
        if (mallGalleryUI.pft) {
            mallGalleryUI.mController.showTitleView();
        } else {
            mallGalleryUI.mController.hideTitleView();
        }
    }

    protected final int getLayoutId() {
        return g.uDw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pfr = getIntent().getStringArrayListExtra("keys_img_urls");
        this.mController.hideTitleView();
        this.pft = false;
        initView();
    }

    protected void onResume() {
        super.onResume();
        this.pfq.ax(this.pfr);
        this.pfq.notifyDataSetChanged();
        if (this.pfr != null) {
            this.pfr.size();
        }
    }

    protected final void initView() {
        this.pfp = (ViewPager) findViewById(a$f.upT);
        this.pfp.zo = new 1(this);
        this.pfq = new g(this);
        this.pfq.pfP = new 2(this);
        this.pfp.a(this.pfq);
        setBackBtn(new 3(this));
        addIconOptionMenu(0, e.bDI, new 4(this));
    }

    final String bjj() {
        String str;
        if (this.pfr == null || this.pfr.size() < this.pfs + 1) {
            x.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.pfr.get(this.pfs);
        }
        if (!bh.ov(str)) {
            return c.Hu(str);
        }
        x.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
        return null;
    }
}
