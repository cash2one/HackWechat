package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.e;
import com.tencent.mm.plugin.card.a.n.a;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;

public class CardShopUI extends DrawStatusBarActivity implements a {
    private ListView Fv;
    private OnClickListener inN = new OnClickListener(this) {
        final /* synthetic */ CardShopUI kVo;

        {
            this.kVo = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cOd) {
                kj kjVar = (kj) view.getTag();
                if (kjVar != null) {
                    b.a(this.kVo, kjVar.fzt, kjVar.fBc, kjVar.hxu);
                    g.pQN.h(11941, new Object[]{Integer.valueOf(5), this.kVo.kIK.atF(), this.kVo.kIK.atG(), "", kjVar.name});
                }
            }
        }
    };
    BroadcastReceiver jhN = new 4(this);
    private com.tencent.mm.plugin.card.base.b kIK;
    private ArrayList<kj> kIQ = new ArrayList();
    private String kIw;
    private boolean kPc = false;
    private ProgressDialog kVi;
    private String kVj = "";
    private a kVk;
    private LinearLayout kVl;
    private View kVm;
    private TextView kVn;

    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        super.onCreate(bundle);
        this.kIK = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info_data");
        Object stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.kIK != null) {
            x.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.kVj = this.kIK.atG();
            stringExtra2 = this.kIK.atF();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.kVj = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.kVj)) {
                x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.kPc = r0;
            if (this.kPc) {
                awj();
            }
            initView();
        }
        cardShopUI.kIw = stringExtra2;
        if (TextUtils.isEmpty(this.kVj)) {
            x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
            finish();
        }
        x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kPc = r0;
        if (this.kPc) {
            awj();
        }
        initView();
    }

    protected final void initView() {
        if (TextUtils.isEmpty(this.kIK.atB().vSl)) {
            setMMTitle(R.l.dNF);
        } else {
            setMMTitle(this.kIK.atB().vSl);
        }
        this.Fv = (ListView) findViewById(R.h.bSa);
        this.kVl = (LinearLayout) View.inflate(getBaseContext(), R.i.dcn, null);
        this.Fv.addHeaderView(this.kVl);
        this.kVk = new a(this, (byte) 0);
        this.Fv.setAdapter(this.kVk);
        this.Fv.setOnItemClickListener(new 1(this, getIntent()));
        setBackBtn(new 2(this));
        this.kVm = View.inflate(this, R.i.dcm, null);
        if (this.kVl != null) {
            this.kVl.addView(this.kVm);
        }
        this.kVn = (TextView) this.kVm.findViewById(R.h.bRh);
        this.kVn.setText(R.l.dPu);
        this.kVm.setVisibility(8);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), true);
    }

    protected void onDestroy() {
        if (this.kPc) {
            unregisterReceiver(this.jhN);
        }
        am.auD().a(this.kVj, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dcD;
    }

    public final void a(boolean z, ArrayList<kj> arrayList) {
        if (this.kVi != null) {
            this.kVi.dismiss();
            this.kVi = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.d(str, str2, objArr);
        if (!z) {
            x.e("MicroMsg.CardShopUI", "onGotCardShop fail");
        } else if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
        } else {
            if (this.kIQ != null) {
                this.kIQ.clear();
                this.kIQ.addAll(arrayList);
                this.kVm.setVisibility(0);
            } else {
                this.kVm.setVisibility(8);
            }
            this.kVk.notifyDataSetChanged();
        }
    }

    private void awj() {
        x.i("MicroMsg.CardShopUI", e.NAME);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.jhN, intentFilter);
        if (awk()) {
            awl();
            return;
        }
        h.a(this, getString(R.l.dQF, new Object[]{getString(R.l.dNF)}), getString(R.l.dGO), new d$7(this), new d$8());
    }

    private static boolean awk() {
        boolean z;
        if (l.OQ() || l.OR()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    private void awl() {
        if (am.auD().a(this.kVj, this.kIw, this)) {
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.kVi = h.a(context, getString(R.l.dOg), true, new 3(this));
            return;
        }
        h.bu(this, getString(R.l.dOf));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.kPc);
                    if (!this.kPc) {
                        this.kPc = true;
                        awj();
                        return;
                    }
                    return;
                }
                h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), null);
                return;
            default:
                return;
        }
    }
}
