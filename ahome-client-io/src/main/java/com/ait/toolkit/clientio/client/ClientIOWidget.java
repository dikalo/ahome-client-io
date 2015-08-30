/*
 * Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ait.toolkit.clientio.client;

import com.ait.toolkit.clientio.client.eventhandling.ClientIOInitHandler;
import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.flash.core.client.framework.Bridge;
import com.ait.toolkit.flash.widget.client.SwfLoadHandler;
import com.ait.toolkit.flash.widget.client.loader.SwfWidgetLoader;
import com.google.gwt.user.client.ui.Widget;

/**
 * The ClientIOWidget class is responsible of creating the GWT based SWF Widget.
 */
class ClientIOWidget {

    private static final String PATH = Util.getModuleBaseUrl() + "clientio/ClientIO.swf";
    private static final String WIDGET_PATH = Util.getModuleBaseUrl() + "clientio/ClientIOWidget.swf";
    private static final String DEFAULT_BRIDGE_NAME = "Flash4j";

    private ClientIOWidget() {}

    static Widget createIoWidget( final ClientIoWidgetCreateHandler clickHandler ) {
        String bridgeName = Util.randomString();
        Bridge.setBridgeName( bridgeName );
        final ClientIoElement fileApi = new ClientIoElement( bridgeName );
        return ClientIOWidget.create( WIDGET_PATH, bridgeName, false, new SwfLoadHandler() {
            @Override
            public void onSwfLoad() {
                clickHandler.onWidgetCreated( fileApi );
            }
        } );
    }

    static Widget createIoWidget( int width, int height, final ClientIoWidgetCreateHandler clickHandler ) {
        String bridgeName = Util.randomString();
        Bridge.setBridgeName( bridgeName );
        final ClientIoElement fileApi = new ClientIoElement( bridgeName );
        return ClientIOWidget.create( width, height, WIDGET_PATH, bridgeName, false, new SwfLoadHandler() {
            @Override
            public void onSwfLoad() {
                clickHandler.onWidgetCreated( fileApi );
            }
        } );
    }

    /**
     * Inject the ClientIOWidget as a widget. This method should be use when trying to embed the Flash widget into an existing GWT container
     * 
     * @param width
     *            , the width of the widget
     * @param height
     *            , the height of the widget
     * @param handler
     *            , the handler to be called once the flash widget was successfully loaded
     * @return, the widget to be added
     */
    static Widget create( int width, int height, SwfLoadHandler handler ) {
        return SwfWidgetLoader.initAsWidget( PATH, width, height, DEFAULT_BRIDGE_NAME, true, handler );
    }

    static Widget create( int width, int height, String path, String bridgeName, boolean transparent, SwfLoadHandler handler ) {
        return SwfWidgetLoader.initAsWidget( PATH, width, height, bridgeName, transparent, handler );
    }

    static Widget create( String path, String bridgeName, boolean transparent, SwfLoadHandler handler ) {
        return SwfWidgetLoader.initAsWidget( path, bridgeName, transparent, handler );
    }

    /**
     * Inject the ClientIOWidget as a widget. filling the entire browser window. This method should be use when trying to embed the Flash Widget into an existing GWT container.
     * 
     * @param handler
     *            ,the handler to be called once the SwfWidgetLoader framework was successfully loaded
     * @return, the SwfWidgetLoader widget to be added
     */
    static Widget create( SwfLoadHandler handler ) {
        return SwfWidgetLoader.initAsWidget( PATH, DEFAULT_BRIDGE_NAME, true, handler );
    }

    static Widget createWidget() {
        return createWidget( null );
    }

    static Widget createWidget( final ClientIOInitHandler initHandler ) {
        return create( new SwfLoadHandler() {
            @Override
            public void onSwfLoad() {
                if( initHandler != null ) {
                    initHandler.onInit();
                }
            }
        } );
    }

}
