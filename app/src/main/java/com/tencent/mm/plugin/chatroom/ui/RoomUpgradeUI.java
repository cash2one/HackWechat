package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.d.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class RoomUpgradeUI extends MMActivity implements e {
    private String chatroomName;
    private ProgressDialog iln = null;
    private q kZS;
    private int kZp;
    private int kZq;
    private View lcj;
    private ImageView lck;
    private TextView lcl;
    private TextView lcm;
    private TextView lcn;
    private TextView lcr;
    private View lcs;
    private TextView lct;
    private h lcu;
    private String lcv;
    private boolean lcw;
    private boolean lcx;
    private int status;

    static /* synthetic */ void a(RoomUpgradeUI roomUpgradeUI, boolean z) {
        Intent intent = new Intent(roomUpgradeUI, RoomAnnouncementUI.class);
        intent.putExtra("need_bind_mobile", z);
        intent.putExtra("RoomInfo_Id", roomUpgradeUI.chatroomName);
        roomUpgradeUI.startActivityForResult(intent, 600);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WT();
        initView();
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                axS();
            }
            if (intent.hasExtra("announce_ok")) {
                axS();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            WT();
            int intExtra = intent.getIntExtra("left_quota", 0);
            axT();
            this.lct.setVisibility(8);
            this.kZq = intExtra;
            if (this.kZq > 0) {
                this.lcn.setText(getString(R.l.eGs, new Object[]{Integer.valueOf(this.kZq)}));
            } else {
                this.lcn.setText(getString(R.l.eGt));
            }
            if (!this.lcx) {
                this.lcr.setVisibility(0);
            }
            this.lcr.setText(R.l.eGp);
        }
    }

    private void axS() {
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
    }

    private void WT() {
        boolean z = true;
        this.chatroomName = getIntent().getStringExtra("room_name");
        x.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[]{this.chatroomName});
        ar.CG().a(519, this);
        ar.Hg();
        this.kZS = c.Fh().hD(this.chatroomName);
        if (this.kZS == null) {
            finish();
            return;
        }
        this.lcw = com.tencent.mm.z.q.FS().equals(this.kZS.field_roomowner);
        if (w.cff()) {
            z = false;
        }
        this.lcx = z;
    }

    protected final void initView() {
        setMMTitle(R.l.eGm);
        setBackBtn(new 1(this));
        this.lcj = findViewById(R.h.cTW);
        this.lcs = findViewById(R.h.cTY);
        this.lck = (ImageView) findViewById(R.h.cTV);
        this.lcl = (TextView) findViewById(R.h.cTX);
        this.lcm = (TextView) findViewById(R.h.cTT);
        this.lcn = (TextView) findViewById(R.h.cTU);
        this.lct = (TextView) findViewById(R.h.cTS);
        this.lct.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeUI lcy;

            {
                this.lcy = r1;
            }

            public final void onClick(View view) {
                switch (this.lcy.status) {
                    case 1:
                        if (this.lcy.lcx) {
                            a.a(this.lcy, this.lcy.chatroomName, true);
                            return;
                        } else {
                            RoomUpgradeUI.a(this.lcy, true);
                            return;
                        }
                    case 2:
                    case 5:
                        if (this.lcy.lcx) {
                            this.lcy.axS();
                            return;
                        } else {
                            RoomUpgradeUI.a(this.lcy, false);
                            return;
                        }
                    default:
                        return;
                }
            }
        });
        this.lcr = (TextView) findViewById(R.h.coI);
        this.lcr.setOnClickListener(new 3(this));
        if (this.lcw) {
            this.iln = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.ctB), true, new 5(this));
            this.lcu = new h(this.chatroomName);
            ar.CG().a(this.lcu, 0);
        } else {
            axT();
            if (!this.lcx) {
                this.lcr.setVisibility(0);
            }
            this.lcr.setText(R.l.eGp);
            this.lct.setVisibility(8);
            this.lcn.setVisibility(8);
        }
        if (this.lcx) {
            this.lcr.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ar.CG().c(this.lcu);
        ar.CG().b(519, this);
        if (this.iln != null) {
            this.iln.dismiss();
        }
        super.onDestroy();
    }

    private void axT() {
        final String str = this.kZS.field_roomowner;
        ar.Hg();
        a WO = c.EY().WO(str);
        if (WO == null || ((int) WO.gJd) > 0) {
            xd(str);
        } else {
            ak.a.hfL.a(str, this.chatroomName, new b.a(this) {
                final /* synthetic */ RoomUpgradeUI lcy;

                public final void v(String str, boolean z) {
                    if (z) {
                        this.lcy.lcj.post(new 1(this));
                    }
                }
            });
        }
        int chU = this.kZS.chU();
        this.lcm.setVisibility(0);
        if (chU <= 40) {
            this.lcm.setText(getString(R.l.eGu, new Object[]{getString(R.l.eGo)}));
            return;
        }
        this.lcm.setText(getString(R.l.eGu, new Object[]{getString(R.l.eGn)}));
    }

    private void xd(String str) {
        String str2;
        CharSequence charSequence = null;
        ar.Hg();
        af WO = c.EY().WO(str);
        if (WO == null || ((int) WO.gJd) <= 0) {
            str2 = null;
        } else {
            str2 = WO.field_conRemark;
        }
        if (!bh.ov(str2)) {
            Object obj = str2;
        } else if (this.kZS != null) {
            charSequence = this.kZS.gu(str);
        }
        if (bh.ov(charSequence) && WO != null && ((int) WO.gJd) > 0) {
            charSequence = WO.AP();
        }
        if (bh.ov(charSequence)) {
            charSequence = str;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lck, str);
        this.lcl.setVisibility(0);
        this.lcl.setText(i.c(this, charSequence, (int) this.lcl.getTextSize()));
    }

    public final int getLayoutId() {
        return R.i.dcS;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                return;
            default:
                x.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eGr), getString(R.l.dGO), false, new 6(this));
        } else if (i == 0 && i2 == 0 && kVar.getType() == 519) {
            h hVar = (h) kVar;
            this.status = hVar.status;
            this.kZp = hVar.kZp;
            this.kZq = hVar.kZq;
            axT();
            this.lcn.setVisibility(0);
            this.lct.setText(getString(R.l.eGl));
            if (this.kZq > 0) {
                this.lcn.setText(getString(R.l.eGs, new Object[]{Integer.valueOf(this.kZq)}));
            } else {
                this.lcn.setText(getString(R.l.eGt));
            }
            if (!this.lcx) {
                this.lcr.setVisibility(0);
            }
            switch (this.status) {
                case 1:
                case 2:
                case 5:
                    this.lct.setVisibility(0);
                    this.lcr.setText(R.l.eGq);
                    return;
                case 3:
                case 4:
                case 6:
                    this.lct.setVisibility(0);
                    this.lct.setEnabled(false);
                    this.lcr.setText(R.l.eGq);
                    return;
                case 7:
                    this.lct.setVisibility(8);
                    this.lcr.setText(R.l.eGp);
                    this.lct.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
