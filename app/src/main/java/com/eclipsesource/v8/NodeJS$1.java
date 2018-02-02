package com.eclipsesource.v8;

class NodeJS$1 implements JavaVoidCallback {
    final /* synthetic */ NodeJS val$node;

    NodeJS$1(NodeJS nodeJS) {
        this.val$node = nodeJS;
    }

    public final void invoke(V8Object v8Object, V8Array v8Array) {
        V8Function v8Function = (V8Function) v8Array.get(0);
        try {
            NodeJS.access$000(this.val$node, v8Function.twin());
        } finally {
            v8Function.release();
        }
    }
}
