package com.tencent.mm.plugin.downloader.model;

import java.util.HashSet;

public final class a<E> extends HashSet<E> {
    private q lrE;

    public a(q qVar) {
        this.lrE = qVar;
    }

    private synchronized void azX() {
        this.lrE.azW();
    }

    private synchronized void azY() {
        this.lrE.remove();
    }

    private synchronized void azZ() {
        this.lrE.clear();
    }

    public final synchronized boolean add(E e) {
        boolean add;
        add = super.add(e);
        azX();
        return add;
    }

    public final void clear() {
        super.clear();
        azZ();
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        remove = super.remove(obj);
        azY();
        return remove;
    }
}
