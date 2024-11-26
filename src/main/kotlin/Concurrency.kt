import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import java.io.File
import java.lang.System.currentTimeMillis
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.random.Random

suspend fun foo() {
    println("task start")
    delay(100)
    println("task finish")
}

suspend fun main0() {
    println("task start")
    delay(100)
    println("task finish")
}

fun main1() { // main이 suspend가 아님
    val time = currentTimeMillis()

    GlobalScope.launch {
        delay(100)
        println("task 1 finished in ${currentTimeMillis() - time} ms")
    }

    GlobalScope.launch {
        delay(100)
        println("task 2 finished in ${currentTimeMillis() - time} ms")
    }

    Thread.sleep(200)
}

suspend fun main2() {
    val message = GlobalScope.async {
        delay(100)
        "abc"
    }

    val count = GlobalScope.async {
        delay(100)
        1 + 2
    }

    delay(200)

    val result = message.await().repeat(count.await())
    println(result)
}

fun main3() {
    GlobalScope.launch {
        delay(100)
        println("background tast: ${Thread.currentThread().name}")
    }

    runBlocking {
        println("primary task: ${Thread.currentThread().name}")
        delay(200)
    }
}

fun main5() {
    runBlocking {
        println("parent task start")

        launch {
            println("task a start")
            delay(2000)
            println("task a finished")
        }
        launch {
            println("task b start")
            delay(2000)
            println("task b finished")
        }
        delay(100)
        println("parent task finished")
    }
    println("shut down")
}

fun main4() {
    runBlocking {
        println("parent task start")

        coroutineScope {
            launch {
                delay(2000)
                println("task a finished")
            }
            launch {
                delay(2000)
                println("task b finished")
            }
        }
    }
    println("custom scope down")
}

fun test() {
    GlobalScope.launch {
        println("task is active: ${coroutineContext[Job.Key]!!.isActive}")
    }
}

fun main6() {
    runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
            println("job started")
        }

        delay(100)

        println("preparing to start")

        job.start()
    }
}

fun main7() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!

        launch { println("task a") }
        launch { println("task b") }

        println("${job.children.count()} children running")
    }
}

fun main8() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!
        val jobA = launch { println("this is task a") }
        val jobB = launch { println("this is task b") }

        jobA.join()
        jobB.join()

        println("${job.children.count()}")
    }
}

//suspend fun main10() {
//    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
//        var i = 1
//        while (true) {
//            println(i++)
//        }
//    }
//    delay(10000)
//    squarePrinter.cancel()
//}
//
//suspend fun main() {
//    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
//        var i = 1
//        while (isActive) {
//            println(i++)
//        }
//    }
//    delay(10000)
//    squarePrinter.cancel()
//}
//
//suspend fun main12() {
//    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
//        var i = 1
//        while (true) {
//            yield()
//            println(i++)
//        }
//    }
//    delay(10000)
//    squarePrinter.cancel()
//}


suspend fun main15() {
    println("Starting main10()")
    main10() // 무한 루프 취소되지 않는 경우 확인

    println("\nStarting main11()")
    main11() // isActive로 협력 취소되는 경우 확인

    println("\nStarting main12()")
    main12() // yield()로 협력 취소되는 경우 확인
}

suspend fun main10() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (true) { // 무조건적인 무한 루프
            println("main10: $i")
            i++
        }
    }

    delay(100) // 100ms 동안 실행
    squarePrinter.cancel() // 취소 요청
    delay(50) // 취소 후 50ms 대기 (취소 효과 관찰)
    println("main10 종료 요청 완료")
}

suspend fun main11() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (isActive) { // isActive 확인
            println("main11: $i")
            i++
        }
    }

    delay(100) // 100ms 동안 실행
    squarePrinter.cancel() // 취소 요청
    delay(50) // 취소 후 50ms 대기 (취소 효과 관찰)
    println("main11 종료 요청 완료")
}

suspend fun main12() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (true) {
            yield() // yield()를 통한 취소 신호 처리
            println("main12: $i")
            i++
        }
    }

    delay(100) // 100ms 동안 실행
    squarePrinter.cancel() // 취소 요청
    delay(50) // 취소 후 50ms 대기 (취소 효과 관찰)
    println("main12 종료 요청 완료")
}


fun main16() {
    runBlocking {
        val parentJob = launch {
            println("parent Started")

            launch {
                println("child 1 started")
                delay(500)
                println("child 1 completed")
            }

            launch {
                println("child 2 started")
                delay(500)
                println("child 2 completed")
            }
            delay(500)
            println("parent completed")
        }
        delay(100)
        parentJob.cancel()
    }
}

fun main111() {
    runBlocking {
        val asyncData = async { File("data.txt").readText() }
        try {
            val text = withTimeout(50) { asyncData.await() }
            println("data loaded: $text")
        } catch (e: Exception) {
            println("timeout")
        }
    }
}

fun main22() {
    runBlocking {
        launch(Dispatchers.Default) {
            println(Thread.currentThread().name)
        }
    }
}

fun main33() {
    val id = AtomicInteger(0)

    val executor = ScheduledThreadPoolExecutor(5) { runnable ->
        Thread(
            runnable,
            "workerThread-${id.incrementAndGet()}"
        ).also { it.isDaemon = true }
    }

    executor.asCoroutineDispatcher().use { dispatcher ->
        runBlocking {
            for (i in 1..3) {
                println(Thread.currentThread().name)
                delay(1000)
            }
        }
    }
}

fun main44() {
    newFixedThreadPoolContext(5, "WorkedThread").use { dispatcher ->
        runBlocking {
            for (i in 1..3) {
                launch(dispatcher) {
                    println(Thread.currentThread().name)
                    delay(1000)
                }
            }
        }
    }
}

