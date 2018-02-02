package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class BindQQUI extends MMWizardActivity implements e {
    private String qjS = null;
    private String qjT = null;
    r tipDialog;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        ar.CG().a(i.CTRL_BYTE, this);
        ar.CG().a(255, this);
    }

    public void onDestroy() {
        ar.CG().b(i.CTRL_BYTE, this);
        ar.CG().b(255, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbl;
    }

    protected final void initView() {
        ar.Hg();
        long longValue = new o(bh.e((Integer) c.CU().get(9, null))).longValue();
        TextView textView;
        Button button;
        if (longValue == 0) {
            setMMTitle(R.l.dLQ);
            textView = (TextView) findViewById(R.h.cMb);
            textView.setVisibility(8);
            textView.setText(R.l.dLP);
            ((TextView) findViewById(R.h.cMc)).setVisibility(8);
            button = (Button) findViewById(R.h.bNE);
            button.setVisibility(0);
            button.setText(R.l.bNE);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI ymH;

                {
                    this.ymH = r1;
                }

                public final void onClick(View view) {
                    MMWizardActivity.A(this.ymH, new Intent(this.ymH, VerifyQQUI.class));
                }
            });
            removeOptionMenu(1);
        } else {
            setMMTitle(R.l.dLO);
            textView = (TextView) findViewById(R.h.cMb);
            textView.setVisibility(8);
            textView.setText(R.l.dLM);
            textView = (TextView) findViewById(R.h.cMc);
            textView.setVisibility(0);
            textView.setText(getString(R.l.dLN) + longValue);
            button = (Button) findViewById(R.h.bNE);
            button.setVisibility(8);
            button.setText(R.l.eoz);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI ymH;

                {
                    this.ymH = r1;
                }

                public final void onClick(View view) {
                }
            });
            addIconOptionMenu(1, R.g.bDI, new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI ymH;

                {
                    this.ymH = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    l lVar = new l(this.ymH.mController.xIM);
                    lVar.rKC = new 1(this);
                    lVar.rKD = new 2(this);
                    lVar.bBX();
                    return false;
                }
            });
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(R.l.dFu), new 1(this));
        } else {
            setBackBtn(new 4(this));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (kVar.getType() == i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.qjS = ((h) kVar).RC();
                if (this.qjS != null && this.qjS.length() > 0) {
                    ar.Hg();
                    c.CU().set(102407, this.qjS);
                }
                if (bh.ov(this.qjT)) {
                    ar.CG().a(new com.tencent.mm.modelsimple.x(2), 0);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.qjT);
                MMWizardActivity.A(this, intent);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == -3) {
                x.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 8(this), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI ymH;

                    {
                        this.ymH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -81) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKz, R.l.dGO, null);
            } else if (i2 == -82) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKA, R.l.dGO, null);
            } else if (i2 == -83) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKx, R.l.dGO, null);
            } else if (i2 == -84) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKy, R.l.dGO, null);
            } else if (i2 == -85) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKw, R.l.dGO, null);
            } else if (i2 == -86) {
                com.tencent.mm.ui.base.h.a(this, R.l.eKB, R.l.dGO, null);
            }
        } else if (kVar.getType() != 255) {
        } else {
            if (i2 == 0) {
                MMWizardActivity.A(this, new Intent(this, StartUnbindQQ.class));
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 10(this), new 11(this));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    ar.CG().a(new h(h.hMG), 0);
                    getString(R.l.dGO);
                    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.eLF), true, new 3(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
