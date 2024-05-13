package com.example.petstore.models

class Veterinarian {
    var name:String = ""
    var age:String = ""
    var number:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, age: String, number: String, imageUrl: String, id: String) {
        this.name = name
        this.age = age
        this.number = number
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}
