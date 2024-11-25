import kotlinx.coroutines.*
import java.lang.System.currentTimeMillis

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

fun main() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!
        val jobA = launch { println("this is task a") }
        val jobB = launch { println("this is task b") }

        jobA.join()
        jobB.join()

        println("${job.children.count()}")
    }
}