fun main45() {
    runBlocking {
        launch {
            throw Exception("error in a")
            println("a done")
        }
        launch {
            delay(1000)
            println("b done")
        }
        println("root")
    }
}


val handler = CoroutineExceptionHandler { _, exception ->
    println("$exception")
}

suspend fun main46() {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("$exception")
    }
    GlobalScope.launch(handler) {
        launch {
            throw Exception("Error in task A")
            println("task a done")
        }

        launch {
            delay(1000)
            println("task b done")
        }

        println("root")
    }.join()
}

fun main47() {
    runBlocking {
        val deferredA = async {
            throw Exception("Error in task A")
            println("task a done")
        }
        val deferredB = async {
            delay(1000)
            println("task b done")
        }
        deferredA.await()
        deferredB.await()
        println("root")
    }
}

fun main27() {
    runBlocking {
        supervisorScope {
            val deferredA = async {
                throw Exception("Error in task A")
                println("task a done")
            }
            val deferredB = async {
                println("task b done")
            }
            try {
                deferredA.await()
            } catch (e: Exception) {
                println("$e")
            }
            deferredB.await()
            println("root")
        }
    }
}

fun main28() {
    runBlocking {
        val streamSize = 5
        val channel = Channel<Int>(3)

        launch {
            for (n in 1..streamSize) {
                delay(Random.nextLong(100))
                val square = n * n
                println("sending: $square")
                channel.send(square)
            }
        }

        launch {
            for (i in 1..streamSize) {
                delay(Random.nextLong(100))
                val n = channel.receive()
                println("receiving: $n")
            }
        }
    }
}

fun main29() {
    runBlocking {
        val streamSize = 5
        val channel = Channel<Int>(Channel.CONFLATED)

        launch {
            for (n in 1..streamSize) {
                delay(100)
                val square = n * n
                println("$square")
                channel.send(square)
            }
            channel.close()
        }

        launch {
            for (n in channel) {
                println("$n")
                delay(200)
            }
        }
    }
}

fun main30() {
    runBlocking {
        val streamSize = 5
        val channel = Channel<Int>(2)

        launch {
            for (n in 1..streamSize) {
                val square = n * n
                println("sending: $square")
                channel.send(square)
            }
            channel.close()
        }

        for (i in 1..3) {
            launch {
                for (n in channel) {
                    println("receiving #$i: $n")
                    delay(Random.nextLong(100))
                }
            }
        }
    }
}

fun main31() {
    runBlocking {
        val channel = produce {
            for (n in 1..5) {
                val square = n * n
                println("send $square")
                send(square)
            }
        }

        launch {
            channel.consumeEach {
                println("$it")
            }
        }
    }
}

fun main32() = runBlocking {
    val ticker = ticker(100)
    println(withTimeoutOrNull(50) { ticker.receive() })
    println(withTimeoutOrNull(60) { ticker.receive() })
    delay(250)
    println(withTimeoutOrNull(1) { ticker.receive() })
    println(withTimeoutOrNull(60) { ticker.receive() })
    println(withTimeoutOrNull(60) { ticker.receive() })
}


sealed class AccountMessage

class GetBalance(
    val amount: CompletableDeferred<Long>
) : AccountMessage()

class Deposit(val amount: Long) : AccountMessage()

class Withdraw(
    val amount: Long,
    val isPermitted: CompletableDeferred<Boolean>
) : AccountMessage()

fun CoroutineScope.accountManager(
    initialBalance: Long
) = actor<AccountMessage> {
    var balance = initialBalance

    for (message in channel) {
        when (message) {
            is GetBalance -> message.amount.complete(balance)

            is Deposit -> {
                balance += message.amount
                println("deposited ${message.amount}")
            }

            is Withdraw -> {
                val canWithdraw = balance >= message.amount
                if (canWithdraw) {
                    balance -= message.amount
                    println("withdrawn ${message.amount}")
                }
                message.isPermitted.complete(canWithdraw)
            }
        }
    }
}

private suspend fun SendChannel<AccountMessage>.deposit(
    name: String,
    amount: Long
) {
    send(Deposit(amount))
    println("$name: deposit $amount")
}

private suspend fun SendChannel<AccountMessage>.tryWithdraw(
    name: String,
    amount: Long
) {
    val status = CompletableDeferred<Boolean>().let {
        send(Withdraw(amount, it))
        if(it.await()) "OK" else "DENIED"
    }
    println("$name : withdraw $amount ($status)")
}

private suspend fun SendChannel<AccountMessage>.printBalance(
    name: String,
) {
    val balance = CompletableDeferred<Long>().let {
        send(GetBalance(it))
        it.await()
    }
    println("$name : balance is $balance")
}

fun main34() {
    runBlocking {
        val manager = accountManager(100)
        withContext(Dispatchers.Default) {
            launch {
                manager.deposit("Client #1", 50)
                manager.printBalance("Client #1")
            }

            launch {
                manager.deposit("Client #2", 100)
                manager.printBalance("Client #2")
            }
        }
        manager.tryWithdraw("Client #0", 1000)
        manager.printBalance("Client #0")
        manager.close()
    }
}

fun main35() {
    println("starting a thread ...")

    thread(name = "worker", isDaemon = true) {
        for (i in 1..5) {
            println("${Thread.currentThread().name}: $i")
            Thread.sleep(150)
        }
    }
    Thread.sleep(500)
    println("shut down ...")
}

fun main() {
   var counter = 0
   val lock = Any()

   for (i in 1..5) {
       thread(isDaemon = false) {
           synchronized(lock) {
               counter += i
               println(counter)
           }
       }
   }
}