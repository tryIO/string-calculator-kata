package io.kata.sck

import java.lang.Integer.parseInt
import java.util.Optional.of
import java.util.stream.Stream

class Sck {
  fun add(string: String): Int = when {
    string.isBlank() -> 0

    string.startsWith("//") -> addBy(of(string.substring(2, 3))
      .map { string.substring(4, string.length).split(it) }
      .get().stream())

    string.length == 1 || string.contains(",") -> addBy(string.split(",").stream()
      .flatMap { it.split("\n").stream() })

    else -> throw RuntimeException()
  }

  private fun addBy(stream: Stream<String>): Int = stream
    .map { parseInt(it) }
    .map { when {
      it < 0 -> throw RuntimeException("Negatives numbers not allowed: $it")
      else -> it
    } }
    .filter { it < 1000 }
    .reduce(0) { v1, v2 -> v1 + v2 }
}
