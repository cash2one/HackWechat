package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.j;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.b;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.c;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.d;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FtsBrowseHistoryUI extends WebSearchBaseActivity {
    private View lWw;
    private TextView mrJ;
    private d tDG;
    private RecyclerView tDI;
    private View tDJ;
    private View tDK;
    private View tDL;
    private View tDM;
    private TextView tDN;
    private a tDO;
    private Animator tDP;

    static /* synthetic */ void a(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        ftsBrowseHistoryUI.tDL.setVisibility(8);
        kx(true);
        ftsBrowseHistoryUI.bTQ();
        ftsBrowseHistoryUI.tDM.setVisibility(0);
        ftsBrowseHistoryUI.tDN.setText(R.l.ekS);
        ftsBrowseHistoryUI.tDP.start();
    }

    static /* synthetic */ void a(FtsBrowseHistoryUI ftsBrowseHistoryUI, c cVar) {
        Intent intent = new Intent();
        x.i("FtsBrowseHistoryUI", "open url %s ,title %s", cVar.url, cVar.title);
        intent.putExtra("rawUrl", r1);
        intent.putExtra("useJs", true);
        intent.putExtra(DownloadSettingTable$Columns.TYPE, -255);
        intent.putExtra("geta8key_scene", 50);
        com.tencent.mm.bm.d.b(ftsBrowseHistoryUI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
        g.pQN.h(14963, Integer.valueOf(2));
    }

    static /* synthetic */ void b(FtsBrowseHistoryUI ftsBrowseHistoryUI, c cVar) {
        String string = ftsBrowseHistoryUI.getString(R.l.dEw);
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        h.a(ftsBrowseHistoryUI, "", (String[]) arrayList.toArray(new String[0]), null, new 5(ftsBrowseHistoryUI, cVar));
    }

    static /* synthetic */ void c(FtsBrowseHistoryUI ftsBrowseHistoryUI, c cVar) {
        RecyclerView.a aVar = ftsBrowseHistoryUI.tDO;
        aVar.hiv.remove(cVar);
        aVar.UR.notifyChanged();
        ftsBrowseHistoryUI.bTR();
        ftsBrowseHistoryUI.tDG.c(cVar);
        g.pQN.h(14963, Integer.valueOf(3));
    }

    static /* synthetic */ void cr(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(((c) it.next()).title)) {
                it.remove();
            }
        }
    }

    static /* synthetic */ void e(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        ftsBrowseHistoryUI.removeOptionMenu(0);
        ftsBrowseHistoryUI.tDK.setVisibility(0);
        ftsBrowseHistoryUI.tDL.setVisibility(0);
        ftsBrowseHistoryUI.mrJ.setVisibility(8);
        ftsBrowseHistoryUI.lWw.setVisibility(8);
        ftsBrowseHistoryUI.tDG.bUc();
        kx(false);
        ftsBrowseHistoryUI.tDM.setVisibility(0);
        ftsBrowseHistoryUI.tDN.setText(R.l.ekR);
        ftsBrowseHistoryUI.tDP.start();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tDG = new b();
        this.tDJ = findViewById(R.h.cts);
        this.mrJ = (TextView) findViewById(R.h.ceu);
        this.lWw = findViewById(R.h.content);
        this.tDK = findViewById(R.h.cPS);
        this.tDM = findViewById(R.h.cPT);
        this.tDN = (TextView) findViewById(R.h.cPU);
        this.tDL = findViewById(R.h.cPQ);
        this.tDI = (RecyclerView) findViewById(R.h.bYP);
        this.tDO = new a();
        this.tDI.a(this.tDO);
        this.tDI.a(new LinearLayoutManager());
        this.tDO.tES = new 1(this);
        setMMTitle(R.l.ekn);
        this.tDL.setOnClickListener(new 2(this));
        this.tDP = AnimatorInflater.loadAnimator(this, R.b.bqK);
        this.tDP.setTarget(this.tDM);
        bTQ();
        g.pQN.h(14963, Integer.valueOf(1));
        if (j.Rc().Rd()) {
            this.tDJ.setVisibility(0);
            this.mrJ.setVisibility(8);
            this.lWw.setVisibility(8);
            ar.Dm().F(new 4(this));
            return;
        }
        this.tDJ.setVisibility(8);
        this.tDK.setVisibility(0);
        this.lWw.setVisibility(8);
        this.mrJ.setVisibility(8);
    }

    private void bTQ() {
        if (j.Rc().Rd()) {
            addIconOptionMenu(0, R.k.duW, new 3(this));
        }
    }

    private static void kx(boolean z) {
        j Rc = j.Rc();
        if (z) {
            Rc.hLa |= HardCoderJNI.ACTION_NET_RX;
        } else {
            Rc.hLa &= -131073;
        }
        int i = z ? 1 : 2;
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(147457, Long.valueOf(Rc.hLa));
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = 47;
            wlVar.wgM = i;
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new e.a(23, wlVar));
        }
    }

    private void bTR() {
        this.tDJ.setVisibility(8);
        if (this.tDO.bUa() == 0) {
            this.mrJ.setVisibility(0);
        } else {
            this.lWw.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.diN;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == 1) {
                    this.tDO.ahw();
                    bTR();
                    return;
                }
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }
}
