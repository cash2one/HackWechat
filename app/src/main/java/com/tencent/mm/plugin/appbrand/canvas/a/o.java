package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class o implements d {
    public final String getMethod() {
        return "save";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.save();
        a aVar = fVar.iKO;
        fVar.iKQ.push(fVar.iKO);
        fVar.iKO = fVar.iKO.abo();
        if (fVar.iKO == null) {
            fVar.iKO = aVar;
        }
        aVar = fVar.iKP;
        fVar.iKR.push(fVar.iKP);
        fVar.iKP = fVar.iKP.abo();
        if (fVar.iKP == null) {
            fVar.iKP = aVar;
        }
        return true;
    }
}
