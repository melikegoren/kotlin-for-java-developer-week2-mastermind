package mastermind

private val CharArray.remove: Unit
    get() {}

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)


fun evaluateGuess(secret: String, guess: String): Evaluation {

    var countRight = 0
    var countWrong = 0
    var countRight2 = 0
    var countWrong2 = 0
    var countRight3 = 0
    var countWrong3 = 0
    var secretRepeat: Int
    var guessRepeat: Int
    var b: Char

    for (b in 'A'..'F') {
        secretRepeat = repeat2(secret, b)
        guessRepeat = repeat2(guess, b)
        if (guessRepeat == secretRepeat && (guessRepeat + secretRepeat in 2..8)) {
            if (secretRepeat == 1 && guessRepeat == 1) {
                if (secret.indexOf(b) == guess.indexOf(b)) {
                    countRight++
                } else {
                    countWrong++
                }

            } else {
                for (i in 0..3) {
                    if ((secret[i] == guess[i])) {
                        if ((secret[i] == b && guess[i] == b)) {
                            countRight++
                        }

                    }
                }
                countWrong = guessRepeat - countRight

            }

        } else if (guessRepeat != secretRepeat && (guessRepeat + secretRepeat in 3..8)) {
            if (guessRepeat != 0 && secretRepeat != 0) {
                if (guessRepeat < secretRepeat) {
                    for (i in 0..3) {
                        if (secret.contains(b) && guess.contains(b)) {
                            if ((secret[i] == guess[i])) {
                                if ((secret[i] == b && guess[i] == b)) {
                                    countRight2++
                                }

                            }

                        }
                    }
                    countWrong2 = guessRepeat - countRight2

                } else if (guessRepeat > secretRepeat) {
                    for (i in 0..3) {
                        if (secret.contains(b) && guess.contains(b)) {
                            if ((secret[i] == guess[i])) {
                                if ((secret[i] == b && guess[i] == b)) {
                                    countRight2++
                                }

                            }

                        }

                    }
                    countWrong2 = secretRepeat - countRight2

                }

            }

        }

    }


    countRight3 = countRight + countRight2
    countWrong3 = countWrong + countWrong2



    return Evaluation(countRight3, countWrong3)

}

private fun repeat2(str: String, letter: Char): Int {
    var number = 0
    for (i in 0 until str.length) {
        if (str[i] == letter)
            number++
    }
    return number
}



