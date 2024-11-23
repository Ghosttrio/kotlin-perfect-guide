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


open class Person(val name: String, val age: Int)

class Student(name: String, age: Int, val university: String) : Person(name, age)

fun main() {
    Student("test", 1, "t")
}