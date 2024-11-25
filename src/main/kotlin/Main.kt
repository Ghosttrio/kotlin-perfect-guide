//package org.ghosttrio
//
////fun main() {
////    val size = 10
////    val test = Array(size) { it + 1 }
////    test.iterator().forEach { a -> println(a) }
////}
//
//
////fun circleArea(radius: Double): Double {
////    return PI * radius * radius
////}
////
////
////
////fun main() {
////    print("enter radius: ")
////    val radius = readln().toDouble()
////    println("ca: ${circleArea(radius)}")
////}
//
////fun main() {
//////    val readInt = readInt()
//////    val readInt1 = readInt(100)
//////    println(readInt)
//////    println(readInt1)
////    test("abc")
////}
//
////fun readInt() = readLine()!!.toInt()
//
////fun readInt() = readInt(10)
////
////fun readInt(radix: Int) = readLine()!!.toInt(radix)
//
////fun readInt(radix: Int = 10) = readln().toInt(radix)
////
////fun test(a: String = "test") {
////    println(a)
////}
//
////fun indexOf(subarray: IntArray, array: IntArray): Int {
////    outerLoop@ for (i in array.indices) {
////        for (j in subarray.indices) {
////            if (subarray[i] != array[i + j]) continue@outerLoop
////        }
////        return i
////    }
////    return -1
////}
//
////class Person {
////    var firstName: String = ""
////    var familyName: String = ""
////    var age: Int = 0
////
////    fun fullName() = "$firstName $familyName"
////
////    fun showMe() {
////        println("${fullName()}: $age")
////    }
////}
////
////fun showFullName(p: Person) = println(p.fullName())
////
////fun main() {
////    val person = Person()
////}
//
////class Person(val name: String) {
////    inner class Id(val firstName: String)
////}
////
////fun main() {
////    val person = Person("test")
////    person.Id("test")
////}
//
//
////fun main() {
////    var x = 1
////
////    class Counter() {
////        fun increment() {
////            x++
////        }
////    }
////
////    Counter().increment()
////
////    println(x) //2
////}
//
//
////val text by lazy {
////    File("data.txt").readText()
////}
////
////fun main() {
////    while (true) {
////        when (val command = readln() ?: return) {
////            "print data" -> println(text)
////            "exit" -> return
////        }
////    }
////}
//
////class Application private constructor(val name: String) {
////    object Factory {
////        fun create(args: Array<String>): Application? {
////            val name = args.firstOrNull() ?: return null
////            return Application(name)
////        }
////    }
////}
////
////fun main(args: Array<String>) {
////    val app = Application.Factory.create(args) ?: return
////}
//
////class Application private constructor(val name: String) {
////    companion object Factory {
////        fun create(args: Array<String>): Application? {
////            val name = args.firstOrNull() ?: return null
////            return Application(name)
////        }
////    }
////}
////
////fun main(args: Array<String>) {
////    val app = Application.create(args) ?: return
////}
//
////fun main() {
////    fun test(a: IntRange, b: IntRange) = object {
////        val x = a.first + b.last / 2
////        val y = b.first + a.last / 2
////    }
////
////    val mid = test(1..5, 2..6)
////
////    println("${mid.x}, ${mid.y}")
////}
//
////fun sum(numbers: IntArray): Int {
////    var result = numbers.firstOrNull() ?: throw IllegalArgumentException("empty array")
////
////    for (i in 1..numbers.lastIndex) {
////        result += numbers[i]
////    }
////    return result
////}
////
////fun main() {
////    println(sum(intArrayOf(1, 2, 3)))
////}
//
//
////fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
////    var result = numbers.firstOrNull() ?: throw IllegalArgumentException("empty")
////
////    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])
////
////    return result
////}
////
////fun sum(numbers: IntArray) = aggregate(numbers, { result, op -> result + op })
////
////fun max(numbers: IntArray) = aggregate(numbers, { result, op -> if (result > op) result else op })
////
////fun interface StringConsumer {
////    fun accept(s: String)
////}
////
////fun main() {
////    val consume = StringConsumer { s -> println(s) }
////    consume.accept("test")
////}
//
////fun test(action: () -> Unit): Long {
////    return 10
////}
////
////fun main() {
////    val result = {a: Int, b:Int -> a < b}
////}
////
////fun test1(action: (() -> Unit)?): Long {
////    return 10
////}
//
//
////fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
////    var result = numbers.firstOrNull() ?: throw IllegalArgumentException("empty")
////
////    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])
////
////    return result
////}
////
//////fun sum(numbers: IntArray) = aggregate(numbers, { result, op -> result + op })
////
////fun sum(numbers: IntArray) = aggregate(numbers, fun(result, op) = result + op)
////
////fun max(numbers: IntArray) = aggregate(numbers, { result, op -> if (result > op) result else op })
////
////
////fun check(a: String, c: (Int, Char) -> Boolean): Boolean {
////    return true
////}
////
////fun main() {
////    check("h") { _, c -> c.isLetter() }
////}
//
////fun evalAtZero(f: (Int) -> Int) = f(0)
////
////fun inc(n: Int) = n + 1
////fun dec(n: Int) = n - 1
////
////fun main() {
////    fun dec(n: Int) = n - 1
////
////    println(evalAtZero(::inc))
////    println(evalAtZero(::dec))
////
////}
//
////class Person(var name: String, var test: String) {
////}
////
////fun main() {
////    val result = Person("a", "b")
////    val getter = result::name.getter
////    val setter = result::name.setter
////
////}
//
////inline fun indexOf(numbers:IntArray, condition: (Int) -> Boolean): Int {
////    for (i in numbers.indices) {
////        if (condition(numbers[i])) return i
////    }
////    return -1
////}
////
////fun main() {
////    indexOf(intArrayOf(4, 3, 2, 1)) { it < 3 }
////}
////
////fun main() {
////    val numbers = intArrayOf(4, 3, 2, 1)
////    var index = -1
////
////    for (i in numbers.indices) {
////        if (numbers[i] < 3) {
////            index = i
////            break
////        }
////    }
////}
//
////fun String.truncate(maxLength: Int): String {
////    return if (length <= maxLength) this else substring(0, maxLength)
////}
////
////fun main() {
////    "Hello".truncate(10)
////}
////
////class Test() {
////
////}
////
////fun Test.mmm(): String {
////    return "test"
////}
//
////val IntRange.leftHalf: IntRange
////    get() = start..(start + endInclusive) / 2
////
////fun main() {
////    (1..3).leftHalf
////}
//
////fun IntRange.Companion.singletonRange(n: Int) = n..n
////
////fun main() {
////    IntRange.singletonRange(5)
////    IntRange.Companion.singletonRange(5)
////}
////
////val String.Companion.HELLO
////    get() = "Hello"
////
////class Person(val name: String) {
////    companion object
////}
////
////val Person.Companion.UNKNOWN by lazy { Person("a") }
//
////fun aggregate(numbers: IntArray, op: Int.(Int) -> Int): Int {
////    var result = numbers.firstOrNull() ?: throw IllegalArgumentException("empty")
////
////    for (i in 1..numbers.lastIndex) result = result.op(numbers[i])
////
////    return result
////}
////
////fun Int.max(other: Int) = if (this > other) this else other
////
////fun main() {
////    val numbers = intArrayOf(1, 2, 3, 4)
////    aggregate(numbers, Int::plus)
////    aggregate(numbers, Int::max)
////}
//
////class Address {
////    var zipCode: Int = 0
////    var city: String = ""
////    var street: String = ""
////    var house: String = ""
////
////    fun post(message: String): Boolean {
////        val s = "Message for {$zipCode, $city, $street, $house} : $message"
////        println(s)
////        return readLine() == "OK"
////    }
////}
//
////fun main() {
////    val isReceived = Address().run {
////        zipCode = 123456
////        city = "la"
////        street = "st1"
////        house = "12"
////        post("Hello!!")
////    }
////
////    if (!isReceived) {
////        println("message not delivered")
////    }
////}
//
////fun main() {
////    val address = run {
////        val city = readLine() ?: return
////        val street = readLine() ?: return
////        val house = readLine() ?: return
////        Address(city, street, house)
////    }
////}
//
////class Address {
////    var city: String = ""
////    var street: String = ""
////    var house: String = ""
////    fun post() {
////    }
////}
////
////fun main() {
////    Address().apply {
////        city = "a"
////        street = "B"
////        house = "c"
////    }.post()
////
////    Address().also {
////        it.city = "a"
////        it.street = "a"
////        it.house = "a"
////    }.post()
////}
//
//
////data class Person(val name: String, val test: String)
////
////
////
////fun main() {
////    val person = Person("a", "b")
////    val (name, test) = person
////    println(name)
////}
////
////
////
////@JvmInline
////value class Dollar(val amount: Int)
//
//
////class Person(
////    val name: String,
////    val test: String,
////    val age: Int
////) : Comparable<Person> {
////    override fun compareTo(other: Person): Int {
////        return name.compareTo(other.name)
////    }
////}
////
////val AGE_COMPARATOR = Comparator<Person> { p1, p2 -> p1.age.compareTo(p2.age) }
////
////val AGE_COMPARATOR2 = compareBy<Person> { it.age }
////val REVERSE_AGE_COMPARATOR = compareByDescending<Person> { it.age }
////
////
////val numbers = sequence {
////    yield(0)
////    yieldAll(listOf(1, 2, 3))
////}
//
//
//
//open class Vehicle {
//    init {
//        println("init vehicle")
//    }
//}
//
//open class Car : Vehicle() {
//    init {
//        println("init car")
//    }
//}
//
//class Truck : Car() {
//    init {
//        println("init truck")
//    }
//}
//
//fun main() {
//    Truck()
//}
//


