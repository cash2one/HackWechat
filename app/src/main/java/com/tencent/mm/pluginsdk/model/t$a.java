package com.tencent.mm.pluginsdk.model;

public final class t$a {
    public int h;
    public int w;
    public int x;
    public int y;

    public final String toString() {
        return String.format("crop area[x=%d,y=%d,h=%d,w=%d]", new Object[]{Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.h), Integer.valueOf(this.w)});
    }
}
