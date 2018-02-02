package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

class t$9 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ Map iad;
    final /* synthetic */ Map iae;
    final /* synthetic */ int[] iaf;
    final /* synthetic */ int[] iag;

    t$9(t tVar, Object obj, Map map, Map map2, int[] iArr, int[] iArr2) {
        this.hZT = tVar;
        this.iad = map;
        this.iae = map2;
        this.iaf = iArr;
        this.iag = iArr2;
        super(3000, obj);
    }

    public final Object run() {
        for (Entry entry : this.iad.entrySet()) {
            MMLogic.saveAuthLongIPs((String) entry.getKey(), (String[]) ((ArrayList) entry.getValue()).toArray(new String[0]));
        }
        for (Entry entry2 : this.iae.entrySet()) {
            MMLogic.saveAuthShortIPs((String) entry2.getKey(), (String[]) ((ArrayList) entry2.getValue()).toArray(new String[0]));
        }
        MMLogic.saveAuthPorts(this.iaf, this.iag);
        BaseEvent.onNetworkChange();
        return null;
    }
}
