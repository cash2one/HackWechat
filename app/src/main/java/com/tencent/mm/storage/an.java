package com.tencent.mm.storage;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

public final class an {
    public static final an xyQ = new an("timeline");
    public static final an xyR = new an("album_friend");
    public static final an xyS = new an("album_self");
    public static final an xyT = new an("album_stranger");
    public static final an xyU = new an("profile_friend");
    public static final an xyV = new an("profile_stranger");
    public static final an xyW = new an(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final an xyX = new an("comment_detail");
    public static final an xyY = new an("other");
    public static final an xyZ = new an("snssight");
    public static final an xza = new an("fts");
    public String tag = "";
    public int time = 0;

    public static an ciO() {
        return new an("timeline");
    }

    public static an ciP() {
        return new an("album_friend");
    }

    public static an ciQ() {
        return new an("album_self");
    }

    public static an ciR() {
        return new an("album_stranger");
    }

    public static an ciS() {
        return new an("comment_detail");
    }

    public static an ciT() {
        return new an("snssight");
    }

    public an(String str) {
        this.tag = str;
    }

    public final an Dp(int i) {
        this.time = i;
        return this;
    }

    public static an a(an anVar, int i) {
        an anVar2 = new an(anVar.tag);
        anVar2.time = i;
        return anVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof an) {
            return ((an) obj).tag.equals(this.tag);
        }
        return super.equals(obj);
    }

    public final String toString() {
        return this.tag + "@" + this.time;
    }
}
