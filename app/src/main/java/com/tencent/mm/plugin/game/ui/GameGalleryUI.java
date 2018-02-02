package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.w.a.f;

@a(19)
public class GameGalleryUI extends MMActivity implements e {
    private String appId = "";
    private MMDotView kba;
    private ViewPager lDX;
    private int mfA = -1;
    private int nqL = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.lDX = (ViewPager) findViewById(R.h.cmd);
        this.kba = (MMDotView) findViewById(R.h.cmf);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.mfA = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.nqL = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.lDX.a(new a(this, stringArrayExtra));
        this.lDX.zo = this;
        this.lDX.d(intExtra, false);
        MMDotView mMDotView = this.kba;
        mMDotView.xZX = f.bEx;
        mMDotView.xZY = f.gUV;
        this.kba.EH(stringArrayExtra.length);
        this.kba.EI(intExtra);
        if (intExtra == 0) {
            ap.a(this, this.mfA, 1202, 1, 12, this.appId, this.nqL, null);
        }
    }

    protected final int getLayoutId() {
        return R.i.cmd;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        this.kba.EI(i);
        ap.a(this, this.mfA, 1202, i + 1, 12, this.appId, this.nqL, null);
    }

    public final void af(int i) {
    }
}
