package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn rWJ = null;
    private TextView rWK = null;
    private MMSwitchBtn rWL = null;
    private SparseIntArray rWM = new SparseIntArray();
    private int status;

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        x.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.rWM.put(i2, z ? 1 : 2);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dHl);
        this.status = q.FW();
        initView();
    }

    private boolean uR(int i) {
        return (this.status & i) != 0;
    }

    protected final int getLayoutId() {
        return R.i.daI;
    }

    protected final void initView() {
        this.rWJ = (MMSwitchBtn) findViewById(R.h.czh);
        this.rWK = (TextView) findViewById(R.h.bLy);
        this.rWL = (MMSwitchBtn) findViewById(R.h.bLx);
        this.rWJ.nB(uR(32));
        if (bEd() == 1) {
            this.rWL.nB(uR(2097152));
            this.rWL.zvp = new 1(this);
        } else {
            this.rWK.setVisibility(8);
            this.rWL.setVisibility(8);
        }
        this.rWJ.zvp = new 2(this);
        setBackBtn(new 3(this));
    }

    private static int bEd() {
        int i;
        String value = g.zY().getValue("AutoAddFriendShow");
        if (bh.ov(value)) {
            value = "0";
        }
        try {
            i = bh.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        x.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.rWM.size(); i++) {
            int keyAt = this.rWM.keyAt(i);
            int valueAt = this.rWM.valueAt(i);
            a wlVar = new wl();
            wlVar.wgL = keyAt;
            wlVar.wgM = valueAt;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            x.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.rWM.clear();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
