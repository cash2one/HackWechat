package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class h$2 implements c {
    final /* synthetic */ h nYk;

    h$2(h hVar) {
        this.nYk = hVar;
    }

    public final void a(n nVar) {
        if (this.nYk.nYA) {
            nVar.a(1, this.nYk.getString(R.l.etp), 0);
        }
        h hVar = this.nYk;
        d dVar = this.nYk.nVR;
        LocationInfo locationInfo = this.nYk.nVS;
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.tencent.map");
        arrayList.add("com.google.android.apps.maps");
        arrayList.add("com.baidu.BaiduMap");
        arrayList.add("com.autonavi.minimap");
        arrayList.add("com.sogou.map.android.maps");
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.nQx), Double.valueOf(locationInfo.nQy)})));
        PackageManager packageManager = dVar.context.getPackageManager();
        Map hashMap = new HashMap();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
            if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(dVar.context.getPackageManager()).toString());
            }
        }
        hVar.nYi = hashMap;
        if (!bh.cgC() && (this.nYk.nYj < 4 || h.b(this.nYk))) {
            nVar.ai(2, R.l.eRe, 0);
        }
        int i = 3;
        for (Entry entry : this.nYk.nYi.entrySet()) {
            if (!((String) entry.getKey()).equals("com.tencent.map")) {
                nVar.a(i, (CharSequence) entry.getValue(), 0);
            }
            i++;
        }
    }
}
