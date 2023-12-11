import com.jpetruk.advent.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var days = arrayListOf(Day1(), Day2(), Day3());
    for (day in days) {
        for (challenge in day.challenges()) {
            println("Day: " + day::class.simpleName + " Challenge: " + challenge.toString() + " Output: " + challenge());
        }
    }
}