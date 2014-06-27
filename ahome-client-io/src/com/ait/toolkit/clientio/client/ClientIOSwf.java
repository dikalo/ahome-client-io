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

import java.util.Arrays;
import java.util.List;

import com.ait.toolkit.flash.core.client.framework.Application;
import com.ait.toolkit.flash.core.client.framework.Bridge;
import com.ait.toolkit.flash.core.client.net.FileFilter;
import com.ait.toolkit.flash.core.client.net.FileReference;
import com.ait.toolkit.flash.core.client.utils.ByteArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ClientIOSwf extends Application {

	private static final ClientIOSwf INSTANCE = new ClientIOSwf();
	private String bridgeName;
	private final FileFilter DEFAULT_FILE_FILTER = new FileFilter("Choose a file", "*");

	protected ClientIOSwf() {
		this("Flash4j");
	}

	protected ClientIOSwf(String bridgeName) {
		this.bridgeName = bridgeName;
		jsObj = Bridge.get(bridgeName).getRoot();
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

	public static ClientIOSwf get(String bridgeName) {
		return new ClientIOSwf(bridgeName);
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

	public native void setLabel(String value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.setSaveText(value);
	}-*/;

	private native void _saveFile(Object data, String fileName)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		root.saveFile(data, fileName);
	}-*/;

	public FileReference browse() {
		return browse(DEFAULT_FILE_FILTER);
	}

	public FileReference browse(FileFilter... fileFilter) {
		_setFilter(fromListOfFileFilter(Arrays.asList(fileFilter)));
		return getBrowseFileReference();
	}

	public FileReference browse(List<FileFilter> fileFilter) {
		_setFilter(fromListOfFileFilter(fileFilter));
		return getBrowseFileReference();
	}

	public final void saveFile(ByteArray data, String fileName) {
		_saveFile(data.getJsObj(), fileName);
	}

	public final void saveFile(String data, String fileName) {
		_saveFile(data, fileName);
	}

	public native FileReference getSaveFileReference()/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = root.getSaveFileReference();
		if (obj == null) {
			return null;
		}
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	public native FileReference getBrowseFileReference()/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var obj = root.getbrowseFileRef();
		if (!obj) {
			return null;
		}
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	private native void _setFilter(JavaScriptObject value)/*-{
		var root = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		for (var i = 0; i < value.length; i++) {
			root.pushValues(value[i]);
		}
		root.prepareBrowse();
	}-*/;

	private JavaScriptObject fromListOfFileFilter(List<FileFilter> values) {
		JsArray<JavaScriptObject> toReturn = JsArray.createArray().cast();
		int size = values.size();
		for (int i = 0; i < size; i++) {
			toReturn.push(values.get(i).getJsObj());
		}
		return toReturn;
	}

}
