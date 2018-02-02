package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.db;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView Fv;
    private a lUM;

    protected final int getLayoutId() {
        return R.i.dgQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(R.l.edl);
        b dbVar = new db();
        dbVar.frv.frw = true;
        a.xef.m(dbVar);
        initView();
        ar.CG().a(537, this.lUM);
    }

    protected final void initView() {
        this.Fv = (ListView) findViewById(R.h.ctf);
        this.lUM = new a(this);
        View.inflate(this, R.i.dgG, null);
        this.Fv.setAdapter(this.lUM);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lUM.aD(ad.aEk().aEP());
        this.lUM.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(537, this.lUM);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.lUM.lUO) {
            return super.onKeyDown(i, keyEvent);
        }
        updateOptionMenuText(0, getString(R.l.dEF));
        a aVar = this.lUM;
        if (aVar.lUO) {
            aVar.lUO = false;
            ag.y(new 5(aVar));
        }
        return true;
    }
}
