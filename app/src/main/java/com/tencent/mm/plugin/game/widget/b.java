package com.tencent.mm.plugin.game.widget;

import java.util.LinkedList;

public final class b<E> extends LinkedList<E> {
    private a nyb;

    public b(a aVar) {
        this.nyb = aVar;
    }

    public final synchronized E pop() {
        E pop;
        pop = super.pop();
        if (this.nyb != null) {
            this.nyb.aPc();
        }
        return pop;
    }

    public final void push(E e) {
        super.push(e);
        if (this.nyb != null) {
            this.nyb.aPb();
        }
    }
}