//open class Person(val name: String, val age: Int)
//
//class Student(name: String, age: Int, val university: String) : Person(name, age)
//
//fun main() {
//    Student("test", 1, "t")
//}


//abstract class Entity(val name: String)
//
//class Person: Entity {
//    constructor(name: String) : super(name)
//
//    constructor(first:String, second: String) : super("$first $second")
//}


//abstract class Result {
//    class Success(val value: Any) : Result() {
//        fun showResult() {
//            println(value)
//        }
//    }
//
//    class Error(val message: String) : Result() {
//        fun throwException() {
//            throw Exception(message)
//        }
//    }
//}
//
//fun runComputation() : Result {
//    try {
//        val a = readLine()?.toInt() ?: return Result.Error("missing first")
//        val b = readLine()?.toInt() ?: return Result.Error("missing second")
//
//        return Result.Success(a + b)
//    } catch (e: NumberFormatException) {
//        return Result.Error(e.message ?: "invalid")
//    }
//}
//
//fun main() {
//    val message = when (val result = runComputation()) {
//        is Result.Success -> "completed: ${result.value}"
//        is Result.Error -> "error: ${result.message}"
//        else -> return
//    }
//    println(message)
//}
//

//interface PersonDate {
//    val name: String
//    val age: Int
//}
//
//open class Person(
//    override val name: String,
//    override val age: Int
//): PersonDate
//
//data class Book(val title: String, val author: PersonDate) {
//    override fun toString(): String {
//        return "Book(title='$title', author=$author)"
//    }
//}
//
//fun main() {
//    val a = Person("aa", 30)
//    val b = Book("kk", a)
//
//    println(b)
//}
//
//// 추가
//class Alias(
//    private val re: PersonDate,
//    private val ne: PersonDate
//): PersonDate {
//    override val name: String
//        get() = ne.name
//    override val age: Int
//        get() = ne.age
//}
//class TreeNode<T>(val data: T) {
//}
//
//fun <T : Number> TreeNode<T>.average(): Double {
//    return 0.0
//}

