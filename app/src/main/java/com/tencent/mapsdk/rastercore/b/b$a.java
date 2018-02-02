package com.tencent.mapsdk.rastercore.b;

public final class b$a {
    private double a = Double.MAX_VALUE;
    private double b = -1.7976931348623157E308d;
    private double c = Double.MAX_VALUE;
    private double d = -1.7976931348623157E308d;

    public final b$a a(c cVar) {
        this.a = Math.min(this.a, cVar.a());
        this.b = Math.max(this.b, cVar.a());
        this.d = Math.max(this.d, cVar.b());
        this.c = Math.min(this.c, cVar.b());
        return this;
    }
}
