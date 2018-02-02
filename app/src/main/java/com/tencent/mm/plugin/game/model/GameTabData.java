package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.plugin.game.ui.tab.GameTabWebUI;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class GameTabData implements Parcelable {
    public static final Creator<GameTabData> CREATOR = new 1();
    public LinkedHashMap<String, TabItem> nef;
    public StatusBar neg;

    public final List<TabItem> aQW() {
        List<TabItem> arrayList = new ArrayList();
        if (this.nef != null) {
            arrayList.addAll(this.nef.values());
        }
        return arrayList;
    }

    public GameTabData() {
        this.nef = new LinkedHashMap();
        this.neg = new StatusBar();
    }

    private GameTabData(Parcel parcel) {
        f(parcel);
    }

    public int describeContents() {
        return 0;
    }

    private void f(Parcel parcel) {
        int readInt = parcel.readInt();
        if (this.nef == null) {
            this.nef = new LinkedHashMap();
        }
        for (int i = 0; i < readInt; i++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.nef.put(tabItem.nei, tabItem);
            }
        }
        this.neg = (StatusBar) parcel.readParcelable(StatusBar.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.nef.size());
        for (Entry value : this.nef.entrySet()) {
            parcel.writeParcelable((Parcelable) value.getValue(), i);
        }
        parcel.writeParcelable(this.neg, i);
    }

    public static GameTabData aV(List<aq> list) {
        if (bh.cA(list)) {
            return null;
        }
        GameTabData gameTabData = new GameTabData();
        dw aQd = i.aQb().aQd();
        if (aQd != null) {
            gameTabData.neg.neh = aQd.neh;
            gameTabData.neg.color = c.parseColor(aQd.hbM);
        }
        int i = 0;
        for (aq aqVar : list) {
            if (!(aqVar == null || bh.ov(aqVar.nhg))) {
                TabItem tabItem = new TabItem();
                tabItem.nei = aqVar.nhg;
                tabItem.title = aqVar.fon;
                tabItem.nej = aqVar.nhh;
                tabItem.nek = aqVar.nhi;
                tabItem.jumpUrl = aqVar.nfg;
                tabItem.nen = aqVar.nhj;
                tabItem.neo = aqVar.nhk;
                if (tabItem.nek) {
                    tabItem.nep = GameTabHomeUI.class.getName();
                } else {
                    int i2 = i + 1;
                    i %= 3;
                    tabItem.nep = GameTabWebUI.class.getName() + (i != 0 ? String.valueOf(i) : "");
                    i = i2;
                }
                tabItem.neq = false;
                tabItem.fFj = aqVar.nhl;
                tabItem.ner = aqVar.nfP;
                tabItem.nbh = aqVar.nfK;
                gameTabData.nef.put(tabItem.nei, tabItem);
            }
        }
        return gameTabData;
    }
}
