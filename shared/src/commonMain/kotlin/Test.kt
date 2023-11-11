import co.touchlab.skie.configuration.annotations.FlowInterop
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun test(): String = "TEST"

fun flowTest(): Flow<Int> = flow {
    (0..5000).forEach {
        println("KOTLIN$it")
        emit(it)
        delay(500)
    }
}

suspend fun suspendTest(): String {
    delay(1000)
    return "TEST"
}

@FlowInterop.Disabled
fun flowDisableTest(): Flow<String> = flow {
    emit("TEST")
}
