package com.tencent.mm.plugin.appbrand.r.b;

import com.tencent.mm.plugin.appbrand.r.e.a;
import com.tencent.mm.plugin.appbrand.r.e.c;
import com.tencent.mm.plugin.appbrand.r.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends c {
    public final c a(a aVar, i iVar) {
        super.a(aVar, iVar);
        iVar.uL("WebSocket Protocol Handshake");
        iVar.put("Server", "Java-WebSocket");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        iVar.put("Date", simpleDateFormat.format(instance.getTime()));
        return iVar;
    }

    public final a alT() {
        return new d();
    }
}
