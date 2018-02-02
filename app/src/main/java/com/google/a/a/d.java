package com.google.a.a;

import java.io.IOException;

public final class d extends IOException {
    private d(String str) {
        super(str);
    }

    static d rD() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static d rE() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static d rF() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    static d rG() {
        return new d("Protocol message contained an invalid tag (zero).");
    }

    static d rH() {
        return new d("Protocol message end-group tag did not match expected tag.");
    }

    static d rI() {
        return new d("Protocol message tag had invalid wire type.");
    }

    static d rJ() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
