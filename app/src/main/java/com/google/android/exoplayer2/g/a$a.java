package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.Format;
import java.util.Comparator;

final class a$a implements Comparator<Format> {
    private a$a() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Format) obj2).bitrate - ((Format) obj).bitrate;
    }
}
