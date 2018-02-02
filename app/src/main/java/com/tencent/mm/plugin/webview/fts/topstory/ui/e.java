package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.ui.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class e extends BaseAdapter {
    private MMActivity fmM;
    b tog;
    ArrayList<c> tot = new ArrayList();
    boolean tou = false;
    boolean tov = false;
    private Random tow;
    boolean tox = false;
    a toy = new 1(this);

    static /* synthetic */ void a(e eVar, int i) {
        boolean z = true;
        x.i("MicroMsg.WebSearch.TopStoryVideoListAdapter", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(System.getInt(eVar.fmM.getContentResolver(), "accelerometer_rotation", 0) == 1)});
        if (!(System.getInt(eVar.fmM.getContentResolver(), "accelerometer_rotation", 0) == 1)) {
            return;
        }
        if (i == 90 || i == 270) {
            if (d.bPB().nbV) {
                d bPB = d.bPB();
                if (i == 90) {
                    z = false;
                }
                bPB.toh = z;
                d.bPB().bPC();
            } else if (g.bQd().tpZ) {
                TopStoryVideoItemView b = com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.b(eVar.tog);
                if (b != null && b.tom != null) {
                    d bPB2 = d.bPB();
                    f fVar = b.tom.tqf;
                    if (i == 90) {
                        z = false;
                    }
                    bPB2.a(fVar, z);
                    b.bPF();
                }
            }
        } else if ((i == 180 || i == 0) && d.bPB().nbV) {
            d.bPB().bPD();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return Ae(i);
    }

    public e(b bVar, ArrayList<c> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.tot = new ArrayList();
            this.tot.addAll(arrayList);
        }
        this.tog = bVar;
        this.fmM = bVar.bPx();
    }

    public final void cm(List<c> list) {
        if (list != null && list.size() > 0) {
            this.tot.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.tot.size();
    }

    private c Ae(int i) {
        return (c) this.tot.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public static boolean aeG() {
        if (!d.bPB().nbV) {
            return true;
        }
        d.bPB().bPD();
        return false;
    }

    public final int getItemViewType(int i) {
        return 1;
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new TopStoryVideoItemView(this.fmM);
            if (this.tow == null) {
                this.tow = new Random();
                this.tow.setSeed(System.currentTimeMillis());
            }
            view.id = this.tow.nextLong();
            x.i("MicroMsg.WebSearch.TopStoryVideoItemView", "setItemId: %s", new Object[]{Long.valueOf(r0)});
        } else {
            TopStoryVideoItemView topStoryVideoItemView = (TopStoryVideoItemView) view;
        }
        x.d("MicroMsg.WebSearch.TopStoryVideoListAdapter", "getView, position: %s", new Object[]{Integer.valueOf(i)});
        c Ae = Ae(i);
        view.tog = this.tog;
        view.ton = Ae;
        view.position = i;
        view.au();
        if (this.tov && i == 0 && !bh.ov(Ae.videoUrl)) {
            view.kf(this.tou);
            this.tov = false;
        }
        return view;
    }
}
