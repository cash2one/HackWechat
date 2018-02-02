package com.eclipsesource.v8;

import java.io.File;

class NodeJS$2 implements JavaCallback {
    final /* synthetic */ NodeJS this$0;
    final /* synthetic */ File val$file;

    NodeJS$2(NodeJS nodeJS, File file) {
        this.this$0 = nodeJS;
        this.val$file = file;
    }

    public Object invoke(V8Object v8Object, V8Array v8Array) {
        V8Array v8Array2 = new V8Array(NodeJS.access$100(this.this$0));
        try {
            v8Array2.push(this.val$file.getAbsolutePath());
            Object call = NodeJS.access$200(this.this$0).call(null, v8Array2);
            return call;
        } finally {
            v8Array2.release();
        }
    }
}
