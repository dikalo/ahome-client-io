Ahome-Client-IO
======

Ahome-Client-IO is a GWT library the helps read and write file on the client(no server required).
The library comes with a couple of nice feratures:

* Read/Write files on the client.
* Create PDF files on the client
* Create Excel on the client.

The following components are required to work with Client-IO:

* GWT 2.5 and higher
* Adobe Flash player 11+


##Getting started with Client-IO
1) Download Client-IO jar file from our open source repository and add it your classpath
* <a href="http://opensource.ahome-it.com/#ahome-client-io">Client IO  jar</a>


2) Inherit the Client-IO module

```xml
  <inherits name="com.ait.toolkit.clientio.ClientIO"/>
```
3) Initialize Client-IO as the first statement in your entry point.

```java
public class ClientIoEntryPoint implements EntryPoint { 
    @Override
    public void onLoad() {
        ClientIO.init();
	//rest of the apg goes here
		
    }
}
```
4) Below is an example how you could create a text file on the client.

```java
public class ClientIoEntryPoint implements EntryPoint { 
    @Override
    public void onLoad() {
        ClientIO.init();

		
    }
}
```



Documentation

Coming soon...

Issue Tracking

https://github.com/ahome-it/ahome-client-io/issues




##Enterprise Support
Get high quality support through Ahomé
* <a href="http://opensource.ahome-it.com/pricing/">Buy Enterprise Support</a>

##Community
* [Ahomé Google+ Community](https://plus.google.com/u/0/communities/106380618381566688303) - See whats happening in the community.

##Demos
* [Ahomé-Client-IO](http://ahome-it.github.io/ahome-client-io/)





