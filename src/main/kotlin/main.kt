@file:Suppress("FunctionName", "LocalVariableName")

package io.gabx.olanzapine

enum class Tag {
  SUP,
  CTR,
}

class Heap

class Position(val value: Int) {
  operator fun plus(other: Position): Position {
    return Position(value + other.value)
  }
}

class ReduceContext(
  val heap: Heap,
  val term: Pointer,
  val threadId: Int,
  val host: Pointer,
) {
  fun countReduction() {
    TODO()
  }

  fun locationOf(position: Int, term: Pointer = this.term): Pointer {
    TODO()
  }

  fun argumentAt(argument: Int, term: Pointer = this.term): Pointer {
    TODO()
  }

  fun Int.link(term: Pointer) {
    TODO()
  }
  
  fun Pointer.free(arity: Int) {
    TODO()
  }
}

val _Add_ = 0
val _Succ_ = 0

class Pointer {
  val tag: Tag get() = TODO()
  val ext: Int get() = TODO()
  val position: Position get() = TODO()
  
  fun on(number: Int): Int {
    return position + number
  }
}

object Terms {
  fun function(id: Int, term: Pointer): Pointer {
    TODO()
  }
  
  fun constructor(id: Int, term: Pointer): Pointer {
    TODO()
  }
}

fun ReduceContext.add(): Boolean {
  val arg_0 = argumentAt(0)
  val arg_1 = argumentAt(1)

  return when (arg_0.tag) {
    Tag.SUP -> {
      countReduction()
      false
    }

    Tag.CTR -> when (arg_0.ext) {
      31 -> {
        countReduction()
        val arg_0_0 = argumentAt(0, arg_0)
        val call_0 = locationOf(0)
        call_0.on(0).link(arg_0_0)
        call_0.on(1).link(arg_1)
        val constructor_1 = locationOf(1)
        constructor_1.on(0).link(Terms.function(_Add_, call_0))
        val done = Terms.constructor(_Succ_, constructor_1)
        host.on(0).link(done)
        false
      }

      32 -> {
        countReduction()
        host.on(0).link(arg_1)
        locationOf(0, arg_0).free(0)
        locationOf(1, arg_0).free(2)
        true
      }

      else -> false
    }

    else -> false
  }
}

fun main() {
}
