package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.DragSortListView.l;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiSortUI extends EmojiBaseActivity implements e, a {
    private s lCA;
    private g lCB = new 4(this);
    private l lCC = new 5(this);
    private com.tencent.mm.plugin.emoji.a.e lCy;
    private DragSortListView lCz;
    ProgressDialog ltM;
    private ArrayList<EmojiGroupInfo> mData = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.mData = i.aBE().lwM.ckq();
        this.lCz = (DragSortListView) findViewById(16908298);
        this.lCz.zrB = this.lCB;
        this.lCz.zrC = this.lCC;
        this.lCy = new com.tencent.mm.plugin.emoji.a.e(this.mController.xIM, this.mData);
        this.lCz.setAdapter(this.lCy);
        i.aBE().lwM.c(this);
        ar.CG().a(717, this);
    }

    protected void onDestroy() {
        i.aBE().lwM.j(this);
        ar.CG().b(717, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dfH;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(getString(R.l.eLm));
        addTextOptionMenu(0, getString(R.l.dFl), new 2(this));
        ((TextView) findViewById(16908310)).setText(R.l.eaA);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (str != null && str.equals("event_update_group") && this.lCy != null) {
            com.tencent.mm.plugin.emoji.a.e eVar = this.lCy;
            ArrayList ckq = i.aBE().lwM.ckq();
            eVar.clear();
            Iterator it = ckq.iterator();
            while (it.hasNext()) {
                eVar.insert((EmojiGroupInfo) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
    }

    public final void k(Message message) {
    }

    public final void l(Message message) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.ltM != null) {
            this.ltM.dismiss();
        }
        if (i == 0 && i == 0) {
            this.lCy.aAH();
            finish();
            return;
        }
        h.a(this, getString(R.l.eag), "", new 6(this));
    }
}
