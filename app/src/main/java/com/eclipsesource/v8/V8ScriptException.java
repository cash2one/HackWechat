package com.eclipsesource.v8;

public abstract class V8ScriptException extends V8RuntimeException {
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    V8ScriptException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        this.fileName = str;
        this.lineNumber = i;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i2;
        this.endColumn = i3;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(createMessageLine());
        stringBuilder.append(createMessageDetails());
        stringBuilder.append(createJSStackDetails());
        stringBuilder.append("\n");
        stringBuilder.append(getClass().getName());
        return stringBuilder.toString();
    }

    public String getMessage() {
        return createMessageLine();
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    private String createMessageLine() {
        return this.fileName + ":" + this.lineNumber + ": " + this.jsMessage;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace != null) {
            return "\n" + this.jsStackTrace;
        }
        return "";
    }

    private String createMessageDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(this.sourceLine == null || this.sourceLine.isEmpty())) {
            stringBuilder.append('\n');
            stringBuilder.append(this.sourceLine);
            stringBuilder.append('\n');
            if (this.startColumn >= 0) {
                stringBuilder.append(createCharSequence(this.startColumn, ' '));
                stringBuilder.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return stringBuilder.toString();
    }

    private char[] createCharSequence(int i, char c) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c;
        }
        return cArr;
    }
}
