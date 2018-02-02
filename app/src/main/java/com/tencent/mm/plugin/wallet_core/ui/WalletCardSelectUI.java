package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private int sCN = -1;
    private int sGT = 3;
    private List<ElementQuery> sSL = new LinkedList();
    private List<ElementQuery> sSM = new LinkedList();
    private CheckedTextView sSN;
    private CheckedTextView sSO;
    private String sSP;
    private int sSQ;
    private int sSR = -1;
    private int sSS = -1;
    private a sST;
    private MaxListView sSU;

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> hiv = new ArrayList();
        final /* synthetic */ WalletCardSelectUI sSV;

        public final /* synthetic */ Object getItem(int i) {
            return zp(i);
        }

        public a(WalletCardSelectUI walletCardSelectUI, Context context) {
            this.sSV = walletCardSelectUI;
            this.context = context;
        }

        public final boolean isEnabled(int i) {
            return bh.ov(((ElementQuery) this.hiv.get(i)).sMF);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            a aVar = new a(this);
            View inflate = View.inflate(this.context, g.uEv, null);
            aVar.sSW = (CheckedTextView) inflate.findViewById(f.uhI);
            ElementQuery elementQuery = (ElementQuery) this.hiv.get(i);
            String az = bh.az(elementQuery.nBM, "");
            if (bh.ov(elementQuery.sMF)) {
                aVar.sSW.setEnabled(true);
                Object obj = az;
            } else {
                charSequence = az + "[" + elementQuery.sMF + "]";
                aVar.sSW.setEnabled(false);
            }
            aVar.sSW.setText(charSequence);
            return inflate;
        }

        public final int getCount() {
            return this.hiv.size();
        }

        public final ElementQuery zp(int i) {
            return (ElementQuery) this.hiv.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uQD);
        initView();
        this.sSM.clear();
        this.sSL.clear();
        if (o.bLy().sIH != null) {
            for (ElementQuery elementQuery : o.bLy().sIH) {
                if (this.sCN == 5 && !elementQuery.sMS) {
                    elementQuery.sMF = getString(i.uXL);
                }
                if (2 == elementQuery.sMz) {
                    this.sSM.add(elementQuery);
                } else if (elementQuery.bLb()) {
                    this.sSL.add(elementQuery);
                }
            }
        }
        if (this.sGT == 3 && !this.sSM.isEmpty()) {
            if (o.bLq().bLR()) {
                Collections.sort(this.sSM, new 6(this));
            } else {
                Collections.sort(this.sSM, new 7(this));
            }
        }
        int size;
        int i;
        if (this.sSL.isEmpty()) {
            size = this.sSM.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.sSM.get(i)).oZz.equals(this.sSP)) {
                    this.sSS = i;
                    jM(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.sSS < 0) {
                jM(false);
                enableOptionMenu(false);
            }
            this.sSN.setVisibility(8);
            this.sSO.setBackgroundResource(a$e.bBx);
            this.sSO.setCheckMarkDrawable(a$e.bFs);
        } else if (bh.ov(this.sSP)) {
            this.sSN.setChecked(false);
            this.sSO.setChecked(false);
            this.sSU.setVisibility(8);
        } else if (this.sSQ == 2) {
            size = this.sSM.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.sSM.get(i)).oZz.equals(this.sSP)) {
                    this.sSS = i;
                    jM(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.sSS < 0) {
                jM(false);
                enableOptionMenu(false);
            }
        } else {
            size = this.sSL.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.sSL.get(i)).oZz.equals(this.sSP)) {
                    this.sSR = i;
                    jM(true);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.sSR < 0) {
                jM(false);
                enableOptionMenu(false);
            }
        }
    }

    public final void initView() {
        this.sSP = this.vf.getString("key_bank_type");
        this.sSQ = this.vf.getInt("key_bankcard_type", 1);
        this.sGT = this.vf.getInt("key_support_bankcard", 1);
        this.sCN = this.vf.getInt("key_bind_scene", -1);
        this.sSU = (MaxListView) findViewById(f.uwv);
        this.sSN = (CheckedTextView) findViewById(f.uhJ);
        this.sSO = (CheckedTextView) findViewById(f.uhK);
        this.sST = new a(this, this);
        this.sSU.setAdapter(this.sST);
        this.sSU.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI sSV;

            {
                this.sSV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ElementQuery zp = this.sSV.sST.zp(i);
                if (bh.ov(zp.sMF)) {
                    if (zp.bLb()) {
                        this.sSV.sSR = i;
                    } else {
                        this.sSV.sSS = i;
                    }
                    this.sSV.enableOptionMenu(true);
                    return;
                }
                h.a(this.sSV, zp.sMF, null, true, null);
            }
        });
        setBackBtn(new 2(this));
        a(0, getString(i.dFl), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI sSV;

            {
                this.sSV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Parcelable parcelable = null;
                Intent intent = new Intent();
                if (this.sSV.sSN.isChecked() && this.sSV.sSR >= 0) {
                    parcelable = (ElementQuery) this.sSV.sSL.get(this.sSV.sSR);
                } else if (this.sSV.sSO.isChecked() && this.sSV.sSS >= 0) {
                    ElementQuery elementQuery = (ElementQuery) this.sSV.sSM.get(this.sSV.sSS);
                }
                if (parcelable != null) {
                    intent.putExtra("elemt_query", parcelable);
                    this.sSV.setResult(-1, intent);
                } else {
                    this.sSV.setResult(0);
                }
                this.sSV.finish();
                return true;
            }
        }, b.xJz);
        enableOptionMenu(false);
        this.sSN.setOnClickListener(new 4(this));
        this.sSO.setOnClickListener(new 5(this));
    }

    private void jM(boolean z) {
        this.sSU.setVisibility(0);
        if (z) {
            this.sSN.setChecked(true);
            this.sSO.setChecked(false);
            this.sST.hiv = this.sSL;
            this.sST.notifyDataSetChanged();
            this.sSU.clearChoices();
            if (this.sSR >= 0) {
                this.sSU.setItemChecked(this.sSR, true);
                enableOptionMenu(true);
                return;
            }
            enableOptionMenu(false);
            return;
        }
        this.sSN.setChecked(false);
        this.sSO.setChecked(true);
        this.sST.hiv = this.sSM;
        this.sST.notifyDataSetChanged();
        this.sSU.clearChoices();
        if (this.sSS >= 0) {
            this.sSU.setItemChecked(this.sSS, true);
            enableOptionMenu(true);
            return;
        }
        enableOptionMenu(false);
    }

    protected final int getLayoutId() {
        return g.uEJ;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean aYj() {
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
