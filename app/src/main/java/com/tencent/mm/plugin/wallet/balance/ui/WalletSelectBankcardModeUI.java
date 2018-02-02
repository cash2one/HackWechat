package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private int kFm = 0;
    private ArrayList<a> mData = new ArrayList();
    private ListView pch;
    private TextView sAl;
    private b sAm;
    private ArrayList<Bankcard> szk;
    private Bankcard szl;
    private String szm;
    private int szv = 0;
    private int szz = -1;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        this.kFm = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.szz = getIntent().getIntExtra("key_select_index", -1);
        x.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.kFm);
        initView();
    }

    protected final void initView() {
        setMMTitle(i.uPC);
        setBackBtn(new 1(this));
        this.sAl = (TextView) findViewById(f.uAf);
        if (this.kFm == 0) {
            this.sAl.setText(i.uWF);
        } else if (this.kFm == 1) {
            this.sAl.setText(i.uWG);
        }
        this.pch = (ListView) findViewById(f.uxZ);
        this.sAm = new b(this);
        this.pch.setAdapter(this.sAm);
        this.pch.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletSelectBankcardModeUI sAn;

            {
                this.sAn = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.sAn.szz = i;
                this.sAn.sAm.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                this.sAn.setResult(-1, intent);
                x.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + i);
                this.sAn.finish();
            }
        });
        this.mData.clear();
        this.szm = getString(i.uPx);
        if (this.kFm == 0) {
            p.bJN();
            ag bJO = p.bJO();
            this.szk = bJO.bLZ();
            this.szl = bJO.a(this.szk, null, false, true);
            if (bJO.sQd != null) {
                this.szv = bJO.sQd.szv;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.szv);
            } else {
                this.szv = 0;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.szk == null || this.szk.size() <= 0) {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.szk.size());
                Iterator it = this.szk.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a((byte) 0);
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.szv != 1) {
                        x.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.szv);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.kNs = getString(i.uOV) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.kNs = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.szz == -1 && this.szl != null && this.szl.equals(bankcard)) {
                        this.szz = i;
                    }
                    i++;
                }
                if (this.szz == -1 && this.szl == null) {
                    this.szz = i;
                }
            }
            a aVar2 = new a((byte) 0);
            aVar2.title = this.szm;
            aVar2.kNs = "";
            this.mData.add(aVar2);
        }
        this.sAm.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return g.uFM;
    }

    public final boolean aYj() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
