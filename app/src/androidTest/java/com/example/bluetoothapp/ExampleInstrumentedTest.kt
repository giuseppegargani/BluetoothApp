package com.example.bluetoothapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/* TEST INIZIALI PER VERIFICARE CHE VEDE I DEVICE E CHE SI CONNETTE E RIMANE CONNESSO

 */

/* - Codice Precedente:
    @RunWith(AndroidJUnit4::class)
class IntentInstrumentalTest {

    @get:Rule //eseguito prima di @Before
    //val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)


    //@Before
    //var mBtAdapter = BluetoothAdapter.getDefaultAdapter()
    /*fun initValidString() {
        // basic example
        //stringToBetyped = "Espresso"
        var mBtAdapter = BluetoothAdapter.getDefaultAdapter()
    }*/

    @Test //test di base per verifica funzionalita'
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.bluetoothtesting", appContext.packageName)
    }

    /*Verifica correttamente che sia attivo e se non attivo deve compiere delle cose
        Magari disabilita con un comando e verifica intent dentro activity
        Se non e' enabled l'APP richiede di abilitarla!!!! ma se attivo non lo fà
        Con espresso
        onView(withText("Consenti"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
            .perform(click())
     */
    @Test
    fun verifyBtTurnedOn(){
        var bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        assertTrue(bluetoothAdapter.isEnabled)
        bluetoothAdapter.disable()
        Thread.sleep(2000)
        bluetoothAdapter.enable()
        //assertTrue(bluetoothAdapter.isEnabled)
        //UiAutomator!!
        var myDevice = UiDevice.getInstance(getInstrumentation())
        var alertDialogButton = myDevice.findObject(UiSelector().text("OK"))
        var alertDialogButton2 = myDevice.findObject(UiSelector().text("Consenti"))
        if(alertDialogButton.exists()&&alertDialogButton.isEnabled){
            alertDialogButton.click()
        }
        if(alertDialogButton2.exists()&&alertDialogButton.isEnabled){
            alertDialogButton.click()
        }
        Thread.sleep(3000)
        assertTrue(bluetoothAdapter.isEnabled)
        /*bluetoothAdapter.disable()
        assertFalse(bluetoothAdapter.isEnabled)*/
    }

    /*DA VERIFICARE!!
     */
    @Test
    fun verifyRequestBtTurnedOn(){
        //intended(IntentMatchers.hasAction(BluetoothAdapter.ACTION_REQUEST_ENABLE))
        try {
            intended(IntentMatchers.hasAction(BluetoothAdapter.ACTION_REQUEST_ENABLE))
        } catch (e: AssertionFailedError) {
            // The intent didn't appear, so the Bluetooth is turned on or doesn't exist at all
            Log.d("risultato", "")
        }
    }

    /*che si colleghi e verifichi che c'e' una macchina con questo nome
    Prende il nome del bluetooth, lo cambia e verifica
    chiede il permesso per cambiare il nome della macchina
    https://stackoverflow.com/questions/8377558/change-the-android-bluetooth-device-name
     */


}

 */

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.bluetoothapp", appContext.packageName)
    }



}