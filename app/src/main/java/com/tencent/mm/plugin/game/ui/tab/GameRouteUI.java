package com.tencent.mm.plugin.game.ui.tab;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.util.List;

@a(19)
public class GameRouteUI extends GameCenterActivity {
    private int ndn;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        initView();
        this.ndn = getIntent().getIntExtra("game_report_from_scene", 0);
        bp aRP = aRP();
        if (aRP == null || bh.cA(aRP.ngS)) {
            as.a(new 1(this));
            return;
        }
        x.i("MicroMsg.GameRouteUI", "use cache data");
        as.a(null);
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        List list = aRP.ngS;
        if (!booleanExtra) {
            z = true;
        }
        e(list, z);
    }

    protected final int getLayoutId() {
        return R.i.dlf;
    }

    protected final void initView() {
        setBackBtn(new 2(this));
        setMMTitle(R.l.enh);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        exit();
        return true;
    }

    protected final boolean aRq() {
        return false;
    }

    public final int aRr() {
        return 0;
    }

    public final int aRs() {
        return 0;
    }

    public final int aRt() {
        return 0;
    }

    private void exit() {
        if (!isFinishing() && !isDestroyed()) {
            finish();
            overridePendingTransition(MMFragmentActivity.a.xKi, MMFragmentActivity.a.xKj);
        }
    }

    private void e(List<aq> list, boolean z) {
        if (!isFinishing() && !isDestroyed()) {
            Parcelable aV = GameTabData.aV(list);
            if (aV == null || bh.cA(aV.aQW())) {
                x.e("MicroMsg.GameRouteUI", "game tab data is null");
                exit();
                return;
            }
            List aQW = aV.aQW();
            int i = 0;
            TabItem tabItem = null;
            while (i < aQW.size()) {
                TabItem tabItem2;
                TabItem tabItem3 = (TabItem) aQW.get(i);
                if (tabItem3 != null) {
                    if (tabItem3.nej) {
                        tabItem2 = tabItem3;
                    } else {
                        tabItem2 = tabItem;
                    }
                    ap.a(this, 18, tabItem3.fFj, tabItem3.ner, null, this.ndn, ap.BY(tabItem3.nbh));
                } else {
                    tabItem2 = tabItem;
                }
                i++;
                tabItem = tabItem2;
            }
            if (tabItem == null) {
                tabItem = (TabItem) aQW.get(0);
            }
            if (tabItem == null) {
                x.e("MicroMsg.GameRouteUI", "game tab entry item is null");
                exit();
                return;
            }
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putParcelable("tab_data", aV);
            getIntent().putExtras(extras);
            GameTabWidget.a(this, tabItem, z, true, true);
        }
    }

    private static bp aRP() {
        byte[] BX = SubCoreGameCenter.aRh().BX("game_index4_tab_nav");
        if (bh.bw(BX)) {
            return null;
        }
        try {
            bp bpVar = new bp();
            try {
                bpVar.aF(BX);
                return bpVar;
            } catch (IOException e) {
                return bpVar;
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
