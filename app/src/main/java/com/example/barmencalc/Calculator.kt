package com.example.barmencalc

class Calculator(_procent:Int,_sum:Int) {
    val procent:Int=_procent
    val sum:Int=_sum
    fun sumProcent():Double
    {
        return sum*(procent*0.01)
    }
    fun sumTotal():Double
    {
        return sum*(1+(procent*0.01))
    }
}