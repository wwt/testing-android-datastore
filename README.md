As part of their commitment to Kotlin and providing a first-class developer experience using 
the Jetpack series of libraries, Google announced DataStore at Google I/O this year.  The *DataStore* 
library allows us to store either key-value pairs, or strongly typed objects, and is the recommended 
replacement for the legacy *SharedPreferences* Android API. According to Google,

> DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.

This repo is the companion to a WWT Platform article that focuses specifically on how to use and 
test the `Preferences` DataStore to store simple key-value pairs. If you need to store strongly 
typed, complex objects, consider using the protocol buffers-based `Proto` DataStore instead.

## Additional resources

* Google announced DataStore (in beta) at Google I/O this year - https://youtu.be/D_mVOAXcrtc?t=720

* Jetpack DataStore documentation - https://developer.android.com/topic/libraries/architecture/datastore

* Testing Android DataStore - https://www.wwt.com/article/testing-android-datastore

