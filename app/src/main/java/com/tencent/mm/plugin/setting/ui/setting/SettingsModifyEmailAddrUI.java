package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SettingsModifyEmailAddrUI extends MMActivity implements e, b {
    private ProgressDialog iln;
    private EditText qjN;
    private String qjO;
    private String qjP;
    private TextView qjQ;
    private TextView qjR;
    private String qjS = null;
    private String qjT = null;
    private boolean qjU;
    private boolean qjV;
    private boolean qjW;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(138, this);
        ar.CG().a(i.CTRL_BYTE, this);
        ar.CG().a(256, this);
        ar.CG().a(108, this);
        ar.CG().a(255, this);
        ar.Hg();
        c.CU().a(this);
    }

    protected final int getLayoutId() {
        return R.i.dsd;
    }

    public void onDestroy() {
        ar.CG().b(138, this);
        ar.CG().b(i.CTRL_BYTE, this);
        ar.CG().b(256, this);
        ar.CG().b(108, this);
        ar.CG().b(255, this);
        ar.Hg();
        c.CU().b(this);
        super.onDestroy();
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(t.aV(obj)), mVar});
        ar.Hg();
        if (mVar != c.CU() || r0 <= 0) {
            x.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(r0), mVar});
            return;
        }
        boolean z;
        ar.Hg();
        Integer num = (Integer) c.CU().get(7, null);
        ar.Hg();
        this.qjO = (String) c.CU().get(5, null);
        if (num == null || (num.intValue() & 2) == 0) {
            z = false;
        } else {
            z = true;
        }
        this.qjU = z;
        this.qjW = this.qjU;
        if (this.qjV) {
            bqJ();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dsd);
        this.qjN = (EditText) findViewById(R.h.cMv);
        this.qjQ = (TextView) findViewById(R.h.cTD);
        this.qjR = (TextView) findViewById(R.h.cxa);
        ar.Hg();
        this.qjO = (String) c.CU().get(5, null);
        this.qjN.setText(this.qjO);
        ar.Hg();
        Integer num = (Integer) c.CU().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qjU = z;
        setBackBtn(new 1(this));
        this.qjV = true;
        bqJ();
    }

    private void bqJ() {
        if (this.qjU) {
            this.qjQ.setVisibility(0);
            this.qjQ.setText(getString(R.l.eNF));
            this.qjR.setText(getString(R.l.eLP));
            this.qjR.setTextColor(getResources().getColor(R.e.brd));
            this.qjN.setEnabled(false);
            this.qjN.setFilters(new InputFilter[]{new 12(this)});
            this.qjQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                {
                    this.qjX = r1;
                }

                public final void onClick(View view) {
                    ar.CG().a(new h(h.hMJ), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.qjX;
                    Context context = this.qjX;
                    this.qjX.getString(R.l.dGO);
                    settingsModifyEmailAddrUI.iln = com.tencent.mm.ui.base.h.a(context, this.qjX.getString(R.l.eNK), true, new 1(this));
                    this.qjX.aWs();
                }
            });
            df(this.qjN);
        } else if (bh.ov(this.qjO)) {
            bqK();
        } else {
            this.qjQ.setVisibility(0);
            this.qjQ.setText(getString(R.l.eKl));
            this.qjR.setText(getString(R.l.eKk));
            this.qjR.setTextColor(getResources().getColor(R.e.btB));
            this.qjN.setEnabled(false);
            this.qjN.setFilters(new InputFilter[]{new 23(this)});
            this.qjQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                {
                    this.qjX = r1;
                }

                public final void onClick(View view) {
                    ar.Hg();
                    final k afVar = new af((String) c.CU().get(2, null));
                    ar.CG().a(afVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.qjX;
                    Context context = this.qjX.mController.xIM;
                    this.qjX.getString(R.l.dGO);
                    settingsModifyEmailAddrUI.iln = com.tencent.mm.ui.base.h.a(context, this.qjX.getString(R.l.eLg), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass24 qka;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ar.CG().c(afVar);
                        }
                    });
                    this.qjX.aWs();
                }
            });
            addTextOptionMenu(0, getString(R.l.dEF), new OnMenuItemClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                {
                    this.qjX = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.qjX.bqK();
                    return true;
                }
            });
            df(this.qjN);
        }
    }

    private void bqK() {
        this.qjQ.setVisibility(8);
        this.qjQ.setText(getString(R.l.eNF));
        this.qjR.setText(getString(R.l.eLP));
        this.qjR.setTextColor(getResources().getColor(R.e.brd));
        this.qjN.setEnabled(true);
        this.qjN.setFilters(new InputFilter[]{new 26(this)});
        addTextOptionMenu(0, getString(R.l.dGx), new 27(this));
    }

    private void goBack() {
        aWs();
        finish();
        if (this.qjW) {
            setResult(-1);
        } else {
            setResult(0);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (!a.ift.a(this.mController.xIM, i, i2, str)) {
            if (kVar.getType() == i.CTRL_BYTE) {
                if (i == 0 && i2 == 0) {
                    this.qjT = ((h) kVar).RD().vWy;
                    this.qjS = ((h) kVar).RC();
                    if (bh.ov(this.qjT)) {
                        ar.CG().a(new com.tencent.mm.modelsimple.x(2), 0);
                        return;
                    }
                    ar.CG().a(new com.tencent.mm.ab.a(com.tencent.mm.ab.a.hjw, this.qjN.getText().toString().trim()), 0);
                    return;
                }
                if (this.iln != null) {
                    this.iln.dismiss();
                    this.iln = null;
                }
                if (i2 == -3) {
                    x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 28(this), new 2(this));
                } else if (i2 == -82) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKA, R.l.dGO, new 3(this));
                } else if (i2 == -83) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKx, R.l.dGO, new 4(this));
                } else if (i2 == -84) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKy, R.l.dGO, new 5(this));
                } else if (i2 == -85) {
                    com.tencent.mm.ui.base.h.a((Context) this, R.l.eKt, R.l.dGO, new 6(this));
                }
            } else if (kVar.getType() == 256) {
                a.ift.um();
                if (((com.tencent.mm.ab.a) kVar).IS() == com.tencent.mm.ab.a.hjv) {
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.h.a(this.mController.xIM, R.l.eLf, R.l.dGO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                            {
                                this.qjX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    if (this.iln != null) {
                        this.iln.dismiss();
                        this.iln = null;
                    }
                    if (i2 == -82) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKA, R.l.dGO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                            {
                                this.qjX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -83) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKx, R.l.dGO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                            {
                                this.qjX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -84) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKy, R.l.dGO, new 10(this));
                    } else if (i2 == -85) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKt, R.l.dGO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                            {
                                this.qjX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i2 == -86) {
                        com.tencent.mm.ui.base.h.a((Context) this, R.l.eKB, R.l.dGO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                            {
                                this.qjX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eLe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGO), new 14(this));
                    }
                } else if (((com.tencent.mm.ab.a) kVar).IS() == com.tencent.mm.ab.a.hjw) {
                    if (this.iln != null) {
                        this.iln.dismiss();
                        this.iln = null;
                    }
                    if (i == 0 && i2 == 0) {
                        ar.Hg();
                        Integer valueOf = Integer.valueOf(((Integer) c.CU().get(7, null)).intValue() | 2);
                        ar.Hg();
                        c.CU().set(7, valueOf);
                        if (bh.ov(this.qjT)) {
                            com.tencent.mm.ui.base.h.a(this.mController.xIM, R.l.eKu, R.l.dGO, new 16(this));
                        } else {
                            com.tencent.mm.ui.base.h.a(this.mController.xIM, this.qjT, "", getString(R.l.dBP), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ SettingsModifyEmailAddrUI qjX;

                                {
                                    this.qjX = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                }
            } else if (kVar.getType() == 138) {
            } else {
                if (kVar.getType() == 108) {
                    if (this.iln != null) {
                        this.iln.dismiss();
                        this.iln = null;
                    }
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.h.a(this.mController.xIM, R.l.eLf, R.l.dGO, new 17(this));
                        return;
                    }
                    com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eLe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGO), new 18(this));
                } else if (kVar.getType() != 255) {
                } else {
                    if (i2 == 0) {
                        ar.CG().a(new com.tencent.mm.ab.a(com.tencent.mm.ab.a.hjw, this.qjN.getText().toString().trim()), 0);
                        return;
                    }
                    if (this.iln != null) {
                        this.iln.dismiss();
                        this.iln = null;
                    }
                    com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.eNI), null, getString(R.l.eNJ), getString(R.l.eNH), true, new 19(this), new 20(this));
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.qjO + " newEmail: " + this.qjP);
                    ar.CG().a(new h(h.hMJ), 0);
                    getString(R.l.dGO);
                    this.iln = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eLF), true, new 21(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
