package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public class ExdeviceRankDataSourceUI extends MMActivity implements e {
    private ListView Fv;
    private b lWH;

    static /* synthetic */ a a(brs com_tencent_mm_protocal_c_brs) {
        a aVar = new a((byte) 0);
        aVar.lWL = null;
        if (com_tencent_mm_protocal_c_brs == null) {
            aVar.lWK = null;
        } else {
            aVar.lWK = com_tencent_mm_protocal_c_brs;
        }
        return aVar;
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar == null || aVar.lWK == null) {
            return "";
        }
        if (!bh.ov(aVar.lWK.ksY)) {
            return aVar.lWK.ksY;
        }
        bq bqVar = aVar.lWL;
        String str = null;
        if (bqVar == null) {
            return "";
        }
        if (!bh.ov(bqVar.gfN)) {
            str = bqVar.gfN;
        } else if (!bh.ov(bqVar.gfO)) {
            str = bqVar.gfO;
        } else if (bqVar.field_mac != 0) {
            str = b.cK(bqVar.field_mac);
        } else if (!bh.ov(bqVar.field_deviceID)) {
            str = bqVar.field_deviceID;
        }
        return bh.ou(str);
    }

    static /* synthetic */ boolean a(String str, String str2, brs com_tencent_mm_protocal_c_brs) {
        return (com_tencent_mm_protocal_c_brs == null || str == null || str2 == null || !str.equals(com_tencent_mm_protocal_c_brs.vXI) || !str2.equals(com_tencent_mm_protocal_c_brs.vJA)) ? false : true;
    }

    protected final int getLayoutId() {
        return R.i.dha;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI lWI;

            {
                this.lWI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lWI.finish();
                return true;
            }
        });
        setMMTitle(R.l.dWd);
        ar.CG().a(1267, (e) this);
        initView();
        ar.CG().a(new q(), 0);
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctf);
        View inflate = View.inflate(this, R.i.dhc, null);
        View inflate2 = View.inflate(this, R.i.dhb, null);
        this.Fv.addHeaderView(inflate, null, false);
        this.Fv.addFooterView(inflate2, null, false);
        this.lWH = new b();
        this.Fv.setAdapter(this.lWH);
        ((ScrollView) findViewById(R.h.cJh)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI lWI;

            {
                this.lWI = r1;
            }

            public final void onClick(View view) {
                this.lWI.startActivityForResult(new Intent(this.lWI.mController.xIM, ExdeviceAddDataSourceUI.class), 1);
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1267, (e) this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                return;
            }
            String cK = b.cK(longExtra);
            if (cK == null) {
                x.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", cK);
            } else if (this.lWH.zr(cK) != null) {
                x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
            } else {
                com.tencent.mm.plugin.exdevice.h.b cJ = ad.aEk().cJ(longExtra);
                if (cJ == null) {
                    x.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", Long.valueOf(longExtra));
                } else if (this.lWH.cs(cJ.field_deviceID, cJ.field_deviceType) != null) {
                    x.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                } else {
                    ar.CG().a(1267, (e) this);
                    ar.CG().a(new q(), 0);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
        } else if (kVar instanceof q) {
            ar.CG().b(1267, (e) this);
            if (i == 0 && i2 == 0) {
                int size;
                agc com_tencent_mm_protocal_c_agc = (agc) ((q) kVar).gJQ.hmh.hmo;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                if (com_tencent_mm_protocal_c_agc.wjp != null) {
                    size = com_tencent_mm_protocal_c_agc.wjp.size();
                } else {
                    size = 0;
                }
                objArr[0] = Integer.valueOf(size);
                x.d(str2, str3, objArr);
                runOnUiThread(new 3(this, com_tencent_mm_protocal_c_agc.wjp));
            }
        }
    }
}
