package com.example.getage

class Programmer : Employee() ,MyInterface {

    override fun work() {
        print("I'm Programmer")
    }

    override fun talk() {
        print("aaaaa")
    }
}