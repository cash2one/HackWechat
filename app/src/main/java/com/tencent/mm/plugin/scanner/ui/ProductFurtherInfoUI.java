package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n$a;
import com.tencent.mm.plugin.scanner.util.n$a.a.b;
import com.tencent.mm.plugin.scanner.util.n.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFurtherInfoUI extends MMPreference {
    protected f jKn;
    private String pVA;
    private MMPageControlView pVy;
    private a pVz;
    private ViewPager xS;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n$a bW = i.bW(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bW == null || bW.qbd == null) {
            x.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            return;
        }
        this.pVz = bW.qbd;
        this.pVA = bW.field_feedbackurl;
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new 1(this));
        addIconOptionMenu(0, R.g.bDI, new 2(this));
        this.jKn = this.yjd;
        List arrayList = new ArrayList();
        Iterator it = this.pVz.qbe.iterator();
        while (it.hasNext()) {
            arrayList.add(((a.a) it.next()).hOf);
        }
        this.xS = (ViewPager) findViewById(R.h.cCl);
        this.pVy = (MMPageControlView) findViewById(R.h.cpL);
        this.pVy.ych = R.i.dpi;
        this.pVy.setVisibility(0);
        this.xS.setOnTouchListener(new 3(this));
        this.xS.zo = new 4(this);
        u aVar = new a(this, this);
        this.xS.a(aVar);
        if (arrayList.size() > 0) {
            aVar.pVD = arrayList;
            aVar.pVB.pVy.eR(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.xS.setVisibility(0);
        }
        while (i < this.pVz.qbf.size()) {
            b bVar = (b) this.pVz.qbf.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(R.i.dov);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.jKn.a(preference);
            i++;
        }
        this.jKn.notifyDataSetChanged();
    }

    public final int XB() {
        return R.o.dpx;
    }

    protected final int getLayoutId() {
        return R.i.dpx;
    }

    public final int asz() {
        return R.i.dpy;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
