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

import com.ait.toolkit.flash.core.client.events.Event;
import com.ait.toolkit.flash.core.client.events.handlers.EventHandler;
import com.ait.toolkit.flash.core.client.net.FileFilter;
import com.ait.toolkit.flash.core.client.net.FileReference;
import com.ait.toolkit.flash.core.client.toplevel.Flash;
import com.ait.toolkit.flash.core.client.utils.ByteArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class ClientIO {

	static final String MESSAGE = "File was successfully created. Click HERE to save.";
	static final String BROWSE_MESSAGE = "File access successful. Click HERE to open.";
	static final String FLASH_NOT_INSTALLED = "ClientIO can't start because Flash seems not be installed !";
	static final String CLIENT_IO_NOT_INITIALIZED = "Client IO was not initialized. Make sure you call the init method before any action";
	private static boolean wasInitiated = false;
	private static EventHandler saveCompleteHandler;
	private static EventHandler ioErrorHandler;
	private static final DefaultInitCallkack initCallback = new DefaultInitCallkack();

	private ClientIO() {

	}

	public static void init() {
		init(initCallback);
	}

	public static void init(ClientIOInitCallback callback) {
		if (!Flash.isInstalled()) {
			initCallback.onInitError();
			return;
		}
		if (!wasInitiated) {
			ClientIOInfoBox.get();
			wasInitiated = true;
		}
	}

	public static final void saveFile(ByteArray data, String fileName, String message) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display();
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(ByteArray data, String fileName, String message, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display(closeDelay);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(ByteArray data, String fileName, String message, int closeDelay, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display(closeDelay, top, left);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(ByteArray data, String fileName) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display();
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}
	}

	public static final void saveFile(ByteArray data, String fileName, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display(closeDelay);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(ByteArray data, String fileName, int closeDelay, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data.getJsObj(), fileName);
			ClientIOInfoBox.display(closeDelay, top, left);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, String message) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data, fileName);
			ClientIOInfoBox.display();
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, String message, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data, fileName);
			ClientIOInfoBox.display(closeDelay);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, String message, int closeDelay, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_saveFile(data, fileName);
			ClientIOInfoBox.display(closeDelay, top, left);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data, fileName);
			ClientIOInfoBox.display();
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data, fileName);
			ClientIOInfoBox.display(top, left);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data, fileName);
			ClientIOInfoBox.display(closeDelay);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final void saveFile(String data, String fileName, int closeDelay, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(MESSAGE);
			_saveFile(data, fileName);
			ClientIOInfoBox.display(closeDelay, top, left);
			setFileSaveHandlers();
		} else {
			initCallback.onInitError();
		}

	}

	public static final FileReference browse(String message, List<FileFilter> fileFilter) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(fileFilter));
			ClientIOInfoBox.display();
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, List<FileFilter> fileFilter, int top, int left) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(fileFilter));
			ClientIOInfoBox.display(top, left);
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, List<FileFilter> fileFilter, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(fileFilter));
			ClientIOInfoBox.display(closeDelay);
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, List<FileFilter> fileFilter, int top, int left, int closeDelay) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(fileFilter));
			ClientIOInfoBox.display(top, left, closeDelay);
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(List<FileFilter> fileFilter) {
		return browse(BROWSE_MESSAGE, fileFilter);
	}

	public static final FileReference browse(List<FileFilter> fileFilter, int top, int left) {
		return browse(BROWSE_MESSAGE, fileFilter, top, left);
	}

	public static final FileReference browse(List<FileFilter> fileFilter, int closeDelay) {
		return browse(BROWSE_MESSAGE, fileFilter, closeDelay);
	}

	public static final FileReference browse(List<FileFilter> fileFilter, int top, int left, int closeDelay) {
		return browse(BROWSE_MESSAGE, fileFilter, top, left, closeDelay);
	}

	public static final FileReference browse(String message, FileFilter... fileFilter) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(Arrays.asList(fileFilter)));
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, int top, int left, FileFilter... fileFilter) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(Arrays.asList(fileFilter)));
			ClientIOInfoBox.display(top, left);
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, int closeDelay, FileFilter... fileFilter) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(Arrays.asList(fileFilter)));
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse(String message, int top, int left, int closeDelay, FileFilter... fileFilter) {
		if (wasInitiated) {
			ClientIO.setLabel(message);
			_setFilter(fromListOfFileFilter(Arrays.asList(fileFilter)));
			ClientIOInfoBox.display(top, left, closeDelay);
			return getFileReference();
		}
		initCallback.onInitError();
		return null;
	}

	public static final FileReference browse() {
		FileFilter fileFilter = new FileFilter("Open a file", "*");
		return browse(BROWSE_MESSAGE, fileFilter);
	}

	public static final FileReference browse(String message) {
		FileFilter fileFilter = new FileFilter(message, "*");
		return browse(BROWSE_MESSAGE, fileFilter);
	}

	public static final FileReference browse(FileFilter... fileFilter) {
		return browse(BROWSE_MESSAGE, fileFilter);
	}

	public static final FileReference browse(int closeDelay, FileFilter... fileFilter) {
		return browse(BROWSE_MESSAGE, closeDelay, fileFilter);
	}

	public static void setBackgroundColor(String value) {
		if (wasInitiated) {
			ClientIOSwf.get().setBackgroundColor(value);
		} else {
			initCallback.onInitError();
		}
	}

	public static void setLabel(String value) {
		if (wasInitiated) {
			ClientIOSwf.get().setSaveText(value);
		} else {
			initCallback.onInitError();
		}
	}

	public static void setFontColor(String value) {
		if (wasInitiated) {
			ClientIOSwf.get().setFontColor(value);
		} else {
			initCallback.onInitError();
		}
	}

	public static void setFontSize(int value) {
		if (wasInitiated) {
			ClientIOSwf.get().setFontSize(value);
		} else {
			initCallback.onInitError();
		}
	}

	public static void fireEvent(GwtEvent<?> event) {
		ClientIOBus.fireEvent(event);
	}

	public static <H extends FileCreateHandler> HandlerRegistration addFileCreateHandler(H handler) {
		return ClientIOBus.addFileCreateHandler(handler);
	}

	private static void setSaveCompleteHandler(EventHandler handler) {
		if (wasInitiated) {
			saveCompleteHandler = handler;
		} else {
			initCallback.onInitError();
		}
	}

	private static void setIoErrorHandler(EventHandler handler) {
		if (wasInitiated) {
			ioErrorHandler = handler;
		} else {
			initCallback.onInitError();
		}
	}

	static void setFileSaveHandlers() {
		ClientIOBus.fireEvent(new FileCreateEvent());
		FileReference fileReference = ClientIOSwf.get().getSaveFileReference();
		if (fileReference != null && saveCompleteHandler != null) {
			fileReference.addEventHandler(Event.COMPLETE, saveCompleteHandler);
		}
		if (fileReference != null && ioErrorHandler != null) {
			fileReference.addEventHandler("ioError", ioErrorHandler);
		}
	}

	static void reset() {
		// wasInitiated = false;
		_reset();
	}

	static native void _reset()/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		root.setdata(null);
	}-*/;

	private static native void _saveFile(Object data, String fileName)/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		root.saveFile(data, fileName);
	}-*/;

	private static native FileReference getFileReference()/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		var obj = root.getbrowseFileRef();
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
	}-*/;

	private static native void _setFilter(JavaScriptObject value)/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		for (var i = 0; i < value.length; i++) {
			root.pushValues(value[i]);
		}
		root.prepareBrowse();
	}-*/;

	private static JavaScriptObject fromListOfFileFilter(List<FileFilter> values) {
		JsArray<JavaScriptObject> toReturn = JsArray.createArray().cast();
		int size = values.size();
		for (int i = 0; i < size; i++) {
			toReturn.push(values.get(i).getJsObj());
		}
		return toReturn;
	}
}
