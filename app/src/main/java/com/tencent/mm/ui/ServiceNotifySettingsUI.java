package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements e {
    private DataSetObserver BD;
    private ListView Fv;
    private int mMode;
    private String mSceneId;
    private MMSwitchBtn sFi;
    private a xMo;
    private r xMp;

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bgs com_tencent_mm_protocal_c_bgs = (bgs) it.next();
            a aVar = new a((byte) 0);
            aVar.username = com_tencent_mm_protocal_c_bgs.username;
            aVar.title = com_tencent_mm_protocal_c_bgs.fpL;
            aVar.url = com_tencent_mm_protocal_c_bgs.wKX;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.xMo;
        aVar2.xMw.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.xMw.addAll(linkedList2);
        }
        serviceNotifySettingsUI.xMo.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.drR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.mSceneId);
        Object stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle(R.l.ezE);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI xMq;

            {
                this.xMq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.xMq.finish();
                return false;
            }
        });
        this.sFi = (MMSwitchBtn) findViewById(R.h.checkbox);
        this.Fv = (ListView) findViewById(R.h.ctf);
        ((TextView) findViewById(R.h.csY)).setText(this.mMode == 1 ? R.l.ezq : R.l.ezn);
        ((TextView) findViewById(R.h.cSf)).setText(this.mMode == 1 ? R.l.ezr : R.l.ezs);
        this.xMo = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.Fv.setAdapter(this.xMo);
        getString(R.l.dGO);
        this.xMp = h.a((Context) this, getString(R.l.dHc), true, new 2(this));
        this.BD = new 3(this);
        this.xMo.registerDataSetObserver(this.BD);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        ar.CG().a(1145, this);
        ar.CG().a(new l(i), 0);
        this.sFi.nB(cnD());
    }

    protected void onDestroy() {
        int i;
        int i2 = 3;
        ar.CG().b(1145, this);
        boolean cnD = cnD();
        boolean z = this.sFi.zvg != cnD;
        LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            bmx com_tencent_mm_protocal_c_bmx = new bmx();
            if (this.sFi.zvg) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_bmx.wPX = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_bmx.ktN = i3;
            linkedList.add(com_tencent_mm_protocal_c_bmx);
            if (cnD) {
                z2 = false;
            } else {
                z2 = true;
            }
            a aVar = a.xsq;
            if (this.mMode == 1) {
                aVar = a.xsr;
            }
            ar.Hg();
            c.CU().a(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.b.a.xef.m(new mx());
            if (this.mMode == 1) {
                if (com_tencent_mm_protocal_c_bmx.wPX == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(i3), this.mSceneId});
                g.pQN.h(13798, new Object[]{Integer.valueOf(i3), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bh.Wo())});
            } else {
                i3 = com_tencent_mm_protocal_c_bmx.wPX == 1 ? 11 : 10;
                g.pQN.h(13796, new Object[]{Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(bh.Wo())});
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.xMo.xMx;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                bmx com_tencent_mm_protocal_c_bmx2 = new bmx();
                com_tencent_mm_protocal_c_bmx2.wPY = aVar2.username;
                com_tencent_mm_protocal_c_bmx2.ktN = i2;
                com_tencent_mm_protocal_c_bmx2.wPX = 1;
                linkedList.add(com_tencent_mm_protocal_c_bmx2);
                b sgVar = new sg();
                sgVar.fJX.fnl = aVar2.username;
                sgVar.fJX.action = 2;
                sgVar.fJX.fJZ = i;
                com.tencent.mm.sdk.b.a.xef.m(sgVar);
            }
        }
        if (!linkedList.isEmpty()) {
            ar.CG().a(1176, new 4(this, z, cnD, linkedList, i));
            ar.CG().a(new k(linkedList), 0);
        }
        this.xMo.unregisterDataSetObserver(this.BD);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (this.xMp != null) {
            this.xMp.dismiss();
        }
        x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            final afs Jb = ((l) kVar).Jb();
            if (this.mMode == 1) {
                this.sFi.nB(Jb.wnB);
            } else {
                this.sFi.nB(Jb.vLB);
            }
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ServiceNotifySettingsUI xMq;

                public final void run() {
                    if (this.xMq.mMode == 1) {
                        ServiceNotifySettingsUI.a(this.xMq, Jb.wnC);
                    } else {
                        ServiceNotifySettingsUI.a(this.xMq, Jb.vLC);
                    }
                }
            });
            return;
        }
        u.makeText(this, R.l.ezv, 0).show();
    }

    private boolean cnD() {
        a aVar = a.xsq;
        if (this.mMode == 1) {
            aVar = a.xsr;
        }
        ar.Hg();
        return c.CU().getBoolean(aVar, true);
    }
}
