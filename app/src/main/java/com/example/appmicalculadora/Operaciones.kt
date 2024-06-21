package com.example.appmicalculadora

class Operaciones(var num1:Float, var num2:Float) {
    //var val
    public fun suma():Float {
        return this.num1 + this.num2;
    }
    public fun resta():Float{
        return this.num1 - this.num2;
    }
    public fun multiplicar():Float{
        return this.num1 * this.num2;
    }
    public  fun dividir():Float{
        return  this.num1 / this.num2;
    }
}