//fun <T, U: T> TreeNode<U>.toList(lis: MutableList<T>) {
//}

//inline fun <reified T> TreeNode<Any>.isInstanceOf(): Boolean =
//    data is T

//interface List<T> {
//    val size: Int
//    fun get(index: Int): T
//}
//
//class ListByArray<T>(
//    private vararg val items: T
//) : List<T> {
//    override val size: Int
//        get() = items.size
//
//    override fun get(index: Int): T = items[index]
//}
//
//fun <T> concat(list1: List<T>, list2: List<T>) = object : List<T> {
//    override val size: Int
//        get() = list1.size + list2.size
//
//    override fun get(index: Int): T {
//        return if (index < list1.size) {
//            list1.get(index)
//        } else {
//            list2.get(index - list1.size)
//        }
//    }
//}
//
//fun main() {
//    val numbers = ListByArray<Number>(1, 2.5, 3f)
//    val integers = ListByArray(10, 30, 30)
//    val result = concat(numbers, integers) // error type missmatch
//}


//typealias IntPredicate = (Int) -> Boolean
//typealias IntMap = HashMap<Int, Int>
//
//fun readFirst(filter: IntPredicate) = generateSequence {
//    readLine()?.toIntOrNull()
//}.firstOrNull(filter)
//
//sealed class Status {
//    object Success: Status()
//    class Error(val msg: String) : Status()
//}
//
//typealias StSuccess = Status.Success
//
//
//typealias MultiMap<K, V> = Map<K, Collection<V>>


