//package com.example.getage
//
//import androidx.test.platform.app.InstrumentationRegistry
//import androidx.test.ext.junit.runners.AndroidJUnit4
//
//import org.junit.Test
//import org.junit.runner.RunWith
//
//import org.junit.Assert.*
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * See [testing documentation](http://d.android.com/tools/testing).
// */
//@RunWith(AndroidJUnit4::class)
//class ExampleInstrumentedTest {
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.example.getage", appContext.packageName)
//    }
//}
//
////Kotlin Class and Objects
//class door (){
//    private val ison: Boolean = false
//    fun closed(){
//        ison = false
//    }
//    fun opend(){
//        ison = true
//    }
//fun main(){
//    val d1 = door()
//    val d2 = door()
//}
//}
////Kotlin Constructors: Primary
//fun main() {
//    val person1 = Person("Adam", 20)
//}
//
//class Person(fName: String, personAge: Int) {
//    val firstName: String
//    var age: Int
//
//    // initializer block
//    init {
//        firstName = fName.capitalize()
//        age = personAge
//
//        println("First Name = $firstName")
//        println("Age = $age")
//    }
//}
////Run
//First Name = Adam
//Age = 20
//
//
////Visibility Modifiers Inside Classes and Interfaces
//open class Base() {
//    var a = 1                 // public by default
//    private var b = 2         // private to Base class
//    protected open val c = 3  // visible to the Base and the Derived class
//    internal val d = 4        // visible inside the same module
//
//    protected fun e() { }     // visible to the Base and the Derived class
//}
//
//class Derived: Base() {
//
//    // a, c, d, and e() of the Base class are visible
//    // b is not visible
//
//    override val c = 9        // c is protected
//}
//
//fun main() {
//    val base = Base()
//
//    // base.a and base.d are visible
//    // base.b, base.c and base.e() are not visible
//
//    val derived = Derived()
//    // derived.c is not visible
//}
////Kotlin Abstract Class and Method
//abstract class Person(name: String) {
//
//    init {
//        println("My name is $name.")
//    }
//
//    fun displaySSN(ssn: Int) {
//        println("My SSN is $ssn.")
//    }
//
//    abstract fun displayJob(description: String)
//}
//
//class Teacher(name: String): Person(name) {
//
//    override fun displayJob(description: String) {
//        println(description)
//    }
//}
//
//fun main(args: Array<String>) {
//    val jack = Teacher("Jack Smith")
//    jack.displayJob("I'm a mathematics teacher.")
//    jack.displaySSN(23123)
//}
////Note: Abstract classes are always open. You do not need to explicitly use open keyword to inherit subclasses from them.
//
////implement interface
//interface MyInterface {
//
//    val test: Int   // abstract property
//
//    fun foo() : String   // abstract method (returns String)
//    fun hello() {   // method with default implementation
//        // body (optional)
//    }
//}
//
//class InterfaceImp : MyInterface {
//
//    override val test: Int = 25
//    override fun foo() = "Lol"
//
//    // other code
//}
////Implementing Two or More Interfaces in a Class
//interface A {
//
//    fun callMe() {
//        println("From interface A")
//    }
//}
//
//interface B  {
//    fun callMe() {
//        println("From interface B")
//    }
//}
//
//class C: A, B {
//    override fun callMe() {
//        super<A>.callMe()
//        super<B>.callMe()
//    }
//}
//
//fun main(args: Array<String>) {
//    val obj = C()
//
//    obj.callMe()
//}
//
////Kotlin Nested Class
//class Outer {
//
//    val a = "Outside Nested class."
//
//    class Nested {
//        val b = "Inside Nested class."
//        fun callMe() = "Function call from inside Nested class."
//    }
//}
//
//fun main(args: Array<String>) {
//    // accessing member of Nested class
//    println(Outer.Nested().b)
//
//    // creating object of Nested class
//    val nested = Outer.Nested()
//    println(nested.callMe())
//}
//
////Kotlin Inner Class
//class Outer {
//    val foo = "Outside Nested class."
//
//    class Nested {
//        // Error! cannot access member of outer class.
//        fun callMe() = foo
//    }
//}
//
//fun main() {
//
//    val outer = Outer()
//    println(outer.Nested().callMe())
//}
//
////Data Class
//data class User(val name: String, val age: Int)
//fun main() {
//    val jack = User("jack", 29)
//    println("name = ${jack.name}")
//    println("age = ${jack.age}")
//}
////Copying
//data class User(val name: String, val age: Int)
//
//fun main() {
//    val u1 = User("John", 29)
//
//    // using copy function to create an object
//    val u2 = u1.copy(name = "Randy")
//
//    println("u1: name = ${u1.name}, name = ${u1.age}")
//    println("u2: name = ${u2.name}, name = ${u2.age}")
//}
//
////toString()
//data class User(val name: String, val age: Int)
//
//fun main() {
//    val u1 = User("John", 29)
//    println(u1.toString())
//}
////hashCode() and equals()
//data class User(val name: String, val age: Int)
//
//fun main() {
//    val u1 = User("John", 29)
//    val u2 = u1.copy()
//    val u3 = u1.copy(name = "Amanda")
//
//    println("u1 hashcode = ${u1.hashCode()}")
//    println("u2 hashcode = ${u2.hashCode()}")
//    println("u3 hashcode = ${u3.hashCode()}")
//
//    if (u1.equals(u2) == true)
//        println("u1 is equal to u2.")
//    else
//        println("u1 is not equal to u2.")
//
//    if (u1.equals(u3) == true)
//        println("u1 is equal to u3.")
//    else
//        println("u1 is not equal to u3.")
//}
////Destructuring Declarations
//data class User(val name: String, val age: Int, val gender: String)
//
//fun main(args: Array<String>) {
//    val u1 = User("John", 29, "Male")
//
//    val (name, age, gender) = u1
//    println("name = $name")
//    println("age = $age")
//    println("gender = $gender")
//}
////componentN()
//data class User(val name: String, val age: Int, val gender: String)
//
//fun main() {
//    val u1 = User("John", 29, "Male")
//
//    println(u1.component1())     // John
//    println(u1.component2())     // 29
//    println(u1.component3())     // "Male"
//}
//
