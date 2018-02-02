package com.tencent.mm.plugin.sight.draft.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;

public class SightDraftUI extends MMActivity {
    private int qvZ = 1;
    SightDraftContainerView qwa;
    private LinkedList<String> qwb = new LinkedList();

    static /* synthetic */ void b(SightDraftUI sightDraftUI) {
        b bVar = sightDraftUI.qwa.qvT;
        j jVar = bVar.qvH == null ? null : bVar.qvH.qvP;
        if (jVar != null) {
            String nk = k.nk(jVar.field_fileName);
            if (!sightDraftUI.qwb.contains(nk)) {
                sightDraftUI.qwb.add(nk);
                String str = e.gHu + String.format("%s%d.%s", new Object[]{"wx_camera_", Long.valueOf(System.currentTimeMillis()), "mp4"});
                x.i("MicroMsg.SightDraftUI", "save src %s dest %s ", new Object[]{nk, str});
                FileOp.x(nk, str);
                d.b(str, sightDraftUI);
                u.makeText(sightDraftUI, sightDraftUI.getString(R.l.ePJ, new Object[]{e.gHu}), 1).show();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ePK);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.e.black));
        this.qwa = new SightDraftContainerView(this);
        setContentView(this.qwa);
        this.qwa.bto();
        setBackBtn(new 1(this));
        SightDraftContainerView sightDraftContainerView = this.qwa;
        a 2 = new 2(this);
        sightDraftContainerView.qvS = 2;
        if (sightDraftContainerView.qvT != null) {
            sightDraftContainerView.qvT.qvB = 2;
        }
    }
}
