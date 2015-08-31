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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ait.toolkit.clientio.client.eventhandling.ClientIOInitHandler;
import com.ait.toolkit.clientio.client.eventhandling.ClientIoFileSaveHandler;
import com.ait.toolkit.clientio.client.eventhandling.ClientIoFileSelectHandler;
import com.ait.toolkit.clientio.client.eventhandling.DefaultClientIOInitHandler;
import com.ait.toolkit.core.client.Color;
import com.ait.toolkit.flash.core.client.events.CallbackRegistration;
import com.ait.toolkit.flash.core.client.events.Event;
import com.ait.toolkit.flash.core.client.events.IOErrorEvent;
import com.ait.toolkit.flash.core.client.events.handlers.EventHandler;
import com.ait.toolkit.flash.core.client.net.FileFilter;
import com.ait.toolkit.flash.core.client.net.FileReference;
import com.ait.toolkit.flash.core.client.toplevel.Flash;
import com.ait.toolkit.flash.core.client.utils.ByteArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Widget;

/**
 * Main I/O class. Export some Flash File API to GWT.
 * 
 * @author Alain Ekambi
 * 
 */
public class ClientIO {

    static final String MESSAGE = "File was successfully created. Click HERE to save.";
    static final String BROWSE_MESSAGE = "File access successful. Click HERE to open.";
    static final String FLASH_NOT_INSTALLED = "ClientIO can't start because Flash seems not be installed !";
    static final String CLIENT_IO_NOT_INITIALIZED = "Client IO was not initialized. Make sure you call the init method before any action";
    private static boolean wasInitiated = false;
    private static ClientIOInitHandler defaultInitHandler = new DefaultClientIOInitHandler();
    static Set<CallbackRegistration> ioCallbackRegistrations = new HashSet<CallbackRegistration>();

    private ClientIO() {

    }

    public static void init( final ClientIOInitHandler initHandler ) {
        if( !Flash.isInstalled() ) {
            initHandler.onInitError();
            return;
        }
        if( !wasInitiated ) {
            ClientIOInfoBox.get( initHandler );
            wasInitiated = true;
        }
    }

    public static void init() {
        init( defaultInitHandler );
    }

    public static Widget createIoWidget( final ClientIoWidgetCreateHandler clickHandler ) {
        return ClientIOWidget.createIoWidget( clickHandler );
    }

