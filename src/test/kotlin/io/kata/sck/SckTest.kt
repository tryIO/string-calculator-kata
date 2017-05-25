package io.kata.sck

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SckTest {
  private var sck:Sck? = null

  @Before
  fun before() { sck = Sck() }

  @Test
  fun emptyStringToZero() {
    val computed = sck?.compute("")
    assertEquals(0, computed)
  }
}
