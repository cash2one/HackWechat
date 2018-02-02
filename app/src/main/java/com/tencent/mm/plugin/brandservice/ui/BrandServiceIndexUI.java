package com.tencent.mm.plugin.brandservice.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.bc.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Map;

public class BrandServiceIndexUI extends MMActivity implements a {
    private int hoL = 251658241;
    private TextView kFV = null;
    private BrandServiceSortView kFW;
    private boolean kFX = false;
    private boolean kFY = false;

    protected final int getLayoutId() {
        return R.i.dbB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hoL = getIntent().getIntExtra("intent_service_type", 251658241);
        this.kFY = s.fa(getIntent().getIntExtra("list_attr", 0), 16384);
        initView();
        y.Mf().c(this);
    }

    protected void onResume() {
        if (this.kFX) {
            this.kFX = false;
            this.kFW.refresh();
        }
        super.onResume();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        enableOptionMenu(1, true);
    }

    protected void onPause() {
        ar.Hg();
        c.CU().set(233474, Long.valueOf(System.currentTimeMillis()));
        ar.Hg();
        c.CU().set(233473, Long.valueOf(System.currentTimeMillis()));
        ar.Hg();
        c.CU().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
    }

    protected void onDestroy() {
        if (ar.Hj()) {
            this.kFW.release();
            y.Mf().j(this);
        }
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.dDe);
        this.kFW = (BrandServiceSortView) findViewById(R.h.cOV);
        this.kFW.K(true);
        this.kFW.kFY = this.kFY;
        this.kFV = (TextView) findViewById(R.h.cCa);
        this.kFV.setOnClickListener(new 1(this));
        this.kFV.setVisibility(8);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kFZ;

            {
                this.kFZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kFZ.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.eRj, R.k.dva, new 3(this));
        addIconOptionMenu(1, R.l.dCk, R.k.duO, new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kFZ;

            {
                this.kFZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (g.zM(0)) {
                    Intent QM = b.QM();
                    QM.putExtra("KRightBtn", true);
                    QM.putExtra("ftsneedkeyboard", true);
                    QM.putExtra("key_load_js_without_delay", true);
                    QM.putExtra("ftsType", 1);
                    QM.putExtra("ftsbizscene", 6);
                    Map b = b.b(6, true, 0);
                    String zH = g.zH(bh.VI((String) b.get("scene")));
                    b.put("sessionId", zH);
                    b.put("subSessionId", zH);
                    QM.putExtra("sessionId", zH);
                    QM.putExtra("rawUrl", b.r(b));
                    d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
                } else {
                    x.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                }
                this.kFZ.enableOptionMenu(1, false);
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.kFY) {
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[]{str});
        this.kFX = true;
    }
}
