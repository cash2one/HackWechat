package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class j {
    TextView FN;
    Context context;
    private String lcH;
    af mHandler = new 1(this, Looper.getMainLooper());
    boolean nTU = false;
    private ViewGroup nTW;
    ArrayList<String> nTX;
    private final int nTY = 100;
    private final int nTZ = 1;
    private final int nUa = 2;
    private final int nUb = 3;
    private final int nUc = 4;
    private final int nUd = 5;
    private final int nUe = 6;
    private final int nUf = 7;
    private final int nUg = 8;
    private final int nUh = 9;
    private final int nUi = 10;
    boolean nUj = true;
    private int nUk = Color.parseColor("#44FEBB");
    int nUl = Color.parseColor("#FFFFFF");
    int nUm = Color.parseColor("#E54646");
    int nUn = Color.parseColor("#FFC90C");
    boolean nUo = false;
    String nUp = "";

    static /* synthetic */ void a(j jVar) {
        jVar.FN.setTextColor(jVar.nUk);
        jVar.FN.invalidate();
    }

    static /* synthetic */ void b(j jVar) {
        jVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        jVar.mHandler.sendMessageDelayed(obtain, 100);
    }

    public j(Context context, ViewGroup viewGroup, String str) {
        this.context = context;
        this.nTW = viewGroup;
        this.FN = (TextView) this.nTW.findViewById(R.h.title);
        this.lcH = str;
        init();
    }

    private void init() {
        x.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.FN.invalidate();
        this.nTX = new ArrayList();
        for (String add : l.aVv().DA(this.lcH)) {
            this.nTX.add(add);
        }
        gn(false);
    }

    final void gn(boolean z) {
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.nTX.size());
        x.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[]{Integer.valueOf(this.nTX.size()), Boolean.valueOf(z)});
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
        } else {
            this.mHandler.sendMessage(obtain);
        }
    }
}
