package com.d.a.a;

import java.util.TimeZone;

final class aa {
    static long af(long j) {
        return (((long) TimeZone.getDefault().getOffset(j)) + j) / 1000;
    }
}
