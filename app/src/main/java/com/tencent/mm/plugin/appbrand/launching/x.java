package com.tencent.mm.plugin.appbrand.launching;

import java.util.concurrent.Callable;

abstract class x<T> implements Callable<T> {
    abstract String getTag();

    x() {
    }
}