//annotation class Dependency(vararg val componentClasses: KClass<*>)
//
//annotation class Component(
//    val name: String = "Core",
//    val dependency: Dependency = Dependency()
//)
//
//@Component
//class IO
//
//@Component("log", Dependency(IO::class))
//class Logger
//
//@Component(dependency = Dependency(IO::class, Logger::class))
//class Main
//
//
//fun main() {
//    val component = Main::class.annotations
//        .filterIsInstance<Component>()
//        .firstOrNull() ?: return
//
//    println("name : ${component.name}")
//
//    val deptext = component.dependency.componentClasses
//        .joinToString { it.simpleName ?: "" }
//
//    println("dependency : $deptext")
//}

//operator fun String.times(n: Int) = repeat(n)
//
//enum class Color {
//    BLACK, RED, GREEN, WHITE, CYAN, MAGENTA;
//    operator fun not() = when (this) {
//        BLACK -> WHITE
//        RED -> CYAN
//        GREEN -> MAGENTA
//        WHITE -> BLACK
//        CYAN -> RED
//        MAGENTA -> GREEN
//    }
//}
//
//fun main() {
//    !Color.RED
//}

//infix fun <T> ((T) -> Boolean).and(
//    other: (T) -> Boolean
//): (T) -> Boolean {
//    return { this(it) && other(it) }
//}
//
//
//infix fun <T> ((T) -> Boolean).or(
//    other: (T) -> Boolean
//): (T) -> Boolean {
//    return { this(it) || other(it) }
//}
//
//fun main() {
//    val a = true
//    val b = true
//
//    a and b
//    a or b
//}


interface ResultSet<out T> {
    val items: Sequence<T>
}

class From<out T>(private val source: Iterable<T>) : ResultSet<T> {
    override val items: Sequence<T>
        get() = source.asSequence()
}

class Where<out T>(
    private val from: ResultSet<T>,
    private val condition: (T) -> Boolean
) : ResultSet<T> {
    override val items: Sequence<T>
        get() = from.items.filter(condition)
}

class Select<out T, out U>(
    private val from: ResultSet<T>,
    private val output: (T) -> U
) : ResultSet<U> {
    override val items: Sequence<U>
        get() = from.items.map(output)
}

class OrderBy<out T, in K : Comparable<K>>(
    private val select: ResultSet<T>,
    private val orderKey: (T) -> K
) : ResultSet<T> {
    override val items: Sequence<T>
        get() = select.items.sortedBy(orderKey)
}

// from 뒤에 where가 올 수 있음
infix fun <T> From<T>.where(condition: (T) -> Boolean) = Where(this, condition)

infix fun <T, U> From<T>.select(output: (T) -> U) = Select(this, output)

infix fun <T, U> Where<T>.select(output: (T) -> U) = Select(this, output)

infix fun <T, K : Comparable<K>> Select<*, T>.orderBy(
    orderKey: (T) -> K
) = OrderBy(this, orderKey)

fun <T> from(source: Iterable<T>) = From(source)

fun main() {
    val nums = listOf(2, 8, 9, 1, 3, 6, 5)
    val query = from(nums) where { it > 3 } select { it * 2 } orderBy { it }
}




