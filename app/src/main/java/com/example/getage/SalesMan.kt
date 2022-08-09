package com.example.getage

class SalesMan():MyInterface{

        infix fun createPyramid(rows: Int) {
            var k = 0
            for (i in 1..rows) {
                k = 0
                for (space in 1..rows-i) {
                    print("  ")
                }
                while (k != 2*i-1) {
                    print("* ")
                    ++k
                }
                println()
            }
        }

    override fun talk() {
        println("bla bla bla")
    }
}

    fun main(args: Array<String>) {
        val p = SalesMan()
    }

