package org.supcom.javase;

import javax.enterprise.inject.se.SeContainer;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BootStrapEvent implements Serializable {
    private final LocalDateTime bootStamp = LocalDateTime.now();
    private final SeContainer container;

    public BootStrapEvent(SeContainer container) {
        this.container = container;
    }

    public LocalDateTime getBootStamp() {
        return bootStamp;
    }

    public SeContainer getContainer() {
        return container;
    }
}
