package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ag;

public final class e {
    ListView nIh;
    h nIi;
    View nIj;
    IPCallAddressUI nIk;
    boolean nIl = false;
    TextView nIm = null;
    TextView nIn = null;
    LinearLayout nIo = null;
    TextView nIp = null;
    ImageView nIq = null;

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.nIh = listView;
        this.nIk = iPCallAddressUI;
        this.nIj = view;
    }

    public final void aUo() {
        ag.y(new 6(this));
    }

    public final void aUp() {
        ag.y(new 7(this));
    }
}
