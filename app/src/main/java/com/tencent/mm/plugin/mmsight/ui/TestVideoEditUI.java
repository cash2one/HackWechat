package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.e;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.a.a;
import com.tencent.mm.api.m.c;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.ui.MMActivity;

public class TestVideoEditUI extends MMActivity implements e {
    private m oDu;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(d.content);
        this.oDu = m.fdD.sU();
        m mVar = this.oDu;
        a aVar = new a();
        aVar.fdF = false;
        aVar.fdH = true;
        aVar.fdI = new Rect(0, 0, 1080, 1080);
        aVar.fdE = c.fdJ;
        mVar.a(aVar.tg());
        View ai = this.oDu.ai(this.mController.xIM);
        ai.a(this);
        frameLayout.addView(ai, new LayoutParams(-1, -1));
        ai.fds = new 1(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.oDu.onDestroy();
    }

    public void onBackPressed() {
        if (!this.oDu.sS()) {
            finish();
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.u.a.e.oFb;
    }

    public final void onFinish() {
        this.oDu.a(new 2(this));
    }

    public final void sW() {
        finish();
    }
}
