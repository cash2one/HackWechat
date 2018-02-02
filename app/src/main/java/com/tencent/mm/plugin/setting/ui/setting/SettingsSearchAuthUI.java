package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.plugin.setting.modelsimple.h;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.brk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@a(3)
public class SettingsSearchAuthUI extends MMActivity implements e {
    private ListView Fv;
    private ProgressDialog nMb;
    private byte[] qga;
    private boolean qjD;
    private com.tencent.mm.ui.fts.widget.a qkK;
    private View qkL;
    private TextView qkM;
    private TextView qkN;
    private List<brj> qkO = new ArrayList();
    private a qkP;

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.qkL.setVisibility(0);
        settingsSearchAuthUI.qkM.setVisibility(0);
        settingsSearchAuthUI.qkN.setVisibility(8);
        settingsSearchAuthUI.Fv.setVisibility(8);
        settingsSearchAuthUI.qkO.clear();
        settingsSearchAuthUI.bqI();
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, String str) {
        k hVar = new h(str);
        g.CG().a(hVar, 0);
        settingsSearchAuthUI.nMb = com.tencent.mm.ui.base.h.a(settingsSearchAuthUI, settingsSearchAuthUI.getString(R.l.dFx), true, new 8(settingsSearchAuthUI, hVar));
    }

    static /* synthetic */ void a(SettingsSearchAuthUI settingsSearchAuthUI, byte[] bArr) {
        final k hVar = new h(bArr);
        g.CG().a(hVar, 0);
        settingsSearchAuthUI.nMb = com.tencent.mm.ui.base.h.a(settingsSearchAuthUI, settingsSearchAuthUI.getString(R.l.dFx), true, new OnCancelListener(settingsSearchAuthUI) {
            final /* synthetic */ SettingsSearchAuthUI qkQ;

            public final void onCancel(DialogInterface dialogInterface) {
                g.CG().c(hVar);
            }
        });
    }

    static /* synthetic */ String bF(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (brk com_tencent_mm_protocal_c_brk : list) {
            stringBuilder.append(com_tencent_mm_protocal_c_brk.qgh);
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    static /* synthetic */ void c(SettingsSearchAuthUI settingsSearchAuthUI) {
        settingsSearchAuthUI.qkL.setVisibility(8);
        settingsSearchAuthUI.qkM.setText("");
        settingsSearchAuthUI.qkO.clear();
        settingsSearchAuthUI.Fv.setVisibility(8);
        settingsSearchAuthUI.bqI();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.qkK = new com.tencent.mm.ui.fts.widget.a(this);
        this.Fv = (ListView) findViewById(R.h.bLv);
        this.qkP = new a(this, (byte) 0);
        this.Fv.setAdapter(this.qkP);
        this.qkL = findViewById(R.h.cJY);
        this.qkM = (TextView) findViewById(R.h.cJo);
        this.qkN = (TextView) findViewById(R.h.cJQ);
        bqI();
        getSupportActionBar().setCustomView(this.qkK);
        this.qkK.zeu = new 1(this);
        this.qkK.zet.zdX = new 2(this);
        this.qkM.setOnClickListener(new 3(this));
        this.Fv.setOnItemClickListener(new 4(this));
        this.Fv.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SettingsSearchAuthUI qkQ;

            {
                this.qkQ = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i + i2 == i3) {
                    x.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
                    if (this.qkQ.qga != null) {
                        SettingsSearchAuthUI.a(this.qkQ, this.qkQ.qga);
                        this.qkQ.qga = null;
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        g.CG().a(1169, this);
        g.CG().a(1127, this);
    }

    protected void onPause() {
        super.onPause();
        g.CG().b(1169, this);
        g.CG().b(1127, this);
    }

    private void bqI() {
        this.mController.removeAllOptionMenu();
        if (!this.qkO.isEmpty()) {
            if (this.qjD) {
                addTextOptionMenu(700, getString(R.l.dFl), new OnMenuItemClickListener(this) {
                    final /* synthetic */ SettingsSearchAuthUI qkQ;

                    {
                        this.qkQ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == 700) {
                            this.qkQ.qjD = false;
                            this.qkQ.qkP.notifyDataSetChanged();
                            this.qkQ.bqI();
                        }
                        return true;
                    }
                });
            } else {
                addTextOptionMenu(700, getString(R.l.dFA), new OnMenuItemClickListener(this) {
                    final /* synthetic */ SettingsSearchAuthUI qkQ;

                    {
                        this.qkQ = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == 700) {
                            this.qkQ.qjD = true;
                            this.qkQ.qkP.notifyDataSetChanged();
                            this.qkQ.bqI();
                        }
                        return true;
                    }
                });
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bql, R.a.bpQ);
    }

    protected final int getLayoutId() {
        return R.i.dsg;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.nMb != null) {
            this.nMb.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.bu(this, str);
        } else if (kVar.getType() == 1169) {
            int i3;
            h hVar = (h) kVar;
            byte[] toByteArray = (hVar.qgd == null || hVar.qgd.wot != 1) ? null : hVar.qgd.wor.toByteArray();
            this.qga = toByteArray;
            if (((h) kVar).qga != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qkO.clear();
            }
            h hVar2 = (h) kVar;
            this.qkO.addAll(hVar2.qgd != null ? hVar2.qgd.wos : Collections.emptyList());
            if (this.qkO.isEmpty()) {
                this.qkL.setVisibility(0);
                this.qkM.setVisibility(8);
                this.qkN.setVisibility(0);
                this.Fv.setVisibility(8);
                this.qkO.clear();
                bqI();
                return;
            }
            this.qkP.qjF = this.qkO;
            this.qkP.notifyDataSetChanged();
            this.qkL.setVisibility(8);
            this.Fv.setVisibility(0);
            bqI();
        } else if (kVar.getType() == 1127) {
            String str2 = ((b) kVar).appId;
            if (!bh.ov(str2)) {
                if (!this.qkO.isEmpty()) {
                    Iterator it = this.qkO.iterator();
                    while (it.hasNext()) {
                        if (((brj) it.next()).fFm.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qkP.notifyDataSetChanged();
            }
        }
    }
}
