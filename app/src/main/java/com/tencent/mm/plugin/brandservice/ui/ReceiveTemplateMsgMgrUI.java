package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements e {
    private static LinkedList<apr> kGL;
    private ProgressDialog iln;
    protected f jKn;
    private String kGK;
    private boolean kGM = false;

    protected final int getLayoutId() {
        return R.i.dqs;
    }

    public final int XB() {
        return R.o.fbV;
    }

    public final int asz() {
        return R.i.dqr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(1031, this);
        ar.CG().a(1030, this);
        initView();
    }

    protected void onPause() {
        if (this.kGM) {
            x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.kGM = false;
            ar.CG().a(new l(this.kGK, kGL), 0);
        }
        super.onPause();
    }

    protected void onDestroy() {
        ar.CG().b(1031, this);
        ar.CG().b(1030, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.dWc);
        this.jKn = this.yjd;
        this.kGK = getIntent().getStringExtra("enterprise_biz_name");
        if (bh.ov(this.kGK)) {
            x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            return;
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReceiveTemplateMsgMgrUI kGN;

            {
                this.kGN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kGN.finish();
                return true;
            }
        });
        k eVar = new com.tencent.mm.plugin.brandservice.a.e(this.kGK);
        ar.CG().a(eVar, 0);
        getString(R.l.dGO);
        this.iln = h.a((Context) this, getString(R.l.eCp), true, new 2(this, eVar));
    }

    public final boolean a(f fVar, Preference preference) {
        if (kGL == null) {
            x.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
        } else {
            String str = preference.ibD;
            if (bh.ov(str)) {
                x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
            } else {
                Iterator it = kGL.iterator();
                while (it.hasNext()) {
                    apr com_tencent_mm_protocal_c_apr = (apr) it.next();
                    if (str.equals(bh.ou(com_tencent_mm_protocal_c_apr.wwx))) {
                        this.kGM = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            com_tencent_mm_protocal_c_apr.vGN = 0;
                        } else {
                            com_tencent_mm_protocal_c_apr.vGN = 1;
                        }
                        if (this.kGM) {
                            x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            ag.h(new 3(this), 4000);
                        }
                    }
                }
                if (this.kGM) {
                    x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                    ag.h(new 3(this), 4000);
                }
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        apt com_tencent_mm_protocal_c_apt = null;
        if (kVar == null) {
            x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        x.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
        if (kVar.getType() == 1031) {
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
                this.iln = null;
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) kVar;
                if (!(eVar.gJQ == null || eVar.gJQ.hmh.hmo == null)) {
                    com_tencent_mm_protocal_c_apt = (apt) eVar.gJQ.hmh.hmo;
                }
                kGL = com_tencent_mm_protocal_c_apt.wwy;
                LinkedList linkedList = kGL;
                this.jKn.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    df(true);
                    return;
                }
                df(false);
                x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    apr com_tencent_mm_protocal_c_apr = (apr) it.next();
                    Preference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.yjI = false;
                    checkBoxPreference.setKey(com_tencent_mm_protocal_c_apr.wwx);
                    checkBoxPreference.setTitle(com_tencent_mm_protocal_c_apr.fon);
                    checkBoxPreference.tSw = com_tencent_mm_protocal_c_apr.vGN == 0;
                    this.jKn.a(checkBoxPreference);
                }
                this.jKn.notifyDataSetChanged();
                x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                return;
            }
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.eCn), 1).show();
            df(true);
        } else if (kVar.getType() != 1030) {
        } else {
            if (i != 0 || i2 != 0) {
                Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.eCo), 0).show();
            }
        }
    }

    private void df(boolean z) {
        View findViewById = findViewById(R.h.cGi);
        View findViewById2 = findViewById(R.h.cGj);
        if (findViewById == null) {
            return;
        }
        if (z) {
            ((TextView) findViewById).setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                return;
            }
            return;
        }
        ((TextView) findViewById).setVisibility(8);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }
}
