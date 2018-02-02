package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private String hEx;
    private String ilo = "";
    private p lcZ;
    private List<a> list;
    public LinearLayout nIQ;
    private boolean nJb = false;
    private ListView nJs;
    private f nJt;
    private IPCallCountryCodeScrollbar nJu;
    private IPCallCountryCodeScrollbar$a nJv;
    private boolean nJw = false;

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        if (iPCallCountryCodeSelectUI.nJt != null) {
            iPCallCountryCodeSelectUI.nJt.CN(iPCallCountryCodeSelectUI.ilo);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.hEx = bh.az(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bh.az(getIntent().getStringExtra("couttry_code"), "");
        this.nJb = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI nJx;

            {
                this.nJx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nJx.finish();
                return false;
            }
        });
        initView();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(-1, R.a.bqm);
    }

    protected final int getLayoutId() {
        return R.i.dlY;
    }

    protected void onPause() {
        super.onPause();
        if (this.lcZ != null) {
            this.lcZ.cxX();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dDp);
        this.lcZ = new p(true, true);
        this.lcZ.zms = new 2(this);
        a(this.lcZ);
        this.nJu = (IPCallCountryCodeScrollbar) findViewById(R.h.bJn);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue : c.aTj().aTm()) {
            int intValue2 = intValue.intValue();
            if (i >= 5) {
                break;
            }
            String Dc = com.tencent.mm.plugin.ipcall.b.a.Dc(String.valueOf(intValue2));
            if (bh.ov(Dc) || c.aTj().rq(intValue2)) {
                intValue2 = i;
            } else {
                this.list.add(new a(Dc, String.valueOf(intValue2), 0, "0"));
                intValue2 = i + 1;
            }
            i = intValue2;
        }
        if (i > 0) {
            this.nJw = true;
        }
        aUu();
        x.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.nIQ = (LinearLayout) findViewById(R.h.bJp);
        this.nJs = (ListView) findViewById(R.h.bJe);
        this.nJt = new f(this, this.list);
        this.nJt.nJb = this.nJb;
        this.nJt.nJc = this.nJw;
        this.nJs.setAdapter(this.nJt);
        this.nJs.setVisibility(0);
        this.nJv = new IPCallCountryCodeScrollbar$a(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI nJx;

            {
                this.nJx = r1;
            }

            public final void xh(String str) {
                int i = 0;
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    this.nJx.nJs.setSelection(0);
                    return;
                }
                int[] iArr = this.nJx.nJt.nJa;
                if (iArr != null) {
                    while (i < iArr.length) {
                        if (iArr[i] == charAt) {
                            this.nJx.nJs.setSelection(i + this.nJx.nJs.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        this.nJu.nJo = this.nJv;
        setBackBtn(new 4(this));
        this.nJs.setOnItemClickListener(new 5(this));
    }

    private void aUu() {
        b bVar;
        String str;
        if (w.cfe()) {
            for (Entry entry : com.tencent.mm.plugin.ipcall.b.a.aUK().entrySet()) {
                entry.getKey();
                bVar = (b) entry.getValue();
                str = bVar.nOv;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (int i = 0; i < length; i++) {
                        String g = SpellMap.g(toCharArray[i]);
                        if (bh.ov(g)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(g);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (bh.ov(str)) {
                    str = " ";
                }
                if (!c.aTj().rq(bh.getInt(bVar.nOu, 0))) {
                    this.list.add(new a(bVar.nOv, bVar.nOu, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : com.tencent.mm.plugin.ipcall.b.a.aUK().entrySet()) {
                entry2.getKey();
                bVar = (b) entry2.getValue();
                str = bVar.nOv.toUpperCase();
                if (bh.ov(str)) {
                    str = " ";
                }
                if (!c.aTj().rq(bh.getInt(bVar.nOu, 0))) {
                    this.list.add(new a(bVar.nOv, bVar.nOu, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.list, new 6(this));
        for (a aUi : this.list) {
            int aUi2 = aUi.aUi();
            if (aUi2 != 0) {
                this.nJu.CR(String.valueOf((char) aUi2));
            }
        }
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
