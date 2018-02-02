package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E> extends LinkedList<E> {
    private byte[] gSF = new byte[0];

    public final E aNX() {
        E poll;
        synchronized (this.gSF) {
            if (size() > 0) {
                poll = super.poll();
            } else {
                poll = null;
            }
        }
        return poll;
    }

    public final boolean bt(E e) {
        boolean contains;
        synchronized (this.gSF) {
            contains = super.contains(e);
        }
        return contains;
    }

    public final void bu(E e) {
        synchronized (this.gSF) {
            if (bt(e)) {
                super.remove(e);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        synchronized (this.gSF) {
            add = super.add(e);
        }
        return add;
    }

    public final int size() {
        int size;
        synchronized (this.gSF) {
            size = super.size();
        }
        return size;
    }
}
