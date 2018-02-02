package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private String hEx;
    private String ilo = "";
    private p lcZ;
    private List<c> list;
    private boolean nJb = false;
    private ListView nJs;
    private a yQC;
    private d zgW;
    private VerticalScrollBar zgX;

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        if (countryCodeUI.zgW != null) {
            countryCodeUI.zgW.CN(countryCodeUI.ilo);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.hEx = t.az(getIntent().getStringExtra("country_name"), "");
        this.countryCode = t.az(getIntent().getStringExtra("couttry_code"), "");
        this.nJb = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        initView();
    }

    protected final int getLayoutId() {
        if (w.cfg()) {
            return R.i.dfk;
        }
        return R.i.dfj;
    }

    protected void onPause() {
        super.onPause();
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dDp);
        x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode start:" + System.currentTimeMillis());
        String[] split = getString(R.l.bZb).trim().split(",");
        String[] split2;
        if (w.cfg()) {
            x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t1:" + System.currentTimeMillis());
            for (String trim : split) {
                split2 = trim.trim().split(":");
                this.list.add(new c(split2[1], split2[0], com.tencent.mm.ar.a.lF(split2[1]), split2[1]));
            }
            x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t2:" + System.currentTimeMillis());
            Collections.sort(this.list, new Comparator<c>(this) {
                final /* synthetic */ CountryCodeUI zgY;

                {
                    this.zgY = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return new Integer(((c) obj).nGR).intValue() - new Integer(((c) obj2).nGR).intValue();
                }
            });
            x.d("MicroMsg.CountryCodeUI", "CHT2:initCountryCode t3:" + System.currentTimeMillis());
        } else {
            for (String trim2 : split) {
                split2 = trim2.trim().split(":");
                if (split2.length < 3) {
                    x.e("MicroMsg.CountryCodeUI", "this country item has problem %s", new Object[]{split[r0]});
                } else {
                    this.list.add(new c(split2[1], split2[0], split2[2].charAt(0), split2[2]));
                }
            }
            Collections.sort(this.list, new 1(this));
        }
        this.lcZ = new p(true, true);
        this.lcZ.zms = new 3(this);
        a(this.lcZ);
        this.nJs = (ListView) findViewById(R.h.bJe);
        this.zgW = new d(this, this.list);
        this.zgW.nJb = this.nJb;
        this.nJs.setAdapter(this.zgW);
        this.nJs.setVisibility(0);
        this.zgX = (VerticalScrollBar) findViewById(R.h.bJn);
        if (w.cfg()) {
            this.yQC = new 5(this);
        } else {
            this.yQC = new 4(this);
        }
        this.zgX.yhE = this.yQC;
        setBackBtn(new 6(this));
        this.nJs.setOnItemClickListener(new 7(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.hEx);
        intent.putExtra("couttry_code", this.countryCode);
        setResult(100, intent);
        finish();
        return true;
    }
}
