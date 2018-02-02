package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private int fBs = 0;
    private f ilB;
    private RcptItem inZ = null;
    private RcptItem ioa = null;
    private List<RcptItem> iob;

    private void XU() {
        switch (this.fBs) {
            case 1:
                this.inZ = null;
                this.fBs = 0;
                break;
            case 2:
                this.ioa = null;
                this.fBs = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.fBs);
        intent.putExtra("key_province", this.inZ);
        intent.putExtra("key_city", this.ioa);
        setResult(0, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XB() {
        return R.o.fca;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        Intent intent = getIntent();
        int i = R.l.dDi;
        if (intent != null) {
            i = intent.getIntExtra("ui_title", R.l.dDi);
        }
        setMMTitle(i);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletMultiRcptSelectUI ioc;

            {
                this.ioc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ioc.XU();
                return true;
            }
        });
        s(intent);
        List list = a.XG().imb;
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.MultiRptSelectUI", "list == null || list.isEmpty(), need loadata!");
            a.XG().XH();
        }
        switch (this.fBs) {
            case 0:
                a.XE();
                list = a.XG().imb;
                break;
            case 1:
                if (!(this.inZ == null || bh.ov(this.inZ.code))) {
                    a.XE();
                    list = a.XG().oM(this.inZ.code);
                    break;
                }
            case 2:
                if (!(this.ioa == null || bh.ov(this.ioa.code))) {
                    a.XE();
                    list = a.XG().oN(this.ioa.code);
                    break;
                }
            default:
                a.XE();
                list = a.XG().imb;
                break;
        }
        this.iob = list;
        if (this.iob == null || this.iob.size() <= 0) {
            x.e("MicroMsg.MultiRptSelectUI", "initZoneItems error ,check zone lists!");
            return;
        }
        this.ilB.removeAll();
        int i2 = 0;
        while (i2 < this.iob.size()) {
            if (!(this.iob.get(i2) == null || bh.ov(((RcptItem) this.iob.get(i2)).name))) {
                Preference rcptPreference = new RcptPreference(this);
                RcptItem rcptItem = (RcptItem) this.iob.get(i2);
                if (rcptItem == null || bh.ov(rcptItem.name)) {
                    x.e("MicroMsg.RcptPreference", "setZoneItem item = null");
                } else {
                    rcptPreference.setKey(rcptItem.code + rcptPreference.hashCode());
                    rcptPreference.inQ = rcptItem;
                }
                this.ilB.a(rcptPreference);
            }
            i2++;
        }
        this.ilB.a(new PreferenceSmallCategory(this));
    }

    private void s(Intent intent) {
        RcptItem rcptItem = null;
        if (intent == null) {
            x.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            return;
        }
        RcptItem rcptItem2;
        this.fBs = intent.getIntExtra("key_stage", 0);
        this.inZ = (RcptItem) intent.getParcelableExtra("key_province");
        this.ioa = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.XE();
            l XG = a.XG();
            if (!bh.ov(stringExtra)) {
                for (RcptItem rcptItem22 : XG.imb) {
                    if (rcptItem22.name.startsWith(stringExtra)) {
                        break;
                    }
                }
            }
            rcptItem22 = null;
            this.inZ = rcptItem22;
            if (this.inZ != null) {
                this.fBs = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.fBs) {
            a.XE();
            List<RcptItem> oM = a.XG().oM(this.inZ.code);
            if (oM != null && oM.size() != 0) {
                for (RcptItem rcptItem222 : oM) {
                    if (rcptItem222.name.startsWith(stringExtra)) {
                        rcptItem = rcptItem222;
                        break;
                    }
                }
            }
            this.ioa = rcptItem;
            if (this.ioa != null) {
                this.fBs = 2;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).inQ;
            if (rcptItem == null || bh.ov(rcptItem.name)) {
                x.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
            } else {
                if (!rcptItem.ilZ) {
                    this.fBs = 2;
                }
                switch (this.fBs) {
                    case 0:
                        this.inZ = rcptItem;
                        this.fBs = 1;
                        break;
                    case 1:
                        this.ioa = rcptItem;
                        this.fBs = 2;
                        break;
                    case 2:
                        StringBuilder stringBuilder = new StringBuilder();
                        if (this.inZ != null) {
                            stringBuilder.append(this.inZ.name).append(" ");
                        }
                        if (this.ioa != null) {
                            stringBuilder.append(this.ioa.name).append(" ");
                        }
                        stringBuilder.append(rcptItem.name);
                        x.d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
                        Intent intent = new Intent();
                        intent.putExtra("karea_result", stringBuilder.toString());
                        intent.putExtra("kpost_code", rcptItem.ilY);
                        intent.putExtra("kwcode", rcptItem.code);
                        setResult(-1, intent);
                        finish();
                        break;
                }
                Intent intent2 = getIntent();
                int intExtra = intent2 != null ? intent2.getIntExtra("ui_title", -1) : -1;
                Intent intent3 = new Intent(this, WalletMultiRcptSelectUI.class);
                intent3.putExtra("key_stage", this.fBs);
                intent3.putExtra("key_province", this.inZ);
                intent3.putExtra("key_city", this.ioa);
                if (-1 != intExtra) {
                    intent3.putExtra("ui_title", intExtra);
                }
                startActivityForResult(intent3, 1);
            }
        }
        return false;
    }

    public void onBackPressed() {
        XU();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                s(intent);
                return;
            default:
                return;
        }
    }
}
