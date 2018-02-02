package com.google.android.gms.common.stats;

import com.google.android.gms.c.j;

public final class c$a {
    public static j<Integer> aPR = j.a("gms:common:stats:connections:level", Integer.valueOf(d.LOG_LEVEL_OFF));
    public static j<String> aPS = j.n("gms:common:stats:connections:ignored_calling_processes", "");
    public static j<String> aPT = j.n("gms:common:stats:connections:ignored_calling_services", "");
    public static j<String> aPU = j.n("gms:common:stats:connections:ignored_target_processes", "");
    public static j<String> aPV = j.n("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
    public static j<Long> aPW = j.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
}
