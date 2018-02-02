package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

public class FTSChattingConvUI extends FTSBaseUI implements OnClickListener {
    private String mLS;
    private View qcg;
    private d qch;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g bpQ = c.bpQ();
        if (bpQ != null) {
            bpQ.aNt();
        }
    }

    protected final void initView() {
        super.initView();
        this.qcg = findViewById(R.h.cJW);
        this.qcg.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.h.cnG);
        recyclerView.a(new GridLayoutManager(this.mController.xIM, 3));
        recyclerView.a(new 1(this));
        recyclerView.a(new a(this));
    }

    protected final void bpY() {
        this.mLS = getIntent().getStringExtra("detail_username");
        x.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", new Object[]{this.mLS});
    }

    protected final b a(c cVar) {
        if (this.qch == null) {
            this.qch = new d(cVar, this.mLS);
        }
        return this.qch;
    }

    public final void a(b bVar) {
        if (s.eV(this.mLS)) {
            u.l(this.fDj, 10, 5, bVar.position + 1);
        } else {
            u.l(this.fDj, 11, 5, bVar.position + 1);
        }
    }

    protected final void bqe() {
        super.bqe();
        this.qcg.setVisibility(0);
    }

    protected final void bqc() {
        super.bqc();
        this.qcg.setVisibility(8);
    }

    protected final void bqd() {
        super.bqd();
        this.qcg.setVisibility(8);
    }

    protected final void bqb() {
        super.bqb();
        this.qcg.setVisibility(8);
    }

    private void pY(int i) {
        if (s.eV(this.mLS)) {
            ar.Hg();
            if (com.tencent.mm.z.c.Fh().hE(this.mLS).Ms() == null) {
                return;
            }
            if (i == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.Ms().size()), Integer.valueOf(1)});
                return;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.Ms().size()), Integer.valueOf(1)});
        } else if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    protected final void IU(String str) {
        int i = 1;
        super.IU(str);
        boolean eV = s.eV(this.mLS);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        if (!eV) {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        gVar.h(14569, objArr);
    }

    protected final int getLayoutId() {
        return R.i.diT;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.qch.finish();
        g bpQ = c.bpQ();
        if (bpQ != null) {
            bpQ.aNr();
        }
    }

    public void onClick(View view) {
        if (view instanceof TextView) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (!s.eV(this.mLS)) {
                intValue++;
            }
            Intent intent;
            if (intValue == 0) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
                intent = new Intent();
                intent.putExtra("frome_scene", 1);
                intent.putExtra("RoomInfo_Id", this.mLS);
                intent.putExtra("title", getResources().getString(R.l.eJf));
                d.b(this, "chatroom", ".ui.SelectMemberUI", intent);
            } else if (intValue == 1) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
                intent = new Intent();
                intent.putExtra("detail_username", this.mLS);
                d.b(this, "chatroom", ".ui.SelectDateUI", intent);
                pY(0);
            } else if (intValue == 2) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mLS);
                intent.putExtra("key_media_type", 1);
                d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
                pY(1);
            } else if (intValue == 3) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mLS);
                intent.putExtra("key_media_type", 2);
                d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 4) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mLS);
                intent.putExtra("key_media_type", 3);
                d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 5) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mLS);
                intent.putExtra("key_media_type", 4);
                d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 6) {
                x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mLS);
                intent.putExtra("key_media_type", 5);
                d.a(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            }
        }
    }
}
