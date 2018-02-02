package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.collector.d;
import org.json.JSONArray;

public interface a extends b, d {
    void a(JSONArray jSONArray, a aVar);

    void abh();

    void abi();

    void b(JSONArray jSONArray, a aVar);

    boolean d(Canvas canvas);

    int getType();

    void l(Runnable runnable);

    void qe(String str);
}