    public static final void saveFile( ByteArray data, String fileName, String message ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display();
        }
    }

    public static final void saveFile( ByteArray data, String fileName, String message, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display( closeDelay );
        }

    }

    public static final void saveFile( ByteArray data, String fileName, String message, int closeDelay, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display( closeDelay, top, left );
        }
    }

    public static final void saveFile( ByteArray data, String fileName ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display();
        }
    }

    public static final void saveFile( ByteArray data, String fileName, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display( closeDelay );
        }

    }

    public static final void saveFile( ByteArray data, String fileName, int closeDelay, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data.getJsObj(), fileName );
            ClientIOInfoBox.display( closeDelay, top, left );
        }

    }

    public static final void saveFile( String data, String fileName, String message ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data, fileName );
            ClientIOInfoBox.display();
        }

    }

    public static final void saveFile( String data, String fileName, String message, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data, fileName );
            ClientIOInfoBox.display( closeDelay );
        }

    }

    public static final void saveFile( String data, String fileName, String message, int closeDelay, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _saveFile( data, fileName );
            ClientIOInfoBox.display( closeDelay, top, left );
        }

    }

    public static final void saveFile( String data ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data, "fileName" );
            ClientIOInfoBox.display();
        }

    }

    public static final void saveFile( String data, String fileName ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data, fileName );
            ClientIOInfoBox.display();
        }

    }

    public static final void saveFile( String data, String fileName, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data, fileName );
            ClientIOInfoBox.display( top, left );
        }
    }

    public static final void saveFile( String data, String fileName, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data, fileName );
            ClientIOInfoBox.display( closeDelay );
        }

    }

    public static final void saveFile( String data, String fileName, int closeDelay, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( MESSAGE );
            _saveFile( data, fileName );
            ClientIOInfoBox.display( closeDelay, top, left );
        }

    }

    public static void browse( String message, List<FileFilter> fileFilter ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( fileFilter ) );
            ClientIOInfoBox.display();
        }
    }

    public static void browse( String message, List<FileFilter> fileFilter, int top, int left ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( fileFilter ) );
            ClientIOInfoBox.display( top, left );
        }
    }

    public static void browse( String message, List<FileFilter> fileFilter, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( fileFilter ) );
            ClientIOInfoBox.display( closeDelay );
        }
    }

    public static void browse( String message, List<FileFilter> fileFilter, int top, int left, int closeDelay ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( fileFilter ) );
            ClientIOInfoBox.display( top, left, closeDelay );
        }
    }

    public static void browse( List<FileFilter> fileFilter ) {
        browse( BROWSE_MESSAGE, fileFilter );
    }

    public static void browse( List<FileFilter> fileFilter, int top, int left ) {
        browse( BROWSE_MESSAGE, fileFilter, top, left );
    }

    public static void browse( List<FileFilter> fileFilter, int closeDelay ) {
        browse( BROWSE_MESSAGE, fileFilter, closeDelay );
    }

    public static void browse( List<FileFilter> fileFilter, int top, int left, int closeDelay ) {
        browse( BROWSE_MESSAGE, fileFilter, top, left, closeDelay );
    }

    public static void browse( String message, FileFilter... fileFilter ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( Arrays.asList( fileFilter ) ) );
            ClientIOInfoBox.display();
        }

    }

    public static void browse( String message, int top, int left, FileFilter... fileFilter ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( Arrays.asList( fileFilter ) ) );
            ClientIOInfoBox.display( top, left );
        }
    }

    public static void browse( String message, int closeDelay, FileFilter... fileFilter ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( Arrays.asList( fileFilter ) ) );
            ClientIOInfoBox.display();
        }
    }

    public static void browse( String message, int top, int left, int closeDelay, FileFilter... fileFilter ) {
        if( wasInitiated ) {
            ClientIO.setLabel( message );
            _setFilter( fromListOfFileFilter( Arrays.asList( fileFilter ) ) );
            ClientIOInfoBox.display( top, left, closeDelay );
        }
    }

    public static void browse() {
        browse( BROWSE_MESSAGE, new ArrayList<FileFilter>() );
    }

    public static void browse( String message ) {
        browse( message, new ArrayList<FileFilter>() );
    }

    public static void browse( FileFilter... fileFilter ) {
        browse( BROWSE_MESSAGE, fileFilter );
    }

    public static void browse( int closeDelay, FileFilter... fileFilter ) {
        browse( BROWSE_MESSAGE, closeDelay, fileFilter );
    }

    public static void setBackgroundColor( Color color ) {
        setBackgroundColor( color.getValue() );
    }

    public static void setBackgroundColor( String value ) {
        if( wasInitiated ) {
            ClientIOSwf.get().setBackgroundColor( value );
        }
    }

    public static void setLabel( String value ) {
        if( wasInitiated ) {
            ClientIOSwf.get().setLabel( value );
            ClientIOSwf.get().setFontColor( Color.WHITE.getValue() );
            ClientIOSwf.get().setFontSize( 15 );
        }
    }

    public static void setFontColor( String value ) {
        if( wasInitiated ) {
            ClientIOSwf.get().setFontColor( value );
        }
    }

    public static void setFontSize( int value ) {
        if( wasInitiated ) {
            ClientIOSwf.get().setFontSize( value );
        }
    }

    static void addCallbackRegistration( CallbackRegistration cb ) {
        ioCallbackRegistrations.add( cb );
    }

    public static void clearCallbackRegistration() {
        for( CallbackRegistration cb : ioCallbackRegistrations ) {
            cb.removeHandler();
        }
        ioCallbackRegistrations.clear();
    }

    public static void addFileSaveHandler( final ClientIoFileSaveHandler handler ) {
        final FileReference fr = getSaveFileReference();
        if( fr != null ) {
            clearCallbackRegistration();
            addCallbackRegistration( fr.addEventHandler( Event.COMPLETE, new EventHandler() {
                @Override
                public void onEvent( Event event ) {
                    handler.onFileSave( fr.getName(), fr.getType(), fr.getSize() );
                }
            } ) );
            addCallbackRegistration( fr.addEventHandler( IOErrorEvent.IO_ERROR, new EventHandler() {
                @Override
                public void onEvent( Event event ) {
                    IOErrorEvent e = IOErrorEvent.cast( event );
                    handler.onIoError( e.getText() );
                }
            } ) );
            addCallbackRegistration( fr.addEventHandler( Event.CANCEL, new EventHandler() {
                @Override
                public void onEvent( Event event ) {
                    handler.onCancel();
                }
            } ) );

        }
    }

    public static void addFileSelectHandler( final ClientIoFileSelectHandler handler ) {
        final FileReference fr = getFileReference();
        if( fr != null ) {
            clearCallbackRegistration();
            addCallbackRegistration( fr.addEventHandler( Event.SELECT, new EventHandler() {
                @Override
                public void onEvent( Event event ) {

                    addCallbackRegistration( fr.addEventHandler( Event.COMPLETE, new EventHandler() {
                        @Override
                        public void onEvent( Event event ) {
                            handler.onFileLoaded( fr.getName(), fr.getType(), fr.getData(), fr.getSize() );
                        }
                    } ) );
                    addCallbackRegistration( fr.addEventHandler( IOErrorEvent.IO_ERROR, new EventHandler() {
                        @Override
                        public void onEvent( Event event ) {
                            IOErrorEvent e = IOErrorEvent.cast( event );
                            handler.onIoError( e.getText() );
                        }
                    } ) );

                    fr.load();
                }
            } ) );
            addCallbackRegistration( fr.addEventHandler( Event.CANCEL, new EventHandler() {
                @Override
                public void onEvent( Event event ) {
                    handler.onCancel();
                }
            } ) );
        }
    }

    static void reset() {
        // wasInitiated = false;
        _reset();
    }

    static native void _reset()/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		root.clearAll();
    }-*/;

    private static native void _saveFile( Object data, String fileName )/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		root.saveFile(data, fileName);
    }-*/;

    private static native FileReference getFileReference()/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		var obj = root.getbrowseFileRef();
		if (!obj) {
			return null;
		}
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private static native FileReference getSaveFileReference()/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		var obj = root.getSaveFileReference();
		if (!obj) {
			return null;
		}
		return @com.ait.toolkit.flash.core.client.net.FileReference::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    private static native void _setFilter( JavaScriptObject value )/*-{
		var root = $wnd.FABridge["Flash4j"].root();
		for (var i = 0; i < value.length; i++) {
			root.pushValues(value[i]);
		}
		root.prepareBrowse();
    }-*/;

    private static JavaScriptObject fromListOfFileFilter( List<FileFilter> values ) {
        JsArray<JavaScriptObject> toReturn = JsArray.createArray().cast();
        int size = values.size();
        for( int i = 0; i < size; i++ ) {
            toReturn.push( values.get( i ).getJsObj() );
        }
        return toReturn;
    }
}
