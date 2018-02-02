package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;

class SystemWebChromeClient$ConsoleMessageImpl implements ConsoleMessage {
    private int mLineNumber;
    private String mMessage;
    private MessageLevel mMessageLevel;
    private String mSourceId;

    SystemWebChromeClient$ConsoleMessageImpl(android.webkit.ConsoleMessage consoleMessage) {
        this.mMessageLevel = MessageLevel.valueOf(consoleMessage.messageLevel().name());
        this.mMessage = consoleMessage.message();
        this.mSourceId = consoleMessage.sourceId();
        this.mLineNumber = consoleMessage.lineNumber();
    }

    SystemWebChromeClient$ConsoleMessageImpl(String str, String str2, int i) {
        this.mMessageLevel = MessageLevel.LOG;
        this.mMessage = str;
        this.mSourceId = str2;
        this.mLineNumber = i;
    }

    public int lineNumber() {
        return this.mLineNumber;
    }

    public String message() {
        return this.mMessage;
    }

    public MessageLevel messageLevel() {
        return this.mMessageLevel;
    }

    public String sourceId() {
        return this.mSourceId;
    }
}
