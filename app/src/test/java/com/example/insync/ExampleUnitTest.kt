package com.example.insync

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

            assertEquals(true, inst.loginWithEmain("abhinavrb.a02@gmail.com", "12345"));
        }

    }


}