package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String hog;
    private a kGA;
    private long kGB;
    private OnItemClickListener kGC;
    private ListView kGl;
    private int scene;

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        String str = null;
        b bVar = (b) enterpriseBizContactPlainListUI.kGA.getItem(i);
        if (bVar == null || bVar.userName == null) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            e.a(enterpriseBizContactPlainListUI.mController, null, bVar.userName, enterpriseBizContactPlainListUI.getString(R.l.eEF), r.gt(bVar.userName), null, enterpriseBizContactPlainListUI.getString(R.l.dGA), new 4(enterpriseBizContactPlainListUI, bVar));
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            r0 = new Intent();
            r0.putExtra("Contact_User", bVar.userName);
            a.ifs.d(r0, enterpriseBizContactPlainListUI);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            e.a(enterpriseBizContactPlainListUI.mController, (String) hashMap.get("title"), (String) hashMap.get("img_url"), (String) hashMap.get("desc"), null, false, enterpriseBizContactPlainListUI.getResources().getString(R.l.dGA), new 5(enterpriseBizContactPlainListUI, bVar.userName));
        } else if (enterpriseBizContactPlainListUI.scene == 4) {
            d jS = f.jS(bVar.userName);
            if (jS != null) {
                str = jS.Ll();
            }
            if (!bh.ov(str)) {
                com.tencent.mm.ag.b jx = y.Mm().jx(jS.Lm());
                int i2 = jx != null ? jx.field_qyUin : 0;
                int i3 = jx != null ? jx.field_userUin : 0;
                int jz = y.Mm().jz(jS.field_username);
                g.pQN.h(13419, new Object[]{Integer.valueOf(i2), Integer.valueOf(jz), Integer.valueOf(i3), Integer.valueOf(1)});
                x.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(jz), Integer.valueOf(i3), Integer.valueOf(1)});
                r0 = new Intent();
                r0.putExtra("rawUrl", str);
                r0.putExtra("useJs", true);
                r0.putExtra("srcUsername", bVar.userName);
                r0.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.hog);
                r0.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.kGB);
                com.tencent.mm.bm.d.b(enterpriseBizContactPlainListUI.mController.xIM, "webview", ".ui.tools.WebViewUI", r0, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.hog = getIntent().getStringExtra("enterprise_biz_name");
        this.kGB = getIntent().getLongExtra("biz_chat_chat_id", -1);
        x.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[]{this.hog});
        initView();
        y.Mf().c(this.kGA);
        ar.Hg();
        c.EY().a(this.kGA);
    }

    protected final void initView() {
        this.kGl = (ListView) findViewById(R.h.ceE);
        if (this.kGA == null) {
            this.kGA = new a(this, this);
            this.kGC = new 1(this);
        }
        x.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[]{Integer.valueOf(this.kGA.getCount())});
        ar.Hg();
        af WO = c.EY().WO(this.hog);
        if (this.scene == 2) {
            setMMTitle(R.l.ebP);
        } else if (WO != null) {
            setMMTitle(WO.AP());
        }
        if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type) || this.kGA.getCount() <= 0) {
            this.kGl.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.ceF);
            textView.setText(R.l.ebV);
            textView.setVisibility(0);
        } else {
            this.kGl.setVisibility(0);
            this.kGl.setAdapter(this.kGA);
            this.kGl.setOnItemClickListener(this.kGC);
        }
        setBackBtn(new 2(this));
        3 3 = new 3(this);
    }

    protected void onResume() {
        super.onResume();
        if (!s.gE(this.hog)) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[]{this.hog});
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        y.Mf().j(this.kGA);
        ar.Hg();
        c.EY().b(this.kGA);
        this.kGA.aUn();
        a aVar = this.kGA;
        if (aVar.hvU != null) {
            aVar.hvU.detach();
            aVar.hvU = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dgo;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
    }
}
