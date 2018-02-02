package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.List;

public class EnterpriseBizContactListUI extends MMActivity {
    private long gzo;
    private long hQr = 0;
    public String kGd;
    private m kGe;
    private EnterpriseBizContactListView kGf;
    private af kGg;
    private boolean kGh = false;

    protected final int getLayoutId() {
        return R.i.dgp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kGd = getIntent().getStringExtra("enterprise_biz_name");
        this.gzo = System.currentTimeMillis() / 1000;
        if (this.kGg == null) {
            this.kGg = new af(this) {
                final /* synthetic */ EnterpriseBizContactListUI kGi;

                {
                    this.kGi = r1;
                }

                public final void handleMessage(Message message) {
                    if (message != null && message.what == 1 && this.kGi != null && !this.kGi.isFinishing()) {
                        y.Mp().jw(this.kGi.kGd);
                        y.Mf();
                        List jN = e.jN(this.kGi.kGd);
                        for (int i = 0; i < jN.size(); i++) {
                            String str = (String) jN.get(i);
                            if (s.gE(str) && (f.jY(str) || f.eE(str))) {
                                y.Mp().jw(str);
                            }
                        }
                    }
                }
            };
        } else {
            this.kGg.removeMessages(1);
        }
        this.kGg.sendEmptyMessageDelayed(1, 500);
    }

    protected void onResume() {
        super.onResume();
        if (s.gE(this.kGd)) {
            initView();
            if (!this.kGh) {
                int intExtra = getIntent().getIntExtra("enterprise_from_scene", 5);
                int i = -1;
                if (this.kGf != null) {
                    i = this.kGf.kGm;
                }
                b jx = y.Mm().jx(this.kGd);
                int i2 = jx != null ? jx.field_qyUin : 0;
                long j = jx != null ? jx.field_wwCorpId : 0;
                long j2 = jx != null ? jx.field_wwUserVid : 0;
                g.pQN.h(12892, this.kGd, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.kGd, Integer.valueOf(intExtra), Integer.valueOf(i), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
                this.kGh = true;
                return;
            }
            return;
        }
        x.e("MicroMsg.BrandService.EnterpriseBizContactListUI", "%s !isContact", this.kGd);
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.kGf != null) {
            EnterpriseBizContactListView.release();
        }
        if (this.gzo > 0 && this.hQr > 0) {
            long j = this.hQr - this.gzo;
            b jx = y.Mm().jx(this.kGd);
            int i = jx != null ? jx.field_qyUin : 0;
            int i2 = jx != null ? jx.field_userUin : 0;
            g.pQN.h(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
            x.d("MicroMsg.BrandService.EnterpriseBizContactListUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(2), Long.valueOf(j));
        }
        super.onDestroy();
    }

    public void finish() {
        this.hQr = System.currentTimeMillis() / 1000;
        super.finish();
    }

    protected final void initView() {
        ar.Hg();
        setMMTitle(c.EY().WO(this.kGd).AP());
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactListUI kGi;

            {
                this.kGi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kGi.aWs();
                this.kGi.finish();
                return true;
            }
        });
        if (!bh.ov(this.kGd)) {
            d jS = f.jS(this.kGd);
            if (jS != null && jS.Le()) {
                addIconOptionMenu(1, R.l.dCm, R.k.duO, new OnMenuItemClickListener(this) {
                    final /* synthetic */ EnterpriseBizContactListUI kGi;

                    {
                        this.kGi = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.kGi.kGe != null) {
                            this.kGi.kGe.dismiss();
                            this.kGi.kGe = null;
                        }
                        this.kGi.kGe = new m(this.kGi.mController.xIM);
                        this.kGi.kGe.rKC = new 1(this);
                        this.kGi.kGe.rKD = new 2(this);
                        this.kGi.kGe.dM();
                        return false;
                    }
                });
            }
        }
        this.kGf = (EnterpriseBizContactListView) findViewById(R.h.ceD);
        this.kGf.kGd = this.kGd;
        this.kGf.kGk = false;
        this.kGf.refresh();
        this.kGf.asv();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.f.aZh().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra3, stringExtra2);
                    a.h(this, this.mController.xIM.getString(R.l.eic));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
