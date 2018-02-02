package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.brk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI extends MMActivity implements e {
    private ListView Fv;
    private ProgressDialog nMb;
    private byte[] qga;
    private View qjA;
    private a qjB;
    private List<brj> qjC = new ArrayList();
    private boolean qjD;

    static /* synthetic */ String bE(List list) {
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.bLv);
        this.qjA = findViewById(R.h.bLu);
        this.qjB = new a(this, (byte) 0);
        this.Fv.setAdapter(this.qjB);
        this.Fv.setOnScrollListener(new 1(this));
        this.Fv.setOnItemClickListener(new 2(this));
        bqI();
        setMMTitle(R.l.eKV);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsManageAuthUI qjE;

            {
                this.qjE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qjE.finish();
                return true;
            }
        });
    }

    private void bqI() {
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(800, R.k.dva, new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsManageAuthUI qjE;

            {
                this.qjE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qjE.startActivity(new Intent(this.qjE, SettingsSearchAuthUI.class));
                b.fE(this.qjE);
                return true;
            }
        });
        if (this.qjC.isEmpty()) {
            this.qjA.setVisibility(0);
            return;
        }
        this.qjA.setVisibility(8);
        if (this.qjD) {
            addTextOptionMenu(700, getString(R.l.dFl), new 5(this));
        } else {
            addTextOptionMenu(700, getString(R.l.dFA), new 6(this));
        }
    }

    protected void onResume() {
        super.onResume();
        g.CG().a(1146, this);
        g.CG().a(1127, this);
        aH(null);
    }

    protected void onPause() {
        super.onPause();
        g.CG().b(1146, this);
        g.CG().b(1127, this);
    }

    protected final int getLayoutId() {
        return R.i.dsc;
    }

    private static void aH(byte[] bArr) {
        g.CG().a(new com.tencent.mm.plugin.setting.modelsimple.e(bArr), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.nMb != null) {
            this.nMb.dismiss();
        }
        if (i != 0 || i2 != 0) {
            h.bu(this, str);
        } else if (kVar.getType() == 1146) {
            int i3;
            com.tencent.mm.plugin.setting.modelsimple.e eVar = (com.tencent.mm.plugin.setting.modelsimple.e) kVar;
            byte[] toByteArray = (eVar.qfZ == null || eVar.qfZ.wot != 1) ? null : eVar.qfZ.wor.toByteArray();
            this.qga = toByteArray;
            if (((com.tencent.mm.plugin.setting.modelsimple.e) kVar).qga != null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                this.qjC.clear();
            }
            com.tencent.mm.plugin.setting.modelsimple.e eVar2 = (com.tencent.mm.plugin.setting.modelsimple.e) kVar;
            this.qjC.addAll(eVar2.qfZ != null ? eVar2.qfZ.wos : Collections.emptyList());
            this.qjB.qjF = this.qjC;
            this.qjB.notifyDataSetChanged();
            bqI();
        } else if (kVar.getType() == 1127) {
            String str2 = ((com.tencent.mm.plugin.setting.modelsimple.b) kVar).appId;
            if (!bh.ov(str2)) {
                if (!this.qjC.isEmpty()) {
                    Iterator it = this.qjC.iterator();
                    while (it.hasNext()) {
                        if (((brj) it.next()).fFm.equals(str2)) {
                            it.remove();
                            break;
                        }
                    }
                }
                this.qjB.notifyDataSetChanged();
            }
        }
    }
}
