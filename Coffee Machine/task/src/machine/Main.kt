package machine

const val CUPS_REQ = 1

const val ESP_WATER = 250
const val ESP_COFFEE = 16
const val ESP_COST = 4

const val LAT_WATER = 350
const val LAT_COFFEE = 20
const val LAT_MILK = 75
const val LAT_COST = 7

const val CAP_WATER = 200
const val CAP_COFFEE = 12
const val CAP_MILK = 100
const val CAP_COST = 6

class CoffeeMachine() {

    var dollars: Int = 550
    var water: Int = 400
    var milk: Int = 540
    var coffee: Int = 120
    var cups: Int = 9
    var machineState: String = "start"

    init {
        //status()
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        var choice = readln()
        var canFill = true

        when (choice) {
            "1" -> {
                if (cups < CUPS_REQ || water < ESP_WATER || coffee < ESP_COFFEE) {
                    printMissing(ESP_WATER, ESP_COFFEE)
                    canFill = false
                } else {
                    cups--
                    water -= ESP_WATER
                    coffee -= ESP_COFFEE
                    dollars += ESP_COST
                }
            }
            "2" -> {
                if (cups < CUPS_REQ || water < LAT_WATER || coffee < LAT_COFFEE || milk < LAT_MILK) {
                    printMissing(LAT_WATER, LAT_COFFEE, LAT_MILK)
                    canFill = false
                } else {
                    cups--
                    water -= LAT_WATER
                    milk -= LAT_MILK
                    coffee -= LAT_COFFEE
                    dollars += LAT_COST
                }
            }
            "3" -> {
                if (cups < CUPS_REQ || water < CAP_WATER || coffee < CAP_COFFEE || milk < CAP_MILK) {
                    printMissing(CAP_WATER, CAP_COFFEE, CAP_MILK)
                    canFill = false
                } else {
                    cups--
                    water -= CAP_WATER
                    milk -= CAP_MILK
                    coffee -= CAP_COFFEE
                    dollars += CAP_COST
                }
            }
        }
        if (canFill) {
            println("I have enough resources, making you a coffee!")
        }
        println()
    }

    fun printMissing(requiredWater: Int, requiredCoffee: Int, requiredMilk: Int = 0) {

        if(cups < 1) {
            println("Sorry, not enough cups!")
        }
        if(water < requiredWater) {
            println("Sorry, not enough water!")
        }
        if(coffee < requiredCoffee) {
            println("Sorry, not enough coffee!")
        }
        if(requiredMilk != 0 && milk < requiredMilk) {
            println("Sorry, not enough milk!")
        }
    }

    fun fill() {
        print("Write how many ml of water do you want to add:")
        water += readln().toInt()
        print("Write how many ml of milk do you want to add:")
        milk += readln().toInt()
        print("Write how many grams of coffee beans do you want to add:")
        coffee += readln().toInt()
        print("Write how many disposable cups of coffee do you want to add:")
        cups += readln().toInt()
        println()
    }

    fun take() {
        println("I gave you \$$dollars")
        println()
        dollars = 0
    }

    fun status(){
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("\$$dollars of money")
        println()
    }

    fun remaining() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("\$$dollars of money")
        println()
    }
}

fun main() {
    var goForCoffee = CoffeeMachine()
    var isExit = false

    while (!isExit) {
        print("Write action (buy, fill, take, remaining, exit): ")
        var action = readln()

        when (action) {
            "buy" -> goForCoffee.buy()
            "fill" -> goForCoffee.fill()
            "take" -> goForCoffee.take()
            "remaining" -> goForCoffee.remaining()
            "exit" -> isExit = true
        }
//        if (isExit) {
//            goForCoffee.status()
//        }
    }
}
