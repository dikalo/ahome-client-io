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
package com.ait.toolkit.clientio.canvg.client;

import com.ait.toolkit.flash.core.client.utils.Base64Util;
import com.ait.toolkit.flash.core.client.utils.ByteArray;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Parser class for Canvas or SVG based elements. Returns the content of a
 * Canvas or SVG elements as ByteArray
 * 
 */
public class CanVgParser {

	private CanVgParser() {

	}

	public static ByteArray getFromSgvElement(Element chartElement) {
		assert chartElement != null : "Element cant be null";
		int width = chartElement.getClientWidth();
		int height = chartElement.getClientHeight();
		return getFromSgvElement(chartElement, width, height);
	}

	public static ByteArray getFromSgvElement(Element chartElement, int width,
			int height) {
		assert chartElement != null : "Element cant be null";
		String html = chartElement.getInnerHTML();
		if (html.indexOf("svg") < 0) {
			throw new RuntimeException(
					"The Element is not a valid svg element !");
		}
		CanVg canvas = new CanVg(html, width + "px", height + "px");
		String base64 = canvas.getBase64();
		RootPanel.get().remove(canvas);

		int indexOfComma = base64.indexOf(",");
		base64 = base64.substring(indexOfComma + 1);

		return Base64Util.get().decode(base64);
	}

	public static ByteArray getCanvas(Canvas element) {
		assert element != null : "Element cant be null";
		String data = element.toDataUrl();

		return Base64Util.get().decode(data);
	}
}
