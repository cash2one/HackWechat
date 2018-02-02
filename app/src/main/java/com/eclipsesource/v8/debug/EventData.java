package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;

public class EventData implements Releasable {
    protected V8Object v8Object;

    EventData(V8Object v8Object) {
        this.v8Object = v8Object.twin();
    }

    public void release() {
        if (!this.v8Object.isReleased()) {
            this.v8Object.release();
        }
    }
}
