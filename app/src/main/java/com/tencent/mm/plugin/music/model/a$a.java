package com.tencent.mm.plugin.music.model;

public final class a$a {
    public String content;
    public boolean oJr;
    public long timestamp;

    public final String toString() {
        return String.format("[%d %s]", new Object[]{Long.valueOf(this.timestamp), this.content});
    }
}
