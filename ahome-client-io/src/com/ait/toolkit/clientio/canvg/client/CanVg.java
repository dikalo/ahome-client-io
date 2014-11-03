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

import com.ait.toolkit.core.client.IdGenerator;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class CanVg extends Composite implements IsWidget {

	private Canvas surface;
	private String elementId;
	static final String unsupportedBrowser = "Your browser does not support the HTML5 Canvas";
	private int position = -10000;
	private String html;

	public CanVg(String svgContent, String width, String height) {
		surface = Canvas.createIfSupported();
		if (surface == null) {
			Window.alert(unsupportedBrowser);
			return;
		}
		this.initWidget(surface);
		elementId = IdGenerator.generateId();
		html = svgContent;
		surface.getElement().setId(elementId);
		surface.setWidth(width);
		surface.setHeight(height);
		this.getElement().getStyle().setPosition(Position.ABSOLUTE);
		this.getElement().getStyle().setLeft(position, Unit.PX);
		this.getElement().getStyle().setRight(position, Unit.PX);
		RootPanel.get().add(this);
		createContent(elementId, html);
		getBase64();
	}

	@Override
	protected void onAttach() {
		super.onAttach();
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	public String getBase64() {
		return surface.toDataUrl();
	}

	public String getBase64(String type) {
		return surface.toDataUrl(type);
	}

	private native void createContent(String id, String svgContent)/*-{
		$wnd.canvg(id, svgContent);
	}-*/;

}
