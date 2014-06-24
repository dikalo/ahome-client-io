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

import com.ait.toolkit.flash.core.client.framework.Application;
import com.ait.toolkit.flash.core.client.framework.Bridge;
import com.ait.toolkit.flash.core.client.net.FileReference;
import com.google.gwt.core.client.JavaScriptObject;

class ClientIOSwf extends Application {

	private static final ClientIOSwf INSTANCE = new ClientIOSwf();

	protected ClientIOSwf() {
		jsObj = Bridge.get().getRoot();
	}

	ClientIOSwf(JavaScriptObject obj) {
		jsObj = obj;
	}

	/**
	 * Get the unique instance of the top most Sprite object of the underlying swf
	 * 
	 * @return
	 */
	public static ClientIOSwf get() {
		return INSTANCE;
	}

	public native void setBackgroundColor(String value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.setBackgroundColor(value);
	}-*/;

	public native void setFontColor(String value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.setTextFontColor(value);
	}-*/;

	public native void setFontSize(int value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.setTextFontSize(value);
	}-*/;

	public native void setSaveText(String value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.setSaveText(value);
	}-*/;

	native FileReference getSaveFileReference()/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = root.getSaveFileReference();
		if (obj == null) {
			return null;
		}
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

}
