package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    Context context;
    private String lcH = "";
    private af mHandler = new af(Looper.getMainLooper());
    private boolean mIsInit = false;
    MMHorList nTD;
    a nTE;
    private int nTF;
    c nTG = null;

    public h(Context context, View view, String str) {
        this.context = context;
        this.nTD = (MMHorList) view;
        this.lcH = str;
        aVP();
    }

    private void aVP() {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", Integer.valueOf(l.aVv().DA(this.lcH).size()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!bh.ov(str)) {
                arrayList.add(new b(this, str));
                arrayList2.add(str);
            }
        }
        E(arrayList);
        F(arrayList2);
        this.nTD.invalidate();
        this.nTE.notifyDataSetChanged();
    }

    private void E(ArrayList<b> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nTK) {
                bVar.aVS();
            }
        }
        this.nTF = a.fromDPToPix(this.context, 60);
        this.nTD.ybK = true;
        this.nTD.ybL = this.nTF;
        this.nTD.ybJ = true;
        this.nTD.setOnItemClickListener(new 1(this));
        this.nTE = new a(this, arrayList);
        this.nTD.setAdapter(this.nTE);
    }

    private void DE(String str) {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", str);
        if (!this.nTE.DI(str)) {
            b bVar = new b(this, str);
            a aVar = this.nTE;
            aVar.nTJ.add(bVar);
            aVar.notifyDataSetChanged();
            this.nTD.invalidate();
        }
    }

    private void DF(String str) {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", str);
        if (this.nTE.DI(str)) {
            a aVar = this.nTE;
            int i = 0;
            while (i < aVar.nTJ.size()) {
                if (((b) aVar.nTJ.get(i)).username.equals(str)) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                aVar.nTJ.remove(i);
                aVar.notifyDataSetChanged();
            }
            this.nTD.invalidate();
        }
    }

    public final void DG(String str) {
        int i = 0;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", str);
        if (this.nTE.DI(str)) {
            this.nTE.DH(str).aVS();
            this.nTE.notifyDataSetChanged();
            this.nTD.invalidate();
            if (!this.nTD.oNe && !bh.ov(str)) {
                a aVar = this.nTE;
                int i2 = 0;
                while (i2 < aVar.nTJ.size()) {
                    if (((b) aVar.nTJ.get(i2)).username.equals(str)) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", Integer.valueOf(i2));
                if (i2 != -1) {
                    int i3 = i2 * this.nTF;
                    int i4 = this.nTD.ybx;
                    if (i3 >= i4) {
                        i4 = i3 > i4 + (this.nTF * 3) ? i3 - (this.nTF * 3) : 0;
                    }
                    if (i2 != 0) {
                        i = i4;
                    }
                    this.mHandler.post(new 2(this, i));
                }
            }
        }
    }

    public final void aVQ() {
        a aVar = this.nTE;
        Iterator it = aVar.nTJ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).aVT();
        }
        aVar.notifyDataSetChanged();
        this.nTD.invalidate();
    }

    public final void F(ArrayList<String> arrayList) {
        Iterator it;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList aVR = this.nTE.aVR();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (aVR.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = aVR.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()));
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                DE((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                DF((String) it.next());
            }
        }
    }
}
