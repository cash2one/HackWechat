package com.tencent.mm.vending.base;

public abstract class a<_Struct> extends Vending<_Struct, Class<?>, Void> {
    public abstract _Struct L(Class<?> cls);

    protected /* bridge */ /* synthetic */ void applyChangeSynchronized(Object obj) {
    }

    protected /* bridge */ /* synthetic */ Object prepareVendingDataAsynchronous() {
        return null;
    }

    public /* synthetic */ Object resolveAsynchronous(Object obj) {
        return L((Class) obj);
    }

    public void notifyVendingDataChange() {
    }

    public void notifyVendingDataChangeSynchronize() {
    }

    protected void destroyAsynchronous() {
    }
}
