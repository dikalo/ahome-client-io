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

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

class ClientIOInfoBox {

	private AbsolutePanel popup;
	private static ClientIOInfoBox INSTANCE;
	private Timer timer;
	private Widget ioWidget;
	private static final int Z_INDEX = 9000000;
	private static final int HIDE_DELAY = 3000;
	private static final String BG_COLOR = "rgba(75,75,77, 0.4)";
	private static final String MOZ_BOX_SHADOW = " 0 0 5px 2px #888";
	private static final String BOX_SHADOW = "0 0 5px 2px rgba(0, 0, 0, 0.5)";
	private static final String WEBKIT_BOX_SHADOW = " 0 0 5px 2px rgba(0, 0, 0, 0.5)";

	// private static final String BORDER_COLOR = "gray";

	public static ClientIOInfoBox get() {
		if (INSTANCE == null) {
			INSTANCE = new ClientIOInfoBox();
		}
		return INSTANCE;
	}

	private ClientIOInfoBox() {

		popup = new AbsolutePanel() {
			@Override
			protected void onUnload() {
				ClientIOInfoBox.reset();
			}
		};
		popup.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		// popup.getElement().getStyle().setBorderColor(BORDER_COLOR);
		// popup.getElement().getStyle().setBorderWidth(2, Unit.PX);
		popup.getElement().getStyle().setBackgroundColor(BG_COLOR);
		popup.getElement().getStyle().setProperty("box-shadow", BOX_SHADOW);
		popup.getElement().getStyle().setProperty("-moz-box-shadow", MOZ_BOX_SHADOW);
		popup.getElement().getStyle().setProperty("-webkit-box-shadow", WEBKIT_BOX_SHADOW);
		popup.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		popup.setPixelSize(400, 40);
		RootPanel.get().add(popup, -400, -40);
		timer = new Timer() {
			@Override
			public void run() {
				popup.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				ioWidget.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				popup.getElement().getStyle().setZIndex(0);
				popup.getElement().getStyle().setPropertyPx("left", -400);
				popup.getElement().getStyle().setPropertyPx("top", -300);
				ClientIO.reset();
			}
		};

		ioWidget = ClientIOWidget.createWidget();
		ioWidget.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		ioWidget.getElement().getStyle().setBackgroundColor(BG_COLOR);
		popup.add(ClientIOWidget.createWidget(), 0, 0);

	}

	public static void display() {
		INSTANCE.say();
	}

	public static void display(int top, int left) {
		INSTANCE.say(top, left);
	}

	public static void display(int closeDelay) {
		INSTANCE.say(closeDelay);
	}

	public static void display(int top, int left, int closeDelay) {
		INSTANCE.say(top, left, closeDelay);
	}

	private void say() {
		say(0, (Window.getClientWidth() / 2) - 200);
	}

	private void say(int top, int left) {
		popup.getElement().getStyle().setZIndex(Z_INDEX);
		popup.getElement().getStyle().setPropertyPx("top", top);
		popup.getElement().getStyle().setPropertyPx("left", left);
		popup.getElement().getStyle().setVisibility(Visibility.VISIBLE);
		ioWidget.getElement().getStyle().setVisibility(Visibility.VISIBLE);
		timer.schedule(HIDE_DELAY);
	}

	private void sayNoDelay(int top, int left) {
		popup.getElement().getStyle().setZIndex(Z_INDEX);
		popup.getElement().getStyle().setPropertyPx("top", top);
		popup.getElement().getStyle().setPropertyPx("left", left);
		popup.getElement().getStyle().setVisibility(Visibility.VISIBLE);
		ioWidget.getElement().getStyle().setVisibility(Visibility.VISIBLE);
	}

	private void say(int delay) {
		say();
		timer.schedule(delay);
	}

	private void say(int top, int left, int delay) {
		sayNoDelay(top, left);
		timer.schedule(delay);
	}

	private static void reset() {
		ClientIO.reset();
		INSTANCE = null;
	}

}
