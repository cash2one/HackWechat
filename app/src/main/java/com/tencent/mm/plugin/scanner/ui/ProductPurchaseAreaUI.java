package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    protected f jKn;
    private String lyH;
    private List<a> pVM;
    private int pVN;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        n.a bW = i.bW(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bW == null || bW.qbc == null) {
            x.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            return;
        }
        this.lyH = bW.field_productid;
        this.pVN = bW.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        x.i("MicroMsg.ProductPurchaseAreaUI", "referkey:" + stringExtra);
        if (!bh.ov(stringExtra)) {
            for (int i = 0; i < bW.qbc.size(); i++) {
                if (stringExtra.equals(((com.tencent.mm.plugin.scanner.a.a) bW.qbc.get(i)).pSq)) {
                    this.pVM = ((com.tencent.mm.plugin.scanner.a.a) bW.qbc.get(i)).hOg;
                    setMMTitle(((com.tencent.mm.plugin.scanner.a.a) bW.qbc.get(i)).title);
                    bpg();
                    return;
                }
            }
        }
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.jKn = this.yjd;
    }

    private void bpg() {
        if (this.pVM != null) {
            for (int i = 0; i < this.pVM.size(); i++) {
                a aVar = (a) this.pVM.get(i);
                String valueOf = String.valueOf(i);
                if (aVar != null) {
                    Preference aVar2 = new a(this);
                    aVar2.setKey(valueOf);
                    aVar2.setTitle(aVar.name);
                    aVar2.setSummary(aVar.desc);
                    aVar2.pTL = aVar.hef;
                    this.jKn.a(aVar2);
                    if (i != this.pVM.size() - 1) {
                        this.jKn.a(new g(this.mController.xIM));
                    }
                }
            }
            this.jKn.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (this.pVM == null) {
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.ibD).intValue();
            if (intValue < 0 || intValue >= this.pVM.size()) {
                return false;
            }
            a aVar = (a) this.pVM.get(intValue);
            if (aVar == null) {
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.hOf;
                    if (!bh.ov(aVar.hOf)) {
                        j(this.mController.xIM, aVar.hOf, this.pVN);
                        break;
                    }
                    x.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                    break;
                case 9:
                    str = aVar.pSy;
                    if (!bh.ov(aVar.pSy)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.pSy);
                        intent.putExtra("key_product_scene", 12);
                        d.b(this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    x.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.hOf);
                    if (!bh.ov(aVar.hOf)) {
                        j(this.mController.xIM, aVar.hOf, this.pVN);
                        break;
                    }
                    break;
            }
            ar.CG().a(new h(this.lyH, aVar.pSx, aVar.type, str, this.pVM.size(), aVar.showType), 0);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e, "", new Object[0]);
            return false;
        }
    }

    private static void j(Context context, String str, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", i.vD(i));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final int XB() {
        return R.o.fbU;
    }
}
