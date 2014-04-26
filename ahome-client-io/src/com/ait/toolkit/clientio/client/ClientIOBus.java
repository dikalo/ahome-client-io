/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.clientio.client;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 * Dispatches an event when the file has successfuly been created
 * 
 */
class ClientIOBus {

    private static final SimpleEventBus eventBus = new SimpleEventBus();

    private ClientIOBus() {

    }

    static void fireEvent(GwtEvent<?> event) {
        eventBus.fireEvent(event);
    }

    static <H extends EventHandler> HandlerRegistration addHandler(Type<H> type, H handler) {
        return eventBus.addHandler(type, handler);
    }

    static <H extends FileCreateHandler> HandlerRegistration addFileCreateHandler(H handler) {
        return addHandler(FileCreateEvent.TYPE, handler);
    }

}