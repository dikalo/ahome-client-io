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

import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.flash.widget.client.StartHandler;
import com.ait.toolkit.flash.widget.client.loader.SwfWidgetLoader;
import com.google.gwt.user.client.ui.Widget;

/**
 * The ClientIOWidget class is responsible of bootstrapping the client side file access api
 */
public class ClientIOWidget {

	private static final String PATH = Util.getModuleBaseUrl() + "clientio/ClientIO.swf";
	private static final String BRIDGE_NAME = "Flash4j";

	private ClientIOWidget() {
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
	static Widget create(int width, int height, StartHandler handler) {
		return SwfWidgetLoader.initAsWidget(PATH, width, height, BRIDGE_NAME, true, handler);
	}

	/**
	 * Inject the ClientIOWidget as a widget. filling the entire browser window. This method should be use when trying to embed the Flash Widget into an existing GWT container.
	 * 
	 * @param handler
	 *            ,the handler to be called once the SwfWidgetLoader framework was successfully loaded
	 * @return, the SwfWidgetLoader widget to be added
	 */
	static Widget create(StartHandler handler) {
		return SwfWidgetLoader.initAsWidget(PATH, BRIDGE_NAME, true, handler);
	}

	static Widget createWidget() {
		return create(new StartHandler() {
			@Override
			public void onStart() {
			}
		});
	}

}
