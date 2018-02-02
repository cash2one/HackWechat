package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public class ShareToQQUI extends MMActivity implements e {
    private ProgressDialog iln = null;
    private EditText pqM;
    private TextView qgF;
    private int qgG;
    private boolean qgH = false;

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        x.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.qgH) {
            String string = shareToQQUI.mController.xIM.getString(R.l.dGO);
            h.a(shareToQQUI.mController.xIM, shareToQQUI.mController.xIM.getString(R.l.eel), string, new 6(shareToQQUI), null);
        }
    }

    protected final int getLayoutId() {
        return R.i.dfz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(26, this);
        initView();
        if (q.Gt()) {
            c cVar = new c("290293790992170");
            ar.Hg();
            cVar.ZI(bh.ou((String) com.tencent.mm.z.c.CU().get(65830, null)));
            new com.tencent.mm.ui.account.h(cVar, new a(this) {
                final /* synthetic */ ShareToQQUI qgI;

                {
                    this.qgI = r1;
                }

                public final void k(Bundle bundle) {
                    super.k(bundle);
                }

                public final void onError(int i, String str) {
                    super.onError(i, str);
                    if (i == 3) {
                        ShareToQQUI.d(this.qgI);
                    }
                }
            }).cnV();
        }
    }

    public void onDestroy() {
        ar.CG().b(26, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eJX);
        this.pqM = (EditText) findViewById(R.h.content);
        this.qgF = (TextView) findViewById(R.h.cZH);
        this.pqM.addTextChangedListener(new MMEditText.c(this.pqM, this.qgF, 280));
        this.qgG = getIntent().getIntExtra("show_to", 2);
        if (this.qgG == 4) {
            this.pqM.setText(R.l.eJG);
        } else {
            this.pqM.setText(R.l.eJI);
        }
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dGE), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQUI qgI;

            {
                this.qgI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                k adVar;
                this.qgI.qgH = true;
                if (this.qgI.qgG == 2 || this.qgI.qgG == 1) {
                    boolean z;
                    boolean z2;
                    String obj = this.qgI.pqM.getText().toString();
                    if (this.qgI.qgG == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.qgI.qgG == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    adVar = new ad(obj, z, z2);
                } else if (this.qgI.qgG == 4) {
                    ar.Hg();
                    long c = bh.c((Long) com.tencent.mm.z.c.CU().get(65831, null));
                    ar.Hg();
                    String ou = bh.ou((String) com.tencent.mm.z.c.CU().get(65830, null));
                    if (bh.bz(c) > 86400000 && ou.length() > 0) {
                        c cVar = new c("290293790992170");
                        cVar.ZI(ou);
                        new com.tencent.mm.ui.account.h(cVar, new 1(this)).cnV();
                    }
                    adVar = new ad(this.qgI.pqM.getText().toString());
                } else {
                    h.h(this.qgI.mController.xIM, R.l.ePg, R.l.dGO);
                    return true;
                }
                ar.CG().a(adVar, 0);
                ShareToQQUI shareToQQUI = this.qgI;
                Context context = this.qgI.mController.xIM;
                this.qgI.getString(R.l.dGO);
                shareToQQUI.iln = h.a(context, this.qgI.getString(R.l.euA), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 qgJ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().c(adVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.iln != null) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 4 && i2 == -68) {
                if (bh.ov(str)) {
                    str = "error";
                }
                h.a(this, str, getString(R.l.dGO), new 3(this), null);
            } else if (i == 0 && i2 == 0) {
                aWs();
                String string = getString(R.l.ePi);
                AnonymousClass4 anonymousClass4 = new OnDismissListener(this) {
                    final /* synthetic */ ShareToQQUI qgI;

                    {
                        this.qgI = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.qgI.finish();
                    }
                };
                h.bu(this, string);
            } else {
                this.qgH = false;
                if (!com.tencent.mm.plugin.setting.a.ift.a(this.mController.xIM, i, i2, str)) {
                    Toast.makeText(this, getString(R.l.ePh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }
}
