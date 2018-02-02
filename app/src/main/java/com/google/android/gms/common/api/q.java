package com.google.android.gms.common.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class q {
    private static final ExecutorService aLM = Executors.newFixedThreadPool(2);

    public static ExecutorService ou() {
        return aLM;
    }
}
