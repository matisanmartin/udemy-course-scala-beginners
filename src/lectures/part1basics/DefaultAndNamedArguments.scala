package lectures.part1basics

object DefaultAndNamedArguments extends App {

    def tailRecursiveFactorial(n: Int, acc: Int = 1): Int =
        if(n <= 1) acc
        else tailRecursiveFactorial(n-1, n*acc)

    val fact10 = tailRecursiveFactorial(10)

    def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080) : Unit = println("Saving picture")

    savePicture("jpg", 800, 600)

    //error
    //savePicture(800,600)

    //error, compiler doesn't know which parameter it is
    //savePicture(800)

    // solutions:
    /*
        1 - Pass every leading argument
        2 - name the arguments
     */

    savePicture(width = 800)

    // order can be switched
    savePicture(height = 600, width = 800, format = "bmp")

}
