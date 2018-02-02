package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public final class u {
    public p fhr;
    public p lcZ = null;
    public View yAG;
    public boolean yAH = false;
    public boolean yAI = false;
    public boolean yAJ = false;
    public long yAK = -1;
    public ArrayList<String> yAL;
    public boolean yAM = false;
    public TextView yAN;
    public ListView yAO;
    public View yAP;
    public boolean yAQ = false;
    private boolean yAR = true;
    private int yAS = 0;
    public boolean yAT = false;
    public boolean yAU = false;
    public boolean ysa = false;
    public com.tencent.mm.ui.chatting.u ytQ;

    class AnonymousClass12 implements Runnable {
        final /* synthetic */ int jZe;
        final /* synthetic */ long val$position;
        final /* synthetic */ u yAV;

        public AnonymousClass12(u uVar, long j, int i) {
            this.yAV = uVar;
            this.val$position = j;
            this.jZe = i;
        }

        public final void run() {
            x.i("MicroMsg.ChattingUI.SearchImp", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", new Object[]{Long.valueOf(this.val$position), Integer.valueOf(this.jZe)});
            t.a(this.yAV.fhr.csx(), this.jZe, false);
            if (this.yAV.yAT && !this.yAV.yAJ) {
                new af().postDelayed(new 13(this.yAV, this.jZe, this.val$position), 200);
                ar.Hg();
                c.CU().a(a.xqy, Boolean.valueOf(false));
            }
        }
    }

    public u(p pVar) {
        this.fhr = pVar;
    }

    public final boolean gd(long j) {
        if (this.yAK != j || !this.yAJ || this.yAL == null || this.yAL.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void ctU() {
        String str = "MicroMsg.ChattingUI.SearchImp";
        String str2 = "enter edit search mode, search stub view is null?%B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yAG == null);
        x.v(str, str2, objArr);
        this.yAQ = true;
        this.fhr.csx().setVisibility(8);
        if (this.yAG != null) {
            this.yAG.setVisibility(0);
        } else {
            g.a(this.fhr.csq(), R.h.cJs);
            this.yAG = this.fhr.csq().findViewById(R.h.cJx);
            this.yAG.setVisibility(0);
            this.yAP = this.fhr.csq().findViewById(R.h.cJq);
            this.fhr.csx().setFocusable(false);
            this.fhr.csx().setFocusableInTouchMode(false);
            this.yAP.setOnClickListener(new 2(this));
            this.yAP.setVisibility(8);
            this.yAN = (TextView) this.fhr.csq().findViewById(R.h.ceo);
            this.ytQ = new com.tencent.mm.ui.chatting.u(this.fhr.csq().getContext(), new au(), this.fhr.crz(), this.fhr.csv(), this.fhr.csd());
            this.ytQ.yuy = new 3(this);
            this.yAO = (ListView) this.fhr.csq().findViewById(R.h.cJr);
            this.yAO.setVisibility(0);
            this.yAO.setAdapter(this.ytQ);
            this.yAO.setOnItemClickListener(new 4(this));
            this.yAO.setOnTouchListener(new 5(this));
            if (this.fhr.csA() != null) {
                this.fhr.csA().ytQ = this.ytQ;
            }
        }
        FF(-1);
    }

    public final void ctV() {
        x.v("MicroMsg.ChattingUI.SearchImp", "exit edit search mode");
        this.yAQ = false;
        this.yAR = true;
        if (this.yAN != null) {
            this.yAN.setVisibility(8);
        }
        if (this.yAP != null) {
            this.yAP.setVisibility(8);
        }
        if (this.yAO != null) {
            this.yAO.setVisibility(8);
        }
        this.fhr.csx().setVisibility(0);
        this.fhr.csq().hideVKB();
    }

    public final void FF(int i) {
        x.v("MicroMsg.ChattingUI.SearchImp", "search result count %d, in edit mode %B, can report %B", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.yAQ), Boolean.valueOf(this.yAR)});
        if (this.yAH || this.yAQ) {
            if (this.yAR && i >= 0) {
                this.yAR = false;
                g.pQN.h(10811, new Object[]{Integer.valueOf(2)});
            }
            if (i > 0) {
                this.yAO.setVisibility(0);
                this.fhr.csx().setVisibility(8);
                this.yAN.setVisibility(8);
                this.yAP.setVisibility(8);
                return;
            } else if (i == 0) {
                this.yAO.setVisibility(8);
                this.fhr.csx().setVisibility(8);
                this.yAN.setVisibility(0);
                this.yAP.setVisibility(8);
                return;
            } else {
                this.yAO.setVisibility(8);
                this.fhr.csx().setVisibility(0);
                this.yAN.setVisibility(8);
                this.yAP.setVisibility(0);
                return;
            }
        }
        x.d("MicroMsg.ChattingUI.SearchImp", "not search now");
    }
}
