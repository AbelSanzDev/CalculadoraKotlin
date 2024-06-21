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
    public fun divicion() : Float {
        if(this.num1!=0.0f && this.num2!=0.0f)
            return this.num1/num2
        else return 0.0f
    }
}