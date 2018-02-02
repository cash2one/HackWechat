package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Object;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class PropertyMirror extends Mirror {
    PropertyMirror(V8Object v8Object) {
        super(v8Object);
    }

    public String getName() {
        return this.v8Object.executeStringFunction("name", null);
    }

    public Mirror getValue() {
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(DownloadSettingTable$Columns.VALUE, null);
        try {
            Mirror createMirror = createMirror(executeObjectFunction);
            return createMirror;
        } finally {
            executeObjectFunction.release();
        }
    }

    public boolean isProperty() {
        return true;
    }
}
