package com.example.insync

import android.util.Log
import com.example.insync.services.authService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun loginCheck(){
        val inst = authService();

        GlobalScope.launch {
            val uid =  "pXAmCOyFOgYipXnd3SwHf3qYdtT2"
            val email =  "test1234@gmail.com"
            val psw = "test1234"

            inst.loginWithEmain(email, psw)
            Log.d("Firebase",inst.uid)
            System.out.println(inst.uid);
            assertEquals(true, inst.done);
        }

    }

    @Test
    fun dummyChecker(){
        val inst = authService();
        assertEquals(4, inst.dummy());
    }



}