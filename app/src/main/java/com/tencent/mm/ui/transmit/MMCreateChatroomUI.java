package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bc.e;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.transmit.a.2;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MMCreateChatroomUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private ProgressDialog iln;
    private int scene;
    private boolean yUp;
    private jv yUq;
    private b yze = new 3(this);
    private List<String> znS;
    private boolean zob;
    a zoc;
    private b zod;
    private boolean zoe;

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, LinkedList linkedList) {
        int i = 0;
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList linkedList2 = new LinkedList();
        while (i < linkedList.size()) {
            linkedList2.add(Integer.valueOf(3));
            i++;
        }
        new q(mMCreateChatroomUI, new a(mMCreateChatroomUI) {
            final /* synthetic */ MMCreateChatroomUI zof;

            {
                this.zof = r1;
            }

            public final void el(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    static /* synthetic */ void a(MMCreateChatroomUI mMCreateChatroomUI, final LinkedList linkedList, List list) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ac.getContext().getString(R.l.dQz);
        List arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list);
        Object[] objArr = new Object[]{bh.d(ar(arrayList), string)};
        h.a(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.eiO, objArr), mMCreateChatroomUI.getString(R.l.esI), mMCreateChatroomUI.getString(R.l.eiN), mMCreateChatroomUI.getString(R.l.eiM), true, new OnClickListener(mMCreateChatroomUI) {
            final /* synthetic */ MMCreateChatroomUI zof;

            public final void onClick(DialogInterface dialogInterface, int i) {
                MMCreateChatroomUI.a(this.zof, linkedList);
            }
        }, null);
    }

    static /* synthetic */ void b(MMCreateChatroomUI mMCreateChatroomUI) {
        mMCreateChatroomUI.yUq = new jv();
        mMCreateChatroomUI.yUq.fAK.fAM = "";
        mMCreateChatroomUI.yUq.fAK.fAN = mMCreateChatroomUI.zoc.cyh();
        com.tencent.mm.sdk.b.a.xef.m(mMCreateChatroomUI.yUq);
        mMCreateChatroomUI.getString(R.l.dGO);
        mMCreateChatroomUI.iln = h.a(mMCreateChatroomUI, mMCreateChatroomUI.getString(R.l.esJ), true, new 2(mMCreateChatroomUI));
    }

    public final /* bridge */ /* synthetic */ o cwa() {
        return this.zoc;
    }

    protected final void WT() {
        super.WT();
        this.znS = getIntent().getStringArrayListExtra("query_phrase_list");
        this.zob = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
        this.scene = getIntent().getIntExtra("scene_from", 0);
    }

    protected final void initView() {
        super.initView();
        a aVar = this.zoc;
        for (String str : aVar.znS) {
            g gVar = new g();
            gVar.handler = aVar.handler;
            gVar.mLZ = aVar.phA;
            gVar.fDj = str;
            gVar.mLY = com.tencent.mm.plugin.fts.a.c.b.mMz;
            gVar.mLU = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            gVar.mLX.add("filehelper");
            gVar.mLX.add(com.tencent.mm.z.q.FS());
            com.tencent.mm.plugin.fts.a.a.a search = ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
            aVar.znT = new ArrayList();
            aVar.znT.add(search);
        }
        a(1, getString(R.l.dFU), new 1(this), p.b.xJz);
        WZ();
        b.a(jv.class.getName(), this.yze);
    }

    public final void WZ() {
        List cyh = this.zoc.cyh();
        if (cyh.size() > 0) {
            updateOptionMenuText(1, getString(R.l.dFU) + "(" + cyh.size() + ")");
            if (cyh.size() > 1) {
                enableOptionMenu(1, true);
                return;
            } else {
                enableOptionMenu(1, false);
                return;
            }
        }
        updateOptionMenuText(1, getString(R.l.dFU));
        enableOptionMenu(1, false);
    }

    protected void onDestroy() {
        this.zoc.finish();
        b.b(jv.class.getName(), this.yze);
        if (!this.zoe && this.scene == 3) {
            e.bR(false);
        }
        super.onDestroy();
    }

    protected final boolean WU() {
        return false;
    }

    protected final boolean WV() {
        return false;
    }

    protected final String WW() {
        return getString(R.l.eJp);
    }

    protected final o WX() {
        if (this.zoc == null) {
            this.zoc = new a(this, this.znS, this.scene);
        }
        return this.zoc;
    }

    protected final com.tencent.mm.ui.contact.m WY() {
        if (this.zod == null) {
            this.zod = new b(this, this.scene);
        }
        return this.zod;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        a aVar2 = this.zoc;
        String str = dVar.iVU.mLs;
        int i = aVar.position;
        if (aVar2.iiv.contains(str)) {
            a.a aVar3;
            for (int size = aVar2.znU.size() - 1; size >= 0; size--) {
                aVar3 = (a.a) aVar2.znU.get(size);
                if (i >= aVar3.mOR) {
                    break;
                }
            }
            aVar3 = null;
            if (aVar3 == null) {
                return false;
            }
            if (!str.equals(aVar3.znX)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!(aVar instanceof d)) {
            return false;
        }
        d dVar = (d) aVar;
        a aVar2 = this.zoc;
        if (aVar2.iiv.contains(dVar.iVU.mLs)) {
            return true;
        }
        return false;
    }

    private static List<String> ar(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ar.Hj()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ar.Hg();
            com.tencent.mm.l.a WO = c.EY().WO(obj2);
            if (!(WO == null || ((int) WO.gJd) == 0)) {
                obj2 = WO.AQ();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final boolean cwh() {
        return true;
    }

    public final void ja(int i) {
        n nVar = this.zoc;
        com.tencent.mm.plugin.fts.a.a.h hVar = this.zod.mLO;
        String str = this.zod.fDj;
        if (!(hVar.mMc.size() == 1 && ((j) hVar.mMc.get(0)).mLs.equals("no_result​"))) {
            a.a aVar = new a.a(nVar, (byte) 0);
            aVar.mMc = hVar.mMc;
            aVar.mMb = hVar.mMb;
            aVar.fDj = str;
            nVar.znU.add(aVar);
            int headerViewsCount = i - nVar.ySV.btG().getHeaderViewsCount();
            if (headerViewsCount >= 3) {
                hVar.mMc.add(0, (j) hVar.mMc.remove(headerViewsCount));
                i = nVar.ySV.btG().getHeaderViewsCount();
            }
            nVar.cyg();
            nVar.ySV.btG().post(new 2(nVar, (aVar.mOR + i) + 1));
        }
        cwf();
        cwg();
        aWs();
    }

    public final void oE(String str) {
        a aVar = this.zoc;
        aVar.iiv.remove(str);
        for (a.a aVar2 : aVar.znU) {
            if (str.equals(aVar2.znX)) {
                aVar2.znX = null;
            }
        }
        aVar.notifyDataSetChanged();
        WZ();
    }
}
