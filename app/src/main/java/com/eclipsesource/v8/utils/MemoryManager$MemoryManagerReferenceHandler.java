package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8Value;
import java.util.Iterator;

class MemoryManager$MemoryManagerReferenceHandler implements ReferenceHandler {
    final /* synthetic */ MemoryManager this$0;

    private MemoryManager$MemoryManagerReferenceHandler(MemoryManager memoryManager) {
        this.this$0 = memoryManager;
    }

    public void v8HandleCreated(V8Value v8Value) {
        MemoryManager.access$100(this.this$0).add(v8Value);
    }

    public void v8HandleDisposed(V8Value v8Value) {
        if (!MemoryManager.access$200(this.this$0)) {
            Iterator it = MemoryManager.access$100(this.this$0).iterator();
            while (it.hasNext()) {
                if (it.next() == v8Value) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
