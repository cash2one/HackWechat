package com.tencent.mm.plugin.chatroom.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.plugin.chatroom.ui.a.1;
import com.tencent.mm.plugin.chatroom.ui.a.2;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements a.a {
    private String chatroomName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        k oVar = new o(this.chatroomName);
        ar.CG().a(482, new 2(false, h.a(this, getString(R.l.ctB), false, new 1()), this, this));
        ar.CG().a(oVar, 0);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static void u(Runnable runnable) {
        new af().postDelayed(runnable, 200);
    }

    public final void i(boolean z, int i) {
        if (z) {
            h.bu(this, getString(R.l.eGx));
            u(new 1(this, z, i));
            return;
        }
        h.a(this, getString(R.l.eGw), "", null);
        u(new 2(this, z));
    }
}
