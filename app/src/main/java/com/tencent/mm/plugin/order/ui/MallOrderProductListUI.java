package com.tencent.mm.plugin.order.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private String hcp = "";
    private List<ProductSectionItem> jNq = new ArrayList();
    private BaseAdapter kPo;
    private String lie = "";
    private ListView pch;

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        if (!c.at(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.au(mallOrderProductListUI, productSectionItem.pbO);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uDe;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(0);
        initView();
    }

    @Deprecated
    protected final void initView() {
        setMMTitle(i.uLp);
        Bundle bundle = this.vf;
        Collection parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.jNq.clear();
            this.jNq.addAll(parcelableArrayList);
        }
        this.lie = bundle.getString("key_trans_id");
        this.hcp = bundle.getString("appname");
        this.pch = (ListView) findViewById(f.usG);
        this.kPo = new a(this, (byte) 0);
        this.pch.setAdapter(this.kPo);
        this.kPo.notifyDataSetChanged();
        this.pch.setOnItemClickListener(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.ag(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ad(this);
        }
        return true;
    }
}
