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
package com.ait.toolkit.clientio.client.eventhandling;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Dispatched when client io has successfully created a file
 * 
 */
public class FileCreateEvent extends GwtEvent<FileCreateHandler> {

    public static Type<FileCreateHandler> TYPE = new Type<FileCreateHandler>();
    private String fileName;

    public FileCreateEvent(String fileName) {
        this.fileName = fileName;
    }

    public FileCreateEvent() {
    }

    @Override
    public Type<FileCreateHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FileCreateHandler handler) {
        handler.onFileCreate(this);
    }

    public String getFileName() {
        return this.fileName;
    }

}